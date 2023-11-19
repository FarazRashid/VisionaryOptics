package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.io.IOException;
import java.util.List;

public class CardProductController  {

    public Button deleteFromCart;
    @FXML
    private Label productName;

    @FXML
    private Label productPrice;

    @FXML
    private Spinner<Integer> productQuantity;

    private Products product;

    private Cart cart;




    public void initData(Products product) {
        this.cart=HelloApplication.getInstance().getCart();
        this.product = product;
        productName.setText(product.getDescription());
        productPrice.setText(String.valueOf(product.getPrice()));
        productQuantity.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 0));

    }

    @FXML
    void onClickAddToCart(ActionEvent event) {
        int quantityToAdd = productQuantity.getValue();

        List<Products> products = cart.getProducts();
        boolean productExistsInCart = products.stream()
                .anyMatch(p -> p.getDescription().equals(product.getDescription()));

        if (productExistsInCart) {
            // Product is already in the cart, update the quantity
            cart.updateCartItem(product, "increment product quantity", quantityToAdd);
        } else {
            // Product is not in the cart, add it with the selected quantity
            cart.updateCartItem(product, "insert product", quantityToAdd);
        }

        HelloApplication.getInstance().setCart(cart);

        try {
            // Switch to the cart page after adding the product to the cart
            HelloApplication.getInstance().switchScene("cart-page.fxml", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


