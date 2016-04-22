package entity;
/**
 * Representation of a piece.
 * Pieces consists of either PieceTile or nulls(indicating that there is no tile there).
 * NOTE: no testing has been done.
 * @author Quoc HoLam
 *
 */
public class Piece{
	//grid of all the PieceTiles that this Piece is made of
	PieceTile[][] shapeGrid;
	//The (row, col) of the upper-left hand corner of the shapeGrid of the Piece on the board, if applicable
	int rowPos, colPos;
	
	//parameters of class
	private final int maxWidth = 6;
	private final int maxHeight = 6;

	/**
	 * Default constructor to create a piece. To be used for method testing.
	 */
	public Piece(){
		//create the grid of maxWidth and maxHeight, intially empty
		shapeGrid = new PieceTile[maxHeight][maxWidth];

		//Piece initially not on a board;
		rowPos = -1;
		colPos = -1;
		
	}
	
	/**
	 * Construct to create a piece, that allows for specification of piece shape.
	 * @param arr 2-D boolean array to specify the desired shape of the piece.
	 * @throws Exception Throws exception if the dimensions of the 2d boolean array doesnt not match that of the piece's.
	 */
	public Piece(boolean[][] arr) throws Exception{
		//make sure the given 2d array has the same dimensions as a piece
		if(arr.length != maxHeight || arr[0].length != maxWidth)
			throw new Exception("Array must be of size " + maxHeight + " by " + maxWidth);
		if(!isValid(arr))
			throw new Exception("Invalid array");
		
		shapeGrid = new PieceTile[maxWidth][maxHeight];
		
		for(int i = 0; i < maxHeight; i++){
			for(int j = 0; j < maxWidth; j++){
				if(arr[i][j])
					shapeGrid[i][j] = new PieceTile(i, j);
			}
		}	
	}
	
	/**
	 * Add given {@link PieceTile} to the (row,col) specified by the {@link PieceTile}.
	 * @param PieceTile PieceTile to add.
	 * @param int row of shapeGrid to add {@link PieceTile} to.
	 * @param int col of shapeGrid to add {@link PieceTile} to.
	 */
	public void addTile(PieceTile p, int row, int col){
		this.shapeGrid[row][col] = p;
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
	public void rotateClockwise(){
		int w = this.shapeGrid.length;
		int h = this.shapeGrid[0].length;
		PieceTile[][] arr = new PieceTile[w][h];
		
		for (int i = 0; i < h; i++) {
	        for (int j = 0; j < w; j++) {
	        	//row and col of the tile [i][j] in the array to keep track of it position on the board
	        	int row = -1;
	        	int col = -1;
	        	if(this.shapeGrid[i][j] != null){
	        		row = this.shapeGrid[i][j].getRow();
	        		col = this.shapeGrid[i][j].getCol(); 
	        	} 
	        	//Tile to be placed in row i col j of the new shapeGrid
	        	PieceTile tile = this.shapeGrid[w - j - 1][i];
	        	
	            arr[i][j] = tile;
	            
	            //update the row and col of the PieceTile on the board
	            if(arr[i][j] != null){
		            arr[i][j].setRow(row);
		            arr[i][j].setCol(col);
	            }
	        }
	    }
		
		this.shapeGrid = arr;
	}
	
	/**
	 * Rotates a piece counterclockwise, a piece is mutated rather than having a new instance be made.
	 * @return PieceTile[][] returns the given array after rotating it counterclockwise.
	 */
	public void rotateCounterclockwise(){
		int w = this.maxWidth;
		int h = this.maxHeight;
		PieceTile[][] arr = new PieceTile[w][h];
		
		for (int i = 0; i < h; i++) {
	        for (int j = 0; j < w; j++) {
	        	//row and col of the tile [i][j] in the array to keep track of it position on the board
	        	int row = -1;
	        	int col = -1;
	        	if(this.shapeGrid[i][j] != null){
	        		row = this.shapeGrid[i][j].getRow();
	        		col = this.shapeGrid[i][j].getCol(); 
	        	} 
	        	//Tile to be placed in row i col j of the new shapeGrid
	        	PieceTile tile = this.shapeGrid[j][h - i - 1];
	        	
	            arr[i][j] = tile;
	            //update the row and col of the piece
	            if(arr[i][j] != null){
		            arr[i][j].setRow(row);
		            arr[i][j].setCol(col);
	            }
	        }
	    }
		
		this.shapeGrid = arr;
	}
	
	/**
	 * Vertically flips an array.
	 * @return PieceTile[][] returns the given array after flipping it vertically.
	 */
	public void verticalFlip(){
		int w = this.maxWidth;
		int h = this.maxHeight;
		PieceTile[][] arr = new PieceTile[h][w];
	    for (int i = 0; i < h; i++) {
	        for (int j = 0; j < w; j++) {
	        	//row and col of the tile [i][j] in the array to keep track of it position on the board
	        	int row = -1;
	        	int col = -1;
	        	if(this.shapeGrid[i][j] != null){
	        		row = this.shapeGrid[i][j].getRow();
	        		col = this.shapeGrid[i][j].getCol(); 
	        	}
	        	//Tile to be placed in row i col j of the new shapeGrid
	        	PieceTile tile = this.shapeGrid[h - i - 1][j];
	        	
	            arr[i][j] = tile; 
	            //update the row and col of the piece
	            if(arr[i][j] != null){
		            arr[i][j].setRow(row);
		            arr[i][j].setCol(col);
	            }
	        }
	    }
	    
	    this.shapeGrid = arr;	
	}
	
	/**
	 * Horizontally flips an array.
	 * @return PieceTile[][] returns the given array after flipping it horizontally.
	 */
	public void horizontalFlip(){
		int w = this.shapeGrid.length;
		int h = this.shapeGrid[0].length;
		PieceTile[][] arr = new PieceTile[h][w];
	    for (int i = 0; i < h; i++) {
	        for (int j = 0; j < w; j++) {
	        	//row and col of the tile [i][j] in the array to keep track of it position on the board
	        	int row = -1;
	        	int col = -1;
	        	if(this.shapeGrid[i][j] != null){
	        		row = this.shapeGrid[i][j].getRow();
	        		col = this.shapeGrid[i][j].getCol(); 
	        	}
	        	//Tile to be placed in row i col j of the new shapeGrid
	        	PieceTile tile = this.shapeGrid[i][w - j - 1]; 
	        	
	            arr[i][j] = tile;
	            //update the row and col of the piece
	            if(arr[i][j] != null){
		            arr[i][j].setRow(row);
		            arr[i][j].setCol(col);
	            }
	        }
	    }
	    
	    this.shapeGrid = arr;
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
				if(shapeGrid[i][j] == null)//possibly change this to have a no piece tile instead of null?
					str += TileType.noTile;
				else
					str += shapeGrid[i][j].toString();
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
					PieceTile t = this.shapeGrid[i][j];
					PieceTile o = other.shapeGrid[i][j];
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
	 * @return the maxWidth
	 */
	public int getMaxWidth() {
		return this.maxWidth;
	}

	/**
	 * @return the maxHeight
	 */
	public int getMaxHeight() {
		return this.maxHeight;
	}

	/**
	 * Update the col position of the upperleft hand corner of a piece relative to the board.
	 * @param int New col.
	 */
	public void seColPos(int n){
		this.colPos = n;
	}
	
	/**
	 * @return the shapeGrid
	 */
	public PieceTile[][] getShapeGrid() {
		return this.shapeGrid;
	}
}
