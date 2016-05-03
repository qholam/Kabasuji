package GUI;

import java.util.Stack;

import javax.swing.JPanel;

import entity.Board;
import entity.Level;
import move.IMove;
import view.TileView;

public abstract class BuilderLevel extends JPanel {
	Stack<IMove> moves;
	Stack<IMove> redo;
	
	/**
	 * Create the panel.
	 */
	public BuilderLevel() {
		moves = new Stack<IMove>();
		redo = new Stack<IMove>();
	}
	
	void setBoard(Board b) {
		
	}
	
	public IMove popMove(){
		return moves.pop();
	}
	
	public void pushMove(IMove move){
		moves.push(move);
	}
	
	public IMove popRedo(){
		return redo.pop();
	}
	
	public void pushRedo(IMove move){
		redo.push(move);
	}

	public abstract BullpenView getBullpenView();

	public abstract  PieceContainer getPieceContainer();

	public abstract BoardPanel getBoardPanel();

	public Level getLevel() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Updates status of a level.
	 */
	public void updateLevel() {
		// TODO Auto-generated method stub
		
	}

}
