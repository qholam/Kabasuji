package entity;

import java.awt.Color;

/**
 * Represents a tile of a {@link Piece}.
 * @author Quoc HoLam
 *
 */
public class PieceTile extends Tile {
	//used to track a a piece tiles position within its piece grid container.
	int rowInPieceContainer, colInPieceContainer;
	
	Color c;
	/**
	 * Default constructor to create a piece tile that is initially not on the board.
	 */
	public PieceTile(){
		//PieceTile initially not on the board
		super(-1,-1);
		
		rowInPieceContainer = -1;
		colInPieceContainer = -1; 
		
		//set color of tile
		c = PieceTileColor.boardPieceColors[PieceTileColor.index % PieceTileColor.boardPieceColors.length];
	}
	
	/**
	 * constructor to create piece tile.
	 * @param row row on board.
	 * @param col col on board.
	 */
	public PieceTile(int row, int col){
		super(row,col);
		
		rowInPieceContainer = row;
		colInPieceContainer = col;
		c = PieceTileColor.boardPieceColors[PieceTileColor.index % PieceTileColor.boardPieceColors.length];
	}

	/**
	 * Set the current row in the PieceGrid.
	 * @param r int to set row.
	 */
	public void setPieceGridRow(int r){
		rowInPieceContainer = r;
	}
	
	/**
	 * Set the current column in the PieceGrid.
	 * @param c int to set col.
	 */
	public void setPieceGridCol(int c){
		colInPieceContainer = c;
	}
	/**
	 * Return current row in PieceGrid.
	 * @return int current row in PieceGrid.
	 */
	public int getPieceGridRow(){
		return rowInPieceContainer;
	}
	/**
	 * Return current column in PieceGrid.
	 * @return int current column in PieceGrid.
	 */
	public int getPieceGridCol(){
		return colInPieceContainer;
	}

	@Override
	/**
	 * Returns the type of the tile.
	 * @return String string that represents the type of the tile.
	 */
	public String toString() {
		return TileType.pieceTile;
	}
	
	/**
	 * return Color of PieceTile.
	 * @return Color current color of PieceTile.
	 */
	@Override
	public Color getColor(){
		return c;
	}
	
	/**
	 * Set PieceTile color.
	 * @param col new color for PieceTile.
	 */
	public void setColor(Color col){
		c = col;
	}
}
