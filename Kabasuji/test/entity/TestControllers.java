package entity;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import GUI.BoardPanel;
import GUI.BuilderPuzzleLevel;
import GUI.BullpenView;
import GUI.KabasujiBuilderFrame;
import GUI.KabasujiFrame;
import GUI.LevelPanel;
import GUI.MainMenuPanel;
import GUI.PieceContainer;
import GUI.SpecifyBoardPropertiesView;
import controller.BoardCtrl;
import controller.DragCtrl;
import controller.EditorPanelCtrl;
import controller.HorizontalFlipCtrl;
import controller.LoadLevelCtrl;
import controller.MouseMoveCtrl;
import controller.PieceInBullpenCtrl;
import controller.RotateClockwiseCtrl;
import controller.RotateCounterClockwiseCtrl;
import controller.SpecifyBoardCtrl;
import controller.VerticalFlipCtrl;
import junit.framework.TestCase;
import view.PieceView;
import view.TileView;

public class TestControllers extends TestMouse {
	
	KabasujiGame game;
	KabasujiFrame kFrame;
	KabasujiBuilderFrame bFrame, rbFrame;
	Piece piece, p, piece2;
	PieceView pv;
	PieceTile[] pieceTiles = new PieceTile[6];
	Bullpen bp, bp2;
	BullpenView bpv;
	PieceInBullpenCtrl bpc;
	ArrayList<Piece> bpArray;
	Board board, rb;
	BoardPanel boardPanel, boardPanel2;
	BoardCtrl bc;
	MouseEvent pr, re;
	PuzzleLevel pl;
	ReleaseLevel rl;
	LevelPanel lp, rlp, blp;

	
	public void setUp(){
		
	piece = new Piece();
	for (int i = 0; i < 6; i++){
		pieceTiles[i] = new PieceTile();
		piece.addTile(pieceTiles[i], i, 0);
		}
	pv = new PieceView(piece);
	piece2 = piece;
	bp2 = new Bullpen();
	bp2.addPiece(piece, 1);
	board = new Board(pl, 10, 10);
	rb = new Board(rl, 10, 10);
	boardPanel = new BoardPanel(board);
	boardPanel2 = new BoardPanel(rb);
	rl = new ReleaseLevel(board, bp2, true, 1, 1);
	rb.setLevel(rl);
	pl = new PuzzleLevel(5, board, bp2, true, 1, 1);
	kFrame = new KabasujiFrame();
	rlp = new LevelPanel(kFrame, rl);
	lp = new LevelPanel(kFrame, pl);
	}

	public void testVerticalFlip(){
		bpArray = new ArrayList<Piece>();
		bpArray.add(piece);
		bp = new Bullpen(bpArray);
		bpv = new BullpenView(bp, lp);
		bpc = new PieceInBullpenCtrl(bpv, pv);
		VerticalFlipCtrl VFC = new VerticalFlipCtrl(bpv);
		pr = createRightClick(bpv, 18, 132);
		bpc.mousePressed(pr);
		pr = createClicked(bpv, 102, 29);
		VFC.mousePressed(pr);
		VFC.mouseReleased(pr);
		p = bpc.getPieceView().getPiece();
		assertEquals(piece, p);
		
	}
	public void testHorizantalFlip(){
		bpArray = new ArrayList<Piece>();
		bpArray.add(piece);
		bp = new Bullpen(bpArray);
		bpc = new PieceInBullpenCtrl(bpv, pv);
		bpv = new BullpenView(bp, lp);
		HorizontalFlipCtrl HFC = new HorizontalFlipCtrl(bpv);
		pr = createRightClick(bpv, 18, 132);
		bpc.mousePressed(pr);
		pr = createClicked(bpv, 90, 12);
		HFC.mousePressed(pr);
		HFC.mouseReleased(pr);
		p = bpc.getPieceView().getPiece();
		piece.horizontalFlip();
		assertEquals(piece, p);
	}
	
	public void testRotateCounterClockwise(){
		bpArray = new ArrayList<Piece>();
		bpArray.add(piece);
		bp = new Bullpen(bpArray);
		bpc = new PieceInBullpenCtrl(bpv, pv);
		bpv = new BullpenView(bp, lp);
		RotateCounterClockwiseCtrl RCC = new RotateCounterClockwiseCtrl(bpv);
		pr = createRightClick(bpv, 18, 132);
		bpc.mousePressed(pr);
		pr = createPressed(bpv, 45, 32);
		RCC.mousePressed(pr);
		RCC.mouseReleased(pr);
		p = bpc.getPieceView().getPiece();
		piece.rotateCounterclockwise();
		assertEquals(piece, p);
		
	}
	
	public void testRotateClockwise(){
		bpArray = new ArrayList<Piece>();
		bpArray.add(piece);
		bp = new Bullpen(bpArray);
		bpv = new BullpenView(bp, lp);
		bpc = new PieceInBullpenCtrl(bpv, pv);
		RotateClockwiseCtrl RC = new RotateClockwiseCtrl(bpv);
		pr = createRightClick(bpv, 18, 132);
		bpc.mousePressed(pr);;
		pr = createPressed(bpv, 102, 19);
		RC.mousePressed(pr);
		RC.mouseReleased(pr);
		p = bpc.getPieceView().getPiece();
		piece.rotateClockwise();
		assertEquals(piece, p);
	}
	
	public void testMoveMouseCtrl(){
		bpv = new BullpenView(bp2, lp);
		bpc = new PieceInBullpenCtrl(bpv, pv);
		MouseMoveCtrl MMC = new MouseMoveCtrl(lp);
		pr = createClicked(bpv, 18, 132);
		bpc.mousePressed(pr);
		pr = mouseMoved(bpv, 643, 148);
		MMC.mouseMoved(pr);
		pr = createClicked(bpv, 643, 132);
		MMC.mousePressed(pr);
		p = bpc.getPieceView().getPiece();
		assertTrue(p != null);
	}

	public void testDragCtrl(){
		bpv = new BullpenView(bp2, lp);
		bpc = new PieceInBullpenCtrl(bpv, pv);
		DragCtrl dc = new DragCtrl(pv, lp);
		bc = new BoardCtrl(boardPanel, lp);
		pr = createClicked(bpv, 18, 132);
		dc.mousePressed(pr);
		re = createClicked(boardPanel, 15, 21);
		dc.mouseReleased(re);
		//bc.mouseReleased(re);
		p = bc.getBoardView().getBoard().getPieceAt(0, 0);
		//assertEquals(lp.getPieceContainer().getDraggingPiece(), pv);
	}

	public void testSpecifyBoardCtrl(){
		bFrame = new KabasujiBuilderFrame();
		boardPanel = new BoardPanel(bFrame.getBoard());
		SpecifyBoardPropertiesView properties = new SpecifyBoardPropertiesView(bFrame);
		SpecifyBoardCtrl sbc = new SpecifyBoardCtrl(properties, boardPanel);
		re = createPressed2(boardPanel, 140, 141);
		sbc.mouseClicked(re);
		//TileView c = boardPanel.getClickedTile(re);
		sbc.mousePressed(re);
		sbc.mousePressed(re);
		re = createRightClick2(boardPanel, 140, 141);
		//sbc.mousePressed(re);
		
		rbFrame = new KabasujiBuilderFrame();
		boardPanel2 = new BoardPanel(rb);
		SpecifyBoardPropertiesView rproperties = new SpecifyBoardPropertiesView(rbFrame);
		SpecifyBoardCtrl rsbc = new SpecifyBoardCtrl(rproperties, boardPanel2);
		re = createPressed2(boardPanel2, 140, 141);
		sbc.mousePressed(re);
		sbc.mousePressed(re);
		re = createRightClick2(boardPanel2, 140, 141);
		//sbc.mousePressed(re);
	}

	public void testLoadLevelCtrl(){
		LoadLevelCtrl LLC = new LoadLevelCtrl(LevelType.Puzzle, kFrame, 1);
		LoadLevelCtrl LLC2 = new LoadLevelCtrl(LevelType.Puzzle, kFrame, 6);
		LoadLevelCtrl LLC3 = new LoadLevelCtrl(LevelType.Lightning, kFrame, 1);
		LoadLevelCtrl LLC4 = new LoadLevelCtrl(LevelType.Release, kFrame, 1);
		LoadLevelCtrl LLC5 = new LoadLevelCtrl(LevelType.Lightning, kFrame, 6);
		LoadLevelCtrl LLC6 = new LoadLevelCtrl(LevelType.Release, kFrame, 6);
		
		MainMenuPanel MMP = new MainMenuPanel(kFrame);
		LLC.actionPerformed(MMP.button);
		LLC2.actionPerformed(MMP.button);
		LLC3.actionPerformed(MMP.button);
		LLC4.actionPerformed(MMP.button);
		LLC5.actionPerformed(MMP.button);
		LLC6.actionPerformed(MMP.button);
	}
	
	public void testBoardCtrl(){
		bpArray = new ArrayList<Piece>();
		bpArray.add(piece);
		bp = new Bullpen(bpArray);
		bpv = new BullpenView(bp, lp);
		BoardCtrl BC = new BoardCtrl(boardPanel, lp);
		//lp.getPieceContainer().setVisible(false);
		PieceContainer PC = new PieceContainer();
		PC.setDraggingPiece(piece);
		PC.setSource(lp);
		pr = createRightClick(boardPanel, 74, 44);
		BC.mousePressed(pr);
		BC.mouseReleased(pr);
		pr = createClicked(boardPanel, 74, 44);
		BC.mousePressed(pr);
		BC.mouseReleased(pr);
	}
	public void testEditorPanelCtrl(){
		bFrame = new KabasujiBuilderFrame();
		BuilderPuzzleLevel BPL = new BuilderPuzzleLevel(bFrame);
		EditorPanelCtrl EPC = new EditorPanelCtrl(pv, BPL);
		bp = new Bullpen();
		bpv = new BullpenView(bp, BPL);
		pr = createClicked2(BPL, 29, 50);
		EPC.mousePressed(pr);
		assertEquals(EPC.getBullpenView().getBullpen().getPieces().size(), 1);
	}
	
	public void testPieceInBullpenCtrl(){
		bp = new Bullpen();
		bp.addPiece(piece);
		bpv = new BullpenView(bp, lp);
		PieceInBullpenCtrl PBC = new PieceInBullpenCtrl(bpv, pv);
		pr = createRightClick2(bpv, 18, 132);
		PBC.mousePressed(pr);
		PBC.mouseReleased(pr);
	}
	
}
