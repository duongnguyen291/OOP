module org.check {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.check to javafx.fxml;
    exports org.check;
}