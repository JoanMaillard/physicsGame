package ch.epfl.cs107.play.game.actor.bikeRider;

import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;

public class Particles {
	
	private Vector position ; // dans le repère absolu
	private Vector velocity ;
	private Vector acceleration ;
	private float angularPosition ;
	private float angularVelocity ;
	private float angularAcceleration ;
	
	public Transform getTransform () {
	return
	Transform.I.rotated(angularPosition).translated(position) ;
	}
	
	public abstract Particle copy() ;

	public void update(float deltaTime) {
		velocity = velocity.add(acceleration.mul(deltaTime)) ;
		position = position.add(velocity.mul(deltaTime)) ;
		angularVelocity += angularAcceleration * deltaTime ;
		angularPosition += angularVelocity * deltaTime ;
	}
}
