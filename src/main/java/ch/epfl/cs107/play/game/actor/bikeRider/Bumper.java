package ch.epfl.cs107.play.game.actor.bikeRider;

import java.util.Timer;
import java.util.TimerTask;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.math.BasicContactListener;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Bumper extends GameEntity{
	
	private PartBuilder partBuilder;
	private Entity entity;
	private ImageGraphics image = new ImageGraphics("explosive.hollow.3.png", 5, 0.3f);
	private BasicContactListener contactListener ;
	private Vector position;
	private Polygon polygon = new Polygon(
            new Vector(0.0f, 0.0f), 
            new Vector(5f, 0f), 
            new Vector(5, 0.3f), 
            new Vector(0f, 0.3f)
        );
	
	public Bumper(ActorGame game, boolean fixed) {
		super(game, fixed, new Vector(65f, 0.3f));
		entity = super.getEntity();
		buildParts();
		image.setParent(entity);
		contactListener = new BasicContactListener () ;
                entity.addContactListener(contactListener) ;
	}
	
	public Bumper(ActorGame game, boolean fixed, Vector position) {
		super(game, fixed, position);
		entity = super.getEntity();
		this.position = position;
		buildParts();
		image.setParent(entity);
		contactListener = new BasicContactListener () ;
                entity.addContactListener(contactListener) ;
		
	}

	private void buildParts() {
        partBuilder = entity.createPartBuilder();
        partBuilder.setShape(polygon);
        partBuilder.build();
        getOwner().getEntitiesList().add(this);
        Terrain.getDangerousBike().add(entity);
    }
	
	public void draw(Canvas canvas) {
	    
		if (entity.getPosition().getY() > 5f)
	        {
	        	entity.setAngularVelocity(0);
	        	entity.setVelocity(Vector.ZERO);
	        	entity.setAngularPosition(0);
	        	entity.setPosition(position);
	        }
		jump();
		image.draw(canvas);
	    
	}
	
	void jump() {

		if (contactListener.getEntities().size() > 1)
				 {
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				  @Override
				  public void run() {
					  entity.setVelocity(new Vector(0f, 20f));
				  }
				}, 500);
		}
	        
		}
	}
