/**
 * 
 */
package controller;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import GUI.BoardPanel;
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

/**
 * Controller to handle the dragging of pieces within a level panel.
 * @author Quoc HoLam
 *
 */
public class DragCtrl implements MouseListener, MouseMotionListener{
	/**
	 * Handles the event when a piece is being dragged.
	 * For some reason if these mouse adapters are added any where
	 * but this class, it will not work. 
	 * As of now this method assumes that the given JPanel is a PieceView.
	 * There are currently graphical issues when dragging a piece over another
	 * piece in the bullpen.
	 * @param panel Given panel to handle a drag event for
	 * @param l The given LevelPanel for which the drag will take place in
	 */
	//view of the tile that was clicked on and its represented tile
	TileView tv;
	Tile t; 
	
	//used to keep track of the mouse position
	Point point;
	
	//the level panel and piece view that are passed
	JPanel l;
	PieceView pv;
	Piece p;
	
	//get the bullpenview and container
	BullpenView bullpen;
	PieceContainer container;
	
	public DragCtrl(PieceView panel, JPanel l){
		this.l = l;
		pv = panel;
    	p = pv.getPiece();
	}
	
    public void mouseClicked(MouseEvent me) {
		//checks that it is a left mouse press,if not do nothing
		if(!SwingUtilities.isLeftMouseButton(me) )
			return; 
		
		if(l instanceof LevelPanel){
	    	//get the bullpenview
	    	bullpen = ((LevelPanel) l).getBullpenView();
	    	//get container
	    	container = ((LevelPanel) l).getPieceContainer();
    	}
    	else{
    		//get the bullpenview
	    	bullpen = ((BuilderLevel) l).getBullpenView();
	    	//get container
	    	container = ((BuilderLevel) l).getPieceContainer();
    	}
		
		if(!container.isVisible()){
    		//get the component that was clicked on within the panel
        	Component c = pv.getComponentAt(me.getPoint());
        	
        	//check if the component is a tile view
        	if(c instanceof TileView){
        		//cast to TileView and get the represented tile
        		tv = (TileView) c;
        		t = tv.getTile();
        		
        		//ensures that drag is only initiated when player click on piece and not its container
        		if(t != null && !t.toString().equals(TileType.noTile)){
        			//set the tile that was clicked on to be the anchor for this drag
        			container.setAnchortile(tv); 
        			//set the source
        			container.setSource(pv);
        			
        			//get the location of the tile, set the piece to be dragged, and have its initial location be the point in which the mouse was clicked
        			//this is still jittery
        			point = tv.getLocation();
        			container.setDraggingPiece(p);
    	            container.setLocation(point);
    	            
    	            //container is visible when being used(there might be a better way to do this)
    	            container.setVisible(true);
    	            
    	            //update quantity of piece
    	            Bullpen bp = bullpen.getBullpen();
    	            bp.changeQuanity(p, -1);
        		}
        	}  
        	else{//another piece is currently being dragged, release it first
        		//get the piece being dragged
    			Piece dragged = container.getDraggingPiece().getPiece();
    			Bullpen bp;
    			//added it back to the bullpen by updating pieces quantity
    			if(l instanceof LevelPanel){
	    			bp = ((LevelPanel) l).getBullpenView().getBullpen();
	    	    	bp.changeQuanity(dragged, 1);
	    	    	((LevelPanel) l).getBullpenView().repaint();
    			}
    			else{
    				bp = ((BuilderLevel) l).getBullpenView().getBullpen();
	    	    	bp.changeQuanity(dragged, 1);
	    	    	((BuilderLevel) l).getBullpenView().repaint();
    			}
    	    	container.setVisible(false);
        	}
		}
    }

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {
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
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
