package quoridor;

public class Position {
	private int row;
	private int column;
	
	public Position (String s) {
		column = s.charAt(0) - 'a';
		row = s.charAt(1) - '1';
	}
	
	public Position (int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	protected int getRow () {
		return row;
	}
	
	protected int getColumn () {
		return column;
	}
	
	protected boolean isHere (int row, int column) {
		return (this.row == row && this.column == column);
	}
	
	protected boolean isAdjacent(Position that) {
		return ((Math.abs(row - that.row) == 1 && column == that.column) || (Math.abs(column - that.column) == 1 && row == that.row));
	}

	@Override
	public int hashCode() {
		return row*9 + column;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Position) {
			Position tmp = (Position)obj;
			return (row == tmp.row && column == tmp.column);
		} else
			return false;
	}
	
	
}
