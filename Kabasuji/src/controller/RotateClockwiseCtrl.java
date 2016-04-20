package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.BullpenView;
import entity.Bullpen;
import entity.Piece;

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
		//Get the bullpen represented by the given bullpen view
		Bullpen bp = bpview.getBullpen();
		
		//get the current selected piece in the bullpen
		Piece p = bp.getSelectedPiece();
		
		//check if nothing is selected
		if(p == null)
			return;
		
		//rotate the seleced piece clockwise
		p.rotateClockwise();
		
		//TODO: update the bullpenview somehow
	}

}
