package emfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;

import emfer.EMFeR.Path;
import emfer.EMFeR.PathTrafo;
import emfer.EMFeR.Trafo;
import emfer.EMFeR.Trafo2;
import emfer.ModelIsomorphismOp.CertInfo;
import emfer.reachability.ReachabilityFactory;
import emfer.reachability.ReachabilityGraph;
import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;

public class SyntheticControl
{


   private EMFeR emfer;
   private Map<String, PathTrafo> pathTrafoMap = new HashMap<String,PathTrafo>();

   public SyntheticControl(EMFeR emfer)
   {
      this.emfer = emfer;
   }

   public void run(EObject root)
   {
      ReachableState currentState = findMatchingOldState(root);
      
      double currentCosts = localCosts(currentState);
      
      if (currentState == null)
      {
         // ups
         return;
      }
         
      // for all states I can reach
      HashSet<ReachableState>  myTargetStates = findMyTargetStates(currentState);
      
      // choose best option
      ReachableState bestMyTarget = chooseBestMyTarget(myTargetStates);
      
      if (bestMyTarget == null || currentCosts <= localCosts(bestMyTarget))
      {
         return;
      }
      
      // run it
      emfer.computeDistancesTo(bestMyTarget);
      
      if (currentState.getMetricValue() == 0) 
      {
         return; // we are at target
      }
      
      TrafoApplication bestTrafo = null;
      double bestCosts = Double.MAX_VALUE;
      double bestDistance = Integer.MAX_VALUE;
      
      for (TrafoApplication trafoApp : currentState.getTrafoApplications())
      {
         if (isMyTrafo(trafoApp))
         {
            ReachableState nextState = trafoApp.getTgt();
            if (nextState.getMetricValue() == 0)
            {
               bestTrafo = trafoApp;
               localCosts(nextState);
               break;
            }
            
            if (nextState.getMetricValue() <= bestDistance)
            {
               bestDistance = nextState.getMetricValue();
               
               double localCosts = localCosts(nextState);
               
               if (localCosts < bestCosts)
               {
                  bestCosts = localCosts;
                  bestTrafo = trafoApp;
               }
            }
         }
      }
      
      // run the trafo
      PathTrafo pathTrafo = pathTrafoMap.get(bestTrafo.getDescription());
      pathTrafo.trafo.run(root, root);
   }

   private ReachableState chooseBestMyTarget(HashSet<ReachableState> myTargetStates)
   {
      double bestAverage = Double.MAX_VALUE;
      ReachableState bestMyTarget = null;
      
      for(ReachableState myTargetState : myTargetStates)
      {
         // for all states the others can reach
         HashSet<ReachableState>  otherTargetStates = findOtherTargetStates(myTargetState);
         
         // averageCosts of other states
         double costSum = localCosts(myTargetState);
         for (ReachableState otherTargetState : otherTargetStates)
         {
            double localCosts = localCosts(otherTargetState);
            costSum += localCosts;
         }
         
         double average = costSum / (otherTargetStates.size() + 1);
         
         if (average < bestAverage)
         {
            bestAverage = average;
            bestMyTarget = myTargetState;
         }
      }
      
      return bestMyTarget;
   }

   public double localCosts(ReachableState otherTargetState)
   {
      double localCosts = 0;
      
      for ( Function<ReachableState, Integer> m : metricsList)
      {
         int newCosts = m.apply(otherTargetState);
         localCosts += newCosts;
      }
      
      otherTargetState.setMetricValue(localCosts);
      
      return localCosts;
   }

   private HashSet<ReachableState> findOtherTargetStates(ReachableState myTargetState)
   {
      HashSet<ReachableState> otherTargetStates = new LinkedHashSet<ReachableState>();
      
      for(TrafoApplication trafoApp : myTargetState.getTrafoApplications())
      {
         if ( ! isMyTrafo(trafoApp))
         {
            if ( ! otherTargetStates.contains(trafoApp.getTgt()))
            {
               otherTargetStates.add(trafoApp.getTgt());
            }
         }
      }
      
      return otherTargetStates;
   }

   private HashSet<ReachableState> findMyTargetStates(ReachableState currentState)
   {
      HashSet<ReachableState> myTargetStates = new LinkedHashSet<ReachableState>();
      myTargetStates.add(currentState); // do nothing
      
      LinkedList<ReachableState>  todoStates = new LinkedList<ReachableState>();
      todoStates.add(currentState);

      while ( ! todoStates.isEmpty())
      {
         ReachableState oldState = todoStates.pollFirst();
         
         for(TrafoApplication trafoApp : oldState.getTrafoApplications())
         {
            if (isMyTrafo(trafoApp))
            {
               if ( ! myTargetStates.contains(trafoApp.getTgt()))
               {
                  myTargetStates.add(trafoApp.getTgt());
                  todoStates.add(trafoApp.getTgt());
               }
            }
         }
      }
      
      return myTargetStates;
   }

   private boolean isMyTrafo(TrafoApplication trafoApp)
   {
      boolean isMyTrafo = false;
      for( Entry<String, PathTrafo> e : pathTrafoMap.entrySet())
      {
         if (e.getKey().equals(trafoApp.getDescription()))
         {
            isMyTrafo = true;
            break;
         }
      }
      return isMyTrafo;
   }

   private ReachableState findMatchingOldState(EObject root)
   {
      // identify current state
      String certificate = emfer.computeCertificate(root);
      
      Map<String, ArrayList<ReachableState>> cert2StateListMap = emfer.getCert2StateListMap();
      
      ArrayList<ReachableState> candidateStates = cert2StateListMap.get(certificate);
      
      ReachableState newReachableState = ReachabilityFactory.eINSTANCE.createReachableState();
      newReachableState.setRoot(root);
      
      ReachableState currentState = null;
      
      for (ReachableState oldState : candidateStates)
      {
         Boolean match = emfer.getIsoOp().lazyMatch(oldState, newReachableState, emfer.getStaticCertInfo());

         if (match)
         {
            currentState = oldState;
            break;
         }
      }
      return currentState;
   }
   
   // private Integer currentCosts = 0;

//   public void run(EObject root)
//   {
//      // identify current state
//      String certificate = emfer.computeCertificate(root);
//      
//      Map<String, ArrayList<ReachableState>> cert2StateListMap = emfer.getCert2StateListMap();
//      
//      ArrayList<ReachableState> candidateStates = cert2StateListMap.get(certificate);
//      
//      ReachableState newReachableState = ReachabilityFactory.eINSTANCE.createReachableState();
//      newReachableState.setRoot(root);
//      
//      ReachableState currentState = null;
//      
//      for (ReachableState oldState : candidateStates)
//      {
//         Boolean match = emfer.getIsoOp().lazyMatch(oldState, newReachableState, emfer.getStaticCertInfo());
//
//         if (match)
//         {
//            currentState = oldState;
//            break;
//         }
//      }
//      
//      if (currentState == null)
//      {
//         // ups
//         return;
//      }
//         
//      
//      
//      // choose best operation
//      double worstMetricValue = currentState.getMetricValue();
//      double bestMyValue = currentState.getMetricValue();
//      TrafoApplication bestTrafoApp = null;
//      
//      for (TrafoApplication trafoApp : currentState.getTrafoApplications())
//      {
//         if (pathTrafoMap.get(trafoApp.getDescription()) != null)
//         {
//            // control it
//            if (trafoApp.getTgt().getMetricValue() < bestMyValue)
//            {
//               bestTrafoApp = trafoApp;
//            }
//         }
//         //         else
//         //         {
//         //            // uncontrolled simulation step
//         //            double tgtMetricValue = trafoApp.getTgt().getMetricValue();
//         //            
//         //            if (tgtMetricValue > worstMetricValue)
//         //            {
//         //               
//         //            }
//         //            
//         //         }
//      }
//      
//      // run it
//      if (bestTrafoApp != null)
//      {
//         PathTrafo pathTrafo = pathTrafoMap.get(bestTrafoApp.getDescription());
//         
//         pathTrafo.trafo.run(root, root);
//      }
//   }

   public SyntheticControl withTrafo(String trafoName, Trafo trafo)
   {
      withTrafo(trafoName,
         root -> {
            LinkedHashSet<EObject> result = new LinkedHashSet<EObject>();
            result.add(root);
            return result;
         },
         (root, handle) -> trafo.run(root));
      
      return this;
   }
   
   public SyntheticControl withTrafo(String trafoName, Path path, Trafo2 trafo)
   {
      PathTrafo pathTrafo = new PathTrafo()
         .withName(trafoName)
         .withPath(path)
         .withTrafo(trafo)
         .withPriority(Integer.MAX_VALUE);

      pathTrafoMap.put(trafoName, pathTrafo);

      return this;
   }

   private ArrayList<Function<ReachableState, Integer>> metricsList = new ArrayList<Function<ReachableState, Integer>>();
   
   public SyntheticControl withMetric(Function<ReachableState, Integer> metric)
   {
      metricsList.add(metric);
      
      return this;
   }

}
