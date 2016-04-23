package toBeDeleted;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import GUI.BullpenView;
import entity.Bullpen;
import entity.Piece;
import entity.PieceTile;
import view.PieceView;

/**
 * Was having issues viewing a JPanel with the built in windowbuilder(no logic such as for loops were being ran)
 * Made this to view JPanels
 * This will be deleted after all views are made
 * @author Quoc HoLam
 *
 */
public class TestPanels extends JFrame{
	private static final long serialVersionUID = 3385126210753078474L;
	
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
		Piece p = new Piece();
		p.addTile(new PieceTile(), 0, 2); 
		p.addTile(new PieceTile(), 1, 2); 
		p.addTile(new PieceTile(), 2, 2);
		p.addTile(new PieceTile(), 3, 2);
		p.addTile(new PieceTile(), 4, 2);
		p.addTile(new PieceTile(), 3, 1);
		p.addTile(new PieceTile(), 3, 3);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		
		PieceView test = new PieceView(p); 
		contentPane.add(test, "test");
		
		
		cardLayout.show(contentPane, "test"); 
	}
}
