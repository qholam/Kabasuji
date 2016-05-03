package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.BullpenView;
import entity.Piece;
import view.PieceView;


public class RotateClockwiseCtrl implements ActionListener, MouseListener {
	BullpenView bpview;

	/**
	 * Rotates the selected piece clockwise.
	 * @param b The BullpenView for the bullpen in which the piece is contained. 
	 */
	public RotateClockwiseCtrl(BullpenView b) {
		bpview = b;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// get the current selected pieceview in the bullpen
		PieceView pv = bpview.getSelected();
		//System.out.println(e.getX() + " " + e.getY());
		// check if nothing is selected
		if (pv == null)
			return;
		// get the piece
		Piece p = pv.getPiece();
		// rotate the selected piece clockwise
		p.rotateClockwise();
		// repaint the piece view
		pv.setRepaintValid();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		bpview.setRepaintValid();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
