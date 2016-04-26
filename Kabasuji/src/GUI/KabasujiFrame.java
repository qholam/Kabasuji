package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Board;
import entity.Bullpen;
import entity.Level;
import entity.LightningLevel;
import entity.Piece;
import entity.PieceTile;
import entity.PuzzleLevel;
import serializers.Deserializer;

import java.awt.CardLayout;

public class KabasujiFrame extends JFrame {
	final String SplashScreen = "SplashScreen";
	final String MainMenu = "MainMenu";
	final String Puzzle1 = "Puzzle1";
	final String LevelSelect = "LevelSelect";

	private JPanel contentPane;
	PieceContainer container;

	/**
	 * Create the frame.
	 */
	public KabasujiFrame() { 
		Deserializer deserializer =  new Deserializer();
		container = new PieceContainer(); 
		
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
		
		//to be remove this bullpen was made for testing
		LevelPanel puzzle1 = new LevelPanel(this, deserializer.deserialzePuzzleLevel(1));
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
	
	public PieceContainer getPieceContainer(){
		return container;
	}
}
