package entity;

import java.awt.Color;
import java.io.Serializable;

/**
 * @author Quoc HoLam
 * Abstract class which defines the behaviors of a tile.
 */
public abstract class Tile  implements Serializable{
	//Position of tile on the board, if applicable. A -1 indicates the the Tile is not on the board
	int row, col;
	
	public Tile(int row,int col){
		this.row = row;
		this.col = col;
	}
	
	/**
	 * Override of equals, sees if two tiles are equal.
	 * @return Boolean true if both pieces tiles are equal.
	 */
	@Override
	public boolean equals(Object obj){
		boolean equals = true;
		Tile other;
		
		if(!(obj instanceof Tile))
			//if obj isn't of type Tile then they cannot be equal
			equals = false;
		else{
			//cast to Tile
			other = (Tile) obj;
			
			equals = this.toString().equals(other.toString()) && this.row == other.getRow() && this.col == other.getCol();
		}
		
		return equals;
	}
	
	/**
	 * Provides information on the type of the tile. 
	 * To be overridden in subclasses.
	 * @return String
	 */
	public abstract String toString();
	
	/**
	 * Get row position of tile on the board.
	 * @return int Row position of tile on board. -1 is returned if the tile is currently not on the board.
	 */
	public int getRow() {
		return row;
	}
	/**
	 * Set the row of a tile.
	 * @param row New row of tile.
	 */
	public void setRow(int row) {
		this.row = row;
	}
	
	/**
	 * Get column position of tile on the board.
	 * @return int Column position of tile on board. -1 is returned if the tile is currently not on the board.
	 */
	public int getCol() {
		return col;
	}
	/**
	 * Set the column of a tile.
	 * @param row New column of tile.
	 */
	public void setCol(int col) {
		this.col = col;
	}
	
	/**
	 * Get the background color of the tile based on the type of the tile
	 */
	public Color getColor(){
		switch(this.toString()){
		case TileType.pieceTile:
			return Color.ORANGE;
		default:
			//default color for all board tiles(including lightning and release)
			//NoTile is not visible so it does not matter what color it is
			return Color.LIGHT_GRAY;
		}
	}
}
