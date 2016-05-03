package entity;
/**
 * Represents a tile on the board that cannot be used.
 * @author Quoc HoLam
 *
 */
public class NoTile extends BoardTile{	
	/**
	 * Constructor to create NoTile with given specifications. 
	 * @param row Row position of tile on board.
	 * @param col Column position of tile on board.
	 */
	public NoTile(int row, int col) {
		super(row, col);
	}
	
	/**
	 * String representation of the type of the tile.
	 * @return String tile type
	 */
	@Override
	public String toString(){
		return TileType.noTile;
	}
}
