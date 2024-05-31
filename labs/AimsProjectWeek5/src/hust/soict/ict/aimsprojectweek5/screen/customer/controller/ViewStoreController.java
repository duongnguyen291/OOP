package ict.aimsprojectweek5.screen.customer.controller;

import ict.aimsprojectweek5.media.Media;
import ict.aimsprojectweek5.store.Store;
import ict.aimsprojectweek5.cart.Cart;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ViewStoreController {
    private Store store;
    private Cart cart;

    public ViewStoreController(Store store) {
        this.store = store;
    }

    @FXML
    private GridPane gridPane;

    @FXML
    void btnViewCartPressed(ActionEvent event) {
        // Implement the action to view the cart here
    }

    @FXML
    public void initialize() {
        final String FXML_ITEM_PATH = "/ict/aimsprojectweek5/screen/customer/view/Item.fxml";
        int column = 0;
        int row = 1;
        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(FXML_ITEM_PATH));
                Media media = store.getItemsInStore().get(i);
                ItemController itemController = new ItemController(media, cart);
                fxmlLoader.setController(itemController);
                AnchorPane anchorPane = fxmlLoader.load();
                itemController.setData(media);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
