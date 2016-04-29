package move;

import entity.Board;
import entity.Bullpen;
import entity.Level;
import entity.Piece;
import entity.PuzzleLevel;
import entity.ReleaseLevel;
import entity.LevelType;
import entity.LightningLevel;

/**
 * Move pieces from the Board to the Bullpen.
 * 
 * Only valid in Puzzle Level? and Level Builder
 * 
 * @author LilyAnne
 * @author Quoc HoLam
 *
 */
public class BullpenToBoardMove implements IMove {
	Board board;
	Piece pieceBeingDragged;
	Bullpen bullpen;
	Level level;
	int row, col;

	/**
	 * Constructor for BoardToBullpenMove
	 * 
	 * @param board
	 * @param pieceBeingDragged
	 * @param row
	 *            The row on the board to add the piece to
	 * @param col
	 *            The col on the board to add the piece to
	 */

	public BullpenToBoardMove(Board board, Level level, Piece pieceBeingDragged, Bullpen bullpen, int row, int col) {
		this.board = board;
		this.level = level;
		this.pieceBeingDragged = pieceBeingDragged;
		this.bullpen = bullpen;
		this.row = row;
		this.col = col;
	}

	/**
	 * Processes the move within the Board.
	 */
	@Override
	public boolean doMove() {
		// is move valid to be made?
		if (!isValid()) {
			return false;
		}

		// add piece to board
		board.addPiece(pieceBeingDragged, row, col);
		
		//update stuff specific to a level type
		switch (level.getLevelType()) {
		case Lightning:
			break;
		case Puzzle:
			((PuzzleLevel) level).changeNumMoves(-1);
			break;
		default:
			((ReleaseLevel) level).changeNumMoves(1);
			break;
		}

		// Move was successful!
		return true;
	}

	/**
	 * Checks whether the attempted move is valid.
	 */
	@Override
	public boolean isValid() {
		boolean validMove = true;

		Piece p = pieceBeingDragged;

		// check if level has been won
		if (level.hasWon() && level.getStars() == 3) {
			validMove = false;
		}

		// check logic specific to a level type
		switch (level.getLevelType()) {
		case Lightning:
			if (((LightningLevel) level).getTimeRemaining() < 0)
				validMove = false;
			break;
		case Puzzle:
			if (((PuzzleLevel) level).getMovesRemaining() < 0)
				validMove = false;
			break;
		default:
			break;
		}

		// check if piece can be added to board
		if (!board.canAddAt(p, row, col)) {
			//System.out.println("cant add");
			validMove = false;
		}

		return validMove;
	}

	/**
	 * Undo the most recent move.
	 * 
	 * Level Builder only?
	 */
	@Override
	public boolean undo() {
		// TODO
		return false;
	}
}
