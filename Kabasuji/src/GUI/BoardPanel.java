package GUI;

import javax.swing.JPanel;

import entity.Board;
import entity.Bullpen;
import entity.Piece;
import entity.Tile;
import entity.TileType;
import view.PieceView;
import view.TileView;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;

public class BoardPanel extends JPanel {
	//Board that this panel represents
	Board board;
	//Tiles vies on the board
	TileView[][] tileViews;
	/**
	 * Create the panel.
	 */
	public BoardPanel(Board b) {
		board = b;
		tileViews = new TileView[b.getNumRows()][b.getNumColumns()];
		
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 600, 300);
		setBackground(new Color(255, 165, 0)); 
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(b.getNumRows(), b.getNumColumns(), 0, 0));
		panel.setBounds(10, 10, 580, 280);
		//panel.setBounds(10, 10, 28*b.getNumColumns(), 28*b.getNumRows());
		
		for (int r = 0; r < b.getNumRows(); r++) {
			for (int c = 0; c < b.getNumRows(); c++) {
				tileViews[r][c] = new TileView(b.getGrid()[r][c]);
				panel.add(tileViews[r][c]);
			}
		}
		setOpaque(true);
	}
	
	public Board getBoard(){
		return board;
	}
	
	public TileView[][] getTileViews(){
		return tileViews;
	}
	
	/**
	 * this is needed to prevent flickering when dragging inside the board.
	 * TODO: find another way to prevent this flickering
	 */
	public void setRepaintInvalid(){
		for (int r = 0; r < board.getNumRows(); r++) {
			for (int c = 0; c < board.getNumRows(); c++) {
				tileViews[r][c].setRepaintInvalid();
			}
		}
	}
	
	/**
	 * this is needed to prevent flickering when dragging inside the board.
	 * TODO: find another way to prevent this flickering
	 */
	public void setRepaintValid(){
		for (int r = 0; r < board.getNumRows(); r++) {
			for (int c = 0; c < board.getNumRows(); c++) {
				tileViews[r][c].setRepaintValid();
			}
		}
	}
}