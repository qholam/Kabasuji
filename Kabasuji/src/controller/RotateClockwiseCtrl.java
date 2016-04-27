package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.BullpenView;
import entity.Piece;
import view.PieceView;

/**
 * Controller to handle the event that a piece is selected and asked to be
 * rotated clockwise in the bullpen
 * 
 * @author Quoc HoLam
 *
 */
public class RotateClockwiseCtrl implements ActionListener, MouseListener {
	BullpenView bpview;

	public RotateClockwiseCtrl(BullpenView b) {
		bpview = b;
	}

	/**
	 * Handles the action event for the button that rotate a piece clockwise
	 * inside the bullpen
	 * 
	 * @param ActionEvent
	 *            The action performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

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

	@Override
	public void mousePressed(MouseEvent e) {
		// get the current selected pieceview in the bullpen
		PieceView pv = bpview.getSelected();

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

}
