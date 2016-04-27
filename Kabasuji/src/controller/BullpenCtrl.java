package controller;

import view.PieceView;
import java.awt.event.MouseEvent;

import entity.Board;
import entity.Bullpen;
import entity.KabasujiGame;


/**
 * Move Pieces within the BullPen
 * @author LilyAnne
 *
 */
public class BullpenCtrl {
		KabasujiGame theGame;
		Bullpen theBullpen;
		PieceView srcPiece;
		
		public void BoardtoBullpenCtrl(KabasujiGame theGame, Board theBoard, Bullpen theBullpen, PieceView srcPiece)
		{
			this.theGame = theGame;
			this.theBullpen = theBullpen;
			this.srcPiece = srcPiece;
		}
		
		public void mousePressed (MouseEvent me)
		{
			//PieceContainer container = theGame.getContainer();
			//PieceView pieceDragging = container.getDraggingPiece();
					
			//Invalid selection
			if (srcPiece.getPiece() == null) 
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
