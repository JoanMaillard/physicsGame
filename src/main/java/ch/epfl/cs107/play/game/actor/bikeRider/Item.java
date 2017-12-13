package ch.epfl.cs107.play.game.actor.bikeRider;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polygon;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class Item extends GameEntity{
	//This item is fixed and triggers the car/bike switch when touched
	private Entity entity;
	private ImageGraphics image = new ImageGraphics("box.3.enabled.png", 1.5f, 1.5f);
	private PartBuilder partBuilder;

	public Item(ActorGame game, boolean fixed, Vector position) {
		super(game, fixed, position);
		entity = super.getEntity();	
		partBuilder = entity.createPartBuilder() ;
		partBuilder.setShape(new Polygon (new Vector(0f, 0f), new Vector(1.5f, 0f),
		new Vector(1.5f, 1.5f), new Vector(0f, 1.5f))) ;
		partBuilder.setGhost(true);
                partBuilder.build() ;
                image.setParent(entity);
                getOwner().getEntitiesList().add(this);
                Terrain.getItems().add(entity);
	}
	
	public void draw(Canvas canvas) {
		image.draw(canvas);
	}	
	public void destroy() {
            getOwner().getEntitiesList().remove(this);
            entity.destroy();
        }
}