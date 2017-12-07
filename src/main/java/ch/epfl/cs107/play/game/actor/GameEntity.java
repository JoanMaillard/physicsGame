package ch.epfl.cs107.play.game.actor;

import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public abstract class GameEntity implements Actor{
    //Variables
    private Entity entity;
    private ActorGame actorGame;
    private EntityBuilder eB;
    private PartBuilder pB;

    //Constructors
    
    public GameEntity(ActorGame game, boolean fixed, Vector position){
        try {
        actorGame = game;
        eB = actorGame.world.createEntityBuilder();
        eB.setFixed(fixed);
        eB.setPosition(position);
        entity = eB.build();
        }
        catch (NullPointerException e) {
            System.err.println("NullPointerException: " + e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException: " + e.getMessage());
        }
    }
    
    public GameEntity(ActorGame game, boolean fixed){
        try {
        actorGame = game;
        eB = actorGame.world.createEntityBuilder();
        eB.setFixed(fixed);
        eB.setPosition(new Vector(0.0f, 0.0f));
        entity = eB.build();
        }
        catch (NullPointerException e) {
            System.err.println("NullPointerException: " + e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException: " + e.getMessage());
        }
    }
    //Additional methods
    
    /*protected void draw(Canvas canvas){
        if (name == null)
            return;
        Image image = canvas.getImage(name);
        Transform transform = Transform.I.translated(-anchor.x, -anchor.y).scaled(width, height).transformed(getTransform());
        canvas.drawImage(image, transform, alpha, depth);
    }*/
    
    public void destroy() {
        entity.destroy();
    }
    
    protected Entity getEntity(){
        return entity;
    }
    
    protected ActorGame getOwner(){
        return actorGame;
    }
    
    public void draw(Canvas canvas) {
    }
}