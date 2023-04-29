package cs380.arosenberg;

import java.io.IOException;
import javafx.fxml.FXML;

public class TutorialController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}