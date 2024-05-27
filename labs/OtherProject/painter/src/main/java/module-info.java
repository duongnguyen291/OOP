module org.painter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.painter to javafx.fxml;
    exports org.painter;
}