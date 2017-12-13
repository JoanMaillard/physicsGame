package ch.epfl.cs107.play.game.tutorial;

import java.awt.Color;
import java.awt.event.KeyEvent;

import ch.epfl.cs107.play.game.Game;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.BasicContactListener;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Window;
;

public class ContactGame implements Game{
	
	private Window window;
	private World world;
	private Entity block;
	private Entity ball;
	private ImageGraphics blockImg;
	private ShapeGraphics ballGraphics;
	private BasicContactListener contactListener ;
	
    @Override
    public boolean begin(Window window, FileSystem fileSystem) {
        
        // Store context
        this.window = window;
        
        // Create physics engine
        world = new World() ;
        // unit is meter
        world.setGravity(new Vector(0.0f, -9.81f)) ;
        EntityBuilder entityBuilder = world.createEntityBuilder() ;
        
        entityBuilder.setFixed(true) ;
        entityBuilder.setPosition(new Vector(-5.0f, -1.0f)) ;
        block = entityBuilder.build() ;
        PartBuilder partBuilder = block.createPartBuilder() ;
        Polygon polygon = new Polygon(
        new Vector(0.0f, 0.0f),
        new Vector(10.0f, 0.0f),
        new Vector(10.0f, 1.0f),
        new Vector(0.0f, 1.0f)
        ) ;
        partBuilder.setShape(polygon) ;
        partBuilder.build() ;
        
        entityBuilder.setFixed(false) ;
        entityBuilder.setPosition(new Vector(0.0f, 2.0f)) ;
        ball = entityBuilder.build() ;
        partBuilder = ball.createPartBuilder() ;
        Circle circle = new Circle(0.5f);
        partBuilder.setShape(circle) ;
        partBuilder.setFriction(0.5f) ;
        partBuilder.build() ; //create ball
     
     

        blockImg = new ImageGraphics("stone.broken.4.png", 10, 1f) ;
        blockImg.setParent(block) ;
        
        ballGraphics = new ShapeGraphics(circle ,Color.BLUE , Color.BLUE , .1f,
        		1, 0) ;
        ballGraphics.setParent(ball) ;
        
        contactListener = new BasicContactListener () ;
        ball.addContactListener(contactListener) ;

        // Successfully initiated
                
        return true;
    }

    // This event is called at each frame
    @Override
    public void update(float deltaTime) {
        
      
        // The actual rendering will be done now, by the program loop
    	// Game logic comes here
    	// Nothing to do, yet
    	// Simulate physics
    	// Our body is fixed , though , nothing will move
    	world.update(deltaTime) ;
    	// We can render our scene now,
    	// we must place the camera where we want
    	// We will look at the origin (identity) and increase the view size a bit
    	window.setRelativeTransform(Transform.I.scaled(10.0f)) ;
    	if (window.getKeyboard().get(KeyEvent.VK_LEFT).isDown()) {
    		ball.applyAngularForce(10.0f) ;
    		} else if (window.getKeyboard().get(KeyEvent.VK_RIGHT).isDown()) {
    		ball.applyAngularForce(-10.0f) ;
    		}
    	blockImg.draw(window) ;
    	
    	// contactListener is associated to ball
    	// contactListener.getEntities () returns the list of entities in collision with ball
    	int numberOfCollisions = contactListener.getEntities ().size() ;
    	if (numberOfCollisions > 0){
    	ballGraphics.setFillColor(Color.RED) ;
    	}
    	ballGraphics.draw(window) ;
    }

    @Override
    public void end() {
        // Empty on purpose, no cleanup required yet
    }
}
