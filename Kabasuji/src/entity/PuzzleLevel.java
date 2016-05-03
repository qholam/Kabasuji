package entity;

import move.IMove;

/**
 * Constructor for a puzzle level. Extends level.
 * @author Calvin
 *
 */
public class PuzzleLevel extends Level {
	private int movesRemaining;
	
	/**
	 * constructor for a LightningLevel
	 * @param movesRemaining The number of moves remaining for the player.
	 * @param board The board on which the level is played on.
	 * @param bullpen Bullpen where the piece tiles will come from.
 	 * @param isUnlocked Boolean that determines if the level is unlocked.
	 * @param levelNum Int the level number that this is.
	 * @param stars The number of stars that the player has earned on this level.
	 */
	public PuzzleLevel(int movesRemaining, Board board, Bullpen bullpen, boolean isUnlocked, int levelNum, int stars){
		super(board, bullpen, isUnlocked, levelNum, stars);
		this.movesRemaining = movesRemaining; 
	} 
	
	/**
	 * Checks whether or not the level has been won. Also updates the stars accordingly.
	 * @return boolean determining if the level has been won
	 */
	public boolean hasWon(){
		int numLeft =  board.getNumUncovered();
		
		//if the bullpen is empty in puzzle level, then all pieces have been placed.
		if (numLeft == 0){
			return true;
		}
		
		//if no moves remaining, check how many pieces are left in bullpen. If 2 or less, conditions fulfilled to win puzzle level.
		if (movesRemaining == 0){
			if (numLeft <= 12){
				return true;
			}
		}
		//System.out.println("num stars: " + stars);
		//level has not been won
		return false;
		
	}
	
	public void updateStars(){
		int numLeft =  board.getNumUncovered();
		
		//if the bullpen is empty in puzzle level, then all pieces have been placed.
		if (numLeft == 0)
			stars = Math.max(stars, 3); 
		else if(numLeft <= 6)
			stars = Math.max(stars, 2);
		else if(numLeft <= 12)
			stars = Math.max(stars, 1);

	}
	
	/** 
	 * Checks if move has been made.
	 * @return boolean determining if the move was made
	 */
	public boolean doMove(IMove move){
		boolean valid = false;
		if (move.doMove()){
			//movesRemaining = movesRemaining - 1;
			valid = true;
		}
		return valid;
	}
	
	/**
	 * Checks the number of move remaining available. 
	 * @return movesRemaining
	 */
	public int getMovesRemaining(){
		return this.movesRemaining;
	}
	
	/**
	 * Will be useful when naming save level .txt files
	 */
	@Override
	public String toString(){
		return "Puzzle" + this.levelNum;
	}
	
	/**
	 * Returns the type of the level
	 */
	@Override
	public LevelType getLevelType(){
		return LevelType.Puzzle;
	}
	
	/**
	 * Changes the number of moves according to the give int.
	 * @param dm Number of moves to add/subtract
	 */
	public void changeNumMoves(int dm){
		this.movesRemaining = this.movesRemaining + dm;
	}
}
