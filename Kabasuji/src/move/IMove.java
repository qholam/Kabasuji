package move;

import entity.KabasujiGame;

/**
 * 
 * @author Richard Hayes
 * An interface for all of the move classes to implement.
 * 
 */
public interface IMove {
	
	public boolean undo();
	boolean doMove();
	boolean isValid();

}
