package emfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;

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
      
      if (currentState == null)
      {
         // ups
         return;
      }
         
      
      
      // choose best operation
      double worstMetricValue = currentState.getMetricValue();
      double bestMyValue = currentState.getMetricValue();
      TrafoApplication bestTrafoApp = null;
      
      for (TrafoApplication trafoApp : currentState.getTrafoApplications())
      {
         if (pathTrafoMap.get(trafoApp.getDescription()) != null)
         {
            // control it
            if (trafoApp.getTgt().getMetricValue() < bestMyValue)
            {
               bestTrafoApp = trafoApp;
            }
         }
         //         else
         //         {
         //            // uncontrolled simulation step
         //            double tgtMetricValue = trafoApp.getTgt().getMetricValue();
         //            
         //            if (tgtMetricValue > worstMetricValue)
         //            {
         //               
         //            }
         //            
         //         }
      }
      
      // run it
      if (bestTrafoApp != null)
      {
         PathTrafo pathTrafo = pathTrafoMap.get(bestTrafoApp.getDescription());
         
         pathTrafo.trafo.run(root, root);
      }
   }

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

}
