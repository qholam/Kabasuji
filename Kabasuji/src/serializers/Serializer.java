package serializers;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import entity.Board;
import entity.Bullpen;
import entity.Level;
import entity.Piece;
import entity.PieceTile;
import entity.PuzzleLevel;
/**
 * Writes state of object into a stream of bytes
 * @author Quoc HoLam
 *
 */
public class Serializer {
		/**
		 * Saves a {@link Level} to text file.
		 * @param l Level to be saved.
		 */
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
