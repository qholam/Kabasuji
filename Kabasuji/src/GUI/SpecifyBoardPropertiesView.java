package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import entity.Board;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * @author Quoc HoLam
 * Gui for the designer to specify the shape and size of the board
 */
public class SpecifyBoardPropertiesView extends JPanel {
	/**
	 * Auto-generate by Eclipse to suppress a warning
	 */
	private static final long serialVersionUID = 7244704783204845445L;
	private JTextField txtEnterWidthmax;
	private JTextField txtEnterHeightmax;
	KabasujiBuilderFrame kFrame;
	BoardPanel board;
	int width,height;

	/**
	 * Create the panel.
	 */
	public SpecifyBoardPropertiesView(KabasujiBuilderFrame frame) {
		kFrame = frame;
		board = new BoardPanel(new Board(null, height, width));
		board.setLocation(0, 0);
		
		setBackground(Color.GRAY);
		setBounds(0, 0, 1200, 800);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(255, 165, 0));
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 1200, 167);
		add(panel);
		
		JLabel lblKabasuji = new JLabel("Board Specifications");
		lblKabasuji.setForeground(new Color(255, 255, 0));
		lblKabasuji.setFont(new Font("Elephant", Font.PLAIN, 70));
		lblKabasuji.setBackground(new Color(255, 165, 0));
		panel.add(lblKabasuji);
		
		Button mainMenuButton = new Button("Main Menu");
		mainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.BuilderMainMenu);
			}
		});
		mainMenuButton.setForeground(Color.YELLOW);
		mainMenuButton.setFont(new Font("Elephant", Font.PLAIN, 30));
		mainMenuButton.setBackground(new Color(255, 165, 0));
		mainMenuButton.setBounds(763, 221, 177, 44);
		add(mainMenuButton);
		
		//panel to hold the board
		JPanel boardPanel = new JPanel();
		boardPanel.setBackground(Color.LIGHT_GRAY);
		boardPanel.setBounds(300, 325, 600, 300);
		add(boardPanel);
		boardPanel.setLayout(null);
		
		//TO BE DELETED
		JLabel lblBoardGoesHere = new JLabel("BOARD GOES HERE");
		lblBoardGoesHere.setBounds(242, 120, 116, 60);
		boardPanel.add(lblBoardGoesHere);
		lblBoardGoesHere.setBackground(Color.LIGHT_GRAY);
		
		//add board
		boardPanel.add(board);
		
		txtEnterWidthmax = new JTextField();
		txtEnterWidthmax.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterWidthmax.setText("Enter Width(Max 12)");
		txtEnterWidthmax.setBounds(236, 235, 112, 27);
		add(txtEnterWidthmax);
		txtEnterWidthmax.setColumns(10);
		
		txtEnterHeightmax = new JTextField();
		txtEnterHeightmax.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterHeightmax.setText("Enter Height(Max 12)");
		txtEnterHeightmax.setColumns(10);
		txtEnterHeightmax.setBounds(369, 235, 112, 27);
		add(txtEnterHeightmax);
		
		//button which will take user to the view to edit the level
		Button nextButton = new Button("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.BuilderPuzzleLevel);
			}
		});
		nextButton.setForeground(Color.YELLOW);
		nextButton.setFont(new Font("Elephant", Font.PLAIN, 30));
		nextButton.setBackground(new Color(255, 165, 0));
		nextButton.setBounds(809, 646, 131, 44);
		add(nextButton);	
	}
}
