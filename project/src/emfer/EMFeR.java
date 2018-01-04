package emfer;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import emfer.EMFeR.PathTrafo;
import emfer.examples.ferryman.Cargo;
import emfer.examples.ferryman.River;
import emfer.reachability.ReachabilityFactory;
import emfer.reachability.ReachabilityGraph;
import emfer.reachability.ReachableState;


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
   


   public EMFeR withTrafo(String string, Path path, Trafo2 trafo)
   {
      PathTrafo pathTrafo = new PathTrafo()
            .withName(string)
            .withPath(path)
            .withTrafo(trafo);
      
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

   public EMFeR withStart(EObject root)
   {
      ReachableState state = ReachabilityFactory.eINSTANCE.createReachableState();
      
      state.setRoot(root);
      
      reachabilityGraph.getStates().add(state);
      
      return this;
   }

   private Set<EObject> staticNodes = new LinkedHashSet<EObject>();

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



   public void explore()
   {
      
   }

}
