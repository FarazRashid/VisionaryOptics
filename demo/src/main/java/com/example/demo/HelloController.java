package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class HelloController {

    public Button switchToRegisterButton;
    @FXML
    private Button loginButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private PasswordField loginPasswordTextField;

    @FXML
    private TextField loginEmailTextField;

    @FXML
    private ImageView logoImageView;

    @FXML
    void onClickLoginButton(ActionEvent event) {

        if(loginEmailTextField.getText().isBlank() == false && loginPasswordTextField.getText().isBlank() == false && validateEmail()){
            loginMessageLabel.setText("Login Successful!");
        }
        else{
            loginMessageLabel.setText("Please enter username and password!");
        }

    }
    @FXML
    void onClickSwitchToRegister(ActionEvent event) throws IOException {
        // get reference to existing hello application and switch scene
        HelloApplication.getInstance().switchScene("register.fxml", "Assets/logo.JPG");
    }

    private boolean validateEmail() {
        if (!loginEmailTextField.getText().contains("@") || !loginEmailTextField.getText().contains(".com")) {
            loginMessageLabel.setText("Email must contain @ and .com!");
            return false;
        }
        return true;
    }

}
