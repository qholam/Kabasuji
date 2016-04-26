package controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import GUI.BuilderLevel;
import GUI.LevelPanel;
import GUI.PieceContainer;
import entity.Bullpen;
import entity.Level;
import entity.Piece;
import entity.PieceTile;
import view.TileView;

public class MouseMoveCtrl implements MouseMotionListener, MouseListener{
	JPanel l;
	PieceContainer container;
	
	public MouseMoveCtrl(JPanel l){
		this.l = l;
		if(l instanceof LevelPanel)
			container = ((LevelPanel) l).getPieceContainer();
		else
			container = ((BuilderLevel) l).getPieceContainer();
	}
	
	@Override
    public void mouseMoved(MouseEvent me) {
    	TileView tv;
 
    	//check if container is currently being used
    	if(container.isVisible()){
    		//this prevents flickering when dragging a piece over the board
    		if(l instanceof LevelPanel){
	    		((LevelPanel) l).getBoardPanel().setRepaintInvalid();
	    		
	    		((LevelPanel) l).setIgnoreRepaint(true);
    		}
    		else{
    			((BuilderLevel) l).getBoardPanel().setRepaintInvalid();
	    		
	    		((BuilderLevel) l).setIgnoreRepaint(true);
    		}
    		tv = container.getAnchorTile();
    		
    		//get the position on the mouse on the level panel
    		Point point = l.getMousePosition();
    		
    		//Some crazy math to calculate the offest, but it works.
    		//width of a tile in the container
    		int cw = container.getWidth()/6;
    		//height of a tile in the container
    		int ch = container.getHeight()/6;
    		//calculate offset to have mouse hoover over the anchor tile
    		int dx = cw * ((PieceTile) tv.getTile()).getPieceGridCol() + cw/2;
    		int dy = ch * ((PieceTile) tv.getTile()).getPieceGridRow() + ch/2;
    		
    		//account for the offest and set the point
    		point.translate(-dx, -dy);
    		
    		//cant move outside window
    		//TODO add dragged piece back to original spot
    		if(point != null)
    			container.setLocation(point);
    	}
    }

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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

	/**
	 * When pressed anywhere but board, the dragging piece is returned to the
	 * source.
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		if(container.isVisible()){
			if(l instanceof LevelPanel){
				//allow board to be rapainted again
				((LevelPanel) l).getBoardPanel().setRepaintInvalid();
				
				//get the piece being dragged
				Piece dragged = container.getDraggingPiece().getPiece();
				
				//added it back to the bullpen by updating pieces quantity
				Bullpen bp = ((LevelPanel) l).getBullpenView().getBullpen();
		    	bp.changeQuanity(dragged, 1);
		    	((LevelPanel) l).getBullpenView().repaint();
		    	
		    	container.setVisible(false);
			}
			else{
				//allow board to be rapainted again
				((BuilderLevel) l).getBoardPanel().setRepaintInvalid();
				
				//get the piece being dragged
				Piece dragged = container.getDraggingPiece().getPiece();
				
				//added it back to the bullpen by updating pieces quantity
				Bullpen bp = ((BuilderLevel) l).getBullpenView().getBullpen();
		    	bp.changeQuanity(dragged, 1);
		    	((BuilderLevel) l).getBullpenView().repaint();
		    	
		    	container.setVisible(false);
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
