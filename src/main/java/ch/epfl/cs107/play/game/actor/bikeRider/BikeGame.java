package ch.epfl.cs107.play.game.actor.bikeRider;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Window;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class BikeGame extends ActorGame{
	
    private Terrain terrain;
    public static boolean beanIsActive;
    private Bike bike;
    private Car car;
    private Window canvasWindow;
    private String endFlag = "";
    private int level = 1;
    private int lives = 3;
    
    @Override
    public void initializeObjects() {
    	terrain = new Terrain(this, true, level);
        if (!beanIsActive) {
            bike = new Bike(this, false, new Vector(0.0f, 5.0f));
            setViewCandidate(bike.getEntity());
            return;
        }
        car = new Car(this, false, new Vector(0.0f, 5.0f));
        setViewCandidate(car.getEntity());
    }
    
    public static void changeCar() {
        
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
                canvasWindow = window;
                initializeObjects();
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
            setEndFlag("reset");
            end();
        }
        else {
            objectsCollision();
            super.update(deltaTime);
            drawAllObjects();
            bike.controls(canvasWindow);
            if (beanIsActive) {car.controls(canvasWindow);}
            
        }
    }
    
    @Override
    public void objectsCollision() {
        if (!beanIsActive) {
            if (bike.collisions().equals("lose")) {
                Terrain.emptyAllDangerous();
                setEndFlag("lose");
                end();
            }
            if (bike.collisions().equals("win")) {
                Terrain.emptyAllDangerous();
                setEndFlag("win");
                end();
            }
            if (bike.collisions().equals("switchBean")) {
                Vector bikePosition = bike.getEntity().getPosition();
                bike.destroy();
                car = new Car(this, false, new Vector(bikePosition.getX(), bikePosition.getY()+5f));
                setViewCandidate(car.getEntity());
                beanIsActive = true;
            } 
        }
        if (beanIsActive) {
            if (car.collisions().equals("lose")) {
                Terrain.emptyAllDangerous();
                setEndFlag("lose");
                end();
            }
            if (car.collisions().equals("win")) {
                Terrain.emptyAllDangerous();
                setEndFlag("win");
                end();
            }
            if (car.collisions().equals("switchBean")) {
                Vector carPosition = car.getEntity().getPosition();
                car.destroy();
                bike = new Bike(this, false, carPosition);
                setViewCandidate(car.getEntity());
                beanIsActive = true;
            }
        }
    }
            
        
    

    @Override
    public void end() {
        switch (getEndFlag()) {
            case "reset":
                destroyAllObjects();
                initializeObjects();
                break;
            case "win":
                destroyAllObjects();
                if (level == 5) {
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
	
    public String getEndFlag() {
		return endFlag;
	}
    
    public void setEndFlag(String flag) {
        endFlag = flag;
    }
    }
