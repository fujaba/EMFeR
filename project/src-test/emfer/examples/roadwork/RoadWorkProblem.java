package emfer.examples.roadwork;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static emfer.examples.roadwork.TravelDirection.*;

import java.util.ArrayList;
import java.util.Collection;
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
import emfer.GameControl;
import emfer.SyntheticControl;
import emfer.reachability.GameState;
import emfer.reachability.ReachabilityFactory;
import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;
import emfer.reachability.Turn;
import emfer.stories.StoryStep;
import emfer.stories.Storyboard;

import java.lang.reflect.*;

public class RoadWorkProblem
{
   
   @Test
   public void testDynamicRoadWorkGame() throws Exception
   {
      Storyboard story = new Storyboard("DynamicRoadWorkGame");

      RoadMap roadMap = createStartSituation();

      roadMap.getWesternSignal().setPass(true);
      
      EMFeRGame game = new EMFeRGame()
         .withOpponentTrafo("move car", root -> getCars(root), (root, car) -> moveCar(root, car))
         .withOpponentTrafo("create car going east", root -> createCarGoingEast(root))
         .withOpponentTrafo("remove car going east", root -> removeCarGoingEast(root))
         .withOpponentTrafo("create car going west", root -> createCarGoingWest(root))
         .withOpponentTrafo("remove car going west", root -> removeCarGoingWest(root))
         .withMyTrafo("swap green green", root -> swapGreenGreen(root))
         .withMyTrafo("swap green red", root -> swapGreenRed(root))
         .withMyTrafo("swap red green", root -> swapRedGreen(root))
         .withMyTrafo("swap red red", root -> swapRedRed(root))
         .withMuCondition("noLeftCar", root -> ! isCarAt(root, WEST))
         .withMuCondition("noRightCar", root -> ! isCarAt(root, EAST))
         .withGeneralCondition("safe", root -> ! isCarDeadLock(root))
         .withStart(roadMap);

      Logger.getGlobal().info(game.getEmfer().getReachabilityGraph().getStates().get(0).toString());
      
      
      int size = game.explore();
      
      Logger.getGlobal().info("game.size: " + size);

      // printReachableStatesList(game.getEmfer(), "g1_");
      
      // story.dumpHtml();

      // build game Control
      GameControl gameControl = new GameControl(game);
      
      // prepare game start
      GameState gameRoadMap = ReachabilityFactory.eINSTANCE.createGameState();
      gameRoadMap.setBoard(roadMap);
      gameRoadMap.setTurn(Turn.MY_TURN);
      
      game.applyAndMarkMuCondition(gameRoadMap);
      

      // test gameStrategy
      EMFeR emfer2 = new EMFeR()
            .withTrafo("move car", g -> gameGetCars(g), (g, car) -> gameMoveCar(g, car, game), 1)
            .withTrafo("create car going east", root -> gameCreateCarGoingEast(root), 1)
            .withTrafo("remove car going east", root -> gameRemoveCarGoingEast(root), 1)
            .withTrafo("create car going west", root -> gameCreateCarGoingWest(root), 1)
            .withTrafo("remove car going west", root -> gameRemoveCarGoingWest(root), 1)
            .withTrafo("game control", root -> gameControl.run(root), 0)
            .withStart(gameRoadMap);
      
      int size2 = emfer2.explore();
      
      // for debugging
      Logger.getGlobal().info("Emfer 2 size " + size2);
      
      printReachableStatesList(emfer2, "g2_");

      story.dumpHtml();
      
      AlwaysGlobally alwaysGlobally = new AlwaysGlobally();
      AlwaysFinally alwaysFinally = new AlwaysFinally();
      ExistFinally existFinally = new ExistFinally();
      
      ReachableState startState = emfer2.getReachabilityGraph().getStates().get(0);
      
      // we are save
      boolean save = alwaysGlobally.test(startState, s -> ! gameIsCarDeadLock(s.getRoot()));

      Logger.getGlobal().info("Save: " + save);
      
      // its fair
      boolean fair = alwaysGlobally.test(
         startState, s -> ! gameIsEastCarWaitsAtRed(s.getRoot()) 
         || alwaysFinally.test(s, s2 -> gameIsEastCarPasses(s2.getRoot())));
      
      Logger.getGlobal().info("Fair: " + fair);
      
      
      story.dumpHtml();
      
   }
   
   
   
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
      
      EMFeRGame game = new EMFeRGame()
         .withOpponentTrafo("move car", root -> getCars(root), (root, car) -> moveCar(root, car))
         .withMyTrafo("swap green green", root -> swapGreenGreen(root))
         .withMyTrafo("swap green red", root -> swapGreenRed(root))
         .withMyTrafo("swap red green", root -> swapRedGreen(root))
         .withMyTrafo("swap red red", root -> swapRedRed(root))
         .withMuCondition("noLeftCar", root -> ! isCarAt(root, WEST))
         .withMuCondition("noRightCar", root -> ! isCarAt(root, EAST))
         .withGeneralCondition("safe", root -> ! isCarDeadLock(root))
         .withStart(roadMap);

      Logger.getGlobal().info(game.getEmfer().getReachabilityGraph().getStates().get(0).toString());
      
      int size = game.explore();
      
      Logger.getGlobal().info("game.size: " + size);

      printReachableStatesList(game.getEmfer(), "g1_");
      
      // story.dumpHtml();

      // build game Control
      GameControl gameControl = new GameControl(game);
      
      // prepare game start
      GameState gameRoadMap = ReachabilityFactory.eINSTANCE.createGameState();
      gameRoadMap.setBoard(roadMap);
      gameRoadMap.setTurn(Turn.MY_TURN);
      
      game.applyAndMarkMuCondition(gameRoadMap);
      

      // test gameStrategy
      EMFeR emfer2 = new EMFeR()
            .withTrafo("move car", g -> gameGetCars(g), (g, car) -> gameMoveCar(g, car, game), 1)
            .withTrafo("game control", root -> gameControl.run(root), 0)
            .withStart(gameRoadMap);
      
      int size2 = emfer2.explore();
      
      // for debugging
      Logger.getGlobal().info("Emfer 2 size " + size2);
      
      printReachableStatesList(emfer2, "g2_");

      story.dumpHtml();
      
      AlwaysGlobally alwaysGlobally = new AlwaysGlobally();
      AlwaysFinally alwaysFinally = new AlwaysFinally();
      ExistFinally existFinally = new ExistFinally();
      
      ReachableState startState = emfer2.getReachabilityGraph().getStates().get(0);
      
      // we are save
      boolean save = alwaysGlobally.test(startState, s -> ! gameIsCarDeadLock(s.getRoot()));

      Logger.getGlobal().info("Save: " + save);
      
      // its fair
      boolean fair = alwaysGlobally.test(
         startState, s -> ! gameIsEastCarWaitsAtRed(s.getRoot()) 
         || alwaysFinally.test(s, s2 -> gameIsEastCarPasses(s2.getRoot())));
      
      Logger.getGlobal().info("Fair: " + fair);
      
      
      story.dumpHtml();
      
   }
   
   
   private boolean isCarAt(EObject root, TravelDirection dir)
   {
      RoadMap roadMap = (RoadMap) root;
      
      Signal signal = roadMap.getWesternSignal();
      
      if (dir == EAST)
      {
         signal = roadMap.getEasternSignal();
      }
      
      return signal.isCarAtSignal();
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
   public void testMultiCarsRoadWorkProblem() throws Exception
   {
      Storyboard story = new Storyboard("MultiCarRoadWorkProblem");

      RoadMap roadMap = createStartSituation();

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
      boolean save = alwaysGlobally.test(startState, s -> ! isDangerous(s.getRoot()));

      System.out.println("Save: " + save);
      
      // its fair
      boolean fair = alwaysGlobally.test(
         startState, s -> ! isEastCarWaitsAtRed(s.getRoot()) 
         || alwaysFinally.test(s, s2 -> isEastCarPasses(s2.getRoot())));
      
      System.out.println("Fair: " + fair);
   }


   @Test
   public void testMetricControlerSynthesis() throws Exception
   {
      Storyboard story = new Storyboard("MetricControlerSynthesis");

      RoadMap roadMap = createStartSituation();

      roadMap.getWesternSignal().setRedCount(1);
      
      Logger.getGlobal().info(roadMap.toString());
      

      EMFeR emfer = new EMFeR()
         .withTrafo("move car", root -> getCars(root), (root, car) -> moveCar(root, car))
         .withTrafo("create car going east", root -> createCarGoingEast(root))
         .withTrafo("remove car going east", root -> removeCarGoingEast(root))
         .withTrafo("create car going west", root -> createCarGoingWest(root))
         .withTrafo("remove car going west", root -> removeCarGoingWest(root))
         .withTrafo("signal green green", root -> signalGreenGreen(root))
         .withTrafo("signal red green", root -> signalRedGreen(root))
         .withTrafo("signal green red", root -> signalGreenRed(root))
         .withTrafo("signal red red", root -> signalRedRed(root))
         .withStart(roadMap);

      int size = emfer.explore();
      
      Logger.getGlobal().info("emfer.size: " + size);

      SyntheticControl syntheticControl = new SyntheticControl(emfer)
            .withTrafo("signal green green")
            .withTrafo("signal red green")
            .withTrafo("signal green red")
            .withTrafo("signal red red")
            .withMetric( root -> dangerMetric(root))
            .withMetric( root -> redWaitCosts(root))
            .applyMetric()
            ;
      
      printReachableStatesList(emfer, "e1_");

      EMFeR emfer2 = new EMFeR()
            .withTrafo("move car", root -> getCars(root), (root, car) -> moveCar(root, car), 1)
            .withTrafo("create car going east", root -> createCarGoingEast(root), 1)
            .withTrafo("remove car going east", root -> removeCarGoingEast(root), 1)
            .withTrafo("create car going west", root -> createCarGoingWest(root), 1)
            .withTrafo("remove car going west", root -> removeCarGoingWest(root), 1)
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
      boolean save = alwaysGlobally.test(startState, s -> ! isDangerous(s.getRoot()));

      System.out.println("Save: " + save);
      
      // its fair
      boolean fair = alwaysGlobally.test(
         startState, s -> ! isEastCarWaitsAtRed(s.getRoot()) 
         || alwaysFinally.test(s, s2 -> isEastCarPasses(s2.getRoot())));
      
      System.out.println("Fair: " + fair);
   }

   private void signalGreenGreen(EObject root)
   {
      RoadMap roadMap = swapGreenGreen(root);

      roadMap.getWesternSignal().setRedCount(0);
      roadMap.getEasternSignal().setRedCount(0);
   }


   private RoadMap swapGreenGreen(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;
      
      roadMap.getWesternSignal().setPass(true);
      roadMap.getEasternSignal().setPass(true);
      return roadMap;
   }


   private void signalRedGreen(EObject root)
   {
      RoadMap roadMap = swapRedGreen(root);

      roadMap.getWesternSignal().setRedCount(1);
      roadMap.getEasternSignal().setRedCount(0);
   }


   private RoadMap swapRedGreen(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;
      
      roadMap.getWesternSignal().setPass(false);
      roadMap.getEasternSignal().setPass(true);
      return roadMap;
   }


   private void signalGreenRed(EObject root)
   {
      RoadMap roadMap = swapGreenRed(root);

      roadMap.getWesternSignal().setRedCount(0);
      roadMap.getEasternSignal().setRedCount(1);
      
   }


   private RoadMap swapGreenRed(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;
      
      roadMap.getWesternSignal().setPass(true);
      roadMap.getEasternSignal().setPass(false);
      return roadMap;
   }

   private void signalRedRed(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;
      
      Signal westSignal = roadMap.getWesternSignal();
      Signal eastSignal = roadMap.getEasternSignal();
      
      if (westSignal.isPass() || eastSignal.isPass())
      {
         westSignal.setRedCount(westSignal.getRedCount()+1);
         eastSignal.setRedCount(eastSignal.getRedCount()+1);
      }
      
      swapRedRed(root);
   }

   private RoadMap swapRedRed(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;
      
      roadMap.getWesternSignal().setPass(false);
      roadMap.getEasternSignal().setPass(false);
      return roadMap;
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
            waitCosts += signal.getRedCount();
         }
         
         if (signal.isPass()) 
         {
            waitCosts += fairnessCosts;
         }
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
      boolean noDeadLock = alwaysGlobally.test(startState, s -> !isCarDeadLock(s.getRoot()));
      assertTrue("noDeadLock", noDeadLock);

      AlwaysFinally alwaysFinally = new AlwaysFinally();
      boolean finallyClear = alwaysFinally.test(startState, s -> isRoadWorkClear(s.getRoot()));
      assertTrue("finallyClear", finallyClear);

      boolean alwaysFinallyEastEnters = alwaysGlobally.test(startState,
         s -> alwaysFinally.test(s, s2 -> !isEastCarWaitsAtRed(s2.getRoot()) || isEastCarPasses(s2.getRoot())));
      ArrayList<TrafoApplication> counterExample = alwaysFinally.getCounterExamplePath();
      // System.out.println(counterExample);
      // assertTrue("finallyEastPasses", alwaysFinallyEastEnters);

      boolean finallyEastPasses = alwaysFinally.test(emfer.getReachabilityGraph().getStates().get(1), s -> isEastCarPasses(s.getRoot()));
      counterExample = alwaysFinally.getCounterExamplePath();
      System.out.println(counterExample);
      // assertTrue("finallyEastPasses", finallyEastPasses);

      ExistFinally existFinally = new ExistFinally();
      finallyEastPasses = existFinally.test(startState, s -> isEastCarPasses(s.getRoot()));
      assertTrue("finallyEastPasses", finallyEastPasses);

      boolean deadLock = existFinally.test(startState, s -> isCarDeadLock(s.getRoot()));
      assertFalse("finallyEastPasses", deadLock);

      ExistGlobally existGlobally = new ExistGlobally();
      boolean existGloballyEastPassing = existGlobally.test(startState, s -> isEasternSignalPassing(s.getRoot()));
      // assertFalse("existGloballyEastPassing", existGloballyEastPassing);

      boolean existGloballyRoadWorkClear = existGlobally.test(startState, s -> isRoadWorkClear(s.getRoot()) && isEasternSignalPassing(s.getRoot()));
      assertFalse("existGloballyRoadWorkClear", existGloballyRoadWorkClear);

      boolean unfair = existFinally.test(startState, s -> existGlobally.test(s, s2 -> isEastCarWaitsAtRed(s2.getRoot())));
      System.out.println(existGlobally.getExamplePath());
      // assertTrue("unfair",unfair);

      ExistNext existNext = new ExistNext();
      boolean westGetsGreen = existNext.test(emfer.getReachabilityGraph().getStates().get(1),
         s -> !isEasternSignalPassing(s.getRoot()));
      assertTrue("westGetsGreen", westGetsGreen);

      AlwaysNext alwaysNext = new AlwaysNext();
      boolean noSignalChangeWhileCarInRoadWork = alwaysNext.test(emfer.getReachabilityGraph().getStates().get(5),
         s -> isEasternSignalPassing(s.getRoot()));
      assertTrue("noSignalChangeWhileCarInRoadWork", noSignalChangeWhileCarInRoadWork);

      AlwaysUntil alwaysUntil = new AlwaysUntil();
      ReachableState carInRoadWorkState = emfer.getReachabilityGraph().getStates().get(6);
      boolean carWillLeaveRoadWork = alwaysUntil.test(carInRoadWorkState,
         s -> !isRoadWorkClear(s.getRoot()),
         s -> isRoadWorkClear(s.getRoot()));
      assertTrue("carWillLeaveRoadWork", carWillLeaveRoadWork);

      boolean alwaysRoadWorkIsEntered = alwaysUntil.test(startState,
         s -> isRoadWorkClear(s.getRoot()),
         s -> !isRoadWorkClear(s.getRoot()));
      assertTrue("alwaysRoadWorkIsEntered", alwaysRoadWorkIsEntered);

      ExistUntil existUntil = new ExistUntil();
      boolean itsPossibleToEnterTheRoadWork = existUntil.test(startState,
         s -> isRoadWorkClear(s.getRoot()),
         s -> !isRoadWorkClear(s.getRoot()));
      assertTrue("itsPossibleToEnterTheRoadWork", itsPossibleToEnterTheRoadWork);

      story.addReachableState(emfer.getReachabilityGraph().getStates().get(0), "Start Model");

      story.addReachabilityGraph(emfer.getReachabilityGraph());

      story.dumpHtml();

      TMXRoadworkVisualizer.visualize(emfer, "doc/rwp-images/");

      // return emfer;
   }


   

   @Test
   public void testDynamicRoadWorkProblem() throws Exception
   {
      Storyboard story = new Storyboard("DynamicRoadWorkProblem");

      RoadMap roadMap = createStartSituation();
      
      Logger.getGlobal().info(roadMap.toString());
      

      EMFeR emfer = new EMFeR()
         .withTrafo("move car", root -> getCars(root), (root, car) -> moveCar(root, car), 1)
         .withTrafo("create car going east", root -> createCarGoingEast(root), 1)
         .withTrafo("remove car going east", root -> removeCarGoingEast(root), 1)
         .withTrafo("create car going west", root -> createCarGoingWest(root), 1)
         .withTrafo("remove car going west", root -> removeCarGoingWest(root), 1)
         .withTrafo("swap Signals", root -> swapSignals(root), 0)
         .withStart(roadMap);

      int size = emfer.explore();
      
      Logger.getGlobal().info("emfer.size: " + size);

      // Assert.assertEquals("Number of states:", 7, size);

      printReachableStatesList(emfer, "e1_");

      // let's do some computational tree logic
      ReachableState startState = emfer.getReachabilityGraph().getStates().get(0);

      AlwaysGlobally alwaysGlobally = new AlwaysGlobally();
      ExistFinally existFinally = new ExistFinally();
      ExistGlobally existGlobally = new ExistGlobally();

      boolean noDeadLock = alwaysGlobally.test(startState, s -> !isCarDeadLock(s.getRoot()));
      assertTrue("save", noDeadLock);

      boolean unfair = existFinally.test(startState, s -> existGlobally.test(s, s2 -> isEastCarWaitsAtRed(s2.getRoot())));
      System.out.println(existGlobally.getExamplePath());
      assertTrue("unfair",unfair);

      story.addReachableState(emfer.getReachabilityGraph().getStates().get(0), "Start Model");

      // story.addReachabilityGraph(emfer.getReachabilityGraph());

      story.dumpHtml();

      // TMXRoadworkVisualizer.visualize(emfer, "doc/rwp-images/");

      // return emfer;
   }


   
   private void gameCreateCarGoingEast(EObject root)
   {
      GameState gameState = (GameState) root;
      
      boolean moveDone = createCarGoingEast(gameState.getBoard()); 

      if (moveDone)
      {
         gameState.setTurn(Turn.MY_TURN);
      }
   }

   
   private boolean createCarGoingEast(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;
      
      for (Track t : roadMap.getRoad().getTracks())
      {
         if (t.getName().equals("s1"))
         {
            if (t.getCar() == null)
            {
               Car newCar = RoadworkFactory.eINSTANCE.createCar();
               newCar.setTravelDirection(EAST);
               newCar.setTrack(t);
               roadMap.getCars().add(newCar);
               return true;
            }
            return false;
         }
      }
      
      return false;
   }


   private void gameRemoveCarGoingEast(EObject root)
   {
      GameState gameState = (GameState) root;
      
      boolean moveDone = removeCarGoingEast(gameState.getBoard()); 

      if (moveDone)
      {
         gameState.setTurn(Turn.MY_TURN);
      }
   }

   
   private boolean removeCarGoingEast(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;
      
      for (Track t : roadMap.getRoad().getTracks())
      {
         if (t.getName().equals("s7"))
         {
            Car oldCar = t.getCar();
            
            if (oldCar != null)
            {
               oldCar.setTrack(null);
               roadMap.getCars().remove(oldCar);
               return true;
            }
            break;
         }
      }
      return false;
   }

   
   private void gameCreateCarGoingWest(EObject root)
   {
      GameState gameState = (GameState) root;
      
      boolean moveDone = createCarGoingWest(gameState.getBoard()); 

      if (moveDone)
      {
         gameState.setTurn(Turn.MY_TURN);
      }
   }

   
   private boolean createCarGoingWest(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;
      
      for (Track t : roadMap.getRoad().getTracks())
      {
         if (t.getName().equals("n1"))
         {
            if (t.getCar() == null)
            {
               Car newCar = RoadworkFactory.eINSTANCE.createCar();
               newCar.setTravelDirection(WEST);
               newCar.setTrack(t);
               roadMap.getCars().add(newCar);
               return true;
            }
            break;
         }
      }
      return false;
   }


   private void gameRemoveCarGoingWest(EObject root)
   {
      GameState gameState = (GameState) root;
      
      boolean moveDone = removeCarGoingWest(gameState.getBoard()); 

      if (moveDone)
      {
         gameState.setTurn(Turn.MY_TURN);
      }
   }

   
   private boolean removeCarGoingWest(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;
      
      for (Track t : roadMap.getRoad().getTracks())
      {
         if (t.getName().equals("n7"))
         {
            Car oldCar = t.getCar();
            
            if (oldCar != null)
            {
               oldCar.setTrack(null);
               roadMap.getCars().remove(oldCar);
               return true;
            }
            break;
         }
      }
      return false;
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


   private boolean isEasternSignalPassing(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;

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

   private boolean gameIsEastCarWaitsAtRed(EObject root)
   {
      GameState gameState = (GameState) root;
      
      return isEastCarWaitsAtRed(gameState.getBoard());
   }
   
   private boolean isEastCarWaitsAtRed(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;
      if (roadMap.getWesternSignal().isPass())
         return false;
      return roadMap.getWesternSignal().isCarAtSignal();
   }


   private boolean gameIsEastCarPasses(EObject root)
   {
      GameState gameState = (GameState) root;
      
      return isEastCarPasses(gameState.getBoard());
   }
   
   
   private boolean isEastCarPasses(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;
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

   

   private boolean isDangerous(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;

      int westCount = 0;
      int eastCount = 0;
      
      for (Car c : roadMap.getCars()) 
      {
         if (c.getTrack().getTravelDirection() == UNDEFINED) 
         {
            if (c.getTravelDirection() == WEST) westCount++;
            
            if (c.getTravelDirection() == EAST) eastCount++;
         }
      }
      
      if (roadMap.getWesternSignal().isPass() && roadMap.getWesternSignal().getTrack().getCar() != null) eastCount++;

      if (roadMap.getEasternSignal().isPass() && roadMap.getEasternSignal().getTrack().getCar() != null) westCount++;

      boolean result = westCount > 0 && eastCount > 0;
      
      if (result)
      {
         System.out.println(root);
      }
      
      return result;
   }

   
   
   private boolean gameIsCarDeadLock(EObject root)
   {
      GameState gameState = (GameState) root;
      
      return isCarDeadLock(gameState.getBoard());
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
      boolean carAtWest = roadMap.getWesternSignal().isCarAtSignal();
      boolean carAtEast = roadMap.getEasternSignal().isCarAtSignal();

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


   private void gameMoveCar(EObject g, EObject handle, EMFeRGame game)
   {
      GameState gameState = (GameState) g;
      
      if (gameState.getTurn() != Turn.OPPONENT_TURN)
      {
         return;
      }
      
      boolean moveDone = moveCar(gameState.getBoard(), handle); 

      if (moveDone)
      {
         gameState.setTurn(Turn.MY_TURN);
      }

      game.applyAndMarkMuCondition(gameState);
   }

   
   private boolean moveCar(EObject root, EObject handle)
   {
      RoadMap roadMap = (RoadMap) root;
      Car car = (Car) handle;

      // red light?
      Signal signal = car.getTrack().getSignal();
      
      if (signal != null && !signal.isPass())
      {
         return false;
      }

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
      {
         return false;
      }
      
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
      {
         return false;
      }

      car.setTrack(newPos);
      
      return true;
   }

   private Collection<EObject> gameGetCars(EObject g)
   {
      GameState game = (GameState) g;
      
      if (game.getTurn() != Turn.OPPONENT_TURN)
      {
         return new ArrayList<EObject>();
      }
      
      return getCars(game.getBoard());
   }

      

   private EList getCars(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;

      return roadMap.getCars();
   }
}
