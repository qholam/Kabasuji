package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Board implements Serializable{ 
	
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
	 * @param row The row in which the upper left hand tile of the piece grid will be placed
	 * @param col The column in which the upper left hand tile of the piece grid will be placed
	 */
	public boolean addPiece(Piece p, int row, int col) {
		//Ensure that the given row and column will be within bounds
		if(row < 0 || row >= this.numRows || col < 0 || col >= this.numColumns)
			return false;
		//Ensure that piece will fit on the board
		if(row+p.getMaxWidth() >= this.numRows || col+p.getMaxHeight() >= this.numColumns)
			return false;
		
		//Check if piece can be legally placed based on the logistics of the level type
		if(level instanceof PuzzleLevel){
			//there can be no overlapping of pieces on the board
			for(int i = row; i < row + p.getMaxWidth(); i++){
				for(int j = col; i < col + p.getMaxHeight(); j++){
					
				}
			}
			
		}
		
		return true;
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
