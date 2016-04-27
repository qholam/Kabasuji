package controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.BoardPanel;
import GUI.LevelPanel;
import GUI.PieceContainer;
import entity.Board;
import entity.BoardTile;
import entity.KabasujiGame;
import entity.Tile;
import view.PieceView;
import view.TileView;

/**
 * Drag Pieces inside the board.
 * @author LilyAnne
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
		Component c = boardPanel.getBoardTilePanel().getComponentAt(me.getPoint());
		if(c instanceof TileView){
			Tile t = ((TileView) c).getTile();
			System.out.println(t.getRow() + " " + t.getCol());
		}
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
		// TODO Auto-generated method stub
		
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
