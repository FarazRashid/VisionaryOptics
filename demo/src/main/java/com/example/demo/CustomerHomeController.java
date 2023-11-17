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

public class CustomerHomeController {

    @FXML
    private Label customerHomePageUserName;

    @FXML
    private GridPane productGrid;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button signOutButton;

    private final DbHandler dbHandler = new DbHandler();

    @FXML
    void initialize() {
        // Fetch products from the database
        List<Products> products = dbHandler.getAllProducts();

        // Dynamically create and populate the card for each product
        for (int i = 0; i < products.size(); i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("card-product.fxml"));
                productGrid.add(loader.load(), i % 2, i / 2);
                CardProductController controller = loader.getController();
                controller.initData(products.get(i));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void onClickSignOut(ActionEvent event) {

    }

}
