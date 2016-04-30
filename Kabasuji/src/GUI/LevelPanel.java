
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
import javax.swing.Timer;

import controller.BoardCtrl;
import controller.DragCtrl;
import controller.LoadLevelCtrl;
import controller.MouseMoveCtrl;
import controller.PieceInBullpenCtrl;
import entity.Board;
import entity.Bullpen;
import entity.Level;
import entity.LevelType;
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
	JButton nextLvlBtn;
	Timer timer;
	
	PieceContainer container;
	/**
	 * Create the panel. 
	 */
	public LevelPanel(KabasujiFrame frame, final Level l) {	
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
		board.addMouseListener(new BoardCtrl(board, this));
		board.setBounds(25, 400, 308, 308);
		board.getBoard().setLevel(l);
		add(board);
		
		bullpen = new BullpenView(l.getBullpen(),this); 
		bullpen.setBounds(25, 25, 600, 300);
		//add adapter to each piece in bullpen to handle a drag within the level panel
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
		
		JButton trashBtn = new JButton("TRASH");
		trashBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean b = container.isVisible();
				if(!b){
					
				}
			}
		});
		trashBtn.setBounds(650, 564, 100, 100);
		//this makes the drag smoother
		trashBtn.addMouseMotionListener(new MouseMoveCtrl(this));
		trashBtn.addMouseListener(new MouseMoveCtrl(this));
		add(trashBtn);
		
		//Change here(condensed all level view into one)
		if(l instanceof PuzzleLevel)
			infoLabel = new JLabel("MOVES LEFT: " + ((PuzzleLevel) l).getMovesRemaining());
		else if( l instanceof LightningLevel){
			infoLabel = new JLabel("Time Left: " + ((LightningLevel) l).getTimeRemaining());
			
			//set a timer
			timer = new Timer(1000, new ActionListener() {
				//Codes runs every one second
				public void actionPerformed(ActionEvent e) {
					if(!l.hasWon() && ((LightningLevel) l).getTimeRemaining() > 0){//update timer if game has been won
						//get the time remaining
						int remaining = ((LightningLevel) l).getTimeRemaining();
						//update time
						((LightningLevel) l).decrementTimeRemaining();
						//update the panel for the timer
						repaint();
					}
				}
			});
			timer.setInitialDelay(1000);
			timer.start();
		}
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
				boolean b = container.isVisible();
				if(!b)
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
		
		nextLvlBtn = new JButton("Next Level");
		nextLvlBtn.addActionListener(new LoadLevelCtrl(l.getLevelType(), kFrame, l.getLevelNum() + 1));
		nextLvlBtn.setBounds(650, 675, 100, 36);
		nextLvlBtn.setVisible(false);
		add(nextLvlBtn);
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//update stars accordingly
		if(threeStar)
			star3.setText("Three star");
		else if(twoStar)
			star2.setText("Two star");
		else if(oneStar)
			star1.setText("One star");
		
		
		
		//update moves/time depending on the level type
		if(level instanceof PuzzleLevel)
			infoLabel.setText("MOVES LEFT: " + ((PuzzleLevel) level).getMovesRemaining());
		else if(level instanceof LightningLevel)
			infoLabel.setText("Time Left: " + ((LightningLevel) level).getTimeRemaining());
		else
			infoLabel.setText("Moves: " + ((ReleaseLevel) level).getNumMoves());
	}
	/**
	 * Method that updates the status of a level.
	 */
	public void updateLevel(){
		level.hasWon();
		//update stars
		level.updateStars();
		
		switch(level.getStars()){
		case 3:
			threeStar = true;
			break;
		case 2:
			twoStar = true;
			break;
		case 1:
			oneStar = true;
			//player can move on to next level if they choose
			nextLvlBtn.setVisible(true);
			break;
		default:
			break;
		}
		
		repaint();
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
	
	public Level getLevel(){
		return level;
	}
}



