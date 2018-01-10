package emfer.examples.tower;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;
import org.junit.Assert;
import org.junit.Test;

import emfer.EMFeR;
import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;
import emfer.stories.Storyboard;

public class TowerOfHanoiProblem
{
   @Test
   public void testTowerOfHanoiProblem() throws Exception
   {
      runWithNumberOfDiscs(3);
      runWithNumberOfDiscs(4);
      runWithNumberOfDiscs(5);
      runWithNumberOfDiscs(6);
      runWithNumberOfDiscs(7);
   }


   private void runWithNumberOfDiscs(int discs)
   {
      Storyboard story = new Storyboard("TowerOfHanoi");

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

      Logger.getGlobal().info(board.toString());

      EMFeR emfer = new EMFeR()
         .withEPackage(TowerPackage.eINSTANCE)
         .withTrafo("move disc to A", root -> getSmallestDiscs(root), (root, disc) -> moveDisc(root, disc, "A"))
         .withTrafo("move disc to B", root -> getSmallestDiscs(root), (root, disc) -> moveDisc(root, disc, "B"))
         .withTrafo("move disc to C", root -> getSmallestDiscs(root), (root, disc) -> moveDisc(root, disc, "C"))
         .withStart(board);

      int size = emfer.explore();

      Assert.assertEquals("Number of states:", (int) Math.pow(3, discs), size);

      for (ReachableState s : emfer.getReachabilityGraph().getStates())
      {
         StringBuilder buf = new StringBuilder();

         for (TrafoApplication t : s.getResultOf())
         {
            ReachableState src = t.getSrc();

            buf.append(src.getNumber()).append(" --").append(t.getDescription()).append("-> ").append(s.getNumber()).append("\n");
         }

         buf.append(s.getRoot().toString());

         for (TrafoApplication t : s.getTrafoApplications())
         {
            ReachableState tgt = t.getTgt();

            buf.append(s.getNumber()).append(" --").append(t.getDescription()).append("-> ").append(tgt.getNumber()).append("\n");
         }

         Logger.getGlobal().info(buf.toString());
      }

      story.dumpHtml();
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

      Stack stack = null;

      for (Stack s : ((Board) root).getStacks())
      {
         if (s.getPosition().equals(stackName))
         {
            stack = s;
            break;
         }
      }

      Disc disc = (Disc) handle;

      if (stack != disc.getAt())
      {
         boolean smallerDisc = false;
         for (Disc d : stack.getDiscs())
         {
            if (d.getSize() < disc.getSize())
            {
               smallerDisc = true;
            }
         }
         if (!smallerDisc)
         {
            stack.getDiscs().add(disc);
         }
      }
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
