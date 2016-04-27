package controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import GUI.BoardPanel;
import GUI.BuilderLevel;
import GUI.BullpenView;
import GUI.LevelPanel;
import GUI.PieceContainer;
import entity.BoardTile;
import entity.Bullpen;
import entity.NoTile;
import entity.Piece;
import entity.PieceTile;
import entity.Tile;
import view.TileView;

/**
 * Drag Pieces inside the board.
 * @author LilyAnne
 * @author Quoc Holam
 *
 */
public class BoardCtrl implements MouseListener{
	BoardPanel boardPanel;
	JPanel levelPanel;
	PieceContainer container;
	Bullpen bp;
	BullpenView bpview;
	
	public BoardCtrl(BoardPanel board, JPanel level){
		boardPanel = board;
		levelPanel = level;
		if(level instanceof LevelPanel)
			container = ((LevelPanel)level).getPieceContainer();
		else 
			container = ((BuilderLevel)level).getPieceContainer();
	}
	
	@Override
	public void mousePressed (MouseEvent me){
		//this determines the amount to change the quantity of the pice by
		int pieceQty = 1;

		//is anything being dragged? if not then see if there is a piece to remove there
		if(!container.isVisible()){//nothing being dragged
			//Level l = levelPanel.getLevel();
			//can only be removed from board if it is puzzle level
			//if(l instanceof PuzzleLevel){
				Component c = boardPanel.getBoardTilePanel().getComponentAt(me.getPoint());
				if(c instanceof TileView){
					TileView tv = (TileView) c;
					Tile t = tv.getTile();
					
					//check if tile clicked was a piece tile
					if(t instanceof PieceTile){
						PieceTile bt = (PieceTile) t;
						
						//get the row and column of the click
						int row = bt.getRow();
						int col = bt.getCol();
						
						//test some shit
						PieceTile pt = new PieceTile(); 
						pt.setPieceGridCol(bt.getPieceGridCol());
						pt.setPieceGridRow(bt.getPieceGridRow());
						
						//remove the piece there
						Piece removed = boardPanel.getBoard().removePieceAt(row, col);
						
						//set container visible again and add removed piece to it, be sure to set anchor and source
						container.setDraggingPiece(removed);
						container.setAnchortile(new TileView(removed.getpieceGrid()[col - removed.getColPos()][row - removed.getRowPos()]));
						container.setSource(boardPanel);
						container.setVisible(true);
					}
				}
			//}
		}
		else{
		//piece is currently being dragged, handle that
			//get the component that was clicked on
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
				
				//add the piece and check if there was a problem doing so, if there is return
				if(!boardPanel.getBoard().addPiece(container.getDraggingPiece().getPiece(), row, col))
					return;
	
				//quantity of piece will be reduced by 1 now
				pieceQty = -1;
			}
			
			//release the dragging piece	
			//get the piece being dragged
			Piece dragged = container.getDraggingPiece().getPiece();
			
			//updating pieces quantity in bullpen
			if(levelPanel instanceof LevelPanel){
				bp = ((LevelPanel)levelPanel).getBullpenView().getBullpen();
				bpview = ((LevelPanel)levelPanel).getBullpenView();
			}
			else{
				bp = ((BuilderLevel)levelPanel).getBullpenView().getBullpen();
				bpview = ((BuilderLevel)levelPanel).getBullpenView();
			}
	    	bp.changeQuanity(dragged, pieceQty);
	    	
	    	container.setVisible(false);
		}
		
	}
	
	@Override
	public void mouseReleased(MouseEvent me){
		if(levelPanel instanceof LevelPanel){
			bp = ((LevelPanel)levelPanel).getBullpenView().getBullpen();
			bpview = ((LevelPanel)levelPanel).getBullpenView();
		}
		else{
			bp = ((BuilderLevel)levelPanel).getBullpenView().getBullpen();
			bpview = ((BuilderLevel)levelPanel).getBullpenView();
		}
		bpview.setRepaintValid();
		boardPanel.setRepaintValid();
		container.repaint();
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
