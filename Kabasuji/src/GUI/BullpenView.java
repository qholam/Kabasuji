package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;

import controller.HorizontalFlipCtrl;
import controller.RotateClockwiseCtrl;
import controller.RotateCounterClockwiseCtrl;
import controller.VerticalFlipCtrl;
import entity.Bullpen;
import entity.Piece;
import view.PieceView;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import java.awt.Label;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridBagLayout;

public class BullpenView extends JPanel {
	//bullpen that this view representes
	Bullpen bullpen;
	//Views of a piece contained by this Bullpen
	PieceView[] pieces;
	
	/**
	 * Create the panel.
	 */
	public BullpenView(Bullpen b) {
		//get bullpen and pieces
		this.bullpen = b;
		//ArrayList<Piece> p = b.getPieces();
		//possibly need to know the quantity of each piece left
		//HashMap<Piece, Integer> pleft = b.getPiecesInfo();
		
		setLayout(null);
		setBounds(0, 0, 600, 300);
		setBackground(new Color(255, 165, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 580, 240);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBounds(10, 250, 580, 40);
		add(panel);
		panel.setLayout(new GridLayout(1, 4, 0, 0));
		
		JButton btnNewButton = new JButton("Rotate Clockwise");
		btnNewButton.addActionListener(new RotateClockwiseCtrl(this));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rotate Counter-Clockwise");
		btnNewButton_1.addActionListener(new RotateCounterClockwiseCtrl(this));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Flip Horizontally");
		btnNewButton_2.addActionListener(new VerticalFlipCtrl(this));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Flip Vertically");
		btnNewButton_3.addActionListener(new HorizontalFlipCtrl(this));
		panel.add(btnNewButton_3);

	}

	/**
	 * @return the bullpen
	 */
	public Bullpen getBullpen() {
		return bullpen;
	}
}
