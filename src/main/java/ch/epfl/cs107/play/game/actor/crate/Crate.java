package ch.epfl.cs107.play.game.actor.crate;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Positionable;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Image;
import ch.epfl.cs107.play.window.Window;

public class Crate extends GameEntity implements Actor{
	
	public Crate() {
		
		super(null, false);
	
	}
	
	public Crate(ActorGame game, boolean fixed, Vector position,ImageGraphics image, float width, float height) {
		
		super(game, fixed);
		
		EntityBuilder entityBuilder = world.createEntityBuilder() ;
        entityBuilder.setFixed(fixed) ;
        entityBuilder.setPosition(position) ;
        entity = entityBuilder.build() ;
        PartBuilder partBuilder = entity.createPartBuilder() ;
        partBuilder.setFriction(0.5f) ;
        Polygon polygon = new Polygon(
        new Vector(0.0f, 0.0f),
        new Vector(width, 0.0f),
        new Vector(width, height),
        new Vector(0.0f, height)
        ) ;
        partBuilder.setShape(polygon) ;
        partBuilder.build() ;
        
	}
	
	private Canvas canvas;
	private World world;
	private Window window;
	Entity entity;
	
	@Override
    public void update(float deltaTime) {
        
    	world.update(deltaTime) ;
    	window.setRelativeTransform(Transform.I.scaled(10.0f)) ; 	
        draw(canvas);
    }

	@Override
	public Transform getTransform() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getVelocity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		
	}
	
}