package entity;

import java.awt.Component;
import java.awt.Container;

import GUI.BoardPanel;
import GUI.BuilderPuzzleLevel;
import GUI.BullpenView;
import GUI.KabasujiBuilderFrame;
import GUI.PieceContainer;
import controller.DragCtrl;
import controller.MouseMoveCtrl;
import junit.framework.TestCase;

public class TestBuilder extends TestCase {
	KabasujiBuilderFrame kFrame;
	Board board;
	BoardPanel bv;
	PuzzleLevel puzzle;
	BuilderPuzzleLevel bpl;
	Bullpen bp;
	Piece piece;
	PieceContainer container;
	BullpenView bpv;

	public void setUp(){
		kFrame = new KabasujiBuilderFrame();
		
		piece = new Piece();
		for (int i = 0; i < 6; i++){
			piece.addTile(new PieceTile(), i, 0);
			piece.addTile(new PieceTile(), 0, 2); 
			piece.addTile(new PieceTile(), 1, 2); 
			piece.addTile(new PieceTile(), 2, 2);
			piece.addTile(new PieceTile(), 3, 2);
			piece.addTile(new PieceTile(), 4, 2);
			piece.addTile(new PieceTile(), 5, 2);
			piece.addTile(new PieceTile(), 5-i, 1);
			piece.addTile(new PieceTile(), 5-i, 3);
		}
		
		bp = new Bullpen();
		bp.addPiece(piece, 1);
		board = new Board(puzzle, 8, 8);
		puzzle = new PuzzleLevel(10, board, bp, false, 1, 0);
		bv = new BoardPanel(board);
	}
	
	public void testBuilderPuzzleLevel(){
		bpl = new BuilderPuzzleLevel(kFrame);
		bpl.setBoard(board);
		bpv = new BullpenView(bp, bpl);
	
		assertTrue(bv instanceof BoardPanel);
		assertTrue(bpl.getBullpenView() instanceof BullpenView);
		assertEquals(bpl.getPieceContainer(), kFrame.getPieceContainer());
		assertTrue(bpl.getLevel() instanceof PuzzleLevel);
	}
}
