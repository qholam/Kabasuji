package entity;

import java.awt.Color;
import java.util.ArrayList;

import junit.framework.TestCase;
import move.BullpenToLightningBoardMove;
import move.BullpenToPuzzleBoardMove;
import move.BullpenToReleaseBoardMove;

public class TestLevels extends TestCase {
	//Create elements for different levels
	Board lightningBoard, puzzleBoard, releaseBoard, board;
	Bullpen bullpen;
	Piece piece;
	boolean unlocked;
	PieceTile[] pieceTiles = new PieceTile[6];
	int movesRemaining, timeRemaining, levelNum, stars, numRows, numColumns;
	
	//Create a Puzzle, Lightning, and Release Level
	PuzzleLevel puzzle; 
	LightningLevel lightning;
	ReleaseLevel release;
	Level level;
	
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
		
		lightningBoard = new Board(puzzle, numRows, numColumns);
		puzzleBoard = new Board(lightning, numRows, numColumns);
		releaseBoard = new Board(release, numRows, numColumns);
		board = new Board(level, numRows, numColumns);
		
		
		puzzle = new PuzzleLevel(movesRemaining, puzzleBoard, bullpen, unlocked, levelNum, stars);
		lightning = new LightningLevel(timeRemaining, lightningBoard, bullpen, unlocked, levelNum, stars);
		release = new ReleaseLevel(releaseBoard, bullpen, unlocked, levelNum, stars);
		level = new Level(board, bullpen, unlocked, levelNum, stars);
	}
	
	/**
	 * Test Puzzle methods.
	 */
	public void testPuzzle(){
		assertEquals(puzzle.hasWon(), false);
		
		//move piece to board
		BullpenToPuzzleBoardMove BPM = new BullpenToPuzzleBoardMove(puzzleBoard, piece, puzzle, bullpen);
		assertEquals(puzzle.doMove(BPM), true);
		
		assertEquals(puzzle.getMovesRemaining(), 0);
		assertEquals(puzzle.hasWon(), true);
	}
	
	/**
	 * Test Lightning methods.
	 */
	public void testLightning(){
		assertEquals(lightning.hasWon(), false); 
		
		//move piece to board
		BullpenToLightningBoardMove BLM = new BullpenToLightningBoardMove(lightningBoard, piece, lightning, bullpen);
		assertEquals(lightning.doMove(BLM), true);
		assertEquals(lightning.getTimeRemaining(), 5); 
		
	} 
	
	/**
	 * Test Release methods.
	 */
	public void testRelease(){
		assertEquals(release.hasWon(), false);
		
		for (int i = 0; i < 6; i++){
			releaseBoard.boardGrid[0][i] = new ReleaseTile(i, 0, new Number(i + 1, Color.red));
		}
		
		BullpenToReleaseBoardMove BRM = new BullpenToReleaseBoardMove(releaseBoard, piece, release, bullpen);
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
	}

	/**
	 * Test toString methods for all levels
	 */
	public void testToString(){
		assertEquals(puzzle.toString(), "Puzzle1");
		assertEquals(lightning.toString(), "Lightning1");
		assertEquals(release.toString(), "Release1");
		
	}
}
