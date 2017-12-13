package ch.epfl.cs107.play.game.actor.bikeRider;

import java.awt.event.KeyEvent;

import ch.epfl.cs107.play.game.actor.ActorGame;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.math.Entity;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Window;

public class SkinChooser {

	
	private Icon bikeIcon;
	private Icon beanIcon;
	static boolean skin;
	
	public SkinChooser(ActorGame game) {
		bikeIcon = new Icon(game, true, true, new Vector(-5f, 0f));
		beanIcon = new Icon(game, true, false, new Vector(5f, 0f));
	}
	
	public void choose(Window window) {
		if (window.getKeyboard().get(KeyEvent.VK_LEFT).isPressed()) {
			if (skin != true) { 
				skin = true;
			}
		}
	if (window.getKeyboard().get(KeyEvent.VK_RIGHT).isPressed()) {
		if (skin != false) {
			skin = false;}
	}	
	}
	
	
	
}