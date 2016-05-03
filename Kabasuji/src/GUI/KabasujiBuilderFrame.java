package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Board;
import entity.Level;
import entity.LevelType;
import entity.LightningLevel;
import entity.Piece;
import entity.PieceTile;
import entity.PuzzleLevel;

import java.awt.CardLayout;

public class KabasujiBuilderFrame extends JFrame {
	final String SplashScreen = "BuilderSplashScreen";
	final String BuilderMainMenu = "BuilderMainMenu";
	final String Puzzle1 = "Puzzle1";
	final String BuilderLevelTypeSelect = "BuilderLevelTypeSelect";
	final String SpecifyBoardProperties = "SpecifyBoardProperties";
	final String BuilderPuzzleLevel = "BuilderPuzzleLevel";
	final String BuilderLightningLevel = "BuilderLightningLevel";
	public LevelType levelType;


	private JPanel contentPane;
	
	Board workingBoard;
	BuilderLevel workingLevel;
	PieceContainer container;
	
	Piece[] pieces = new Piece[35];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					KabasujiBuilderFrame frame = new KabasujiBuilderFrame();
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
	public KabasujiBuilderFrame() {
		container = new PieceContainer();
		workingBoard = new Board(null, 12,12);
		initPieces();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		
		BuilderSplashScreen splash = new BuilderSplashScreen(this);
		
		BuilderMainMenuPanel mainMenu = new BuilderMainMenuPanel(this);
		mainMenu.setBounds(0, 0, 800, 800);
		contentPane.add(mainMenu, BuilderMainMenu);
		
		BuilderLevelTypeSelect levelTypeSelect = new BuilderLevelTypeSelect(this);
		levelTypeSelect.setBounds(0, 0, 1200, 800);
		contentPane.add(levelTypeSelect, BuilderLevelTypeSelect);
		
		SpecifyBoardPropertiesView specifyBoard = new SpecifyBoardPropertiesView(this);
		specifyBoard.setBounds(0, 0, 1200, 800);
		contentPane.add(specifyBoard, SpecifyBoardProperties);
		
		//Added by nick
		//CHANGE FOR LIGHTNING
		//workingLevel=new BuilderPuzzleLevel(this);
		//workingLevel.setBounds(0, 0, 1200, 800);
		//contentPane.add(workingLevel, BuilderPuzzleLevel);
		
		splash.displaySplashScreen();
	}
	
	public CardLayout getCardLayout() {
		return (CardLayout)contentPane.getLayout();
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}
	
	public void setWorkingBoard(Board b) {
		workingBoard = b;
		/**
		if (b.getLevel() instanceof LightningLevel){
			workingLevel = (BuilderLightningLevel) workingLevel;
		}
		if (b.getLevel() instanceof PuzzleLevel){
			workingLevel = (BuilderPuzzleLevel) workingLevel;
		}
		*/
		workingLevel.setBoard(b);
		workingLevel.repaint(); 
	}

	public PieceContainer getPieceContainer(){
		return container;
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
					p.addTile(new PieceTile(), b, a);
				}
				num++;
			}
		}
		return p;
	}

	public Board getBoard() {
		// TODO Auto-generated method stub
		return this.workingBoard;
	}
}
