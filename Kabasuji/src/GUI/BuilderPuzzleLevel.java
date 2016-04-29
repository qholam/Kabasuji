package GUI;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import controller.BoardCtrl;
import controller.DragCtrl;
import controller.EditorPanelCtrl;
import controller.MouseMoveCtrl;
import entity.Board;
import entity.Bullpen;
import entity.Piece;
import entity.PieceTile;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class BuilderPuzzleLevel extends BuilderLevel {
	KabasujiBuilderFrame kFrame;
	
	BoardPanel boardPanel;
	Board board;
	BullpenView  bullpen;
	PieceContainer container;
	
	/**
	 * Create the panel.
	 */
	public BuilderPuzzleLevel(KabasujiBuilderFrame frame) {
		container = frame.getPieceContainer();
		container.setVisible(false);
		add(container);
		kFrame = frame;
		
		setBackground(Color.GRAY);
		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		boardPanel = new BoardPanel(new Board(null, 12, 12));
		boardPanel.setBounds(25, 400, 600, 300);
		boardPanel.addMouseListener(new BoardCtrl(boardPanel, this));
		add(boardPanel);
		
		Bullpen b = new Bullpen();
		//test pieces
		for(int i = 0; i < 6; i++){
			Piece p = new Piece();
			p.addTile(new PieceTile(), 0, 2); 
			p.addTile(new PieceTile(), 1, 2); 
			p.addTile(new PieceTile(), 2, 2);
			p.addTile(new PieceTile(), 3, 2);
			p.addTile(new PieceTile(), 4, 2);
			p.addTile(new PieceTile(), 5, 2);
			p.addTile(new PieceTile(), 5-i, 1);
			p.addTile(new PieceTile(), 5-i, 3);
			b.addPiece(p);
		}
		bullpen = new BullpenView(b);
		bullpen.setBounds(25, 25, 600, 300);
		//add controllers to handle dragging
		for(int i = 0; i < bullpen.getBullpen().getPieces().size(); i++){
			//add controllers to handle dragging a piece over other pieces
			bullpen.getPieceViews().get(i).addMouseMotionListener(new MouseMoveCtrl(this));
			bullpen.getPieceViews().get(i).addMouseListener(new MouseMoveCtrl(this));
			
			//controller to handle the dragging
			bullpen.getPieceViews().get(i).addMouseListener(new DragCtrl(bullpen.getPieceViews().get(i), this));
			//new DragCtrl().handleDrag(bullpen.getPieceViews().get(i), this); 
		}
		//add controllers to handle dragging a piece over the components within the bullpen, this makes the drag smoother
		for(Component c :bullpen.getComponents()){
			//some components have components inside
			for(Component cc: ((Container) c).getComponents()){
				cc.addMouseMotionListener(new MouseMoveCtrl(this));
				cc.addMouseListener(new MouseMoveCtrl(this));
			}
			c.addMouseMotionListener(new MouseMoveCtrl(this));
			c.addMouseListener(new MouseMoveCtrl(this));
		}
		add(bullpen);
		
		JButton btnNewButton_1 = new JButton("TRASH");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(650, 600, 100, 100);
		btnNewButton_1.addMouseMotionListener(new MouseMoveCtrl(this));
		btnNewButton_1.addMouseListener(new MouseMoveCtrl(this));
		add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("ALLOWED MOVES: 0");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(275, 336, 350, 57);
		add(lblNewLabel);
		
		JButton btnMenu = new JButton("SAVE");
		btnMenu.setBounds(650, 25, 100, 75);
		btnMenu.addMouseMotionListener(new MouseMoveCtrl(this));
		btnMenu.addMouseListener(new MouseMoveCtrl(this));
		add(btnMenu);
		
		JPanel panel = new JPanel();
		panel.setBounds(775, 25, 400, 675);
		add(panel);
		panel.setLayout(new GridLayout(1, 1, 0, 0));
		panel.addMouseMotionListener(new MouseMoveCtrl(this));
		panel.addMouseListener(new MouseMoveCtrl(this));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		EditorPanel editorPanel = new EditorPanel(kFrame);
		
		//Nick added this 	\/
		editorPanel.addMouseMotionListener(new EditorPanelCtrl(editorPanel,this));
		//  				/\
		panel_1.add(editorPanel);
		scrollPane.addMouseMotionListener(new MouseMoveCtrl(this));
		scrollPane.addMouseListener(new MouseMoveCtrl(this));
		
		
		
		JButton btnUndo = new JButton("UNDO");
		btnUndo.setBounds(25, 366, 89, 23);
		btnUndo.addMouseMotionListener(new MouseMoveCtrl(this));
		btnUndo.addMouseListener(new MouseMoveCtrl(this));
		add(btnUndo);
		
		JButton button = new JButton("REDO");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(124, 366, 89, 23);
		button.addMouseMotionListener(new MouseMoveCtrl(this));
		button.addMouseListener(new MouseMoveCtrl(this));
		add(button);
		
		JButton button_1 = new JButton("+");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBounds(635, 336, 50, 23);
		button_1.addMouseMotionListener(new MouseMoveCtrl(this));
		button_1.addMouseListener(new MouseMoveCtrl(this));
		add(button_1);
		
		JButton button_2 = new JButton("-");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_2.setBounds(635, 370, 50, 23);
		button_2.addMouseMotionListener(new MouseMoveCtrl(this));
		button_2.addMouseListener(new MouseMoveCtrl(this));
		add(button_2);
		
		JButton button_3 = new JButton("RESET");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setBounds(650, 111, 100, 75);
		button_3.addMouseMotionListener(new MouseMoveCtrl(this));
		button_3.addMouseListener(new MouseMoveCtrl(this));
		add(button_3);
		
		JButton button_4 = new JButton("EXIT");
		button_4.setBounds(650, 197, 100, 75);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.BuilderMainMenu);
			}
		});
		button_4.addMouseMotionListener(new MouseMoveCtrl(this));
		button_4.addMouseListener(new MouseMoveCtrl(this));
		add(button_4);

		
		//handles the moving of a piece
		this.addMouseMotionListener(new MouseMoveCtrl(this));
		this.addMouseListener(new MouseMoveCtrl(this));
	}
	
	void setBoard(Board b) {
		remove(boardPanel);
		boardPanel = new BoardPanel(b);
		boardPanel.setBounds(25, 400, 600, 300);
		add(boardPanel);
		boardPanel.repaint();
	}
	
	public PieceContainer getPieceContainer(){
		return container;
	}
	
	public BullpenView getBullpenView(){
		return bullpen;
	}
	
	public BoardPanel getBoardPanel(){
		return boardPanel;
	}
}
