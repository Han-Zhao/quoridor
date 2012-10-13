package quoridor;

import java.util.HashMap;

public class GameState {
	
	//final int BOARD_SIZE = 9;
	Player player1;
	Player player2;
	Player turn;
	HashMap<Position, Orientation> allWalls;
	
	public GameState() {
		player1 = new Player(new Position("e9"));
		player2 = new Player(new Position("e1"));
		turn = player1;
		allWalls = new HashMap<Position, Orientation>();
	}
	
	public boolean parse(String move) {
		if (move.length() < 2)
			return false;
		if (!(move.charAt(0) >= 'a' && move.charAt(0) <= 'i' && move.charAt(1) >= '1' && move.charAt(1) <= '9'))
			return false;
		if (move.length() == 3) {
			if (move.charAt(2) == 'v')
				allWalls.put(new Position(move), Orientation.VERTICAL);
			else if (move.charAt(2) == 'h')
				allWalls.put(new Position(move), Orientation.HORIZONTAL);
			else
				return false;
			turn.wallsCount++;
		} else if (move.length() == 2)
			turn.move(new Position(move));
		else
			return false;
		turn = turn == player1 ? player2: player1;
		return true;
	}
	
	public void display() {
		int i, j;
		System.out.println("     a   b   c   d   e   f   g   h   i");
		for (i = 0; i < 19; i++) {
			if (i%2 == 1)
				System.out.print(" " + (i/2 + 1) + " ");
			else
				System.out.print("   ");
			for (j = 0; j < 9; j++) {
				if (i % 2 == 0) {
					if (allWalls.get(new Position (i/2 - 1, j)) == Orientation.HORIZONTAL 
							|| allWalls.get(new Position (i/2 - 1, j - 1)) == Orientation.HORIZONTAL) {
						System.out.print("+###");
					} else {
						System.out.print("+---");
					}
				} else {
					if (allWalls.get(new Position (i/2, j - 1)) == Orientation.VERTICAL 
							|| allWalls.get(new Position (i/2 - 1, j - 1)) == Orientation.VERTICAL) {
						System.out.print("#");
					} else {
						System.out.print("|");
					}
					if (player1.currentPosition.isHere(i/2, j))
						System.out.print(" O ");
					else if (player2.currentPosition.isHere(i/2, j))
						System.out.print(" X ");
					else
						System.out.print("   ");
				}
			}
			if (i % 2 == 0)
				System.out.println("+");
			else
				System.out.println("|");
		}
	}

}
