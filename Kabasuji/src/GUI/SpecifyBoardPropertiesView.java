package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.Label;
/**
 * @author Quoc HoLam
 * Gui for the designer to specify the shape and size of the board
 */
public class SpecifyBoardPropertiesView extends JPanel {
	private JTextField txtEnterWidthmax;
	private JTextField txtEnterHeightmax;

	/**
	 * Create the panel.
	 */
	public SpecifyBoardPropertiesView() {
		setBackground(Color.GRAY);
		this.setSize(800, 800);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(255, 165, 0));
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 800, 167);
		add(panel);
		
		JLabel lblKabasuji = new JLabel("Board Specifications");
		lblKabasuji.setForeground(new Color(255, 255, 0));
		lblKabasuji.setFont(new Font("Elephant", Font.PLAIN, 70));
		lblKabasuji.setBackground(new Color(255, 165, 0));
		panel.add(lblKabasuji);
		
		Button button = new Button("Main Menu");
		button.setForeground(Color.YELLOW);
		button.setFont(new Font("Elephant", Font.PLAIN, 30));
		button.setBackground(new Color(255, 165, 0));
		button.setBounds(562, 221, 177, 44);
		add(button);
		
		JPanel boardPanel = new JPanel();
		boardPanel.setBounds(99, 325, 600, 300);
		add(boardPanel);
		boardPanel.setLayout(null);
		
		JLabel lblBoardGoesHere = new JLabel("Board Goes Here");
		lblBoardGoesHere.setBounds(260, 182, 81, 14);
		boardPanel.add(lblBoardGoesHere);
		
		txtEnterWidthmax = new JTextField();
		txtEnterWidthmax.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterWidthmax.setText("Enter Width(Max 12)");
		txtEnterWidthmax.setBounds(35, 235, 112, 27);
		add(txtEnterWidthmax);
		txtEnterWidthmax.setColumns(10);
		
		txtEnterHeightmax = new JTextField();
		txtEnterHeightmax.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterHeightmax.setText("Enter Height(Max 12)");
		txtEnterHeightmax.setColumns(10);
		txtEnterHeightmax.setBounds(168, 235, 112, 27);
		add(txtEnterHeightmax);
		
		Button nextButton = new Button("Next");
		nextButton.setForeground(Color.YELLOW);
		nextButton.setFont(new Font("Elephant", Font.PLAIN, 30));
		nextButton.setBackground(new Color(255, 165, 0));
		nextButton.setBounds(608, 746, 131, 44);
		add(nextButton);	
	}
}
