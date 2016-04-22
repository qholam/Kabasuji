package entity;

import move.IMove;

/**
 * Constructor for a lightning level. Extends level.
 * @author Calvin
 *
 */
public class LightningLevel extends Level{

	int timeRemaining;
	
	/**
	 * constructor for a puzzle level
	 * @param timeRemaining The amount of tie remaining for the level.
	 * @param board The board on which the level is played on.
	 * @param bullpen Bullpen where the piece tiles will come from.
 	 * @param isUnlocked Boolean that determines if the level is unlocked.
	 * @param levelNum Int the level number that this is.
	 * @param stars The number of stars that the player has earned on this level.
	 */
	public LightningLevel(int timeRemaining, Board board,Bullpen bullpen, boolean isUnlocked, int levelNum, int stars){
		super(board, bullpen, isUnlocked, stars, stars);
		this.timeRemaining = timeRemaining;
	}
	
	/**
	 * Checks whether or not the level has been won.
	 * @return boolean determining if the level has been won
	 */
	public boolean hasWon(){
		int notCovered = 0;
		int numRows = board.numRows;
		int numColumns = board.numColumns;
		
		for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < numColumns; c++) {
				if (!board.boardGrid[r][c].isCovered){
					notCovered++;
				}
			}
		}
		
		//If time is out and there are 12 or less not covered, game is won. 
		if (timeRemaining == 0){
			if (notCovered <= 12){
				return true;
			}
		}
		//There is time left, but all the tiles are covered.
		if (timeRemaining > 0){
			if (notCovered == 0){
				return true;
			}
		}
		return false;
	}
	
	/** 
	 * Checks if move has been made.
	 * @return boolean determining if the move was made
	 */
	public boolean doMove(IMove move){
		return move.doMove();
	}

	/**
	 * Gets the remaining time on the level.
	 * @return timeRemaining
	 */
	public int getTimeRemaining(){
		return this.timeRemaining;
	}	
}
