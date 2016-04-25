package controller;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import GUI.BullpenView;
import GUI.KabasujiFrame;
import GUI.LevelPanel;
import GUI.PieceContainer;
import entity.Piece;
import entity.PieceTile;
import entity.Tile;
import entity.TileType;
import view.PieceView;
import view.TileView;

public class PieceInBullpenCtrl implements MouseListener, MouseMotionListener{
	BullpenView bv;
	PieceView pv;

	
	public PieceInBullpenCtrl(BullpenView b, PieceView p){
		bv = b;
		pv = p;
	}
	
	@Override
    public void mousePressed(MouseEvent me) {
		Component c = pv.getComponentAt(me.getPoint());
		
		//more accurate clicking, piece is only selected if user clicks on a tile that is not null or a notile
		if(c instanceof TileView){
			Tile t = ((TileView) c).getTile();
			if(t == null || t.toString().equals(TileType.noTile)){
				return;
			}
			else{
				bv.setSelected(pv);
			}
		}
    }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
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
    public void mouseReleased(MouseEvent me){

    }
	
	@Override
    public void mouseDragged(MouseEvent me) {
    }

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
