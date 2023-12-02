package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.HelloApplication;
import com.example.demo.Systems.DbHandler;
import com.example.demo.Users.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EditProfileController {

    private static final Logger logger = Logger.getLogger(EditProfileController.class.getName());

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

    private List<String> editedFields = new ArrayList<>();

    // Existing code...

    @FXML
    void onChange(InputMethodEvent event) {
        trackEditedField("name");
    }

    @FXML
    void onChangeAddress(InputMethodEvent event) {
        trackEditedField("address");
    }

    @FXML
    void onChangeEmail(InputMethodEvent event) {
        trackEditedField("email");
    }

    @FXML
    void onChangePassword(InputMethodEvent event) {
    }

    @FXML
    void onChangePhoneNumber(InputMethodEvent event) {
        trackEditedField("phonenumber");
    }

    @FXML
    void onChangeUsername(InputMethodEvent event) {
        trackEditedField("name");
    }

    private void trackEditedField(String field) {
        if (!editedFields.contains(field)) {
            editedFields.add(field);
        }
    }

    @FXML boolean validateCustomer(Customer customer){
        // validate the customer object
        if (customer.getName().isBlank() || customer.getEmail().isBlank() || customer.getPhoneNumber().isBlank() || customer.getAddress().isBlank()) {
            registerMessageLabel.setText("Please fill in all the fields.");
            return false;
        }
        if (!customer.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            registerMessageLabel.setText("Please enter a valid email address.");
            return false;
        }
        if (!customer.getPhoneNumber().matches("^\\+?[0-9]{10,13}$")) {
            registerMessageLabel.setText("Please enter a valid phone number.");
            return false;
        }
        if (!registerPasswordTextField.getText().isBlank()) {
            if (!customer.getPassword().equals(registerPasswordTextField.getText())) {
                registerMessageLabel.setText("Please enter the correct password.");
                return false;
            }
        }
        else{
            registerMessageLabel.setText("Please enter the password to make changes.");
        }
        return true;
    }

    @FXML
    void onClickSaveButton(ActionEvent event) {

        Customer customer = HelloApplication.getInstance().getCustomer();

        customer.setName(registerUsernameTextField.getText());
        customer.setEmail(registerEmailTextField.getText());
        customer.setPhoneNumber(registerPhoneTextField.getText());
        customer.setAddress(registerAddressField.getText());

        if (!validateCustomer(customer)) return;



        DbHandler dbHandler = new DbHandler();
        if(dbHandler.update(customer, editedFields)){
            registerMessageLabel.setText("Success! Changes have been updated");
            Customer updatedCustomer = dbHandler.getCustomer(customer.getEmail());
            HelloApplication.getInstance().setCustomer(updatedCustomer);
            editedFields.clear();
        }
        else{
            if(editedFields.isEmpty())
                registerMessageLabel.setText("No changes were made!");
            else
                registerMessageLabel.setText("Error! Changes could not be updated");
        }
    }

    @FXML
    void initialize() {
        Customer customer = HelloApplication.getInstance().getCustomer();
        registerUsernameTextField.setText(customer.getName());
        registerEmailTextField.setText(customer.getEmail());
        registerPhoneTextField.setText(customer.getPhoneNumber());
        registerAddressField.setText(customer.getAddress());

        registerUsernameTextField.textProperty().addListener((observable, oldValue, newValue) -> trackEditedField("name"));

        registerAddressField.textProperty().addListener((observable, oldValue, newValue) -> trackEditedField("address"));

        registerEmailTextField.textProperty().addListener((observable, oldValue, newValue) -> trackEditedField("email"));

        registerPhoneTextField.textProperty().addListener((observable, oldValue, newValue) -> trackEditedField("phonenumber"));
    }
    @FXML
    void onClickSwitchToHomePage(ActionEvent event) {
        try {
            HelloApplication.getInstance().switchScene("customer-homepage.fxml", "");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to switch to customer-homepage.", e);
        }
    }

}
