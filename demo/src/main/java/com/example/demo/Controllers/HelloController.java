package com.example.demo.Controllers;

import com.example.demo.HelloApplication;
import com.example.demo.Inventory.Cart;
import com.example.demo.Systems.DbHandler;
import com.example.demo.Users.Customer;
import com.example.demo.password.BasicPasswordHashingStrategy;
import com.example.demo.password.PasswordHashingStrategy;
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

    private PasswordHashingStrategy passwordHashingStrategy;

    public void setPasswordHashingStrategy(PasswordHashingStrategy passwordHashingStrategy) {
        this.passwordHashingStrategy = passwordHashingStrategy;
    }


    @FXML
    void onClickLoginButton(ActionEvent event) throws IOException {
        try {
            this.passwordHashingStrategy = new BasicPasswordHashingStrategy();

            if (!loginEmailTextField.getText().isBlank() && !loginPasswordTextField.getText().isBlank() && validateEmail()) {
                String enteredEmail = loginEmailTextField.getText();
                String enteredPassword = loginPasswordTextField.getText();

                DbHandler dbHandler = new DbHandler();

                // Retrieve the hashed password from the database based on the entered email
                String storedHashedPassword = dbHandler.getHashedPassword(enteredEmail);

                if (enteredPassword.equals(storedHashedPassword) || storedHashedPassword != null && (passwordHashingStrategy.checkPassword(enteredPassword, storedHashedPassword))) {
                    // Login successful, switch to the desired scene
                    Customer customer = dbHandler.getCustomer(enteredEmail);
                    Cart cart = dbHandler.getCart(customer);
                    HelloApplication.getInstance().setCustomer(customer);
                    HelloApplication.getInstance().setCart(cart);

                    HelloApplication.getInstance().switchScene("customer-homepage.fxml", "");
                } else {
                    // Login failed, you may show an error message or take appropriate action
                    loginMessageLabel.setText("Login failed. Invalid credentials.");
                }
            } else {
                loginMessageLabel.setText("Please enter username and password!");
            }
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace(); // Log or handle the exception as needed
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
