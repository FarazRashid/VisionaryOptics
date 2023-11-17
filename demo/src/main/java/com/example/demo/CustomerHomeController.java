package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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

        // Create a VBox to hold rows
        VBox rowsVBox = new VBox();
        rowsVBox.setSpacing(10); // Adjust the spacing as needed

        // Dynamically create and populate rows with 3 columns for each product
        for (int i = 0; i < products.size(); i += 3) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("card-product.fxml"));
                HBox rowHBox = new HBox();

                // Add 3 columns to the row
                for (int j = 0; j < 3 && i + j < products.size(); j++) {
                    loader = new FXMLLoader(getClass().getResource("card-product.fxml"));
                    rowHBox.getChildren().add(loader.load());

                    CardProductController controller = loader.getController();
                    controller.initData(products.get(i + j));
                }

                rowsVBox.getChildren().add(rowHBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Set the VBox as the content of the ScrollPane
        scrollPane.setContent(rowsVBox);
    }

    @FXML
    void onClickSignOut(ActionEvent event) {

    }

}
