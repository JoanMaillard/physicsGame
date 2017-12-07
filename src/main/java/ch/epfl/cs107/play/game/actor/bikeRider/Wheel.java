package ch.epfl.cs107.play.game.actor.bikeRider;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.WheelConstraintBuilder;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Canvas;

public class Wheel implements Actor{
	
	private boolean motorized;
	private Entity entity;
	private World world;
	
	public Wheel(boolean left) {
		
		
		
		if (Bike.right == true) {
			motorized = left;
			attach(entity , new Vector (-1.0f, 0.0f), new Vector (-0.5f, -1.0f)) ;
		}
		else {
			motorized = !left;
			attach(entity , new Vector (1.0f, 0.0f), new Vector (0.5f, -1.0f)) ;
		}
		
		
		
	}
	
	public void attach(Entity vehicle , Vector anchor , Vector axis) {
		
		WheelConstraintBuilder constraintBuilder = world.createWheelConstraintBuilder() ; ;
		constraintBuilder.setFirstEntity(vehicle) ;
		// point d'ancrage du véhicule :
		constraintBuilder.setFirstAnchor(anchor) ;
		// Entity associée à la roue :
		constraintBuilder.setSecondEntity(this.entity) ;
		// point d'ancrage de la roue (son centre) :
		constraintBuilder.setSecondAnchor(Vector.ZERO) ;
		// axe le long duquel la roue peut se déplacer :
		constraintBuilder.setAxis(axis) ;
		// fréquence du ressort associé
		constraintBuilder.setFrequency (3.0f) ;
		constraintBuilder.setDamping (0.5f) ;
		// force angulaire maximale pouvant être appliquée
		//à la roue pour la faire tourner :
		constraintBuilder.setMotorMaxTorque (10.0f) ;
		//constraint = 
		constraintBuilder.build () ;
		
	}
	
	public void power(float speed) {}
	
	public void relax () {}
	
	public void detach () {}
	
	public float getSpeed () {
		return 0;}
	

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
