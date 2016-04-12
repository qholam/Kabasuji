package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * @author Quoc HoLam
 * Splash screen that is displayed before the application is loaded
 */
public class SplashScreen extends JPanel {
	private JTextField txtSplashScreen;
	KabasujiFrame kf;
	
	/**
	 * Create the panel.
	 */
	public SplashScreen(KabasujiFrame frame) {
		kf = frame;
		
		setBackground(Color.gray);
		setSize(800,800);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 62);
		add(panel);
		
		txtSplashScreen = new JTextField();
		txtSplashScreen.setText("Splash Screen");
		panel.add(txtSplashScreen);
		txtSplashScreen.setColumns(10);
	}
	
	public void displaySplashScreen(){
		kf.getCardLayout().show(kf.getContentPane(), kf.SplashScreen);
		
		//Screen is displayed for given amount of try
		try{
			Thread.sleep(2000);
		} catch(Exception e){
			System.err.println("Could not sleep during splash screen");
		}
		
		kf.getCardLayout().show(kf.getContentPane(), kf.MainMenu);
	}
	
}
