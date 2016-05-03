package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import GUI.KabasujiFrame;
import GUI.LevelPanel;
import entity.Level;
import entity.LevelType;
import serializers.Deserializer;

/**
 * 
 * @author Quoc HoLam
 *
 */
public class LoadLevelCtrl implements ActionListener{
	int levelNum;
	LevelType levelType;
	KabasujiFrame kFrame;

	/**
	 * Constructor for LoadLevelCtrl, which will handle the loading of levels.
	 * @param type The level type to load.
	 * @param frame The given kabasuji frame which holds all the panels.
	 * @param num The level number to load.
	 */
	public LoadLevelCtrl(LevelType type, KabasujiFrame frame, int num) {
		kFrame = frame;
		levelType = type;
		levelNum = num;
	}

	/**
	 * Loads level. 
	 * TODO: make this more dynamic. This assumes that the most number of levels of each type is 5.
	 * @param ae ActionEvent.
	 */
	public void actionPerformed(ActionEvent ae) {	
		LevelPanel levelPanel = null;
		Level level = null;
		switch (levelType) {
		case Lightning:
			if(levelNum > 5){
				//do something
			}
			else{
				level = new Deserializer().deserialzeLightningLevel(levelNum);
				if(level != null)
					levelPanel = new LevelPanel(kFrame, level);
			}
			break;
		case Release:
			if(levelNum > 5){
				level = new Deserializer().deserialzeLightningLevel(1);
				if(level != null)
					levelPanel = new LevelPanel(kFrame, level);
			}
			else{
				level = new Deserializer().deserialzeReleaseLevel(levelNum);
				if(level != null)
					levelPanel = new LevelPanel(kFrame, level);
			}
			break;
		case Puzzle:
			if(levelNum > 5){
				level = new Deserializer().deserialzeReleaseLevel(1);
				if(level != null)
					levelPanel = new LevelPanel(kFrame, level);
			}
			else{
				level = new Deserializer().deserialzePuzzleLevel(levelNum);
				if(level != null)
					levelPanel = new LevelPanel(kFrame, level);
			}
			break;
		default:
			break;
		}

		if(levelPanel != null){
			kFrame.addToContentPane((JPanel) levelPanel, kFrame.LevelPanel);
			kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.LevelPanel);
		}
	}
}
