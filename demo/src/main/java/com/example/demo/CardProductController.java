package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

import java.util.List;

public class CardProductController {

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
    }

    @FXML
    void onClickAddToCart(ActionEvent event) {


        List<Products> products = cart.getProducts();
        if(products.contains(product)){
            cart.updateCartItem(product, "insert product", 1);
            HelloApplication.getInstance().setCart(cart);
            return;
        }
        else{
            cart.updateCartItem(product, "increment product quantity", 1);
            HelloApplication.getInstance().setCart(cart);
            return;
        }

   
    }

}
