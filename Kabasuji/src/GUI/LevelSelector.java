package GUI;


import javax.swing.JPanel;

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

public class LevelSelector extends JPanel {

	
	KabasujiFrame kFrame;

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
	public LevelSelector(KabasujiFrame frame) {
		kFrame = frame;
		setLayout(null);
		setBackground(new Color(176, 224, 230));
		setBounds(0, 0, 800, 800);
		
		JButton puzzleLevel1 = new JButton("1");
		puzzleLevel1.setBounds(120, 200, 60, 50);
		puzzleLevel1.setForeground(new Color(255, 165, 0));
		puzzleLevel1.addActionListener(new LoadLevelCtrl(LevelType.Puzzle, kFrame, 1));
		add(puzzleLevel1);

		JLabel lblKabasuji = new JLabel("Kabasuji");
		lblKabasuji.setBounds(6, 0, 900, 34);
		add(lblKabasuji);

		JButton puzzleLevel2 = new JButton("2");
		puzzleLevel2.setBounds(240, 200, 60, 50);
		puzzleLevel2.setForeground(new Color(255, 165, 0));
		puzzleLevel2.addActionListener(new LoadLevelCtrl(LevelType.Puzzle, kFrame, 2));
		add(puzzleLevel2);

		JButton puzzleLevel3 = new JButton("3");
		puzzleLevel3.setBounds(360, 200, 60, 50);
		puzzleLevel3.setForeground(new Color(255, 165, 0));
		puzzleLevel3.addActionListener(new LoadLevelCtrl(LevelType.Puzzle, kFrame, 3));
		add(puzzleLevel3);

		JButton puzzleLevel4 = new JButton("4");
		puzzleLevel4.setBounds(480, 200, 60, 50);
		puzzleLevel4.setForeground(new Color(255, 165, 0));
		puzzleLevel4.addActionListener(new LoadLevelCtrl(LevelType.Puzzle, kFrame, 4));
		add(puzzleLevel4);

		JButton puzzleLevel5 = new JButton("5");
		puzzleLevel5.setBounds(600, 200, 60, 50);
		puzzleLevel5.setForeground(new Color(255, 165, 0));
		puzzleLevel5.addActionListener(new LoadLevelCtrl(LevelType.Puzzle, kFrame, 5));
		add(puzzleLevel5);

		JButton releaseLevel1 = new JButton("1");
		releaseLevel1.setBounds(120, 364, 60, 50);
		releaseLevel1.setForeground(new Color(255, 165, 0));
		releaseLevel1.addActionListener(new LoadLevelCtrl(LevelType.Release, kFrame, 1)); 
		add(releaseLevel1);
		
		JButton releaseLevel2 = new JButton("2");
		releaseLevel2.setBounds(240, 364, 60, 50);
		releaseLevel2.setForeground(new Color(255, 165, 0));
		releaseLevel2.addActionListener(new LoadLevelCtrl(LevelType.Release, kFrame, 2));
		add(releaseLevel2);

		JButton releaseLevel3 = new JButton("3");
		releaseLevel3.setBounds(360, 364, 60, 50);
		releaseLevel3.setForeground(new Color(255, 165, 0));
		releaseLevel3.addActionListener(new LoadLevelCtrl(LevelType.Release, kFrame, 3));
		add(releaseLevel3);

		JButton releaseLevel4 = new JButton("4");
		releaseLevel4.setBounds(480, 364, 60, 50);
		releaseLevel4.setForeground(new Color(255, 165, 0));
		releaseLevel4.addActionListener(new LoadLevelCtrl(LevelType.Release, kFrame, 4));
		add(releaseLevel4);

		JButton releaseLevel5 = new JButton("5");
		releaseLevel5.setBounds(600, 364, 60, 50);
		releaseLevel5.setForeground(new Color(255, 165, 0));
		releaseLevel5.addActionListener(new LoadLevelCtrl(LevelType.Release, kFrame, 5));
		add(releaseLevel5);

		JButton lightningLevel1 = new JButton("1");
		lightningLevel1.setBounds(120, 528, 60, 50);
		lightningLevel1.setForeground(new Color(255, 165, 0));
		lightningLevel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Bullpen bp = new Bullpen();
				for (int i = 0; i < 10; i++) {
					bp.addPiece(kFrame.pieces[i]);
				}
				Level l = new LightningLevel(20, new Board(null, 6, 6),bp, true, 1, 0);
				LevelPanel puzzle1 = new LevelPanel(kFrame, l);
				kFrame.addToContentPane((JPanel)puzzle1, kFrame.Puzzle1);
				kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.Puzzle1);
			}
		}); 
		add(lightningLevel1);

		JButton lightningLevel2 = new JButton("2");
		lightningLevel2.setBounds(240, 528, 60, 50);
		lightningLevel2.setForeground(new Color(255, 165, 0));
		lightningLevel2.addActionListener(new LoadLevelCtrl(LevelType.Release, kFrame, 2));
		add(lightningLevel2);

		JButton lightningLevel3 = new JButton("3");
		lightningLevel3.setBounds(360, 528, 60, 50);
		lightningLevel3.setForeground(new Color(255, 165, 0));
		lightningLevel3.addActionListener(new LoadLevelCtrl(LevelType.Release, kFrame, 3));
		add(lightningLevel3);

		JButton lightningLevel4 = new JButton("4");
		lightningLevel4.setBounds(480, 528, 60, 50);
		lightningLevel4.setForeground(new Color(255, 165, 0));
		lightningLevel4.addActionListener(new LoadLevelCtrl(LevelType.Release, kFrame, 4));
		add(lightningLevel4);

		JButton lightningLevel5 = new JButton("5");
		lightningLevel5.setBounds(600, 528, 60, 50);
		lightningLevel5.setForeground(new Color(255, 165, 0));
		lightningLevel5.addActionListener(new LoadLevelCtrl(LevelType.Release, kFrame, 5));
		add(lightningLevel5);

		JLabel puzzleLabel = new JLabel("Puzzle");
		puzzleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		puzzleLabel.setBounds(357, 140, 66, 25);
		add(puzzleLabel);

		JLabel releaseLabel = new JLabel("Release");
		releaseLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		releaseLabel.setBounds(354, 304, 72, 25);
		add(releaseLabel);

		JLabel lblLightning = new JLabel("Lightning");
		lblLightning.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblLightning.setBounds(345, 468, 90, 25);
		add(lblLightning);

		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(30, 60, 117, 29);
		btnMainMenu.setForeground(new Color(255, 165, 0));
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.MainMenu);
			}
		});
		add(btnMainMenu);
		
		JLabel lblSelectLevel = new JLabel("Select Level");
		lblSelectLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSelectLevel.setBounds(331, 60, 117, 29);
		add(lblSelectLevel);
		
		//Labels that hold the highest star achieved for each level
		int stars = kFrame.getStars(LevelType.Puzzle, 1);
		System.out.println(stars);
		lblPuzzleStars1 = new JLabel();
		lblPuzzleStars1.setBounds(120, 260, 61, 16);
		lblPuzzleStars1.setIcon(new ImageIcon(getClass().getResource("pictures/" + stars + "star.png")));
		add(lblPuzzleStars1);

		stars = kFrame.getStars(LevelType.Puzzle, 2);
		lblPuzzleStars2 = new JLabel(stars + " Star");
		lblPuzzleStars2.setBounds(240, 260, 61, 16);
		lblPuzzleStars2.setIcon(new ImageIcon(getClass().getResource("pictures/" + stars + "star.png")));
		add(lblPuzzleStars2);

		stars = kFrame.getStars(LevelType.Puzzle, 3);
		lblPuzzleStars3 = new JLabel(stars + " Star");
		lblPuzzleStars3.setBounds(360, 260, 61, 16);
		lblPuzzleStars3.setIcon(new ImageIcon(getClass().getResource("pictures/" + stars + "star.png")));
		add(lblPuzzleStars3);

		stars = kFrame.getStars(LevelType.Puzzle, 4);
		lblPuzzleStars4 = new JLabel(stars + " Star");
		lblPuzzleStars4.setBounds(480, 260, 61, 16);
		lblPuzzleStars4.setIcon(new ImageIcon(getClass().getResource("pictures/" + stars + "star.png")));
		add(lblPuzzleStars4);

		stars = kFrame.getStars(LevelType.Puzzle, 5);
		lblPuzzleStars5 = new JLabel(stars + " Star");
		lblPuzzleStars5.setBounds(600, 260, 61, 16);
		lblPuzzleStars5.setIcon(new ImageIcon(getClass().getResource("pictures/" + stars + "star.png")));
		add(lblPuzzleStars5);

		stars = kFrame.getStars(LevelType.Release, 1);
		lblReleaseStars1 = new JLabel(stars + " Star");
		lblReleaseStars1.setBounds(120, 426, 61, 16);
		lblReleaseStars1.setIcon(new ImageIcon(getClass().getResource("pictures/" + stars + "star.png")));
		add(lblReleaseStars1);

		stars = kFrame.getStars(LevelType.Release, 2);
		lblReleaseStars2 = new JLabel(stars + " Star");
		lblReleaseStars2.setBounds(240, 426, 61, 16);
		lblReleaseStars2.setIcon(new ImageIcon(getClass().getResource("pictures/" + stars + "star.png")));
		add(lblReleaseStars2);
		
		stars = kFrame.getStars(LevelType.Release, 3);
		lblReleaseStars3 = new JLabel(stars + " Star");
		lblReleaseStars3.setBounds(357, 426, 61, 16);
		lblReleaseStars3.setIcon(new ImageIcon(getClass().getResource("pictures/" + stars + "star.png")));
		add(lblReleaseStars3);

		stars = kFrame.getStars(LevelType.Release, 4);
		lblReleaseStars4 = new JLabel(stars + " Star");
		lblReleaseStars4.setBounds(480, 426, 61, 16);
		lblReleaseStars4.setIcon(new ImageIcon(getClass().getResource("pictures/" + stars + "star.png")));
		add(lblReleaseStars4);

		stars = kFrame.getStars(LevelType.Release, 5);
		lblReleaseStars5 = new JLabel(stars + " Star");
		lblReleaseStars5.setBounds(600, 426, 61, 16);
		lblReleaseStars5.setIcon(new ImageIcon(getClass().getResource("pictures/" + stars + "star.png")));
		add(lblReleaseStars5);
		
		stars = kFrame.getStars(LevelType.Lightning, 1);
		lblLightningStars1 = new JLabel(stars + " Star");
		lblLightningStars1.setBounds(120, 590, 61, 16);
		lblLightningStars1.setIcon(new ImageIcon(getClass().getResource("pictures/" + stars + "star.png")));
		add(lblLightningStars1);

		stars = kFrame.getStars(LevelType.Lightning, 2);
		lblLightningStars2 = new JLabel(stars + " Star");
		lblLightningStars2.setBounds(240, 590, 61, 16);
		lblLightningStars2.setIcon(new ImageIcon(getClass().getResource("pictures/" + stars + "star.png")));
		add(lblLightningStars2);

		stars = kFrame.getStars(LevelType.Lightning, 3);
		lblLightningStars3 = new JLabel(stars + " Star");
		lblLightningStars3.setBounds(360, 590, 61, 16);
		lblLightningStars3.setIcon(new ImageIcon(getClass().getResource("pictures/" + stars + "star.png")));
		add(lblLightningStars3);

		stars = kFrame.getStars(LevelType.Lightning, 4);
		lblLightningStars4 = new JLabel(stars + " Star");
		lblLightningStars4.setBounds(480, 590, 61, 16);
		lblLightningStars4.setIcon(new ImageIcon(getClass().getResource("pictures/" + stars + "star.png")));
		add(lblLightningStars4);

		stars = kFrame.getStars(LevelType.Lightning, 5);
		lblLightningStars5 = new JLabel(stars + " Star");
		lblLightningStars5.setBounds(600, 590, 61, 16);
		lblLightningStars5.setIcon(new ImageIcon(getClass().getResource("pictures/" + stars + "star.png")));
		add(lblLightningStars5);

	}
	
	
}

