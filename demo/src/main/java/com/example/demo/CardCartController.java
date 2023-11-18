package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;

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

    @FXML
    void onClickDeleteFromCart(ActionEvent event) {

    }

    @FXML
    void updateQuantity(InputMethodEvent event) {

    }

}
