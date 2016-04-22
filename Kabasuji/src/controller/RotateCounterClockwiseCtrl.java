package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.BullpenView;
import entity.Bullpen;
import entity.Piece;
import view.PieceView;

public class RotateCounterClockwiseCtrl implements ActionListener{
	BullpenView bpview;
	
	public RotateCounterClockwiseCtrl(BullpenView bullpenView) {
		bpview = bullpenView;
	}

	@Override
	public void actionPerformed(ActionEvent e) { 
		//Get the bullpen represented by the given bullpen view
		Bullpen bp = bpview.getBullpen();
		
		//get the current selected pieceview in the bullpen
		PieceView pv = bpview.getSelected();
		
		//check if nothing is selected
		if(pv == null)
			return;
		
		//get the piece
		Piece p = pv.getPiece();
		
		//rotate the seleced piece clockwise
		p.rotateCounterclockwise();
		
		//repaint the piece view
		pv.repaint();
	}

}
