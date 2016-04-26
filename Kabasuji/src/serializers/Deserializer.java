package serializers;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import entity.Level;
import entity.LightningLevel;
import entity.PuzzleLevel;
import entity.ReleaseLevel;

public class Deserializer {
	   public ReleaseLevel deserialzeReleaseLevel(int index){
		   
		   ReleaseLevel level;
		 
		   try{
			    
			   FileInputStream fin = new FileInputStream("src/savedLevels/Release"+index);
			   ObjectInputStream ois = new ObjectInputStream(fin);
			   level = (ReleaseLevel) ois.readObject();
			   ois.close();
			  
			   return level;
			   
		   }catch(Exception ex){
			   ex.printStackTrace();
			   return null;
		   } 
	   } 
	   
	   public LightningLevel deserialzeLightningLevel(int index){
		   
		   LightningLevel level;
		 
		   try{
			    
			   FileInputStream fin = new FileInputStream("src/savedLevels/Lightning"+index);
			   ObjectInputStream ois = new ObjectInputStream(fin);
			   level = (LightningLevel) ois.readObject();
			   ois.close();
			  
			   return level;
			   
		   }catch(Exception ex){
			   ex.printStackTrace();
			   return null;
		   } 
	   } 
	   
	   public PuzzleLevel deserialzePuzzleLevel(int index){
		   
		   PuzzleLevel level;
		 
		   try{
			    
			   FileInputStream fin = new FileInputStream("src/savedLevels/Puzzle"+index);
			   ObjectInputStream ois = new ObjectInputStream(fin);
			   level = (PuzzleLevel) ois.readObject();
			   ois.close();
			  
			   return level;
			   
		   }catch(Exception ex){
			   ex.printStackTrace();
			   return null;
		   } 
	   } 
}
