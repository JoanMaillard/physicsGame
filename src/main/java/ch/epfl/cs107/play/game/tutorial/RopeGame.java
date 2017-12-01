package ch.epfl.cs107.play.game.tutorial;

import java.awt.Color;

import ch.epfl.cs107.play.game.Game;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.RopeConstraintBuilder;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Window;
;

public class RopeGame implements Game{
	
	private Window window;
	private World world;
	private Entity block;
	private Entity ball;
	private ImageGraphics blockImg;
	private ShapeGraphics ballGraphics;
	
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
        entityBuilder.setPosition(new Vector(1.f, 0.5f)) ;
        block = entityBuilder.build() ;
     // At this point , your body is in the world , but it has no geometry
     // You need to use another builder to add shapes
     PartBuilder partBuilder = block.createPartBuilder() ;
     // Create a square polygon , and set the shape of the builder to this polygon
     Polygon polygon = new Polygon(
     new Vector(0.0f, 0.0f),
     new Vector(1.0f, 0.0f),
     new Vector(1.0f, 1.0f),
     new Vector(0.0f, 1.0f)
     ) ;
     partBuilder.setShape(polygon) ;
     partBuilder.setFriction(0.5f) ;
     // Finally , do not forget the following line.
     partBuilder.build() ;
     entityBuilder.setFixed(false) ;
     entityBuilder.setPosition(new Vector(0.6f, 4.0f)) ;
     ball = entityBuilder.build() ;
     // At this point , your body is in the world , but it has no geometry
     // You need to use another builder to add shapes
     partBuilder = ball.createPartBuilder() ;
	// Create a square polygon , and set the shape of the builder to this polygon
     Circle circle = new Circle(0.6f);

     partBuilder.setShape(circle) ;
     partBuilder.setFriction(0.5f) ;

     // Finally , do not forget the following line.
     partBuilder.build() ;

        blockImg = new ImageGraphics("stone.broken.4.png", 1, 1) ;
        blockImg.setParent(block) ;
        ballGraphics = new ShapeGraphics(circle , Color.BLUE, Color.RED, .1f, 1.f, 0) ;
        ballGraphics.setParent(ball) ;

        // Successfully initiated
        
        RopeConstraintBuilder ropeConstraintBuilder =
        		world.createRopeConstraintBuilder() ;
        		ropeConstraintBuilder.setFirstEntity(block) ;
        		ropeConstraintBuilder.setFirstAnchor(new Vector(1.0f/2,
        		1.0f/2)) ;
        		ropeConstraintBuilder.setSecondEntity(ball) ;
        		ropeConstraintBuilder.setSecondAnchor(Vector.ZERO) ;
        		ropeConstraintBuilder.setMaxLength(6.0f) ;
        		ropeConstraintBuilder.setInternalCollision(true) ;
        		ropeConstraintBuilder.build() ;

        
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
    	blockImg.draw(window) ;
    	ballGraphics.draw(window) ;
    }

    @Override
    public void end() {
        // Empty on purpose, no cleanup required yet
    }
}
