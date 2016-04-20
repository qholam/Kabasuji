package entity;
/**
 * represents a tile on the release board.
 * @author Quoc HoLam
 *
 */
public class ReleaseTile extends Tile{
	Number num;
	/**
	 * Constructor to create ReleaseTile with given specifications. 
	 * @param row Row position of tile on board.
	 * @param col Column position of tile on board.
	 * @param Number Number to associate with this tile.
	 */
	public ReleaseTile(int row, int col, Number n) {
		super(row, col);
		
		num = n;
	}

	@Override
	public String toString() {
		return TileType.releaseTile;
	}

}
