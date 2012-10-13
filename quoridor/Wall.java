package quoridor;

public class Wall {
	Position centre;
	Orientation orientation;
	
	public Wall (String s) {
		centre = new Position (s.substring(0, 1));
		orientation = s.charAt(2) == 'h' ? Orientation.HORIZONTAL : Orientation.VERTICAL;
	}
}
