package ch.epfl.cs107.play.game.actor.bikeRider;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.math.Polyline;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Terrain extends GameEntity{
	
	public Terrain(ActorGame game, boolean fixed) {
		super(game, fixed);
		// TODO Auto-generated constructor stub
	}

	private Polyline polyline = 
			new Polyline(
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
