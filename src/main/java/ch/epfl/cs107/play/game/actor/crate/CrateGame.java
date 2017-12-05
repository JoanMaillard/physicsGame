package ch.epfl.cs107.play.game.actor.crate;

import ch.epfl.cs107.play.game.Game;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Circle;
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
	
	private Window window;
	private World world;
	private ActorGame game;
	private Crate crate1;
	private Crate crate2;
	private Crate crate3;
	private ImageGraphics image1;
	private ImageGraphics image2;
	
    @Override
    public boolean begin(Window window, FileSystem fileSystem) {
    	
    	this.window = window;
        
        // Create physics engine
        world = new World() ;
        // unit is meter
        world.setGravity(new Vector(0.0f, -9.81f)) ;
    	
    	image1 = new ImageGraphics("box.4.png", 5, 5);
    	image2 = new ImageGraphics("stone.broken.4.png", 5, 5);
    	
    	crate1 = new Crate(game, false, new Vector(0.0f, 0.0f), image1, 5f, 5f);
    	crate2 = new Crate(game, false, new Vector(0.0f, 0.0f), image1, 5f, 10f);
    	crate3 = new Crate(game, false, new Vector(0.0f, 0.0f), image2, 5f, 5f);
    	
    	
        
    	return true;
    }
}
