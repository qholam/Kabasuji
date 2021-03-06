package entity;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import GUI.BoardPanel;
import GUI.BuilderLevelSelector;
import GUI.BuilderLightningLevel;
import GUI.BuilderReleaseLevel;
import GUI.BullpenView;
import GUI.KabasujiBuilderFrame;
import GUI.KabasujiFrame;
import GUI.LevelPanel;
import GUI.LevelSelector;
import GUI.SpecifyBoardPropertiesView;
import junit.framework.TestCase;
import view.PieceView;

/**
 * Extra Test Cases.
 * @author LilyAnne
 *
 */
public class TestGUI extends TestCase
{
	Bullpen pen;
	Piece piece1;
	Piece piece2;
	Piece piece3;
	BullpenView b;
	PieceView pv, pv1, vcw, vccw, vv, vh;

	
	
	KabasujiFrame frame;
	KabasujiBuilderFrame bFrame;
	Board board;
	Level l;
	LevelPanel lp;
	SpecifyBoardPropertiesView sbpv;
	LevelSelector ls;
	BuilderLightningLevel bll;
	BoardPanel bp;
	BuilderLevelSelector blc;

	public void setUp()
	{
		pen = new Bullpen();
		piece1 = new Piece();
		piece1.addTile(new PieceTile(), 0, 2); 
		piece1.addTile(new PieceTile(), 1, 2); 
		piece1.addTile(new PieceTile(), 2, 2);
		piece1.addTile(new PieceTile(), 3, 2);
		piece1.addTile(new PieceTile(), 4, 2);
		piece1.addTile(new PieceTile(), 3, 1);
		piece1.addTile(new PieceTile(), 3, 3);
		
		piece2 = new Piece();
		piece2.addTile(new PieceTile(), 0, 3);
		piece2.addTile(new PieceTile(), 1, 3);
		piece2.addTile(new PieceTile(), 2, 3);
		piece2.addTile(new PieceTile(), 3, 3);
		piece2.addTile(new PieceTile(), 4, 3);
		piece2.addTile(new PieceTile(), 3, 2);
		piece2.addTile(new PieceTile(), 3, 4);
		
		piece3 = new Piece();
		piece3.addTile(new PieceTile(), 1, 2);
		piece3.addTile(new PieceTile(), 2, 2);
		piece3.addTile(new PieceTile(), 3, 2);
		piece3.addTile(new PieceTile(), 2, 1);
		piece3.addTile(new PieceTile(), 2, 3);
		piece3.addTile(new PieceTile(), 2, 4);
		piece3.addTile(new PieceTile(), 2, 5);
		
		
		b = new BullpenView(pen, lp);
		frame = new KabasujiFrame();
		bFrame = new KabasujiBuilderFrame();
		
		
		bFrame.levelType = LevelType.Puzzle;
		board = new Board(l, 12, 12);
		l = new Level(board, pen, true, 1, 0);
		
		
		
	}
	
	public void testBuilderLevelSelector()
	{
		blc = new BuilderLevelSelector(bFrame);
		Component c = blc.getComponentAt(330, 201);
		assertTrue(c instanceof JButton);
	}
	
	public void testBoard()
	{
		board.addPiece(piece1, 3, 3);
		assertTrue(board.boardGrid[5][3].isCovered());
		
		board.removePiece(piece1);
		assertFalse(board.boardGrid[5][3].isCovered());
		
		board.addPiece(piece1, 3, 3);
		assertTrue(board.boardGrid[5][3].isCovered());

	}
	
	/**
	 * Checks that correct number of Pieces added to the Bullpen is correct
	 */
	public void testNumPieces()
	{
		int totalOfSamePiece = 0;
		pen.addPiece(piece1);
		totalOfSamePiece = pen.getQuantity(piece1);
		assertEquals(totalOfSamePiece, 1);
		pen.addPiece(piece2, 3);
		totalOfSamePiece = pen.getQuantity(piece2);
		assertEquals(totalOfSamePiece, 3);
		
		b.setSelected(pv1);
		assertEquals(b.getSelected(), pv1);
	}
	
	public void testSpecifyBoardPropertiesView()
	{

		sbpv = new SpecifyBoardPropertiesView(bFrame);
		Component c1 = sbpv.getComponentAt(237, 236);
		assertTrue(c1 instanceof JTextField);
		
		Component c2 = sbpv.getComponentAt(237, 274);
		assertTrue(c2 instanceof JTextField);
		((JTextField) c1).setText("6");
		((JTextField) c2).setText("6");
		
		//sbpv.updateBoard();
		
		
	}
	
	public void testLevelSelector()
	{
		ls = new LevelSelector(frame);
		Component c = ls.getComponentAt(130, 210);
		Color color = new Color(255, 165, 0);
		Color buttonColor = c.getForeground();
		
		assertTrue(c instanceof JButton);
		assertEquals(buttonColor, color);
		
		Component c2 = ls.getComponentAt(7, 1);
		
		assertTrue(c2 instanceof JLabel);
	}

	public void testLightningLevel()
	{
		bll = new BuilderLightningLevel(bFrame);
		Component c = bll.getComponentAt(655, 605);
		assertTrue(c instanceof JButton);
	}

}
