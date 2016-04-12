package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Bullpen extends JPanel {

	/**
	 * Create the panel.
	 */
	public Bullpen() {
		setLayout(null);
		setBounds(0, 0, 600, 300);
		setBackground(new Color(255, 165, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 580, 240);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 250, 580, 40);
		add(panel);
		panel.setLayout(new GridLayout(1, 4, 0, 0));
		
		JButton btnNewButton = new JButton("Rotate Clockwise");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rotate Counter-Clockwise");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Flip Horizontally");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Flip Vertically");
		panel.add(btnNewButton_3);

	}
}
