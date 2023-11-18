package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.List;

public class CartPageController {

    public Button goBackHomeButton;
    @FXML
    private Label cartTotalAmount;

    @FXML
    private Button checkOutButton;

    @FXML
    private Label customerHomePageUserName;

    @FXML
    private Button signOutButton;

    @FXML
    private Button viewProfileButton;

    @FXML
    private GridPane cartGrid;

    private final DbHandler dbHandler = new DbHandler();
    private Cart currentCart;

    @FXML
    void initialize() {
        // Fetch cart items from the database
        setCurrentCart();
        List<Products> cartItems = currentCart.getProducts();

        // Dynamically create and populate the card for each cart item
        for (int i = 0; i < cartItems.size(); i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("card-cart.fxml"));
                cartGrid.add(loader.load(), 0, i);
                CardCartController controller = loader.getController();
                controller.initData(cartItems.get(i));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Update the total amount label
        cartTotalAmount.setText("$"+String.valueOf(currentCart.getTotalAmount()));
    }

    @FXML
    void onClickCheckOut(ActionEvent event) {
        // Handle checkout logic
    }

    @FXML
    void onClickSignOut(ActionEvent event) {
        try {
            HelloApplication.getInstance().switchScene("hello-view.fxml", "Assets/logo.JPG");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickViewProfile(ActionEvent event) {
        try {
            HelloApplication.getInstance().switchScene("view-profile.fxml", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add a method to set the current cart
    public void setCurrentCart() {
        this.currentCart = HelloApplication.getInstance().getCart();
    }

    public void onClickGoBackHome(ActionEvent actionEvent) {
        try {
            HelloApplication.getInstance().switchScene("customer-homepage.fxml", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
