package emfer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;

public class ExistsNext
{

   private ArrayList<TrafoApplication> examplePath;

   public ArrayList<TrafoApplication> getExamplePath()
   {
      return examplePath;
   }


   public boolean test(ReachableState startState, Predicate<ReachableState> phi)
   {
      examplePath = new ArrayList<TrafoApplication>();
      
      for (TrafoApplication t : startState.getTrafoApplications())
      {
         ReachableState nextState = t.getTgt();
         
         if (phi.test(nextState))
         {
            examplePath.add(t);
            
            return true;
         }
      }
      
      return false;
   }



}
