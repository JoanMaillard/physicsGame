package ch.epfl.cs107.play.game.actor.bikeRider;

import java.awt.Color;
import java.awt.event.KeyEvent;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Polyline;
import ch.epfl.cs107.play.math.Shape;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Window;

public class Bike extends GameEntity implements Actor{
	
    public static final float MAX_WHEEL_SPEED = 20f;
    public static boolean right = true;
    public static Entity entity;
    private static Wheel leftWheel;
    private static Wheel rightWheel;
    private ShapeGraphics image;
    private ShapeGraphics headImage;
    private ShapeGraphics armImage;
	private ShapeGraphics bodyImage;
	private ShapeGraphics shoulderImage;
	private ShapeGraphics leftLegUpImage;
	private ShapeGraphics leftLegDownImage;
	private ShapeGraphics rightLegUpImage;
	private ShapeGraphics rightLegDownImage;
	
	
	
    public Bike(ActorGame game, boolean fixed, World world) {
	super(game, fixed);
        entity = super.getEntity();
        build();
        buildWheels(game, fixed, new Vector(0.0f, 0.0f), world);
    }
	
    public Bike(ActorGame game, boolean fixed, Vector position, World world) {
	super(game, fixed, position);
        entity = super.getEntity();
        new Vector(0.0f, 0.0f);
        build();
        buildWheels(game, fixed, position, world);
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
        image = new ShapeGraphics(polygon, Color.RED, Color.BLUE, 0.01f);
	    image.setParent(entity);
	     
	    // Draw bodyparts
	    Circle head = new Circle (0.2f, getHeadLocation ());
	    Polyline arm = new Polyline(getSleeveLocation (), getHandLocation ());
	    Polyline shoulder = new Polyline(getShoulderLocation (), getSleeveLocation ());
	    Polyline body = new Polyline(getShoulderLocation (), getWaistLocation ());
	    Polyline leftLegUp = new Polyline(getWaistLocation (), getLeftKneeLocation ());
	    Polyline leftLegDown = new Polyline(getLeftKneeLocation (), getLeftFootLocation ());
	    Polyline rightLegUp = new Polyline(getWaistLocation (), getRightKneeLocation ());
	    Polyline rightLegDown = new Polyline(getRightKneeLocation (), getRightFootLocation ());
	    	
	    headImage = new ShapeGraphics(head, Color.PINK, Color.DARK_GRAY, 0);
	    headImage.setParent(entity);
	    armImage = new ShapeGraphics(arm, Color.PINK, Color.PINK, 0.15f);
	    armImage.setParent(entity);
	    shoulderImage = new ShapeGraphics(shoulder, Color.BLUE, Color.BLUE, 0.15f);
	    shoulderImage.setParent(entity);
	    bodyImage = new ShapeGraphics(body, Color.BLUE, Color.BLUE, 0.3f);
	    bodyImage.setParent(entity);
	    leftLegUpImage = new ShapeGraphics(leftLegUp, Color.DARK_GRAY, Color.DARK_GRAY, 0.25f);
	    leftLegUpImage.setParent(entity);
	    leftLegDownImage = new ShapeGraphics(leftLegDown, Color.DARK_GRAY, Color.DARK_GRAY, 0.25f);
	    leftLegDownImage.setParent(entity);
	    rightLegUpImage = new ShapeGraphics(rightLegUp, Color.GRAY, Color.GRAY, 0.25f);
	    rightLegUpImage.setParent(entity);
	    rightLegDownImage = new ShapeGraphics(rightLegDown, Color.GRAY, Color.GRAY, 0.25f);
	    rightLegDownImage.setParent(entity);
        
    }

    private void buildWheels(ActorGame game, boolean fixed, Vector position, World world) {
        leftWheel = new Wheel(game, fixed, position.add(new Vector(-1.0f, 0.f)), true);
        leftWheel.build(world);
        leftWheel.attach(entity, new Vector (-1.0f, 0.0f), new Vector (-0.5f, -1.0f), world);
        rightWheel = new Wheel(game, fixed, position.add(new Vector(1.0f, 0.f)), false);
        rightWheel.build(world);
        rightWheel.attach(entity, new Vector (1.0f, 0.0f), new Vector (0.5f, -1.0f), world);
    }
    
    static void controls(Window window) {
    	
    	//turn
    	if (window.getKeyboard().get(KeyEvent.VK_SPACE).isDown()) {
    		if (right) {right = false;}
    		else {right = true;}
    	}
    	
    	//brake
    	if (window.getKeyboard().get(KeyEvent.VK_DOWN).isDown()) {
        		Wheel.stop = true; }
        		else {Wheel.stop = false;}
    		
    	leftWheel.go(window);
    	rightWheel.go(window);
    	
    	//rotate
    	if (window.getKeyboard().get(KeyEvent.VK_LEFT).isDown()) {
    		entity.applyAngularForce (20.0f) ;
    	}
    	if (window.getKeyboard().get(KeyEvent.VK_RIGHT).isDown()) {
    		entity.applyAngularForce (-20.0f) ;
    	}
    	
    }
    
    // Head location , in local coordinates
    private Vector getHeadLocation () {
    return new Vector (0.0f, 1.75f) ;
    }
    
    private Vector getSleeveLocation () {
    return new Vector (0.25f, 1.2f) ;
    }
    
    private Vector getShoulderLocation () {
    return new Vector (0.0f, 1.4f) ;
    }
    
    private Vector getHandLocation () {
    return new Vector (0.5f, 1f) ;
    }
    
    private Vector getWaistLocation () {
    return new Vector (-0.5f, 0.8f) ;
    }
    
    private Vector getLeftKneeLocation () {
        return new Vector (0.3f, 0.5f) ;
        }
    
    private Vector getRightKneeLocation () {
        return new Vector (0.2f, 0.2f) ;
        }
    
    private Vector getLeftFootLocation () {
        return new Vector (-0.3f, 0f) ;
        }
    
    private Vector getRightFootLocation () {
        return new Vector (0f, -0.2f) ;
        }

    public void draw(Canvas canvas) {
    	
    	headImage.draw(canvas);
    	armImage.draw(canvas);
    	shoulderImage.draw(canvas);
    	bodyImage.draw(canvas);
    	leftLegUpImage.draw(canvas);
    	leftLegDownImage.draw(canvas);
    	rightLegUpImage.draw(canvas);
    	rightLegDownImage.draw(canvas);
        leftWheel.draw(canvas);
        rightWheel.draw(canvas);
    }
}
