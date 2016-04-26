package view;

import javax.swing.JPanel;

import entity.Tile;
import entity.TileType;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
/**
 * @author Quoc HoLam
 * View for Tiles
 */

public class TileView extends JPanel{
	/**
	 * Auto-generate by Eclipse to suppress a warning
	 */
	private static final long serialVersionUID = 4176891530644715173L;
	
	//Tile that this view represents
	Tile tile;
	
	//boolean to determine repaint(need for smooth drag)
	Boolean repaint = true;

	/**
	 * Constructor for TileView
	 * @param t Given {@link Tile} that this view will represent
	 */
	public TileView(Tile t){
		super();
		repaint = true;
		
		//TODO set a proper size based on the grids of a board 
		setSize(40,23);
		setLayout(null);
		
		tile = t;
	} 
	
	/**
	 * Properly update the displayed info on this {@link Tile}
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		//check if tile is null or  a noTile, if so set it to not be visible(not implemented)
		//NEEDS TO LOOK INTO(get the setVisble function calls to work)
		//the current color for notiles/null is the default color of a jpanel(technically invisble), there were issues with the call to repaint
		//when the tiles were set to not be visible.
		if(tile == null){
			setBackground(new JPanel().getBackground());
			setBorder(new LineBorder(new Color(0, 0, 0), 0));
			setOpaque(false);
			//setVisible(false);
		}
		else if (tile.toString().equals(TileType.noTile)) {
			setBackground(new JPanel().getBackground());
			setBorder(new LineBorder(new Color(0, 0, 0), 1));
			setOpaque(true);
		}
		else{
			setBackground(tile.getColor());
			setBorder(new LineBorder(new Color(0, 0, 0), 1));
			setOpaque(true);
			//setVisible(true);
		}

	}
	
	@Override
	public void repaint(){
		if(repaint != null && repaint)
			super.repaint();
	}
	
	/**
	 * this is needed to prevent flickering when dragging inside the board.
	 * TODO: find another way to prevent this flickering
	 */
	public void setRepaintInvalid(){
		repaint = false;
	}
 
	/**
	 * this is needed to prevent flickering when dragging inside the board.
	 * TODO: find another way to prevent this flickering
	 */
	public void setRepaintValid(){
		repaint = true;
	}
	
	/**
	 * @return the tile
	 */
	public Tile getTile() {
		return tile;
	}

	/**
	 * @param tile the tile to set
	 */
	public void setTile(Tile tile) {
		this.tile = tile;
		this.repaint();
	}
}
