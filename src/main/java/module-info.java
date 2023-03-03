module cs380.arosenberg {
    requires javafx.controls;
    requires javafx.fxml;
	requires junit;

    opens cs380.arosenberg to javafx.fxml;
    exports cs380.arosenberg;
}
