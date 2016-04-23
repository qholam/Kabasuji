package move;

import entity.Board;
import entity.Bullpen;
import entity.Piece;
import entity.PuzzleLevel;

/**
 * Move class for moving pieces from the Bullpen to the Board in a Puzzle Level.
 * @author LilyAnne
 *
 */

public class BullpenToPuzzleBoardMove implements IMove 
{

	Board board;
	Piece pieceBeingDragged;
	PuzzleLevel level;
	Bullpen bullpen;
		
	/**
	 * Constructor for BullpenToPuzzleBoardMove
	 * @param board
	 * @param pieceBeingDragged
	 * @param level
	 */
		
	public BullpenToPuzzleBoardMove(Board board, Piece pieceBeingDragged, PuzzleLevel level, Bullpen bullpen)
	{
		this.board = board;
		this.pieceBeingDragged = pieceBeingDragged;
		this.level = level;
		this.bullpen = bullpen;
	}

	/**
	 * Processes the move to the board the Board.
	 */
	@Override
	public boolean doMove() 
	{
		if (!isValid()) 
		{
			return false; 
		}
				
		// TODO bullpen.remove(pieceBeingDragged);
		board.addPiece(pieceBeingDragged);
		
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
			
		if(true)
		{
			//TODO CHECK FOR ON BOARD
			validMove = true;
		}
			
		return validMove;
	}
	/**
	 * Undo the most recent move.
	 * 
	 * Always returns false
	 */
	@Override
	public boolean undo() 
	{
		//TODO
		return false;
	}

}
