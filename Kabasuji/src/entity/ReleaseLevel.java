package entity;

import java.awt.Color;

import move.IMove;

/**
 * constructor for a release level.
 * @author Calvin
 *
 */
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
		super(board, bullpen, isUnlocked, levelNum, stars);
		numMoves = 0;
	}
	
	/**
	 * 
	 * @return boolean determining if the level has been won
	 */
	public boolean hasWon(){
		/**
		 * covered[0][] is red
		 * covered[1][] is blue
		 * covered[2][] is green
		 * covered[][n] is the number 
		 */
	boolean[][] covered = new boolean[3][6];
		int numRows = board.getRows();
		int numColumns = board.getColumns();
		int color = -1;
		ReleaseTile release;
		
		//set the covered array to all false
		for (int r = 0; r < 3; r++){
			for (int c = 0; c < 6; c++){
					covered[r][c] = false;
				}
			}
		
		for (int i = 0; i < numColumns; i++){
			for (int a = 0; a < numRows; a++){
				if (board.boardGrid[i][a] instanceof ReleaseTile){
					if (board.boardGrid[i][a].isCovered()){
						release = (ReleaseTile) board.boardGrid[i][a];
						if (release.getNumber().getColor().equals(Color.red)){
							color = 0;
						} else
						if (release.getNumber().getColor().equals(Color.blue)){
							color = 1;
						} else
						if (release.getNumber().getColor().equals(Color.green)){
							color = 2;
						}
						covered[color][release.getNumber().getNum() - 1] = true;
					}
				}
			}
		}
		
		for (int r = 0; r < 3; r++){
			int count = 0;
			for (int c = 0; c < 6; c++){
				if (covered[r][c] == true){
					count++;
					//if the count is 6 for any set then its a win
					if (count == 6){
						return true;
						}
				}
			}
		}
		
		return false;
		
	}
	
	/** 
	 * 
	 * @return boolean determining if the move was made.
	 */
	public boolean doMove(IMove move){
		boolean valid = false;
		if (move.doMove()){
			valid = true;
			numMoves++;
		}
		return valid;
	}
	
	/**
	 * get the number of moves.
	 * @return int The number of moves
	 */
	public int getNumMoves(){
		return numMoves;
	}
	
	/**
	 * Changes the number of moves according to the give int.
	 * @param dm Number of moves to add/subtract
	 */
	public void changeNumMoves(int dm){
		this.numMoves = this.numMoves + dm;
	}
	
	/**
	 * Will be useful when naming save level .txt files
	 */
	@Override
	public String toString(){
		return "Release" + this.levelNum;
	}
	
	/**
	 * Returns the type of the level
	 */
	@Override
	public LevelType getLevelType(){
		return LevelType.Release;
	}
	
}
