package com.example.demo.Cards;
import com.example.demo.Inventory.Cart;
import com.example.demo.Systems.DbHandler;
import com.example.demo.HelloApplication;
import com.example.demo.Inventory.Products;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CardProductController  {

    public Button deleteFromCart;
    public ImageView cardProductImage;
    @FXML
    private Label productName;

    @FXML
    private Label productPrice;

    @FXML
    private Spinner<Integer> productQuantity;

    private Products product;

    private Cart cart;




    public void initData(Products product) {
        this.cart= HelloApplication.getInstance().getCart();
        this.product = product;
        productName.setText(product.getDescription());
        productPrice.setText(String.valueOf(product.getPrice()));
        productQuantity.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 0));


        Image image = new Image("file:" + "Assets/"+ product.getProductId()+".jpg", 229, 130, false, false);
        if(image.isError()){
            image = new Image("file:" + "Assets/imageNotFound.jpg", 229, 130, false, false);
        }
        cardProductImage.setImage(image);

    }

    @FXML
    void onClickAddToCart(ActionEvent event) {
        int quantityToAdd = productQuantity.getValue();
        product.setQuantity(quantityToAdd);
        // Ensure the cart is not null
        if (cart == null) {
            cart = new Cart();
        }

        List<Products> products = cart.getProducts();

        if(products==null){
            products= new ArrayList<Products>();
            cart.setProducts(products);
        }

        if (products.isEmpty()) {
            // Cart is empty, add the product with the selected quantity
            cart.updateCartItem(product, "insert product", quantityToAdd);
            DbHandler dbHandler = new DbHandler();
            dbHandler.updateCartTotalAmount(cart.getCartId().toString(), cart.getTotalAmount());
        } else {
            boolean productExistsInCart = products.stream()
                    .anyMatch(p -> {
                        if (product.getDescription() != null) {
                            return p.getDescription() != null && p.getDescription().equals(product.getDescription());
                        }
                        return false;
                    });

            if (productExistsInCart) {
                // Product is already in the cart, update the quantity
                cart.updateCartItem(product, "increment product quantity", quantityToAdd);
                DbHandler dbHandler = new DbHandler();
                dbHandler.updateCartTotalAmount(cart.getCartId().toString(), cart.getTotalAmount());
            } else {
                // Product is not in the cart, add it with the selected quantity
                cart.updateCartItem(product, "insert product", quantityToAdd);
                DbHandler dbHandler = new DbHandler();
                dbHandler.updateCartTotalAmount(cart.getCartId().toString(), cart.getTotalAmount());
            }
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


