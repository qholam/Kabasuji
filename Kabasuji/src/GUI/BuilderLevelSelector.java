package GUI;


import javax.swing.JPanel;

import controller.LoadBuilderLevelCrl;
import controller.LoadLevelCtrl;
import entity.Board;
import entity.Bullpen;
import entity.Level;
import entity.LevelType;
import entity.LightningLevel;
import entity.PuzzleLevel;
import serializers.Deserializer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * A panel used to select which level you want to play.
 * @author Richard Hayes
 *
 */
public class BuilderLevelSelector extends JPanel {

	
	KabasujiBuilderFrame kFrame;

	JLabel lblPuzzleStars1;
	JLabel lblPuzzleStars2;
	JLabel lblPuzzleStars3;
	JLabel lblPuzzleStars4;
	JLabel lblPuzzleStars5;

	JLabel lblReleaseStars1;
	JLabel lblReleaseStars2;
	JLabel lblReleaseStars3;
	JLabel lblReleaseStars4;
	JLabel lblReleaseStars5;
	
	JLabel lblLightningStars1;
	JLabel lblLightningStars2;
	JLabel lblLightningStars3;
	JLabel lblLightningStars4;
	JLabel lblLightningStars5;

	/*
	 * Create the panel.
	 */
	public BuilderLevelSelector(KabasujiBuilderFrame frame) {
		kFrame = frame;
		setLayout(null);
		setBackground(new Color(176, 224, 230));
		setBounds(0, 0, 1200, 800);
		
		JButton puzzleLevel1 = new JButton("1");
		puzzleLevel1.setBounds(329, 200, 60, 50);
		puzzleLevel1.setForeground(new Color(255, 165, 0));
		puzzleLevel1.addActionListener(new LoadBuilderLevelCrl(LevelType.Puzzle, kFrame, 1));
		add(puzzleLevel1);

		JLabel lblKabasuji = new JLabel("Kabasuji");
		lblKabasuji.setBounds(6, 0, 900, 34);
		add(lblKabasuji);

		JButton puzzleLevel2 = new JButton("2");
		puzzleLevel2.setBounds(449, 200, 60, 50);
		puzzleLevel2.setForeground(new Color(255, 165, 0));
		puzzleLevel2.addActionListener(new LoadBuilderLevelCrl(LevelType.Puzzle, kFrame, 2));
		add(puzzleLevel2);

		JButton puzzleLevel3 = new JButton("3");
		puzzleLevel3.setBounds(570, 200, 60, 50);
		puzzleLevel3.setForeground(new Color(255, 165, 0));
		puzzleLevel3.addActionListener(new LoadBuilderLevelCrl(LevelType.Puzzle, kFrame, 3));
		add(puzzleLevel3);

		JButton puzzleLevel4 = new JButton("4");
		puzzleLevel4.setBounds(689, 200, 60, 50);
		puzzleLevel4.setForeground(new Color(255, 165, 0));
		puzzleLevel4.addActionListener(new LoadBuilderLevelCrl(LevelType.Puzzle, kFrame, 4));
		add(puzzleLevel4);

		JButton puzzleLevel5 = new JButton("5");
		puzzleLevel5.setBounds(809, 200, 60, 50);
		puzzleLevel5.setForeground(new Color(255, 165, 0));
		puzzleLevel5.addActionListener(new LoadBuilderLevelCrl(LevelType.Puzzle, kFrame, 5));
		add(puzzleLevel5);

		JButton releaseLevel1 = new JButton("1");
		releaseLevel1.setBounds(329, 364, 60, 50);
		releaseLevel1.setForeground(new Color(255, 165, 0));
		releaseLevel1.addActionListener(new LoadBuilderLevelCrl(LevelType.Release, kFrame, 1));
		add(releaseLevel1);
		
		JButton releaseLevel2 = new JButton("2");
		releaseLevel2.setBounds(449, 364, 60, 50);
		releaseLevel2.setForeground(new Color(255, 165, 0));
		releaseLevel2.addActionListener(new LoadBuilderLevelCrl(LevelType.Release, kFrame, 2));
		add(releaseLevel2);

		JButton releaseLevel3 = new JButton("3");
		releaseLevel3.setBounds(570, 364, 60, 50);
		releaseLevel3.setForeground(new Color(255, 165, 0));
		releaseLevel3.addActionListener(new LoadBuilderLevelCrl(LevelType.Release, kFrame, 3));
		add(releaseLevel3);

		JButton releaseLevel4 = new JButton("4");
		releaseLevel4.setBounds(689, 364, 60, 50);
		releaseLevel4.setForeground(new Color(255, 165, 0));
		releaseLevel4.addActionListener(new LoadBuilderLevelCrl(LevelType.Release, kFrame, 4));
		add(releaseLevel4);

		JButton releaseLevel5 = new JButton("5");
		releaseLevel5.setBounds(809, 364, 60, 50);
		releaseLevel5.setForeground(new Color(255, 165, 0));
		releaseLevel5.addActionListener(new LoadBuilderLevelCrl(LevelType.Release, kFrame, 5));
		add(releaseLevel5);

		JButton lightningLevel1 = new JButton("1");
		lightningLevel1.setBounds(329, 528, 60, 50);
		lightningLevel1.setForeground(new Color(255, 165, 0));
		lightningLevel1.addActionListener(new LoadBuilderLevelCrl(LevelType.Lightning, kFrame, 1));
		add(lightningLevel1);

		JButton lightningLevel2 = new JButton("2");
		lightningLevel2.setBounds(449, 528, 60, 50);
		lightningLevel2.setForeground(new Color(255, 165, 0));
		lightningLevel2.addActionListener(new LoadBuilderLevelCrl(LevelType.Lightning, kFrame, 2));
		add(lightningLevel2);

		JButton lightningLevel3 = new JButton("3");
		lightningLevel3.setBounds(570, 528, 60, 50);
		lightningLevel3.setForeground(new Color(255, 165, 0));
		lightningLevel3.addActionListener(new LoadBuilderLevelCrl(LevelType.Lightning, kFrame, 3));
		add(lightningLevel3);

		JButton lightningLevel4 = new JButton("4");
		lightningLevel4.setBounds(689, 528, 60, 50);
		lightningLevel4.setForeground(new Color(255, 165, 0));
		lightningLevel4.addActionListener(new LoadBuilderLevelCrl(LevelType.Lightning, kFrame, 4));
		add(lightningLevel4);

		JButton lightningLevel5 = new JButton("5");
		lightningLevel5.setBounds(809, 528, 60, 50);
		lightningLevel5.setForeground(new Color(255, 165, 0));
		lightningLevel5.addActionListener(new LoadBuilderLevelCrl(LevelType.Lightning, kFrame, 5));
		add(lightningLevel5);

		JLabel puzzleLabel = new JLabel("Puzzle");
		puzzleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		puzzleLabel.setBounds(567, 140, 66, 25);
		add(puzzleLabel);

		JLabel releaseLabel = new JLabel("Release");
		releaseLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		releaseLabel.setBounds(564, 304, 72, 25);
		add(releaseLabel);

		JLabel lblLightning = new JLabel("Lightning");
		lblLightning.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblLightning.setBounds(555, 468, 90, 25);
		add(lblLightning);

		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(30, 60, 117, 29);
		btnMainMenu.setForeground(new Color(255, 165, 0));
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.BuilderMainMenu);
			}
		});
		add(btnMainMenu);
		
		JLabel lblSelectLevel = new JLabel("Select Level To Edit");
		lblSelectLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSelectLevel.setBounds(508, 60, 184, 29);
		add(lblSelectLevel);

	}
	
	
}

