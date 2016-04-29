package entity;

import java.awt.Color;

/**
 * represents a tile on the release board.
 * @author Quoc HoLam
 *
 */
public class ReleaseTile extends BoardTile{
	Number num;
	/**
	 * Constructor to create ReleaseTile with given specifications. 
	 * @param row Row position of tile on board.
	 * @param col Column position of tile on board.
	 * @param Number Number to associate with this tile.
	 */
	public ReleaseTile(int row, int col, Number n) {
		super(row, col);
		
		num = n;
	}

	@Override
	public String toString() {
		return TileType.releaseTile;
	}
	
	/**
	 * sets the next release tile
	 * @return the next release tile
	 */
	public ReleaseTile getNext(){
		//if(this.num.getNum() >= 6){
			//return null;
		//}
		Number number = new Number(this.num.getNum() + 1, this.num.getColor());
		return new ReleaseTile(0, 0, number);
	}
	
	/**
	 * sets the next release tile
	 * @return the next release tile
	 */
	public ReleaseTile getPrevious(){
		Number number = new Number(this.num.getNum() - 1, this.num.getColor());
		return new ReleaseTile(0, 0, number);
	}
	
	/**
	 * Gets the Number of the release tile.
	 * @return Number the number of this tile.
	 */
	public Number getNumber(){
		return this.num;
	}
	
	public Color getColor(){
		return this.num.getColor();
	}

}
