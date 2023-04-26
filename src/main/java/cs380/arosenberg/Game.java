package cs380.arosenberg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * An instance of the Game class is will represent a game of the NYT Spelling Bee.
 * It acts as a data sack, storing the core letter, list of all letters, list of
 * correct words, player's score, and list of guessed words. The Game class can also
 * read words from a data file and store those words into the correct words list
 * for quick reference when the user makes a guess. Game can check whether a guess
 * is correct or not, as well as award points for a correct guess.
 * @author alanr
 *
 */
public class Game {

	private String coreLtr = "y";	//required "core" letter
	private String[] ltrs = {"o", "a", "l", "y", "n", "e", "g"};
	private String[] words = {};	//list of all correct words
	private int score;
	private LinkedList<String> guessed;		//tracking all guessed words
	
	/**
	 * Default constructor initializing local variables to starting values
	 */
	public Game() {
		words = this.readWords();
		score = 0;
		guessed = new LinkedList<>();
	}
	
	/**
	 * readWords is a private helper that reads the file of correct words.
	 * It will store these words into the local String array, words.
	 * This is to have a convenient handle on the list of correct words.
	 * @return array of words, from the file of correct words
	 */
	private String[] readWords() {
		
		//setting up
		File f = new File("src/main/resources/cs380/arosenberg/words.txt");
		BufferedReader br;
		ArrayList<String> read = new ArrayList<>();	//holding onto words read from file
		
		try {
			
			FileReader fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			//reading lines
			String line = br.readLine();
			
			while(line != null) {	//So long as there is a next line...
				
				System.out.println("Got ["+line+"]");
				
				read.add(line);			//adding word to local list
				
				line = br.readLine();	//reading the next line
			}
		}
		catch (IOException e) {
			
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		//copying words into global word list
		String[] words = new String[read.size()];
		for(int i=0 ; i<read.size() ; i++) {
			words[i] = read.get(i);
		}
		
		return words;
	}
	
	/**
	 * checkGuess will take a guess word and check to see if that word is correct.
	 * It returns a boolean indicating whether the guess is correct or not.
	 * Either way, the method will append the word to guessed, the array of guessed words.
	 * If word already exists in guessed, this method will return false
	 * @param guessed word
	 * @return true if guess is correct, false if not
	 */
	public boolean checkGuess(String guess) {
		
		//assuming guess is false by default
		boolean isCorrect = false;
		
		//if guess exists in guessed list, returning false
		for(int i=0 ; i<guessed.size() ; i++) {
			if(guess.equals(guessed.get(i))) {
				return isCorrect;
			}
		}
		
		//if guess exists in the list of correct words, returning true
		for(int i=0 ; i<words.length ; i++) {
			if(guess.equals(words[i])) {
				isCorrect = true;
				break;
			}
		}
		
		return isCorrect;
	}
	
	/**
	 * awardPoints takes a word and awards points based on the length of the word.
	 * The number of points awarded gets added to the local score variable.
	 * @param guessed word
	 * @return integer amount of points award for just this word
	 */
	public void awardPoints(String guess) {
		
		//total points to be added to player's score
		int total = 0;
		
		//adding a points for every letter in the word
		total = guess.length();
		
		//adding an extra 7 points if the word is a pangram
		if(isPangram(guess)) {
			total += 7;
		}
		
		//returning allotted total
		score += total;
	}

	/**
	 * isPangram is a private helper method that will determine if a guess is a pangram.
	 * @param guessed word
	 * @return true if the guess is a pangram, false if not
	 */
	private boolean isPangram(String guess) {
		
		//assuming guess is a pangram
		boolean isPangram = true;
		
		//if guess  does not contain all letters from list of letters, returning false
		for(int i=0 ; i<ltrs.length ; i++) {
			if(!guess.contains(ltrs[i])) {
				isPangram = false;
				break;
			}
		}
		
		return isPangram;
	}
	
	/*
	 * Getters and Setters
	 */
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getCoreLtr() {
		return coreLtr;
	}

	public String[] getLtrs() {
		return ltrs;
	}

	public String[] getWords() {
		return words;
	}

	public LinkedList<String> getGuessed() {
		return guessed;
	}
}
