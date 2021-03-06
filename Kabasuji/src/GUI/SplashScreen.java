package GUI;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Label;

/**
 * Splash screen that is displayed before the application is loaded.
 * @author Quoc HoLam
 */
public class SplashScreen extends JFrame {
	/**
	 * Auto-generated by Eclipse
	 */
	private static final long serialVersionUID = 8475780127935142847L;
	
	private JPanel contentPane;
	KabasujiFrame kf;
	private Label label;
	
	/**
	 * Constructor for SplashScreen.
	 * @param frame.
	 */
	public SplashScreen(KabasujiFrame frame) {
		kf = frame;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>Team Odius:<br>Quoc HoLam<br>Calvin Chen<br>Richard Hayes<br>Nicholas Hollan<br>LilyAnne Lewis</html>");
		lblNewLabel.setFont(new Font("Elephant", Font.PLAIN, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(185, 194, 419, 492);
		contentPane.add(lblNewLabel);
		
		label = new Label("Kabasuji");
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Elephant", Font.PLAIN, 90));
		label.setAlignment(Label.CENTER);
		label.setBackground(new Color(255, 165, 0));
		label.setBounds(0, 0, 784, 161);
		contentPane.add(label);
	}
	
	/**
	 * Display Splash Screen.
	 */
	public void displaySplashScreen(){
		this.setVisible(true);
		
		//Screen is displayed for given amount of try
		try{
			Thread.sleep(2000);
		} catch(Exception e){
			System.err.println("Could not sleep during splash screen");
		}
		
		this.setVisible(false);
		kf.getCardLayout().show(kf.getContentPane(), kf.MainMenu);
	}
}
