package emfer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;

public class ExistsFinally
{

   private ArrayList<TrafoApplication> examplePath;

   public ArrayList<TrafoApplication> getExamplePath()
   {
      return examplePath;
   }


   public boolean test(ReachableState startState, Predicate<ReachableState> phi)
   {
      examplePath = new ArrayList<TrafoApplication>();
      
      // phi must hold for every state reachable from startState
      Set<ReachableState> done = new HashSet<ReachableState>();

      examplePath = test(startState, phi, done);
    
      return examplePath != null;
   }



   private ArrayList<TrafoApplication> test(ReachableState startState, Predicate<ReachableState> phi, Set<ReachableState> done)
   {
      if (phi.test(startState))
      {
         // this path reaches phi
         return examplePath;
      }
      
      done.add(startState);

      for (TrafoApplication t : startState.getTrafoApplications())
      {
         if (done.contains(t.getTgt()))
         {
            continue;
         }
         
         examplePath.add(t);

         // go on 
         ArrayList<TrafoApplication> newPath = test(t.getTgt(), phi, done);

         if (newPath != null)
         {
            return newPath;
         }
            
         examplePath.remove(examplePath.size()-1);
      }
      
      return null;
   }



}
