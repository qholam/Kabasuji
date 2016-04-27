package entity;

import java.io.Serializable;
import java.util.ArrayList;

import view.TileView;

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
		pieces = new ArrayList<Piece>();
		this.level = level;
		this.numRows = numRows;
		this.numColumns = numColumns;
		boardGrid = new BoardTile[numColumns][numRows];
		
		for (int r = 0; r < this.numRows; r++) {
			for (int c = 0; c < this.numColumns; c++) {
				boardGrid[c][r] = new BoardTile(r, c);
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
	
	/** Adds a piece to the boar. The given row and column specify the position of the upperleft hand corner of the piece grid.
	 * @param p The piece to add to the board
	 * @param row The row in which the upper left hand tile of the piece grid will be placed
	 * @param col The column in which the upper left hand tile of the piece grid will be placed
	 */
	public boolean addPiece(Piece piece, int row, int col) {
		//create a copy of the piece
		//Piece p = new Piece(piece);
		Piece p = piece;
		
		//Ensure that the given row and column will be within bounds
		//TODO finish this
		if(row < 0 || row >= this.numRows || col < 0 || col >= this.numColumns)
			//return false;
		//Ensure that piece will fit on the board
		if(row+p.getMaxWidth() >= this.numRows || col+p.getMaxHeight() >= this.numColumns)
			//return false;
		
		//Check if piece can be legally placed based on the logistics of the level type
		if(level instanceof PuzzleLevel){
			//there can be no overlapping of pieces on the board
			for(int i = row; i < row + p.getMaxWidth(); i++){
				for(int j = col; i < col + p.getMaxHeight(); j++){
					if(boardGrid[j][i] == null || boardGrid[j][i].isCovered()) 
							return false;
				}
			}
			System.out.println("true meet");
		}
		
		//add piece to board
		int r = 0;
		int c = 0;
		PieceTile[][] pgrid = p.getpieceGrid();
		for(int i = row; i < row + p.getMaxWidth(); i++){
			for(int j = col; j < col + p.getMaxHeight(); j++){
				if(pgrid[c][r] != null){
					//piece is now covered
					boardGrid[j][i].cover();
					//set row and column of the piece tile
					pgrid[c][r].setCol(j);
					pgrid[c][r].setRow(i);
				}
				c++;
			}
			c = 0;
			r++;
		}
		
		//set the position of the upper left hand tile of the piece and keep track of it
		p.setColPos(col);
		p.setRowPos(row);
		pieces.add(p);
		
		return true;
	}
	
	/**
	 * Remove the piece at the specified row and column.
	 * @param row
	 * @param col
	 * @return
	 */
	public Piece removePieceAt(int row, int col){
		Piece p = null;
		
		//ensure there is a piece at the specified row and col
		if(!isLocatedAt(row, col)){
			return null;
		}
		
		//get the piece at the specified location
		p = getPieceAt(row, col);
		//remove the piece
		removePiece(p);
		
		return p;
	}
	
	/**
	 * Removes the given piece from the board
	 * @para p Piece to remove
	 */
	public void removePiece(Piece p){
		//ensures the given piece is actually on the board
		if(!pieces.contains(p))
			return;
		
		//get the piece tiles of the given piece and remove them(in this case the board tiles are just set to be uncovered) **this may need changing
		for(PieceTile pt: p.getPieceTiles()){
			//get row and column of piece tile
			int row = pt.getRow();
			int col = pt.getCol();
			
			//uncover the board tile located there
			boardGrid[col][row].uncover();
		}
	}
	
	/**
	 * Determines if there is a  piece that is located at the specified row and column on the board
	 */
	public boolean isLocatedAt(int row, int col){
		boolean isLocated = false;
		
		for(Piece p: pieces){
			System.out.println(p.getPieceTiles().size());
			//get all the piece tiles and see if they have the given row and col values
			for(PieceTile pt: p.getPieceTiles()){
				if(pt.getCol() == col && pt.getRow() == row)
					isLocated = true;
			}
		}
		
		return isLocated;
	}
	
	/**
	 * Gets the piece at the specified row and column, if applicable.
	 * @return
	 */
	public Piece getPieceAt(int row, int col){
		Piece piece = null;
		
		for(Piece p: pieces){
			System.out.println(p.getPieceTiles().size());
			//get all the piece tiles and see if they have the given row and col values
			for(PieceTile pt: p.getPieceTiles()){
				if(pt.getCol() == col && pt.getRow() == row)
					piece = p;
			}
		}
		
		return piece;
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
