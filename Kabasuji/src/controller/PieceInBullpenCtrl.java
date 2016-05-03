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

	/**
	 * Constructor for PieceInBullpenCtrl that handles when a mouse event occurs in the specified bullpen.
	 * @param b The BullpenView for the bullpen in which the piece is contained.
	 * @param p The PieceView for the piece that is being selected.
	 */
	public PieceInBullpenCtrl(BullpenView b, PieceView p){
		bv = b;
		pv = p;
	}
	 
	@Override
    public void mousePressed(MouseEvent me) {
		if(SwingUtilities.isRightMouseButton(me)){
			Component c = pv.getComponentAt(me.getPoint());
			
			//more accurate clicking, piece is only selected if user clicks on a tile that is not null or a notile
			if(c instanceof TileView){
				Tile t = ((TileView) c).getTile();
				if(t == null || t.toString().equals(TileType.noTile)){
					return;
				}
				else{
					//unselect a piecce if one is selected
					if(bv.getSelected() != null)
						bv.getSelected().toggleBorder(false);
					//select piece
					bv.setSelected(pv);
					pv.toggleBorder(true);
				}
			}
		}
    }
	
	@Override
    public void mouseReleased(MouseEvent me){
		bv.setRepaintValid();
		pv.setRepaintValid();
    }

	/**
	 * Gets the pieceView associated with this piece in bullpen controller.
	 * @return PieceView the pieceView of the piece
	 */
	public PieceView getPieceView(){
		return this.pv;
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
    public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
    }

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}
