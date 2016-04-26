package serializers;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import entity.Level;

public class Serializer {
	   public void serializeLevel(Level l){ 
		   try{
			   
			FileOutputStream fout = new FileOutputStream("src/nut/test2");
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			oos.writeObject(l);
			oos.close();
			System.out.println("Done");
			   
		   }catch(Exception ex){
			   ex.printStackTrace();
		   }
	   }
}
