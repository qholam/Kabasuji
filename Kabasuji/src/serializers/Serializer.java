package serializers;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import entity.Board;
import entity.Bullpen;
import entity.Level;
import entity.Piece;
import entity.PieceTile;
import entity.PuzzleLevel;

public class Serializer {
		//testing saving of the first level7
		public static void main(String[] args){
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
			Level l = (Level) new PuzzleLevel(20, new Board(null, 10, 10), b, true, 1, 0);
			new Serializer().serializeLevel(l);
			
		}
		
	
		public void serializeLevel(Level l){ 
		   try{  
			FileOutputStream fout = new FileOutputStream("src/savedLevels/" + l.toString());
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			oos.writeObject(l);
			oos.close();
			   
		   }catch(Exception ex){
			   ex.printStackTrace();
		   }
		}
}
