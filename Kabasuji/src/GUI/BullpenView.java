package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;

import controller.HorizontalFlipCtrl;
import controller.PieceInBullpenCtrl;
import controller.RotateClockwiseCtrl;
import controller.RotateCounterClockwiseCtrl;
import controller.VerticalFlipCtrl;
import entity.Bullpen;
import entity.KabasujiGame;
import entity.Piece;
import entity.PieceTile;
import view.PieceView;
import view.TileView;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import java.awt.Label;
import java.awt.FlowLayout;
import java.awt.Graphics;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BullpenView extends JPanel {
	//bullpen that this view represents
	Bullpen bullpen;
	//Views of a piece contained by this Bullpen
	PieceView[] pieces;
	//the current selected pieceview 
	PieceView selected;
	
	public void setSelected(PieceView p){
		selected = p;
	}
	
	public PieceView getSelected(){
		return selected;
	}
	
	/**
	 * Create the panel.
	 */
	public BullpenView(Bullpen b) {
		pieces = new PieceView[4];
		//get bullpen and pieces
		this.bullpen = b;
		//ArrayList<Piece> p = b.getPieces();
		//possibly need to know the quantity of each piece left
		//HashMap<Piece, Integer> pleft = b.getPiecesInfo();
		
		setLayout(null);
		setBounds(0, 0, 600, 300);
		setBackground(new Color(255, 165, 0));

		JPanel scrollPanel = new JPanel(new GridLayout(1, 0, 10, 0));
		
		JScrollPane scrollPane = new JScrollPane(scrollPanel);
		
		scrollPane.setBounds(10, 10, 580, 240);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		//USED TO TEST, will be removed
		for(int i = 0; i < 3; i++){ 
			Piece p = new Piece();
			p.addTile(new PieceTile(), 0, 2); 
			p.addTile(new PieceTile(), 1, 2); 
			p.addTile(new PieceTile(), 2, 2);
			p.addTile(new PieceTile(), 3, 2);
			p.addTile(new PieceTile(), 4, 2);
			p.addTile(new PieceTile(), 3, 1);
			p.addTile(new PieceTile(), 3, 3);
			pieces[i] = new PieceView(p);
			pieces[i].addMouseListener(new PieceInBullpenCtrl(this, pieces[i]));
            scrollPanel.add(pieces[i]);
            scrollPanel.setPreferredSize(new Dimension(240 * scrollPanel.getComponents().length, 0));  
		}

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
		btnNewButton_2.addActionListener(new HorizontalFlipCtrl(this));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Flip Vertically");
		btnNewButton_3.addActionListener(new VerticalFlipCtrl(this));
		panel.add(btnNewButton_3); 

	}
	
	/**
	 * @return the bullpen
	 */
	public Bullpen getBullpen() {
		return bullpen;
	}
}
