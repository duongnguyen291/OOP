package ict.aimsprojectweek5.screen.customer.controller;
import ict.aimsprojectweek5.cart.*;
import ict.aimsprojectweek5.media.*;
import ict.aimsprojectweek5.store.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;
import java.text.DecimalFormat;
public class CartController {
    private Cart cart;
    private Store store;

    public CartController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder;


    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Place order");
        alert.setHeaderText("Are you sure want to place order?");
        alert.setContentText("Total cost: " + roundTotalCost(cart.totalCost()) + " $");

        // option != null.
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK) {
            cart.clear();
            updateTotalCost();
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Place order");
            alert1.setHeaderText(null);
            alert1.setContentText("Order placed successfully!");
            alert1.showAndWait();
        } else if (option.get() == ButtonType.CANCEL) {

        } else {}

    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        try {
            ((Playable)media).play();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        updateTotalCost();

    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String FXML_STORE_PATH = "ict/aimsprojectweek5/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML_STORE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        if(cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }

        costLabel.setText(roundTotalCost(cart.totalCost()) + " $");
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                showFilteredMedia(newValue);
            }
        });


    }

    void updateButtonBar(Media media) {
        if(media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            if(media instanceof Playable) {
                btnPlay.setVisible(true);
            } else {
                btnPlay.setVisible(false);
            }
        }
    }

    void showFilteredMedia(String filter) {
        if(filter == null || filter.isEmpty()) {
            tblMedia.setItems(cart.getItemsOrdered());
        } else {
            if(radioBtnFilterId.isSelected()) {
                try {
                    tblMedia.setItems(cart.searchByID(Integer.parseInt(filter)));
                } catch (NumberFormatException e) {
                    tblMedia.setItems(null);
                }
            } else if(radioBtnFilterTitle.isSelected()) {
                tblMedia.setItems(cart.searchByTitle(filter));
            }
        }
    }

    void updateTotalCost() {
        costLabel.setText(cart.totalCost() + " $");
    }

    String roundTotalCost(float totalCost) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(totalCost);

    }

}