package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Board;
import entity.Bullpen;
import entity.Level;
import entity.LightningLevel;
import entity.Piece;
import entity.PieceTile;
import entity.PuzzleLevel;
import serializers.Deserializer;

import java.awt.CardLayout;

public class KabasujiFrame extends JFrame {
	final String SplashScreen = "SplashScreen";
	final String MainMenu = "MainMenu";
	final String Puzzle1 = "Puzzle1";
	public final String LevelPanel = "LevelPanel";
	final String LevelSelect = "LevelSelect";
	
	public final static int tileWidth = 24;
	public final static int tileHeight = 24;
	
	JPanel contentPane;
	PieceContainer container; 
	static Piece[] pieces = new Piece[35];

	/**
	 * Create the frame.
	 */
	public KabasujiFrame() {
		
		Deserializer deserializer =  new Deserializer();
		container = new PieceContainer(); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		
		SplashScreen splash = new SplashScreen(this);
		
		MainMenuPanel mainMenu = new MainMenuPanel(this);
		mainMenu.setBounds(0, 0, 800, 800);
		contentPane.add(mainMenu, MainMenu);
		
		initPieces();
		
		//to be remove this bullpen was made for testing
		Bullpen bp = new Bullpen();
		for (int i = 0; i < 6; i++) {
			bp.addPiece(createPiece(new int[]{
					1, 0, 0, 0, 0, 0,
					1, 0, 0, 0, 0, 0,
					1, 0, 0, 0, 0, 0,
					1, 0, 0, 0, 0, 0,
					1, 0, 0, 0, 0, 0,
					1, 0, 0, 0, 0, 0
					}));
		}
		
		//TOMMYCOMMENT to run either lightning comment out the creation of the puzzlelevel and uncomment the line that creates the lightning level
		Level l = new PuzzleLevel(30, new Board(null, 6, 6), bp, true, 1, 0);
		//Level l = new LightningLevel(20, new Board(null, 6, 6),bp, true, 1, 0);
		//LevelPanel puzzle1 = new LevelPanel(this, deserializer.deserialzePuzzleLevel(1));
		LevelPanel puzzle1 = new LevelPanel(this, l);
		contentPane.add(puzzle1, Puzzle1);
		
		/* TOMMYCOMMENT Drag does not redraw properly when this code is added.
		Level l2 = new LightningLevel(100, new Board(null, 6, 6),new Bullpen(), true, 1, 0);
		LevelPanel lightning1 = new LevelPanel(this, l2);
		contentPane.add(lightning1, Lightning1);
		*/
		
		LevelSelector levelSelect = new LevelSelector(this);
		levelSelect.setBounds(0, 0, 800, 800);
		contentPane.add(levelSelect, LevelSelect);
		
		splash.displaySplashScreen();
	}
	
	public CardLayout getCardLayout() {
		return (CardLayout)contentPane.getLayout();
	}
	
	public PieceContainer getPieceContainer(){
		return container;
	}
	
	public void addToContentPane(JPanel l, String s){
		contentPane.add(l, s);
	}
	
	/** Initializes all 35 Kabasuji Pieces from hardcoded int arrays.*/
	void initPieces() {
		/** Create all 35 Kabasuji Hexominos */ 
		pieces[0] = createPiece(new int[]{
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0
				});
		pieces[1] = createPiece(new int[]{
				1, 1, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[2] = createPiece(new int[]{
				0, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[3] = createPiece(new int[]{
				0, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 1, 1, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[4] = createPiece(new int[]{
				0, 0, 1, 1, 0, 0,
				1, 1, 1, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[5] = createPiece(new int[]{
				1, 1, 1, 0, 0, 0,
				0, 0, 1, 1, 1, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[6] = createPiece(new int[]{
				0, 1, 0, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[7] = createPiece(new int[]{
				0, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[8] = createPiece(new int[]{
				1, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 1, 1, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[9] = createPiece(new int[]{
				1, 1, 1, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[10] = createPiece(new int[]{
				0, 0, 1, 0, 0, 0,
				0, 0, 1, 0, 0, 0,
				0, 0, 1, 0, 0, 0,
				1, 1, 1, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[11] = createPiece(new int[]{
				1, 1, 0, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[12] = createPiece(new int[]{
				0, 1, 1, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[13] = createPiece(new int[]{
				0, 0, 1, 0, 0, 0,
				0, 1, 1, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[14] = createPiece(new int[]{
				1, 0, 0, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[15] = createPiece(new int[]{
				0, 1, 0, 0, 0, 0,
				1, 1, 1, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[16] = createPiece(new int[]{
				1, 0, 0, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[17] = createPiece(new int[]{
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 1, 1, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[18] = createPiece(new int[]{
				1, 1, 1, 0, 0, 0,
				0, 0, 1, 0, 0, 0,
				0, 0, 1, 1, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[19] = createPiece(new int[]{
				0, 1, 1, 1, 0, 0,
				1, 1, 1, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[20] = createPiece(new int[]{
				0, 0, 1, 0, 0, 0,
				1, 1, 1, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[21] = createPiece(new int[]{
				0, 1, 0, 0, 0, 0,
				1, 1, 1, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[22] = createPiece(new int[]{
				1, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[23] = createPiece(new int[]{
				0, 1, 0, 0, 0, 0,
				1, 1, 1, 0, 0, 0,
				1, 0, 1, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[24] = createPiece(new int[]{
				1, 1, 1, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[25] = createPiece(new int[]{
				1, 0, 0, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				1, 1, 1, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[26] = createPiece(new int[]{
				1, 1, 0, 0, 0, 0,
				0, 1, 1, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[27] = createPiece(new int[]{
				0, 0, 1, 0, 0, 0,
				0, 0, 1, 0, 0, 0,
				1, 1, 1, 0, 0, 0,
				0, 0, 1, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[28] = createPiece(new int[]{
				1, 0, 1, 1, 0, 0,
				1, 1, 1, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[29] = createPiece(new int[]{
				0, 0, 1, 0, 0, 0,
				1, 1, 1, 0, 0, 0,
				1, 0, 1, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[30] = createPiece(new int[]{
				1, 0, 0, 0, 0, 0,
				1, 1, 1, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[31] = createPiece(new int[]{
				0, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				1, 1, 1, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[32] = createPiece(new int[]{
				1, 0, 0, 0, 0, 0,
				1, 1, 1, 1, 0, 0,
				0, 0, 1, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[33] = createPiece(new int[]{
				0, 1, 0, 0, 0, 0,
				1, 1, 1, 1, 0, 0,
				0, 0, 1, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[34] = createPiece(new int[]{
				0, 0, 1, 0, 0, 0,
				0, 1, 1, 1, 0, 0,
				1, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
	}
	
	/** Creates a new piece as defined by an int array.
	 * (Mainly meant for use by initPieces method).
	 * @param tileIntArray An array of ints that defines the shape of a piece in 0s and 1s.
	 * @return The new piece created by this function.
	 */
	Piece createPiece(int[] tileIntArray) {
		Piece p = new Piece();
		int num = 0;
		for (int a = 0; a < 6; a++) {
			for (int b = 0; b < 6; b++) {
				if (tileIntArray[num] == 1) {
					p.addTile(new PieceTile(), a, b);
				}
				num++;
			}
		}
		return p;
	}
	
	public static Piece getPiece(int n){
		return pieces[n];
	}
}
