package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

public class CardProductController {

    @FXML
    private Label productName;

    @FXML
    private Label productPrice;

    @FXML
    private Spinner<Integer> productQuantity;

    private Products product;


    public void initData(Products product) {
        this.product = product;
        productName.setText(product.getDescription());
        productPrice.setText(String.valueOf(product.getPrice()));
    }

    @FXML
    void onClickAddToCart(ActionEvent event) {
        // You can replace this with actual "Add to Cart" logic
    }

}
