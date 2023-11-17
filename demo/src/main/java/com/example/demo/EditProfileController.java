package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;

import java.util.List;

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
        Customer customer = HelloApplication.getInstance().getCustomer();
        // Update the customer object
        customer.setName(registerUsernameTextField.getText());
        customer.setEmail(registerEmailTextField.getText());
        customer.setPhoneNumber(registerPhoneTextField.getText());
        customer.setAddress(registerAddressField.getText());

        // validate the customer object
        if (customer.getName().isBlank() || customer.getEmail().isBlank() || customer.getPhoneNumber().isBlank() || customer.getAddress().isBlank()) {
            registerMessageLabel.setText("Please fill in all the fields.");
            return;
        }
        if (!customer.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            registerMessageLabel.setText("Please enter a valid email address.");
            return;
        }
        if (!customer.getPhoneNumber().matches("^\\+?[0-9]{10,13}$")) {
            registerMessageLabel.setText("Please enter a valid phone number.");
            return;
        }
        if (!registerPasswordTextField.getText().isBlank()) {
            if (!customer.getPassword().equals(registerPasswordTextField.getText())) {
                registerMessageLabel.setText("Please enter the correct password.");
                return;
            }
        }
        else{
            registerMessageLabel.setText("Please enter the password to make changes.");
        }

        DbHandler dbHandler = new DbHandler();
        dbHandler.update(customer, List.of("name", "email", "phoneNumber", "address"));

        Customer updatedCustomer = dbHandler.getCustomer(customer.getEmail());
        HelloApplication.getInstance().setCustomer(updatedCustomer);

        registerMessageLabel.setText("Success! Changes have been updated");


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
