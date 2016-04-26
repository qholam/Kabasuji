package entity;

import java.util.ArrayList;

public class Board { 
	
	// All pieces on board
	ArrayList<Piece> pieces;
	// The level to which this board belongs
	Level level;
	// The grid of tiles that makes up this board
	BoardTile[][] boardGrid;
	// The number of rows of tiles on this board
	int numRows;
	// The number of columns of tiles on this board
	int numColumns;
	
	/** Constructor requires level reference and size specifications (rows and columns) 
	 *  @param level The level to which this board belongs
	 *  @param numRows The number of rows of tiles this board should have
	 *  @param numColumns The number of columns of tiles this board should have
	 */
	public Board(Level level, int numRows, int numColumns) {
		this.level = level;
		this.numRows = numRows;
		this.numColumns = numColumns;
		boardGrid = new BoardTile[numColumns][numRows];
		
		for (int r = 0; r < this.numRows; r++) {
			for (int c = 0; c < this.numColumns; c++) {
				boardGrid[c][r] = new NoTile(r, c);
			}
		}
	}
	
	/** Getter for number of rows in this board.
	 * 
	 * @return The number of rows in this board.
	 */
	public int getNumRows() {
		return numRows;
	}
	
	/** Getter for number of columns in this board.
	 * 
	 * @return The number of columns in this board.
	 */
	public int getNumColumns() {
		return numColumns;
	}
	
	/** Getter for the board grid used in this board.
	 * 
	 * @return The board grid of tiles used in this board.
	 */
	public BoardTile[][] getGrid() {
		return boardGrid;
	}
	
	/** Adds a piece to the board ... ?
	 * @param p The piece to add to the board
	 */
	public boolean addPiece(Piece p) {
		// TODO
		return false;
	}
	
	public Level getLevel(){
		return level;
	}

	/**
	 * Gets the number of rows on the board.
	 * @return int number of rows on board.
	 */
	public int getRows(){
		return this.numRows;
	}
	
	/**
	 * Gets the number of columns on the board.
	 * @return int number of columns on board.
	 */
	public int getColumns(){
		return this.numColumns;
	}
}
