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
	//Tile tile1;
	//Tile tile2;
	Number number;
	ReleaseTile releaseTile;
	PieceTile pieceTile;
	PieceTile pieceTile1;
	Piece piece, piece1, piece2, piece3, piece4;
	boolean[][] pieceArray;
	ArrayList<PieceTile> pieceTileArray;
	
	public void setUp() throws Exception{
		tileType = new TileType();
		//tile1 = new Tile(5, 2);
		//tile2 = new Tile(5, 2);
		number = new Number(2, Color.red);
		releaseTile = new ReleaseTile(5, 2, number);
		pieceTile = new PieceTile();
		pieceTile1 = new PieceTile(10, 20);
		piece = new Piece();
		piece1 = new Piece(piece);
		pieceArray = new boolean[6][6];
		piece2 = new Piece(pieceArray);
		piece3 = new Piece(piece2);
		
		/**
		piece4 = new Piece();
		piece4.pieceTiles.add(pieceTile);
		pieceTileArray = new ArrayList<PieceTile>();
		pieceTileArray.add(pieceTile);
		**/
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
		//assertEquals(piece4.getPieceTiles(), pieceTileArray);
	}
	
	public void testNumber(){
		assertEquals(number.getNum(), 2);
		assertEquals(number.getColor(), Color.red);
	}
	
	
}
