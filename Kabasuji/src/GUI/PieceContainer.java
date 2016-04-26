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
	//source of the drag
	JPanel source;
	
	public PieceContainer() {
		super();
		
		source = null;
		draggedPiece = new PieceView(new Piece());
		setLayout(new GridLayout(1,0));
		setBounds(0,0,350,170);
		add(draggedPiece);
		
		//The panel holding the piece should not be visible.
		setOpaque(false);
	}
	
	public void setSource(JPanel source){
		this.source = source;
	}
	
	public JPanel getSource(){
		return source;
	}
	
	public void setDraggingPiece(Piece p){
		draggedPiece.setPiece(p);
	}
	
	public void setAnchortile(TileView t){
		anchorTile = t;
		System.out.println("Point: " + ((PieceTile)t.getTile()).getPieceGridRow() + " " + ((PieceTile)t.getTile()).getPieceGridCol());
	}
	
	public TileView getAnchorTile(){
		return anchorTile;
	}
	
	/**
	 * get view of piece being dragged.
	 * @return PieceView View of the piece being dragged.
	 */
	public PieceView getPieceView(){
		return draggedPiece;
	}
}
