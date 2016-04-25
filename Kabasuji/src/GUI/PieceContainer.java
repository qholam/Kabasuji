package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import entity.Piece;
import entity.PieceTile;
import view.PieceView;
import view.TileView;

/**
 * A container for dragged pieces
 * @author Quoc HoLam
 *
 */
public class PieceContainer extends JPanel{
	//The piece being dragged, if applicable
	PieceView draggedPiece;
	//the tile that the mouse is hovering over during a drag
	TileView anchorTile;
	
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
	
	public void setAnchortile(TileView t){
		anchorTile = t;
		int r = ((PieceTile) t.getTile()).getPieceGridRow();
		int c = ((PieceTile) t.getTile()).getPieceGridCol();
	}
	
	public TileView getAnchorTile(){
		return anchorTile;
	}
	
	public PieceView getPieceView(){
		return draggedPiece;
	}
}
