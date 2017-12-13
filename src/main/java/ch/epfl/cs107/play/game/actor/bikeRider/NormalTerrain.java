/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.epfl.cs107.play.game.actor.bikeRider;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.GameEntity;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.math.BasicContactListener;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.PartBuilder;
import ch.epfl.cs107.play.math.Polyline;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;
import java.awt.Color;

public class NormalTerrain extends GameEntity{
    private Polyline levelline;
    private Entity entity;
    private PartBuilder partBuilder;
    private ShapeGraphics image;
    
    public NormalTerrain(ActorGame game, boolean fixed, Vector position, Polyline polyline) {
        super(game, fixed, position);
        entity = super.getEntity();
        levelline = polyline;
        image = new ShapeGraphics(polyline , new Color(2, 106, 53) , Color.GREEN ,0.5f, 1f, 0);
        build();
    }
    
    public NormalTerrain(ActorGame game, boolean fixed, Polyline polyline) {
        super(game, fixed);
        entity = super.getEntity();
        levelline = polyline;
        image = new ShapeGraphics(polyline , new Color(2, 106, 53) , Color.GREEN ,0.5f, 1f, 0);
        build();
        
    }
    
    public void build() {
            partBuilder = entity.createPartBuilder() ;
	    partBuilder.setShape(levelline) ;
	    partBuilder.setFriction(1000.0f) ;
	    partBuilder.build() ;
	    image.setParent(entity);
            getOwner().getEntitiesList().add(this);
            setDangerous();
	}
    
    @Override
    public void draw(Canvas canvas) {
        image.draw(canvas);
    }
    
        
    public void setDangerous() {
        Terrain.getDangerousBike().add(entity);
    }
}
