package GUI;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import controller.BoardCtrl;
import controller.DragCtrl;
import controller.EditorPanelCtrl;
import controller.MouseMoveCtrl;
import entity.Board;
import entity.Bullpen;
import entity.Level;
import entity.LightningLevel;
import entity.Piece;
import entity.PieceTile;
import entity.PuzzleLevel;
import move.IMove;
import serializers.Serializer;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 * View for a lightning level within the Builder.
 * 
 *
 */
public class BuilderLightningLevel extends BuilderLevel {
	KabasujiBuilderFrame kFrame;
	
	BoardPanel boardPanel;
	Board board;
	BullpenView  bullpen;
	PieceContainer container;
	JLabel movesLabel;
	
	LightningLevel level;
	
	/**
	 * Create the panel fo the Lightning Level in the Builder.
	 * @param frame
	 */
	public BuilderLightningLevel(KabasujiBuilderFrame frame) {
		container = frame.getPieceContainer();
		container.setVisible(false); 
		add(container);
		kFrame = frame;
		
		int timeRemaining = 10;
		level = new LightningLevel(timeRemaining, kFrame.workingBoard, new Bullpen(), false, 1, 0);
		
		setBackground(Color.GRAY);
		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		boardPanel = new BoardPanel(new Board(null, 12, 12));
		boardPanel.setBounds(25, 400, 600, 300);
		boardPanel.addMouseListener(new BoardCtrl(boardPanel, this));
		boardPanel.addMouseMotionListener(new MouseMoveCtrl(this));
		boardPanel.addMouseListener(new MouseMoveCtrl(this));
		add(boardPanel);
		
		Bullpen b = new Bullpen();
		bullpen = new BullpenView(b, this);
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
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				container.setDraggingPiece(null);
				container.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(650, 600, 100, 100);
		btnNewButton_1.addMouseMotionListener(new MouseMoveCtrl(this));
		btnNewButton_1.addMouseListener(new MouseMoveCtrl(this));
		add(btnNewButton_1);
		
		movesLabel = new JLabel("TIME REMAINING: " + timeRemaining);
		movesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		movesLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		movesLabel.setBounds(275, 336, 350, 57);
		add(movesLabel);
		
		JButton btnMenu = new JButton("SAVE");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Object[] options = { "1", "2", "3", "4", "5" };
				String s = (String) JOptionPane.showInputDialog(null, "Please choose a level ID to overwrite:", "Save",
						JOptionPane.PLAIN_MESSAGE, null, options, "1");
				if (s != null) {
					//clear board and add pieces back to bullpen
					ArrayList<Piece> temp = boardPanel.getBoard().pieces;
					for(int i = 0; i<temp.size(); i++){
						bullpen.getBullpen().addPiece(temp.get(i));
					}
					boardPanel.clearBoard();
					
					int id = Integer.parseInt(s);
					level = new LightningLevel(level.getTimeRemaining(), boardPanel.getBoard(), bullpen.getBullpen(),
							level.isUnlocked(), id, 0);
					new Serializer().serializeLevel(level);
					JOptionPane.showMessageDialog(null, "Level " + id + " has been successfully saved.");
				}
				else {
					JOptionPane.showMessageDialog(null, "Level saving has been cancelled.");
				}
				
				level = new LightningLevel(level.getTimeRemaining(), boardPanel.getBoard(), bullpen.getBullpen(), level.isUnlocked(), level.getLevelNum(), 0);
				new Serializer().serializeLevel(level);
			}
		});
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
		
		EditorPanel editorPanel = new EditorPanel(kFrame, this);
		panel_1.add(editorPanel);
		scrollPane.addMouseMotionListener(new MouseMoveCtrl(this));
		scrollPane.addMouseListener(new MouseMoveCtrl(this));
		//Nick added
		for(int i = 0; i < editorPanel.getPieces().length; i++){
			editorPanel.getPieceViews()[i].addMouseListener(new EditorPanelCtrl(editorPanel.getPieceViews()[i], this));
		}
		editorPanel.addMouseMotionListener(new MouseMoveCtrl(this));
		editorPanel.addMouseListener(new MouseMoveCtrl(this));
		
		
		JButton btnUndo = new JButton("UNDO");
		btnUndo.setBounds(25, 366, 89, 23);
		btnUndo.addMouseMotionListener(new MouseMoveCtrl(this));
		btnUndo.addMouseListener(new MouseMoveCtrl(this));
		btnUndo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				//do nothing if there is nothing to undo
				if(moves.size() <= 0)
					return;
				
				//pop move and undo
				IMove move = popMove();
				//add to redo stack
				pushRedo(move);
				//do the undo
				move.undo();
				//repaint
				boardPanel.revalidate();
				bullpen.revalidate();
				boardPanel.setRepaintValid();
				bullpen.setRepaintValid();
			}
			
			@Override
			public void mouseReleased(MouseEvent me){
				boardPanel.revalidate();
				bullpen.revalidate();
				boardPanel.setRepaintValid();
				bullpen.setRepaintValid();
			}
		});
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
		
		final JTextField textField = new JTextField("Enter Time", 30);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText() != null && textField.getText() != "") {
					try {
						int input = Integer.parseInt(textField.getText());
						if (input > 0 && input < 1000) {
							level.changeTimeRemaining(input);
							movesLabel.setText("TIME REMAINING: " + level.getTimeRemaining());
							textField.setText("Enter Time");
						} else if (input > 999) {
							level.changeTimeRemaining(999);
							movesLabel.setText("TIME REMAINING: " + level.getTimeRemaining());
							textField.setText("Enter time");
						} else {
							textField.setText("Enter time");
						}
					} catch (NumberFormatException ex) {
						textField.setText("Enter time");
					}
				}
			}
		});
		textField.setBounds(635, 336, 112, 27);
		textField.addMouseMotionListener(new MouseMoveCtrl(this));
		textField.addMouseListener(new MouseMoveCtrl(this));
		add(textField);
		
		JButton button_3 = new JButton("RESET");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boardPanel.clearBoard();
				bullpen.removeAll();
				boardPanel.revalidate();
				bullpen.revalidate();
				boardPanel.setRepaintValid();
				bullpen.setRepaintValid();
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
	
	/**
	 * Set the board for this level.
	 * @param b Given {@link Board} given board to set. 
	 */
	void setBoard(Board b) {
		remove(boardPanel);
		boardPanel = new BoardPanel(b);
		boardPanel.setBounds(25, 400, 600, 300);
		boardPanel.addMouseListener(new BoardCtrl(boardPanel, this));
		boardPanel.addMouseMotionListener(new MouseMoveCtrl(this));
		boardPanel.addMouseListener(new MouseMoveCtrl(this));
		add(boardPanel);
		boardPanel.repaint();
	}
	
	/**
	 * get the container that holds currently dragged pieces.
	 * @return The container which holds pieces being dragged within this level.
	 */
	public PieceContainer getPieceContainer(){
		return container;
	}
	
	/**
	 * Get the view for the {@link Bullpen} of this {@link Level}.
	 * @return The {@link BullpenView}.
	 */
	public BullpenView getBullpenView(){
		return bullpen;
	}
	
	/**
	 * Get the view for the {@link Board} in this {@link Level}.
	 * @return The {@link BoardPanel} for the board.
	 */
	public BoardPanel getBoardPanel(){
		return boardPanel;
	}
	
	/**
	 * Get the {@link Level} that is represented by this view.
	 * @return The represented {@link Level}
	 */
	public Level getLevel() {
		return level;
	}
}
