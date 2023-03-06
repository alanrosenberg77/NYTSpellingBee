package cs380.arosenberg;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

	@FXML
	private void switchToSecondary() throws IOException {
		App.setRoot("secondary");
	}

	public String word;

	public int assignPointValue(String word) {
    	//the pangram is worth an additional seven points. 
    	//if the unique letter count is 7, then an additional 7 points should be awarded
    	String orgInput = word.toLowerCase();
        int count = 0;
        int stringLength = word.length();
        for( int i = 0; i<stringLength; i++){
            for(int j = 2; j > j-i-1; j--){
                char temp = orgInput.charAt(i);
                if (temp == orgInput.charAt(j)){
                    count++;
                }
            }
        }
        int bonus = 0;
    if (stringLength == 7) {
    	 bonus = 7;
    }
    	//the nyt says that all words are worth the same amount of points as their length
    	int length = word.length();
    	return length + bonus;
	}
}
