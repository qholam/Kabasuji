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
 * flipped horizontally in the bullpen
 * 
 * @author Quoc HoLam
 *
 */
public class HorizontalFlipCtrl implements ActionListener, MouseListener {
	BullpenView bpview;

	/**
	 * Constructor for the HorizontalFlipCtrl, which will handle horizontal flips 
	 * for pieces in the bullpen.
	 * @param bullpenView Bullpen to handle.
	 */
	public HorizontalFlipCtrl(BullpenView bullpenView) {
		bpview = bullpenView;
	}

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
	/**
	 * On mouse press, the selected piece is flipped horizontally.
	 * @param e MouseEvent.
	 */
	public void mousePressed(MouseEvent e) {
		// get the current selected pieceview in the bullpen
		//System.out.println(e.getX() + " " + e.getY());
		PieceView pv = bpview.getSelected();

		// check if nothing is selected
		if (pv == null)
			return;

		// get the piece
		Piece p = pv.getPiece();

		// rotate the seleced piece clockwise
		p.horizontalFlip();

		// repaint the piece view
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
}
