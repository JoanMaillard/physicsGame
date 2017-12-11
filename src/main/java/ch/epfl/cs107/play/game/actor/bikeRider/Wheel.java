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
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.WheelConstraintBuilder;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Window;

public class Wheel extends GameEntity implements Actor {
	
	private PartBuilder partBuilder;
	private boolean left;
	static boolean stop = false;
	WheelConstraintBuilder constraintBuilder;
	Entity entity;
	private Circle circle = new Circle(0.5f);
	private ImageGraphics image1 = new ImageGraphics("wheel.png", 1f , 1f , new Vector(0.5f, 0.5f)) ;
	private ShapeGraphics image = new ShapeGraphics(circle , Color.GRAY , Color.BLACK ,	0.01f, 1f, 0);

	
	public Wheel(ActorGame game, boolean fixed, Vector position, boolean left) {
        super(game, fixed, position);
        entity = super.getEntity();
        this.left = left;
    }
    
    public Wheel(ActorGame game, boolean fixed, boolean left){
        super(game, fixed);
        entity = super.getEntity();
        this.left = left;
    }
    
    public WheelConstraintBuilder makeWheelConstraintBuilder() {   	
    	constraintBuilder = getOwner().world.createWheelConstraintBuilder();
    	return constraintBuilder;
    }
    
	public void attach(Entity vehicle , Vector anchor , Vector axis, World world) {
		
		constraintBuilder = makeWheelConstraintBuilder();
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
	
	void build(World world) {
		
            partBuilder = entity.createPartBuilder() ;
	    partBuilder.setShape(circle) ;
	    partBuilder.setFriction(10000.0f) ;
	    partBuilder.build() ;
	    image1.setParent(entity);
	}
	
	void go(Window window) {
		if(left && Bike.right) {
                    if(window.getKeyboard().get(KeyEvent.VK_UP).isDown() && getSpeed() >= -Bike.MAX_WHEEL_SPEED) {
                        entity.applyAngularForce(-10.0f);
                    }
                    
                    
		}
		if(!left && !Bike.right) {
                    if(window.getKeyboard().get(KeyEvent.VK_UP).isDown() && getSpeed() <= Bike.MAX_WHEEL_SPEED) {
                        entity.applyAngularForce(10.0f);
                    }
                }
                if(window.getKeyboard().get(KeyEvent.VK_DOWN).isDown()) {
                    if (getSpeed() < 0.0f) {
                        entity.applyAngularForce(10.0f);
                    }
                    if (getSpeed() > 0.0f) {
                        entity.applyAngularForce(-10.0f);
                    }
                }
        }
	
	void goBean(Window window) {
		if(left && Bike.right) {
                    if(window.getKeyboard().get(KeyEvent.VK_UP).isDown() && getSpeed() >= -Bike.MAX_WHEEL_SPEED*3) {
                        entity.applyAngularForce(-30.0f);
                    }
                    
                    
		}
		if(!left && !Bike.right) {
                    if(window.getKeyboard().get(KeyEvent.VK_UP).isDown() && getSpeed() <= Bike.MAX_WHEEL_SPEED*3) {
                        entity.applyAngularForce(30.0f);
                    }
                }
                if(window.getKeyboard().get(KeyEvent.VK_DOWN).isDown()) {
                    if (getSpeed() < 0.0f) {
                        entity.applyAngularForce(10.0f);
                    }
                    if (getSpeed() > 0.0f) {
                        entity.applyAngularForce(-10.0f);
                    }
                }
        }
	
	public void power(float speed) {}
	
	public void relax () {}
	
	public void detach () {}
	
	public float getSpeed () {
            return entity.getAngularVelocity();
        }

	@Override
	public void draw(Canvas canvas) {
            image1.draw(canvas);
	}	
}
