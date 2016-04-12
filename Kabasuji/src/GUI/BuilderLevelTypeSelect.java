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

public class BuilderLevelTypeSelect extends JPanel
{
	private JPanel contentPane;

	
	
	public BuilderLevelTypeSelect() 
	{
		setBackground(new Color(176, 224, 230));
		this.setSize(800, 800);
		setLayout(null);
	
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(255, 165, 0));
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 800, 167);
		add(panel);
	
		JLabel lblKabasuji = new JLabel("Level Type");
		lblKabasuji.setForeground(new Color(255, 255, 0));
		lblKabasuji.setFont(new Font("Elephant", Font.PLAIN, 99));
		lblKabasuji.setBackground(new Color(255, 165, 0));
		panel.add(lblKabasuji);
	
		Button button = new Button("Puzzle");
		button.setFont(new Font("Dialog", Font.PLAIN, 49));
		button.setForeground(new Color(255, 255, 0));
		button.setBackground(new Color(255, 165, 0));
		button.setBounds(238, 396, 324, 87);
		add(button);
	
		Button button_1 = new Button("Release");
		button_1.setForeground(Color.YELLOW);
		button_1.setFont(new Font("Dialog", Font.PLAIN, 49));
		button_1.setBackground(new Color(255, 165, 0));
		button_1.setBounds(238, 303, 324, 87);
		add(button_1);
	
		Button button_2 = new Button("Lightning");
		button_2.setForeground(Color.YELLOW);
		button_2.setFont(new Font("Dialog", Font.PLAIN, 49));
		button_2.setBackground(new Color(255, 165, 0));
		button_2.setBounds(238, 489, 324, 87);
		add(button_2);
		
		Button button_3 = new Button("Main Menu");
		button_3.setForeground(Color.YELLOW);
		button_3.setFont(new Font("Dialog", Font.PLAIN, 49));
		button_3.setBackground(new Color(255, 165, 0));
		button_3.setBounds(238, 582, 324, 87);
		add(button_3);
	}
}
