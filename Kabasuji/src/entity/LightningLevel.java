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
