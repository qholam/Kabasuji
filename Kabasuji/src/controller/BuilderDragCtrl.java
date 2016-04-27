/**
 * 
 */
package controller;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import GUI.BuilderPuzzleLevel;
import GUI.BullpenView;
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
public class BuilderDragCtrl {
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
	public void handleDrag(final PieceView panel, final BuilderPuzzleLevel builderPuzzleLevel){
	    panel.addMouseListener(new MouseAdapter() {
	    	//cast given panel to be a PieceView and represented piece
	    	PieceView pv = panel;
	    	Piece p = pv.getPiece();
	    	//get the bullpenview
	    	BullpenView bullpen = builderPuzzleLevel.getBullpenView();
	    	//get container
	    	PieceContainer container = builderPuzzleLevel.getPieceContainer();
	    	
	    	@Override
	        public void mouseClicked(MouseEvent me) {
	    		//checks that it is a left mouse press,if not do nothing
	    		if(!SwingUtilities.isLeftMouseButton(me) )
	    			return;
	    		
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
		        			container.setSource(panel);
		        			
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
		    			
		    			//added it back to the bullpen by updating pieces quantity
		    			Bullpen bp = builderPuzzleLevel.getBullpenView().getBullpen();
		    	    	bp.changeQuanity(dragged, 1);
		    	    	builderPuzzleLevel.getBullpenView().repaint();
		    	    	
		    	    	container.setVisible(false);
		        	}
	    		}
	        }
	    });
	}
}
