package controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import GUI.BullpenView;
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
		System.out.println(me.getX() + " " + me.getY());
		System.out.println(me.isPopupTrigger() + " " +  me.getModifiers() + " " + me.getID());
		if(SwingUtilities.isRightMouseButton(me)){
			Component c = pv.getComponentAt(me.getPoint());
			System.out.println(c);
			
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
		System.out.println(me.getX() + " " + me.getY());

		bv.setRepaintValid();
		pv.setRepaintValid();
    }
	
	@Override
    public void mouseDragged(MouseEvent me) {
    }

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Gets the pieceView associated with this piece in bullpen controller.
	 * @return PieceView the pieceView of the piece
	 */
	public PieceView getPieceView(){
		return this.pv;
	}
}
