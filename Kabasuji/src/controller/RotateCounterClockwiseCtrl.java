package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.BullpenView;
import entity.Bullpen;
import entity.Piece;

public class RotateCounterClockwiseCtrl implements ActionListener{
	BullpenView bpview;
	
	public RotateCounterClockwiseCtrl(BullpenView bullpenView) {
		bpview = bullpenView;
	}

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
		p.rotateCounterclockwise();
				
		//TODO: update the bullpenview somehow	
	}

}
