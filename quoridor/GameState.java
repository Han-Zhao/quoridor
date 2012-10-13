package quoridor;

import java.util.HashMap;
import java.util.LinkedList;

public class GameState {
	
	//final int BOARD_SIZE = 9;
	Player player1;
	Player player2;
	Player turn;
	Player other;
	HashMap<Position, Orientation> walls;
	
	public GameState() {
		player1 = new Player(new Position("e9"));
		player2 = new Player(new Position("e1"));
		turn = player1;
		other = player2;
		walls = new HashMap<Position, Orientation>();
	}
	
	private boolean hasEdge(Position position, Orientation orientation) {
		
	}
	
	private LinkedList<Position> allAdjacent(Player player) {
		LinkedList<Position> result = new LinkedList<Position>();
		Position tmp;
		if (player.currentPosition.getRow() > 0) {
			tmp = new Position(player.currentPosition.getRow() - 1, player.currentPosition.getColumn());
			if(walls.get(tmp) != Orientation.HORIZONTAL)
				result.add(tmp);
		}
		if (player.currentPosition.getRow() < 8) {
			if(walls.get(player.currentPosition) != Orientation.HORIZONTAL) {
				tmp = new Position(player.currentPosition.getRow() + 1, player.currentPosition.getColumn());
				result.add(tmp);
			}
		}
		if (player.currentPosition.getColumn() < 8) {
			if(walls.get(player.currentPosition) != Orientation.HORIZONTAL) {
				tmp = new Position(player.currentPosition.getRow() + 1, player.currentPosition.getColumn());
				result.add(tmp);
			}
		}
		return result;
	}
	
	public boolean parse(String move) {
		if (move.length() < 2)
			return false;
		if (!(move.charAt(0) >= 'a' && move.charAt(0) <= 'i' && move.charAt(1) >= '1' && move.charAt(1) <= '9'))
			return false;
		if (move.length() == 3) {
			if (move.charAt(0) == 'i' || move.charAt(1) == '9')
				return false;
			if (move.charAt(2) == 'v')
				walls.put(new Position(move), Orientation.VERTICAL);
			else if (move.charAt(2) == 'h')
				walls.put(new Position(move), Orientation.HORIZONTAL);
			else
				return false;
			turn.wallsCount++;
		} else if (move.length() == 2) {
			Position movement = new Position(move);
			if (movement.equals(player1.currentPosition) || movement.equals(player2.currentPosition))
				return false;
			if (movement.isAdjacent(turn.currentPosition))
				turn.move(movement);
			else if (movement.isAdjacent(other.currentPosition) && other.currentPosition.isAdjacent(turn.currentPosition)) {
				
			}
		} else
			return false;
		Player tmp = turn;
		turn = other;
		other = tmp;
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
					if (walls.get(new Position (i/2 - 1, j)) == Orientation.HORIZONTAL 
							|| walls.get(new Position (i/2 - 1, j - 1)) == Orientation.HORIZONTAL) {
						System.out.print("+###");
					} else {
						System.out.print("+---");
					}
				} else {
					if (walls.get(new Position (i/2, j - 1)) == Orientation.VERTICAL 
							|| walls.get(new Position (i/2 - 1, j - 1)) == Orientation.VERTICAL) {
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
