package ch.epfl.cs107.play.game.actor.bikeRider;


import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.crate.Crate;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.Polyline;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Terrain extends GameEntity{
        boolean collision = false;
	
	public Terrain(ActorGame game, boolean fixed, int level) {
		super(game, fixed);
                createLevel(level);
	}
        

        private void createLevel(int level) {
            switch (level){
                    case 3:
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
                        new NormalTerrain(getOwner(), true, terrainLv1);
                        new Finish(getOwner(), true, new Vector(65f, 0.3f));
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
                        new NormalTerrain(getOwner(), true, terrainLv2);
                        new Crate(getOwner(), false, new Vector(-12.0f, 1.0f));
                        new Crate(getOwner(), false, new Vector(-12.0f, 2.0f));
                        new Crate(getOwner(), true, new Vector(-15.0f, 1.0f));
                        new Finish(getOwner(), true, new Vector(-65f, 0.3f));
                        break;
                    case 1: //Change the level!
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
                 				14f, -20f,
                 				10f, -40f,
                 				14f, -60f,
                 				50f, -60f,
                 				20f, -40f,
                 				17f, -20f,
                 				20f, 5f,
                 				100f, 5f,
                 				100f, -100f,
                 				-100f, -100f                 				
                 				);
                        new NormalTerrain(getOwner(), true, terrainLv4);
                        new Finish(getOwner(), true, new Vector(-5f, 0.3f));
                        break;
                        
                    default:
                        
                        break;
                }
        }
}
