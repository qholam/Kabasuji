package GUI;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class BuilderPuzzleLevel extends JPanel {
	KabasujiBuilderFrame kFrame;
	
	/**
	 * Create the panel.
	 */
	public BuilderPuzzleLevel(KabasujiBuilderFrame frame) {
		kFrame = frame;
		
		setBackground(Color.GRAY);
		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		Board board = new Board();
		board.setBounds(25, 400, 600, 300);
		add(board);
		
		Bullpen bullPen = new Bullpen();
		bullPen.setBounds(25, 25, 600, 300);
		add(bullPen);
		
		JButton btnNewButton_1 = new JButton("TRASH");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(650, 600, 100, 100);
		add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("ALLOWED MOVES: 0");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(275, 336, 350, 57);
		add(lblNewLabel);
		
		JButton btnMenu = new JButton("SAVE");
		btnMenu.setBounds(650, 25, 100, 75);
		add(btnMenu);
		
		JPanel panel = new JPanel();
		panel.setBounds(775, 25, 400, 675);
		add(panel);
		panel.setLayout(new GridLayout(1, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
		
		JButton btnUndo = new JButton("UNDO");
		btnUndo.setBounds(25, 366, 89, 23);
		add(btnUndo);
		
		JButton button = new JButton("REDO");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(124, 366, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("+");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBounds(635, 336, 50, 23);
		add(button_1);
		
		JButton button_2 = new JButton("-");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_2.setBounds(635, 370, 50, 23);
		add(button_2);
		
		JButton button_3 = new JButton("RESET");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setBounds(650, 111, 100, 75);
		add(button_3);
		
		JButton button_4 = new JButton("EXIT");
		button_4.setBounds(650, 197, 100, 75);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.BuilderMainMenu);
			}
		});
		add(button_4);

	}
}
