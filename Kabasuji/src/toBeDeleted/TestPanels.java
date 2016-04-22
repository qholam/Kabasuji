package toBeDeleted;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

import GUI.KabasujiFrame;
import GUI.LevelSelector;
import GUI.MainMenuPanel;
import GUI.PuzzleLevelPanel;
import GUI.SplashScreen;
import entity.Piece;
import view.PieceView;

/**
 * Was having issues viewing a JPanel with the built in windowbuilder(no logic such as for loops were being ran)
 * Made this to view JPanels
 * This will be deleted after all views are made
 * @author Quoc HoLam
 *
 */
public class TestPanels extends JFrame{
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestPanels frame = new TestPanels();
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
	public TestPanels() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		
		PieceView test = new PieceView(new Piece());
		contentPane.add(test, "test");
		
		
		cardLayout.show(contentPane, "test");
	}
}
