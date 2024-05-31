package ict.aimsprojectweek5.screen.customer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import ict.aimsprojectweek5.cart.Cart;
import ict.aimsprojectweek5.store.Store;
import ict.aimsprojectweek5.media.Media;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartController {
    private Cart cart;
    private Store store;

    public CartController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private Label costLabel;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        // Xử lý sự kiện khi nút "Play" được nhấn
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        // Xử lý sự kiện khi nút "Remove" được nhấn
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        // Xử lý sự kiện khi nút "View Store" được nhấn
    }

    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }
    }
}
