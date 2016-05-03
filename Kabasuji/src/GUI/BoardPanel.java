package GUI;

import javax.swing.JPanel;

import entity.Board;
import entity.BoardTile;
import entity.Bullpen;
import entity.LevelType;
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
	
	Boolean repaint = true;
	
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
		boardTilePanel.setOpaque(false);
		boardTilePanel.setLayout(new GridLayout(b.getNumRows(), b.getNumColumns(), 0, 0));
		boardTilePanel.setBounds(10, 10, b.getNumColumns() * KabasujiFrame.tileWidth, b.getNumRows() * KabasujiFrame.tileHeight);
		add(boardTilePanel);
		//panel.setBounds(10, 10, 28*b.getNumColumns(), 28*b.getNumRows());
		
		for (int r = 0; r < b.getNumRows(); r++) {
			for (int c = 0; c < b.getNumColumns(); c++) {
				tileViews[c][r] = new TileView(b.getGrid()[c][r]);
				tileViews[c][r].setSize(getPreferredSize());
				tileViews[c][r].setLocation(KabasujiFrame.tileWidth * c, KabasujiFrame.tileHeight * r);
				boardTilePanel.add(tileViews[c][r]);
				boardTilePanel.validate();
			}
		}
		setOpaque(true);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for (int r = 0; r < board.getNumRows(); r++) {
			for (int c = 0; c < board.getNumColumns(); c++) {
				//no tile?
				if(board.getGrid()[c][r].toString().equals(TileType.noTile)){
					tileViews[c][r].setTile(new NoTile(r,c));
					tileViews[c][r].setOpaque(false);
				}
				else if(board.getGrid()[c][r].isCovered()){//covered tile?
					PieceTile p = new PieceTile();
					p.setCol(c);
					p.setRow(r);
					p.setColor(board.getGrid()[c][r].getColor());
					tileViews[c][r].setTile(p);
					if(!board.getLevel().getLevelType().equals(LevelType.Puzzle)){
						tileViews[c][r].setBackground(Color.GREEN);
					}
				}
				else{
					tileViews[c][r].setTile(board.getGrid()[c][r]);
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
	
	public void repaint(){
		if(repaint != null && repaint){
			super.repaint();
			repaint = false;
		}
	}
	
	/**
	 * this is needed to prevent flickering when dragging inside the board.
	 * TODO: find another way to prevent this flickering
	 */
	/**public void setRepaintInvalid(){
		repaint = false;
		for (int r = 0; r < board.getNumRows(); r++) {
			for (int c = 0; c < board.getNumRows(); c++) {
				tileViews[c][r].setRepaintInvalid();
			}
		}
	}*/
	
	/**
	 * this is needed to prevent flickering when dragging inside the board.
	 * TODO: find another way to prevent this flickering
	 */
	public void setRepaintValid(){
		repaint = true;
		repaint();
		
		for (int r = 0; r < board.getNumRows(); r++) {
			for (int c = 0; c < board.getNumColumns(); c++) {
				tileViews[c][r].setRepaintValid();
			}
		}
	}
	
	public JPanel getBoardTilePanel(){
		return boardTilePanel;
	}
	
	/**
	 * Get the tile view at the specified mouse event
	 * @param me
	 */
	public TileView getClickedTile(MouseEvent me){
		TileView t = null;
		//get the component that was clicked on
		Component c = boardTilePanel.getComponentAt(me.getPoint());
		
		//System.out.println(boardTilePanel.getComponent(5));
		if(c instanceof TileView){
			t = (TileView) c;
		}
		
		
		return t;
	}
	
	public void clearBoard(){
		for(int i=0; i<board.pieces.size(); i++){
			board.pieces.remove(i);
		}
		setRepaintValid();
	}
}