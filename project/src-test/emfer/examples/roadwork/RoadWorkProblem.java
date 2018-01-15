package emfer.examples.roadwork;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.junit.Assert;
import org.junit.Test;

import emfer.AlwaysFinally;
import emfer.AlwaysGlobally;
import emfer.AlwaysNext;
import emfer.AlwaysUntil;
import emfer.EMFeR;
import emfer.ExistsFinally;
import emfer.ExistsGlobally;
import emfer.ExistsNext;
import emfer.ExistsUntil;
import emfer.examples.ferryman.FerrymanPackage;
import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;
import emfer.stories.Storyboard;

public class RoadWorkProblem
{
   @Test
   public void testRoadWorkProblem() throws Exception
   {
      Storyboard story = new Storyboard("RoadWorkProblem");
      
      RoadworkFactory factory = RoadworkFactory.eINSTANCE;
      
      RoadMap roadMap = factory.createRoadMap();
      
      Road road = factory.createRoad();
      
      roadMap.setRoad(road);
      
      Track north1 = factory.createTrack();
      Track north2 = factory.createTrack();
      Track north3 = factory.createTrack();
      Track north4 = factory.createTrack();
      Track north5 = factory.createTrack();
      Track north6 = factory.createTrack();
      Track north7 = factory.createTrack();
                      
      Track south1 = factory.createTrack();
      Track south2 = factory.createTrack();
      Track south6 = factory.createTrack();
      Track south7 = factory.createTrack();

      north1.getWest().add(north2);
      north2.getWest().add(north3);
      north3.getWest().add(north4);
      north4.getWest().add(north5);
      north5.getWest().add(north6);
      north6.getWest().add(north7);
      north7.getWest().add(north1);
      
      north1.setTravelDirection(TravelDirection.WEST);
      north2.setTravelDirection(TravelDirection.WEST);
      north3.setTravelDirection(TravelDirection.UNDEFINED);
      north4.setTravelDirection(TravelDirection.UNDEFINED);
      north5.setTravelDirection(TravelDirection.UNDEFINED);
      north6.setTravelDirection(TravelDirection.WEST);
      north7.setTravelDirection(TravelDirection.WEST);

      north1.setName("n1");
      north2.setName("n2");
      north3.setName("n3");
      north4.setName("n4");
      north5.setName("n5");
      north6.setName("n6");
      north7.setName("n7");
      
      
      south1.getEast().add(south2);
      south2.getEast().add(north5);
      north3.getEast().add(south6);
      south6.getEast().add(south7);
      south7.getEast().add(south1);

      south1.setTravelDirection(TravelDirection.EAST);
      south2.setTravelDirection(TravelDirection.EAST);
      south6.setTravelDirection(TravelDirection.EAST);
      south7.setTravelDirection(TravelDirection.EAST);
      
      south1.setName("s1");
      south2.setName("s2");
      south6.setName("s6");
      south7.setName("s7");
      
      Signal westernSignal = factory.createSignal();
      Signal easternSignal = factory.createSignal();

      westernSignal.setTrack(south2);
      easternSignal.setTrack(north2);

      westernSignal.setPass(false);
      easternSignal.setPass(true); 

      road.getTracks().add(north1);
      road.getTracks().add(north2);
      road.getTracks().add(north3);
      road.getTracks().add(north4);
      road.getTracks().add(north5);
      road.getTracks().add(north6);
      road.getTracks().add(north7);

      road.getTracks().add(south1);
      road.getTracks().add(south2);
      road.getTracks().add(south6);
      road.getTracks().add(south7);
      
      roadMap.setEasternSignal(easternSignal);
      roadMap.setWesternSignal(westernSignal);
      
      Car car1 = factory.createCar();
      car1.setTravelDirection(TravelDirection.EAST);
      car1.setTrack(south1);
      
      roadMap.getCars().add(car1);

      Car car2 = factory.createCar();
      car2.setTravelDirection(TravelDirection.WEST);
      car2.setTrack(north1);
      
      roadMap.getCars().add(car2);

      
      String text = roadMap.toString();
      
      Logger.getGlobal().info(text);
      
      EMFeR emfer = new EMFeR()
            .withEPackage(FerrymanPackage.eINSTANCE)
            .withTrafo("move car", root -> getCars(root), (root, car) -> moveCar(root, car))
            .withTrafo("swap Signals", root -> swapSignals(root))
            .withStart(roadMap)
            .withStatic(road, road.getTracks())
            ;
      
      int size = emfer.explore();
      
      // Assert.assertEquals("Number of states:", 7, size);
      
      for (ReachableState s : emfer.getReachabilityGraph().getStates())
      {
         StringBuilder buf = new StringBuilder();
         
         for (TrafoApplication t : s.getResultOf())
         {
            ReachableState src = t.getSrc();
            
            buf.append("\n").append(src.getNumber()).append(" --").append(t.getDescription()).append("-> ").append(s.getNumber());
         }
         
         buf.append(s.getRoot().toString());
         
         for (TrafoApplication t : s.getTrafoApplications())
         {
            ReachableState tgt = t.getTgt();
            
            buf.append(s.getNumber()).append(" --").append(t.getDescription()).append("-> ").append(tgt.getNumber()).append("\n");
         }
         
         Logger.getGlobal().info(buf.toString());
      }
      
      // let's do some computational tree logic 
      ReachableState startState = emfer.getReachabilityGraph().getStates().get(0);
      
      boolean noDeadLock = new AlwaysGlobally().test(startState, s -> ! isCarDeadLock(s));
      assertTrue("noDeadLock", noDeadLock);

      AlwaysFinally alwaysFinally = new AlwaysFinally();
      boolean finallyClear = alwaysFinally.test(startState, s -> isRoadWorkClear(s));
      assertTrue("finallyClear", finallyClear);

      boolean finallyEastPasses = alwaysFinally.test(startState, s -> isEastCarPasses(s));
      assertFalse("finallyEastPasses", finallyEastPasses);
      
      ExistsFinally existsFinally = new ExistsFinally();
      finallyEastPasses = existsFinally.test(startState, s -> isEastCarPasses(s));
      assertTrue("finallyEastPasses", finallyEastPasses);

      boolean deadLock = existsFinally.test(startState, s -> isCarDeadLock(s));
      assertFalse("finallyEastPasses", deadLock);
      
      ExistsGlobally existsGlobally = new ExistsGlobally();
      boolean existGloballyEastPassing = existsGlobally.test(startState, s -> isEasternSignalPassing(s));
      assertTrue("existGloballyEastPassing", existGloballyEastPassing);
      
      boolean existGloballyRoadWorkClear = existsGlobally.test(startState, s -> isRoadWorkClear(s) && isEasternSignalPassing(s));
      assertFalse("existGloballyRoadWorkClear", existGloballyRoadWorkClear);
      
      ExistsNext existsNext = new ExistsNext();
      boolean westGetsGreen = existsNext.test(emfer.getReachabilityGraph().getStates().get(1), 
         s -> ! isEasternSignalPassing(s));
      assertTrue("existGloballyEastPassing", existGloballyEastPassing);

      AlwaysNext alwaysNext = new AlwaysNext();
      boolean noSignalChangeWhileCarInRoadWork = alwaysNext.test(emfer.getReachabilityGraph().getStates().get(6), 
         s -> isEasternSignalPassing(s));
      assertTrue("noSignalChangeWhileCarInRoadWork", noSignalChangeWhileCarInRoadWork);

      AlwaysUntil alwaysUntil = new AlwaysUntil();
      boolean carWillLeaveRoadWork = alwaysUntil.test(emfer.getReachabilityGraph().getStates().get(6), 
         s-> ! isRoadWorkClear(s), 
         s-> isRoadWorkClear(s));
      assertTrue("carWillLeaveRoadWork", carWillLeaveRoadWork);

      boolean alwaysRoadWorkIsEntered = alwaysUntil.test(startState, 
         s-> isRoadWorkClear(s), 
         s-> ! isRoadWorkClear(s));
      assertTrue("alwaysRoadWorkIsEntered", alwaysRoadWorkIsEntered);

      ExistsUntil existsUntil = new ExistsUntil();
      boolean itsPossibleToEnterTheRoadWork = existsUntil.test(startState, 
         s-> isRoadWorkClear(s), 
         s-> ! isRoadWorkClear(s));
      assertTrue("itsPossibleToEnterTheRoadWork", itsPossibleToEnterTheRoadWork);
      
      story.dumpHtml();
   }

   private boolean isEasternSignalPassing(ReachableState s)
   {
      RoadMap roadMap = (RoadMap) s.getRoot();
      
      return roadMap.getEasternSignal().isPass();
   }

   private boolean isEastCarPasses(ReachableState s)
   {
      RoadMap roadMap = (RoadMap) s.getRoot();

      Optional<Car> eastCar = roadMap.getCars().stream()
            .filter(c -> c.getTravelDirection() == TravelDirection.EAST).findAny();

      Car car = eastCar.get();
      
      return car.getTrack().getTravelDirection() == TravelDirection.UNDEFINED;
   }

   private boolean isRoadWorkClear(ReachableState s)
   {
      RoadMap roadMap = (RoadMap) s.getRoot();

      long count = roadMap.getCars().stream()
            .filter(c -> c.getTrack().getTravelDirection() == TravelDirection.UNDEFINED)
            .count();

      return count == 0;
   }

   private boolean isCarDeadLock(ReachableState s)
   {
      RoadMap roadMap = (RoadMap) s.getRoot();
      
      long count = roadMap.getCars().stream()
            .filter(c -> c.getTrack().getTravelDirection() == TravelDirection.UNDEFINED)
            .map(c -> c.getTravelDirection())
            .count();
      
      return count >= 2;
   }

   private void swapSignals(EObject root)
   {
      // no car in narrowing
      RoadMap roadMap = (RoadMap) root;
      
      Optional<Track> usedUndefTrack = roadMap.getCars().stream().map(c -> c.getTrack()).filter(t -> t.getTravelDirection() == TravelDirection.UNDEFINED).findAny();

      if (usedUndefTrack.isPresent())
      {
         return;
      }
      
      boolean carIsWaiting = false;
      
      // no car about to enter and one car waiting at red light
      if (roadMap.getWesternSignal().isPass())
      {
         Track enterTrack = roadMap.getWesternSignal().getTrack();
         boolean carIsEntering = roadMap.getCars().stream().map(c -> c.getTrack()).anyMatch(t -> t == enterTrack);
         
         if (carIsEntering)
         {
            // do not swap signals
            return;
         }

         Track waitTrack = roadMap.getEasternSignal().getTrack();
         carIsWaiting = roadMap.getCars().stream().map(c -> c.getTrack()).anyMatch(t -> t == waitTrack);
      }
      else
      {
         Track enterTrack = roadMap.getEasternSignal().getTrack();
         boolean carIsEntering = roadMap.getCars().stream().map(c -> c.getTrack()).anyMatch(t -> t == enterTrack);
         
         if (carIsEntering)
         {
            // do not swap signals
            return;
         }

         Track waitTrack = roadMap.getWesternSignal().getTrack();
         carIsWaiting = roadMap.getCars().stream().map(c -> c.getTrack()).anyMatch(t -> t == waitTrack);
      }
      
      if (carIsWaiting)
      {
         roadMap.getEasternSignal().setPass( ! roadMap.getEasternSignal().isPass());
         
         roadMap.getWesternSignal().setPass( ! roadMap.getWesternSignal().isPass());
      }
   }

   private void moveCar(EObject root, EObject handle)
   {
      RoadMap roadMap = (RoadMap) root;
      Car car = (Car) handle;
      
      Track pos = car.getTrack();
      EList<Track> targets;
      
      // red light?
      if (pos == roadMap.getEasternSignal().getTrack() && ! roadMap.getEasternSignal().isPass())
      {
         return;
      }
       
      if (pos == roadMap.getWesternSignal().getTrack() && ! roadMap.getWesternSignal().isPass())
      {
         return;
      }
      
      if (car.getTravelDirection() == TravelDirection.EAST)
      {
         targets = pos.getEast();
      }
      else
      {
         targets = pos.getWest();
      }
      
      Track newPos = null;
      
      if (targets.size() == 0)
      {
         return;
      }
      else if (targets.size() == 1)
      {
         newPos = targets.get(0);
      }
      else 
      {
         for (Track t : targets)
         {
            if (t.getTravelDirection() == car.getTravelDirection())
            {
               newPos = t;
               break;
            }
         }
      }
      
      // newPos is blocked?
      Track blockPos = newPos;
      Optional<Car> blocker = roadMap.getCars().stream().filter(c -> c.getTrack() == blockPos ).findAny();
      
      if (blocker.isPresent())
      {
         return;
      }
         
      car.setTrack(newPos);
      
      return;
   }

   private EList getCars(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;
      
      return roadMap.getCars();
   }
}
