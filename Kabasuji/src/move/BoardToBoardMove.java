package move;

import entity.Board;
import entity.Level;
import entity.LightningLevel;
import entity.Piece;
import entity.PuzzleLevel;

/**
 * Move class for moving pieces within the board.
 * 
 * Only valid in Puzzle Levels and Level Builder
 * 
 * @author LilyAnne
 * @author Quoc HoLam
 *
 */

public class BoardToBoardMove implements IMove {

	Board board;
	Piece pieceBeingDragged;
	Level level;
	int row, col;
	int originalRow, originalCol;

	/**
	 * Constructor for BoardToBullpenMove.
	 * 
	 * @param board Given board to be used during this move.
	 * @param level The level in which this move will take place.
	 * @param pieceBeingDragged The piece being dragged.
	 * @param row
	 *            The row on the board to add the piece to.
	 * @param col
	 *            The col on the board to add the piece to.
	 */

	public BoardToBoardMove(Board board, Level level, Piece pieceBeingDragged,  int row, int col) {
		this.board = board;
		this.pieceBeingDragged = pieceBeingDragged;
		this.level = level;
		this.row = row;
		this.col = col;
		//keep track of old row and column for redo.
		this.originalRow = pieceBeingDragged.getRowPos();
		this.originalCol = pieceBeingDragged.getColPos();
	}

	/**
	 * Processes the move within the Board.
	 * @return Boolean indicating if move was succesful. 
	 */
	@Override
	public boolean doMove() {
		if (!isValid())
			return false;

		// TODO board.remove(pieceBeingDragged);
		board.addPiece(pieceBeingDragged, row, col);
		return true;
	}

	/**
	 * Checks whether the attempted move is valid.
	 * @return Boolean indicating if move is valid.
	 */
	@Override
	public boolean isValid() {
		boolean validMove = true;

		Piece p = pieceBeingDragged;

		if (level.hasWon()) {
			validMove = false;
		}

		// check logic specific to a level type
		switch (level.getLevelType()) {
		case Lightning:
			if (((LightningLevel) level).getTimeRemaining() <= 0)
				validMove = false;
			break;
		case Puzzle:
			if (((PuzzleLevel) level).getMovesRemaining() <= 0)
				validMove = false;
			break;
		default:
			break;
		}

		// check if piece can be added to board
		if (!board.canAddAt(p, row, col)) {
			validMove = false;
		}

		return validMove;
	} 

	/**
	 * Undo the most recent move.
	 * 
	 * Level Builder only?
	 * @return Boolean indicating if undo was a success. 
	 */
	@Override
	public boolean undo() {
		//remove piece
		board.removePiece(this.pieceBeingDragged);
		
		//add it back to orignial spot
		board.addPiece(this.pieceBeingDragged, this.originalRow, this.originalCol);

		return false;
	}

}
