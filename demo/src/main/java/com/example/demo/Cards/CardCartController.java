package com.example.demo.Cards;
import com.example.demo.Inventory.Cart;
import com.example.demo.Systems.DbHandler;
import com.example.demo.HelloApplication;
import com.example.demo.Inventory.Products;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class CardCartController {

    @FXML
    private Label cardCartCategory;

    @FXML
    private ImageView cardCartImage;

    @FXML
    private Label cardCartName;

    @FXML
    private Label cardCartPrice;

    @FXML
    private Label cardCartQuantity;

    @FXML
    private Spinner<Integer> cardCartSpinner;

    @FXML
    private Label cartCardId;

    @FXML
    private Button deleteFromCart;

    private Products currentProduct;

    // Reference to the Cart object
    private Cart cart;

    private boolean spinnerListenerAdded = false;
    private ChangeListener<Integer> spinnerChangeListener;



    public void setCart(Cart cart) {
        this.cart = HelloApplication.getInstance().getCart();
    }

    @FXML
    void onClickDeleteFromCart(ActionEvent event) throws IOException {
        // Get the product ID from the label
        int productId = Integer.parseInt(cartCardId.getText());
        // Call the deleteCartItem method in the Cart class
        cart.updateCartItem(currentProduct, "delete product", 0);
        DbHandler dbHandler = new DbHandler();
        dbHandler.updateCartTotalAmount(cart.getCartId().toString(), cart.getTotalAmount());
        removeSpinnerListener();
        HelloApplication.getInstance().setCart(cart);
        HelloApplication.getInstance().switchScene("cart-page.fxml", "");
    }

    @FXML
    void updateQuantity(Integer newQuantity) throws IOException {

        int productId = Integer.parseInt(cartCardId.getText());

        int currentQuantity = Integer.parseInt(cardCartQuantity.getText());

        // Determine if it's an increment or decrement
        String action;
        int quantityChange = Math.abs(newQuantity - currentQuantity);
        if (newQuantity > currentQuantity) {
            action = "increment product quantity";
        } else if (newQuantity < currentQuantity) {
            action = "deduct product quantity";
        } else {
            // Quantity didn't change, handle this case if needed
            return;
        }

        // Call the updateCartItem method in the Cart class
        cart.updateCartItem(currentProduct, action, quantityChange);
        DbHandler dbHandler = new DbHandler();
        dbHandler.updateCartTotalAmount(cart.getCartId().toString(), cart.getTotalAmount());
        removeSpinnerListener();
        HelloApplication.getInstance().setCart(cart);
        HelloApplication.getInstance().switchScene("cart-page.fxml", "");
    }

    public void initData(Products products) {
        this.cart = HelloApplication.getInstance().getCart();
        currentProduct = products;
        cardCartName.setText(products.getDescription());
        cardCartPrice.setText("$" + String.valueOf(products.getPrice()* products.getQuantity()));
        cardCartCategory.setText(products.getCategory());
        cardCartQuantity.setText(String.valueOf(products.getQuantity()));
        cartCardId.setText(String.valueOf(products.getProductId()));

        Image image = new Image("file:" + "Assets/"+ products.getProductId()+".jpg", 229, 130, false, false);
        //if image not found display imageNotFound.jpg
        if(image.isError()){
            image = new Image("file:" + "Assets/imageNotFound.jpg", 229, 130, false, false);
        }
        cardCartImage.setImage(image);

        // Initialize the Spinner with a value factory
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, products.getQuantity());
        cardCartSpinner.setValueFactory(valueFactory);

        // Add a listener to the valueProperty of the Spinner only if it hasn't been added before
        if (!spinnerListenerAdded) {
            spinnerChangeListener = (observableValue, integer, t1) -> {
                int currentValue = cardCartSpinner.getValue();
                try {
                    updateQuantity(currentValue);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };

            cardCartSpinner.valueProperty().addListener(spinnerChangeListener);
            spinnerListenerAdded = true;
        }
    }

    private void removeSpinnerListener() {
        if (spinnerListenerAdded && spinnerChangeListener != null) {
            cardCartSpinner.valueProperty().removeListener(spinnerChangeListener);
            spinnerChangeListener = null;
            spinnerListenerAdded = false;
        }
    }
}

