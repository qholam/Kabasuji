package entity;

import java.awt.Color;
import java.awt.event.MouseEvent;

import GUI.BullpenView;
import junit.framework.TestCase;
import move.IMove;

public class LilyAnneTest extends TestCase 
{
	Bullpen pen;
	Piece piece1;
	Piece piece2;
	Piece piece3;
	BullpenView b;
	
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
	}
	
	public void testPiecesInPen()
	{
		pen.addPiece(piece1);
		
		pen.addPiece(piece2);
		
		pen.addPiece(piece3);
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
	}
	
	public void testDragPiece()
	{

	}
	
	public void testFlipPiece()
	{
		
	}
	
	public void testRotatePiece()
	{
	}
}
