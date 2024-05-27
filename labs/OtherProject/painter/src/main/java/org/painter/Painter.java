package org.painter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlfile = new FXMLLoader(PainterController.class.getResource("Painter.fxml"));
//      Parent root = FXMLLoader.load(getClass().getResource("org/painter/Painter.fxml"));
        Scene scene = new Scene(fxmlfile.load());
        stage.setTitle("Painter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
