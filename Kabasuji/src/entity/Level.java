package entity;

import java.io.Serializable;

import move.IMove;

/**
 * Represents shared aspects of the different levels
 * @author Calvin
 *
 */
public class Level implements Serializable{
	
	boolean isUnlocked;
	Board board;
	Bullpen bullpen;
	int levelNum;
	int stars;
	
	/**
	 * constructor for creating a level.
	 * @param board The board on which the level is played on.
	 * @param bullpen Bullpen where the piece tiles will come from.
	 * @param isUnlocked Boolean that determines if the level is unlocked.
	 * @param levelNum Int the level number that this is.
	 * @param stars The number of stars that the player has earned on this level.
	 */
	public Level(Board board,Bullpen bullpen, boolean isUnlocked, int levelNum, int stars){
		this.board = board;
		this.bullpen = bullpen;
		this.isUnlocked = isUnlocked;
		this.levelNum = levelNum;
		this.stars = stars;
	}
	
	/**
	 * Checks whether or not the level is unlocked.
	 * @return Boolean isUnlocked
	 */
	public boolean isUnlocked() {
		return isUnlocked;
	}

	/**
	 * Gets the board that this level is played on.
	 * @return Board the board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Gets the bullpen that this level is played on.
	 * @return the bullpen
	 */
	public Bullpen getBullpen() {
		return bullpen;
	}

	/**
	 * Gets the level number that this level is.
	 * @return levelNum the the level number.
	 */
	public int getLevelNum() {
		return levelNum;
	}

	/**
	 * Gets the number of stars that has been achieved.
	 * @return the stars
	 */
	public int getStars() {
		return stars;
	}

	/**
	 * update number of stars base on conditions of level type.
	 */
	public void updateStars(){
		
	}
	
	/**
	 * Checks whether or not the level has been won.
	 * @return boolean determining if the level has been won.
	 */
	public boolean hasWon(){
		return false;
	}
	
	/** 
	 * Checks if move has been made.
	 * @return boolean determining if the move was made.
	 */
	public boolean doMove(IMove move){
		return false;
	}
	
	/**
	 * Returns the type of the level.
	 * @return The type of the current level.
	 */
	public LevelType getLevelType(){
		if (this instanceof ReleaseLevel){
			return ((ReleaseLevel) this).getLevelType();
		} if (this instanceof PuzzleLevel){
			return ((PuzzleLevel) this).getLevelType();
		} if (this instanceof ReleaseLevel){
			return ((ReleaseLevel) this).getLevelType();
		} else return null;
	}
}
