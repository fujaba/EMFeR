package emfer.examples.roadwork;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static emfer.examples.roadwork.TravelDirection.*;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.junit.Test;

import emfer.AlwaysFinally;
import emfer.AlwaysGlobally;
import emfer.AlwaysNext;
import emfer.AlwaysUntil;
import emfer.EMFeR;
import emfer.EMFeRGame;
import emfer.ExistFinally;
import emfer.ExistGlobally;
import emfer.ExistNext;
import emfer.ExistUntil;
import emfer.SyntheticControl;
import emfer.reachability.ReachabilityGraph;
import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;
import emfer.stories.StoryStep;
import emfer.stories.Storyboard;

public class RoadWorkProblem
{
   
   @Test
   public void testRoadWorkGame() throws Exception
   {
      Storyboard story = new Storyboard("RoadWorkGame");

      RoadMap roadMap = createStartSituation();

      for (Track t : roadMap.getRoad().getTracks())
      {
         if (t.getName().equals("n7"))
         {
            Car newCar = RoadworkFactory.eINSTANCE.createCar();
            newCar.setTravelDirection(WEST);
            newCar.setTrack(t);
            roadMap.getCars().add(newCar);
         }

         if (t.getName().equals("s7"))
         {
            Car newCar = RoadworkFactory.eINSTANCE.createCar();
            newCar.setTravelDirection(EAST);
            newCar.setTrack(t);
            roadMap.getCars().add(newCar);
         }
      }

      roadMap.getWesternSignal().setPass(true);
      
      Logger.getGlobal().info(roadMap.toString());
      

      EMFeRGame game = new EMFeRGame()
         .withOpponentTrafo("move car", root -> getCars(root), (root, car) -> moveCar(root, car))
         .withMyTrafo("swap western signal", root -> swapSimpleSignal(root, WEST))
         .withMyTrafo("swap eastern signal", root -> swapSimpleSignal(root, EAST))
         .withMyTrafo("swap both signals", root -> swapSimpleSignal(root, BOTH))
         .withMyTrafo("swap both signals", root -> swapSimpleSignal(root, UNDEFINED))
         .withMuCondition(root -> ! isCarWaitsAtRed(root, WEST))
         .withMuCondition(root -> ! isCarWaitsAtRed(root, EAST))
         .withGeneralCondition(root -> isCarDeadLock(root))
         .withStart(roadMap);

      int size = game.explore();
      
      Logger.getGlobal().info("game.size: " + size);

      printReachableStatesList(game.getEmfer(), "e1_");


      story.dumpHtml();
      
   }
   
   
   private void swapSimpleSignal(EObject root, TravelDirection dir)
   {
      RoadMap roadMap = (RoadMap) root;
      Signal signal = roadMap.getWesternSignal();
      
      if (dir == UNDEFINED)
      {
         // do nothing
      }
      else if (dir == WEST)
      {
         signal.setPass( ! signal.isPass());
      }
      else if (dir == EAST)
      {
         signal = roadMap.getEasternSignal();
         signal.setPass( ! signal.isPass());
      }
      else 
      {
         signal.setPass( ! signal.isPass());
         signal = roadMap.getEasternSignal();
         signal.setPass( ! signal.isPass());
      }
   }
   
   
   


   @Test
   public void testManyCarsRoadWorkProblem() throws Exception
   {
      Storyboard story = new Storyboard("MultiCarRoadWorkProblem");

      RoadMap roadMap = createStartSituation();

      for (Track t : roadMap.getRoad().getTracks())
      {
         if (t.getName().equals("n7"))
         {
            Car newCar = RoadworkFactory.eINSTANCE.createCar();
            newCar.setTravelDirection(WEST);
            newCar.setTrack(t);
            roadMap.getCars().add(newCar);
         }

         if (t.getName().equals("s7"))
         {
            Car newCar = RoadworkFactory.eINSTANCE.createCar();
            newCar.setTravelDirection(EAST);
            newCar.setTrack(t);
            roadMap.getCars().add(newCar);
         }
      }

      roadMap.getWesternSignal().setRedCount(1);
      
      Logger.getGlobal().info(roadMap.toString());
      

      EMFeR emfer = new EMFeR()
         .withTrafo("move car", root -> getCars(root), (root, car) -> moveCar(root, car))
         .withTrafo("swap western signal", root -> swapSignal(root, WEST))
         .withTrafo("swap eastern signal", root -> swapSignal(root, EAST))
         .withStart(roadMap);

      int size = emfer.explore();
      
      Logger.getGlobal().info("emfer.size: " + size);

      SyntheticControl syntheticControl = new SyntheticControl(emfer)
            .withTrafo("swap western signal")
            .withTrafo("swap eastern signal")
            .withMetric( root -> dangerMetric(root))
            .withMetric( root -> redWaitCosts(root))
            .applyMetric()
            ;
      
      printReachableStatesList(emfer, "e1_");

      EMFeR emfer2 = new EMFeR()
            .withTrafo("move car", root -> getCars(root), (root, car) -> moveCar(root, car), 1)
            .withTrafo("synthetic control", root -> syntheticControl.run(root), 0)
            .withStart(roadMap);
      
      int size2 = emfer2.explore();
      
      // for debugging
      syntheticControl.applyMetric(emfer2);
      
      Logger.getGlobal().info("Emfer 2 size " + size2);
      
      printReachableStatesList(emfer2, "e2_");

      story.dumpHtml();
      
      AlwaysGlobally alwaysGlobally = new AlwaysGlobally();
      AlwaysFinally alwaysFinally = new AlwaysFinally();
      ExistFinally existFinally = new ExistFinally();
      
      ReachableState startState = emfer2.getReachabilityGraph().getStates().get(0);
      
      // we are save
      boolean save = alwaysGlobally.test(startState, s -> ! isDangerous(s));

      System.out.println("Save: " + save);
      
      // its fair
      boolean fair = alwaysGlobally.test(startState, s -> ! isEastCarWaitsAtRed(s) || alwaysFinally.test(s, s2 -> isEastCarPasses(s2)));
      
      System.out.println("Fair: " + fair);
   }

   private void swapSignal(EObject root, TravelDirection signalPos)
   {
      RoadMap roadMap = (RoadMap) root;
      Signal signal = roadMap.getWesternSignal();
      Signal otherSignal = roadMap.getEasternSignal();
      
      if (signalPos == EAST)
      {
         signal = roadMap.getEasternSignal();
         otherSignal = roadMap.getWesternSignal();
      }
      
      signal.setPass( ! signal.isPass());
      
      if (signal.isPass())
      {
         signal.setRedCount(0);
         
         // if ( ! otherSignal.isPass()) otherSignal.setRedCount(1);
      }
      else
      {
         if (otherSignal.isPass())
         {
            signal.setRedCount(1);
         }
         else
         {
            signal.setRedCount(2);
            otherSignal.setRedCount(1);
         }
      }
   }


   private int redWaitCosts(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;
      
      int waitCosts = 0; 
      
      int fairnessCosts = 1;
      
      if ( ! isRoadWorkClear(roadMap))
      {
         fairnessCosts = 4;
      }
      
      
      for (Signal signal : roadMap.getSignals())
      {
         if (! signal.isPass() && signal.isCarAtSignal())
         {
            waitCosts += (3 - signal.getRedCount());
         }
         if (signal.isPass()) waitCosts += fairnessCosts;
      }
      
      return waitCosts;
   }
   
   
   private int dangerMetric(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;
      
      // two cars in road work area
      int carCount = 0;
      
      for (Car c : roadMap.getCars())
      {
         if (c.getTrack().getTravelDirection() == UNDEFINED) carCount++;
      }
      
      for (Signal signal : roadMap.getSignals())
      {
         if (signal.isPass() && signal.isCarAtSignal()) carCount++;
      }
         
      if (carCount >= 2) return Integer.MAX_VALUE;
      
      if (roadMap.getWesternSignal().isPass() 
            && roadMap.getEasternSignal().isPass())
      {
         return Integer.MAX_VALUE;
      }
      
      return 0;
   }

   public boolean isPassTo(RoadMap roadMap, TravelDirection dir)
   {
      Signal signal = roadMap.getWesternSignal();
      
      if (dir == WEST)
      {
         signal = roadMap.getEasternSignal();
      }
      
      return signal.isPass();
   }


   private int noOfBlockers(ReachableState s)
   {
      RoadMap roadMap = (RoadMap) s.getRoot();
      int blockers = 0;
      int rwac = 0;
      for (Car c : roadMap.getCars()) {
         if (c.getTrack().getTravelDirection() == UNDEFINED)
         {
            Signal signal = roadMap.getWesternSignal();
            if (c.getTravelDirection() == EAST) signal = roadMap.getEasternSignal();
            if ( ! signal.isPass() && signal.getTrack().getCar() != null) 
               blockers++;
         }
      }
      return blockers;
   }


   private void newCar(EObject root, TravelDirection direction)
   {
      String startName = (direction == WEST) ? "n1" : "s1";
      RoadMap roadMap = (RoadMap) root;
      for (Track t : roadMap.getRoad().getTracks())
      {
         if (t.getName().equals(startName))
         {
            if (t.getCar() == null)
            {
               Car newCar = RoadworkFactory.eINSTANCE.createCar();
               newCar.setTravelDirection(direction);
               newCar.setTrack(t);
               roadMap.getCars().add(newCar);
            }
            return;
         }
      }
   }


   private void removeCar(EObject root, TravelDirection direction)
   {
      String endName = (direction == WEST) ? "n7" : "s7";
      RoadMap roadMap = (RoadMap) root;
      for (Car c : roadMap.getCars())
      {
         if (c.getTrack().getName().equals(endName))
         {
            c.setTrack(null);
            roadMap.getCars().remove(c);
         }
      }
   }


   private RoadMap createStartSituation()
   {
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

      return roadMap;
   }


   @Test
   public void testRoadWorkProblem() throws Exception
   {
      Storyboard story = new Storyboard("RoadWorkProblem");

      RoadMap roadMap = createStartSituation();
      
      Logger.getGlobal().info(roadMap.toString());
      

      EMFeR emfer = new EMFeR()
         .withTrafo("move car", root -> getCars(root), (root, car) -> moveCar(root, car), 1)
         .withTrafo("swap Signals", root -> swapSignals(root), 0)
         .withStart(roadMap);

      int size = emfer.explore();

      // Assert.assertEquals("Number of states:", 7, size);

      printReachableStatesList(emfer, "e1_");

      // let's do some computational tree logic
      ReachableState startState = emfer.getReachabilityGraph().getStates().get(0);

      AlwaysGlobally alwaysGlobally = new AlwaysGlobally();
      boolean noDeadLock = alwaysGlobally.test(startState, s -> !isCarDeadLock(s));
      assertTrue("noDeadLock", noDeadLock);

      AlwaysFinally alwaysFinally = new AlwaysFinally();
      boolean finallyClear = alwaysFinally.test(startState, s -> isRoadWorkClear(s));
      assertTrue("finallyClear", finallyClear);

      boolean alwaysFinallyEastEnters = alwaysGlobally.test(startState,
         s -> alwaysFinally.test(s, s2 -> !isEastCarWaitsAtRed(s2) || isEastCarPasses(s2)));
      ArrayList<TrafoApplication> counterExample = alwaysFinally.getCounterExamplePath();
      // System.out.println(counterExample);
      // assertTrue("finallyEastPasses", alwaysFinallyEastEnters);

      boolean finallyEastPasses = alwaysFinally.test(emfer.getReachabilityGraph().getStates().get(1), s -> isEastCarPasses(s));
      counterExample = alwaysFinally.getCounterExamplePath();
      System.out.println(counterExample);
      // assertTrue("finallyEastPasses", finallyEastPasses);

      ExistFinally existFinally = new ExistFinally();
      finallyEastPasses = existFinally.test(startState, s -> isEastCarPasses(s));
      assertTrue("finallyEastPasses", finallyEastPasses);

      boolean deadLock = existFinally.test(startState, s -> isCarDeadLock(s));
      assertFalse("finallyEastPasses", deadLock);

      ExistGlobally existGlobally = new ExistGlobally();
      boolean existGloballyEastPassing = existGlobally.test(startState, s -> isEasternSignalPassing(s));
      // assertFalse("existGloballyEastPassing", existGloballyEastPassing);

      boolean existGloballyRoadWorkClear = existGlobally.test(startState, s -> isRoadWorkClear(s) && isEasternSignalPassing(s));
      assertFalse("existGloballyRoadWorkClear", existGloballyRoadWorkClear);

      boolean unfair = existFinally.test(startState, s -> existGlobally.test(s, s2 -> isEastCarWaitsAtRed(s2)));
      System.out.println(existGlobally.getExamplePath());
      // assertTrue("unfair",unfair);

      ExistNext existNext = new ExistNext();
      boolean westGetsGreen = existNext.test(emfer.getReachabilityGraph().getStates().get(1),
         s -> !isEasternSignalPassing(s));
      assertTrue("westGetsGreen", westGetsGreen);

      AlwaysNext alwaysNext = new AlwaysNext();
      boolean noSignalChangeWhileCarInRoadWork = alwaysNext.test(emfer.getReachabilityGraph().getStates().get(5),
         s -> isEasternSignalPassing(s));
      assertTrue("noSignalChangeWhileCarInRoadWork", noSignalChangeWhileCarInRoadWork);

      AlwaysUntil alwaysUntil = new AlwaysUntil();
      ReachableState carInRoadWorkState = emfer.getReachabilityGraph().getStates().get(6);
      boolean carWillLeaveRoadWork = alwaysUntil.test(carInRoadWorkState,
         s -> !isRoadWorkClear(s),
         s -> isRoadWorkClear(s));
      assertTrue("carWillLeaveRoadWork", carWillLeaveRoadWork);

      boolean alwaysRoadWorkIsEntered = alwaysUntil.test(startState,
         s -> isRoadWorkClear(s),
         s -> !isRoadWorkClear(s));
      assertTrue("alwaysRoadWorkIsEntered", alwaysRoadWorkIsEntered);

      ExistUntil existUntil = new ExistUntil();
      boolean itsPossibleToEnterTheRoadWork = existUntil.test(startState,
         s -> isRoadWorkClear(s),
         s -> !isRoadWorkClear(s));
      assertTrue("itsPossibleToEnterTheRoadWork", itsPossibleToEnterTheRoadWork);

      story.addReachableState(emfer.getReachabilityGraph().getStates().get(0), "Start Model");

      story.addReachabilityGraph(emfer.getReachabilityGraph());

      story.dumpHtml();

      TMXRoadworkVisualizer.visualize(emfer, "doc/rwp-images/");

      // return emfer;
   }


   private void printReachableStatesList(EMFeR emfer, String prefix)
   {
      StoryStep step = new StoryStep();
      
      for (ReachableState s : emfer.getReachabilityGraph().getStates())
      {
         StringBuilder buf = new StringBuilder();
         
         String descr = step.genHtmlStateDescription(s, prefix);

         Logger.getGlobal().info(descr);
      }
   }


   private boolean isEasternSignalPassing(ReachableState s)
   {
      RoadMap roadMap = (RoadMap) s.getRoot();

      return roadMap.getEasternSignal().isPass();
   }


   // private boolean isEastCarPasses(ReachableState s)
   // {
   // RoadMap roadMap = (RoadMap) s.getRoot();
   //
   // Optional<Car> eastCar = roadMap.getCars().stream()
   // .filter(c -> c.getTravelDirection() == TravelDirection.EAST).findAny();
   //
   // Car car = eastCar.get();
   //
   // return car.getTrack().getTravelDirection() == TravelDirection.UNDEFINED;
   // }

   private boolean isCarWaitsAtRed(EObject root, TravelDirection dir)
   {
      RoadMap roadMap = (RoadMap) root;
     
      Signal signal = roadMap.getWesternSignal();
      
      if (dir == EAST)
      {
         signal = roadMap.getEasternSignal();
      }
      
      boolean result =  ! signal.isPass() && signal.isCarAtSignal();

      return result;
   }
   
   private boolean isCarWaitsAtRed(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;
      if (!roadMap.getWesternSignal().isPass()
         && roadMap.getWesternSignal().getTrack().getCar() != null)
         return true;
      if (!roadMap.getEasternSignal().isPass()
         && roadMap.getEasternSignal().getTrack().getCar() != null)
         return true;
      return false;
   }
   
   private int signalInsecure(ReachableState s)
   {
      RoadMap roadMap = (RoadMap) s.getRoot();
      int result = 0;
      
      Signal signal = roadMap.getWesternSignal();
      if (signal.isPass() && signal.getTrack().getCar() == null) result++;
      
      signal = roadMap.getEasternSignal();
      if (signal.isPass() && signal.getTrack().getCar() == null) result++;
      
      return result;
      
   }

   private boolean isEastCarWaitsAtRed(ReachableState s)
   {
      RoadMap roadMap = (RoadMap) s.getRoot();
      if (roadMap.getWesternSignal().isPass())
         return false;
      return roadMap.getWesternSignal().isCarAtSignal();
   }


   private boolean isEastCarPasses(ReachableState s)
   {
      RoadMap roadMap = (RoadMap) s.getRoot();
      for (Car c : roadMap.getCars())
      {
         if (c.getTravelDirection() == TravelDirection.EAST
            && c.getTrack().getTravelDirection() == TravelDirection.UNDEFINED)
         {
            return true;
         }
      }
      return false;
   }


   private boolean isRoadWorkClear(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;

      long count = roadMap.getCars().stream()
         .filter(c -> c.getTrack().getTravelDirection() == TravelDirection.UNDEFINED)
         .count();

      return count == 0;
   }

   

   private boolean isDangerous(ReachableState s)
   {
      RoadMap roadMap = (RoadMap) s.getRoot();

      int westCount = 0;
      int eastCount = 0;
      for (Car c : roadMap.getCars()) {
         if (c.getTrack().getTravelDirection() == UNDEFINED) {
            if (c.getTravelDirection() == WEST) westCount++;
            if (c.getTravelDirection() == EAST) eastCount++;
         }
      }
      if (roadMap.getWesternSignal().isPass() && roadMap.getWesternSignal().getTrack().getCar() != null) eastCount++;
      if (roadMap.getEasternSignal().isPass() && roadMap.getEasternSignal().getTrack().getCar() != null) westCount++;

      boolean result = westCount > 0 && eastCount > 0;
      
      if (result)
      {
         System.out.println(s);
      }
      
      return result;
   }

   
   private boolean isCarDeadLock(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;

      long count = roadMap.getCars().stream()
            .filter(c -> c.getTrack().getTravelDirection() == TravelDirection.UNDEFINED)
            .map(c -> c.getTravelDirection()).distinct()
            .count();

      return count >= 2;
   }


   // private void swapSignals(EObject root)
   // {
   // // no car in narrowing
   // RoadMap roadMap = (RoadMap) root;
   //
   // Optional<Track> usedUndefTrack = roadMap.getCars().stream().map(c -> c.getTrack()).filter(t -> t.getTravelDirection() == TravelDirection.UNDEFINED).findAny();
   //
   // if (usedUndefTrack.isPresent())
   // {
   // return;
   // }
   //
   // boolean carIsWaiting = false;
   //
   // // no car about to enter and one car waiting at red light
   // if (roadMap.getWesternSignal().isPass())
   // {
   // Track enterTrack = roadMap.getWesternSignal().getTrack();
   // boolean carIsEntering = roadMap.getCars().stream().map(c -> c.getTrack()).anyMatch(t -> t == enterTrack);
   //
   // if (carIsEntering)
   // {
   // // do not swap signals
   // return;
   // }
   //
   // Track waitTrack = roadMap.getEasternSignal().getTrack();
   // carIsWaiting = roadMap.getCars().stream().map(c -> c.getTrack()).anyMatch(t -> t == waitTrack);
   // }
   // else
   // {
   // Track enterTrack = roadMap.getEasternSignal().getTrack();
   // boolean carIsEntering = roadMap.getCars().stream().map(c -> c.getTrack()).anyMatch(t -> t == enterTrack);
   //
   // if (carIsEntering)
   // {
   // // do not swap signals
   // return;
   // }
   //
   // Track waitTrack = roadMap.getWesternSignal().getTrack();
   // carIsWaiting = roadMap.getCars().stream().map(c -> c.getTrack()).anyMatch(t -> t == waitTrack);
   // }
   //
   // if (carIsWaiting)
   // {
   // roadMap.getEasternSignal().setPass(!roadMap.getEasternSignal().isPass());
   //
   // roadMap.getWesternSignal().setPass(!roadMap.getWesternSignal().isPass());
   // }
   // }
   //

   private void swapSignals(EObject root)
   {
      // no car in narrowing
      RoadMap roadMap = (RoadMap) root;

      for (Car c : roadMap.getCars())
      {
         if (c.getTrack().getTravelDirection() == TravelDirection.UNDEFINED)
            return;
      }

      boolean carIsWaiting = false;

      // no car about to enter and one car waiting at red light
      boolean carAtWest = roadMap.getWesternSignal().getTrack().getCar() != null;
      boolean carAtEast = roadMap.getEasternSignal().getTrack().getCar() != null;

      if (roadMap.getWesternSignal().isPass() && carAtWest)
         return;
      if (roadMap.getEasternSignal().isPass() && carAtEast)
         return;

      if (roadMap.getWesternSignal().isPass() && carAtEast
         || roadMap.getEasternSignal().isPass() && carAtWest)
      {
         roadMap.getEasternSignal().setPass(!roadMap.getEasternSignal().isPass());
         roadMap.getWesternSignal().setPass(!roadMap.getWesternSignal().isPass());
      }
   }


   private void moveCar(EObject root, EObject handle)
   {
      RoadMap roadMap = (RoadMap) root;
      Car car = (Car) handle;

      // red light?
      Signal signal = car.getTrack().getSignal();
      if (signal != null && !signal.isPass())
         return;

      EList<Track> targets;
      if (car.getTravelDirection() == TravelDirection.EAST)
      {
         targets = car.getTrack().getEast();
      }
      else
      {
         targets = car.getTrack().getWest();
      }

      Track newPos = null;

      if (targets.size() == 0)
         return;
      if (targets.size() == 1)
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
            }
         }
      }

      if (newPos.getCar() != null)
         return;

      car.setTrack(newPos);
   }

   // private void moveCar(EObject root, EObject handle)
   // {
   // RoadMap roadMap = (RoadMap) root;
   // Car car = (Car) handle;
   //
   // Track pos = car.getTrack();
   // EList<Track> targets;
   //
   // // red light?
   // if (pos == roadMap.getEasternSignal().getTrack() && !roadMap.getEasternSignal().isPass())
   // {
   // return;
   // }
   //
   // if (pos == roadMap.getWesternSignal().getTrack() && !roadMap.getWesternSignal().isPass())
   // {
   // return;
   // }
   //
   // if (car.getTravelDirection() == TravelDirection.EAST)
   // {
   // targets = pos.getEast();
   // }
   // else
   // {
   // targets = pos.getWest();
   // }
   //
   // Track newPos = null;
   //
   // if (targets.size() == 0)
   // {
   // return;
   // }
   // else if (targets.size() == 1)
   // {
   // newPos = targets.get(0);
   // }
   // else
   // {
   // for (Track t : targets)
   // {
   // if (t.getTravelDirection() == car.getTravelDirection())
   // {
   // newPos = t;
   // break;
   // }
   // }
   // }
   //
   // // newPos is blocked?
   // Track blockPos = newPos;
   // Optional<Car> blocker = roadMap.getCars().stream().filter(c -> c.getTrack() == blockPos).findAny();
   //
   // if (blocker.isPresent())
   // {
   // return;
   // }
   //
   // car.setTrack(newPos);
   //
   // return;
   // }


   private EList getCars(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;

      return roadMap.getCars();
   }
}
