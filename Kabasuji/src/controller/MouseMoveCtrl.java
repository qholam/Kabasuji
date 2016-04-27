package controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import GUI.BoardPanel;
import GUI.BuilderLevel;
import GUI.LevelPanel;
import GUI.PieceContainer;
import entity.Bullpen;
import entity.Piece;
import entity.PieceTile;
import view.TileView;

public class MouseMoveCtrl implements MouseMotionListener, MouseListener{
	JPanel l;
	PieceContainer container;
	Bullpen bp;
	Piece dragged;
	
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
    		//there were issues with adding a piece to the board and then clicking any of the rotate/flip buttons
    		if(l instanceof LevelPanel)
    			((LevelPanel) l).getBullpenView().setSelected(null);
    		else
    			((BuilderLevel) l).getBullpenView().setSelected(null);
    		
    		//get the anchor of the drag 
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
		//there were issues with adding a piece to the board and then clicking any of the rotate/flip buttons
		if(l instanceof LevelPanel){
			((LevelPanel) l).getBullpenView().setRepaintValid();
			((LevelPanel) l).getBoardPanel().setRepaintValid();
		}
		else{
			((BuilderLevel) l).getBullpenView().setRepaintValid();
			((BuilderLevel) l).getBoardPanel().setRepaintValid();
		}
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
			//if source is board it cannot be dropped anywhere else but the board
			if(container.getSource() instanceof BoardPanel || container.getSource() instanceof BuilderLevel){
				return;
			}
			
			if(l instanceof LevelPanel){
				//allow board to be rapainted again
				bp = ((LevelPanel) l).getBullpenView().getBullpen();
				//get the piece being dragged
				dragged = container.getDraggingPiece().getPiece(); 
			}
			else{
				//allow board to be rapainted again
				bp = ((BuilderLevel) l).getBullpenView().getBullpen();
				//get the piece being dragged
				dragged = container.getDraggingPiece().getPiece();
			}
			
			//added piece back to the bullpen by updating pieces quantity
			if(bp != null)
				bp.changeQuanity(dragged, 1);
	    	
	    	container.setVisible(false);
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
