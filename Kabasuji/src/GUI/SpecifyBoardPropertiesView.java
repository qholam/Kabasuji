package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.SpecifyBoardCtrl;
import entity.Board;
import entity.LevelType;
import entity.LightningLevel;
import view.TileView;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JButton;
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
	JPanel boardContainer;
	int width,height;
	int widthMax;
	int heightMax;

	/**
	 * Create the panel.
	 */
	public SpecifyBoardPropertiesView(KabasujiBuilderFrame frame) {
		kFrame = frame;
		width = 12;
		height = 12;
		widthMax = 12;
		heightMax = 12;
		
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
		
		txtEnterWidthmax = new JTextField("" + width);
		txtEnterWidthmax.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterWidthmax.setBounds(236, 235, 112, 27);
		add(txtEnterWidthmax);
		txtEnterWidthmax.setColumns(10);
		
		txtEnterHeightmax = new JTextField("" + height);
		txtEnterHeightmax.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterHeightmax.setColumns(10);
		txtEnterHeightmax.setBounds(236, 273, 112, 27);
		add(txtEnterHeightmax);
		
		//button which will take user to the view to edit the level
		Button nextButton = new Button("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				kFrame.setWorkingBoard(new Board(kFrame.workingLevel.getLevel(), board.getBoard().getNumRows(), board.getBoard().getNumColumns()));
				kFrame.workingLevel.setBoard(kFrame.workingBoard);
				LevelType lt = kFrame.workingLevel.getLevel().getLevelType();
				System.out.println(lt);
				if (lt.equals(LevelType.Lightning)) {
					kFrame.workingLevel=new BuilderLightningLevel(kFrame);
					kFrame.workingLevel.setBounds(0, 0, 1200, 800);
					kFrame.getContentPane().add(kFrame.workingLevel, kFrame.BuilderLightningLevel);
					kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.BuilderLightningLevel);
				}
				else if (lt.equals(LevelType.Puzzle)) {
					kFrame.workingLevel=new BuilderPuzzleLevel(kFrame);
					kFrame.workingLevel.setBounds(0, 0, 1200, 800);
					kFrame.getContentPane().add(kFrame.workingLevel, kFrame.BuilderPuzzleLevel);
					kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.BuilderPuzzleLevel);
				}
				else {
					kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.BuilderPuzzleLevel); //CHANGE THIS TO RELEASE
				}
			}
		});
		nextButton.setForeground(Color.YELLOW);
		nextButton.setFont(new Font("Elephant", Font.PLAIN, 30));
		nextButton.setBackground(new Color(255, 165, 0));
		nextButton.setBounds(809, 646, 131, 44);
		add(nextButton);	
		
		boardContainer = new JPanel();
		boardContainer.setBounds(300, 325, 308, 308);
		add(boardContainer);
		boardContainer.setLayout(new GridLayout(0, 1, 0, 0));
		
		board = new BoardPanel(new Board(null, width, height));
		board.addMouseListener(new SpecifyBoardCtrl(this, board));
		boardContainer.add(board);
		
		JButton btnUpdateSize = new JButton("UPDATE SIZE");
		btnUpdateSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				updateBoard();
			}
		});
		btnUpdateSize.setBounds(358, 254, 112, 23);
		add(btnUpdateSize);
		
		JLabel lblNewLabel = new JLabel("Width (Max " + widthMax + ")");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(86, 233, 140, 27);
		add(lblNewLabel);
		
		JLabel lblHeightmax = new JLabel("Height (Max " + heightMax + ")");
		lblHeightmax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHeightmax.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHeightmax.setBounds(86, 273, 140, 27);
		add(lblHeightmax);
	}
	
	boolean updateHeight() {
		String s = txtEnterHeightmax.getText();
		int newHeight;
		try {
			newHeight = Integer.parseInt(s);
		}
		catch (NumberFormatException e) {
		     return false;
		}
		if (newHeight < 1 || newHeight > heightMax) {
			return false;
		}
		
		height = newHeight;
		return true;
	}
	
	boolean updateWidth() {
		String s = txtEnterWidthmax.getText();
		int newWidth;
		try {
			newWidth = Integer.parseInt(s);
		}
		catch (NumberFormatException e) {
		     return false;
		}
		if (newWidth < 1 || newWidth > widthMax) {
			return false;
		}
		
		width = newWidth;
		return true;
	}
	
	void updateBoard() {
		System.out.println(board.getTileViews()[0][1].getTile().toString());
		updateWidth();
		updateHeight();
		txtEnterWidthmax.setText("" + width);
		txtEnterHeightmax.setText("" + height);
		
		boardContainer.remove(board);
		board = new BoardPanel(new Board(null, width, height));
		boardContainer.add(board);
		boardContainer.repaint();
		repaint();
		
	}
	
	/**
	 * Get the tile view at the specified mouse event
	 * @param me
	 */
	public TileView getClickedTile(MouseEvent me){
		return board.getClickedTile(me);
	}
	
	public KabasujiBuilderFrame getFrame(){
		return kFrame;
	}
}
