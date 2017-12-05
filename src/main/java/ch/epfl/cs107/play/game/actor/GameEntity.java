package ch.epfl.cs107.play.game.actor;

import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.math.World;

public abstract class GameEntity implements Actor{
    
    private Entity entity;
    protected static ActorGame actorGame;
	
	public GameEntity (ActorGame game, boolean fixed, Vector position) {
            super();
	}
	
	public GameEntity(ActorGame game, boolean fixed){
            super();
	}
        
        protected World getOwner() {
        return new World();
        }
	
	
	private void destroy(Entity entity){
        entity.destroy();
        }
}