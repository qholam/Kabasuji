package entity;
/**
 * Representation of a piece
 * Pieces consists of either PieceTile or nulls(indicating that there is no tile there)
 * NOTE: no testing has been done
 * @author Quoc HoLam
 *
 */
public class Piece{
	//grid of all the PieceTiles that this Piece is made of
	PieceTile[][] shapeGrid;
	//NOT SURE WHAT THIS IS
	Tile origin;
	
	//parameters of class
	private final int maxWidth = 6;
	private final int maxHeight = 6;
	
	//TODO what should be added in parameters to specify shape of piece
	/**
	 * Constructor to create a piece
	 */
	public Piece(){
		//create the grid of maxWidth and maxHeight
		shapeGrid = new PieceTile[maxWidth][maxHeight];
	}
	
	/**
	 * Rotates a piece clockwise, a piece is mutated rather than having a new instance be made
	 * @param PieceTile[][] array of {@link PieceTile}
	 * @return PieceTile[][] returns the given array after rotating it clockwise
	 */
	public PieceTile[][] rotateClockwise(PieceTile[][] a){
		int w = a.length;
		int h = a[0].length;
		PieceTile[][] arr = new PieceTile[w][h];
		
		for (int i = 0; i < h; ++i) {
	        for (int j = 0; j < w; ++j) {
	            arr[i][j] = a[w - j - 1][i];
	        }
	    }
		
		return arr;
	}
	
	/**
	 * Rotates a piece counterclockwise, a piece is mutated rather than having a new instance be made
	 * @param PieceTile[][] array of {@link PieceTile}
	 * @return PieceTile[][] returns the given array after rotating it counterclockwise
	 */
	public PieceTile[][] rotateCounterclockwise(PieceTile[][] a){
		int w = a.length;
		int h = a[0].length;
		PieceTile[][] arr = new PieceTile[w][h];
		
		for (int i = 0; i < h; ++i) {
	        for (int j = 0; j < w; ++j) {
	            arr[i][j] = a[j][h - i - 1];
	        }
	    }
		
		return arr;
	}
	
	/**
	 * Vertically flips an array
	 * @param PieceTile[][] array of {@link PieceTile}
	 * @return PieceTile[][] returns the given array after flipping it vertically
	 */
	public PieceTile[][] verticalFlip(PieceTile[][] a){
		int w = a.length;
		int h = a[0].length;
		PieceTile[][] arr = new PieceTile[h][w];
	    for (int i = 0; i < h; i++) {
	        for (int j = 0; j < w; j++) {
	            arr[h - i - 1][j] = a[i][j];
	        }
	    }
	    
	    return arr;	
	}
	
	/**
	 * Horizontally flips an array
	 * @param PieceTile[][] array of {@link PieceTile}
	 * @return PieceTile[][] returns the given array after flipping it horizontally
	 */
	public PieceTile[][] horizontalFlip(PieceTile[][] a){
		int w = a.length;
		int h = a[0].length;
		PieceTile[][] arr = new PieceTile[h][w];
	    for (int i = 0; i < h; i++) {
	        for (int j = 0; j < w; j++) {
	            arr[i][w - j - 1] = a[i][j];
	        }
	    }
	    
	    return arr;
	}
	
	/**
	 * Make a string representation of this Piece
	 * @return String string representation of this piece
	 */
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
}
