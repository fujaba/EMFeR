package emfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import emfer.EMFeR.PathTrafo;
import emfer.ModelIsomorphismOp.CertInfo;
import emfer.examples.ferryman.Cargo;
import emfer.examples.ferryman.River;
import emfer.reachability.ReachabilityFactory;
import emfer.reachability.ReachabilityGraph;
import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;


public class EMFeR
{
   private EPackage ePackage = null;
   
   public EMFeR withEPackage(EPackage einstance)
   {
      ePackage = einstance;
      
      return this;
   }
   
   
   @FunctionalInterface
   public interface Path
   {
      public Set<EObject> run(EObject root);
   }

   @FunctionalInterface
   public interface Trafo
   {
      public void run(EObject root);
   }
   
   @FunctionalInterface
   public interface Trafo2
   {
      public void run(EObject root, EObject handle);
   }
   
   public static class PathTrafo
   {
      public String name;
      public Path path;
      public Trafo2 trafo;
      
      public PathTrafo withName(String name)
      {
         this.name = name;

         return this;
      }

      public PathTrafo withPath(Path path)
      {
         this.path = path;

         return this;
      }
      
      public PathTrafo withTrafo(Trafo2 trafo)
      {
         this.trafo = trafo;

         return this;
      }
   }
   
   private ArrayList<PathTrafo> pathTrafosList = new ArrayList<PathTrafo>();
   


   public EMFeR withTrafo(String string, Path path, Trafo2 trafo)
   {
      PathTrafo pathTrafo = new PathTrafo()
            .withName(string)
            .withPath(path)
            .withTrafo(trafo);
      
      pathTrafosList.add(pathTrafo);
      
      return this;
   }



   public EMFeR withTrafo(String string, Trafo trafo)
   {
      withTrafo(string, 
         root -> {LinkedHashSet<EObject> result = new LinkedHashSet<EObject>(); result.add(root); return result;}, 
         (root, handle) -> trafo.run(root));
      
      return this;
   }

   private ReachabilityGraph reachabilityGraph = ReachabilityFactory.eINSTANCE.createReachabilityGraph();

   public ReachabilityGraph getReachabilityGraph()
   {
      return reachabilityGraph;
   }
   
   public EMFeR withStart(EObject root)
   {
      ReachableState state = ReachabilityFactory.eINSTANCE.createReachableState();
      
      state.setRoot(root);
      
      reachabilityGraph.getStates().add(state);
      
      return this;
   }

   private Set<EObject> staticNodes = new LinkedHashSet<EObject>();

   private CertInfo staticCertInfo;
   
   public EMFeR withStatic(Object... items)
   {
      for (Object i : items)
      {
         if (i instanceof Collection)
         {
            for (Object o : (Collection) i)
            {
               staticNodes.add((EObject) o);
            }
         }
         else if (i instanceof EObject)
         {
            staticNodes.add((EObject) i);
         }
      }
      return this;
   }

   private Map<String, ArrayList<ReachableState>> cert2StateListMap = new HashMap<String, ArrayList<ReachableState>>();
   
   private void put2Cert2StateListMap(String cert, ReachableState newState)
   {
      ArrayList<ReachableState> arrayList = cert2StateListMap.get(cert);
      
      if (arrayList == null)
      {
         arrayList = new ArrayList<ReachableState>();
         cert2StateListMap.put(cert, arrayList);
      }
     
      arrayList.add(newState);
   }
   
   private ModelIsomorphismOp isoOp = new ModelIsomorphismOp();

   @FunctionalInterface
   public interface Metric
   {
      public double compute(EObject graphRoot);
   }
   
   private Metric metric = null;
   
   public EMFeR withMetric(Metric newMetric)
   {
      this.metric = newMetric;
      
      return this;
   }
   
   private BlockingQueue<ReachableState> todo = null;

   


   public BlockingQueue<ReachableState> getTodo()
   {
      if (this.todo == null)
      {
         if (metric != null)
         {
            this.todo = new PriorityBlockingQueue<ReachableState>(11, (s1, s2) -> Double.compare(s2.getMetricValue(), s1.getMetricValue()));
         }
         else
         {
            this.todo = new LinkedBlockingQueue<>();
         }
      }

      return this.todo;
   }


   public boolean addToTodo(ReachableState value)
   {
      boolean changed = false;

      if (value != null)
      {
         if (this.todo == null)
         {
            if (metric != null)
            {
               this.todo = new PriorityBlockingQueue<ReachableState>(11, (s1, s2) -> Double.compare(s2.getMetricValue(), s1.getMetricValue()));
            }
            else
            {
               this.todo = new LinkedBlockingQueue<>();
            }
         }

         changed = this.todo.offer(value);
      }

      return changed;
   }


   public boolean removeFromTodo(ReachableState value)
   {
      boolean changed = false;

      if ((this.todo != null) && (value != null))
      {
         changed = this.todo.remove(value);
      }

      return changed;
   }
   
   private int maxNoOfNewStates = 300*1000;
   
   public EMFeR withMaxNoOfNewStates(int newMax)
   {
      maxNoOfNewStates = newMax;
      
      return this;
   }
   
   public int explore()
   {
      // compute certificates for staticNodes
      CertInfo emptyCertInfo = new CertInfo();
      
      isoOp.aggregate(staticNodes, emptyCertInfo);
      
      staticCertInfo = isoOp.computeCertificate(staticNodes, emptyCertInfo);
      
      // compute cert for start state and add to map and to todo
      ReachableState startState = reachabilityGraph.getStates().get(0);
      
      startState.setNumber(1);

      CertInfo certInfo = isoOp.computeCertificate(startState.getRoot(), staticCertInfo);
      
      put2Cert2StateListMap(certInfo.getCertificate(), startState);
      
      if (metric != null)
      {
         double metricValue = metric.compute(startState.getRoot());
         startState.setMetricValue(metricValue);
      }
      
      addToTodo(startState);
      
      // apply trafos
      doToDo: while (!getTodo().isEmpty() && this.reachabilityGraph.getStates().size() <= maxNoOfNewStates)
      {
         ReachableState current = null;
         
         try
         {
            current = getTodo().take();
         }
         catch (InterruptedException e)
         {
            // retry
            continue;
         }

         exploreTrafos(current);
         
      }  // while todo
      
      return reachabilityGraph.getStates().size();
   }
   
   private LazyCloneOp lazyCloneOp = new LazyCloneOp();
   
   private void exploreTrafos(ReachableState current)
   {
      // prepare 
      Set<EObject> dynNodes = new LinkedHashSet<EObject>();

      ArrayList<Object> dynEdges = new ArrayList<Object>();

      dynNodes.add(current.getRoot());
      
      isoOp.aggregate(dynNodes, staticCertInfo);
      
      lazyCloneOp.reset();
      
      // subscribe to model changes
      // current.getRoot().eAdapters().add(lazyCloneOp);
      for (EObject o : dynNodes)
      {
         o.eAdapters().add(lazyCloneOp);
      }
      
      
      
      // run trafos
      for (PathTrafo pathTrafo : this.pathTrafosList)
      {
         Set<EObject> handles = pathTrafo.path.run(current.getRoot());

         String trafoName = pathTrafo.name;

         Trafo2 trafo = pathTrafo.trafo;

         for (EObject h : handles)
         {
            Object newRoot = null;
            ReachableState newReachableState = null;

            lazyCloneOp.reset();

            
            lazyCloneOp.enableChangeRecording = true;

            // apply trafo
            trafo.run(current.getRoot(), h);

            // unsubscribe from dyn nodes
            lazyCloneOp.enableChangeRecording = false;
            // current.getRoot().eAdapters().remove(lazyCloneOp);

            newReachableState = lazyCloneOp.transferChangesToClone(current, dynNodes, staticCertInfo);

            if (newReachableState == null)
            {
               continue;
            }

            // merge with old states
            CertInfo newCertInfo = isoOp.computeCertificate(newReachableState.getRoot(), staticCertInfo);

            // already known? 
            ArrayList<ReachableState> candidateStates = this.cert2StateListMap.get(newCertInfo.getCertificate());
            

            Object match = null;

            if (candidateStates != null)
            {
               for (ReachableState oldState : candidateStates)
               {
                  match = isoOp.lazyMatch(oldState, newReachableState, staticCertInfo);

                  if (match != null)
                  {
                     // newReachableState is isomorphic to oldState. Just add a
                     // link from first to oldState
                     if (current == oldState)
                     {
                        // trafo did not change the current state, do not create a rule application link
                     }
                     else
                     {
                        TrafoApplication newTrafoApp = ReachabilityFactory.eINSTANCE.createTrafoApplication();
                        newTrafoApp.setSrc(current);
                        newTrafoApp.setTgt(oldState);
                        newTrafoApp.setDescription(trafoName);
                        reachabilityGraph.getTrafoApplications().add(newTrafoApp);
                     }

                     break;
                  }
               }
            }

            if (match == null)
            {
               // new state is really new
               if (metric != null)
               {
                  double metricValue = metric.compute(newReachableState);
                  newReachableState.setMetricValue(metricValue);
               }
               
               addToTodo(newReachableState);
               put2Cert2StateListMap(newCertInfo.getCertificate(), newReachableState);

               reachabilityGraph.getStates().add(newReachableState);
               newReachableState.setNumber(reachabilityGraph.getStates().size());
               
               TrafoApplication newTrafoApp = ReachabilityFactory.eINSTANCE.createTrafoApplication();
               newTrafoApp.setSrc(current);
               newTrafoApp.setTgt(newReachableState);
               newTrafoApp.setDescription(trafoName);
               reachabilityGraph.getTrafoApplications().add(newTrafoApp);
            }
         }
      }
      
      // remove change listener
      for (EObject o : dynNodes)
      {
         o.eAdapters().remove(lazyCloneOp);
      }
   }



   private Object lazyMatch(ReachableState oldState, ReachableState newReachableState)
   {
      // TODO Auto-generated method stub
      return null;
   }


}
