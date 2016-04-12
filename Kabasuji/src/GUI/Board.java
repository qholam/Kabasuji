package GUI;

import javax.swing.JPanel;
import java.awt.Color;

public class Board extends JPanel {

	/**
	 * Create the panel.
	 */
	public Board() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 600, 300);
		setBackground(new Color(255, 165, 0));
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 580, 280);
		add(panel);

	}
}