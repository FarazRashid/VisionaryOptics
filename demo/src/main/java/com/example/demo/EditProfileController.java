package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;

public class EditProfileController {

    @FXML
    private Button goBackToHomePageButton;

    @FXML
    private ImageView logoImageView;

    @FXML
    private TextField registerAddressField;

    @FXML
    private TextField registerEmailTextField;

    @FXML
    private Label registerMessageLabel;

    @FXML
    private PasswordField registerPasswordTextField;

    @FXML
    private TextField registerPhoneTextField;

    @FXML
    private TextField registerUsernameTextField;

    @FXML
    private Button saveButton;

    @FXML
    void onChange(InputMethodEvent event) {

    }

    @FXML
    void onChangeAddress(InputMethodEvent event) {

    }

    @FXML
    void onChangeEmail(InputMethodEvent event) {

    }

    @FXML
    void onChangePassword(InputMethodEvent event) {

    }

    @FXML
    void onChangePhoneNumber(InputMethodEvent event) {

    }

    @FXML
    void onChangeUsername(InputMethodEvent event) {

    }

    @FXML
    void onClickSaveButton(ActionEvent event) {
        // Get the customer object

    }

    @FXML
    void initialize() {
        Customer customer = HelloApplication.getInstance().getCustomer();
        registerUsernameTextField.setText(customer.getName());
        registerEmailTextField.setText(customer.getEmail());
        registerPhoneTextField.setText(customer.getPhoneNumber());
        registerAddressField.setText(customer.getAddress());
    }
    @FXML
    void onClickSwitchToHomePage(ActionEvent event) {
        try {
            HelloApplication.getInstance().switchScene("customer-homepage.fxml", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
