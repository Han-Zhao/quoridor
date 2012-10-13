package quoridor;

import java.util.StringTokenizer;

public class Displayer implements Display {

	@Override
	public void display(String moves) {
		GameState gs = new GameState();
		StringTokenizer st = new StringTokenizer(moves);
		while (st.hasMoreTokens()) {
			String move = st.nextToken();
			gs.parse(move);
		}
		gs.display();
	}

}
