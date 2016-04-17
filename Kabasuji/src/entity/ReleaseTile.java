package entity;

public class ReleaseTile extends Tile{
	Number num;
	
	public ReleaseTile(int row, int col, Number n) {
		super(row, col);
		
		num = n;
	}

	@Override
	public String toString() {
		return TileType.releaseTile;
	}

}
