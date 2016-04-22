package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.BullpenView;
import view.PieceView;

public class PieceInBullpenCtrl implements MouseListener{
	BullpenView bv;
	PieceView pv;
	
	public PieceInBullpenCtrl(BullpenView b, PieceView p){
		bv = b;
		pv = p;
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		bv.setSelected(pv);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		bv.setSelected(pv);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
