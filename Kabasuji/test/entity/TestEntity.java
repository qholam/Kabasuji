package entity;

import java.awt.Color;

import junit.framework.TestCase;

/**
 * This class will tests general methods from the entity classes.
 * @author Calvin
 */
public class TestEntity extends TestCase {

	TileType tileType;
	//Tile tile1;
	//Tile tile2;
	Number number;
	ReleaseTile releaseTile;
	PieceTile pieceTile;
	PieceTile pieceTile1;
	Piece piece;
	Piece piece1;
	
	public void setUp(){
		tileType = new TileType();
		//tile1 = new Tile(5, 2);
		//tile2 = new Tile(5, 2);
		number = new Number(2, Color.red);
		releaseTile = new ReleaseTile(5, 2, number);
		pieceTile = new PieceTile();
		pieceTile1 = new PieceTile(10, 20);
		Piece piece = new Piece();
		Piece piece1 = new Piece(piece);
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
		
	}
	
}
