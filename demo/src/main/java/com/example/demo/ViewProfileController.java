package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;

import java.io.IOException;
import java.util.List;

public class ViewProfileController {

    @FXML
    private Label addressLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Button goBackToHomePageButton;

    @FXML
    private ImageView logoImageView;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private Button saveButton;

    @FXML
    private Label usernameLabel;

    @FXML
    void onClickEditProfileButton(ActionEvent event) {
        try {
            HelloApplication.getInstance().switchScene("edit-profile.fxml", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        Customer customer = HelloApplication.getInstance().getCustomer();
        usernameLabel.setText(customer.getName());
        emailLabel.setText(customer.getEmail());
        phoneNumberLabel.setText(customer.getPhoneNumber());
        addressLabel.setText(customer.getAddress());

    }

    @FXML
    void onClickSwitchToHomePage(ActionEvent event) {
        try {
            HelloApplication.getInstance().switchScene("customer-homepage.fxml", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
