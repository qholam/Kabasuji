package entity;
/**
 * @author Tommy
 * Abstract class which defines the behaviors of a tile
 */
public abstract class Tile {
	//position of tile on the board, if applicable
	int row, col;
	
	public Tile(int row,int col){
		this.row = row;
		this.col = col;
	}
	
	/**
	 * Provides information on the type of the tile. 
	 * To be overridden in subclasses
	 * @return String
	 */
	public abstract String toString();
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
}
