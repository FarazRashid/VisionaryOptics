package com.example.demo.Controllers;

import com.example.demo.Cards.CardOrder;
import com.example.demo.HelloApplication;
import com.example.demo.Inventory.Order;
import com.example.demo.Systems.DbHandler;
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

public class OrdersPageController {

    @FXML
    private GridPane orderGrid;

    @FXML
    private ScrollPane orderScrollPane;

    @FXML
    private Label customerHomePageUserName;

    @FXML
    private Button goBackHomeButton;

    @FXML
    private Button signOutButton;

    @FXML
    private Button trackOrder;

    @FXML
    private Button viewProfileButton;

    @FXML
    void initialize() {

        DbHandler dbHandler= new DbHandler();
        List<Order> orderItems = dbHandler.getOrders(HelloApplication.getInstance().getCustomer().getCustomerId()); // Replace with your actual method

        // Create a VBox to hold rows
        VBox rowsVBox = new VBox();
        rowsVBox.setSpacing(10); // Adjust the spacing as needed

        // Dynamically create and populate the card for each order item
        for (int i = 0; i < orderItems.size(); i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("card-order.fxml"));
                rowsVBox.getChildren().add(loader.load());

                CardOrder controller = loader.getController();
                controller.initData(orderItems.get(i));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Set the VBox as the content of the ScrollPane
        orderScrollPane.setContent(rowsVBox);

        // You can add additional logic here, e.g., updating total amounts, etc.
    }

    public void onClickGoBackHome(ActionEvent actionEvent) {
        try {
            HelloApplication.getInstance().switchScene("customer-homepage.fxml", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    void onClickTrackOrder(ActionEvent event) {
        try{
            HelloApplication.getInstance().switchScene("track-order.fxml", "");
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


}
