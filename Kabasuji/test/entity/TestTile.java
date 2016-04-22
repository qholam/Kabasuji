package entity;

import java.awt.Color;

import junit.framework.TestCase;

public class TestTile extends TestCase{
	BoardTile b1;
	BoardTile b2;
	NoTile n1;
	NoTile n2;
	PieceTile p;
	LightningTile l;
	ReleaseTile r;
	
	public void setUp(){
		b1 = new BoardTile(0,0);
		b2 = new BoardTile(0,0);
		n1 = new NoTile(0,0);
		n2 = new NoTile(0,1);
		p = new PieceTile(0,0);
		l = new LightningTile(0,0);
		r = new ReleaseTile(0,0, new Number(1, Color.RED));
	}
	
	/**
	 * Test toString() method of each subclass of {@link Tile}
	 */
	public void testToString(){
		assertEquals(b1.toString(), "b");
		assertEquals(n1.toString(), "n");
		assertEquals(p.toString(), "p");
		assertEquals(l.toString(), "l");
		assertEquals(r.toString(), "r");
	}
	
	/**
	 * Test equals() of the subclasses of {@link Tile}
	 */
	public void testEquals(){
		//two board tiles with same (row,col) should be equal
		assertTrue(b1.equals(b2));
		//two tiles of different types are not equal
		assertFalse(b1.equals(l));
		//tiles are not equal if they have same type, but not same (row,col)
		assertFalse(n1.equals(n2));
	}
	
	/**
	 * Test method to get the color of the subclasses of {@link Tile}
	 */
	public void testColor(){
		assertEquals(b1.getColor(), Color.LIGHT_GRAY);
		assertEquals(l.getColor(), Color.LIGHT_GRAY);
		assertEquals(r.getColor(), Color.LIGHT_GRAY);
		assertEquals(p.getColor(), Color.ORANGE);
		assertEquals(n1.getColor(), Color.WHITE);
	}
}
