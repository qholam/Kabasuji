package GUI;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BuilderMainMenuPanel extends JPanel
{

	KabasujiBuilderFrame kFrame;

	/**
	 * Create the frame.
	 */
	public BuilderMainMenuPanel(KabasujiBuilderFrame frame) 
	{
		kFrame = frame;
		setBackground(Color.GRAY);
		this.setSize(1200, 800);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(255, 165, 0));
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 1200, 167);
		add(panel);
		
		
		JLabel lblKabasuji = new JLabel("Kabasuji Level Builder");
		lblKabasuji.setBounds(117, 7, 640, 68);
		panel.add(lblKabasuji);
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setForeground(new Color(255, 255, 51));
		lblKabasuji.setFont(new Font("Elephant", Font.PLAIN, 55));
		
		Button button_4 = new Button("Build a Level");
		button_4.setForeground(Color.YELLOW);
		button_4.setFont(new Font("Dialog", Font.PLAIN, 34));
		button_4.setBackground(new Color(255, 153, 0));
		button_4.setBounds(467, 238, 265, 90);
		add(button_4);
		
		Button button_6 = new Button("Saved Levels");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_6.setForeground(Color.YELLOW);
		button_6.setFont(new Font("Dialog", Font.PLAIN, 25));
		button_6.setBackground(new Color(255, 153, 0));
		button_6.setBounds(467, 368, 265, 90);
		add(button_6);
	}
}	

