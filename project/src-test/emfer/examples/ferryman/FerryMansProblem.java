package emfer.examples.ferryman;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

import emfer.stories.Storyboard;

public class FerryMansProblem
{
   @Test
   public void testFerryMansProblem() throws Exception
   {
      Storyboard story = new Storyboard("FerryMansProblem");
      
      FerrymanFactory factory = FerrymanFactory.eINSTANCE;
      
      River river = factory.createRiver();
      Bank left = factory.createBank();
      left.setName("left");
      
      Bank right = factory.createBank();
      right.setName("right");
      
      Boat boat = factory.createBoat();
      
      Cargo wolf = factory.createCargo();
      wolf.setName("wolf");
      
      Cargo goat = factory.createCargo();
      goat.setName("goat");
      
      Cargo cabbage = factory.createCargo();
      cabbage.setName("cabbage");

      river.getBanks().add(left);
      river.getBanks().add(right);
      river.setBoat(boat);
      
      left.getCargos().add(wolf);
      left.getCargos().add(goat);
      left.getCargos().add(cabbage);
      
      boat.setAt(left);
      
      
      Logger global = Logger.getGlobal();
      global.info(river.toString());
      
      story.dumpHtml();
   }
}
