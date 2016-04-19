package entity;
/**
 * Represents a tile of a {@link Piece}
 * @author Quoc HoLam
 *
 */
public class PieceTile extends Tile {
	/**
	 * Default constructor to create a piece tile that is initially not on the board.
	 */
	public PieceTile(){
		//PieceTile initially not on the board
		super(-1,-1);
	}
	
	/**
	 * constructor to create piece tile
	 * @param row row on board
	 * @param col col on board
	 */
	public PieceTile(int row, int col){
		super(row,col);
	}

	@Override
	/**
	 * Returns the type of the tile
	 * @return String string that represents the type of the tile
	 */
	public String toString() {
		return TileType.pieceTile;
	}
}
