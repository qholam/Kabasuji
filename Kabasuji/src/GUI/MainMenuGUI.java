package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.Button;

public class MainMenuGUI extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuGUI frame = new MainMenuGUI();
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
	public MainMenuGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ToolBar.floatingForeground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 884, 166);
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 165, 0));
		panel.setForeground(Color.WHITE);
		contentPane.add(panel);
		
		JLabel lblKabasuji = new JLabel("Kabasuji");
		panel.add(lblKabasuji);
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setForeground(new Color(255, 255, 51));
		lblKabasuji.setFont(new Font("Elephant", Font.PLAIN, 71));
		
		Button button_3 = new Button("View Levels");
		button_3.setBounds(309, 399, 265, 90);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setFont(new Font("Dialog", Font.PLAIN, 34));
		button_3.setForeground(Color.YELLOW);
		button_3.setBackground(new Color(255, 153, 0));
		contentPane.add(button_3);
		
		Button button_4 = new Button("Play");
		button_4.setForeground(Color.YELLOW);
		button_4.setFont(new Font("Dialog", Font.PLAIN, 34));
		button_4.setBackground(new Color(255, 153, 0));
		button_4.setBounds(309, 303, 265, 90);
		contentPane.add(button_4);
		
		Button button_6 = new Button("Reset Score");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_6.setForeground(Color.YELLOW);
		button_6.setFont(new Font("Dialog", Font.PLAIN, 34));
		button_6.setBackground(new Color(255, 153, 0));
		button_6.setBounds(309, 495, 265, 90);
		contentPane.add(button_6);
	}
}
