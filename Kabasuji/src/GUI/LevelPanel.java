
package GUI;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;

import controller.DragCtrl;
import controller.MouseMoveCtrl;
import controller.PieceInBullpenCtrl;
import entity.Board;
import entity.Bullpen;
import entity.Level;
import entity.LightningLevel;
import entity.Piece;
import entity.PieceTile;
import entity.PuzzleLevel;
import entity.ReleaseLevel;
import entity.Tile;
import entity.TileType;
import serializers.Deserializer;
import view.PieceView;
import view.TileView;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LevelPanel extends JPanel{
	KabasujiFrame kFrame;
	//the level that this panel represents
	Level level;
	//booleans to keep track if the stars achieved
	boolean oneStar, twoStar, threeStar; 
	
	JLabel star1, star2, star3;
	JLabel infoLabel;
	BullpenView bullpen;
	BoardPanel board;
	
	PieceContainer container;
	/**
	 * Create the panel. 
	 */
	public LevelPanel(KabasujiFrame frame, Level l) {	
		container = frame.getPieceContainer();
		container.setVisible(false);
		add(container);
		kFrame = frame;
		level = l;
		
		oneStar = false; 
		twoStar = false;
		threeStar = false;
		
		setBackground(Color.GRAY);
		setLayout(null); 
		setBounds(0, 0, 800, 800);
		
		board = new BoardPanel(l.getBoard());
		
		board.addMouseMotionListener(new MouseMoveCtrl(this));
		board.addMouseListener(new MouseAdapter(){
			@Override
	        public void mouseClicked(MouseEvent me){
	        	System.out.println("hi");
	        }
		});
		board.setBounds(25, 400, 600, 300);
		add(board);
		
		bullpen = new BullpenView(l.getBullpen());
		bullpen.setBounds(25, 25, 600, 300);
		//add adapter to each piece in bullpen to handle a drag within the level panel
		for(int i = 0; i < bullpen.getBullpen().getPieces().size(); i++){
			//add controllers to handle dragging a piece over other pieces
			bullpen.getPieceViews().get(i).addMouseMotionListener(new MouseMoveCtrl(this));
			bullpen.getPieceViews().get(i).addMouseListener(new MouseMoveCtrl(this));
			
			//controller to handle the dragging
			new DragCtrl().handleDrag(bullpen.getPieceViews().get(i), this);
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
		
		JButton trashBtn = new JButton("TRASH");
		trashBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		trashBtn.setBounds(650, 600, 100, 100);
		//this makes the drag smoother
		trashBtn.addMouseMotionListener(new MouseMoveCtrl(this));
		trashBtn.addMouseListener(new MouseMoveCtrl(this));
		add(trashBtn);
		
		//Change here(condensed all level view into one)
		if(l instanceof PuzzleLevel)
			infoLabel = new JLabel("MOVES LEFT: " + ((PuzzleLevel) l).getMovesRemaining());
		else if( l instanceof LightningLevel)
			infoLabel = new JLabel("Time Left: " + ((LightningLevel) l).getTimeRemaining());
		else
			infoLabel = new JLabel("Moves: 0");
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		infoLabel.setBounds(25, 336, 600, 57);
		add(infoLabel);
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.setBounds(650, 25, 100, 100);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.MainMenu);
			}
		});
		//this makes the drag smoother
		btnMenu.addMouseMotionListener(new MouseMoveCtrl(this));
		btnMenu.addMouseListener(new MouseMoveCtrl(this));
		add(btnMenu);
		
		JPanel panel = new JPanel();
		panel.setBounds(650, 186, 100, 353);
		add(panel);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		star3 = new JLabel("---");
		star3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(star3);
		
		star2 = new JLabel("---");
		star2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(star2);
		
		star1 = new JLabel("---");
		star1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(star1);
		
		//handles the dragging of an object, this makes the drag smoother
		this.addMouseMotionListener(new MouseMoveCtrl(this));
		this.addMouseListener(new MouseMoveCtrl(this));
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//update stars accordingly
		if(oneStar)
			star1.setText("One star");
		if(twoStar)
			star2.setText("Two star");
		if(threeStar)
			star3.setText("Three star");
		
		//update moves/time depending on the level type
		if(level instanceof PuzzleLevel)
			infoLabel.setText("MOVES LEFT: " + ((PuzzleLevel) level).getMovesRemaining());
		else if(level instanceof LightningLevel)
			infoLabel = new JLabel("Time Left: " + ((LightningLevel) level).getTimeRemaining());
		else
			infoLabel = new JLabel("Moves: " + ((ReleaseLevel) level).getNumMoves());
	}
	
	public PieceContainer getPieceContainer(){
		return container;
	}
	
	public BullpenView getBullpenView(){
		return bullpen;
	}
	
	public BoardPanel getBoardPanel(){
		return board;
	}
}



