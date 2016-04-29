package entity;

import java.awt.Color;
import java.util.ArrayList;

import junit.framework.TestCase;
import move.BoardToBoardMove;
import move.BullpenToBoardMove;

public class TestLevels extends TestCase {
	//Create elements for different levels
	Board lightningBoard, puzzleBoard, releaseBoard, board, puzzleBoard1;
	Bullpen bullpen, bullpen1;
	Piece piece;
	boolean unlocked;
	PieceTile[] pieceTiles = new PieceTile[6];
	int movesRemaining, timeRemaining, levelNum, stars, numRows, numColumns;
	
	//Create a Puzzle, Lightning, and Release Level
	PuzzleLevel puzzle, puzzle1; 
	LightningLevel lightning;
	ReleaseLevel release;
	Level level;
	
	
	Board puzzleBoard5, lightningBoard5;
	PuzzleLevel puzzle5;
	LightningLevel lightning5;
	Bullpen bullpen5, bullpen6;
	
	
	
	public void setUp(){ 
		movesRemaining = 1; 
		timeRemaining = 5;
		levelNum = 1;
		stars = 0;
		numRows = 6;
		numColumns = 1;
		unlocked = true;
		
		piece = new Piece();
		for (int i = 0; i < 6; i++){
			pieceTiles[i] = new PieceTile();
			piece.addTile(pieceTiles[i], i, 0);
		}

		bullpen = new Bullpen();
		bullpen.addPiece(piece, 1);
		bullpen1 = new Bullpen();
		bullpen1.addPiece(piece, 1);
		bullpen1.addPiece(piece, 1);
		
		lightningBoard = new Board(lightning, numRows, numColumns);
		puzzleBoard = new Board(puzzle, numRows, numColumns);
		releaseBoard = new Board(release, numRows, numColumns);
		board = new Board(level, numRows, numColumns);
		
		
		puzzle = new PuzzleLevel(movesRemaining, puzzleBoard, bullpen, unlocked, levelNum, stars);
		lightning = new LightningLevel(timeRemaining, lightningBoard, bullpen, unlocked, levelNum, stars);
		release = new ReleaseLevel(releaseBoard, bullpen, unlocked, levelNum, stars);
		level = new Level(board, bullpen, unlocked, levelNum, stars);
		
		bullpen5 = new Bullpen();
		bullpen5.addPiece(piece);
		bullpen5.addPiece(piece);
		puzzleBoard5 = new Board(puzzle5, 10, 10);
		puzzle5 = new PuzzleLevel(5, puzzleBoard5, bullpen5, unlocked, levelNum, stars);
		
		lightning5 = new LightningLevel(timeRemaining, lightningBoard5, bullpen5, unlocked, levelNum, stars);
		lightningBoard5 = new Board(lightning5, 10, 10);
		bullpen6 = new Bullpen();
		bullpen6.addPiece(piece);
		bullpen6.addPiece(piece);
	
	}
	
	/**
	 * Test Puzzle methods.
	 */
	public void testPuzzle(){
		assertEquals(puzzle.hasWon(), false);
		
		//move piece to board
		BullpenToBoardMove BPM = new BullpenToBoardMove(puzzleBoard, puzzle, piece ,bullpen, 0, 0);
		assertEquals(puzzle.doMove(BPM), true);
		
		assertEquals(puzzle.getMovesRemaining(), 0);
		assertEquals(puzzle.hasWon(), true);
		puzzle.updateStars();
		assertEquals(puzzle.getStars(), 3);
	}
	
	/**
	 * Test Lightning methods.
	 */
	public void testLightning(){
		assertEquals(lightning.hasWon(), false); 
		
		//move piece to board
		BullpenToBoardMove BLM = new BullpenToBoardMove(lightningBoard, lightning, piece, bullpen, 0, 0);
		assertEquals(lightning.doMove(BLM), true);
		assertEquals(lightning.getTimeRemaining(), 5); 
		lightning.updateStars();
		assertEquals(lightning.getStars(), 3);
		
	} 
	
	/**
	 * Test Release methods.
	 */
	public void testRelease(){
		assertEquals(release.hasWon(), false);
		
		for (int i = 0; i < 6; i++){
			releaseBoard.boardGrid[0][i] = new ReleaseTile(i, 0, new Number(i + 1, Color.red));
		}
		
		BullpenToBoardMove BRM = new BullpenToBoardMove(releaseBoard, release, piece, bullpen, 0, 0);
		assertEquals(release.doMove(BRM), true);
		assertEquals(release.getNumMoves(), 1);
		assertEquals(release.hasWon(), true);
	}
	
	/**
	 * Test general level methods
	 */
	public void testLevel(){
		assertEquals(level.isUnlocked(), true);
		assertEquals(level.getLevelNum(), 1);
		assertEquals(level.getStars(), 0);
		assertEquals(level.hasWon(), false);
		assertEquals(level.getBullpen(), bullpen);
		assertEquals(level.getBoard(), board);
		BullpenToBoardMove BPM = new BullpenToBoardMove(puzzleBoard, puzzle, piece ,bullpen, 0, 0);
		assertEquals(level.doMove(BPM), false);
		assertEquals(level.getLevelType(), null);
	}

	/**
	 * Test toString methods for all levels
	 */
	public void testToString(){
		assertEquals(puzzle.toString(), "Puzzle1");
		assertEquals(lightning.toString(), "Lightning1");
		assertEquals(release.toString(), "Release1");
		
	}
	
	/**
	 * Test board methods
	 */
	public void testBoard(){
		puzzleBoard1 = new Board(puzzle1, numRows, numColumns);
		puzzle1 = new PuzzleLevel(movesRemaining, puzzleBoard1, bullpen1, unlocked, levelNum, stars);
		BullpenToBoardMove BPM = new BullpenToBoardMove(puzzleBoard1, puzzle1, piece ,bullpen1, 0, 0);
		puzzle1.doMove(BPM);
		assertEquals(puzzleBoard1.getPieceAt(0, 0), piece);
		assertEquals(puzzleBoard1.removePieceAt(0, 0), piece);
		puzzle1.doMove(BPM);
		//puzzleBoard1.removePiece(piece);
		//assertEquals(puzzleBoard1.pieces.size(), 0);
	}
	
	public void testBoardMove(){

		BullpenToBoardMove BPM = new BullpenToBoardMove(puzzleBoard5, puzzle5, piece ,bullpen5, 0, 0);
		puzzle5.doMove(BPM);
		BoardToBoardMove BBM = new BoardToBoardMove(puzzleBoard5, puzzle5, piece, 2, 2);
		puzzle5.doMove(BBM);
		assertEquals(puzzleBoard5.getPieceAt(2, 2), piece);
		
		/**
		BullpenToBoardMove BPM1 = new BullpenToBoardMove(lightningBoard5, lightning5, piece, bullpen6, 0, 0);
		lightning5.doMove(BPM1);
		BoardToBoardMove BBM1 = new BoardToBoardMove(lightningBoard5, lightning5, piece, 2, 2);
		lightning5.doMove(BBM1);
		assertEquals(lightningBoard5.getPieceAt(2, 2), piece);
		**/
	}
}
