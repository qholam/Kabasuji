package move;

import entity.KabasujiGame;

public interface IMove {
	
	public boolean undo();
	boolean doMove();
	boolean isValid();

}
