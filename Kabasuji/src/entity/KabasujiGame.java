package entity;

import GUI.KabasujiFrame;
import GUI.PieceContainer;

public class KabasujiGame {
	protected PieceContainer container = null;
	
	public static void main(String[] args) {
		KabasujiFrame kFrame = new KabasujiFrame();
		kFrame.setVisible(true);
	}
	
	public void setContainer(PieceContainer cont) {
		container = cont;
	}
	
	public PieceContainer getContainer() {
		return container;
	}

}
