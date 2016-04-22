package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Board;
import entity.Bullpen;
import entity.Level;
import entity.LightningLevel;
import entity.PuzzleLevel;

import java.awt.CardLayout;

public class KabasujiFrame extends JFrame {
	final String SplashScreen = "SplashScreen";
	final String MainMenu = "MainMenu";
	final String Puzzle1 = "Puzzle1";
	final String LevelSelect = "LevelSelect";

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KabasujiFrame frame = new KabasujiFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KabasujiFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		
		SplashScreen splash = new SplashScreen(this);
		
		MainMenuPanel mainMenu = new MainMenuPanel(this);
		mainMenu.setBounds(0, 0, 800, 800);
		contentPane.add(mainMenu, MainMenu);
		
		LevelPanel puzzle1 = new LevelPanel(this,(Level) new PuzzleLevel(20, new Board(null, 10, 10), new Bullpen(), true, 1, 0));
		mainMenu.setBounds(0, 0, 800, 800);
		contentPane.add(puzzle1, Puzzle1);
		
		LevelSelector levelSelect = new LevelSelector(this);
		levelSelect.setBounds(0, 0, 800, 800);
		contentPane.add(levelSelect, LevelSelect);
		
		splash.displaySplashScreen();
	}
	
	public CardLayout getCardLayout() {
		return (CardLayout)contentPane.getLayout();
	}

}
