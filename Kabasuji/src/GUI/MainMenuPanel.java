package GUI;

import javax.swing.JPanel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;

public class MainMenuPanel extends JPanel 
{

	/**
	 * Create the panel.
	 */
	public MainMenuPanel() 
	{
		setBackground(new Color(176, 224, 230));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(255, 165, 0));
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 800, 167);
		add(panel);
		
		JLabel lblKabasuji = new JLabel("Kabasuji");
		lblKabasuji.setForeground(new Color(255, 255, 0));
		lblKabasuji.setFont(new Font("Elephant", Font.PLAIN, 99));
		lblKabasuji.setBackground(new Color(255, 165, 0));
		panel.add(lblKabasuji);
		
		Button button = new Button("View Levels");
		button.setFont(new Font("Dialog", Font.PLAIN, 49));
		button.setForeground(new Color(255, 255, 0));
		button.setBackground(new Color(255, 165, 0));
		button.setBounds(238, 396, 324, 87);
		add(button);
		
		Button button_1 = new Button("Play");
		button_1.setForeground(Color.YELLOW);
		button_1.setFont(new Font("Dialog", Font.PLAIN, 49));
		button_1.setBackground(new Color(255, 165, 0));
		button_1.setBounds(238, 303, 324, 87);
		add(button_1);
		
		Button button_2 = new Button("Reset Score");
		button_2.setForeground(Color.YELLOW);
		button_2.setFont(new Font("Dialog", Font.PLAIN, 49));
		button_2.setBackground(new Color(255, 165, 0));
		button_2.setBounds(238, 489, 324, 87);
		add(button_2);
		
		

	}
}
