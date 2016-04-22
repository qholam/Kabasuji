package GUI;

import javax.swing.JPanel;

import entity.Board;

import java.awt.Color;

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
		panel.setBounds(10, 10, 580, 280);
		add(panel);

	}
}