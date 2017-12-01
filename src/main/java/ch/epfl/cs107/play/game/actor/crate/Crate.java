package ch.epfl.cs107.play.game.actor.crate;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.math.EntityBuilder;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Positionable;
import ch.epfl.cs107.play.math.Transform;
import ch.epfl.cs107.play.math.Vector;

public class Crate extends GameEntity implements Actor, Positionable{

	Crate(ActorGame game, boolean fixed) {
		super(game, fixed);
		// TODO Auto-generated constructor stub
	}
	
	Crate(ActorGame game, boolean fixed, Vector position) {
		super(game, fixed);
		// TODO Auto-generated constructor stub
	}
	
	Crate(ActorGame game, boolean fixed, Vector position, float dimensionX, float dimensionY, ImageGraphics image) {
		super(game, fixed);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Transform getTransform() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getVelocity() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}