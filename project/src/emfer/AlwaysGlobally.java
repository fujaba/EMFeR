package emfer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;

public class AlwaysGlobally
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
      if ( ! phi.test(startState))
      {
         // counter example found
         return counterExamplePath;
      }
      
      done.add(startState);

      for (TrafoApplication t : startState.getTrafoApplications())
      {
         if ( ! done.contains(t.getTgt()))
         {
            counterExamplePath.add(t);
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
