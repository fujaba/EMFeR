package emfer.examples.ferryman;

import static org.junit.Assert.*;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;

import emfer.EMFeR;
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
            .withTrafo("load goat", root -> getCargos(root), (root, cargo) -> loadCargo(root, cargo))
            .withTrafo("move boat", root -> moveBoat(root))
            .withStart(river)
            .withStatic(wolf, goat, cabbage)
            ;
      
      emfer.explore();
      
      
      story.dumpHtml();
   }

   private void moveBoat(EObject root)
   {
      River river = (River) root;
      
      Boat boat = river.getBoat();
      
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
