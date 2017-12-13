package ch.epfl.cs107.play.game.actor.bikeRider;

import java.awt.Color;
import java.awt.event.KeyEvent;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.math.Contact;
import ch.epfl.cs107.play.math.ContactListener;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Window;

public class Car extends GameEntity implements Actor{
	
    public static final float MAX_WHEEL_SPEED = 20f;
    public static boolean right = true;
    private String hit = "";
    public static Entity entity;
    private static CarWheel leftWheel;
    private static CarWheel rightWheel;
    private ImageGraphics carImage = new ImageGraphics("car.png", 8f, 4.5f, new Vector(0.9f, 0f));
    //only for tests
    private Polygon polygon = new Polygon(
    		-3.5f, 1.5f,
    		-3f, 4.5f,
    		1f, 4.5f,
    		2f, 1.5f,
    		0f, 1f,
    		-2f, 1.5f);
    private ShapeGraphics hitBox = new ShapeGraphics(polygon, Color.RED, Color.blue, 0, 0.5f, 0);
	
	
	
    public Car(ActorGame game, boolean fixed) {
	super(game, fixed);
        entity = super.getEntity();
        build();
        buildWheels(game, fixed, new Vector(0.0f, 0.0f));
        //hasAlreadyTurned = false;
    }
	
    public Car(ActorGame game, boolean fixed, Vector position) {
	super(game, fixed, position);
        entity = super.getEntity();
        new Vector(0.0f, 0.0f);
        build();
        buildWheels(game, fixed, position);
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

    private void buildWheels(ActorGame game, boolean fixed, Vector position) {
        getOwner().getEntitiesList().add(this);
        leftWheel = new CarWheel(game, fixed, position.add(new Vector(-2.5f, -1f)), true);
        leftWheel.build();
        leftWheel.attach(entity, new Vector (-2.5f, -1f), new Vector (-0.5f, -1.0f));
        rightWheel = new CarWheel(game, fixed, position.add(new Vector(2.5f, -1f)), false);
        rightWheel.build();
        rightWheel.attach(entity, new Vector (2.5f, -1f), new Vector (0.5f, -1.0f));
        contactListener();
    }
    
    void controls(Window window) {
    	
    	//turn
    	if (window.getKeyboard().get(KeyEvent.VK_SPACE).isPressed()) {
    		right = !right;
    	}
    	
    	leftWheel.go(window);
    	rightWheel.go(window);
    	
    	//rotate
    	if (window.getKeyboard().get(KeyEvent.VK_LEFT).isDown()) {
    		entity.applyAngularForce (1000.0f) ;
    	}
    	if (window.getKeyboard().get(KeyEvent.VK_RIGHT).isDown()) {
    		entity.applyAngularForce (-1000.0f) ;
    	}
    	
    }
    
    @Override
    protected Entity getEntity() {
        return entity;
    }

    public void draw(Canvas canvas) {
    	carImage.draw(canvas);
    	//hitBox.draw(canvas);
    }
    public void destroy()
    {
        leftWheel.destroy();
        rightWheel.destroy();
        getOwner().getEntitiesList().remove(leftWheel);
        getOwner().getEntitiesList().remove(rightWheel);
        getOwner().getEntitiesList().remove(this);
        entity.destroy();
    }
    
    @Override
    public String collisions() {
        if (leftWheel.collisions().equals("lose") || rightWheel.collisions().equals("lose") || hit.equals("lose")) {
            return "lose";
        }
        if (hit.equals("win")) {
            return "win";
        }
        return "";
    }
    
    private void contactListener() {
    
    	ContactListener listener = new ContactListener () {
    	@Override
    	public void beginContact(Contact contact) {
            if (contact.getOther().isGhost()){
                if (Terrain.getFinish().equals(contact.getOther().getEntity())) { 
                    hit = "win";
                }
            }
            if (Terrain.getDangerousBike().contains(contact.getOther().getEntity())) {
                hit = "lose";
            }
    	}
    	
    	@Override
    	public void endContact(Contact contact) {}
    	} ;
        
        entity.addContactListener(listener);
    }
}
