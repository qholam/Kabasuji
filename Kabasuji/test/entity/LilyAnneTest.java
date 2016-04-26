package entity;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;

import GUI.BullpenView;
import GUI.KabasujiFrame;
import GUI.LevelPanel;
import GUI.LevelSelector;
import junit.framework.TestCase;
import move.IMove;
import view.PieceView;

public class LilyAnneTest extends TestCase 
{
	Bullpen pen;
	Piece piece1;
	Piece piece2;
	Piece piece3;
	BullpenView b;
	PieceView pv, pv1, vcw, vccw, vv, vh;
	LevelPanel level;
	KabasujiFrame frame;
	Level l;
	Board board;
	
	LevelSelector ls;

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
		
		
		b = new BullpenView(pen);
		frame = new KabasujiFrame();
		
		
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
	
	public void testLevelPanel()
	{
		//l = new Level(board, pen, true, 1, 0);		
		//level = new LevelPanel(frame, l);
		//board = new Board(l, 6, 6);
		
	}
	
	public void testLevelSelector()
	{
		//ls = new LevelSelector(frame);
	}

}
