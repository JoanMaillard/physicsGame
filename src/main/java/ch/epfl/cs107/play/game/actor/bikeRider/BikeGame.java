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
    private Bike bike;
    private Window canvasWindow;
    private World world;
	
	@Override
    public boolean begin(Window window, FileSystem fileSystem){
       
		world = new World();
		if (super.begin(window, fileSystem)) {  
            terrain = new Terrain(this, true);
            bike = new Bike(this, false, new Vector(0.0f, 0.0f), world); //TODO: Change bike's position
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
    	Bike.controls(canvasWindow);
        terrain.draw(canvasWindow);
        bike.draw(canvasWindow);
    }

    @Override
    public void end() {
        
    }
}