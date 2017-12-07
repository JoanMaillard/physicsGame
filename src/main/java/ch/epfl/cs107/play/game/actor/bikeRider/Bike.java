package ch.epfl.cs107.play.game.actor.bikeRider;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Bike implements Actor{
	
	public static final float MAX_WHEEL_SPEED = 20f;
	static boolean right = true;
	private Entity entity;
	
	Polygon polygon = new Polygon(
			0.0f, 0.5f,
			0.5f, 1.0f,
			0.0f, 2.0f,
			-0.5f, 1.0f
			) ;

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
