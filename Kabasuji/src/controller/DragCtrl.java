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

/**
 * Controller to handle the dragging of pieces within a level panel.
 * 
 * @author Quoc HoLam
 *
 */
public class DragCtrl implements MouseListener, MouseMotionListener {
	
	// view of the tile that was clicked on and its represented tile
	TileView tv;
	Tile t;

	// used to keep track of the mouse position
	Point point;

	// the level panel and piece view that are passed
	JPanel l;
	PieceView pv;
	Piece p;

	// get the bullpenview and container
	BullpenView bullpen;
	PieceContainer container;

	/**
	 * Handles the event when a piece is being dragged. For some reason if these
	 * mouse adapters are added any where but this class, it will not work. As
	 * of now this method assumes that the given JPanel is a PieceView. There
	 * are currently graphical issues when dragging a piece over another piece
	 * in the bullpen.
	 * 
	 * @param panel
	 *            Given panel to handle a drag event for.
	 * @param l
	 *            The given LevelPanel for which the drag will take place in.
	 */
	public DragCtrl(PieceView panel, JPanel l) {
		this.l = l;
		pv = panel;
		p = pv.getPiece();
	}

	public void mouseClicked(MouseEvent me) {

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
	/**
	 * On mouse press, a piece will be picked up from the bullpen. If a piece is already
	 * currently being dragged, then mouse press will not do anything. 
	 * @param me MouseEvent.
	 */
	public void mousePressed(MouseEvent me) {
		// checks that it is a left mouse press,if not do nothing
		if (SwingUtilities.isRightMouseButton(me))
			return; 

		// get the bullpen and container
		if (l instanceof LevelPanel) {
			// get the bullpenview
			bullpen = ((LevelPanel) l).getBullpenView();
			// get container
			container = ((LevelPanel) l).getPieceContainer(); 
		} else {
			// get the bullpenview
			bullpen = ((BuilderLevel) l).getBullpenView();
			// get container
			container = ((BuilderLevel) l).getPieceContainer();
		}

		if (!container.isVisible()) {// nothing is being dragged currently
			// get the component that was clicked on within the panel
			Component c = pv.getComponentAt(me.getPoint());

			// check if the component is a tile view
			if (c instanceof TileView) {
				// cast to TileView and get the represented tile
				tv = (TileView) c;
				t = tv.getTile();

				// ensures that drag is only initiated when player click on
				// piece and not its container
				if (t != null && !t.toString().equals(TileType.noTile)) {
					// set the tile that was clicked on to be the anchor for
					// this drag
					container.setAnchortile(tv);
					// set the source
					container.setSource(bullpen);

					// get the position on the mouse on the level panel
					Point point = l.getMousePosition();

					// Some crazy math to calculate the offest, but it works.
					// width of a tile in the container
					int cw = container.getWidth() / 6;
					// height of a tile in the container
					int ch = container.getHeight() / 6;
					// calculate offset to have mouse hoover over the anchor
					// tile
					int dx = cw * ((PieceTile) tv.getTile()).getPieceGridCol() + cw / 2;
					int dy = ch * ((PieceTile) tv.getTile()).getPieceGridRow() + ch / 2;
					// account for offest
					point.translate(-dx, -dy);
					// set location
					point.setLocation(point);

					container.setDraggingPiece(p);
					container.setLocation(point);

					// container is visible when being used(there might be a
					// better way to do this)
					container.setVisible(true);

					// update quantity of piece
					Bullpen bp = bullpen.getBullpen();
					bullpen.removePiece(pv);
				}
			} else {// another piece is currently being dragged, release it
					// first
					// get the piece being dragged
				Bullpen bp;
				// added it back to the bullpen by updating pieces quantity
				
				if (l instanceof LevelPanel) {
					bp = ((LevelPanel) l).getBullpenView().getBullpen();
				} else {
					bp = ((BuilderLevel) l).getBullpenView().getBullpen();
				}

				//if(container.getDraggingPiece().getPiece() != null)
					//bp.addPiece(container.getDraggingPiece().getPiece());
				container.setVisible(false);
			}
		}

		pv.setRepaintValid();
		bullpen.setRepaintValid();
		container.repaint();

	}

	@Override
	/**
	 * On mouse release, the bullpen and container are repainted.
	 * @param e MouseEvent
	 */
	public void mouseReleased(MouseEvent e) {
		if (l instanceof LevelPanel) {
			// get the bullpenview
			bullpen = ((LevelPanel) l).getBullpenView();
			// get container
			container = ((LevelPanel) l).getPieceContainer();
		} else {
			// get the bullpenview
			bullpen = ((BuilderLevel) l).getBullpenView();
			// get container
			container = ((BuilderLevel) l).getPieceContainer();
		}
		container.repaint();
	}
}
