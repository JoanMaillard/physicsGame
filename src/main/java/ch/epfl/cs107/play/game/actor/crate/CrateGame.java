package ch.epfl.cs107.play.game.actor.crate;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Window;
;

public class CrateGame extends ActorGame{

	
    @Override
    public boolean begin(Window window, FileSystem fileSystem) {
        Crate crate1 = new Crate(this, false, new Vector(0.0f, 5.0f));
        Crate crate2 = new Crate(this, false, new Vector(0.2f, 7.0f));
        Crate crate3 = new Crate(this, false, new Vector(2.0f, 6.0f));
        return true;
    }

    // This event is called at each frame
    @Override
    public void update(float deltaTime) {
    }

    @Override
    public void end() {
        // Empty on purpose, no cleanup required yet
    }
}
