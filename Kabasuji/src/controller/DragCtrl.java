/**
 * 
 */
package controller;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

import GUI.BullpenView;
import GUI.LevelPanel;
import GUI.PieceContainer;
import entity.Bullpen;
import entity.Piece;
import entity.Tile;
import entity.TileType;
import view.PieceView;
import view.TileView;

/**
 * Controller to handle the dragging of pieces within a level panel.
 * @author Quoc HoLam
 *
 */
public class DragCtrl {
	/**
	 * Handles the event when a piece is being dragged.
	 * For some reason if these mouse adapters are added any where
	 * but this class, it will not work. 
	 * As of now this method assumes that the given JPanel is a PiceView.
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
	public void handleDrag(final JPanel panel, final LevelPanel l){
	    panel.addMouseListener(new MouseAdapter() {
	    	//cast given panel to be a PieceView and represented piece
	    	PieceView pv = (PieceView) panel;
	    	Piece p = pv.getPiece();
	    	//get the bullpenview
	    	BullpenView bullpen = l.getBullpenView();
	    	//get container
	    	PieceContainer container = l.getPieceContainer();
	    	
	    	@Override
	        public void mousePressed(MouseEvent me) {
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
	        }
	        
	        @Override
	        public void mouseReleased(MouseEvent me){
	        	//return container to its original position(is this needed?)
	        	container.setLocation(0, 0);
	        	 
	        	//container is no longer being used so hide it(there might be a better way to do this)
	        	container.setVisible(false);
	        	
	        	//piece is returned to bullpen, update its quantity and repaint
	        	Bullpen bp = bullpen.getBullpen();
	        	bp.changeQuanity(p, 1);
	        	bullpen.repaint();
	        }
	    });
	    
	    panel.addMouseMotionListener(new MouseMotionAdapter() {
	    	//get the container
	    	PieceContainer container = l.getPieceContainer();
	    	
	        @Override
	        public void mouseDragged(MouseEvent me) {
	        	//check if container is currently being used
	        	if(container.isVisible()){
	        		//get the position on the mouse on the level panel
	        		Point point = l.getMousePosition();
	        		
	        		//crazy math but it works, this center the mouse on top of the anchoring piece while being dragged
		        	point.translate(-(tv.getX()/2 + tv.getHeight()/4), -(tv.getY()/2 + tv.getWidth()/4));
		            container.setLocation(point);
	        	}
	        }
	    });
	}
}
