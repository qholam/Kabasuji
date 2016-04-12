package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Label;

/**
 * @author Quoc HoLam
 * Splash screen that is displayed before the application is loaded
 */
public class SplashScreen extends JFrame {
	private JPanel contentPane;
	private JTextField txtSplashScreen;
	KabasujiFrame kf;
	private JTextField txtKabasuji;
	
	/**
	 * Create the panel.
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
		
		txtKabasuji = new JTextField();
		txtKabasuji.setForeground(Color.YELLOW);
		txtKabasuji.setFont(new Font("Elephant", Font.PLAIN, 99));
		txtKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		txtKabasuji.setText("Kabasuji");
		txtKabasuji.setBounds(0, 0, 784, 167);
		txtKabasuji.setBackground(new Color(255, 165, 0));
		contentPane.add(txtKabasuji);
		txtKabasuji.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("<html>Team Odius:<br>Quoc HoLam<br>Calvin Chen<br>Richard Hayes<br>Nicholas Hollan<br>LilyAnne Lewis</html>");
		lblNewLabel.setFont(new Font("Elephant", Font.PLAIN, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(182, 134, 419, 492);
		contentPane.add(lblNewLabel);
	}
	
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
