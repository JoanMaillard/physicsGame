package ch.epfl.cs107.play.game.actor.bikeRider;


import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.crate.Crate;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.Polyline;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Terrain extends GameEntity{
        Finish finish;
	
	public Terrain(ActorGame game, boolean fixed, int level) {
		super(game, fixed);
                createLevel(level);
	}
        

        private void createLevel(int level) {
            switch (level){
                    case 1:
                        Polyline terrainLv1 = new Polyline(
						-1000.0f, -1000.0f,
						-1000.0f, 0.0f,
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
                        NormalTerrain normalTerrainLv1 = new NormalTerrain(getOwner(), true, terrainLv1);
                        Finish finish1 = new Finish(getOwner(), true, new Vector(65f, 0.3f));
                        finish = finish1;
                        break;
                    case 2: //Change the level!
                        Polyline terrainLv2 = new Polyline(
						-1000.0f, -1000.0f,
						-1000.0f, 0.0f,
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
                        NormalTerrain normalTerrainLv2 = new NormalTerrain(getOwner(), true, terrainLv2);
                        Crate crate1_1 = new Crate(getOwner(), false, new Vector(-12.0f, 1.0f));
                        Crate crate1_2 = new Crate(getOwner(), false, new Vector(-12.0f, 2.0f));
                        Crate crate1_3 = new Crate(getOwner(), true, new Vector(-15.0f, 1.0f));
                        Finish finish2 = new Finish(getOwner(), true, new Vector(-65f, 0.3f));
                        finish = finish2;
                        break;
                    case 3: //Change the level!
                        Polyline terrainLv3 = new Polyline(
<<<<<<< HEAD
						-1000.0f, -1000.0f,
						-1000.0f, 0.0f,
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
                        NormalTerrain normalTerrainLv3 = new NormalTerrain(getOwner(), true, terrainLv3);
                        Finish finish3 = new Finish(getOwner(), true, new Vector(-5f, 0.3f));
                        finish = finish3;
                        break;
                    default:
                        
                        break;
                }
        }
        
	public void draw(Canvas canvas) {
	}
        
        public String collisions(Entity entity) {
            if (finish.collisions(entity).equals("win")) {
                return "win";
            }
            else {
                return "";
            }
        }
	
	
}
