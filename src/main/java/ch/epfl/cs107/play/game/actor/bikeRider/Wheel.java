package ch.epfl.cs107.play.game.actor.bikeRider;

import java.awt.Color;
import java.awt.event.KeyEvent;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.WheelConstraintBuilder;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Keyboard;
import ch.epfl.cs107.play.window.Window;

public class Wheel extends GameEntity implements Actor {
	
	private PartBuilder partBuilder;
	private boolean left;
	private boolean motorized;
	static boolean stop = false;
	WheelConstraintBuilder constraintBuilder;
	private Entity entity;
	private World world;
	private Circle circle = new Circle(0.6f);
	private ShapeGraphics image = new ShapeGraphics(circle , Color.GRAY , Color.BLACK ,	0.1f, 0.5f, 0);

	
	public Wheel(ActorGame game, boolean fixed, Vector position) {
        super(game, fixed, position);
        entity = super.getEntity();
		build();
    }
    
    public Wheel(ActorGame game, boolean fixed){
        super(game, fixed);
        entity = super.getEntity();
        build();
    }
    
	public void attach(Entity vehicle , Vector anchor , Vector axis) {
		
		constraintBuilder = world.createWheelConstraintBuilder() ; ;
		constraintBuilder.setFirstEntity(vehicle) ;
		// point d'ancrage du véhicule :
		constraintBuilder.setFirstAnchor(anchor) ;
		// Entity associée à la roue :
		constraintBuilder.setSecondEntity(entity) ;
		// point d'ancrage de la roue (son centre) :
		constraintBuilder.setSecondAnchor(Vector.ZERO) ;
		// axe le long duquel la roue peut se déplacer :
		constraintBuilder.setAxis(axis) ;
		// fr�quence du ressort associé
		constraintBuilder.setFrequency (3.0f) ;
		constraintBuilder.setDamping (0.5f) ;
		// force angulaire maximale pouvant être appliquée
		//à la roue pour la faire tourner :
		constraintBuilder.setMotorMaxTorque (10.0f) ;
		//constraint = 
		constraintBuilder.build () ;
		
	}
	
	private void build() {
		
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
	
	void go(Window window) {
		
		if(motorized && window.getKeyboard().get(KeyEvent.VK_UP).isDown()) {
			if(Bike.right && getSpeed() <= Bike.MAX_WHEEL_SPEED) {
    		entity.applyAngularForce(10.0f) ;
    		}
			if (!Bike.right && getSpeed() >= -Bike.MAX_WHEEL_SPEED) {
    			entity.applyAngularForce(-10.0f) ;
    		}
		}
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

	public void setMotorised(boolean motor) {
		
		motorized = motor;
	}

	

}
