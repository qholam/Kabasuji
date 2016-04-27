package GUI;

import javax.swing.JPanel;

import entity.Board;
import entity.Bullpen;
import entity.Piece;
import entity.PieceTile;
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
	
	JPanel boardTilePanel;
	/**
	 * Create the panel.
	 */
	public BoardPanel(Board b) { 
		board = b;
		tileViews = new TileView[b.getNumColumns()][b.getNumRows()];
		
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 600, 300);
		setBackground(new Color(255, 165, 0));  
		
		boardTilePanel = new JPanel();
		add(boardTilePanel);
		boardTilePanel.setLayout(new GridLayout(b.getNumRows(), b.getNumColumns(), 0, 0));
		boardTilePanel.setBounds(10, 10, 580, 280);
		//panel.setBounds(10, 10, 28*b.getNumColumns(), 28*b.getNumRows());
		
		for (int r = 0; r < b.getNumRows(); r++) {
			for (int c = 0; c < b.getNumColumns(); c++) {
				tileViews[c][r] = new TileView(b.getGrid()[c][r]);
				boardTilePanel.add(tileViews[c][r]);
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
	
	public JPanel getBoardTilePanel(){
		return boardTilePanel;
	}
}