package entity;

import java.awt.Color;

public class PieceTileColor {
	//Colors of pieces can be
	static Color[] boardPieceColors = {Color.ORANGE, Color.GREEN, Color.RED, Color.BLUE, Color.MAGENTA, Color.YELLOW, Color.PINK,Color.BLACK, Color.CYAN};
	//index to keep track of the color the next piece should be
	public static int index = 0;
}
