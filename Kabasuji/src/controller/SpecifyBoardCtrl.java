package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.BoardPanel;
import GUI.SpecifyBoardPropertiesView;
import entity.NoTile;
import view.TileView;

public class SpecifyBoardCtrl implements MouseListener{
	SpecifyBoardPropertiesView sbpv;
	BoardPanel boardPanel;
	
	public SpecifyBoardCtrl(SpecifyBoardPropertiesView s, BoardPanel b){
		sbpv = s;
		boardPanel = b;
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		TileView t = sbpv.getClickedTile(me);
		if(t != null){
			System.out.println("Set tile" + t.getTile().getRow() + " " + t.getTile().getCol());
			t.setTile(new NoTile(0,0));	
		}
		
		boardPanel.setRepaintValid();
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

}
