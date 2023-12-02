package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardOrderProduct {

    public ImageView cardOrderProductImage;
    @FXML
    private Label CardId;

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

    public void init(Products product) {

        CardId.setText(String.valueOf(product.getProductId()));
        cardCartName.setText(product.getDescription());
        cardCartPrice.setText("$" + String.valueOf(product.getPrice()* product.getQuantity()));
        cardCartCategory.setText(product.getCategory());
        cardCartQuantity.setText(String.valueOf(product.getQuantity()));
        Image image = new Image("file:" + "Assets/"+ product.getProductId()+".jpg", 229, 130, false, false);
        if(image.isError()){
            image = new Image("file:" + "Assets/imageNotFound.jpg", 229, 130, false, false);
        }
        cardOrderProductImage.setImage(image);
    }

}
