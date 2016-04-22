package view;

import javax.swing.JPanel;

import entity.BoardTile;
import entity.PieceTile;
import entity.Tile;
import entity.TileType;

import java.awt.Graphics;
import java.awt.Color;
/**
 * @author Quoc HoLam
 * View for Tiles
 */
public class TileView extends JPanel{
	//Tile that this view represents
	Tile tile;

	/**
	 * Constructor for TileView
	 * @param t Given {@link Tile} that this view will represent
	 */
	public TileView(Tile t){
		super();
		
		//TODO set a proper size based on the grids of a board
		setSize(100,100);
		setLayout(null);
		
		tile = t;
		
		//check if tile is null(this only occurs when in a Piece)
		if(tile == null)
			setBackground(Color.WHITE);
		else
			setBackground(tile.getColor());
	}
	
	/**
	 * Properly update the displayed info on this {@link Tile}
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//check if tile is null(this only occurs when in a Piece)
		if(tile == null)
			setBackground(Color.WHITE);
		else
			setBackground(tile.getColor());
	}

	/**
	 * @return the tile
	 */
	public Tile getTile() {
		return tile;
	}

	/**
	 * @param tile the tile to set
	 */
	public void setTile(Tile tile) {
		this.tile = tile;
		this.repaint();
	}
}
