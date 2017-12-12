package ch.epfl.cs107.play.game.actor.bikeRider;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Window;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class BikeGame extends ActorGame{
	
    private Terrain terrain;
    private Bike bike;
    private Window canvasWindow;
    private String endFlag = "";
    private int level = 1;
    private int lives = 3;
    
    @Override
    public void initializeObjects() {
                terrain = new Terrain(this, true, level);
                bike = new Bike(this, false, new Vector(0.0f, 5.0f));
                setViewCandidate(bike.getEntity());
                
    }
    
    @Override
    public void destroyAllObjects() {
        super.destroyAllObjects();
        super.setEntitiesList(new ArrayList<>());
    }
    
    @Override
    public void drawAllObjects() {
        super.drawAllObjects();
    }
    
    public int getLevel() {
        return level;
    }
    
    @Override
    public boolean begin(Window window, FileSystem fileSystem){
            if (super.begin(window, fileSystem)) {
                initializeObjects();
                canvasWindow = window;
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public void update(float deltaTime) {
        //reset
        if (canvasWindow.getKeyboard().get(KeyEvent.VK_R).isPressed()) {
            endFlag = "reset";
            end();
        }
        else {
            super.update(deltaTime);
            drawAllObjects();
            bike.controls(canvasWindow);
        }
    }
    
    @Override
    public void objectsCollision() {
        for (int i = 0; i < super.getEntitiesList().toArray().length; i++){
            switch (super.getEntitiesList().get(i).collisions(bike.getEntity(), 0))
            {
                case "win":
                    endFlag = "win";
                    end();
                    break;
                case "lose":
                    endFlag = "lose";
                    end();
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void end() {
        switch (endFlag) {
            case "reset":
                destroyAllObjects();
                lives = 3;
                initializeObjects();
                break;
            case "win":
                destroyAllObjects();
                if (level == 3) {
                    level = 0;
                }
                level++;
                initializeObjects();
                break;
            case "lose":
                destroyAllObjects();
                lives--;
                if (lives == 0) {
                    level = 1;
                    lives = 3;
                }
                initializeObjects();
                break;
            default:
                break;
        }
    }
    
}