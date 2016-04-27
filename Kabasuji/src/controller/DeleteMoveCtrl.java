package controller;

import java.awt.event.MouseEvent;

import entity.KabasujiGame;
import move.IMove;
/**
 * Delete a Move.
 * @author LilyAnne
 *
 */
public class DeleteMoveCtrl 
{
	KabasujiGame theGame;
	IMove move;
	
	public DeleteMoveCtrl(KabasujiGame theGame,  IMove move)
	{
		this.theGame = theGame;
		this.move = move;

	}
	public void mousePressed (MouseEvent me)
	{
		/**
		 * need more information here as well
		 */

			
		//redraw();
	}
}
