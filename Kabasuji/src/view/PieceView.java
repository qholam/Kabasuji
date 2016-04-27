package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import GUI.KabasujiFrame;
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
	
	Boolean repaint = true;
	
	public PieceView(Piece p) {
		super();
		
		piece = p;
		Tile[][] g = p.getpieceGrid();  
		
		setLayout(new GridLayout(p.getMaxHeight(), p.getMaxWidth(), 0, 0));
		tilesView = new TileView[p.getMaxHeight()][p.getMaxWidth()];
		for(int i = 0; i < p.getMaxHeight(); i++){
			for(int j = 0; j < p.getMaxWidth(); j++){
				tilesView[j][i] = new TileView(g[j][i]);
				//tilesView[j][i].setVisible(false);
				add(tilesView[j][i]);
			}
		}	
		
		setPreferredSize(new Dimension(6 * KabasujiFrame.tileWidth, 6 * KabasujiFrame.tileHeight));
		//The panel holding the piece should not be visible.
		this.setOpaque(false);
	} 
	
	/**
	 * Properly update the displayed info on this {@link Piece}
	 */
	@Override 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Tile[][] grid = piece.getpieceGrid();
		
		for(int i = 0; i < tilesView.length; i++){
			for(int j = 0; j < tilesView[i].length; j++){
				tilesView[j][i].setTile(grid[j][i]);
				//tilesView[j][i].setRepaintValid();
			}
		}	
		
		/*
		for(int i = 0; i < tilesView.length; i++){
			for(int j = 0; j < tilesView[i].length; j++){
				if(piece.getpieceGrid()[j][i] != null){
					int tw = KabasujiFrame.tileWidth;
					int th = KabasujiFrame.tileHeight;
					g.setColor(piece.getpieceGrid()[j][i].getColor());
					g.fillRect(tw*j, th*i, tw, th);
					g.setColor(Color.black);
					g.drawRect(tw*j, th*i, tw, th);
				}
			}
		}*/
		
	}

	@Override
	public void repaint(){
		if(repaint != null && repaint){
			super.repaint();
			repaint = false;
		}
	}
	
	
	/**
	 * this is needed to prevent flickering when dragging inside the board.
	 * TODO: find another way to prevent this flickering
	 */
	public void setRepaintInvalid(){
		repaint = false;
		for(int i = 0; i < tilesView.length; i++){
			for(int j = 0; j < tilesView[i].length; j++){
				tilesView[j][i].setRepaintInvalid();
			}
		}
	}
	
	/**
	 * this is needed to prevent flickering when dragging inside the board.
	 * TODO: find another way to prevent this flickering
	 */
	public void setRepaintValid(){
		repaint = true;
		repaint();
		for(int i = 0; i < tilesView.length; i++){
			for(int j = 0; j < tilesView[i].length; j++){
				tilesView[j][i].setRepaintValid();
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
		//this.setRepaintValid();
	}
}
