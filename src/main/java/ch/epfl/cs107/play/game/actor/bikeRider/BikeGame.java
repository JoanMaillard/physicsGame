package ch.epfl.cs107.play.game.actor.bikeRider;

import java.awt.event.KeyEvent;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.RevoluteConstraintBuilder;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Window;

public class BikeGame extends ActorGame{
	
	private Terrain terrain;
	private Wheel leftWheel;
	private Wheel rightWheel;
	private Window canvasWindow;
	
	@Override
    public boolean begin(Window window, FileSystem fileSystem) {
		if (super.begin(window, fileSystem)) {  
       terrain = new Terrain(this, true);
       leftWheel = new Wheel(true);
       rightWheel = new Wheel(false);
       canvasWindow = window;
		
        return true;
        }
        else {
        	return false;
        }
    }

    // This event is called at each frame
    @Override
    public void update(float deltaTime) {
        
    	super.update(deltaTime);
        terrain.draw(canvasWindow);
        leftWheel.draw(canvasWindow);
        rightWheel.draw(canvasWindow);
        
    }

    @Override
    public void end() {
        
    }
}
