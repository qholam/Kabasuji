package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class KabasujiBuilderFrame extends JFrame {
	final String SplashScreen = "BuilderSplashScreen";
	final String BuilderMainMenu = "BuilderMainMenu";
	final String Puzzle1 = "Puzzle1";
	final String BuilderLevelTypeSelect = "BuilderLevelTypeSelect";

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KabasujiBuilderFrame frame = new KabasujiBuilderFrame();
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
	public KabasujiBuilderFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		
		BuilderSplashScreen splash = new BuilderSplashScreen(this);
		
		BuilderMainMenuPanel mainMenu = new BuilderMainMenuPanel(this);
		mainMenu.setBounds(0, 0, 800, 800);
		contentPane.add(mainMenu, BuilderMainMenu);
		
		BuilderLevelTypeSelect levelTypeSelect = new BuilderLevelTypeSelect(this);
		levelTypeSelect.setBounds(0, 0, 1200, 800);
		contentPane.add(levelTypeSelect, BuilderLevelTypeSelect);
		
		splash.displaySplashScreen();
	}
	
	public CardLayout getCardLayout() {
		return (CardLayout)contentPane.getLayout();
	}

}
