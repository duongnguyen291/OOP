package ict.test.screen.customer.cart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import ict.aimsprojectweek5.store.Store;
import ict.aimsprojectweek5.cart.Cart;
import ict.aimsprojectweek5.media.Media;
import ict.aimsprojectweek5.screen.customer.controller.CartController;
public class TestViewStoreCart extends Application {
    private static Cart cart;
    private static Store store;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/ict/aimsprojectweek5/screen/customer/view/Cart.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(STORE_FXML_FILE_PATH));
        CartController cartController = new CartController(cart, store);
        fxmlLoader.setController(cartController);
        Parent parent = fxmlLoader.load();

        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cart");
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        store.initData();
//        cart = new Cart();
//        cart.initData();
        launch(args);
    }
}
