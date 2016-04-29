package entity;

import GUI.KabasujiFrame;
import cchen5.Intrigue;
import junit.framework.TestCase;
import ks.common.model.Deck;
import ks.launcher.Main;

public class TestGame extends TestCase {
	KabasujiGame game;
	KabasujiFrame gf;
	
	protected void setUp() {
		game = new KabasujiGame();
		gf = game.main(args);
	}
	
}
