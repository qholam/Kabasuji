package entity;

import GUI.KabasujiBuilderFrame;
import GUI.KabasujiFrame;
import GUI.PieceContainer;
import junit.framework.TestCase;


public class TestGame extends TestCase {
	KabasujiGame game;
	KabasujiBuilder builder;
	KabasujiBuilderFrame bframe;
	KabasujiFrame gf, testFrame;
	PieceContainer pc;
	Board board;
	PuzzleLevel puzzle;
	Piece piece;
	PieceTile[] pieceTiles = new PieceTile[6];
	Bullpen bullpen;
	
	protected void setUp() {
		game = new KabasujiGame();
		pc = new PieceContainer();
		builder = new KabasujiBuilder();
		piece = new Piece();
		for (int i = 0; i < 6; i++){
			pieceTiles[i] = new PieceTile();
			piece.addTile(pieceTiles[i], i, 0);
		}

		bullpen = new Bullpen();
		bullpen.addPiece(piece, 1);
		board = new Board(puzzle, 5, 5);
		puzzle = new PuzzleLevel(5, board, bullpen, true, 1, 1);
		//gf = new KabasujiGame().getFrame();//game.getFrame();
	}
	
	public void testGame(){
		assertEquals(game.getContainer(), null);
		game.setContainer(pc);
		assertEquals(game.getContainer(), pc);
	}
	
	
}
