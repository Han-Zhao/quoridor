package quoridor;

public class Player {
	
	Position currentPosition;
	int wallsCount;
	//Queue<Wall> walls;
	
	public Player(Position initPosition) {
		currentPosition = initPosition;
		//walls = new LinkedList<Wall>();
	}
	
	public void move(Position position) {
		currentPosition = position;
	}
	
	/*public void addWall(Wall wall) {
		walls.add(wall);
	}*/
	
}
