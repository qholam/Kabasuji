package GUI;

import javax.swing.JPanel;

import entity.Board;
import entity.BoardTile;
import entity.Bullpen;
import entity.NoTile;
import entity.Piece;
import entity.PieceTile;
import entity.Tile;
import entity.TileType;
import view.PieceView;
import view.TileView;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
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
		setBounds(0, 0, 308, 308);
		setBackground(new Color(255, 165, 0));   
		
		boardTilePanel = new JPanel();
		add(boardTilePanel);
		boardTilePanel.setLayout(new GridLayout(b.getNumRows(), b.getNumColumns(), 0, 0));
		boardTilePanel.setBounds(10, 10, 288, 288);
		boardTilePanel.setVisible(false);
		//panel.setBounds(10, 10, 28*b.getNumColumns(), 28*b.getNumRows());
		
		/* RICHARDCHANGE comment these loops out */
		for (int r = 0; r < b.getNumRows(); r++) {
			for (int c = 0; c < b.getNumColumns(); c++) {
				tileViews[c][r] = new TileView(b.getGrid()[c][r]);
				tileViews[c][r].setVisible(false);
				boardTilePanel.add(tileViews[c][r]);
			}
		} 
		setOpaque(true);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		/*
		for (int r = 0; r < board.getNumRows(); r++) {
			for (int c = 0; c < board.getNumColumns(); c++) {
				if(board.getGrid()[c][r].isCovered()){
					PieceTile p = new PieceTile();
					p.setCol(c);
					p.setRow(r);
					tileViews[c][r].setTile(p);
				}
				else{
					tileViews[c][r].setTile(board.getGrid()[c][r]);
				}
			}
		}*/
		
		/* RICHARDCHANGE uncomment these */
		for (int i = 0; i < board.getNumRows(); i++) {
			for (int j = 0; j < board.getNumColumns(); j++) {
				if (board.getGrid()[j][i] instanceof BoardTile) {
					g.setColor(Color.lightGray);
					g.fillRect(boardTilePanel.getX() + 24 * j, boardTilePanel.getY() + 24 * i, 24, 24);
					g.setColor(Color.black);
					g.drawRect(boardTilePanel.getX() + 24 * j, boardTilePanel.getY() + 24 * i, 24, 24);
				} else if (board.getGrid()[j][i] != null) {
					g.setColor(Color.orange);
					g.fillRect(boardTilePanel.getX() + 24 * j, boardTilePanel.getY() + 24 * i, 24, 24);
					g.setColor(Color.black);
					g.drawRect(boardTilePanel.getX() + 24 * j, boardTilePanel.getY() + 24 * i, 24, 24);
				}
			}
		}
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