package ch.epfl.cs107.play.game.actor.crate;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Window;


public class CrateGame extends ActorGame{
    private Crate crate1;
    private Crate crate2;
    private Crate crate3;
    private Window canvasWindow;
    
    @Override
    public void initializeObjects() {    
        crate1 = new Crate(this, false, new Vector(0.0f, 5.0f));
        crate2 = new Crate(this, false, new Vector(0.2f, 7.0f));
        crate3 = new Crate(this, false, new Vector(2.0f, 6.0f));
    }
    
    @Override
    public void destroyAllObjects(){
        super.destroyAllObjects();
    }
    
    @Override
    public void drawAllObjects() {
        super.drawAllObjects();
    }

    @Override
    public boolean begin(Window window, FileSystem fileSystem) {
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
        super.update(deltaTime);
        drawAllObjects();
    }

    @Override
    public void end() {

    }
}
