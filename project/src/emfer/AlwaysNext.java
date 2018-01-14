package emfer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;

public class AlwaysNext
{

   private ArrayList<TrafoApplication> counterExamplePath;

   public ArrayList<TrafoApplication> getCounterExamplePath()
   {
      return counterExamplePath;
   }


   public boolean test(ReachableState startState, Predicate<ReachableState> phi)
   {
      counterExamplePath = new ArrayList<TrafoApplication>();
      
      for (TrafoApplication t : startState.getTrafoApplications())
      {
         ReachableState nextState = t.getTgt();
         
         if (! phi.test(nextState))
         {
            counterExamplePath.add(t);
            
            return false;
         }
      }
      
      return true;
   }



}
