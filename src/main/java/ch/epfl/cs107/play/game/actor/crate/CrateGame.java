package ch.epfl.cs107.play.game.actor.crate;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Window;


public class CrateGame extends ActorGame{

	
    @Override
    public boolean begin(Window window, FileSystem fileSystem) {
        if (super.begin(window, fileSystem)) {
            Crate crate1 = new Crate(this, false, new Vector(0.0f, 5.0f));
            setGraphicsToBox(crate1, "box.4.png", 5, 5);
            //crate1.draw(window);
            Crate crate2 = new Crate(this, false, new Vector(0.2f, 7.0f));
            setGraphicsToBox(crate2, "box.4.png", 5, 5);
            //crate2.draw(window);
            Crate crate3 = new Crate(this, false, new Vector(2.0f, 6.0f));
            setGraphicsToBox(crate3, "box.4.png", 5, 5);
            //crate3.draw(window);
        return true;
        }
        else {
            return false;
        }
    }
    
    private void setGraphicsToBox(GameEntity gE, String path, int size1, int size2) {
        ImageGraphics image = new ImageGraphics(path, size1, size2);
        image.setParent(gE);
    }

    // This event is called at each frame
    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        
    }

    @Override
    public void end() {
        // Empty on purpose, no cleanup required yet
    }
}
