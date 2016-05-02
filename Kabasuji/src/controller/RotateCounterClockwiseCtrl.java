package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.BullpenView;
import entity.Piece;
import view.PieceView;
/**
 * Controller to handle the event that a piece is selected and asked to be rotated counterclockwise in the bullpen
 * @author Quoc HoLam
 *
 */
public class RotateCounterClockwiseCtrl implements ActionListener, MouseListener{
	BullpenView bpview;
	
	public RotateCounterClockwiseCtrl(BullpenView bullpenView) {
		bpview = bullpenView;
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

	@Override
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
	public void mouseReleased(MouseEvent e) {
		bpview.setRepaintValid();
	}

}
