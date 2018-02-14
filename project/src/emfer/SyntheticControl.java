package emfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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

   private Set<String> trafoNameSet = new LinkedHashSet<String>();

   public SyntheticControl(EMFeR emfer)
   {
      this.emfer = emfer;
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
      
      for ( Function<EObject, Integer> m : metricsList)
      {
         int newCosts = m.apply(otherTargetState.getRoot());
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
      for(String trafoName : trafoNameSet)
      {
         if (trafoName.equals(trafoApp.getDescription()))
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

   public void run(EObject root)
   {
      // identify current state
      ReachableState currentState = findMatchingOldState(root);      
      
      if (currentState == null)
      {
         // ups
         return;
      }
               
      
      // choose best operation
      double bestMetricValue = currentState.getMetricValue();
      TrafoApplication bestTrafoApp = null;
      
      for (TrafoApplication trafoApp : currentState.getTrafoApplications())
      {
         if (emfer.getPathTrafosList(trafoApp.getDescription()) != null)
         {
            // control it
            if (trafoApp.getTgt().getMetricValue() < bestMetricValue)
            {
               bestTrafoApp = trafoApp;
               bestMetricValue = trafoApp.getTgt().getMetricValue();
            }
         }
      }
      
      // run it
      if (bestTrafoApp != null)
      {
         PathTrafo pathTrafo = emfer.getPathTrafosList(bestTrafoApp.getDescription());
         
         pathTrafo.trafo.run(root, root);
      }
   }

   public SyntheticControl withTrafo(String trafoName)
   {
      trafoNameSet.add(trafoName);

      return this;
   }

   private ArrayList<Function<EObject, Integer>> metricsList = new ArrayList<Function<EObject, Integer>>();
   
   public ArrayList<Function<EObject, Integer>> getMetricsList()
   {
      return metricsList;
   }
   
   public SyntheticControl withMetric(Function<EObject, Integer> metric)
   {
      metricsList.add(metric);
      
      return this;
   }

   public SyntheticControl applyMetric()
   {
      return applyMetric(emfer);
   }
   
   
   public SyntheticControl applyMetric(EMFeR myEmfer)
   {
      for (ReachableState s : myEmfer.getReachabilityGraph().getStates())
      {
         double localCosts = 0;
         
         for ( Function<EObject, Integer> m : metricsList)
         {
            int newCosts = m.apply(s.getRoot());
            localCosts += newCosts;
         }
         
         s.setMetricValue(localCosts);
      }
      
      return this;
   }

}
