package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import entity.Piece;
import entity.Tile;
/**
 * View for a piece
 * @author Quoc HoLam
 *
 */
public class PieceView extends JPanel {
	/**
	 * Auto-generate by Eclipse to suppress a warning
	 */
	private static final long serialVersionUID = 7304415273821237640L;
	
	//Piece that this view represents
	Piece piece;
	//Tileviews contained by this pieceview
	TileView[][] tilesView;
	
	public PieceView(Piece p) {
		super();
		
		piece = p;
		Tile[][] g = p.getpieceGrid();  
		
		setLayout(new GridLayout(p.getMaxHeight(), p.getMaxWidth(), 0, 0));
		tilesView = new TileView[p.getMaxHeight()][p.getMaxWidth()];
		for(int i = 0; i < p.getMaxHeight(); i++){
			for(int j = 0; j < p.getMaxWidth(); j++){
				tilesView[j][i] = new TileView(g[j][i]);
				/* RICHARDCHANGE tilesView[j][i].setVisible(false); */
				add(tilesView[j][i]);
			}
		}
		
		//The panel holding the piece should not be visible.
		this.setOpaque(false);
		setPreferredSize(new Dimension(144, 144));
	} 
	
	/**
	 * Properly update the displayed info on this {@link Piece}
	 */
	@Override 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		/* RICHARDCHANGE Comment out this method of drawing */
		Tile[][] grid = piece.getpieceGrid();
		
		for(int i = 0; i < tilesView.length; i++){
			for(int j = 0; j < tilesView[i].length; j++){
				tilesView[j][i].setTile(grid[j][i]);
			}
		}
		
		/* RICHARDCHANGE Use this to draw instead */
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (piece.getpieceGrid()[j][i] != null) {
					g.setColor(Color.orange);
					g.fillRect (24*j, 24*i, 24, 24);
					g.setColor(Color.black);
					g.drawRect (24*j, 24*i, 24, 24);
				}
			}
		}
	}

	/**
	 * @return the piece
	 */
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece p){
		piece = p;
		repaint();
	}
}
