package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.BullpenView;
import entity.Bullpen;
import entity.Piece;
import view.PieceView;

public class HorizontalFlipCtrl implements ActionListener{
	BullpenView bpview;
	
	public HorizontalFlipCtrl(BullpenView bullpenView) {
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
		p.horizontalFlip();
		
		//repaint the piece view
		pv.repaint();
	}
}
