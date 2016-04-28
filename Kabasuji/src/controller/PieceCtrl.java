package controller;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import GUI.BuilderLevel;
import GUI.BullpenView;
import GUI.LevelPanel;
import GUI.PieceContainer;
import entity.Bullpen;
import entity.Piece;
import entity.PieceTile;
import entity.Tile;
import entity.TileType;
import view.PieceView;
import view.TileView;

public class PieceCtrl implements MouseListener, MouseMotionListener{
	TileView tv;
	Point point;
	JPanel l;
	PieceView pv;
	BullpenView bullpen;
	PieceContainer container;
	
	public PieceCtrl(JPanel l, PieceView pv){
		this.l = l;
		this.pv = pv;
		if(l instanceof LevelPanel)
			container = ((LevelPanel) l).getPieceContainer();
		else
			container = ((BuilderLevel) l).getPieceContainer();
	} 
	
	@Override
    public void mouseClicked(MouseEvent me) {
		if(l instanceof LevelPanel){
	    	bullpen = ((LevelPanel) l).getBullpenView();
	    	container = ((LevelPanel) l).getPieceContainer();
    	}
    	else{
	    	bullpen = ((BuilderLevel) l).getBullpenView();
	    	container = ((BuilderLevel) l).getPieceContainer();
    	}
		
		if(SwingUtilities.isLeftMouseButton(me) ){
			Component c = pv.getComponentAt(me.getPoint());
			if(c instanceof TileView){
				Tile t = ((TileView) c).getTile();
				if(t == null || t.toString().equals(TileType.noTile)){
					return;
				}
				else{
					bullpen.setSelected(pv);
				}
			}
		}
    }
	
	@Override
	public void mousePressed(MouseEvent me) {
		if(!SwingUtilities.isLeftMouseButton(me) )
			return; 
		
		if(l instanceof LevelPanel){
	    	bullpen = ((LevelPanel) l).getBullpenView();
	    	container = ((LevelPanel) l).getPieceContainer();
    	}
    	else{
	    	bullpen = ((BuilderLevel) l).getBullpenView();
	    	container = ((BuilderLevel) l).getPieceContainer();
    	}
		
		if(!container.isVisible()){
        	Component c = pv.getComponentAt(me.getPoint());
        	if(c instanceof TileView){
        		tv = (TileView) c;
        		Tile t = tv.getTile();
        		if(t != null && !t.toString().equals(TileType.noTile)){
        			container.setAnchortile(tv);
        			container.setSource(pv);
        			point = tv.getLocation();
        			container.setDraggingPiece(pv.getPiece());
    	            container.setLocation(point);
    	            container.setVisible(true);
    	            Bullpen bp = bullpen.getBullpen();
    	            bp.changeQuantity(pv.getPiece(), -1);
        		}
        	}  
        	else{
    			Piece dragged = container.getDraggingPiece().getPiece();
    			Bullpen bp;
    			if(l instanceof LevelPanel){
	    			bp = ((LevelPanel) l).getBullpenView().getBullpen();
	    	    	bp.changeQuantity(dragged, 1);
	    	    	((LevelPanel) l).getBullpenView().repaint();
    			}
    			else{
    				bp = ((BuilderLevel) l).getBullpenView().getBullpen();
	    	    	bp.changeQuantity(dragged, 1);
	    	    	((BuilderLevel) l).getBullpenView().repaint();
    			}
    	    	container.setVisible(false);
        	}
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent me) {
    	if(container.isVisible()){ 
    		if(l instanceof LevelPanel){
	    		((LevelPanel) l).getBoardPanel().setRepaintInvalid();
	    		((LevelPanel) l).getBullpenView().setSelected(null);
	    		((LevelPanel) l).setIgnoreRepaint(true);
    		}
    		else{
    			((BuilderLevel) l).getBoardPanel().setRepaintInvalid();
    			((BuilderLevel) l).getBullpenView().setSelected(null);
	    		((BuilderLevel) l).setIgnoreRepaint(true);
    		}
    		tv = container.getAnchorTile();
    		Point point = l.getMousePosition();
    		int cw = container.getWidth()/6;
    		int ch = container.getHeight()/6;
    		int dx = cw * ((PieceTile) tv.getTile()).getPieceGridCol() + cw/2;
    		int dy = ch * ((PieceTile) tv.getTile()).getPieceGridRow() + ch/2;
    		point.translate(-dx, -dy);
    		if(point != null)
    			container.setLocation(point);
    	}
	}
	
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
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
}
