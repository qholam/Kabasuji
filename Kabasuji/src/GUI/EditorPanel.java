package GUI;

import javax.swing.JPanel;

import entity.Piece;
import view.PieceView;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

/**
 * @author Richard Hayes
 * Pannel to hold an infinite amount of all 35 Kabasuji Pieces in the Builder.
 */
public class EditorPanel extends JPanel {
	
	PieceView[] pieces = new PieceView[35];
	KabasujiBuilderFrame kFrame;

	/** Default constructor for an EditorPanel. */
	public EditorPanel(KabasujiBuilderFrame frame) {
		setLayout(new GridLayout(18, 18, 24, 0));
		kFrame = frame;
		
		for (int i = 0; i < kFrame.pieces.length; i++) {
			pieces[i] = new PieceView(kFrame.pieces[i]);
			add(pieces[i]);
			setPreferredSize(new Dimension(100, 100 * getComponents().length));
		}
	}

}
