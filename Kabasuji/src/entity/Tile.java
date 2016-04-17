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
	 * Override of equals, sees if two tiles are equal
	 * @return Boolean true if both pieces tiles are equal
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
