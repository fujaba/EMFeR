package emfer;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.function.Predicate;

import org.eclipse.emf.ecore.EObject;

import emfer.EMFeR.Path;
import emfer.EMFeR.PathTrafo;
import emfer.EMFeR.Trafo;
import emfer.EMFeR.Trafo2;
import emfer.examples.roadwork.RoadMap;
import emfer.reachability.GameState;
import emfer.reachability.ReachabilityFactory;

public class EMFeRGame
{
   private EMFeR emfer = new EMFeR();
   
   public EMFeR getEmfer()
   {
      return emfer;
   }

   private ArrayList<PathTrafo> myPathTrafosList = new ArrayList<PathTrafo>();

   private ArrayList<PathTrafo> opponentPathTrafosList = new ArrayList<PathTrafo>();

   
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
      
      gameState.setBoard(startBoard);
      
      emfer.withStart(gameState);
      return this;
   }


   public int explore()
   {
      // TODO Auto-generated method stub
      return 0;
   }

   private ArrayList<Predicate<EObject>> allMuConditions = new ArrayList<Predicate<EObject>>();

   public EMFeRGame withMuCondition(Predicate<EObject> muCondition)
   {
      allMuConditions.add(muCondition);
      
      return this;
   }


   private ArrayList<Predicate<EObject>> allGeneralConditions = new ArrayList<Predicate<EObject>>();

   public EMFeRGame withGeneralCondition(Predicate<EObject> generalCondition)
   {
      allGeneralConditions.add(generalCondition);
      return this;
   }
   
}
