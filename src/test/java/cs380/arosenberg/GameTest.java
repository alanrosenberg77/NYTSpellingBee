package cs380.arosenberg;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	
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
	 * readWords Tests
	 */
	@Test
	public void readWordsTest() {
		
		assertNotNull(g.getWords());
		assertEquals(42, g.getWords().length);
		
		for(int i=0 ; i<g.getWords().length ; i++) {
			assertTrue(g.getWords()[i].equals(correctWords[i]));
		}
	}
	
	
	/*
	 * checkGuess Tests
	 */
	
	@Test
	public void checkGuessTestTrue() {
		assertTrue(g.checkGuess("analogy"));
	}
	
	@Test
	public void checkGuessTestFalse() {
		assertFalse(g.checkGuess("cheese"));
	}
	
	@Test
	public void checkGuessTestAlreadyGuessed() {
		g.getGuessed().add("analogy");
		assertFalse(g.checkGuess("analogy"));
	}
	
	@Test
	public void checkGuessTestEmptyString() {
		assertFalse(g.checkGuess(""));
	}
	
	
	/*
	 * awardPoints Tests
	 */
	
	@Test
	public void awardPointsTestNotPangram() {
		g.awardPoints("alloy");
		assertEquals(5, g.getScore());
	}
	
	@Test
	public void awardPointsTestPangram() {
		g.awardPoints("genealogy");
		assertEquals(16, g.getScore());
	}
	
	@Test
	public void awardPointsTestEmptyString() {
		g.awardPoints("");
		assertEquals(0, g.getScore());
	}

}
