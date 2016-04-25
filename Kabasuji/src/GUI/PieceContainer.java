package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import entity.Piece;
import view.PieceView;

/**
 * A container for dragged pieces
 * @author Quoc HoLam
 *
 */
public class PieceContainer extends JPanel{
	//The piece being dragged, if applicable
	PieceView draggedPiece;
	
	public PieceContainer() {
		super();
		
		draggedPiece = new PieceView(new Piece());
		setLayout(new GridLayout(1,0));
		setBounds(0,0,100,100);
		add(draggedPiece);
	}
	
	public void setDraggingPiece(Piece p){
		draggedPiece.setPiece(p);
	}
	
	public PieceView getPieceView(){
		return draggedPiece;
	}
}
