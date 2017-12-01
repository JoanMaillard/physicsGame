package ch.epfl.cs107.play.game.actor;

import java.awt.Color;
import java.awt.event.KeyEvent;

import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.BasicContactListener;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Positionable;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Keyboard;
import ch.epfl.cs107.play.window.Window;

public class ActorGame {
	
	public Keyboard getKeyboard (){
		return window.getKeyboard () ;
		}
		public Canvas getCanvas (){
		return window ;
		}

	// Viewport properties
	private Vector viewCenter ;
	private Vector viewTarget ;
	private Positionable viewCandidate ;
	private static final float VIEW_TARGET_VELOCITY_COMPENSATION = 0.2f ;
	private static final float VIEW_INTERPOLATION_RATIO_PER_SECOND = 0.1f ;
	private static final float VIEW_SCALE = 10.0f ;
	
	@Override
    public boolean begin(Window window, FileSystem fileSystem) {
        
        
                
        return true;
    }

    // This event is called at each frame
    @Override
    public void update(float deltaTime) {
        
      
        
    }

    @Override
    public void end() {
    	
    	
    }
	
}
