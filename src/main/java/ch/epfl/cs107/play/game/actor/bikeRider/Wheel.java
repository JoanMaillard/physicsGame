package ch.epfl.cs107.play.game.actor.bikeRider;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.WheelConstraintBuilder;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Window;
import java.awt.event.KeyEvent;

public class Wheel extends GameEntity{
	
    private PartBuilder partBuilder;
    private boolean motorized;
    private Entity entity;
    private ActorGame window;
    private Circle circle;
    private ShapeGraphics image;

    public Wheel(ActorGame game, boolean fixed, Vector position) {
        super(game, fixed, position);
        entity = super.getEntity();
        circle = new Circle(0.5f);
        image = new ShapeGraphics(circle, Color.GRAY, Color.BLACK, 0.1f, 0.5f, 0);
        window = super.getOwner();
        build();
    }
        
    public void attach(Entity vehicle , Vector anchor , Vector axis) {
		
	WheelConstraintBuilder constraintBuilder = getOwner().world.createWheelConstraintBuilder() ;
	constraintBuilder.setFirstEntity(vehicle) ;
	// point d'ancrage du véhicule :
	constraintBuilder.setFirstAnchor(anchor) ;
	// Entity associée à la roue :
	constraintBuilder.setSecondEntity(entity) ;
	// point d'ancrage de la roue (son centre) :
	constraintBuilder.setSecondAnchor(Vector.ZERO) ;
	// axe le long duquel la roue peut se déplacer :
	constraintBuilder.setAxis(axis) ;
	// fréquence du ressort associé
	constraintBuilder.setFrequency (3.0f) ;
	constraintBuilder.setDamping (0.5f) ;
	// force angulaire maximale pouvant être appliquée
	//à la roue pour la faire tourner :
        if (motorized) {
	constraintBuilder.setMotorMaxTorque (10.0f) ;
        }
	//constraint = 
	constraintBuilder.build () ;
		
    }
	
    private void build() {
        partBuilder = entity.createPartBuilder();
	partBuilder.setShape(circle);
	partBuilder.setFriction(0.5f);
	partBuilder.build();
        image.setParent(this);
    }
	
    public void power(float speed) {}
	
    public void relax () {}
	
    public void detach () {}
    
        private void setSpeed() {
        if (window.getKeyboard().get(KeyEvent.VK_LEFT).isDown() && motorized) {
            entity.applyAngularForce(10.0f) ;
    	} else if (window.getKeyboard().get(KeyEvent.VK_RIGHT).isDown() && motorized) {
            entity.applyAngularForce(-10.0f) ;
    	}
    }
	
    public float getSpeed () {
	return 0.0f;
    }
    
    //Setter / getter combo for whether the wheel is motorised
    public void setMotorised(boolean setter) {
        motorized = setter;
    }
    
    public boolean getMotorised() {
        return motorized;
    }

    @Override
    public Transform getTransform() {
        return entity.getTransform();
	}

    @Override
    public Vector getVelocity() {
	return entity.getVelocity();
    }

    @Override
    public void draw(Canvas canvas) {
	image.draw(canvas);
    }
}

