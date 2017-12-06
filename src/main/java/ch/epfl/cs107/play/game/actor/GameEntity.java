package ch.epfl.cs107.play.game.actor;

import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.Vector;

public abstract class GameEntity implements Actor{
    //Variables
    private Entity entity;
<<<<<<< HEAD
    protected static ActorGame actorGame;
	
	public GameEntity (ActorGame game, boolean fixed, Vector position) {
            super();
	}
	
	public GameEntity(ActorGame game, boolean fixed){
            super();
	}
        
        protected World getOwner() {
        return new World();
=======
    private ActorGame actorGame;
    private EntityBuilder eB;

    //Constructors
    
    public GameEntity(ActorGame game, boolean fixed, Vector position){
        //try {
        actorGame = game;
        eB = actorGame.world.createEntityBuilder();
        eB.setFixed(fixed);
        eB.setPosition(position);
        entity = eB.build();
        //}
        /*catch (NullPointerException e) {
            System.err.println("NullPointerException: " + e.getMessage());
>>>>>>> bcd3b295232b5b2bec93143114b22aff31a172c7
        }
        catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException: " + e.getMessage());
        }*/
    }
    
    public GameEntity(ActorGame game, boolean fixed){
        //try {
        actorGame = game;
        eB = actorGame.world.createEntityBuilder();
        eB.setFixed(fixed);
        eB.setPosition(new Vector(0.0f, 0.0f));
        entity = eB.build();
        //}
        /*catch (NullPointerException e) {
            System.err.println("NullPointerException: " + e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException: " + e.getMessage());
        }*/
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
    
}