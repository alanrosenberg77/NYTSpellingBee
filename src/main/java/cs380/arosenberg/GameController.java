package cs380.arosenberg;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class GameController implements Initializable {

	/*
	 * FXML elements
	 */
    @FXML
    TextField textInput;
    
    @FXML
    Button ltrBtn1;
    
    @FXML
    Button ltrBtn2;
    
    @FXML
    Button ltrBtn3;
    
    @FXML
    Button ltrBtn4;
    
    @FXML
    Button ltrBtn5;
    
    @FXML
    Button ltrBtn6;
    
    @FXML
    Button ltrBtn7;
    
    @FXML
    Button deleteBtn;
    
    @FXML
    Button shuffleBtn;
    
    @FXML
    Button enterBtn;
    
    @FXML
    Label scoreLbl;
    
    @FXML
    ListView<String> wordList;
    
    @FXML
    Text feedbackTxt;
    
    /*
     * Local variables
     */
    ArrayList<Button> ltrBtns;
    
    Game g;
    
    /*
     * Next 7 methods are action responders for the letter buttons.
     * These methods will simply grab the letters from the letter button,
     * and then append the letter to the string inside the textInput element
     */
    
    /**
     * ltr1Do grabs the letter contained in ltrBtn1.
     * Then it appends the letter to the string contained in textInput.
     */
    @FXML
    public void ltr1Do() {
    	System.err.println("ltrBtn1 Pressed");
    	
    	String ltr = ltrBtn1.getText();
    	textInput.setText(textInput.getText()+ltr);
    }
    
    /**
     * ltr2Do grabs the letter contained in ltrBtn2.
     * Then it appends the letter to the string contained in textInput.
     */
    @FXML
    public void ltr2Do() {
    	System.err.println("ltrBtn2 Pressed");
    	
    	String ltr = ltrBtn2.getText();
    	textInput.setText(textInput.getText()+ltr);
    }
    
    /**
     * ltr3Do grabs the letter contained in ltrBtn3.
     * Then it appends the letter to the string contained in textInput.
     */
    @FXML
    public void ltr3Do() {
    	System.err.println("ltrBtn3 Pressed");
    	
    	String ltr = ltrBtn3.getText();
    	textInput.setText(textInput.getText()+ltr);
    }
    
    /**
     * ltr4Do grabs the letter contained in ltrBtn4.
     * Then it appends the letter to the string contained in textInput.
     */
    @FXML
    public void ltr4Do() {
    	System.err.println("ltrBtn4 Pressed");
    	
    	String ltr = ltrBtn4.getText();
    	textInput.setText(textInput.getText()+ltr);
    }
    
    /**
     * ltr5Do grabs the letter contained in ltrBtn5.
     * Then it appends the letter to the string contained in textInput.
     */
    @FXML
    public void ltr5Do() {
    	System.err.println("ltrBtn5 Pressed");
    	
    	String ltr = ltrBtn5.getText();
    	textInput.setText(textInput.getText()+ltr);
    }
    
    /**
     * ltr6Do grabs the letter contained in ltrBtn6.
     * Then it appends the letter to the string contained in textInput.
     */
    @FXML
    public void ltr6Do() {
    	System.err.println("ltrBtn6 Pressed");
    	
    	String ltr = ltrBtn6.getText();
    	textInput.setText(textInput.getText()+ltr);
    }
    
    /**
     * ltr7Do grabs the letter contained in ltrBtn7.
     * Then it appends the letter to the string contained in textInput.
     */
    @FXML
    public void ltr7Do() {
    	System.err.println("ltrBtn7 Pressed");
    	
    	String ltr = ltrBtn7.getText();
    	textInput.setText(textInput.getText()+ltr);	//appending new letter
    }
    
    /**
     * deleteBtnDo responds when the delete button is pressed.
     * It will reach into the textInput element, and delete the
     * last letter in the string contained in textInput
     */
    @FXML
    public void deleteBtnDo() {
    	System.err.println("deleteBtn Pressed");
    	
    	String word = textInput.getText();
    	textInput.setText(word.substring(0, word.length()-1));	//removing last letter
    }
    
    /**
     * shuffleBtnDo responds when the shuffle button is pressed.
     * It will randomly rearrange the letter buttons, excluding
     * the core letter.
     */
    @FXML
    public void shuffleBtnDo() {
    	System.err.println("shuffleBtn Pressed");
    	
    	//grabbing letters from Game instance
    	List<String> copy = new ArrayList<String>(Arrays.asList(g.getLtrs()));
    	copy.remove(g.getCoreLtr());	//excluding core letter
    	
    	//randomly grabbing a letter from list of letters
    	String l1 = copy.get((int) (Math.random()*copy.size()));
    	copy.remove(l1);	//preventing letter from being picked again
    	
    	//Doing it again
    	String l2 = copy.get((int) (Math.random()*copy.size()));
    	copy.remove(l2);
    	
    	//Doing it again
    	String l3 = copy.get((int) (Math.random()*copy.size()));
    	copy.remove(l3);
    	
    	//Doing it again
    	String l5 = copy.get((int) (Math.random()*copy.size()));
    	copy.remove(l5);
    	
    	//Doing it again
    	String l6 = copy.get((int) (Math.random()*copy.size()));
    	copy.remove(l6);
    	
    	//Doing it again
    	String l7 = copy.get((int) (Math.random()*copy.size()));
    	copy.remove(l7);
    	
    	//Giving each letter button its new letter
    	ltrBtn1.setText(l1.toUpperCase());
    	ltrBtn2.setText(l2.toUpperCase());
    	ltrBtn3.setText(l3.toUpperCase());
    	ltrBtn5.setText(l5.toUpperCase());
    	ltrBtn6.setText(l6.toUpperCase());
    	ltrBtn7.setText(l7.toUpperCase());
    	
    	//Providing feedback to user
    	feedbackTxt.setVisible(true);
    	feedbackTxt.setText("Shuffled!");
    }
    
    /**
     * enterBtnDo responds when the enter button is pressed.
     * It grabs the string inside the textInput element and hands it over to
     * the game instance, so that it can check whether the guess is correct.
     * If the guess is correct, this method tells the game instance to update
     * its local fields, and update the GUI accordingly.
     */
    @FXML
    public void enterBtnDo() {
    	System.err.println("enterBtn Pressed");
    	
    	//clearing the wordList
    	wordList.getItems().clear();
    	
    	//absolutely ROBBING the textInput of the guess
    	String guess = textInput.getText().toLowerCase();
    	
    	//checking the guess
    	if(g.checkGuess(guess)) {
    		System.err.println("Correct Guess");
    		
    		//providing feedback
    		feedbackTxt.setVisible(true);
    		feedbackTxt.setText("Correct!");
    		
    		//updating score and list of guessed words
    		g.awardPoints(guess);
    		g.getGuessed().add(guess.toUpperCase());
    	}
    	
    	//if guess is wrong...
    	else {
    		System.err.println("Incorrect Guess");
    		
    		//providing feedback
    		feedbackTxt.setVisible(true);
    		feedbackTxt.setText("Try Again");
    	}
    	
    	textInput.setText("");	//clearing textInput for next guess
    	
    	//updating GUI with new game metrics
    	scoreLbl.setText(String.valueOf(g.getScore()));
    	
    	//filling wordList with guessed words
    	for(int i=0 ; i<g.getGuessed().size() ; i++) {
    		wordList.getItems().add(g.getGuessed().get(i));
    	}
    }

	@FXML
	private void switchToTutorial() throws IOException {
		System.err.println("Switching to Tutorial");
		
		App.setRoot("tutorial");
	}

	/**
	 * initializing the GUI for a new game.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.err.println("Setting up...");
		
		//initializing local variables
		g = new Game();
		ltrBtns = new ArrayList<>();
		
		//filling ltrBtns
		ltrBtns.add(ltrBtn1);
		ltrBtns.add(ltrBtn2);
		ltrBtns.add(ltrBtn3);
		ltrBtns.add(ltrBtn4);
		ltrBtns.add(ltrBtn5);
		ltrBtns.add(ltrBtn6);
		ltrBtns.add(ltrBtn7);
		
		//Giving letter buttons their letters
		for(int i=0 ; i<ltrBtns.size() ; i++) {
			ltrBtns.get(i).setText(g.getLtrs()[i].toUpperCase());
		}
		
		//preparing scoreLbl for a new game
		scoreLbl.setText(String.valueOf(g.getScore()));
		
		System.err.println("Game On!");
	}
}
