package serializers;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import entity.Level;

public class Deserializer {
	   public Level deserialzeLevel(){
		   
		   Level level;
		 
		   try{
			    
			   FileInputStream fin = new FileInputStream();
			   ObjectInputStream ois = new ObjectInputStream(fin);
			   level = (Level) ois.readObject();
			   ois.close();
			  
			   return level;
			   
		   }catch(Exception ex){
			   ex.printStackTrace();
			   return null;
		   } 
	   } 
}
