package ch.epfl.cs107.play.game.tutorial;

import java.awt.Color;
import java.awt.event.KeyEvent;

import ch.epfl.cs107.play.game.Game;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.RevoluteConstraintBuilder;
import ch.epfl.cs107.play.math.RopeConstraintBuilder;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Window;
;

public class ScaleGame implements Game{
	
	private Window window;
	private World world;
	private Entity block;
	private Entity plank;
	private Entity ball;
	private ImageGraphics blockImg;
	private ImageGraphics plankImg;
	private ImageGraphics ballImg;
	
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
        
        EntityBuilder entityBuilderPlank = world.createEntityBuilder() ;
        entityBuilderPlank.setFixed(false) ;
        entityBuilderPlank.setPosition(new Vector(-2.5f, 0.8f)) ;
        plank = entityBuilderPlank.build() ;
        PartBuilder partBuilderPlank = plank.createPartBuilder() ;
        partBuilderPlank = plank.createPartBuilder() ;
        polygon = new Polygon(
        new Vector(0.0f, 0.0f),
        new Vector(5.0f, 0.0f),
        new Vector(5.0f, 0.2f),
        new Vector(0.0f, 0.2f)
        ) ;
        partBuilderPlank.setShape(polygon) ;
        partBuilderPlank.build() ;
     
        entityBuilder.setFixed(false) ;
        entityBuilder.setPosition(new Vector(0.5f, 4.0f)) ;
        ball = entityBuilder.build() ;
        partBuilder = ball.createPartBuilder() ;
        Circle circle = new Circle(0.5f);
        partBuilder.setShape(circle) ;
        partBuilder.setFriction(0.5f) ;
        partBuilder.build() ;
     
     

        blockImg = new ImageGraphics("stone.broken.4.png", 10, 1f) ;
        blockImg.setParent(block) ;
        
        plankImg = new ImageGraphics("wood.3.png", 5, 0.2f) ;
        plankImg.setParent(plank) ;
        
        ballImg = new ImageGraphics("explosive.11.png", 2.0f*0.5f , 
        		2.0f * 0.5f , new Vector(0.5f, 0.5f)) ;
        ballImg.setParent(ball) ;

        // Successfully initiated
        
        RevoluteConstraintBuilder revoluteConstraintBuilder =
        world.createRevoluteConstraintBuilder() ;
        revoluteConstraintBuilder.setFirstEntity(block) ;
        revoluteConstraintBuilder.setFirstAnchor(new Vector(10f/2,
        (1.0f*7)/4)) ;
        revoluteConstraintBuilder.setSecondEntity(plank) ;
        revoluteConstraintBuilder.setSecondAnchor(new Vector(5f/2,
        0.2f/2)) ;
        revoluteConstraintBuilder.setInternalCollision(true) ;
        revoluteConstraintBuilder.build() ;
        
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
    	plankImg.draw(window) ;
    	ballImg.draw(window) ;
    }

    @Override
    public void end() {
        // Empty on purpose, no cleanup required yet
    }
}
