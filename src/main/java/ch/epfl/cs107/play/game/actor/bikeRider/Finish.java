package ch.epfl.cs107.play.game.actor.bikeRider;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.math.BasicContactListener;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Finish extends GameEntity{
	
	private PartBuilder partBuilder;
	private Entity entity;
	private ImageGraphics image= new ImageGraphics("flag.red.png", 1, 1);
	private BasicContactListener contactListener ;

	public Finish(ActorGame game, boolean fixed) {
		super(game, fixed, new Vector(65f, 0.3f));
		entity = super.getEntity();
		buildParts();
		image.setParent(entity);
		contactListener = new BasicContactListener () ;
	    entity.addContactListener(contactListener) ;
		
	}
	
	public Finish(ActorGame game, boolean fixed, Vector position) {
		super(game, fixed, position);
		entity = super.getEntity();
		buildParts();
		image.setParent(entity);
		contactListener = new BasicContactListener () ;
	    entity.addContactListener(contactListener) ;
		
	}

	private void buildParts() {
        partBuilder = entity.createPartBuilder();
        Polygon polygon = new Polygon(
            new Vector(0.0f, 0.0f), 
            new Vector(0.0f, 100f), 
            new Vector(1.0f, 100f), 
            new Vector(1.0f, 0f)
        );
        partBuilder.setShape(polygon);
        partBuilder.setGhost(true);
        partBuilder.build();
    }

    public void draw(Canvas canvas) {
        image.draw(canvas);
    }
    
    
}
