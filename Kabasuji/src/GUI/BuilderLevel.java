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
	 * Create the panel. Holds the stacks for undo and redo.
	 */
	public BuilderLevel() {
		moves = new Stack<IMove>();
		redo = new Stack<IMove>();
	}
	
	void setBoard(Board b) {
		
	}
	
	/**
	 * Get the {@link IMove} that is on the top of the undo stack.
	 * @return The most recently done move.
	 */
	public IMove popMove(){
		return moves.pop();
	}
	
	/**
	 * Add an {@link IMove} onto the redo stack.
	 * @param move
	 */
	public void pushMove(IMove move){
		moves.push(move);
	}
	
	/**
	 * Get the {@link IMove} that is on the top of the redo stack.
	 * @return The most recently undone move.
	 */
	public IMove popRedo(){
		return redo.pop();
	}
	
	/**
	 * Add an {@link IMove} onto the redo stack.
	 * @param move
	 */
	public void pushRedo(IMove move){
		redo.push(move);
	}

	public abstract BullpenView getBullpenView();

	public abstract  PieceContainer getPieceContainer();

	public abstract BoardPanel getBoardPanel();

	/**
	 * Get the level that this view represents.
	 * @return The represented Level.
	 */
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
