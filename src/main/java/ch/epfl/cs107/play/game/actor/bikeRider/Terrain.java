package ch.epfl.cs107.play.game.actor.bikeRider;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polyline;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Canvas;

public class Terrain extends GameEntity{
	
	private ShapeGraphics image;
	private PartBuilder partBuilder;
	private Entity entity;
	private Polyline polyline;
	
	public Terrain(ActorGame game, boolean fixed, World world) {
		super(game, fixed);
		entity = super.getEntity();
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
		image = new ShapeGraphics(polyline , Color.DARK_GRAY , Color.GREEN ,0.5f, 1f, 0);
		
		build(world);
	}

	public void draw(Canvas canvas) {
		image.draw(canvas);
		
	}
	
	void build(World world) {
		
		 partBuilder = entity.createPartBuilder() ;
	     partBuilder.setShape(polyline) ;
	     partBuilder.setFriction(0.5f) ;
	     partBuilder.build() ;
	     image.setParent(entity);
	}
}
