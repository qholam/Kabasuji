package entity;
/**
 * Represents a tile on the board that cannot be used.
 * @author Quoc HoLam
 *
 */
public class NoTile extends BoardTile{

	/**
	 * Constructs a no tile on the board. This tile cannot have a piece cover it
	 * @param row
	 * @param col
	 */
	public NoTile(int row, int col) {
		super(row, col);
	}
	
	/**
	 * String representation of the type of the tile
	 * @return String tile type
	 */
	@Override
	public String toString(){
		return TileType.noTile;
	}
}
