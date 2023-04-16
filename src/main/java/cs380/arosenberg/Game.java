package cs380.arosenberg;

public class Game {

	private char coreLtr = 'Y';
	private char[] ltrs = {'O', 'A', 'L', 'N', 'E', 'G'};
	private String[] words = {};
	private int score;
	private String[] guessed = {};
	
	public Game() {
		words = this.readWords();
		score = 0;
	}
	
	/**
	 * readWords is a private helper that reads the file of correct words.
	 * It will store these words into the local String array, words.
	 * This is to have a convenient handle on the list of correct words.
	 * @return array of words, from the file of correct words
	 */
	private String[] readWords() {
		// TODO implement readWords()
		return null;
	}
	
	/**
	 * checkGuess will take a guess word and check to see if that word is correct.
	 * It returns a boolean indicating whether the guess is correct or not.
	 * Either way, the method will append the word to guessed, the array of guessed words.
	 * @param guessed word
	 * @return true if guess is correct, false if not
	 */
	public boolean checkGuess(String guess) {
		// TODO implement checkGuess(String guess)
		return true;
	}
	
	/**
	 * awardPoints takes a word and awards points based on the length of the word.
	 * The number of points awarded gets added to the local score variable.
	 * @param guessed word
	 * @return integer amount of points award for just this word
	 */
	public int awardPoints(String guess) {
		
		int total = 0;
		
		for(int i = 0 ; i < guess.length() ; i++) {
			total++;
		}
		
		if(isPangram(guess)) {
			total += 7;
		}
		
		return total;
	}

	/**
	 * isPangram is a private helper method that will determine if a guess is a pangram.
	 * @param guessed word
	 * @return true if the guess is a pangram, false if not
	 */
	private boolean isPangram(String guess) {
		// TODO implement isPangram(String guess)
		return true;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public char getCoreLtr() {
		return coreLtr;
	}

	public char[] getLtrs() {
		return ltrs;
	}

	public String[] getWords() {
		return words;
	}

	public String[] getGuessed() {
		return guessed;
	}
}
