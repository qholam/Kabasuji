package entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Representation of a piece.
 * Pieces consists of either PieceTile or nulls(indicating that there is no tile there).
 * NOTE: no testing has been done.
 * @author Quoc HoLam
 *
 */
public class Piece  implements Serializable{
	//grid of all the PieceTiles that this Piece is made of
	PieceTile[][] pieceGrid;
	//The (row, col) of the upper-left hand corner of the pieceGrid of the Piece on the board, if applicable
	//this may be helpful when adding a piece to the board through a drag
	int rowPos, colPos;
	//piece tiles contained by the grid
	ArrayList <PieceTile> pieceTiles = new ArrayList<PieceTile>();
	
	//parameters of class
	private final int maxWidth = 6;  
	private final int maxHeight = 6;

	/**
	 * Default constructor to create a piece. To be used for method testing.
	 */
	public Piece(){
		//create the grid of maxWidth and maxHeight, intially empty
		pieceGrid = new PieceTile[maxHeight][maxWidth];
		
		//Piece initially not on a board;
		rowPos = -1;
		colPos = -1;
		
		//updates index so that next piece created is different color
		PieceTileColor.index++;
	} 	
	
	/**
	 * Clones the given piece.
	 * @param p
	 */
	public Piece(Piece p){
		pieceGrid = new PieceTile[maxHeight][maxWidth];
		//this.pieceGrid = p.pieceGrid;
		for(int r = 0; r < maxWidth; r++){
			for(int c = 0; c < maxHeight; c++){
				if(p.getpieceGrid()[c][r] != null)
					pieceGrid[c][r] = new PieceTile(r, c);
			}
		}	
		
		rowPos = p.rowPos;
		colPos = p.colPos;
		
		//updates index so that next piece created is different color
		//PieceTileColor.index = PieceTileColor.index % PieceTileColor.boardPieceColors.length;
		PieceTileColor.index++;
	}
	
	/**
	 * Construct to create a piece, that allows for specification of piece shape.
	 * @param arr 2-D boolean array to specify the desired shape of the piece.
	 * @throws Exception Throws exception if the dimensions of the 2d boolean array doesn't not match that of the piece's.
	 */
	public Piece(boolean[][] arr) throws Exception{
		//make sure the given 2d array has the same dimensions as a piece
		if(arr.length != maxHeight || arr[0].length != maxWidth)
			throw new Exception("Array must be of size " + maxHeight + " by " + maxWidth);
		if(!isValid(arr))
			throw new Exception("Invalid array");
		
		pieceGrid = new PieceTile[maxWidth][maxHeight];
		
		for(int r = 0; r < maxWidth; r++){
			for(int c = 0; c < maxHeight; c++){
				if(arr[c][r])
					pieceGrid[c][r] = new PieceTile(r, c); 
			}
		}	
		
		PieceTileColor.index = PieceTileColor.index % PieceTileColor.boardPieceColors.length;
	} 
	
	/**
	 * Add given {@link PieceTile} to the (row,col) specified by the {@link PieceTile}.
	 * @param PieceTile PieceTile to add.
	 * @param int row of pieceGrid to add {@link PieceTile} to.
	 * @param int col of pieceGrid to add {@link PieceTile} to.
	 */
	public void addTile(PieceTile p, int row, int col){
		this.pieceGrid[col][row] = p;
		p.setPieceGridCol(col);
		p.setPieceGridRow(row);
	}
	
	/**
	 * Method to check if a given 2-d boolean array will result in a valid piece.
	 * @param arr Given 2-d boolean array that specifies properties of a piece.
	 */
	public boolean isValid(boolean[][] arr){
		boolean valid = true;
		
		//TODO
		
		return valid;
	}
	
	/**
	 * Rotates a piece clockwise, a piece is mutated rather than having a new instance be made.
	 * @return PieceTile[][] returns the given array after rotating it clockwise.
	 */
	public void rotateCounterclockwise(){
		int w = this.pieceGrid.length;
		int h = this.pieceGrid[0].length;
		PieceTile[][] arr = new PieceTile[w][h];
		
		for (int i = 0; i < h; i++) {
	        for (int j = 0; j < w; j++) {
	        	//row and col of the tile [i][j] in the array to keep track of it position on the board
	        	int row = -1;
	        	int col = -1;
	        	if(this.pieceGrid[i][j] != null){
	        		row = this.pieceGrid[i][j].getRow();
	        		col = this.pieceGrid[i][j].getCol(); 
	        	} 
	        	//Tile to be placed in row i col j of the new pieceGrid
	        	PieceTile tile = this.pieceGrid[w - j - 1][i];
	        	
	            arr[i][j] = tile;
	            
	            //update the row and col of the PieceTile on the board and in the piece grid
	            if(arr[i][j] != null){
		            arr[i][j].setRow(row);
		            arr[i][j].setCol(col);
		            
		            arr[i][j].setPieceGridRow(j);
		            arr[i][j].setPieceGridCol(i);
	            }
	        }
	    }
		 
		this.pieceGrid = arr;
	}
	
	/**
	 * Rotates a piece counterclockwise, a piece is mutated rather than having a new instance be made.
	 * @return PieceTile[][] returns the given array after rotating it counterclockwise.
	 */
	public void rotateClockwise(){
		int w = this.maxWidth;
		int h = this.maxHeight;
		PieceTile[][] arr = new PieceTile[w][h];
		
		for (int i = 0; i < h; i++) {
	        for (int j = 0; j < w; j++) {
	        	//row and col of the tile [i][j] in the array to keep track of it position on the board
	        	int row = -1;
	        	int col = -1;
	        	if(this.pieceGrid[i][j] != null){
	        		row = this.pieceGrid[i][j].getRow();
	        		col = this.pieceGrid[i][j].getCol(); 
	        	} 
	        	//Tile to be placed in row i col j of the new pieceGrid
	        	PieceTile tile = this.pieceGrid[j][h - i - 1];
	        	
	            arr[i][j] = tile;
	            //update the row and col of the piece and piece grid
	            if(arr[i][j] != null){
		            arr[i][j].setRow(row);
		            arr[i][j].setCol(col);
		            
		            arr[i][j].setPieceGridRow(j);
		            arr[i][j].setPieceGridCol(i);
	            }
	        }
	    }
		
		this.pieceGrid = arr;
	}
	
	/**
	 * Vertically flips an array.
	 * @return PieceTile[][] returns the given array after flipping it vertically.
	 */
	public void horizontalFlip(){
		int w = this.maxWidth;
		int h = this.maxHeight;
		PieceTile[][] arr = new PieceTile[h][w];
	    for (int i = 0; i < h; i++) {
	        for (int j = 0; j < w; j++) {
	        	//row and col of the tile [i][j] in the array to keep track of it position on the board
	        	int row = -1;
	        	int col = -1;
	        	if(this.pieceGrid[i][j] != null){
	        		row = this.pieceGrid[i][j].getRow();
	        		col = this.pieceGrid[i][j].getCol(); 
	        	}
	        	//Tile to be placed in row i col j of the new pieceGrid
	        	PieceTile tile = this.pieceGrid[h - i - 1][j];
	        	
	            arr[i][j] = tile; 
	            //update the row and col of the piece and piece grid
	            if(arr[i][j] != null){
		            arr[i][j].setRow(row);
		            arr[i][j].setCol(col);
		            
		            arr[i][j].setPieceGridRow(j);
		            arr[i][j].setPieceGridCol(i);
	            }
	        }
	    }
	    
	    this.pieceGrid = arr;	
	}
	
	/**
	 * Horizontally flips an array.
	 * @return PieceTile[][] returns the given array after flipping it horizontally.
	 */
	public void verticalFlip(){
		int w = this.pieceGrid.length;
		int h = this.pieceGrid[0].length;
		PieceTile[][] arr = new PieceTile[h][w];
	    for (int i = 0; i < h; i++) {
	        for (int j = 0; j < w; j++) {
	        	//row and col of the tile [i][j] in the array to keep track of it position on the board
	        	int row = -1;
	        	int col = -1;
	        	if(this.pieceGrid[i][j] != null){
	        		row = this.pieceGrid[i][j].getRow();
	        		col = this.pieceGrid[i][j].getCol(); 
	        	}
	        	//Tile to be placed in row i col j of the new pieceGrid
	        	PieceTile tile = this.pieceGrid[i][w - j - 1]; 
	        	
	            arr[i][j] = tile;
	            //update the row and col of the piece and piece grid
	            if(arr[i][j] != null){
		            arr[i][j].setRow(row);
		            arr[i][j].setCol(col);
		            
		            arr[i][j].setPieceGridRow(j);
		            arr[i][j].setPieceGridCol(i);
	            }
	        }
	    }
	    
	    this.pieceGrid = arr;
	}
	
	/**
	 * Make a string representation of this Piece.
	 * @return String string representation of this piece.
	 */
	@Override
	public String toString(){
		String str = "";
		
		for(int i = 0; i < this.maxWidth; i++){
			for(int j = 0; j < this.maxHeight; j++){
				if(pieceGrid[i][j] == null)//possibly change this to have a no piece tile instead of null?
					str += TileType.noTile;
				else
					str += pieceGrid[i][j].toString();
			}
			
			str += "\n";
		}
		
		return str;
	}
	
	/**
	 * Override of equals, used to test the methods that mutate the piece.
	 * @param Piece Other Piece to compare this Piece to.
	 * @return Boolean true if both pieces are equal.
	 */
	@Override
	public boolean equals(Object obj){
		boolean equals = true;
		Piece other;
		
		if(!(obj instanceof Piece))
			//if obj isn't of type Piece then they cannot be equal
			equals = false;
		else{
			//cast to Piece
			other = (Piece) obj;
			
			//go through both shape grids and make sure the piece tiles in each (row, col) are equal
			for(int i = 0; i < this.maxHeight; i++){
				for(int j = 0; j < this.maxWidth; j++){
					PieceTile t = this.pieceGrid[i][j];
					PieceTile o = other.pieceGrid[i][j];
					if(t == null && o == null){
					}
					else if(t == null && o != null || t != null && o == null)
						equals = false;
					else if(!t.equals(o))
						equals = false;	
				}
			}
		}
		
		return equals;
	}
	
	/**
	 * Update the row position of the upperleft hand corner of a piece relative to the board.
	 * @param int New row.
	 */
	public void setRowPos(int n){
		this.rowPos = n;
	}
	
	/**
	 * @return the maxWidth.
	 */
	public int getMaxWidth() {
		return this.maxWidth;
	}

	/**
	 * @return the maxHeight.
	 */
	public int getMaxHeight() {
		return this.maxHeight;
	}

	/**
	 * Update the col position of the upperleft hand corner of a piece relative to the board.
	 * @param int New col.
	 */
	public void setColPos(int n){
		this.colPos = n;
	}
	
	/**
	 * @return the colPos.
	 */
	public int getColPos(){
		return colPos;
	}
	
	/**
	 * @return the rowPos.
	 */
	public int getRowPos(){
		return rowPos;
	}
	
	/**
	 * @return the pieceGrid.
	 */
	public PieceTile[][] getpieceGrid() {
		return this.pieceGrid;
	}
	
	/**
	 * @return The PieceTiles on the grid.
	 */
	public ArrayList<PieceTile> getPieceTiles(){
		pieceTiles = new ArrayList<PieceTile>();
		
		for(int r = 0; r < pieceGrid.length; r++){
			for(int c = 0; c < pieceGrid[0].length; c++){
				if(pieceGrid[c][r] != null){
					pieceTiles.add(pieceGrid[c][r]);
				}
			}
		}
		
		return pieceTiles;
	}
}
