package move;

import entity.Board;
import entity.Piece;
import entity.PuzzleLevel;

/**
 * Move class for moving pieces within the board.
 * 
 * Only valid in Puzzle Levels and Level Builder
 * @author LilyAnne
 *
 */

public class BoardToBoardMove implements IMove
{
	
	Board board;
	Piece pieceBeingDragged;
	PuzzleLevel level;
	
	/**
	 * Constructor for BoardToBoardMove
	 * @param board
	 * @param pieceBeingDragged
	 * @param level
	 */
	
	public BoardToBoardMove(Board board, Piece pieceBeingDragged, PuzzleLevel level)
	{
		this.board = board;
		this.pieceBeingDragged = pieceBeingDragged;
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
