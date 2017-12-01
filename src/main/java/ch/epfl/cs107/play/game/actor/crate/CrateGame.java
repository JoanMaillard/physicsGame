package ch.epfl.cs107.play.game.actor.crate;

import ch.epfl.cs107.play.game.Game;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Positionable;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;
import ch.epfl.cs107.play.window.Window;
;

public class CrateGame extends ActorGame implements Game{
	
	private ActorGame game;
	private Crate crate1;
	private Crate crate2;
	private Crate crate3;
	private ImageGraphics image1;
	private ImageGraphics image2;
	
    @Override
    public boolean begin(Window window, FileSystem fileSystem) {
      
    	image1 = new ImageGraphics("../box.4.png", 5, 5) ;
    	image2 = new ImageGraphics("stone.broken.4.png", 5, 5) ;
    	crate1 = new Crate(game, false, new Vector(0.0f, 5.0f), 5f, 5f, image1);
    	crate2 = new Crate(game, false, new Vector(0.2f, 7.0f), 8f, 8f, image1);
    	crate3 = new Crate(game, false, new Vector(2.0f, 6.0f), 5f, 5f, image2);
    	image1.setParent(crate1) ;
    	
        return true;
    }

    // This event is called at each frame

    public void update(float deltaTime) {

    	image1.draw(window);
    	
    }

    @Override
    public void end() {
        // Empty on purpose, no cleanup required yet
    }
}
