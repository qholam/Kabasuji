package entity;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

import view.TileView;

public class Board implements Serializable {

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

	/**
	 * Constructor requires level reference and size specifications (rows and
	 * columns)
	 * 
	 * @param level
	 *            The level to which this board belongs
	 * @param numRows
	 *            The number of rows of tiles this board should have
	 * @param numColumns
	 *            The number of columns of tiles this board should have
	 */
	public Board(Level level, int numRows, int numColumns) {
		if (level instanceof ReleaseLevel){
			//boardGrid = (ReleaseTile[][]) boardGrid;
			boardGrid = new ReleaseTile[numColumns][numRows];
		} else {
			boardGrid = new BoardTile[numColumns][numRows];
		}
		pieces = new ArrayList<Piece>();
		this.level = level;
		this.numRows = numRows;
		this.numColumns = numColumns;

		for (int r = 0; r < this.numRows; r++) {
			for (int c = 0; c < this.numColumns; c++) {
				boardGrid[c][r] = new BoardTile(r, c);
			}
		}
	}

	/**
	 * Getter for number of rows in this board.
	 * 
	 * @return The number of rows in this board.
	 */
	public int getNumRows() {
		return numRows;
	}

	/**
	 * Getter for number of columns in this board.
	 * 
	 * @return The number of columns in this board.
	 */
	public int getNumColumns() {
		return numColumns;
	}

	/**
	 * Getter for the board grid used in this board.
	 * 
	 * @return The board grid of tiles used in this board.
	 */
	public BoardTile[][] getGrid() {
		return boardGrid;
	}

	/**
	 * Adds a piece to the boar. The given row and column specify the position
	 * of the upperleft hand corner of the piece grid.
	 * 
	 * @param p
	 *            The piece to add to the board
	 * @param row
	 *            The row in which the upper left hand tile of the piece grid
	 *            will be placed
	 * @param col
	 *            The column in which the upper left hand tile of the piece grid
	 *            will be placed
	 */
	public void addPiece(Piece p, int row, int col) {
		// add piece to board
		PieceTile[][] pgrid = p.getpieceGrid();
		int r = 0;
		int c = 0;
		for (int i = row; i < row + p.getMaxWidth(); i++) {
			for (int j = col; j < col + p.getMaxHeight(); j++) {
				if (i >= 0 && j >= 0 && i < numRows && j < numColumns && pgrid[c][r] != null) {
					//get color of piece tile
					Color color = pgrid[c][r].getColor();
					
					// piece is now covered
					boardGrid[j][i].cover();
					boardGrid[j][i].setColor(color);
					// set row and column of the piece tile
					pgrid[c][r].setCol(j);
					pgrid[c][r].setRow(i);
				}
				c++;
			}
			c = 0;
			r++;
		}

		// set the position of the upper left hand tile of the piece and keep
		// track of it
		p.setColPos(col);
		p.setRowPos(row);
		pieces.add(p);
	}

	/**
	 * Remove the piece at the specified row and column.
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public Piece removePieceAt(int row, int col) {
		Piece p = null;

		// ensure there is a piece at the specified row and col
		if (!isLocatedAt(row, col)) {
			return null;
		}

		// get the piece at the specified location
		p = getPieceAt(row, col);
		// remove the piece
		removePiece(p);

		pieces.remove(p);
		
		return p;
	}

	/**
	 * Removes the given piece from the board
	 * 
	 * @para p Piece to remove
	 */
	public void removePiece(Piece p) {
		// ensures the given piece is actually on the board
		if (!pieces.contains(p))
			return;
 
		// get the piece tiles of the given piece and remove them(in this case
		// the board tiles are just set to be uncovered) **this may need
		// changing
		for (PieceTile pt : p.getPieceTiles()) {
			// get row and column of piece tile
			int row = pt.getRow();
			int col = pt.getCol();

			// uncover the board tile located there
			boardGrid[col][row].uncover();
			boardGrid[col][row].setColor(Color.LIGHT_GRAY);
		}
	}

	/**
	 * Determine if a piece can be added at given row and column
	 */
	public boolean canAddAt(Piece p, int row, int col) {
		// simulate adding
		int r = 0;
		int c = 0;
		
		PieceTile[][] pgrid = p.getpieceGrid();
		for (int i = row; i < row + p.getMaxHeight(); i++) {
			for (int j = col; j < col + p.getMaxWidth(); j++) {
				if ((i < 0 || j < 0 || i >= numRows || j >= numColumns)) {//checks if pieces tiles will be places outside the boundaries of the board
					if (pgrid[c][r] != null)
						return false;
				} 
				else if(!(level instanceof LightningLevel) && boardGrid[j][i].isCovered() && pgrid[c][r] != null){//Tiles cannot overlap unless it is a lightning level
					return false;
				}
				else if(boardGrid[j][i].toString().equals(TileType.noTile) && pgrid[c][r] != null){//Ensures piece tiles are not placed on top of a location on the board in which no tile exists
					return false;
				}
				c++;
			}
			c = 0;
			r++;
		}
		
		return true;
	}

	/**
	 * Determines if there is a piece that is located at the specified row and
	 * column on the board
	 */
	public boolean isLocatedAt(int row, int col) {
		boolean isLocated = false;

		for (Piece p : pieces) {
			// System.out.println(p.getPieceTiles().size());
			// get all the piece tiles and see if they have the given row and
			// col values
			for (PieceTile pt : p.getPieceTiles()) {
				if (pt.getCol() == col && pt.getRow() == row)
					isLocated = true;
			}
		}

		return isLocated;
	}

	/**
	 * Gets the piece at the specified row and column, if applicable.
	 * 
	 * @return
	 */
	public Piece getPieceAt(int row, int col) {
		Piece piece = null;

		for (Piece p : pieces) {
			// System.out.println(p.getPieceTiles().size());
			// get all the piece tiles and see if they have the given row and
			// col values
			for (PieceTile pt : p.getPieceTiles()) {
				if (pt.getCol() == col && pt.getRow() == row){
					piece = p;
					break;
				}
			}
		}

		return piece;
	}
	
	/**
	 * Returns the number of uncovered board tiles left.
	 */
	public int getNumUncovered(){
		int num = 0;
		
		for (int r = 0; r < this.numRows; r++) {
			for (int c = 0; c < this.numColumns; c++) {
				if(!boardGrid[c][r].isCovered && boardGrid[c][r].toString().equals(TileType.boardTile))
					num++;
			} 
		}
		//System.out.println("num uncovered: " + num);
		return num;
		
	}
	
	/**
	 * Method that check if this board is valid to be used in the game.
	 * @return boolean True if board is valid
	 */
	public boolean isValid(){
		boolean valid = true;
		
		//check if any 
		
		return valid;
	}

	public Level getLevel() {
		return level;
	}
	
	public void setLevel(Level l){
		level = l;
	}

	/**
	 * Gets the number of rows on the board.
	 * 
	 * @return int number of rows on board.
	 */
	public int getRows() {
		return this.numRows;
	}

	/**
	 * Gets the number of columns on the board.
	 * 
	 * @return int number of columns on board.
	 */
	public int getColumns() {
		return this.numColumns;
	}
}
