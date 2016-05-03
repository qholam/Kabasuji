package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import GUI.BoardPanel;
import GUI.KabasujiBuilderFrame;
import GUI.SpecifyBoardPropertiesView;
import entity.BoardTile;
import entity.NoTile;
import entity.ReleaseTile;
import entity.TileType;
import view.TileView;
import entity.Number;

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


	//Release tiles that can be added to the board
	ReleaseTile greenRelease = new ReleaseTile(0, 0, new Number(1, Color.GREEN));
	ReleaseTile redRelease = new ReleaseTile(0, 0, new Number(1, Color.RED));
	ReleaseTile blueRelease = new ReleaseTile(0, 0, new Number(1, Color.BLUE));
	@Override
	public void mousePressed(MouseEvent me) {
		TileView t = sbpv.getClickedTile(me);
		//click has to be on a board tile
		if(t == null)
			return;
		
		int row = t.getTile().getRow();
		int col = t.getTile().getCol();

		
		if(SwingUtilities.isLeftMouseButton(me)){//left click will remove/readd tiles
			//add or remove board tile depending on whether or not there is currently a board tile at clicked location
			switch(t.getTile().toString()){
			case TileType.boardTile:
				boardPanel.getBoard().getGrid()[col][row] = new NoTile(row,col);
				break;
			case TileType.noTile:
				boardPanel.getBoard().getGrid()[col][row] = new BoardTile(row,col);
				break;
			}
		}
		else if(SwingUtilities.isRightMouseButton(me)){//right click will add/remove release tiles
			switch(t.getTile().toString()){
			case TileType.boardTile:
				boardPanel.getBoard().getGrid()[col][row] = greenRelease;
				boardPanel.getBoard().getGrid()[col][row].setRow(row);
				boardPanel.getBoard().getGrid()[col][row].setCol(col);
				greenRelease = greenRelease.getNext();
				break;
			case TileType.releaseTile:
				//get the color of the tile
				Color c = ((ReleaseTile) t.getTile()).getNumber().getColor();
				if(c.equals(Color.GREEN)){
					boardPanel.getBoard().getGrid()[col][row] = redRelease;
					boardPanel.getBoard().getGrid()[col][row].setRow(row);
					boardPanel.getBoard().getGrid()[col][row].setCol(col);
					greenRelease = greenRelease.getPrevious();
					redRelease = redRelease.getNext();
				}
				else if(c.equals(Color.RED)){
					boardPanel.getBoard().getGrid()[col][row] = blueRelease;
					boardPanel.getBoard().getGrid()[col][row].setRow(row);
					boardPanel.getBoard().getGrid()[col][row].setCol(col);
					redRelease = redRelease.getPrevious();
					blueRelease = blueRelease.getNext();
				}
				else if(c.equals(Color.BLUE)){
					boardPanel.getBoard().getGrid()[col][row] = new BoardTile(row,col);
					blueRelease = blueRelease.getPrevious();
				}
				break;
			}
		}
		
		//repaint board
		boardPanel.setRepaintValid();
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		
	}

}
