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

	/**
	 * Constructor to create a EditorPanelCrl, which will handle all mouse events 
	 * for pieces within the {@link EditorPanel}.
	 * @param pv The piece to handle.
	 * @param l The level panel.
	 */
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
	/**
	 * On mouse press, the piece that is pressed on is added to the bullpen
	 * if the played is in the builder application.
	 * @param e MouseEvent.
	 */
	public void mousePressed(MouseEvent e) {
		//do nothing if not in builder level panel
		if (!(l instanceof BuilderLevel)) {
			return;
		}
		if (SwingUtilities.isLeftMouseButton(e)) {
			// Component c = pv.getComponentAt(me.getPoint());
			System.out.println(pv.getPiece().toString());
			if (pv instanceof PieceView) {
				Piece p = ((PieceView) pv).getPiece();
				//clone piece
				Piece pClone = new Piece(p);
				//add to bullpen
				bv.getBullpen().addPiece(pClone);
			}
		}
		bv = ((BuilderLevel) l).getBullpenView();
		bv.revalidate();
		bv.setRepaintValid();
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