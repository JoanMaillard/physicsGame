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
                    case 3: //Change the level!
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
                 				100f, -25f,
                 				100f, -100f,
                 				-15f, -100f
                 				);
                        for (int i = 0; i < 7 ; i++) {
                        new Spike(getOwner(), true, new Vector(17.5f+i, -29.7f));
                        }
                        new NormalTerrain(getOwner(), true, terrainLv3);
                        new Finish(getOwner(), true, new Vector(-5f, 0.3f));
                        break;
                        
                    case 4: //Change the level!
                        Polyline terrainLv4 = new Polyline(
						-15f, 0f,
                 				-100f, 5f,
                 				2f, 4.5f,
                 				2f, 4f,
                 				2.5f, 4f,
                 				2.5f, 3.5f,
                 				3f, 3.5f,
                 				3f, 3f,
                 				3.5f, 3f,
                 				3.5f, 2.5f,
                 				4f, 2.5f,
                 				4f, 2f,
                 				4.5f, 2f,
                 				4.5f, 1.5f,
                 				5f, 1.5f,
                 				5f, 1f,
                 				5.5f, 1f,
                 				5.5f, 0.5f,
                 				6f, 0.5f,
                 				6f, 0f,
                 				6.5f, 0f,
                 				7f, -2.5f,
                 				7.5f, -2.5f,
                 				8f, 0f,
                 				8.5f, 5f,
                 				100f, 5f,
                 				100f, -100f,
                 				-100f, -100f
                 				
                 				
                 				
                 				);
                        for (int i = 0; i < 7 ; i++) {
                        new Spike(getOwner(), true, new Vector(17.5f+i, -29.7f));
                        }
                        new NormalTerrain(getOwner(), true, terrainLv4);
                        new Finish(getOwner(), true, new Vector(-5f, 0.3f));
                        break;
                        
                    default:
                        
                        break;
                }
        }
}
