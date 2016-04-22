package controller;

import entity.Piece;
import move.IMove;
import view.PieceView;

import java.awt.event.MouseEvent;

import entity.Board;
import entity.Bullpen;
import entity.KabasujiGame;

public class BaordToBullpenCtrl 
{
	KabasujiGame theGame;
	Board theBoard;
	Bullpen pen;
	Piece piece;
	
	public void BoardtoBullpenCtrl(KabasujiGame theGame, Board theBoard, Bullpen pen, Piece piece)
	{
		this.theGame = theGame;
		this.theBoard = theBoard;
		this.pen = pen;
		this.piece = piece;

	}
	
	public void mousePressed (MouseEvent me)
	{
		/**
		 * need more information here as well
		 */
		
				
		//Invalid selection
		if (piece == null) 
		{
			//releaseDraggingObject();
			return;
		}
				
			
		// Tell container which object is being dragged, and where in that widget the user clicked.
		//c.setActiveDraggingObject (piece, me);
				
		// Tell container which source widget initiated the drag
		//setDragSource (board);
			
		//redraw();
	}
	
	public void mouseReleased(MouseEvent me)
	{
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
}
