package ch.epfl.cs107.play.game.actor.bikeRider;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Window;

public class BikeGame extends ActorGame{
	
    private Terrain terrain;
    private Bike bike;
    private Finish finish;
    private Car car;
    private Window canvasWindow;
    public boolean beanMode = true;
	
    public boolean begin(Window window, FileSystem fileSystem){
            if (super.begin(window, fileSystem)) {  
            terrain = new Terrain(this, true, world);
            if (!beanMode) {
            bike = new Bike(this, false, new Vector(0.0f, 5.0f), world);
            } else {
            car = new Car(this, false, new Vector(-3f, 5f), world);
            }
            finish = new Finish(this, true, new Vector(65f, 0.3f));
            canvasWindow = window;

        	
            return true;
        }
        else {
            return false;
        }
    }

    public void update(float deltaTime) {
    	super.update(deltaTime);
    	if (!beanMode) {
    	bike.controls(canvasWindow);
    	bike.draw(canvasWindow);
    	} else {
    	car.controls(canvasWindow);
    	car.draw(canvasWindow);
    	}
    	terrain.draw(canvasWindow);
        finish.draw(canvasWindow);
        finish.collision();
    }

    public void end() {
        
    }
}