package ch.epfl.cs107.play.game.actor.bikeRider;


import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.Polyline;
import ch.epfl.cs107.play.math.Vector;
import java.util.ArrayList;
import java.util.List;

public class Terrain extends GameEntity{ // This class contains the levels

        private static List<Entity> dangerousWheel = new ArrayList<>(); //List of entities which make the player lose if a wheel touches them
        private static List<Entity> dangerousBike = new ArrayList<>(); // List of entities which make the player lose if the bike / car touches them
        private static List<Entity> items = new ArrayList<>(); // List of entities which are considered as "items" in colliders (i.e. switch car/bike)
        private static Entity finish; //Finish line (one per level)
        
        protected static void emptyAllDangerous() { //Empties all above lists
            emptyDangerousWheel();
            emptyDangerousBike();
            emptyItems();
        }
        
        
        //Gets and empties for all above lists
        protected static List<Entity> getItems() { 
            return items;
        }
        
        protected static void emptyItems() {
            items = new ArrayList<>();
        }
        
        protected static List<Entity> getDangerousWheel() {
            return dangerousWheel;
        }
        
        protected static void emptyDangerousWheel() {
            dangerousWheel = new ArrayList<>();
        }
        
        protected static List<Entity> getDangerousBike() {
            return dangerousBike;
        }
        
        protected static void emptyDangerousBike() {
            dangerousBike = new ArrayList<>();
        }
        
        protected static void setFinish(Entity entity) {
            finish = entity;
        }
        
        protected static Entity getFinish() { 
            return finish;
        }
	
	public Terrain(ActorGame game, boolean fixed, int level) {
		super(game, fixed);
                createLevel(level);
	}
        

        private void createLevel(int level) { //The following switch stores all the levels
            switch (level){
                    case 1:
                        BikeGame.beanIsActive = false;
                        Polyline terrainLv1 = new Polyline(
						-1000.0f, -1000.0f,
						-1000.0f, 0.0f,
						-5f, 10f,
						-2f, 0f,
						0.0f, 0.0f,
						3.0f, 1.0f,
						8.0f, 1.0f,
						15.0f, 3.0f,
						16.0f, 3.0f,
						25.0f, 0.0f,
						35.0f, -5.0f,
						50.0f, -5.0f,
						55.0f, -4.0f,
						65.0f, 0.0f,
						6500.0f, -1000.0f
						);
                        new NormalTerrain(getOwner(), true, terrainLv1);
                        new Finish(getOwner(), true, new Vector(65f, 0.3f));
                        new Item(getOwner(), true, new Vector(8f, 1.3f));
                        break;
                    case 2:
                        BikeGame.beanIsActive = false;
                        Polyline terrainLv2 = new Polyline(
						-1000.0f, -1000.0f,
						-1000.0f, 0.0f,
						0.0f, 0.0f,
						3.0f, 1.0f,
						3.0f, 10f,
						15.0f, 3.0f,
						16.0f, 3.0f,
						25.0f, 0.0f,
						35.0f, -5.0f,
						50.0f, -5.0f,
						55.0f, -4.0f,
						65.0f, 0.0f,
						6500.0f, -1000.0f
						);
                        new NormalTerrain(getOwner(), true, terrainLv2);
                        new Finish(getOwner(), true, new Vector(-65f, 0.3f));
                        for(int i = 0; i < 30; i++) {
                        	new BikeCrate(getOwner(), false, new Vector(-5f, 40f + 2*i));
                        }
                        for(int i = 0; i < 30; i++) {
                        	new BikeCrate(getOwner(), false, new Vector(-20f, 60f + 2*i));
                        }
                        for(int i = 0; i < 30; i++) {
                        	new BikeCrate(getOwner(), false, new Vector(-40f, 150f + 2*i));
                        }
                        break;
                    case 3: //Change the level!
                        BikeGame.beanIsActive = false;
                        Polyline terrainLv3 = new Polyline(
						-15f, 0f,
                 				-5, 0f,
                 				-3.5f, -10f,
                 				1f, -19f,
                 				2.57f, -23.3f,
                 				6.77f, -25.2f,
                 				13.35f, -23.87f,
                 				17f, -22f,
                 				17f, -30f,
                 				25f, -30f,
                 				25f, -22f,
                 				27.56f, -23.68f,
                 				200f, -23.68f,
                 				200f, -100f,
                 				-15f, -100f
                 				);
                        for (int i = 0; i < 7 ; i++) {
                        new Spike(getOwner(), true, new Vector(17.5f+i, -29.7f));
                        }
                        for (int i = 0; i < 15 ; i++) {

                            new Spike(getOwner(), true, new Vector(50f+i, -23.38f));
                        }
                        new NormalTerrain(getOwner(), true, terrainLv3);
                        new Finish(getOwner(), true, new Vector(100f, -23.38f));
                        new Bumper(getOwner(), false, new Vector(45f, -23.35f));
                        break;
                        
                    case 4: //Change the level!
                        BikeGame.beanIsActive = false;
                        Polyline terrainLv4 = new Polyline(
						-15f, 0f,
                 				-100f, 5f,
                 				2f, 5,
                 				2f, 4f,
                 				3f, 4f,
                 				3f, 3f,
                 				4f, 3f,
                 				4f, 2f,
                 				5f, 2f,
                 				5f, 1f,
                 				6f, 1f,
                 				6f, 0f,
                 				7f, 0f,
                 				7f, -1f,
                 				8f, -1f,
                 				8f, -2f,
                 				9f, -2f,
                 				9f, -3f,
                 				10f, -3f,
                 				10f, -4f,
                 				11f, -4f,
                 				11f, -5f,
                 				12f, -20f,
                 				10f, -40f,
                 				12f, -60f,
                 				50f, -60f,
                 				20f, -40f,
                 				18f, -20f,
                 				20f, 5f,
                 				100f, 5f,
                 				100f, -100f,
                 				-100f, -100f                 				
                 				);
                        new NormalTerrain(getOwner(), true, terrainLv4);
                        new Finish(getOwner(), true, new Vector(45f, -59.7f));
                        break;
                        
                    default: //In case of bad number
                        
                        break;
                }
        }
}
