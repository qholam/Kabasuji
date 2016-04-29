/**
 * 
 */
package controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import GUI.BuilderLevel;
import GUI.BullpenView;
import GUI.EditorPanel;
import GUI.PieceContainer;
import entity.Bullpen;
import entity.Piece;
import view.PieceView;

public class EditorPanelCtrl implements MouseListener, MouseMotionListener {
	JPanel l;
	PieceView pv;
	BullpenView bv;
	EditorPanel ep;
	PieceContainer container;
	
	public EditorPanelCtrl(EditorPanel ep, JPanel l){
		this.l = l;
		this.ep = ep;
		this.container = ((BuilderLevel) l).getPieceContainer();
		this.bv = ((BuilderLevel) l).getBullpenView();
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		System.out.println("# in bullpen" + bv.getBullpen().getPieces().size());
		System.out.println("GOT CLICK");
		if(!(l instanceof BuilderLevel)){
			return;
		}		
		if(SwingUtilities.isLeftMouseButton(me)){
		Component c = container.getComponentAt(me.getPoint());
		if(c instanceof PieceView){
			Piece p = ((PieceView) c).getPiece();
			bv.getBullpen().addPiece(p);
			System.out.println("# in bullpen" + bv.getBullpen().getPieces().size());
			}
		}
		bv = ((BuilderLevel) l).getBullpenView();
		bv.setRepaintValid();
		container.repaint();
		
		}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
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

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}