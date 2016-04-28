package entity;

import move.IMove;

/**
 * Constructor for a lightning level. Extends level.
 * @author Calvin
 *
 */
public class LightningLevel extends Level{
	private int timeRemaining;
	
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
		super(board, bullpen, isUnlocked, levelNum, stars);
		this.timeRemaining = timeRemaining;
	}
	
	/**
	 * Checks whether or not the level has been won.
	 * @return boolean determining if the level has been won
	 */
	public boolean hasWon(){
		int notCovered = 0;
		int numRows = board.getRows();
		int numColumns = board.getColumns();
		BoardTile[][] boardGrid = board.boardGrid;
		
		for (int c = 0; c < numColumns; c++) {
			for (int r = 0; r < numRows; r++) {
				if (!boardGrid[c][r].isCovered()){
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
		boolean valid = false;
		if (move.doMove()){
			valid = true;
		}
		return valid;
	}

	/**
	 * Gets the remaining time on the level.
	 * @return timeRemaining
	 */
	public int getTimeRemaining(){
		return this.timeRemaining;
	}	
	
	/**
	 * Will be useful when naming save level .txt files
	 */
	@Override
	public String toString(){
		return "Lightning" + this.levelNum;
	}
	
	/**
	 * Returns the type of the level
	 */
	@Override
	public LevelType getLevelType(){
		return LevelType.Lightning;
	}
}
