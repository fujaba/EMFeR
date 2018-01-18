package emfer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;

public class AlwaysUntil
{

   private ArrayList<TrafoApplication> counterExamplePath;

   public ArrayList<TrafoApplication> getCounterExamplePath()
   {
      return counterExamplePath;
   }


   public boolean test(ReachableState startState, Predicate<ReachableState> phi, Predicate<ReachableState> psi)
   {
      counterExamplePath = new ArrayList<TrafoApplication>();
      
      // phi must hold for every state reachable from startState
      Set<ReachableState> done = new HashSet<ReachableState>();
      Set<ReachableState> successStates = new HashSet<ReachableState>();

      counterExamplePath = test(startState, phi, psi, done, successStates);
    
      return counterExamplePath == null;
   }



   private ArrayList<TrafoApplication> test(ReachableState startState, Predicate<ReachableState> phi, Predicate<ReachableState> psi, 
         Set<ReachableState> done, Set<ReachableState> successStates)
   {
      if (psi.test(startState))
      {
         // this path reaches psi
         successStates.add(startState);
         return null;
      }
      
      if ( ! phi.test(startState))
      {
         return counterExamplePath;
      }
      
      done.add(startState);
      
      if (startState.getTrafoApplications().size() == 0)
      {
         // can not reach psi
         return counterExamplePath;
      }

      for (TrafoApplication t : startState.getTrafoApplications())
      {
         counterExamplePath.add(t);
         
         if (successStates.contains(t.getTgt()))
         {
            continue;
         }

         if (done.contains(t.getTgt()))
         {
            // we may cycle for ever, not reaching psi
            return counterExamplePath;
         }
         else
         {
            // go on 
            ArrayList<TrafoApplication> newPath = test(t.getTgt(), phi, psi, done, successStates);

            if (newPath != null)
            {
               return newPath;
            }
            
            counterExamplePath.remove(counterExamplePath.size()-1);
         }
      }
      
      successStates.add(startState);
      
      // it works always
      return null;
   }



}
