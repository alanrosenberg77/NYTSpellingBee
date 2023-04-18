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
    public void ltrBtnDo() {
    	
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
		countLbl.setText(String.valueOf(g.getGuessed().length));
		
		
	}
}
