package entity;

public class Number {
	//number of the tile and its color
	int number;
	String color;
	
	//parameters for this class
	private final int maxNumber = 6;
	private final int minNumber = 1;
	
	/**
	 * 
	 * @param n number 
	 * @param c
	 * @throws Exception 
	 */
	public Number(int n, String c){
		//makes sure that the 
		try{
			if(n > maxNumber || n < minNumber)
				throw new Exception("number must be between " + maxNumber + " and " + minNumber + ", inclusive");
		} catch(Exception e) {
			
		}
		
		
		number = n;
		color = c;
	}
}
