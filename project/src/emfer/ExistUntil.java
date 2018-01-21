package emfer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;

public class ExistUntil
{

   private ArrayList<TrafoApplication> examplePath;

   public ArrayList<TrafoApplication> getExamplePath()
   {
      return examplePath;
   }


   public boolean test(ReachableState startState, Predicate<ReachableState> phi, Predicate<ReachableState> psi)
   {
      examplePath = new ArrayList<TrafoApplication>();
      
      // phi must hold for every state reachable from startState
      Set<ReachableState> done = new HashSet<ReachableState>();
      Set<ReachableState> failStates = new HashSet<ReachableState>();

      examplePath = test(startState, phi, psi, done, failStates);
    
      return examplePath != null;
   }



   private ArrayList<TrafoApplication> test(ReachableState startState, Predicate<ReachableState> phi, Predicate<ReachableState> psi, 
         Set<ReachableState> done, Set<ReachableState> failStates)
   {
      if (psi.test(startState))
      {
         // yep
         return examplePath;
      }
      
      if ( ! phi.test(startState))
      {
         // counter example found
         return null;
      }
      
      done.add(startState);
      
      if (startState.getTrafoApplications().isEmpty())
      {
         // we do not reach psi
         return null;
      }

      for (TrafoApplication t : startState.getTrafoApplications())
      {
         examplePath.add(t);

         if ( done.contains(t.getTgt()))
         {
            if (failStates.contains(t.getTgt()))
            {
               return null;
            }
            else
            {
               // reaching a cycling state without hitting psi
               return null;
            }
         }
         
         ArrayList<TrafoApplication> newPath = test(t.getTgt(), phi, psi, done, failStates);

         if (newPath != null)
         {
            return newPath;
         }
            
         examplePath.remove(examplePath.size()-1);
      }
      
      failStates.add(startState);
      
      return null;
   }



}
