package emfer;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import emfer.EMFeR.PathTrafo;
import emfer.reachability.GameState;
import emfer.reachability.ReachabilityFactory;
import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;
import emfer.reachability.Turn;

public class GameControl
{
   private EMFeRGame game;


   public GameControl(EMFeRGame game)
   {
      this.game = game;
   }

   public void run(EObject root)
   {
      // identify current state
      ReachableState currentState = findMatchingOldState(root);      
      
      if (currentState == null)
      {
         // ups
         return;
      }
      
      GameState gameState = (GameState) root;
               
      if (gameState.getTurn() == Turn.OPPONENT_TURN)
      {
         // not my turn
         return;
      }
      
      gameState.setTurn(Turn.OPPONENT_TURN);
      game.clearWhenAllConditionsFulfilled(gameState);
      
      // choose best operation
      double bestMetricValue = Integer.MAX_VALUE;
      
      TrafoApplication bestTrafoApp = null;
      
      for (TrafoApplication trafoApp : currentState.getTrafoApplications())
      {
         if (game.getMyPathTrafosList(trafoApp.getDescription()) != null)
         {
            // control it
            if (trafoApp.getTgt().getMetricValue() < bestMetricValue)
            {
               bestTrafoApp = trafoApp;
               bestMetricValue = trafoApp.getTgt().getMetricValue();
            }
         }
      }
      
      // run it
      if (bestTrafoApp != null)
      {
         PathTrafo pathTrafo = game.getMyPathTrafosList(bestTrafoApp.getDescription());
         
         EObject board = gameState.getBoard();
         
         pathTrafo.trafo.run(board, board);
         
      }
   }
   
   
   
   private ReachableState findMatchingOldState(EObject root)
   {
      GameState gameState = (GameState) root;
      // identify current state
      String certificate = game.getEmfer().computeCertificate(root);
      
      Map<String, ArrayList<ReachableState>> cert2StateListMap = game.getEmfer().getCert2StateListMap();
      
      ArrayList<ReachableState> candidateStates = cert2StateListMap.get(certificate);
      
      if (candidateStates == null)
      {
         return null;
      }
      
      ReachableState newReachableState = ReachabilityFactory.eINSTANCE.createReachableState();
      newReachableState.setRoot(root);
      
      if (gameState.getTurn() == Turn.MY_TURN)
      {
         game.applyAndMarkMuCondition(newReachableState);
      }
      
      ReachableState currentState = null;
      
      for (ReachableState oldState : candidateStates)
      {
         Boolean match = game.getEmfer().getIsoOp().lazyMatch(oldState, newReachableState, game.getEmfer().getStaticCertInfo());

         if (match != null && match)
         {
            currentState = oldState;
            break;
         }
      }
      
      return currentState;
   }

}
