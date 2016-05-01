package entity;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import GUI.BoardPanel;
import GUI.BullpenView;
import GUI.LevelPanel;
import controller.HorizontalFlipCtrl;
import controller.PieceInBullpenCtrl;
import controller.RotateClockwiseCtrl;
import controller.RotateCounterClockwiseCtrl;
import controller.VerticalFlipCtrl;
import junit.framework.TestCase;
import view.PieceView;

public class TestControllers extends TestMouse {
	
	KabasujiGame game;
	Piece piece, p, piece2;
	PieceView pv;
	PieceTile[] pieceTiles = new PieceTile[6];
	Bullpen bp;
	BullpenView bpv;
	PieceInBullpenCtrl bpc;
	ArrayList<Piece> bpArray;
	Board board;
	BoardPanel boardPanel;
	MouseEvent pr, re;
	LevelPanel lp;

	
	public void setUp(){
		
	piece = new Piece();
	for (int i = 0; i < 6; i++){
		pieceTiles[i] = new PieceTile();
		piece.addTile(pieceTiles[i], i, 0);
		}
	pv = new PieceView(piece);
	piece2 = piece;
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
		p = bpc.getPieceView().getPiece();
		assertEquals(piece, p);
		
		/*
		MouseEvent me = new MouseEvent(bp., MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				10, 10, 0, false);
		VFC.mouseClicked(me);
		*/
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
		p = bpc.getPieceView().getPiece();
		piece.rotateClockwise();
		assertEquals(piece, p);
	}
	
	
	
	
}
