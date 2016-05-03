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

/**
 * The view for a {@link Board}
 * 
 *
 */
public class BoardPanel extends JPanel {
	//Board that this panel represents
	Board board;
	//Tiles vies on the board
	TileView[][] tileViews;
	
	JPanel boardTilePanel;
	
	//determines whether a board can repaint, this prevented some flickering
	//TODO: find a better way to do this
	Boolean repaint = true;
	
	/**
	 * Create the panel for the board.
	 * @param b Board that this panel will represent. 
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
	/**
	 * Repaints the board based on no tiles, pieces tiles, or release tiles being
	 * placed on a {@link Board}.
	 * @param g
	 */
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
	
	/**
	 * Returns the reprented board.
	 * @return The board represented by this panel.
	 */
	public Board getBoard(){
		return board;
	}
	
	/**
	 * Get the all the {@link TileView} on the board panel.
	 * @return TileViews on the board. 
	 */
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
	 * This will repaint the board once.
	 * TODO: find another way to prevent this flickering.
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
	
	/**
	 * Get the panel that holds all the {@link TileView}'s.
	 * @return JPanel that holds all the Tile Views.
	 */
	public JPanel getBoardTilePanel(){
		return boardTilePanel;
	}
	
	/**
	 * Get the tile view at the specified mouse event.
	 * @param me
	 */
	public TileView getClickedTile(MouseEvent me){
		TileView t = null;
		//get the component that was clicked on
		Component c = boardTilePanel.getComponentAt(me.getPoint());
		
		if(c instanceof TileView){
			t = (TileView) c;
		}
		
		
		return t;
	}
	
	/**
	 * Removes all pieces from the {@link Board}
	 */
	public void clearBoard(){
		int temp = board.pieces.size();
		
		for(int i= temp - 1; i >= 0; i--){
			board.removePiece(board.pieces.get(i));
		}
		setRepaintValid();
	}
}