package emfer.examples.roadwork;

import static emfer.examples.roadwork.TravelDirection.EAST;
import static emfer.examples.roadwork.TravelDirection.UNDEFINED;
import static emfer.examples.roadwork.TravelDirection.WEST;

import java.util.HashMap;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.junit.Test;

import emfer.EMFeR;
import emfer.SyntheticControl;
import emfer.reachability.ReachabilityGraph;
import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;
import emfer.stories.Storyboard;

public class RoadWorkProblemSimStep
{
   @Test
   public void testManyCarsRoadWorkProblem() throws Exception
   {
      Storyboard story = new Storyboard("MultiCarRoadWorkProblemSimulatedStep");

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

      EMFeR emfer = new EMFeR()
         .withTrafo("simulation step", root -> simulationStep(root))
         .withTrafo("swap western signal", root -> swapSignal(root, WEST))
         .withTrafo("swap eastern signal", root -> swapSignal(root, EAST))
         .withStart(roadMap);

      int size = emfer.explore();

      applyMetric(emfer.getReachabilityGraph());

      // printReachableStatesList(emfer);

      // story.addReachableState(emfer.getReachabilityGraph().getStates().get(0), "Start Model");

      // story.addReachabilityGraph(emfer.getReachabilityGraph());

      SyntheticControl syntheticControl = new SyntheticControl(emfer)
         .withTrafo("swap western signal", root -> swapSignal(root, WEST))
         .withTrafo("swap eastern signal", root -> swapSignal(root, EAST));

      EMFeR emfer2 = new EMFeR()
         .withTrafo("simulation step", root -> simulationStep(root))
         .withTrafo("synthetic control", root -> syntheticControl.run(root), 0)
         .withStart(roadMap);

      int size2 = emfer2.explore();

      story.addReachabilityGraph(emfer2.getReachabilityGraph());

      Logger.getGlobal().info("Emfer 2 size " + size2);

      printReachableStatesList(emfer2);

      story.dumpHtml();
   }


   private void applyMetric(ReachabilityGraph reachabilityGraph)
   {
      for (ReachableState s : reachabilityGraph.getStates())
      {
         RoadMap roadMap = (RoadMap) s.getRoot();

         int newMetricValue = 0;

         if (isDangerous(s))
         {
            newMetricValue = Integer.MAX_VALUE;
         }
         else
         {
            Signal westernSignal = roadMap.getWesternSignal();
            Signal easternSignal = roadMap.getEasternSignal();

            Car westernCar = westernSignal.getTrack().getCar();
            Car easternCar = easternSignal.getTrack().getCar();

            if (westernSignal.isPass() && westernCar == null)
               newMetricValue++;

            if (!westernSignal.isPass() && westernCar != null)
               newMetricValue += 3;

            if (westernSignal.isPass() && roadMap.getLastDirection() == EAST)
               newMetricValue++;

            if (easternSignal.isPass() && easternCar == null)
               newMetricValue++;

            if (!easternSignal.isPass() && easternCar != null)
               newMetricValue += 3;

            if (easternSignal.isPass() && roadMap.getLastDirection() == WEST)
               newMetricValue++;

            if (easternSignal.isPass() && roadMap.getLastDirection() == WEST &&
               westernCar != null)
               newMetricValue += 3;

            if (westernSignal.isPass() && roadMap.getLastDirection() == EAST &&
               easternCar != null)
               newMetricValue += 3;
         }

         s.setMetricValue(newMetricValue);
      }
   }


   private void swapSignal(EObject root, TravelDirection signalPos)
   {
      RoadMap roadMap = (RoadMap) root;
      Signal signal = roadMap.getWesternSignal();
      if (signalPos == EAST)
      {
         signal = roadMap.getEasternSignal();
      }
      signal.setPass(!signal.isPass());
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

      String text = roadMap.toString();

      Logger.getGlobal().info(text);
      return roadMap;
   }


   private void printReachableStatesList(EMFeR emfer)
   {
      for (ReachableState s : emfer.getReachabilityGraph().getStates())
      {
         StringBuilder buf = new StringBuilder();

         for (TrafoApplication t : s.getResultOf())
         {
            ReachableState src = t.getSrc();

            buf.append("\n").append(src.getNumber()).append(" --").append(t.getDescription()).append("-> ").append(s.getNumber());
         }

         buf.append("\n").append(s.getMetricValue());
         buf.append(s.getRoot().toString());

         for (TrafoApplication t : s.getTrafoApplications())
         {
            ReachableState tgt = t.getTgt();

            buf.append(s.getNumber()).append(" --").append(t.getDescription()).append("-> ").append(tgt.getNumber())
               .append(" ").append(tgt.getMetricValue()).append("\n");
         }

         Logger.getGlobal().info(buf.toString());
      }
   }


   private boolean isDangerous(ReachableState s)
   {
      RoadMap roadMap = (RoadMap) s.getRoot();

      int westCount = 0;
      int eastCount = 0;
      for (Car c : roadMap.getCars())
      {
         if (c.getTrack().getTravelDirection() == UNDEFINED)
         {
            if (c.getTravelDirection() == WEST)
               westCount++;
            if (c.getTravelDirection() == EAST)
               eastCount++;
         }
      }
      if (roadMap.getWesternSignal().isPass() && roadMap.getWesternSignal().getTrack().getCar() != null)
         eastCount++;
      if (roadMap.getEasternSignal().isPass() && roadMap.getEasternSignal().getTrack().getCar() != null)
         westCount++;

      return westCount > 0 && eastCount > 0;
   }


   private void simulationStep(EObject root)
   {
      EList<Car> cars = getCars(root);
      HashMap<Car, Boolean> carHasMovedMap = new HashMap<Car, Boolean>();
      // TODO: smarter way to move cars in a row than trying so often
      for (int i = 0; i < 7; i++)
      {
         for (Car car : cars)
         {
            if (carHasMovedMap.get(car) == null || carHasMovedMap.get(car) == false)
            {
               Track currTrack = car.getTrack();
               moveCar(root, car);
               if (car.getTrack() != currTrack)
               {
                  carHasMovedMap.put(car, true);
               }
               else
               {
                  carHasMovedMap.put(car, false);
               }
            }
         }
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


   private EList<Car> getCars(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;

      return roadMap.getCars();
   }
}
