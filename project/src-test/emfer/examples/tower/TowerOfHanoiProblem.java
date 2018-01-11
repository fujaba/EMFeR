package emfer.examples.tower;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;
import org.junit.Assert;
import org.junit.Test;

import emfer.EMFeR;

public class TowerOfHanoiProblem
{
   @Test
   public void testTowerOfHanoiProblem() throws Exception
   {
      runWithNumberOfDiscs(7, false);
      runWithNumberOfDiscs(7, true);
   }


   private void runWithNumberOfDiscs(int discs, boolean staticDiscs)
   {
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
      Logger.getGlobal().info("Exploring scenario with "
         + discs
         + " discs took "
         + (System.currentTimeMillis() - time) / 1000f
         + " seconds. "
         + size
         + " states in reachability graph. Discs are static: "
         + staticDiscs);

      Assert.assertEquals("Number of states:", (int) Math.pow(3, discs), size);
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

      // get the target stack
      Stack targetStack = null;
      Stack currentStack = null;

      for (Stack s : ((Board) root).getStacks())
      {
         if (s.getPosition().equals(stackName))
         {
            targetStack = s;
         }
         if (s.getDiscs().contains(disc))
         {
            currentStack = s;
         }
         if (targetStack != null && currentStack != null)
         {
            break;
         }
      }

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
