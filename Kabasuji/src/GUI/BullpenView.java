package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;

import controller.HorizontalFlipCtrl;
import controller.RotateClockwiseCtrl;
import controller.RotateCounterClockwiseCtrl;
import controller.VerticalFlipCtrl;
import entity.Bullpen;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BullpenView extends JPanel {
	//bullpen that this view representes
	Bullpen bullpen;
	
	/**
	 * Create the panel.
	 */
	public BullpenView(Bullpen b) {
		this.bullpen = b;
		
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
		btnNewButton.addActionListener(new RotateClockwiseCtrl(this));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rotate Counter-Clockwise");
		btnNewButton_1.addActionListener(new RotateCounterClockwiseCtrl(this));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Flip Horizontally");
		btnNewButton_2.addActionListener(new VerticalFlipCtrl(this));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Flip Vertically");
		btnNewButton_3.addActionListener(new HorizontalFlipCtrl(this));
		panel.add(btnNewButton_3);

	}

	/**
	 * @return the bullpen
	 */
	public Bullpen getBullpen() {
		return bullpen;
	}
}
