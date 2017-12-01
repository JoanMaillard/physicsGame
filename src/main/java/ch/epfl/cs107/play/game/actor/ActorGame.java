package ch.epfl.cs107.play.game.actor;

import ch.epfl.cs107.play.math.Positionable;
import ch.epfl.cs107.play.math.Vector;

public class ActorGame {

	// Viewport properties
	private Vector viewCenter ;
	private Vector viewTarget ;
	private Positionable viewCandidate ;
	private static final float VIEW_TARGET_VELOCITY_COMPENSATION = 0.2f ;
	private static final float VIEW_INTERPOLATION_RATIO_PER_SECOND = 0.1f ;
	private static final float VIEW_SCALE = 10.0f ;
	
}
