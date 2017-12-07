package ch.epfl.cs107.play.game.actor.bikeRider;

import java.awt.event.KeyEvent;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Window;

public class Bike extends GameEntity{
	
    public static final float MAX_WHEEL_SPEED = 20f;
    public static boolean right = true;
    private Entity entity;
    private Wheel leftWheel;
    private Wheel rightWheel;
    private Vector offset;
    private Vector wheelAxis;
	
	
	
    public Bike(ActorGame game, boolean fixed) {
	super(game, fixed);
        entity = super.getEntity();
	build();
        buildWheels(game, fixed, new Vector(0.0f, 0.0f));
    }
	
    public Bike(ActorGame game, boolean fixed, Vector position) {
	super(game, fixed, position);
        entity = super.getEntity();
        offset = new Vector(0.0f, 0.0f); // A revoir
        wheelAxis = new Vector(0.0f, 1.0f); // A revoir
        build();
        buildWheels(game, fixed, position);
        setMotorisedWheel(right);
        leftWheel.attach(entity, position.add(offset), wheelAxis);
        rightWheel.attach(entity, position.add(offset), wheelAxis);
    }

    private void build() {
        PartBuilder partBuilder;		 
        partBuilder = entity.createPartBuilder();
        Polygon polygon = new Polygon(
	 			0.0f, 0.5f,
	 			0.5f, 1.0f,
	 			0.0f, 2.0f,
	 			-0.5f, 1.0f
	 			);

        partBuilder.setShape(polygon);
        partBuilder.setFriction(0.8f);
        partBuilder.build();
    }
        // TODO: change left and right wheel positions compared to bike frame (by changing the added vectors)
    private void buildWheels(ActorGame game, boolean fixed, Vector position) {
        leftWheel = new Wheel(game, fixed, position.add(offset));
        rightWheel = new Wheel(game, fixed, position.add(offset));
    }
    
    private void setMotorisedWheel(boolean right) {
        if (right){
            leftWheel.setMotorised(true);
            rightWheel.setMotorised(false);
        }
        else {
            leftWheel.setMotorised(false);
            rightWheel.setMotorised(true);
        }
    }
    
    private void controls(Window window) {
    	
    	//turn
    	if (window.getKeyboard().get(KeyEvent.VK_SPACE).isDown()) {
    		right = !right;
    	}
    	
    	//brake
    	if (window.getKeyboard().get(KeyEvent.VK_DOWN).isDown()) {
        		Wheel.stop = true;
    		
    	}
    	
    	//rotate
    	if (window.getKeyboard().get(KeyEvent.VK_LEFT).isDown()) {
    		entity.applyAngularForce (-10.0f) ;
    	}
    	if (window.getKeyboard().get(KeyEvent.VK_RIGHT).isDown()) {
    		entity.applyAngularForce (10.0f) ;
    	}
    	
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
        // TOFINISH (need bike's graphics)
        // shapeGraphicsBike.draw(canvas);
        leftWheel.draw(canvas);
        rightWheel.draw(canvas);
    }

}
