package ch.epfl.cs107.play.game.actor.bikeRider;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.WheelConstraintBuilder;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Canvas;

public class Wheel implements Actor{
	
	private boolean motorized;
	private Entity entity;
	private World world;
	private Circle circle = new Circle(0.6f);
	private ShapeGraphics image = new ShapeGraphics(circle , Color.GRAY , Color.BLACK ,	0.1f, 0.5f, 0);
	
	public Wheel(boolean left) {
		
		 EntityBuilder entityBuilder = world.createEntityBuilder() ;
		 PartBuilder partBuilder = entity.createPartBuilder() ;
		 entityBuilder.setFixed(false) ;
		 
		 if (Bike.right == true) {
			 
			 entityBuilder.setPosition(Bike.positionInit.add(new Vector(1.0f, 0.f)));
			}
			else {
				
				entityBuilder.setPosition(Bike.positionInit.add(new Vector(-1.0f, 0.f)));
			}
		 
	     
	     entity = entityBuilder.build() ;
	     partBuilder = entity.createPartBuilder() ;

	     partBuilder.setShape(circle) ;
	     partBuilder.setFriction(0.5f) ;
	     partBuilder.build() ;

		
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
		// point d'ancrage du v�hicule :
		constraintBuilder.setFirstAnchor(anchor) ;
		// Entity associ�e � la roue :
		constraintBuilder.setSecondEntity(entity) ;
		// point d'ancrage de la roue (son centre) :
		constraintBuilder.setSecondAnchor(Vector.ZERO) ;
		// axe le long duquel la roue peut se d�placer :
		constraintBuilder.setAxis(axis) ;
		// fr�quence du ressort associ�
		constraintBuilder.setFrequency (3.0f) ;
		constraintBuilder.setDamping (0.5f) ;
		// force angulaire maximale pouvant �tre appliqu�e
		//� la roue pour la faire tourner :
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
		image.draw(canvas);
	}

}
