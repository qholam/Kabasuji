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
	
	/**
	 * Create the panel.
	 */
	public BoardPanel(Board b) {
		board = b;
		
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
				panel.add(new TileView(b.getGrid()[r][c]));
			}
		}
		setOpaque(true);
		
	}
}