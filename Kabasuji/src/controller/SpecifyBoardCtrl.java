package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.BoardPanel;
import GUI.SpecifyBoardPropertiesView;
import entity.NoTile;
import view.TileView;

public class SpecifyBoardCtrl implements MouseListener {
	SpecifyBoardPropertiesView sbpv;
	BoardPanel boardPanel;

	public SpecifyBoardCtrl(SpecifyBoardPropertiesView s, BoardPanel b) {
		sbpv = s;
		boardPanel = b;
	}

	@Override
	public void mouseClicked(MouseEvent me) {
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
		TileView t = sbpv.getClickedTile(me);
		if (t != null) {
			int row = t.getTile().getRow();
			int col = t.getTile().getCol();
			boardPanel.getBoard().getGrid()[col][row] = new NoTile(row,col);
		}
		boardPanel.setRepaintValid();
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		
	}

}
