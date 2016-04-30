package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import GUI.KabasujiFrame;
import GUI.LevelPanel;
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

	public LoadLevelCtrl(LevelType type, KabasujiFrame frame, int num) {
		kFrame = frame;
		levelType = type;
		levelNum = num;
	}

	public void actionPerformed(ActionEvent ae) {		
		LevelPanel levelPanel = null;
		switch (levelType) {
		case Lightning:
			levelPanel = new LevelPanel(kFrame, new Deserializer().deserialzeLightningLevel(levelNum));
			break;
		case Release:
			levelPanel = new LevelPanel(kFrame, new Deserializer().deserialzeReleaseLevel(levelNum));
			break;
		case Puzzle:
			levelPanel = new LevelPanel(kFrame, new Deserializer().deserialzePuzzleLevel(levelNum));
			break;
		default:
			break;
		}

		kFrame.addToContentPane((JPanel) levelPanel, kFrame.LevelPanel);
		kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.LevelPanel);
	}
}
