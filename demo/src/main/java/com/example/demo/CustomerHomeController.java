package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.logging.Logger;
import java.util.logging.Level;

public class CustomerHomeController {

    @FXML
    private Button CustomerSupportButton;
    public Button goToCart;

    private static final Logger logger = Logger.getLogger(CustomerHomeController.class.getName());


    @FXML
    private Label customerHomePageUserName;

    @FXML
    private GridPane productGrid;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button signOutButton;

    @FXML
    private Button viewProfileButton;
    
    @FXML
    private ComboBox<String> categorySelect;

    private final DbHandler dbHandler = new DbHandler();


    @FXML
    void initialize() {
        // Fetch products from the database
        Customer customer= HelloApplication.getInstance().getCustomer();
        customerHomePageUserName.setText(customer.getName());
        List<Products> products = dbHandler.getAllProducts();

        ObservableList<String> categories = FXCollections.observableArrayList(products.stream().map(Products::getType).distinct().toList());
        categorySelect.setItems(categories);

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
                logger.log(Level.SEVERE, "Failed to load card-product.fxml.", e);
            }
        }

        // Set the VBox as the content of the ScrollPane
        scrollPane.setContent(rowsVBox);
    }

    @FXML
    void onClickSignOut(ActionEvent event) {
        try {
            HelloApplication.getInstance().switchScene("hello-view.fxml", "Assets/logo.JPG");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to switch to hello-view.", e);
        }
    }

    @FXML
    void onClickViewProfile(ActionEvent event) {
        try {
            HelloApplication.getInstance().switchScene("view-profile.fxml", "");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to switch to view-profile.", e);
        }
    }


    public void onClickGoToCart(ActionEvent actionEvent) {
        try {
            HelloApplication.getInstance().switchScene("cart-page.fxml", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickSelectCategory(ActionEvent event) {
        // Get the selected category from the combo box
        String selectedCategory = categorySelect.getValue();

        // Fetch all products from the database
        List<Products> allProducts = dbHandler.getAllProducts();

        // Filter products based on the selected category
        List<Products> filteredProducts = allProducts.stream()
                .filter(product -> product.getType().equals(selectedCategory))
                .collect(Collectors.toList());

        // Update the displayed products
        updateDisplayedProducts(filteredProducts);
    }

    private void updateDisplayedProducts(List<Products> products) {
        // Clear existing content
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
                logger.log(Level.SEVERE, "Failed to load card-product.fxml.", e);
            }
        }

        // Set the VBox as the content of the ScrollPane
        scrollPane.setContent(rowsVBox);
    }

    @FXML
    void onClickGoToCustomerSupport(ActionEvent event) {
        try {
            HelloApplication.getInstance().switchScene("customer-support.fxml", "");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to switch to receive-customer-support.", e);
        }
    }



}
