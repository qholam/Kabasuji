package entity;

import junit.framework.TestCase;

public class TestPiece extends TestCase{
	//Original piece
	Piece p, p1;
	//Original piece rotated clockwise
	Piece cw;
	//Original piece rotated counterclockwise
	Piece ccw;
	//Original piece flipped vertically
	Piece v;
	//Original piece flipped horizontally
	Piece h;
	
	public void setUp(){
		p = new Piece();
		p.addTile(new PieceTile(0,2));
		p.addTile(new PieceTile(1,2));
		p.addTile(new PieceTile(2,2));
		p.addTile(new PieceTile(3,2));
		p.addTile(new PieceTile(4,2));
		p.addTile(new PieceTile(3,1));
		p.addTile(new PieceTile(3,3));
		
		p1 = new Piece();
		p1.addTile(new PieceTile(0,2));
		p1.addTile(new PieceTile(1,2));
		p1.addTile(new PieceTile(2,2));
		p1.addTile(new PieceTile(3,2));
		p1.addTile(new PieceTile(4,2));
		p1.addTile(new PieceTile(3,1));
		p1.addTile(new PieceTile(3,3));
		
		cw = new Piece();
		cw.addTile(new PieceTile(1,2));
		cw.addTile(new PieceTile(2,2));
		cw.addTile(new PieceTile(3,2));
		cw.addTile(new PieceTile(2,1));
		cw.addTile(new PieceTile(2,3));
		cw.addTile(new PieceTile(2,4));
		cw.addTile(new PieceTile(2,5));
		
		ccw = new Piece();
		ccw.addTile(new PieceTile(2, 3));
		ccw.addTile(new PieceTile(3, 3));
		ccw.addTile(new PieceTile(4, 3));
		ccw.addTile(new PieceTile(3, 0));
		ccw.addTile(new PieceTile(3, 1));
		ccw.addTile(new PieceTile(3, 2));
		ccw.addTile(new PieceTile(3, 4));
		
		v = new Piece();
		v.addTile(new PieceTile(1,2));
		v.addTile(new PieceTile(2,2));
		v.addTile(new PieceTile(3,2));
		v.addTile(new PieceTile(4,2));
		v.addTile(new PieceTile(5,2));
		v.addTile(new PieceTile(2,1));
		v.addTile(new PieceTile(2,3));
		
		h = new Piece();
		h.addTile(new PieceTile(0,3));
		h.addTile(new PieceTile(1,3));
		h.addTile(new PieceTile(2,3));
		h.addTile(new PieceTile(3,3));
		h.addTile(new PieceTile(4,3));
		h.addTile(new PieceTile(3,2));
		h.addTile(new PieceTile(3,4));
	}
	/**
	 * Test equals method
	 */
	public void testEquals(){
		assertEquals(p, p1);
	}
	
	/**
	 * Test the method that rotates a {@link Piece} clockwise
	 */
	public void testClockwise(){
		p.rotateClockwise();
		assertEquals(cw, p);
	}
	
	/**
	 * Test the method that rotates a {@link Piece} counterclockwise
	 */
	public void testCounterClockwise(){
		p.rotateCounterclockwise();
		assertEquals(ccw, p);
	}
	
	/**
	 * Test the method that flips a {@link Piece} vertically
	 */
	public void testVertical(){
		//TODO
		p.verticalFlip();
		assertEquals(v, p);
	}
	
	/**
	 * Test the method that flips a {@link Piece} horizontally
	 */
	public void testHorizontal(){
		//TODO
		p.horizontalFlip();
		assertEquals(h, p);
	}
}
