package ch.epfl.cs107.play.game.actor.crate;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;


public class Crate extends GameEntity{
    //Variables
    Entity entity;
    PartBuilder pB;
    
    //Constructors
    public Crate(ActorGame game, boolean fixed, Vector position) {
        super(game, fixed, position);
        entity = super.getEntity();
        buildParts();
        //setParentToImage();
    }
    
    public Crate(ActorGame game, boolean fixed){
        super(game, fixed);
        entity = super.getEntity();
        buildParts();
        //setParentToImage();
    }
    
    //Additional methods
    private void buildParts() {
        pB = entity.createPartBuilder();
        Polygon polygon = new Polygon(
            new Vector(0.0f, 0.0f), 
            new Vector(0.0f, 5.0f), 
            new Vector(5.0f, 0.0f), 
            new Vector(5.0f, 5.0f)
        );
        pB.setShape(polygon);
        pB.build();
    }

    @Override
    public Transform getTransform() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector getVelocity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Canvas canvas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}