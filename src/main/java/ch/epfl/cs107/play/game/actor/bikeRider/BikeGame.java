package ch.epfl.cs107.play.game.actor.bikeRider;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Window;

public class BikeGame extends ActorGame{
	
    private Terrain terrain;
    private Bike bike;
    private Window canvasWindow;
    private World world;
	
    public boolean begin(Window window, FileSystem fileSystem){
       
		world = new World();
		if (super.begin(window, fileSystem)) {  
            terrain = new Terrain(this, true, world);
            bike = new Bike(this, false, new Vector(0.0f, 3.0f), world);
            canvasWindow = window;	
            return true;
        }
        else {
            return false;
        }
    }

    public void update(float deltaTime) {
    	super.update(deltaTime);
    	Bike.controls(canvasWindow);
    	terrain.draw(canvasWindow);
        bike.draw(canvasWindow);
    }

    public void end() {
        
    }
}