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
		
		rowInPieceContainer = -1;
		colInPieceContainer = -1;
	}

	public void setPieceGridRow(int r){
		rowInPieceContainer = r;
	}
	
	public void setPieceGridCol(int c){
		colInPieceContainer = c;
	}
	
	public int getPieceGridRow(){
		return rowInPieceContainer;
	}
	
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
	
	@Override
	public Color getColor(){
		return c;
	}
	
	public void setColor(Color col){
		c = col;
	}
}
