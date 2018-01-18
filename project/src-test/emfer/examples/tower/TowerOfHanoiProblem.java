package emfer.examples.tower;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;
import org.junit.Assert;
import org.junit.Test;

import emfer.EMFeR;
import emfer.reachability.ReachableState;

public class TowerOfHanoiProblem
{
   private int discs;


   @Test
   public void testTowerOfHanoiProblem3StaticDiscs() throws Exception
   {
      runWithNumberOfDiscs(3, true);
   }


   @Test
   public void testTowerOfHanoiProblem3NonStaticDiscs() throws Exception
   {
      runWithNumberOfDiscs(3, false);
   }


   @Test
   public void testTowerOfHanoiProblem5StaticDiscs() throws Exception
   {
      runWithNumberOfDiscs(5, true);
   }


   @Test
   public void testTowerOfHanoiProblem7StaticDiscs() throws Exception
   {
      runWithNumberOfDiscs(7, true);
   }


   private void runWithNumberOfDiscs(int discs, boolean staticDiscs)
   {
      this.discs = discs;
      TowerFactory factory = TowerFactory.eINSTANCE;

      Board board = factory.createBoard();

      Stack start = factory.createStack();
      start.setPosition("A");

      Stack middle = factory.createStack();
      middle.setPosition("B");

      Stack target = factory.createStack();
      target.setPosition("C");

      for (int i = 0; i < discs; i++)
      {
         Disc d = factory.createDisc();
         d.setSize(i);
         start.getDiscs().add(d);
      }

      board.getStacks().add(start);
      board.getStacks().add(middle);
      board.getStacks().add(target);

      EMFeR emfer = new EMFeR()
         .withEPackage(TowerPackage.eINSTANCE)
         .withTrafo("move disc to A", root -> getSmallestDiscs(root), (root, disc) -> moveDisc(root, disc, "A"))
         .withTrafo("move disc to B", root -> getSmallestDiscs(root), (root, disc) -> moveDisc(root, disc, "B"))
         .withTrafo("move disc to C", root -> getSmallestDiscs(root), (root, disc) -> moveDisc(root, disc, "C"))
         .withMaxNoOfNewStates(10000000)
         .withStart(board);

      if (staticDiscs)
      {
         emfer.withStatic(start.getDiscs());
      }

      long time = System.currentTimeMillis();
      int size = emfer.explore();
      float duration = (System.currentTimeMillis() - time) / 1000f;

      emfer.computeDistancesTo(s -> isFinalState(s));

      Logger.getGlobal().info("\nExploring scenario with "
         + discs
         + (staticDiscs ? "" : " static")
         + " discs took "
         + duration
         + " seconds.\n"
         + size
         + " states in reachability graph."
         + "\nShortest path is "
         + emfer.shortestPath(emfer.getReachabilityGraph().getStates().get(0)).size()
         + " steps long.");

      float shortestPathSum = 0;

      for (ReachableState targetState : emfer.getReachabilityGraph().getStates())
      {
         emfer.computeDistancesTo(targetState);
         for (ReachableState s : emfer.getReachabilityGraph().getStates())
         {
            int currentShortestPath = emfer.shortestPath(s).size();
            shortestPathSum += currentShortestPath;
         }
         shortestPathSum = shortestPathSum / size;
      }

      float mathShortestPathSum = (float) (((466f / 885f) * Math.pow(2, discs))
         - (1f / 3f)
         - ((3f / 5f) * Math.pow((1f / 3f), discs))
         + ((12f / 59f) + (18f / 1003f) * Math.sqrt(17))
            * Math.pow(((5f + Math.sqrt(17)) / 18f), discs)
         + ((12f / 59f) - (18f / 1003f) * Math.sqrt(17))
            * Math.pow(((5 - Math.sqrt(17)) / 18f), discs));

      Assert.assertEquals("Number of states computed does not match calculated number", (int) Math.pow(3, discs), size);
      Assert.assertEquals("Number of average transitions between two states computed does not match calculated number", mathShortestPathSum, shortestPathSum, 0.1f);
   }


   private boolean isFinalState(ReachableState s)
   {
      EObject root = s.getRoot();
      Board b = (Board) root;
      Stack stack = getStackByName("C", b);

      if (stack.getDiscs().size() == discs)
      {
         return true;
      }
      return false;
   }


   private Stack getStackByName(String stackName, Board b)
   {
      for (Stack s : b.getStacks())
      {
         if (s.getPosition().equals(stackName))
         {
            return s;
         }
      }
      return null;
   }


   private Stack getStackByDisc(Disc disc, Board board)
   {
      for (Stack s : board.getStacks())
      {
         if (s.getDiscs().contains(disc))
         {
            return s;
         }
      }
      return null;
   }


   private void moveDisc(EObject root, EObject handle, String stackName)
   {
      if (root == null
         || handle == null
         || !(root instanceof Board)
         || !(handle instanceof Disc))
      {
         return;
      }

      // disc to be moved
      Disc disc = (Disc) handle;
      Board board = (Board) root;

      // get the target stack
      Stack targetStack = getStackByName(stackName, board);
      Stack currentStack = getStackByDisc(disc, board);

      for (Disc d : targetStack.getDiscs())
      {
         if (d.getSize() <= disc.getSize())
         {
            return;
         }
      }
      currentStack.getDiscs().remove(disc);
      targetStack.getDiscs().add(disc);
      return;
   }


   private Set<EObject> getSmallestDiscs(EObject root)
   {
      if (!(root instanceof Board))
      {
         return null;
      }

      Board board = (Board) root;

      Set<EObject> smallestDiscs = new LinkedHashSet<EObject>();

      for (Stack s : board.getStacks())
      {
         Disc smallestDisc = null;
         for (Disc d : s.getDiscs())
         {
            if (smallestDisc == null || smallestDisc.getSize() > d.getSize())
            {
               smallestDisc = d;
            }
         }
         if (smallestDisc != null)
         {
            smallestDiscs.add(smallestDisc);
         }
      }

      return smallestDiscs;
   }
}
