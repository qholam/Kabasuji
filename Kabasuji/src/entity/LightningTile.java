package entity;
/**
 * Represents a lightning tile on the board.
 * @author Quoc HoLam
 *
 */
public class LightningTile extends BoardTile{

	/**
	 * Constructor to create LightningTile with given specifications. 
	 * @param row Row position of tile on board.
	 * @param col Column position of tile on board.
	 */
	public LightningTile(int row, int col) {
		super(row, col);
	}
	
	/**
	 * String representation of the tile type.
	 * @return String tile type.
	 */
	@Override
	public String toString(){
		return TileType.lightningTile;
	}

}
