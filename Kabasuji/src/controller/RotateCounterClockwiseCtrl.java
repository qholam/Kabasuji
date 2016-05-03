package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.BullpenView;
import entity.Piece;
import view.PieceView;

public class RotateCounterClockwiseCtrl implements ActionListener, MouseListener{
	BullpenView bpview;
	
	
	/**
	 * Constructor for RotateCounterClockwiseCtrl, which will handle counterclockwise rotations
	 * for pieces in the bullpen.
	 * @param b The BullpenView for the bullpen in which the piece is contained. 
	 */
	public RotateCounterClockwiseCtrl(BullpenView bullpenView) {
		bpview = bullpenView;
	}

	@Override
	/**
	 * On mouse press, the selected piece is rotated counterclockwise.
	 * @param e MouseEvent.
	 */
	public void mousePressed(MouseEvent e) {
		//get the current selected pieceview in the bullpen
		//System.out.println(e.getX() + " " + e.getY());
		PieceView pv = bpview.getSelected();
		
		//check if nothing is selected
		if(pv == null)
			return;
		
		//get the piece
		Piece p = pv.getPiece();
		//rotate the selected piece clockwise
		p.rotateCounterclockwise();
		//repaint the piece view
		pv.setRepaintValid();
		
	}

	@Override
	/**
	 * On mouse release, {@link BullpenView} is repainted.
	 * @param e MouseEvent.
	 */
	public void mouseReleased(MouseEvent e) {
		bpview.setRepaintValid();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { 	
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
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
