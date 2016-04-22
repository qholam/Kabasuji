package entity;

import move.IMove;

public class LightningLevel extends Level{

	int timeRemaining;
	
	/**
	 * constructor for a puzzle level
	 * @param timeRemaining
	 * @param board
	 * @param bullpen
	 * @param isUnlocked
	 * @param levelNum
	 * @param stars
	 */
	public LightningLevel(int timeRemaining, Board board,Bullpen bullpen, boolean isUnlocked, int levelNum, int stars){
		super(board, bullpen, isUnlocked, stars, stars);
		this.timeRemaining = timeRemaining;
	}
	
	/**
	 * 
	 * @return boolean determining if the level has been won
	 */
	public boolean hasWon(){
		return false;
		
	}
	
	/** 
	 * 
	 * @return boolean determining if the move was made
	 */
	public boolean doMove(IMove move){
		
		
		return false;
	}

	/**
	 * @return timeRemaining
	 */
	public int getTimeRemaining(){
		return this.timeRemaining;
	}	
}
