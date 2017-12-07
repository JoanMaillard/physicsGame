package ch.epfl.cs107.play.game.actor.bikeRider;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Canvas;

public class Bike extends GameEntity implements Actor{
	
	public static final float MAX_WHEEL_SPEED = 20f;
	static boolean right = true;
	private Entity entity;
	static Vector positionInit;
	private World world;
	
	
	
	public Bike(ActorGame game, boolean fixed) {
		super(game, fixed);
		positionInit = new Vector(0f, 0f);
		build();
	}
	
	public Bike(ActorGame game, boolean fixed, Vector Position) {
		super(game, fixed);
		positionInit = Position;
		build();
	}

	private void build() {
		EntityBuilder entityBuilder = world.createEntityBuilder() ;
		 PartBuilder partBuilder = entity.createPartBuilder() ;
		 entityBuilder.setFixed(false) ;		 
		 entityBuilder.setPosition(positionInit);		 
	     
	     entity = entityBuilder.build() ;
	     partBuilder = entity.createPartBuilder() ;
	     Polygon polygon = new Polygon(
	 			0.0f, 0.5f,
	 			0.5f, 1.0f,
	 			0.0f, 2.0f,
	 			-0.5f, 1.0f
	 			) ;

	     partBuilder.setShape(polygon) ;
	     partBuilder.setFriction(0.5f) ;
	     partBuilder.build() ;
	
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
