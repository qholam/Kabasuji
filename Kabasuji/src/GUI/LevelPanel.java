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

import entity.Board;
import entity.Bullpen;
import entity.Level;
import entity.LightningLevel;
import entity.PuzzleLevel;

public class LevelPanel extends JPanel {
	KabasujiFrame kFrame;
	//the level that this panel represnets
	Level level;

	/**
	 * Create the panel.
	 */
	public LevelPanel(KabasujiFrame frame, Level l) {
		kFrame = frame;
		level = l;
		
		setBackground(Color.GRAY);
		setLayout(null); 
		setBounds(0, 0, 800, 800);
		
		BoardPanel board = new BoardPanel(l.getBoard());
		board.setBounds(25, 400, 600, 300);
		add(board);
		
		BullpenView bullPen = new BullpenView(l.getBullpen());
		bullPen.setBounds(25, 25, 600, 300);
		add(bullPen);
		
		JButton btnNewButton_1 = new JButton("TRASH");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(650, 600, 100, 100);
		add(btnNewButton_1);
		
		//Change here(condensed all level view into one)
		JLabel lblNewLabel;
		if(l instanceof PuzzleLevel)
			lblNewLabel = new JLabel("MOVES LEFT: " + ((PuzzleLevel) l).getMovesRemaining());
		else if( l instanceof LightningLevel)
			lblNewLabel = new JLabel("Time Left: " + ((LightningLevel) l).getTimeRemaining());
		else
			lblNewLabel = new JLabel("Moves: 0");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(25, 336, 600, 57);
		add(lblNewLabel);
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.setBounds(650, 25, 100, 100);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.MainMenu);
			}
		});
		add(btnMenu);
		
		JPanel panel = new JPanel();
		panel.setBounds(650, 186, 100, 353);
		add(panel);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("STAR");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("STAR");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("STAR");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);

	}
}
