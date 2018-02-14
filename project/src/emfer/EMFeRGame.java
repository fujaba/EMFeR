package emfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import emfer.EMFeR.Path;
import emfer.EMFeR.PathTrafo;
import emfer.EMFeR.Trafo;
import emfer.EMFeR.Trafo2;
import emfer.ModelIsomorphismOp.CertInfo;
import emfer.examples.roadwork.RoadMap;
import emfer.reachability.GameState;
import emfer.reachability.OperationName;
import emfer.reachability.ReachabilityFactory;
import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;
import emfer.reachability.Turn;

public class EMFeRGame
{
   private EMFeR emfer = new EMFeR();
   
   public EMFeR getEmfer()
   {
      return emfer;
   }

   private ArrayList<PathTrafo> myPathTrafosList = new ArrayList<PathTrafo>();
   
   public ArrayList<PathTrafo> getMyPathTrafosList()
   {
      return myPathTrafosList;
   }
   
   public PathTrafo getMyPathTrafosList(String trafoName)
   {
      for (PathTrafo trafo : myPathTrafosList)
      {
         if (trafo.name.startsWith(trafoName))
         {
            return trafo;
         }
      }
      
      return null;
   }


   private ArrayList<PathTrafo> opponentPathTrafosList = new ArrayList<PathTrafo>();

   
   public EMFeRGame withOpponentTrafo(String string, Trafo trafo)
   {
      withOpponentTrafo(string,
         root -> {
            LinkedHashSet<EObject> result = new LinkedHashSet<EObject>();
            result.add(root);
            return result;
         },
         (root, handle) -> trafo.run(root));

      return this;
   }
   
   
   public EMFeRGame withOpponentTrafo(String string, Path path, Trafo2 trafo)
   {
      PathTrafo pathTrafo = new PathTrafo()
            .withName(string)
            .withPath(path)
            .withTrafo(trafo);
      
      opponentPathTrafosList.add(pathTrafo);

      return this;
   }


   public EMFeRGame withMyTrafo(String string, Trafo trafo)
   {
      withMyTrafo(string,
         root -> {
            LinkedHashSet<EObject> result = new LinkedHashSet<EObject>();
            result.add(root);
            return result;
         },
         (root, handle) -> trafo.run(root));

      return this;
   }

   public EMFeRGame withMyTrafo(String string, Path path, Trafo2 trafo)
   {
      PathTrafo pathTrafo = new PathTrafo()
         .withName(string)
         .withPath(path)
         .withTrafo(trafo);

      myPathTrafosList.add(pathTrafo);

      return this;
   }


   public EMFeRGame withStart(EObject startBoard)
   {
      GameState gameState = ReachabilityFactory.eINSTANCE.createGameState();
      
      gameState.setTurn(Turn.MY_TURN);
      gameState.setBoard(startBoard);
      
      boolean allMuHold = applyAndMarkMuCondition(gameState);
      
      emfer.withStart(gameState);
      
      emfer.getReachabilityGraph().getStates().get(0).setAllMuHold(allMuHold);
      
      return this;
   }


   public int explore()
   {
      // compute certificates for staticNodes
      CertInfo emptyCertInfo = new CertInfo();

      emfer.getIsoOp().aggregate(emfer.getStaticNodes(), emptyCertInfo);

      emfer.setStaticCertInfo(emfer.getIsoOp().computeCertificate(emfer.getStaticNodes(), emptyCertInfo));

      // compute cert for start state and add to map and to todo
      ReachableState startState = emfer.getReachabilityGraph().getStates().get(0);

      startState.setNumber(1);

      CertInfo certInfo = emfer.getIsoOp().computeCertificate(startState.getRoot(), emfer.getStaticCertInfo());

      emfer.put2Cert2StateListMap(certInfo.getCertificate(), startState);

      emfer.addToTodo(startState);

      // apply trafos
      runTrafos();
      
      computeDistancesToWin();
      
      return emfer.getReachabilityGraph().getStates().size();
   }

   
   private void computeDistancesToWin()
   {
      
      EList<ReachableState> states = emfer.getReachabilityGraph().getStates();
      LinkedList<ReachableState> todo = new LinkedList<ReachableState>();

      for (ReachableState s : states)
      {
         if (s.isAllMuHold() && allGeneralConditionsHold(s))
         {
            s.setMetricValue(0);
            todo.add(s);
         }
         else
         {
            s.setMetricValue(Integer.MAX_VALUE);
         }
      }


      while ( ! todo.isEmpty())
      {
         ReachableState current = todo.pollFirst();

         for (TrafoApplication t : current.getResultOf())
         {
            ReachableState newState = t.getSrc();
            
            if (newState.getMetricValue() != Integer.MAX_VALUE)
            {
               // already reached by shorter path
               continue;
            }
            
            GameState gameState = (GameState) newState.getRoot();
            
            if (gameState.getTurn() == Turn.OPPONENT_TURN)
            {
               // max of successors + 1
               double max = 0;
               
               for (TrafoApplication t2 : newState.getTrafoApplications())
               {
                  ReachableState succState = t2.getTgt();
                  
                  if (succState.getMetricValue() > max)
                  {
                     max = succState.getMetricValue();
                  }
               }
               
               if (max < Integer.MAX_VALUE)
               {
                  newState.setMetricValue(max + 1);
                  todo.add(newState);
               }
            }
            else
            {
               // my state has a choice, thus, it goes for the minimal distance + 1
               double min = Integer.MAX_VALUE;
               
               for (TrafoApplication t2 : newState.getTrafoApplications())
               {
                  ReachableState succState = t2.getTgt();
                  
                  if (succState.getMetricValue() < min)
                  {
                     min = succState.getMetricValue();
                  }
               }
               
               if (min < Integer.MAX_VALUE)
               {
                  newState.setMetricValue(min + 1);
                  todo.add(newState);
               }
            }
         }

      }
   }

   private boolean allGeneralConditionsHold(ReachableState s)
   {
      GameState gameState = (GameState) s.getRoot();
      
      RoadMap roadMap = (RoadMap) gameState.getBoard();
      
      for (Entry<String, Predicate<EObject>> e : allGeneralConditions.entrySet())
      {
         Predicate<EObject> phi = e.getValue();
         boolean conditionHolds = phi.test(roadMap);
         
         if ( ! conditionHolds)
         {
            return false;
         }
         
         String condName = e.getKey();

         storeConditionResult(s, condName, true);
      }
      
      return true;
   }

   private void runTrafos()
   {
      doToDo: while (! emfer.getTodo().isEmpty() && emfer.getReachabilityGraph().getStates().size() <= emfer.getMaxNoOfNewStates())
      {
         ReachableState current = null;

         try
         {
            current = emfer.getTodo().take();
         }
         catch (InterruptedException e)
         {
            // retry
            continue;
         }

         exploreTrafos(current);

      } // while todo
   }



   private void applyWinConditions()
   {
      applyBasicConditions();

      Collection<ReachableState> previousStates = emfer.getReachabilityGraph().getStates();
      
      while (true)
      {
         // propagate mu conditions
         LinkedHashSet<ReachableState> modifiedOpponentStates = new LinkedHashSet<ReachableState>();

         updateOpponentStates(modifiedOpponentStates, previousStates);

         LinkedHashSet<ReachableState> modifiedMyStates = new LinkedHashSet<ReachableState>();

         updateMyStates(modifiedMyStates, modifiedOpponentStates);
         
         if (modifiedMyStates.isEmpty()) 
         { 
            break;
         }
         
         previousStates = new LinkedHashSet<ReachableState>();
         
         for (ReachableState myState : modifiedMyStates)
         {
            for (TrafoApplication t : myState.getResultOf())
            {
               previousStates.add(t.getSrc());
            }
         }
      }
   }


   private void updateMyStates(LinkedHashSet<ReachableState> modifiedStates, Collection<ReachableState> modifiedOpponentStates)
   {
      // update my state to intersection of successors
      for (ReachableState s : modifiedOpponentStates)
      {
         GameState g = (GameState) s.getRoot();

         if (g.getTurn() == Turn.MY_TURN)
         {
            continue;
         }
         
         for (TrafoApplication t1 : s.getResultOf())
         {
            ReachableState myState = t1.getSrc();
            
            if (myState.isAllMuHold())
            {
               // mystate should not learn from kids, as it switches mu domain
               continue;
            }
            
            LinkedHashSet<String> myConditions = getConditionsNameSet(myState);
         
            int oldSize = myConditions.size();
            
            if (oldSize == allGeneralConditions.size() + allMuConditions.size())
            {
               continue;
            }
            
            LinkedHashSet<String> bestNewConditions = myConditions;
            
            
            for (TrafoApplication t : myState.getTrafoApplications())
            {
               ReachableState opponentTurn = t.getTgt();
               
               // if opponent has all my conditions and even more, add those
               LinkedHashSet<String> nextConditions = getConditionsNameSet(opponentTurn);
               
               for(String c : myConditions)
               {
                  nextConditions.add(c);
               }
               
               if (nextConditions.size() > bestNewConditions.size())
               {
                  bestNewConditions = nextConditions;
               }
            }
            
            if (bestNewConditions.size() > oldSize)
            {
               // new conditions have been added
               storeAllConditionResults(myState, bestNewConditions, true);
               modifiedStates.add(myState);
            }
         }
      }
   }


   private LinkedHashSet<String> getConditionsNameSet(ReachableState myState)
   {
      LinkedHashSet<String> myConditions = new LinkedHashSet<String>();
      for (OperationName op : myState.getConditionsTrue())
      {
         myConditions.add(op.getOpName());
      }
      
      return myConditions;
   }


   
   private void updateOpponentStates(LinkedHashSet<ReachableState> modifiedStates, Collection<ReachableState> previousStates)
   {
      // update opponent states to intersection of successors
      for (ReachableState s : previousStates)
      {
         GameState g = (GameState) s.getRoot();

         if (g.getTurn() == Turn.OPPONENT_TURN)
         {
            if (s.getTrafoApplications().isEmpty()) 
            {
               continue;
            }
            
            LinkedHashSet<String> intersection = new LinkedHashSet<String>();
            intersection.addAll(allMuConditions.keySet());
            intersection.addAll(allGeneralConditions.keySet());
            
            
            for (TrafoApplication t : s.getTrafoApplications())
            {
               ReachableState nextMyTurn = t.getTgt();

               LinkedHashSet<String> nextConditions = new LinkedHashSet<String>();
               
               for (OperationName op : nextMyTurn.getConditionsTrue())
               {
                  nextConditions.add(op.getOpName());
               }
               
               intersection.retainAll(nextConditions);
               
               if (intersection.isEmpty()) break;
            }
            
            for (String opName : intersection)
            {
               if ( getFromConditionsTrue(s, opName) == null)
               {
                  modifiedStates.add(s);
               }
               storeConditionResult(s, opName, true);
            }
         }
      }
   }


   private void applyBasicConditions()
   {
      for (ReachableState s : emfer.getReachabilityGraph().getStates())
      {
         GameState g = (GameState) s.getRoot();
         EObject root = g.getBoard();

         if (g.getTurn() == Turn.OPPONENT_TURN)
         {
            continue;
         }
         
         // apply general conditions
         applyConditions(s, allGeneralConditions);
         
         // apply mu conditions
         for (OperationName op : g.getAchievedMuConditions())
         {
            s.getConditionsTrue().add(op);
         }
      }
   }



   private void storeAllConditionResults(ReachableState s, Collection<String> condNames, boolean allHold)
   {
      // add names to state
      for (String opName : condNames)
      {
         storeConditionResult(s, opName, allHold);
      }
   }


//   private boolean applyMuConditions(ReachableState s, ArrayList<TrafoApplication> path, LinkedHashMap<String, Predicate<EObject>> muConditions)
//   {
//      boolean isCycle = pathContains(path, s);
//      
//      if (isCycle)
//      {
//         return false;
//      }
//      
//      GameState g = (GameState) s.getRoot();
//      EObject root = g.getBoard();
//      
//      LinkedHashMap<String, Predicate<EObject>> stillOpenMuConditions = (LinkedHashMap<String, Predicate<EObject>>) muConditions.clone();
//      
//      
//      for (Entry<String, Predicate<EObject>> e : muConditions.entrySet())
//      {
//         // test if phi holds
//         String opName = e.getKey();
//         Predicate<EObject> value = e.getValue();
//         
//         boolean phiHolds = value.test(root);
//         
//         if (phiHolds)
//         {
//            stillOpenMuConditions.remove(opName);
//            storeConditionResult(s, opName, phiHolds);
//         }
//      }
//      
//      if (stillOpenMuConditions.size() == 0)
//      {
//         return true;
//      }
//      
//      // some muConditions need checking on successor turns
//      for (TrafoApplication myTrafo : s.getTrafoApplications())
//      {
//         ReachableState opponentState = myTrafo.getTgt();
//
//         if (opponentState.getTrafoApplications().isEmpty())
//         {
//            return false;
//         }
//
//         path.add(myTrafo);
//         
//         boolean allNextTurnHold = true;
//         
//         for (TrafoApplication opponentTrafo : opponentState.getTrafoApplications())
//         {
//            path.add(opponentTrafo);
//            ReachableState nextMyState = opponentTrafo.getTgt();
//            boolean nextTurnHold = applyMuConditions(nextMyState, path, stillOpenMuConditions);
//            
//            allNextTurnHold = allNextTurnHold && nextTurnHold;
//            
//            path.remove(path.size()-1);
//            
//            if ( ! allNextTurnHold ) break;
//         }
//         
//         path.remove(path.size()-1);
//
//         if (allNextTurnHold)
//         {
//            storeAllConditionResults(opponentState, stillOpenMuConditions, allNextTurnHold);
//            return true;
//         }
//      }
//      
//      return false;
//   }


   private boolean pathContains(ArrayList<TrafoApplication> path, ReachableState s)
   {
      if (path.size() == 0) return false;
      
      for (TrafoApplication t : path)
      {
         if (t.getSrc() == s) return true;
      }
      
      return false;
   }


   private void applyConditions(ReachableState s, LinkedHashMap<String, Predicate<EObject>> allConditions)
   {
      GameState g = (GameState) s.getRoot();
      EObject root = g.getBoard();
      
      for (Entry<String, Predicate<EObject>> e : allConditions.entrySet())
      {
         String opName = e.getKey();
         Predicate<EObject> phi = e.getValue();
         
         boolean phiResult = phi.test(root);
         
         storeConditionResult(s, opName, phiResult);
      }
   }


   private void storeConditionResult(ReachableState s, String opName, boolean phiResult)
   {
      OperationName currentOp = getFromConditionsTrue(s, opName);

      if (phiResult)
      {
         if (currentOp == null)
         {
            currentOp = ReachabilityFactory.eINSTANCE.createOperationName();
            currentOp.setOpName(opName);
            s.getConditionsTrue().add(currentOp);
         }
      }
      else
      {
         if (currentOp != null)
         {
            s.getConditionsTrue().remove(currentOp);
         }
      }
   }


   private OperationName getFromConditionsTrue(ReachableState s, String opName)
   {
      OperationName currentOp = null;
      for (OperationName op : s.getConditionsTrue())
      {
         if (op.getOpName().equals(opName))
         {
            currentOp = op;
            break;
         }
      }
      return currentOp;
   }


   private void exploreTrafos(ReachableState current)
   {
      // prepare
      Set<EObject> dynNodes = new LinkedHashSet<EObject>();

      ArrayList<Object> dynEdges = new ArrayList<Object>();

      dynNodes.add(current.getRoot());

      emfer.getIsoOp().aggregate(dynNodes, emfer.getStaticCertInfo());

      emfer.getLazyCloneOp().reset();

      // subscribe to model changes
      // current.getRoot().eAdapters().add(lazyCloneOp);
      for (EObject o : dynNodes)
      {
         o.eAdapters().add(emfer.getLazyCloneOp());
      }


      // run trafos
      GameState gameState = (GameState) current.getRoot();
      EObject root = gameState.getBoard();
      
      ArrayList<PathTrafo> pathTrafoList = this.myPathTrafosList;
      
      if (gameState.getTurn() == Turn.MY_TURN)
      {
         // apply and mark mu conditions
         // applyAndMarkMuCondition(current);
      }
      else
      {
         pathTrafoList = opponentPathTrafosList;
      }
      
      for (PathTrafo pathTrafo : pathTrafoList)
      {
         
         Collection<EObject> tmpHandles = pathTrafo.path.run(gameState.getBoard());

         ArrayList<EObject> handles = new ArrayList<EObject>();
         handles.addAll(tmpHandles);
         
         String trafoName = pathTrafo.name;

         Trafo2 trafo = pathTrafo.trafo;

         doHandles(current, dynNodes, pathTrafo, handles, trafoName, trafo);
      }

      // remove change listener
      for (EObject o : dynNodes)
      {
         o.eAdapters().remove(emfer.getLazyCloneOp());
      }
   }

   
   
   public void applyAndMarkMuCondition(ReachableState state)
   {
      GameState gameState = (GameState) state.getRoot();
      
      boolean allMuHold = applyAndMarkMuCondition(gameState);
      
      if (allMuHold)
      {
         state.setAllMuHold(true);
      }
   }

   public boolean applyAndMarkMuCondition(GameState gameState)
   {
      boolean allMuHold = false;
      
      EObject root = gameState.getBoard();
      
      if (gameState.getTurn() == Turn.OPPONENT_TURN)
      {
         System.out.println();
      }
      
      for (Entry<String, Predicate<EObject>> e : allMuConditions.entrySet())
      {
         if (e.getValue().test(root))
         {
            addNameToGameState(gameState, e.getKey());
         }
      }
      
      EList<OperationName> achievedMuConditions = gameState.getAchievedMuConditions();
      
      return (achievedMuConditions.size() == allMuConditions.size());
   }

 
   private void addNameToGameState(GameState gameState, String key)
   {
      for (OperationName op : gameState.getAchievedMuConditions())
      {
         if (op.getOpName().equals(key))
         {
            return;
         }
      }
      
      OperationName newOp = ReachabilityFactory.eINSTANCE.createOperationName();
      newOp.setOpName(key);
      gameState.getAchievedMuConditions().add(newOp);
   }


   private void doHandles(ReachableState current, Set<EObject> dynNodes, PathTrafo pathTrafo, ArrayList<EObject> handles, String trafoName, Trafo2 trafo)
   {
      GameState gameState = (GameState) current.getRoot();
      
      for (EObject h : handles)
      {
         Object newRoot = null;
         ReachableState newReachableState = null;

         emfer.getLazyCloneOp().reset();

         emfer.getLazyCloneOp().enableChangeRecording = true;

         // toggle turn
         if (gameState.getTurn() == Turn.MY_TURN)
         {
            // do it always for my turn, even when I decide to do nothing
            toggleTurn(gameState);
            clearWhenAllConditionsFulfilled(gameState);
         }
         
         
         // apply trafo
         trafo.run(gameState.getBoard(), h);
         
         
         // unsubscribe from dyn nodes
         emfer.getLazyCloneOp().enableChangeRecording = false;

         newReachableState = emfer.getLazyCloneOp().transferChangesToClone(current, dynNodes, emfer.getStaticCertInfo());

         if (newReachableState == null)
         {
            continue;
         }

         if (gameState.getTurn() == Turn.OPPONENT_TURN)
         {
            // toggle turn because opponent has actually done something
            GameState newGameState = (GameState) newReachableState.getRoot();
            
            newGameState.setTurn(Turn.MY_TURN);
            
            applyAndMarkMuCondition(newReachableState);
         }
         
         // merge with old states
         CertInfo newCertInfo = emfer.getIsoOp().computeCertificate(newReachableState.getRoot(), emfer.getStaticCertInfo());

         // already known?
         ArrayList<ReachableState> candidateStates = emfer.getCert2StateListMap().get(newCertInfo.getCertificate());

         Object match = findMatchingCandidate(current, gameState, pathTrafo, trafoName, h, newReachableState, candidateStates);

         createNewReachableState(current, gameState, pathTrafo, trafoName, h, newReachableState, newCertInfo, match);
      }
   }


  public void clearWhenAllConditionsFulfilled(GameState gameState)
   {
      EList<OperationName> achievedMuConditions = gameState.getAchievedMuConditions();
      if (achievedMuConditions.size() == allMuConditions.size())
      {
         // pass on empty opName list
         while ( ! achievedMuConditions.isEmpty())
         {
            achievedMuConditions.remove(achievedMuConditions.size()-1);
         }
      }
   }


   private void createNewReachableState(ReachableState current, GameState gameState, PathTrafo pathTrafo, String trafoName, EObject h, ReachableState newReachableState, CertInfo newCertInfo, Object match)
   {
      if (match == null)
      {
         // new state is really new
         emfer.addToTodo(newReachableState);
         emfer.put2Cert2StateListMap(newCertInfo.getCertificate(), newReachableState);

         emfer.getReachabilityGraph().getStates().add(newReachableState);
         newReachableState.setNumber(emfer.getReachabilityGraph().getStates().size());

         TrafoApplication newTrafoApp = ReachabilityFactory.eINSTANCE.createTrafoApplication();
         newTrafoApp.setSrc(current);
         newTrafoApp.setTgt(newReachableState);
         String description = trafoName;
         
         if (h != gameState.getBoard())
         {
            description = trafoName + " " + h;
         }
         newTrafoApp.setDescription(description);
         emfer.getReachabilityGraph().getTrafoApplications().add(newTrafoApp);
      }
   }


   private Object findMatchingCandidate(ReachableState current, GameState gameState, PathTrafo pathTrafo, String trafoName, EObject h, ReachableState newReachableState, ArrayList<ReachableState> candidateStates)
   {
      int currentPrio;
      Object match = null;

      if (candidateStates != null)
      {
         for (ReachableState oldState : candidateStates)
         {
            match = emfer.getIsoOp().lazyMatch(oldState, newReachableState, emfer.getStaticCertInfo());

            if (match != null)
            {
               // newReachableState is isomorphic to oldState. Just add a
               // link from first to oldState
               if (current == oldState)
               {
                  // trafo did not change the current state, do not create a rule application link
               }
               else
               {
                  TrafoApplication newTrafoApp = ReachabilityFactory.eINSTANCE.createTrafoApplication();
                  newTrafoApp.setSrc(current);
                  newTrafoApp.setTgt(oldState);
                  String description = trafoName;
                  
                  if (h != gameState.getBoard())
                  {
                     description = trafoName + " " + h;
                  }
                  
                  newTrafoApp.setDescription(description);
                  emfer.getReachabilityGraph().getTrafoApplications().add(newTrafoApp);
                  currentPrio = pathTrafo.getPriority();
               }

               break;
            }
         }
      }
      return match;
   }


   private void toggleTurn(GameState gameState)
   {
      if (gameState.getTurn() == Turn.MY_TURN)
      {
         gameState.setTurn(Turn.OPPONENT_TURN);
      }
      else
      {
         gameState.setTurn(Turn.MY_TURN);
      }
   }


   
   
   
   private LinkedHashMap<String, Predicate<EObject>> allMuConditions = new LinkedHashMap<String, Predicate<EObject>>();

   public EMFeRGame withMuCondition(String opName, Predicate<EObject> muCondition)
   {
      allMuConditions.put(opName, muCondition);
      
      return this;
   }


   private LinkedHashMap<String, Predicate<EObject>> allGeneralConditions = new LinkedHashMap<String, Predicate<EObject>>();

   public EMFeRGame withGeneralCondition(String opName, Predicate<EObject> generalCondition)
   {
      allGeneralConditions.put(opName, generalCondition);
      return this;
   }
   
}
