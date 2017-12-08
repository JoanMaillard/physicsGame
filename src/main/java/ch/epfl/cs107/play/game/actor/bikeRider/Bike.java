package ch.epfl.cs107.play.game.actor.bikeRider;

import java.awt.event.KeyEvent;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Window;

public class Bike extends GameEntity implements Actor{
	
    public static final float MAX_WHEEL_SPEED = 20f;
    public static boolean right = true;
    static Entity entity;
    private static Wheel leftWheel;
    private static Wheel rightWheel;
    private Vector wheelAxis;
    private World world;
	
	
	
    public Bike(ActorGame game, boolean fixed, World world) {
	super(game, fixed);
	this.world = world;
        entity = super.getEntity();
        build();
        buildWheels(game, fixed, new Vector(0.0f, 0.0f));
    }
	
    public Bike(ActorGame game, boolean fixed, Vector position, World world) {
	super(game, fixed, position);
        entity = super.getEntity();
        this.world = world;
        new Vector(0.0f, 0.0f);
        build();
        buildWheels(game, fixed, position);
        setMotorisedWheel(right);
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
        leftWheel = new Wheel(game, fixed, position.add(new Vector(-2f, 5f)), true);
        leftWheel.build(world);
        rightWheel = new Wheel(game, fixed, position.add(new Vector(2f, 5f)), false);
        rightWheel.build(world);
    }
    
    private void setMotorisedWheel(boolean right) {
        if (right){
            leftWheel.setMotorized(true);
            rightWheel.setMotorized(false);
        }
        else {
            leftWheel.setMotorized(false);
            rightWheel.setMotorized(true);
        }
    }
    
    static void controls(Window window) {
    	
    	//turn
    	if (window.getKeyboard().get(KeyEvent.VK_SPACE).isDown()) {
    		right = !right;
    	}
    	
    	//brake
    	if (window.getKeyboard().get(KeyEvent.VK_DOWN).isDown()) {
        		Wheel.stop = true; }
        		else {Wheel.stop = false;}
    		
    	leftWheel.go(window);
    	rightWheel.go(window);
    	
    	//rotate
    	if (window.getKeyboard().get(KeyEvent.VK_LEFT).isDown()) {
    		entity.applyAngularForce (-10.0f) ;
    	}
    	if (window.getKeyboard().get(KeyEvent.VK_RIGHT).isDown()) {
    		entity.applyAngularForce (10.0f) ;
    	}
    	
    }

    public void draw(Canvas canvas) {
        // TOFINISH (need bike's graphics)
        // shapeGraphicsBike.draw(canvas);
        leftWheel.draw(canvas);
        rightWheel.draw(canvas);
    }
}
