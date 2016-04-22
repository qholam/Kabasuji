package entity;

import move.IMove;

/**
 * Constructor for a puzzle level. Extends level.
 * @author Calvin
 *
 */
public class PuzzleLevel extends Level {
	int movesRemaining;
	
	/**
	 * constructor for a LightningLevel
	 * @param movesRemaining The number of moves remaining for the player.
	 * @param board The board on which the level is played on.
	 * @param bullpen Bullpen where the piece tiles will come from.
 	 * @param isUnlocked Boolean that determines if the level is unlocked.
	 * @param levelNum Int the level number that this is.
	 * @param stars The number of stars that the player has earned on this level.
	 */
	public PuzzleLevel(int movesRemaining, Board board,Bullpen bullpen, boolean isUnlocked, int levelNum, int stars){
		super(board, bullpen, isUnlocked, movesRemaining, movesRemaining);
		this.movesRemaining = movesRemaining;
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
	 * Checks the number of move remaining available. 
	 * @return movesRemaining
	 */
	public int getMovesRemaining(){
		return this.movesRemaining;
	}
}
