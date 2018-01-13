package emfer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;

public class AlwaysFinally
{

   private ArrayList<TrafoApplication> counterExamplePath;

   public ArrayList<TrafoApplication> getCounterExamplePath()
   {
      return counterExamplePath;
   }


   public boolean test(ReachableState startState, Predicate<ReachableState> phi)
   {
      counterExamplePath = new ArrayList<TrafoApplication>();
      
      // phi must hold for every state reachable from startState
      Set<ReachableState> done = new HashSet<ReachableState>();

      counterExamplePath = test(startState, phi, done);
    
      return counterExamplePath == null;
   }



   private ArrayList<TrafoApplication> test(ReachableState startState, Predicate<ReachableState> phi, Set<ReachableState> done)
   {
      if (phi.test(startState))
      {
         // this path reaches phi
         return null;
      }
      
      done.add(startState);

      for (TrafoApplication t : startState.getTrafoApplications())
      {
         counterExamplePath.add(t);

         if (done.contains(t.getTgt()))
         {
            // we may cycle for ever, not reaching phi
            return counterExamplePath;
         }
         else
         {
            // go on 
            ArrayList<TrafoApplication> newPath = test(t.getTgt(), phi, done);

            if (newPath != null)
            {
               return newPath;
            }
            
            counterExamplePath.remove(counterExamplePath.size()-1);
         }
      }
      
      return null;
   }



}
