package view;

import javax.swing.JPanel;

import entity.Piece;
import entity.PieceTile;

public class PieceView extends JPanel {
	//Piece that this view represents
	Piece piece;
	
	public PieceView(Piece p) {
		piece = p;
		
		this.setSize(100, 100);
		setLayout(null);
	}

}
