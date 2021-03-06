package GUI;

import javax.swing.JPanel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.border.LineBorder;

import controller.LoadLevelCtrl;
import entity.LevelType;

import javax.swing.JLabel;

public class MainMenuPanel extends JPanel 
{
	/**
	 * Auto-generate by Eclipse to suppress a warning
	 */
	private static final long serialVersionUID = -7680580324316157014L;
	KabasujiFrame kFrame;
	public ActionEvent button; 

	/**
	 * Create the panel for a Main Menu.
	 * @param frame The given {@link KabasujiFrame}.
	 */
	public MainMenuPanel(KabasujiFrame frame) 
	{
		kFrame = frame;
		
		setBackground(Color.GRAY);
		this.setSize(800, 800);
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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				LevelSelector levelSelect = new LevelSelector(kFrame);
				levelSelect.setBounds(0, 0, 800, 800);
				kFrame.contentPane.add(levelSelect, kFrame.LevelSelect);
				kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.LevelSelect);
			}
		});
		button.setFont(new Font("Dialog", Font.PLAIN, 49));
		button.setForeground(new Color(255, 255, 0));
		button.setBackground(new Color(255, 165, 0));
		button.setBounds(238, 396, 324, 87);
		add(button);
		
		Button button_1 = new Button("Play");
		button_1.addActionListener(new LoadLevelCtrl(LevelType.Puzzle, kFrame, 1));
		button_1.setForeground(Color.YELLOW);
		button_1.setFont(new Font("Dialog", Font.PLAIN, 49));
		button_1.setBackground(new Color(255, 165, 0));
		button_1.setBounds(238, 303, 324, 87);
		button = button_1;
		add(button_1);
		
		Button button_2 = new Button("Reset Score");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				FileOutputStream fileOut;
				try {
					//open file that holds info on stars
					fileOut = new FileOutputStream("src/LevelInfo/LevelStars");
					
					//delete everything
					fileOut.write("".getBytes());
					fileOut.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		button_2.setForeground(Color.YELLOW);
		button_2.setFont(new Font("Dialog", Font.PLAIN, 49));
		button_2.setBackground(new Color(255, 165, 0));
		button_2.setBounds(238, 489, 324, 87);
		add(button_2);
		
		

	}
}
