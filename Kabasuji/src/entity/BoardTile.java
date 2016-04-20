package entity;

/**
 * Represent a tile on the board.
 * @author Quoc HoLam
 *
 */
public class BoardTile extends Tile{
	//determines whether this BoardTile is cover by a {@link PieceTile}
	boolean isCovered;
	
	/**
	 * Constructor to create BoardTile with given specifications. 
	 * @param row Row position of tile on board.
	 * @param col Column position of tile on board.
	 */
	public BoardTile(int row, int col) {
		super(row, col);
		isCovered = false;
	}

	@Override
	/**
	 * Provides info on the type of the tile.
	 * @return String type of the tile
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
}
