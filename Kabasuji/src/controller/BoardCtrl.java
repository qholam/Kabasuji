package controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.BoardPanel;
import GUI.BuilderLevel;
import GUI.LevelPanel;
import GUI.PieceContainer;
import entity.Board;
import entity.BoardTile;
import entity.Bullpen;
import entity.KabasujiGame;
import entity.Level;
import entity.NoTile;
import entity.Piece;
import entity.PieceTile;
import entity.PuzzleLevel;
import entity.Tile;
import view.PieceView;
import view.TileView;

/**
 * Drag Pieces inside the board.
 * @author LilyAnne
 * @author Quoc Holam
 *
 */
public class BoardCtrl implements MouseListener{
	BoardPanel boardPanel;
	LevelPanel levelPanel;
	PieceContainer container;
	
	public BoardCtrl(BoardPanel board, LevelPanel level){
		boardPanel = board;
		levelPanel = level;
		container = level.getPieceContainer();
	}
	
	@Override
	public void mousePressed (MouseEvent me){
		//this determines the amount to change the quantity of the pice by
		int pieceQty = 1;
		
		//is anything being dragged? if not then see if there is a piece to remove there
		if(!container.isVisible()){
			Level l = levelPanel.getLevel();
			//can only be removed from board if it is puzzle level
			//if(l instanceof PuzzleLevel){
				Component c = boardPanel.getBoardTilePanel().getComponentAt(me.getPoint());
				if(c instanceof TileView){
					TileView tv = (TileView) c;
					Tile t = tv.getTile();
					
					//ensure the tile clicked on was a board tile
					if(!(t instanceof BoardTile) || t instanceof NoTile){
						//do nothing if it is not a boardtile
						return;
					}
					
					//check if the board tile clicked on was covered, if so get the piece there
					BoardTile bt = (BoardTile) t;
					if(bt.isCovered()){
						//get the row and column of the click
						int row = bt.getRow();
						int col = bt.getCol();
						
						//remove the piece there
						Piece removed = boardPanel.getBoard().removePieceAt(row, col);
						
						//set container visible again and add removed piece to it
						container.setDraggingPiece(removed);
						container.setSource(boardPanel);
						container.setVisible(true);
					}
				}
			//}
				
			return;
		}
		boardPanel.setRepaintValid();
		Component c = boardPanel.getBoardTilePanel().getComponentAt(me.getPoint());
		if(c instanceof TileView){
			//get the row and column of the click on the board
			Tile t = ((TileView) c).getTile();
			int tRow = t.getRow();
			int tCol = t.getCol();

			//get the row and column of the anchoring tile
			TileView anchor = container.getAnchorTile();
			int anchorRow = ((PieceTile) anchor.getTile()).getPieceGridRow();
			int anchorCol = ((PieceTile) anchor.getTile()).getPieceGridCol();	
			
			//get row and col on board in which the left hand corner of the tile in the piece grid will be added to
			int row = tRow - anchorRow;
			int col = tCol - anchorCol;
			boardPanel.getBoard().addPiece(container.getDraggingPiece().getPiece(), row, col);
			boardPanel.repaint();

			
			//quantity of piece will be reduced by 1 now
			pieceQty = -1;
		}
		
		//release the dragging piece	
		//get the piece being dragged
		Piece dragged = container.getDraggingPiece().getPiece();
		
		//added it back to the bullpen by updating pieces quantity
		Bullpen bp = levelPanel.getBullpenView().getBullpen();
    	bp.changeQuanity(dragged, pieceQty);
    	levelPanel.getBullpenView().repaint();
    	
    	container.setVisible(false);
	}
	
	@Override
	public void mouseReleased(MouseEvent me){
		/**
		 * need more information to complete this 
		 */
				
		//IMove move = new BoardToBullpenMove();
		//if (move.doMove(theGame)) 
		//{
		//	theGame.doMove (move);     // Successful Move has been Move
		//} 
		//else 
		//{
		//	fromWidget.returnWidget (draggingWidget);
		//}
				
		// release the dragging object, (this will reset dragSource)
		//releaseDraggingObject();
				
		// finally repaint
		//repaint();
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
}
