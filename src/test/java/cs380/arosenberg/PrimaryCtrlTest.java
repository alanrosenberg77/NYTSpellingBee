package cs380.arosenberg;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PrimaryCtrlTest {
	
	Game g;
	String[] correctWords = {"agony", "allay", "alley", "alloy", "ally", "anally", "analogy", "annoy", "anyone", "eely", "eggy", "elegy", "galley", "gangly", "gayly", "genealogy", "geology", "goggly", "golly", "gooey", "googly", "goony", "laggy", "lallygag", "leanly", "legally", "leggy", "logy", "lollygag", "lonely", "loony", "loyal", "loyally", "naggy", "nanny", "nylon", "oenology", "onlay", "only", "yang", "yell", "yoga"};
	
	
	@Before
	public void setUp() throws Exception {
		g = new Game();
	}

	@Test
	public void creationTest() {
		assertNotNull(g);
	}
	
	/*
	 * readWords tests
	 */
	@Test
	public void readWordsTest() {
		
		assertNotNull(g.getWords());
		assertEquals(42, g.getWords().length);
		
		for(int i=0 ; i<g.getWords().length ; i++) {
			assertTrue(g.getWords()[i].equals(correctWords[i]));
		}
	}

}
