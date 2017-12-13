package ch.epfl.cs107.play.game.actor.bikeRider;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.TextGraphics;
import ch.epfl.cs107.play.math.BasicContactListener;
import ch.epfl.cs107.play.math.ContactListener;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;


public class Spike extends GameEntity{
    //Variables
    private Entity entity;
    private PartBuilder pB;
    private ImageGraphics image;
    private boolean collision[] = {false, false};
    private BasicContactListener contactListener;
	private ActorGame game;
    
    //Constructors
    public Spike(ActorGame game, boolean fixed, Vector position) {
        super(game, fixed, position);
        this.game = game;
        entity = super.getEntity();
        buildParts();
        setParentToImage();
        contactListener = new BasicContactListener () ;
	    entity.addContactListener(contactListener) ;
    }
    
    public Spike(ActorGame game, boolean fixed){
        super(game, fixed);
        entity = super.getEntity();
        buildParts();
        setParentToImage();
        contactListener = new BasicContactListener () ;
        entity.addContactListener(contactListener) ;
    }
    
    //Additional methods
    private void buildParts() {
        pB = entity.createPartBuilder();
        Polygon polygon = new Polygon(
            new Vector(0.0f, 0.0f), 
            new Vector(0.5f, 1.0f), 
            new Vector(1.0f, 1.0f)
        );
        pB.setShape(polygon);
        pB.setFriction(1.0f);
        pB.build();
        getOwner().getEntitiesList().add(this);
    }

    @Override
    public void draw(Canvas canvas) {
        image.draw(canvas);
    }
    
    public void update(float deltaTime)
    {
    	bikeCollisions(game);
    }
    
    private void setParentToImage(){
        image = new ImageGraphics("stone.10.png", 1, 1);
        image.setParent(entity);
    }
    
    public void bikeCollisions(ActorGame game) {
    	
    	System.out.println(getOwner().toString());
    	if (contactListener.getEntities().isEmpty()  || 
    			contactListener.getEntities().getClass() == Wheel.class) {
    		
    		System.out.println("aouch");
           getOwner().setEndFlag("loose");
           getOwner().end();
    }
    
    }
}