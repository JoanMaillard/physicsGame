package ch.epfl.cs107.play.game.actor.bikeRider;

import java.awt.Color;
import java.awt.event.KeyEvent;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Contact;
import ch.epfl.cs107.play.math.ContactListener;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Polyline;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Window;

public class Car extends GameEntity implements Actor{
	
    public static final float MAX_WHEEL_SPEED = 20f;
    public static boolean right = true;
    private boolean hit;
    public static Entity entity;
    private static Wheel leftWheel;
    private static Wheel rightWheel;
    private ImageGraphics carImage = new ImageGraphics("car.png", 8f, 4.5f, new Vector(0.9f, 0f));
    private Polygon polygon = new Polygon(
    		-4f, 1f,
    		-3.5f, 4.5f,
    		3.5f, 4.5f,
    		4f, 1f,
    		2f, 1.5f,
    		0f, 1f,
    		-2f, 1.5f);
    private ShapeGraphics hitBox = new ShapeGraphics(polygon, Color.RED, Color.blue, 0, 0.5f, 0);
	
	
	
    public Car(ActorGame game, boolean fixed, World world) {
	super(game, fixed);
        entity = super.getEntity();
        build();
        buildWheels(game, fixed, new Vector(0.0f, 0.0f), world);
        //hasAlreadyTurned = false;
    }
	
    public Car(ActorGame game, boolean fixed, Vector position, World world) {
	super(game, fixed, position);
        entity = super.getEntity();
        new Vector(0.0f, 0.0f);
        build();
        //hasAlreadyTurned = false;
    }

    private void build() {
        PartBuilder partBuilder;		 
        partBuilder = entity.createPartBuilder();
        partBuilder.setShape(polygon);
        partBuilder.setFriction(0.8f);
        partBuilder.build();
	    carImage.setParent(entity);
	    hitBox.setParent(entity);
    }

<<<<<<< HEAD
    private void buildWheels(ActorGame game, boolean fixed, Vector position, World world) {
        leftWheel = new Wheel(game, fixed, position.add(new Vector(-3f, 0f)), true);
        leftWheel.build(world);
        leftWheel.attach(entity, new Vector (-3f, 0f), new Vector (-0.5f, -1.0f), world);
        rightWheel = new Wheel(game, fixed, position.add(new Vector(3f, 0f)), false);
        rightWheel.build(world);
        rightWheel.attach(entity, new Vector (3f, 0f), new Vector (0.5f, -1.0f), world);
=======
>>>>>>> 9ce271092b9808a759037761e08f8f385eea72c8
    }
    
    void controls(Window window) {
    	
    	//turn
    	if (window.getKeyboard().get(KeyEvent.VK_SPACE).isPressed()) {
    		
    		right = !right;
                
    	}
    	
    	leftWheel.goBean(window);
    	rightWheel.goBean(window);
    	
    	//rotate
    	if (window.getKeyboard().get(KeyEvent.VK_LEFT).isDown()) {
    		entity.applyAngularForce (20.0f) ;
    	}
    	if (window.getKeyboard().get(KeyEvent.VK_RIGHT).isDown()) {
    		entity.applyAngularForce (-20.0f) ;
    	}
    	
    }

    public void draw(Canvas canvas) {
    	
    	carImage.draw(canvas);
        leftWheel.draw(canvas);
        rightWheel.draw(canvas);
        hitBox.draw(canvas);
    }
    
    private void contactListener() {
    
    	ContactListener listener = new ContactListener () {
    	@Override
    	public void beginContact(Contact contact) {
    	if (contact.getOther ().isGhost ())
    	//return ;
    	//return ;
    	hit = true ;
    	}
    	
    	@Override
    	public void endContact(Contact contact) {}
    	} ;
    	//addContactListener() ;
    }
}
