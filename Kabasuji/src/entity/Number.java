package entity;

import java.awt.Color;
import java.io.Serializable;

/**
 * Numbers for releaseTiles.
 * Can be between 1 - 6.
 */

public class Number implements Serializable{
	//number of the tile and its color
	int number;
	Color color;
	
	//parameters for this class
	private final int maxNumber = 6; 
	private final int minNumber = 1;
	/**
	 * 
	 * @param n number. 
	 * @throws Exception. 
	 */
	public Number(int n, Color c){
		//makes sure that the 
		try{
			if(n > maxNumber || n < minNumber)
				throw new Exception("number must be between " + maxNumber + " and " + minNumber + ", inclusive");
		} catch(Exception e) {
			
		}
		
		
		number = n;
		color = c;
	}
	
	/**
	 * Gets the number associated with the tile.
	 * @return int the number associated with the tile.
	 */
	public int getNum(){
		return this.number;
	}
	
	/** 
	 * Gets the color associated with the tile.
	 * @return Color Gets the color associated with the tile.
	 */
	public Color getColor(){
		return this.color;
	}
}
