package controller;

import java.awt.event.MouseEvent;

import entity.Board;
import entity.Bullpen;
import entity.KabasujiGame;
import entity.Piece;
import move.IMove;

public class DeleteMoveCtrl 
{
	KabasujiGame theGame;
	IMove move;
	
	public void DeleteMoveCtrl(KabasujiGame theGame,  IMove move)
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
