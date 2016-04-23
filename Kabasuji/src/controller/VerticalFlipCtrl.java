package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.BullpenView;
import entity.Piece;
import view.PieceView;
/**
 * Controller to handle the event that a piece is selected and asked to be flipped vertically in the bullpen
 * @author Quoc HoLam
 *
 */
public class VerticalFlipCtrl implements ActionListener{
	BullpenView bpview;
	
	public VerticalFlipCtrl(BullpenView bullpenView) {
		bpview = bullpenView;
	}

	@Override
	public void actionPerformed(ActionEvent e) { 
		//get the current selected pieceview in the bullpen
		PieceView pv = bpview.getSelected();
		
		//check if nothing is selected
		if(pv == null)
			return;
		
		//get the piece
		Piece p = pv.getPiece();
		
		//rotate the seleced piece clockwise
		p.verticalFlip();
		
		//repaint the piece view
		pv.repaint();
	}

}
