package ict.aimsprojectweek5.screen.customer.controller;

import ict.aimsprojectweek5.media.Media;
import ict.aimsprojectweek5.media.Playable;
import ict.aimsprojectweek5.cart.Cart;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;

public class ItemController {

    private Media media;
    private Cart cart;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    // Default constructor for JavaFX
    public ItemController() {
    }

    // Constructor with parameters
    public ItemController(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        System.out.println("Hello");
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        System.out.println("Hello");
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 110));
        }
    }
}
