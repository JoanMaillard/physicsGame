package ch.epfl.cs107.play.game.actor.crate;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;


public class Crate extends GameEntity implements Actor{
    //Variables
    ImageGraphics image = new ImageGraphics("box.4.png", 5, 5); 
    
    //Constructors
    public Crate(ActorGame game, boolean fixed, Vector position) {
        super(game, fixed, position);
        setParentToImage();
    }
    
    public Crate(ActorGame game, boolean fixed){
        super(game, fixed);
        setParentToImage();
    }
    
    //Additional methods
    private void setParentToImage() {
    image.setParent(this);
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