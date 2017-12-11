package ch.epfl.cs107.play.game.actor.bikeRider;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Window;
import java.awt.event.KeyEvent;

public class BikeGame extends ActorGame{
	
    private Terrain terrain;
    private Bike bike;
    private Finish finish;
    private Window canvasWindow;
<<<<<<< HEAD
    private String endFlag = "";
    
    @Override
    public void initializeObjects() {
        terrain = new Terrain(this, true);
        bike = new Bike(this, false, new Vector(0.0f, 5.0f));
        finish = new Finish(this, true, new Vector(65f, 0.3f));
    }
    
    @Override
    public void destroyAllObjects() {
        terrain.destroy();
        bike.destroy();
        finish.destroy();
    }
    
    @Override
    public void drawAllObjects() {
        terrain.draw(canvasWindow);
        bike.draw(canvasWindow);
        finish.draw(canvasWindow);
    }
    
    public GameEntity getBike() {
        return bike;
    }
    
    @Override
    public boolean begin(Window window, FileSystem fileSystem){
            if (super.begin(window, fileSystem)) {
                initializeObjects();
                setViewCandidate(bike.getEntity());
                canvasWindow = window;
=======

        	
>>>>>>> 942e8a9e0aea5df09f725e403e73b9720a4969b9
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public void update(float deltaTime) {
<<<<<<< HEAD
        //reset
        if (canvasWindow.getKeyboard().get(KeyEvent.VK_R).isPressed()) {
            endFlag = "reset";
            end();
        }
        else {
            super.update(deltaTime);
            drawAllObjects();
            bike.controls(canvasWindow);
            finish.collision(bike.getEntity());
        }
=======
>>>>>>> 942e8a9e0aea5df09f725e403e73b9720a4969b9
    }

    @Override
    public void end() {
        switch (endFlag) {
            case "reset":
                destroyAllObjects();
                initializeObjects();
                setViewCandidate(bike.getEntity());
                break;
            case "win":
                break;
            case "lose":
                break;
            default:
                break;
        }
    }
    
}