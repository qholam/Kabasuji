package entity;

import move.IMove;

public class ReleaseLevel extends Level {
	//number of moves done
	int numMoves;
	
	/**
	 * constructor for creating a Releaselevel
	 * @param board
	 * @param bullpen
	 * @param isUnlocked
	 * @param levelNum
	 * @param stars
	 */
	public ReleaseLevel(Board board,Bullpen bullpen, boolean isUnlocked, int levelNum, int stars){
		super(board, bullpen, isUnlocked, stars, stars);
		numMoves = 0;
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
	 * get the number of moves
	 * @return int The number of moves
	 */
	public int getNumMoves(){
		return numMoves;
	}
}
