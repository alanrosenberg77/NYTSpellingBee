module cs380.arosenberg {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
	requires java.desktop;
	requires javafx.graphics;

    opens cs380.arosenberg to javafx.fxml;
    exports cs380.arosenberg;
}
