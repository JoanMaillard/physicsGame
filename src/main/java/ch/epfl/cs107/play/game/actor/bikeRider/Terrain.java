package ch.epfl.cs107.play.game.actor.bikeRider;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.game.actor.crate.Crate;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polyline;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Terrain extends GameEntity{
	
	private ShapeGraphics image;
	private PartBuilder partBuilder;
	private Entity entity;
	private Polyline polyline;
        private Finish finish;
	
	public Terrain(ActorGame game, boolean fixed, int level) {
		super(game, fixed);
		entity = super.getEntity();
                switch (level){
                    case 1:
                        polyline = new Polyline(
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
                        finish = new Finish(game, true, new Vector(65f, 0.3f));
                        break;
                    case 2: //Change the level!
                        polyline = new Polyline(
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
                        Crate crate1 = new Crate(game, false, new Vector(-12.0f, 1.0f));
                        Crate crate2 = new Crate(game, false, new Vector(-12.0f, 2.0f));
                        Crate crate3 = new Crate(game, true, new Vector(-15.0f, 1.0f));
                        finish = new Finish(game, true, new Vector(-65f, 0.3f));
                        break;
                    case 3: //Change the level!
                        polyline = new Polyline(
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
                        finish = new Finish(game, true, new Vector(-5f, 0.3f));
                        break;
                    default:
                        
                        break;
                }
                image = new ShapeGraphics(polyline , new Color(2, 106, 53) , Color.GREEN ,0.5f, 1f, 0);
		build();
	}

	public void draw(Canvas canvas) {
		image.draw(canvas);
	}
        
        public String collision(Entity entity) {
            if (finish.collision(entity).equals("win")) {
                return "win";
            }
            else {
                return "";
            }
        }
	
	void build() {
            partBuilder = entity.createPartBuilder() ;
	    partBuilder.setShape(polyline) ;
	    partBuilder.setFriction(1.0f) ;
	    partBuilder.build() ;
	    image.setParent(entity);
            getOwner().getEntitiesList().add(this);
	}
}
