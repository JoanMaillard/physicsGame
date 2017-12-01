package ch.epfl.cs107.play.game.actor;

public interface Actor {

	/**
	* Simulates a single time step.
	* @param deltaTime elapsed time since last update , in
	seconds , non -negative
	*/
	public default void update(float deltaTime) {
	// By default , actors have nothing to update
	}
	public default void destroy (){
	// By default , actors have nothing to destroy
	}
	
}