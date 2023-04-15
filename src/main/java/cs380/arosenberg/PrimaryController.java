package cs380.arosenberg;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController {

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
    Label countLbl;
    
    @FXML
    ListView<String> wordList;
    
    @FXML
    public void ltrBtnDo() {
    	// TODO give letter buttons functionality
    }
    
    @FXML
    public void deleteBtnDo() {
    	// TODO give delete button functionality
    }
    
    @FXML
    public void shuffleBtnDo() {
    	// TODO give shuffle button functionality
    }
    
    @FXML
    public void enterBtnDo() {
    	// TODO give enter button functionality
    }

	@FXML
	private void switchToSecondary() throws IOException {
		App.setRoot("secondary");
	}

	public String word;

	public int assignPointValue(String word) {
		// the pangram is worth an additional seven points.
		// if the unique letter count is 7, then an additional 7 points should be
		// awarded
		String orgInput = word.toLowerCase();
		int count = 0;
		int stringLength = word.length();
		for (int i = 0; i < stringLength; i++) {
			for (int j = 2; j > j - i - 1; j--) {
				char temp = orgInput.charAt(i);
				if (temp == orgInput.charAt(j)) {
					count++;
				}
			}
		}
		int bonus = 0;
		if (stringLength == 7) {
			bonus = 7;
		}
		// the nyt says that all words are worth the same amount of points as their
		// length
		int length = word.length();
		return length + bonus;
	}
}
