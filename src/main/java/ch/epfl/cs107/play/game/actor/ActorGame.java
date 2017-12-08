package ch.epfl.cs107.play.game.actor;

import ch.epfl.cs107.play.game.Game;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Positionable;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.WheelConstraintBuilder;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Keyboard;
import ch.epfl.cs107.play.window.Window;

public abstract class ActorGame implements Game {
    //Variables
    public World world;
    private Window window;
    private Vector viewCenter ;
    private Vector viewTarget ;
    private Positionable viewCandidate ;
    private static final float VIEW_TARGET_VELOCITY_COMPENSATION = 0.2f ;
    private static final float VIEW_INTERPOLATION_RATIO_PER_SECOND = 0.1f ;
    private static final float VIEW_SCALE = 15.0f ;
    
    //Additional methods (getters)
    public Keyboard getKeyboard (){
        return window.getKeyboard () ;
    }
    public Canvas getCanvas (){
        return window ;
    }

    //Game interface methods

    @Override
    public boolean begin(Window window, FileSystem fileSystem) {
        
    	this.window = window;
        
        // Create physics engine
        world = new World();
        // unit is meter
        world.setGravity(new Vector(0.0f, -9.81f)) ;
    	
        viewCenter = Vector.ZERO;
        viewTarget = Vector.ZERO;
                
        return true;
    }

    // This event is called at each frame
    
    @Override
    public void update(float deltaTime) {
        
    	world.update(deltaTime) ;
    	// We can render our scene now,
    	// we must place the camera where we want
    	// We will look at the origin (identity) and increase the view size a bit
    	window.setRelativeTransform(Transform.I.scaled(10.0f)) ;
    	
    	// Update expected viewport center
    	if (viewCandidate != null) {
    	viewTarget = viewCandidate.getPosition().add(viewCandidate.getVelocity ().mul(VIEW_TARGET_VELOCITY_COMPENSATION)) ;
    	}
    	// Interpolate with previous location
    	float ratio = (float)Math.pow(VIEW_INTERPOLATION_RATIO_PER_SECOND , deltaTime) ;
    	viewCenter = viewCenter.mixed(viewTarget , ratio) ;
    	// Compute new viewport
    	Transform viewTransform = Transform.I.scaled(VIEW_SCALE).translated(viewCenter) ;
    	window.setRelativeTransform(viewTransform) ;
    }

    @Override
    public void end() {
    	
    	
    }
    
    public WheelConstraintBuilder makeWheelConstraintBuilder() {
    	    	
    	WheelConstraintBuilder constraintBuilder = world.createWheelConstraintBuilder();
    	
    	return constraintBuilder;
    	
    }
	
}