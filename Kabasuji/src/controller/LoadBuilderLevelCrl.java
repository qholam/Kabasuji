package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import GUI.BuilderLevel;
import GUI.BuilderLightningLevel;
import GUI.BuilderPuzzleLevel;
import GUI.BuilderReleaseLevel;
import GUI.KabasujiBuilderFrame;
import GUI.KabasujiFrame;
import GUI.LevelPanel;
import GUI.SpecifyBoardPropertiesView;
import entity.Level;
import entity.LevelType;
import serializers.Deserializer;

/**
 * 
 * @author Quoc HoLam
 *
 */
public class LoadBuilderLevelCrl implements ActionListener {
	int levelNum;
	LevelType levelType;
	KabasujiBuilderFrame kFrame;

	/**
	 * Constructor for LoadLevelCtrl, which will handle the loading of levels.
	 * 
	 * @param type
	 *            The level type to load.
	 * @param frame
	 *            The given kabasuji frame which holds all the panels.
	 * @param num
	 *            The level number to load.
	 */
	public LoadBuilderLevelCrl(LevelType type, KabasujiBuilderFrame frame, int num) {
		kFrame = frame;
		levelType = type;
		levelNum = num;
	}

	/**
	 * Loads level. TODO: make this more dynamic. This assumes that the most
	 * number of levels of each type is 5.
	 * 
	 * @param ae
	 *            ActionEvent.
	 */
	public void actionPerformed(ActionEvent ae) {
		BuilderLevel levelPanel = null;
		Level level = null;

		// determine level type to load
		switch (levelType) {
		case Lightning:
			// set working level to correct type
			kFrame.levelType = LevelType.Lightning;

			// load lightning level
			level = new Deserializer().deserialzeLightningLevel(levelNum);
			if (level != null) {
				kFrame.workingLevel = new BuilderLightningLevel(kFrame);
				((BuilderLightningLevel) kFrame.workingLevel).setBullpen(level.getBullpen());
			}

			break;
		case Release:
			// set working level to correct type
			kFrame.levelType = LevelType.Release;

			// load release level
			level = new Deserializer().deserialzeReleaseLevel(levelNum);
			if (level != null) {
				kFrame.workingLevel = new BuilderReleaseLevel(kFrame);
				((BuilderReleaseLevel) kFrame.workingLevel).setBullpen(level.getBullpen());
			}
			break;
		case Puzzle:
			// set working level to correct type
			kFrame.levelType = LevelType.Puzzle;

			// load puzzle level
			level = new Deserializer().deserialzePuzzleLevel(levelNum);
			if (level != null) {
				kFrame.workingLevel = new BuilderPuzzleLevel(kFrame);
				((BuilderPuzzleLevel) kFrame.workingLevel).setBullpen(level.getBullpen());
			}
			break;
		default:
			break;
		}

		// display the level
		if (kFrame.workingLevel != null) {
			kFrame.setWorkingBoard(level.getBoard());
			kFrame.workingLevel.setBoard(level.getBoard());
			SpecifyBoardPropertiesView specifyBoard = new SpecifyBoardPropertiesView(kFrame);
			specifyBoard.setBounds(0, 0, 1200, 800);
			switch (levelType) {
			case Lightning:
				kFrame.getContentPane().add(kFrame.workingLevel, kFrame.BuilderLightningLevel);
				kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.BuilderLightningLevel);
				break;
			case Puzzle:
				kFrame.getContentPane().add(kFrame.workingLevel, kFrame.BuilderPuzzleLevel);
				kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.BuilderPuzzleLevel);
				break;
			case Release:
				kFrame.getContentPane().add(kFrame.workingLevel, kFrame.BuilderReleaseLevel);
				kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.BuilderReleaseLevel);
				break;
			default:
				break;
			}

		}
	}
}
