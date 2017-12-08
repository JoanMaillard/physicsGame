package ch.epfl.cs107.play.game.actor;

import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;

public abstract class GameEntity{
    //Variables
    private Entity entity;
    private ActorGame actorGame;
    private EntityBuilder eB;

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
    
    public void destroy() {
        entity.destroy();
    }
    
    protected Entity getEntity(){
        return entity;
    }
    
    protected ActorGame getOwner(){
        return actorGame;
    }
    


	public Transform getTransform() {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector getVelocity() {
		// TODO Auto-generated method stub
		return null;
	}
}