package controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import GUI.BoardPanel;
import GUI.BuilderLevel;
import GUI.BullpenView;
import GUI.KabasujiFrame;
import GUI.LevelPanel;
import GUI.PieceContainer;
import entity.BoardTile;
import entity.Bullpen;
import entity.Level;
import entity.NoTile;
import entity.Piece;
import entity.PieceTile;
import entity.PuzzleLevel;
import entity.Tile;
import move.BoardToBoardMove;
import move.BullpenToBoardMove;
import move.IMove;
import view.TileView;

/**
 * Drag Pieces inside the board.
 * 
 * @author LilyAnne
 * @author Quoc Holam
 *
 */
public class BoardCtrl implements MouseListener {
	BoardPanel boardPanel;
	JPanel levelPanel;
	PieceContainer container;
	Bullpen bp;
	BullpenView bpview;

	public BoardCtrl(BoardPanel board, JPanel level) {
		boardPanel = board;
		levelPanel = level;
		if (level instanceof LevelPanel)
			container = ((LevelPanel) level).getPieceContainer();
		else
			container = ((BuilderLevel) level).getPieceContainer();
	}

	@Override
	public void mousePressed(MouseEvent me) {
		// this determines the amount to change the quantity of the pice by
		int pieceQty = 1;
		Level l;

		// is anything being dragged? if not then see if there is a piece to
		// remove there
		if (!container.isVisible()) {// nothing being dragged
			// check if game is over, if so do nothing
			if (levelPanel instanceof LevelPanel) {
				if (((LevelPanel) levelPanel).getLevel().getStars() == 3)
					return;
				l = ((LevelPanel) levelPanel).getLevel();
			} else {
				if (((BuilderLevel) levelPanel).getLevel().getStars() == 3)
					return;
				l = ((BuilderLevel) levelPanel).getLevel();
			}
			// Level l = levelPanel.getLevel();
			// can only be removed from board if it is puzzle level
			if (l instanceof PuzzleLevel) {
				Component c = boardPanel.getBoardTilePanel().getComponentAt(me.getPoint());
				if (c instanceof TileView) {
					TileView tv = (TileView) c;
					Tile t = tv.getTile();

					// check if tile clicked was a piece tile
					if (t instanceof PieceTile) {
						PieceTile bt = (PieceTile) t;

						// get the row and column of the click
						int row = bt.getRow();
						int col = bt.getCol();

						// test some shit
						PieceTile pt = new PieceTile();
						pt.setPieceGridCol(bt.getPieceGridCol());
						pt.setPieceGridRow(bt.getPieceGridRow());

						// remove the piece there
						Piece removed = boardPanel.getBoard().removePieceAt(row, col);

						// set container visible again and add removed piece to
						// it,
						// be sure to set anchor and source
						container.setDraggingPiece(removed);
						container.setAnchortile(new TileView(removed.getpieceGrid()[col - removed.getColPos()][row - removed.getRowPos()])); 
						container.setSource(boardPanel);
						container.setVisible(true);
					}
				}
			}
		} else {
			// piece is currently being dragged, handle that
			// get the component that was clicked on
			Component c = boardPanel.getBoardTilePanel().getComponentAt(me.getPoint());

			if (c instanceof TileView) {
				// get the row and column of the click on the board
				Tile t = ((TileView) c).getTile();
				int tRow = t.getRow();
				int tCol = t.getCol();

				// get the row and column of the anchoring tile
				TileView anchor = container.getAnchorTile();
				int anchorRow = ((PieceTile) anchor.getTile()).getPieceGridRow();
				int anchorCol = ((PieceTile) anchor.getTile()).getPieceGridCol();

				// get row and col on board in which the left hand corner of the
				// tile in the piece grid will be added to
				int row = tRow - anchorRow;
				int col = tCol - anchorCol;

				// add the piece and check if there was a problem doing so, if
				// there is return
				IMove move;
				Level level;
				JPanel source = container.getSource();

				// get the level
				if (levelPanel instanceof LevelPanel)
					level = ((LevelPanel) levelPanel).getLevel();
				else
					level = ((BuilderLevel) levelPanel).getLevel();

				// check the source of the drag
				if (source instanceof BullpenView)
					move = new BullpenToBoardMove(boardPanel.getBoard(), level, container.getDraggingPiece().getPiece(),
							bp, row, col);
				else// otherwise source is the board
					move = new BoardToBoardMove(boardPanel.getBoard(), level, container.getDraggingPiece().getPiece(),
							row, col);

				// was move successful?
				// TODO: what to do when move is invalid?
				if (!move.doMove()) {
					//System.out.println("cant do move");
					return;
				}

				// updating pieces quantity in bullpen
				if (levelPanel instanceof LevelPanel) {
					bp = ((LevelPanel) levelPanel).getBullpenView().getBullpen();
					bpview = ((LevelPanel) levelPanel).getBullpenView();
				} else {
					bp = ((BuilderLevel) levelPanel).getBullpenView().getBullpen();
					bpview = ((BuilderLevel) levelPanel).getBullpenView();
				}
				container.setVisible(false);
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent me) {
		//System.out.println(me.getX() + " " + me.getY());
		if (levelPanel instanceof LevelPanel) {
			bp = ((LevelPanel) levelPanel).getBullpenView().getBullpen();
			bpview = ((LevelPanel) levelPanel).getBullpenView();
		} else {
			bp = ((BuilderLevel) levelPanel).getBullpenView().getBullpen();
			bpview = ((BuilderLevel) levelPanel).getBullpenView();
		}
		bpview.setRepaintValid();
		boardPanel.setRepaintValid();
		container.repaint();
		// update status of level
		if (levelPanel instanceof LevelPanel)
			((LevelPanel) levelPanel).updateLevel();
		else
			((BuilderLevel) levelPanel).updateLevel();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Gets the current BoardView.
	 * @return BoardView the current boardview.
	 */
	public BoardPanel getBoardView(){
		return this.boardPanel;
	}
}