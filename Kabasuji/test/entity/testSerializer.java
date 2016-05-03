package entity;

import junit.framework.TestCase;
import serializers.Deserializer;
import serializers.Serializer;

public class testSerializer extends TestCase {
/**
	Serializer s;
	Deserializer ds;
	public void testSerializer(){
		PuzzleLevel puz = new PuzzleLevel(20, null, null, true, 1, 0);
		Board board = new Board(puz, 10, 10);
		Bullpen b = new Bullpen();
		for(int i = 0; i < 6; i++){
			Piece p = new Piece(); 
			p.addTile(new PieceTile(), 0, 2); 
			p.addTile(new PieceTile(), 1, 2); 
			p.addTile(new PieceTile(), 2, 2);
			p.addTile(new PieceTile(), 3, 2); 
			p.addTile(new PieceTile(), 4, 2);
			p.addTile(new PieceTile(), 5, 2);
			p.addTile(new PieceTile(), 5-i, 1);
			p.addTile(new PieceTile(), 5-i, 3); 
			b.addPiece(p);
		}
		puz = new PuzzleLevel(50, board, b, true, 1, 0);
		s = new Serializer();
		s.serializeLevel(puz);
		
		String[] string = new String[3];
		string[0] = "a";
		string[1] = "b";
		string[2] = "c";
		
		Serializer.main(string);
	}
	
	public void testDeserializer(){
		ds = new Deserializer();
		ReleaseLevel rl;
		PuzzleLevel pl;
		LightningLevel ll;
		
		rl = ds.deserialzeReleaseLevel(1);
		pl = ds.deserialzePuzzleLevel(1);
		ll = ds.deserialzeLightningLevel(1);
		
		//assertTrue(rl != null);
		//assertTrue(pl != null);
		//assertTrue(ll != null);
	}
	**/
}

