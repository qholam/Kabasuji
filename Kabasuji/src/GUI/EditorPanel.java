package GUI;

import javax.swing.JPanel;

import controller.MouseMoveCtrl;
import entity.Piece;
import view.PieceView;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

/**
 * @author Richard Hayes
 * Pannel to hold an infinite amount of all 35 Kabasuji Pieces in the Builder.
 */
public class EditorPanel extends JPanel {
	
	Piece[] actualPieces = new Piece[35];
	PieceView[] pieces = new PieceView[35];
	KabasujiBuilderFrame kFrame;
	JPanel level;

	/** Default constructor for an EditorPanel. */
	public EditorPanel(KabasujiBuilderFrame frame, JPanel l) {
		setLayout(new GridLayout(18, 18, 24, 0));
		kFrame = frame;
		this.level=l;
		
		
		for (int i = 0; i < kFrame.pieces.length; i++) {
			pieces[i] = new PieceView(kFrame.pieces[i]);
			pieces[i].addMouseMotionListener(new MouseMoveCtrl(l));
			pieces[i].addMouseListener(new MouseMoveCtrl(l));
			JPanel p = new JPanel();
			p.add(pieces[i]);
			add(p);
			setPreferredSize(new Dimension(100, 100 * getComponents().length));
		}
	}
	
	//Nick added methods
	public Piece[] getPieces(){
		for(int i=0; i<pieces.length;i++){
			actualPieces[i]=pieces[i].getPiece();
		}
		return actualPieces;
	}
	
	public PieceView[]  getPieceViews(){
		return pieces;
	}

}
