package entity;

import move.IMove;

public class Level {
	
	boolean isUnlocked;
	Board board;
	Bullpen bullpen;
	int levelNum;
	int stars;
	
	/**
	 * constructor for creating a level
	 * @param board
	 * @param bullpen
	 * @param isUnlocked
	 * @param levelNum
	 * @param stars
	 */
	public Level(Board board,Bullpen bullpen, boolean isUnlocked, int levelNum, int stars){
		this.board = board;
		this.bullpen = bullpen;
		this.isUnlocked = isUnlocked;
		this.levelNum = levelNum;
		this.stars = stars;
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
}
