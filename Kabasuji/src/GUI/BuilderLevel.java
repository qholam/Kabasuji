package GUI;

import javax.swing.JPanel;

import entity.Board;
import view.TileView;

public abstract class BuilderLevel extends JPanel {

	/**
	 * Create the panel.
	 */
	public BuilderLevel() {

	}
	
	void setBoard(Board b) {
		
	}

	public abstract BullpenView getBullpenView();

	public abstract  PieceContainer getPieceContainer();

	public abstract BoardPanel getBoardPanel();

}
