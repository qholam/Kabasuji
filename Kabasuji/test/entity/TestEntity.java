package entity;

import java.awt.Color;
import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * This class will tests general methods from the entity classes.
 * @author Calvin
 */
public class TestEntity extends TestCase {

	TileType tileType;
	Bullpen bullpen;
	Number number;
	ReleaseTile releaseTile;
	PieceTile pieceTile;
	PieceTile pieceTile1;
	Piece piece, piece1, piece2, piece3, piece4, pieces1, pieces2, pieces3;
	boolean[][] pieceArray;
	ArrayList<PieceTile> pieceTileArray;
	ArrayList<Piece> BullpenArray;
	
	public void setUp() throws Exception{
		tileType = new TileType();
		number = new Number(2, Color.red);
		releaseTile = new ReleaseTile(5, 2, number);
		pieceTile = new PieceTile();
		pieceTile1 = new PieceTile(10, 20);
		piece = new Piece();
		piece1 = new Piece(piece);
		pieceArray = new boolean[6][6];
		piece2 = new Piece(pieceArray);
		piece3 = new Piece(piece2);
		
		BullpenArray = new ArrayList<Piece>();
		bullpen = new Bullpen();
		
		pieces1 = new Piece();
		pieces1.addTile(new PieceTile(), 0, 2); 
		pieces1.addTile(new PieceTile(), 1, 2); 
		pieces1.addTile(new PieceTile(), 2, 2);
		pieces1.addTile(new PieceTile(), 3, 2);
		pieces1.addTile(new PieceTile(), 4, 2);
		pieces1.addTile(new PieceTile(), 3, 1);
		pieces1.addTile(new PieceTile(), 3, 3);
		
		pieces2 = new Piece();
		pieces2.addTile(new PieceTile(), 0, 3);
		pieces2.addTile(new PieceTile(), 1, 3);
		pieces2.addTile(new PieceTile(), 2, 3);
		pieces2.addTile(new PieceTile(), 3, 3);
		pieces2.addTile(new PieceTile(), 4, 3);
		pieces2.addTile(new PieceTile(), 3, 2);
		pieces2.addTile(new PieceTile(), 3, 4);
		
		pieces3 = new Piece();
		pieces3.addTile(new PieceTile(), 1, 2);
		pieces3.addTile(new PieceTile(), 2, 2);
		pieces3.addTile(new PieceTile(), 3, 2);
		pieces3.addTile(new PieceTile(), 2, 1);
		pieces3.addTile(new PieceTile(), 2, 3);
		pieces3.addTile(new PieceTile(), 2, 4);
		pieces3.addTile(new PieceTile(), 2, 5);	
		
	}
	
	/**
	 * Tests the TileTypes.
	 */
	public void testTileType(){
		assertEquals(tileType.lightningTile, "l");
		assertEquals(tileType.boardTile, "b");
		assertEquals(tileType.noTile, "n");
		assertEquals(tileType.releaseTile, "r");
		assertEquals(tileType.pieceTile, "p");
	}
	
	public void testTile(){
		
	}
	
	/**
	 * Tests the Release Tile.
	 */
	public void testReleaseTile(){
		assertEquals(releaseTile.getNumber(), number);
		assertEquals(releaseTile.toString(), tileType.releaseTile);
	}
	
	/**
	 * Tests the Piece Tile.
	 */
	public void testPieceTile(){
		assertEquals(pieceTile.getPieceGridCol(), -1);
		assertEquals(pieceTile.getPieceGridRow(), -1);
		pieceTile.setPieceGridCol(5);
		pieceTile.setPieceGridRow(7);
		assertEquals(pieceTile.getPieceGridCol(), 5);
		assertEquals(pieceTile.getPieceGridRow(), 7);
		assertEquals(pieceTile1.getPieceGridCol(), -1);
		assertEquals(pieceTile1.getPieceGridRow(), -1);
		assertEquals(pieceTile.toString(), tileType.pieceTile);
	}
	
	public void testPiece(){
		assertEquals(piece, piece1);
		assertEquals(piece2, piece3);
		piece1.setRowPos(30);
		assertEquals(piece1.getRowPos(), 30);
		piece1.setColPos(20);
		assertEquals(piece1.getColPos(), 20);
	}
	
	public void testNumber(){
		assertEquals(number.getNum(), 2);
		assertEquals(number.getColor(), Color.red);
	}
	
	public void testBullpen(){
		Bullpen bullpen1;
		Piece selected;
		BullpenArray.add(pieces1);
		BullpenArray.add(pieces2);
		BullpenArray.add(pieces3);
		
		bullpen.addPiece(pieces1);
		bullpen.addPiece(pieces2);
		bullpen.addPiece(pieces3);
		
		assertEquals(bullpen.getPieces(), BullpenArray);
		
		bullpen1 = new Bullpen(bullpen.getPieces());
		assertEquals(bullpen1.getPieces(), BullpenArray);
		
		bullpen.setSelectedPiece(pieces1);
		selected = bullpen.getSelectedPiece();
		
		assertEquals(selected, pieces1);
		assertEquals(bullpen.getNumPieces(), 3);
		//bullpen.changeQuantity(pieces1, -1);
		//assertEquals(bullpen.getNumPieces(), 2);
		
	}

	
}
