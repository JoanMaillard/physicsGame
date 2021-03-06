package ch.epfl.cs107.play.game.actor.bikeRider;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.bikeRider.Terrain;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;


public class BikeCrate extends GameEntity{
    //Variables
    private Entity entity;
    private PartBuilder pB;
    private ImageGraphics image;
    
    //Constructors
    public BikeCrate(ActorGame game, boolean fixed, Vector position) {
        super(game, fixed, position);
        entity = super.getEntity();
        buildParts();
        setParentToImage();
    }
    
    public BikeCrate(ActorGame game, boolean fixed){
        super(game, fixed);
        entity = super.getEntity();
        buildParts();
        setParentToImage();
    }
    
    //Additional methods
    private void buildParts() {
        pB = entity.createPartBuilder();
        Polygon polygon = new Polygon(
            new Vector(0.0f, 0.0f), 
            new Vector(0.0f, 1.0f), 
            new Vector(1.0f, 1.0f), 
            new Vector(1.0f, 0.0f)
        );
        pB.setShape(polygon);
        pB.setFriction(1.0f);
        pB.build();
        getOwner().getEntitiesList().add(this);
    }

    public void draw(Canvas canvas) {
        image.draw(canvas);
    }
    
    private void setParentToImage(){
        image = new ImageGraphics("box.4.png", 1, 1);
        image.setParent(entity);
    }
    
}