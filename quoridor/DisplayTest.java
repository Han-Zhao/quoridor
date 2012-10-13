package quoridor;

import org.junit.Before;
import org.junit.Test;

public class DisplayTest {
	
	Display displayer;
	String moves;
	
	@Before
	public void setUp() throws Exception {
		displayer = new Displayer();
		moves = "e1h f1 g1h e8h d1v g1 h2v h1";
	}

	@Test
	public void testDisplay() {
		displayer.display(moves);
	}

}
