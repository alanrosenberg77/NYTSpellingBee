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

public class PrimaryController implements Initializable {

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
    
    ArrayList<Button> ltrBtns;
    
    @FXML
    Button deleteBtn;
    
    @FXML
    Button shuffleBtn;
    
    @FXML
    Button enterBtn;
    
    @FXML
    Label scoreLbl;
    
    @FXML
    Label countLbl;
    
    @FXML
    ListView<String> wordList;
    
    Game g;
    
    @FXML
    public void ltr1Do() {
    	String ltr = ltrBtn1.getText();
    	textInput.setText(textInput.getText()+ltr);
    }
    
    @FXML
    public void ltr2Do() {
    	String ltr = ltrBtn2.getText();
    	textInput.setText(textInput.getText()+ltr);
    }
    
    @FXML
    public void ltr3Do() {
    	String ltr = ltrBtn3.getText();
    	textInput.setText(textInput.getText()+ltr);
    }
    
    @FXML
    public void ltr4Do() {
    	String ltr = ltrBtn4.getText();
    	textInput.setText(textInput.getText()+ltr);
    }
    
    @FXML
    public void ltr5Do() {
    	String ltr = ltrBtn5.getText();
    	textInput.setText(textInput.getText()+ltr);
    }
    
    @FXML
    public void ltr6Do() {
    	String ltr = ltrBtn6.getText();
    	textInput.setText(textInput.getText()+ltr);
    }
    
    @FXML
    public void ltr7Do() {
    	String ltr = ltrBtn7.getText();
    	textInput.setText(textInput.getText()+ltr);
    }
    
    @FXML
    public void deleteBtnDo() {
    	String word = textInput.getText();
    	textInput.setText(word.substring(0, word.length()-1));
    }
    
    @FXML
    public void shuffleBtnDo() {
    	
    	ArrayList<String> copy = (ArrayList<String>) Arrays.asList(g.getLtrs());
    	
    	String l1 = copy.get((int) (Math.random()*copy.size()));
    	copy.remove(l1);
    	String l2 = copy.get((int) (Math.random()*copy.size()));
    	copy.remove(l2);
    	String l3 = copy.get((int) (Math.random()*copy.size()));
    	copy.remove(l3);
    	String l4 = copy.get((int) (Math.random()*copy.size()));
    	copy.remove(l4);
    	String l5 = copy.get((int) (Math.random()*copy.size()));
    	copy.remove(l5);
    	String l6 = copy.get((int) (Math.random()*copy.size()));
    	copy.remove(l6);
    	String l7 = copy.get((int) (Math.random()*copy.size()));
    	copy.remove(l7);
    }
    
    @FXML
    public void enterBtnDo() {
    	
    	String guess = textInput.getText().toLowerCase();
    	if(g.checkGuess(guess)) {
    		g.awardPoints(guess);
    		g.getGuessed().add(guess);
    	}
    	
    	textInput.setText("");
    	scoreLbl.setText(String.valueOf(g.getScore()));
    	countLbl.setText(String.valueOf(g.getCorrectGuesses()));
    }

	@FXML
	private void switchToSecondary() throws IOException {
		App.setRoot("secondary");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		g = new Game();
		ltrBtns = new ArrayList<>();
		ltrBtns.add(ltrBtn1);
		ltrBtns.add(ltrBtn2);
		ltrBtns.add(ltrBtn3);
		ltrBtns.add(ltrBtn4);
		ltrBtns.add(ltrBtn5);
		ltrBtns.add(ltrBtn6);
		ltrBtns.add(ltrBtn7);
		
		for(int i=0 ; i<ltrBtns.size() ; i++) {
			ltrBtns.get(i).setText(g.getLtrs()[i].toUpperCase());
		}
		
		scoreLbl.setText(String.valueOf(g.getScore()));
		countLbl.setText(String.valueOf(g.getGuessed().size()));
		
		
	}
}
