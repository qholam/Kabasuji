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
import entity.ReleaseLevel;

import java.awt.CardLayout;

/**
 * A JFrame class used to contain all of the information for the builder
 * application.
 * @author Richard Hayes
 *
 */
public class KabasujiBuilderFrame extends JFrame {
	final String SplashScreen = "BuilderSplashScreen";
	final String BuilderMainMenu = "BuilderMainMenu";
	final String Puzzle1 = "Puzzle1";
	final String BuilderLevelTypeSelect = "BuilderLevelTypeSelect";
	public final String SpecifyBoardProperties = "SpecifyBoardProperties";
	public final String BuilderPuzzleLevel = "BuilderPuzzleLevel";
	public final String BuilderLightningLevel = "BuilderLightningLevel";
	public final String BuilderReleaseLevel = "BuilderReleaseLevel";
	final String LevelSelect = "LevelSelect";
	public LevelType levelType;



	JPanel contentPane;
	
	public Board workingBoard;
	public BuilderLevel workingLevel;
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
	
	/**
	 * Gets the cardLayout used in this frame.
	 * @return The cardLayout used in this frame.
	 */
	public CardLayout getCardLayout() {
		return (CardLayout)contentPane.getLayout();
	}
	
	/**
	 * Gets the content pane used in this frame.
	 * @return The content pane used in this frame.
	 */
	public JPanel getContentPane() {
		return contentPane;
	}
	
	/**
	 * Sets the board that the builder is currently working with.
	 * @param b The board we want to work with.
	 */
	public void setWorkingBoard(Board b) {
		workingBoard = b;
		workingLevel.setBoard(b);
		workingLevel.repaint(); 
	}

	/**
	 * Gets the container that is used to move pieces in the builder.
	 * @return The container used to move pieces in the builder.
	 */
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

	/**
	 * Returns the board that the builder is currently working with.
	 * @return The board that the builder is currently working with.
	 */
	public Board getBoard() {
		// TODO Auto-generated method stub
		return this.workingBoard;
	}
}
