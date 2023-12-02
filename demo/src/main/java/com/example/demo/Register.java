package com.example.demo;

import com.example.demo.password.BCrypt;
import com.example.demo.password.BasicPasswordHashingStrategy;
import com.example.demo.password.PasswordHashingStrategy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;

import java.io.IOException;

public class Register {

    private PasswordHashingStrategy passwordHashingStrategy;

    public void setPasswordHashingStrategy(PasswordHashingStrategy passwordHashingStrategy) {
        this.passwordHashingStrategy = passwordHashingStrategy;
    }
    public Button switchToLoginButton;
    @FXML
    private ImageView logoImageView;

    @FXML
    private TextField registerAddressField;

    @FXML
    private Button registerButton;

    @FXML
    private PasswordField registerConfirmPasswordTextField;

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
    void onClickRegisterButton(ActionEvent event) {
        try {

            this.passwordHashingStrategy = new BasicPasswordHashingStrategy();

            if (validateFields() && validatePasswordMatch() && validatePhoneNumber() && validateEmail()) {
                DbHandler dbHandler = new DbHandler();
                String username = registerUsernameTextField.getText();
                String password = registerPasswordTextField.getText();
                String email = registerEmailTextField.getText();
                String phone = registerPhoneTextField.getText();
                String address = registerAddressField.getText();

                // Use password hashing strategy
                String generatedSalt = BCrypt.gensalt();


                String hashedPassword = passwordHashingStrategy.hashPassword(password, generatedSalt);

                Customer customer = new Customer(username, hashedPassword, email, phone, address, 0);

                if (dbHandler.create(customer)) {
                    registerMessageLabel.setText("Account created successfully!");
                } else {
                    registerMessageLabel.setText("Account creation failed!");
                }

            }
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace(); // Log or handle the exception as needed
        }
    }

    @FXML
    void onClickSwitchToLogin(ActionEvent event) throws IOException {
        HelloApplication.getInstance().switchScene("hello-view.fxml", "Assets/logo.JPG");
    }


    private boolean validateFields() {
        if (isTextFieldEmpty(registerUsernameTextField) || isTextFieldEmpty(registerPasswordTextField) ||
                isTextFieldEmpty(registerConfirmPasswordTextField) || isTextFieldEmpty(registerEmailTextField) ||
                isTextFieldEmpty(registerPhoneTextField) || isTextFieldEmpty(registerAddressField)) {
            registerMessageLabel.setText("Please fill in all the fields!");
            return false;
        }
        return true;
    }

    private boolean validatePasswordMatch() {
        if (!registerPasswordTextField.getText().equals(registerConfirmPasswordTextField.getText())) {
            registerMessageLabel.setText("Password does not match!");
            return false;
        }
        return true;
    }

    private boolean validatePhoneNumber() {
        if (registerPhoneTextField.getText().length() != 13) {
            registerMessageLabel.setText("Phone number must be 13 digits!");
            return false;
        }
        return true;
    }

    private boolean validateEmail() {
        if (!registerEmailTextField.getText().contains("@") || !registerEmailTextField.getText().contains(".com")) {
            registerMessageLabel.setText("Email must contain @ and .com!");
            return false;
        }
        return true;
    }

    private boolean isTextFieldEmpty(TextField textField) {
        return textField.getText().isBlank();
    }

    public void onChange(InputMethodEvent inputMethodEvent) {
    }
}
