package emfer.examples.roadwork;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.junit.Assert;
import org.junit.Test;

import emfer.EMFeR;
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
      easternSignal.setTrack(north6);

      westernSignal.setPass(false);
      easternSignal.setPass(false); 

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

      
      String text = roadMap.toString();
      
      Logger.getGlobal().info(text);
      
      EMFeR emfer = new EMFeR()
            .withEPackage(FerrymanPackage.eINSTANCE)
            .withTrafo("load cargo", root -> getCars(root), (root, car) -> moveCar(root, car))
            .withStart(roadMap)
            .withStatic(road, road.getTracks())
            ;
      
      int size = emfer.explore();
      
      Assert.assertEquals("Number of states:", 7, size);
      
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
      
   
      story.dumpHtml();
   }

   private void moveCar(EObject root, EObject handle)
   {
      RoadMap roadMap = (RoadMap) root;
      Car car = (Car) handle;
      
      Track pos = car.getTrack();
      EList<Track> targets;
      
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
         
      car.setTrack(newPos);
      
      return;
   }

   private EList getCars(EObject root)
   {
      RoadMap roadMap = (RoadMap) root;
      
      return roadMap.getCars();
   }
}
