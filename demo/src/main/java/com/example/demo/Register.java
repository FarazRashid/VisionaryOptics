package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class Register {

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
        if (validateFields() && validatePasswordMatch() && validatePhoneNumber() && validateEmail()) {
            registerMessageLabel.setText("Register Successful!");
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

}
