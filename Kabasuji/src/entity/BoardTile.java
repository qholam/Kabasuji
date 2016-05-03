package entity;

import java.awt.Color;
import java.io.Serializable;

/**
 * Represent a tile on the board.
 * @author Quoc HoLam
 *
 */
public class BoardTile extends Tile{
	//determines whether this BoardTile is cover by a {@link PieceTile}
	boolean isCovered;
	Color c;
	
	/**
	 * Constructor to create BoardTile with given specifications. 
	 * @param row Row position of tile on board.
	 * @param col Column position of tile on board.
	 */
	public BoardTile(int row, int col) {
		super(row, col);
		isCovered = false;
		
		c = Color.LIGHT_GRAY;
	}

	@Override
	/**
	 * Provides info on the type of the tile.
	 * @return String type of the tile.
	 */
	public String toString() {
		return TileType.boardTile;
	}

	/**
	 * Board tile is covered by a {@link PieceTile}.
	 */
	public void cover(){
		isCovered = true;
	}
	
	/**
	 * Board tile is uncovered.
	 */
	public void uncover(){
		isCovered = false;
	}
	
	/**
	 * Checks if boardtile is covered.
	 * @return boolean true if covered.
	 */
	public boolean isCovered(){
		return this.isCovered;
	}
	
	/** Getter for the color of this piece.
	 * @return The color of the piece.
	 */
	@Override
	public Color getColor(){
		return c;
	}
	
	/** Sets the color for this board tile.
	 * 
	 * @param col The color we want to set this tile to.
	 */
	public void setColor(Color col){
		c = col;
	}
}
