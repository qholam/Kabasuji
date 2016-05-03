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
	// EditorPanel ep;
	PieceContainer container;

	public EditorPanelCtrl(PieceView pv, JPanel l) {
		this.pv = pv;
		this.l = l;
		this.container = ((BuilderLevel) l).getPieceContainer();
		this.bv = ((BuilderLevel) l).getBullpenView();
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		

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
		System.out.println("GOT CLICK");
		if (!(l instanceof BuilderLevel)) {
			return;
		}
		if (SwingUtilities.isLeftMouseButton(e)) {
			// Component c = pv.getComponentAt(me.getPoint());
			System.out.println(pv.getPiece().toString());
			if (pv instanceof PieceView) {
				Piece p = ((PieceView) pv).getPiece();
				Piece pClone = new Piece(p);
				bv.getBullpen().addPiece(pClone);
				System.out.println("# in bullpen" + bv.getBullpen().getPieces().size());
			}
		}
		bv = ((BuilderLevel) l).getBullpenView();
		bv.revalidate();
		bv.setRepaintValid();
		System.out.println("# in bullpen" + bv.getBullpen().getPieces().size());
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
/**
 * Gets the bullpenview associated with this panel.
 * @return BullpenView the BullpenView associated with this panel.
 **/
	public BullpenView getBullpenView() {
		return this.bv;
		
	}

}