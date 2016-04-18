package entity;

import move.IMove;

public class LightningLevel extends Level{

	int movesRemaining;
	
	/**
	 * constructor for a LightningLevel
	 * @param movesRemaining
	 * @param board
	 * @param bullpen
	 * @param isUnlocked
	 * @param levelNum
	 * @param stars
	 */
	public LightningLevel(int movesRemaining, Board board,Bullpen bullpen, boolean isUnlocked, int levelNum, int stars){
		super(board, bullpen, isUnlocked, movesRemaining, movesRemaining);
		this.movesRemaining = movesRemaining;
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
