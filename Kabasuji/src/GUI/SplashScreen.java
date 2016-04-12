package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * @author Quoc HoLam
 * Splash screen that is displayed before the application is loaded
 */
public class SplashScreen extends JFrame {
	private JPanel contentPane;
	private JTextField txtSplashTest;
	private JTextField txtSplashScreen;
	KabasujiFrame kf;
	
	/**
	 * Create the panel.
	 */
	public SplashScreen(KabasujiFrame frame) {
		kf = frame;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		txtSplashTest = new JTextField();
		txtSplashTest.setText("Splash Test");
		contentPane.add(txtSplashTest, BorderLayout.CENTER);
		txtSplashTest.setColumns(10);
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
