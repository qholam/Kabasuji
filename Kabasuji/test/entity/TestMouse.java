package entity;

import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import junit.framework.TestCase;

/** 
 * The TestMouse class uses code from Heineman KSTestCase.
 * @author Calvin
 *
 */
public abstract class TestMouse extends TestCase{
	
	/** (dx,dy) are offsets into the widget space. Feel Free to Use as Is. */
	public MouseEvent createClicked (JComponent source, int dx, int dy) {
		MouseEvent me = new MouseEvent(source, MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				dx, dy, 1, false);
		return me;
	}
	
	/** (dx,dy) are offsets into the widget space. Feel Free to Use as Is. */
	public MouseEvent createPressed (JComponent source, int dx, int dy) {
		MouseEvent me = new MouseEvent(source, MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				dx, dy, 0, false);
		return me;
	}
	
	/** (dx,dy) are offsets into the widget space. Feel Free to Use as Is. */
	public MouseEvent createReleased (JComponent source, int dx, int dy) {
		MouseEvent me = new MouseEvent(source, MouseEvent.MOUSE_RELEASED, 
				System.currentTimeMillis(), 0, 
				source.getX()+dx, source.getY()+dy, 0, false);
		return me;
	}
	
	/** (dx,dy) are offsets into the widget space. Feel Free to Use as Is. */
	public MouseEvent createRightClick (JComponent source, int dx, int dy) {
		MouseEvent me = new MouseEvent(source, MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				dx, dy, 0, true);
		return me;
	}

	/** (dx,dy) are offsets into the widget space. Feel Free to Use as Is. */
	public MouseEvent createDoubleClicked (JComponent source, int dx, int dy) {
		MouseEvent me = new MouseEvent(source, MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				dx, dy, 2, false);
		return me;
	}
	
	/**
	 * Creates a mouse move.
	 * @param source
	 * @param dx
	 * @param dy
	 * @return
	 */
	public MouseEvent mouseMoved(JComponent source, int dx, int dy) {
		MouseEvent me = new MouseEvent(source, MouseEvent.MOUSE_MOVED, 
				System.currentTimeMillis(), 0, 
				dx, dy, 0, false);
		return me;
	}
}
