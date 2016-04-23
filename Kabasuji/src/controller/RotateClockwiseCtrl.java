package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.BullpenView;
import entity.Piece;
import view.PieceView;
/**
 * Controller to handle the event that a piece is selected and asked to be rotated clockwise in the bullpen
 * @author Quoc HoLam
 *
 */
public class RotateClockwiseCtrl implements ActionListener{
	BullpenView bpview;

	public RotateClockwiseCtrl(BullpenView b) {
		bpview = b;
	}

	/**
	 * Handles the action event for the button that rotate a piece clockwise inside the bullpen
	 * @param ActionEvent The action performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) { 
		//get the current selected pieceview in the bullpen
		PieceView pv = bpview.getSelected();
		
		//check if nothing is selected
		if(pv == null)
			return;
		
		//get the piece
		Piece p = pv.getPiece();
		
		//rotate the selected piece clockwise 
		p.rotateClockwise();
		
		//repaint the piece view
		pv.repaint();
	}

}
