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
import java.util.List;

public class CartPageController  {

    @FXML
    public GridPane cartGrid;
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
    private ScrollPane cartScrollPane;

    private final DbHandler dbHandler = new DbHandler();
    private Cart currentCart;


    @FXML
    void initialize() {
        // Fetch cart items from the database
        Customer customer= HelloApplication.getInstance().getCustomer();
        customerHomePageUserName.setText(customer.getName());
        setCurrentCart();
        currentCart.recalculateTotal();
        List<Products> cartItems = currentCart.getProducts();

        // Create a VBox to hold rows
        VBox rowsVBox = new VBox();
        rowsVBox.setSpacing(10); // Adjust the spacing as needed

        // Dynamically create and populate the card for each cart item
        for (int i = 0; i < cartItems.size(); i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("card-cart.fxml"));
                rowsVBox.getChildren().add(loader.load());

                CardCartController controller = loader.getController();
                controller.initData(cartItems.get(i));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Set the VBox as the content of the ScrollPane
        cartScrollPane.setContent(rowsVBox);

        // Update the total amount label
        cartTotalAmount.setText("$" + String.valueOf(currentCart.getTotalAmount()));
    }

    @FXML
    void onClickCheckOut(ActionEvent event) throws IOException {
        // Handle checkout logic
        HelloApplication.getInstance().switchScene("checkout-page.fxml", "");
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
            HelloApplication.getInstance().switchScene("view-profile.fxml", "Assets/logo.JPG");
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
