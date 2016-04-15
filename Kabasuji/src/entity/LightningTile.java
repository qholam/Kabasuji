package entity;
/**
 * Represents a lightning tile on the board
 * @author Quoc HoLam
 *
 */
public class LightningTile extends BoardTile{

	public LightningTile(int row, int col) {
		super(row, col);
	}
	
	/**
	 * String representation of the tile type
	 * @return String tile type
	 */
	@Override
	public String toString(){
		return TileType.lightningTile;
	}

}
