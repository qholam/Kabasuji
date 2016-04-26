package entity;

import java.awt.Color;

import junit.framework.TestCase;

public class LilyAnneTest extends TestCase 
{
	Bullpen pen;
	Piece piece1;
	Piece piece2;
	Piece piece3;
	
	public void setUp()
	{
		pen = new Bullpen();
		piece1 = new Piece();
		piece2 = new Piece();
		piece3 = new Piece();
		
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
}
