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
	 * @return the isUnlocked
	 */
	public boolean isUnlocked() {
		return isUnlocked;
	}

	/**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * @return the bullpen
	 */
	public Bullpen getBullpen() {
		return bullpen;
	}

	/**
	 * @return the levelNum
	 */
	public int getLevelNum() {
		return levelNum;
	}

	/**
	 * @return the stars
	 */
	public int getStars() {
		return stars;
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
