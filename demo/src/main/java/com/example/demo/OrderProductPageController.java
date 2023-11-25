package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class OrderProductPageController {

    @FXML
    private Label cartTotalAmount;

    @FXML
    private Button goBackHomeButton;

    @FXML
    private GridPane orderGrid;

    @FXML
    private ScrollPane orderScrollPane;

    @FXML
    private Button signOutButton;

    @FXML
    private Button viewOrdersButton;

    @FXML
    private Button viewProfileButton;

    public void initialize() {
        DbHandler dbHandler = new DbHandler();
        Order order = HelloApplication.getInstance().getOrder();
        Cart cart = dbHandler.getCart(order.getCartId());

        cartTotalAmount.setText(String.valueOf(cart.getTotalAmount()));

        // Clear existing children
        orderGrid.getChildren().clear();

        // Create a VBox to hold rows
        VBox rowsVBox = new VBox();
        rowsVBox.setSpacing(10); // Adjust the spacing as needed

        // Dynamically create and populate the card for each cart item
        for (int i = 0; i < cart.getProducts().size(); i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("card-order-product.fxml"));
                rowsVBox.getChildren().add(loader.load());

                CardOrderProduct controller = loader.getController();
                controller.init(cart.getProducts().get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Set the VBox as the content of the ScrollPane
        orderScrollPane.setContent(rowsVBox);
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
    @FXML
    void onClickGoBackHome(ActionEvent event) {
        try {
            HelloApplication.getInstance().switchScene("customer-homepage.fxml", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void onClickViewOrders(ActionEvent event) {

        try{
            HelloApplication.getInstance().switchScene("orders-page.fxml", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
