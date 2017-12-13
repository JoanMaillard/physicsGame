package ch.epfl.cs107.play.game.actor.bikeRider;

import java.awt.event.KeyEvent;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Window;

public class Icon extends GameEntity implements Actor {
	
	private ImageGraphics bikerImageOn = new ImageGraphics("bikeon.png", 10, 10);
	private ImageGraphics bikerImageOff= new ImageGraphics("bikeoff.png", 10, 10);
	private ImageGraphics beanImageOn= new ImageGraphics("beanon.png", 10, 10);
	private ImageGraphics beanImageOff= new ImageGraphics("beanoff.png", 10, 10);
	private PartBuilder partBuilder;
	private Entity entity;
	private boolean bike;
	
	public Icon(ActorGame game, boolean bike, Vector position) {
		super(game, true, position);
		entity = super.getEntity();
		this.bike = bike;
		partBuilder = entity.createPartBuilder() ;
		partBuilder.setShape(new Polygon(new Vector(0f, 0f), new Vector(10f, 0f),
	    		new Vector(10f, 10f), new Vector(0f, 10f))) ;
	    partBuilder.build() ;
	    getOwner().getEntitiesList().add(this);
	    entity.setPosition(position);
	}

	@Override
	public void draw(Canvas canvas) {
		if (SkinChooser.skin) {
			bikerImageOn.draw(canvas);
			beanImageOff.draw(canvas);
		}
		else {
			bikerImageOff.draw(canvas);
			beanImageOn.draw(canvas);
		}
		System.out.println(SkinChooser.skin);
	}
	
	private void choose(Window window) {
		if (SkinChooser.skin) {
			if (bike && bikerImageOff.getParent() != null) {
				bikerImageOn.setParent(this);
				bikerImageOff.setParent(null);
			}
		 else if (!bike && beanImageOn.getParent() != null) {
				beanImageOn.setParent(null);
				beanImageOff.setParent(this);
		}
	} else {
		
		if (bike && bikerImageOn.getParent() != null) {
			bikerImageOn.setParent(null);
			bikerImageOff.setParent(this);
		}
	else if (!bike && beanImageOn.getParent() != null) {
			beanImageOn.setParent(null);
			beanImageOff.setParent(null);
	}
}
}
}	