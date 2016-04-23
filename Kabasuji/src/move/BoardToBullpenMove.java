package move;

import entity.Board;
import entity.Bullpen;
import entity.Piece;
import entity.PuzzleLevel;

/**
 * Move pieces from the Board to the Bullpen.
 * 
 * Only valid in Puzzle Level? and Level Builder
 * @author LilyAnne
 *
 */
public class BoardToBullpenMove implements IMove
{	
	Board board;
	Piece pieceBeingDragged;
	Bullpen bullpen;
	PuzzleLevel level;
		
	/**
	 * Constructor for BoardToBullpenMove
	 * @param board
	 * @param pieceBeingDragged
	 * @param level
	 */
		
	public BoardToBullpenMove(Board board, Piece pieceBeingDragged, PuzzleLevel level, Bullpen bullpen)
	{
		this.board = board;
		this.pieceBeingDragged = pieceBeingDragged;
		this.level = level;
		this.bullpen = bullpen;
	}
	
	/**
	 * Processes the move within the Board.
	 */
	@Override
	public boolean doMove() 
	{
		if (!isValid()) 
		{
			return false; 
		}
			
		// TODO board.remove(pieceBeingDragged);
		bullpen.addPiece(pieceBeingDragged);
		return true;
	}
	
	/**
	 * Checks whether the attempted move is valid.
	 */
	@Override
	public boolean isValid() 
	{
		boolean validMove = false;
		
		Piece p = pieceBeingDragged;

		if(level.hasWon() == false)
		{
			validMove = true;
		}
			
		if(level.getMovesRemaining() >= 1)
		{
			validMove = true;
		}
			
		if(true)
		{
			//TODO CHECK FOR OVERLAP
			validMove = true;
		}
			
		return validMove;
		}

	/**
	 * Undo the most recent move.
	 * 
	 * Level Builder only?
	 */
	@Override
	public boolean undo() 
	{
		//TODO
		return false;
	}
}
