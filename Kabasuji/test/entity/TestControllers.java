package entity;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import GUI.BoardPanel;
import GUI.BullpenView;
import controller.HorizontalFlipCtrl;
import controller.RotateClockwiseCtrl;
import controller.RotateCounterClockwiseCtrl;
import controller.VerticalFlipCtrl;
import junit.framework.TestCase;
import view.PieceView;

public class TestControllers extends TestCase {
	
	KabasujiGame game;
	Piece piece;
	PieceView pv;
	PieceTile[] pieceTiles = new PieceTile[6];
	Bullpen bp;
	BullpenView bpv;
	ArrayList<Piece> bpArray;
	Board board;
	BoardPanel boardPanel;
	MouseEvent pr, re;

	
	public void setUp(){
		
	piece = new Piece();
	for (int i = 0; i < 6; i++){
		pieceTiles[i] = new PieceTile();
		piece.addTile(pieceTiles[i], i, 0);
		}
	pv = new PieceView(piece);
	}
	
	public void testVerticalFlip(){
		bpArray = new ArrayList<Piece>();
		bpArray.add(piece);
		bp = new Bullpen(bpArray);
		bpv = new BullpenView(bp);
		VerticalFlipCtrl VFC = new VerticalFlipCtrl(bpv);
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
		bpv = new BullpenView(bp);
		HorizontalFlipCtrl HFC = new HorizontalFlipCtrl(bpv);
		HFC.mousePressed(pr);
	}
	
	public void testRotateCounterClockwise(){
		bpArray = new ArrayList<Piece>();
		bpArray.add(piece);
		bp = new Bullpen(bpArray);
		bpv = new BullpenView(bp);
		RotateCounterClockwiseCtrl RCC = new RotateCounterClockwiseCtrl(bpv);
		RCC.mousePressed(pr);
		
	}
	
	public void testRotateClockwise(){
		bpArray = new ArrayList<Piece>();
		bpArray.add(piece);
		bp = new Bullpen(bpArray);
		bpv = new BullpenView(bp);
		RotateClockwiseCtrl RC = new RotateClockwiseCtrl(bpv);
		RC.mousePressed(pr);
	}
	
	
	
	
}
