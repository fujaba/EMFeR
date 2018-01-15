package emfer.examples.ferryman;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.junit.Assert;
import org.junit.Test;

import emfer.EMFeR;
import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;
import emfer.stories.Storyboard;

public class FerryMansProblem
{
   @Test
   public void testFerryMansProblem() throws Exception
   {
      Storyboard story = new Storyboard("FerryMansProblem");
      
      FerrymanFactory factory = FerrymanFactory.eINSTANCE;
      
      River river = factory.createRiver();
      Bank left = factory.createBank();
      left.setName("left");
      
      Bank right = factory.createBank();
      right.setName("right");
      
      Boat boat = factory.createBoat();
      
      Cargo wolf = factory.createCargo();
      wolf.setName("wolf");
      
      Cargo goat = factory.createCargo();
      goat.setName("goat");
      
      Cargo cabbage = factory.createCargo();
      cabbage.setName("cabbage");

      river.getBanks().add(left);
      river.getBanks().add(right);
      river.setBoat(boat);
      
      left.getCargos().add(wolf);
      left.getCargos().add(goat);
      left.getCargos().add(cabbage);
      
      boat.setAt(left);
      
      Logger.getGlobal().info(river.toString());
      
      EMFeR emfer = new EMFeR()
            .withEPackage(FerrymanPackage.eINSTANCE)
            .withTrafo("load cargo", root -> getCargos(root), (root, cargo) -> loadCargo(root, cargo))
            .withTrafo("move boat", root -> moveBoat(root))
            .withStart(river)
            .withStatic(wolf, goat, cabbage)
            ;
      
      
      int size = emfer.explore();

      emfer.computeDistancesTo(s -> isFinalState(s));
      
      ArrayList<TrafoApplication> shortestPath = emfer.shortestPath(emfer.getReachabilityGraph().getStates().get(0));

      StringBuilder buf = new StringBuilder("\nShortest path: \n\n");
      
      buf.append(shortestPath.get(0).getSrc());
      
      for (TrafoApplication t : shortestPath)
      {
         buf.append(t).append("\n").append(t.getTgt());
      }

      Logger.getGlobal().info(buf.toString());
      
      
      Assert.assertEquals("Number of states:", 26, size);
      
      Logger.getGlobal().info("\nFull reachability graph: \n");

      for (ReachableState s : emfer.getReachabilityGraph().getStates())
      {
         buf = new StringBuilder("\n");
         
         for (TrafoApplication t : s.getResultOf())
         {
            ReachableState src = t.getSrc();
            
            buf.append(src.getNumber()).append(" --").append(t.getDescription()).append("-> ").append(s.getNumber()).append("\n");
         }
         
         buf.append(s.toString());
         
         for (TrafoApplication t : s.getTrafoApplications())
         {
            ReachableState tgt = t.getTgt();
            
            buf.append(s.getNumber()).append(" --").append(t.getDescription()).append("-> ").append(tgt.getNumber()).append("\n");
         }
         
         Logger.getGlobal().info(buf.toString());
      }
      
      
      // is there a solution state? 
      FerryManReachabilityQuery xtend = new FerryManReachabilityQuery();
      
      ReachableState xtendFinal = xtend.findFinal(emfer.getReachabilityGraph());

      Logger.getGlobal().info("\nxtend: \n" + xtendFinal.toString());
      
      Stream<ReachableState> rootStream = emfer.getReachabilityGraph().getStates().stream().filter(s -> isFinalState(s));
      
      Optional<ReachableState> finalState = rootStream.findFirst();
      
      Logger.getGlobal().info("\njava streams: \n" + finalState.toString());
      
      story.addReachabilityGraph(emfer.getReachabilityGraph());
      
      story.dumpHtml();
   }

   private boolean isFinalState(ReachableState s)
   {
      EObject root = s.getRoot();
      
      River river = (River) root;
      
      Optional<Bank> bank = river.getBanks().stream().filter(b -> b.getName().equals("right") && b.getCargos().size() == 3).findFirst();
      
      return bank.isPresent();
      
   }

   private void moveBoat(EObject root)
   {
      River river = (River) root;
      
      Boat boat = river.getBoat();
      
      Bank bank = boat.getAt();
      
      if (bank.getCargos().size() >= 2)
      {
         for (Cargo c : bank.getCargos())
         {
            if (c.getName().equals("goat"))
            {
               // do not leave the goat and some other cargo alone
               return;
            }
         }
      }
      
      Bank otherBank = null;
      
      for (Bank b : river.getBanks())
      {
         if (boat.getAt() != b)
         {
            otherBank = b;
            break;
         }
      }
      
      boat.setAt(otherBank);
      
      Cargo cargo = boat.getCargo();
      if (cargo != null)
      {
         boat.setCargo(null);
         otherBank.getCargos().add(cargo);
      }
      
      return;
   }

   private void loadCargo(EObject root, EObject handle)
   {
      if ( ! (root instanceof River) || ! (handle instanceof Cargo))
      {
         return;
      }
      
      River river = (River) root;
      Cargo cargo = (Cargo) handle;
      
      Bank bank = null;
      
      for (Bank b : river.getBanks())
      {
         if (b.getCargos().contains(cargo))
         {
            bank = b;
            break;
         }
      }
      
      if (bank == null)
      {
         return;
      }
      
      Boat boat = river.getBoat();
      
      if (boat == null || boat.getAt() != bank || boat.getCargo() != null)
      {
         return;
      }
      
      if (bank.getCargos().size() == 3 && ! cargo.getName().equals("goat"))
      {
         return;
      }
      
      // load it
      bank.getCargos().remove(cargo);
      boat.setCargo(cargo);
      
      return;
   }

   private Set<EObject> getCargos(EObject root)
   {
      Set<EObject> cargos = new LinkedHashSet<EObject>();

      if (root instanceof River)
      {
         River river = (River) root;
         
         for (Bank b : river.getBanks())
         {
            cargos.addAll(b.getCargos());
         }
      }

      return cargos;
   }
}
