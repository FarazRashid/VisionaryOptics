package com.example.demo;

import com.example.demo.emailSystem.EmailService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CheckoutPage {

    public CheckBox registeredAddressCheckbox;
    @FXML
    private TextField addressTextField;

    @FXML
    private TextField cardCVV;

    @FXML
    private ComboBox<String> categorySelect;

    @FXML
    private TextField creditCardNumber;

    @FXML
    private VBox creditCardPayment;

    @FXML
    private Label customerHomePageUserName;

    @FXML
    private TextField expiryDateNumber;

    @FXML
    private Button goBackHomeButton;

    @FXML
    private Button placeOrderButton;

    @FXML
    private Button signOutButton;

    @FXML
    private Button viewProfileButton;

    @FXML
    private void initialize() {
        // Initialize the ComboBox with payment options
        ObservableList<String> paymentOptions = FXCollections.observableArrayList("Pay by Card", "Pay by Cash");
        categorySelect.setItems(paymentOptions);
    }

    @FXML
    private void onClickSelectPaymentType(ActionEvent event) {
        // Handle the event when the user selects a payment method
        String selectedPayment = categorySelect.getValue();

        // Show/hide the credit card details based on the selected payment method
        if ("Pay by Card".equals(selectedPayment)) {
            creditCardPayment.setVisible(true);
        } else {
            creditCardPayment.setVisible(false);
        }
    }
    @FXML
    public void onClickGoBackHome(ActionEvent actionEvent) {
        try {
            HelloApplication.getInstance().switchScene("customer-homepage.fxml", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onClickRegisteredAddressCheckbox(ActionEvent event) {
        // Handle the event when the user checks/unchecks the registered address checkbox
        boolean isChecked = registeredAddressCheckbox.isSelected();

        // Disable/enable the addressTextField based on the checkbox state
        addressTextField.setDisable(isChecked);
    }

    @FXML
    void onClickPlaceOrder(ActionEvent event) {
        // Handle the event when the user clicks the place order button
        String selectedPayment = categorySelect.getValue();

        if (selectedPayment == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid payment method");
            alert.setContentText("Please select a valid payment method");
            alert.showAndWait();
            return;
        }

        // Show/hide the credit card details based on the selected payment method
        if ("Pay by Card".equals(selectedPayment)) {
            // Validate the credit card details
            String creditCardNumberText = creditCardNumber.getText();
            String expiryDateText = expiryDateNumber.getText();
            String cvvText = cardCVV.getText();

            if (creditCardNumberText.isBlank() || expiryDateText.isBlank() || cvvText.isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid credit card details");
                alert.setContentText("Please enter valid credit card details");
                alert.showAndWait();
                return;
            }
        }

        // Validate the address
        String addressText = addressTextField.getText();
        if (addressText.isBlank() && !registeredAddressCheckbox.isSelected()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid address");
            alert.setContentText("Please enter a valid address");
            alert.showAndWait();
            return;
        }

        Customer customer=HelloApplication.getInstance().getCustomer();

        if(registeredAddressCheckbox.isSelected()){
            addressText = HelloApplication.getInstance().getCustomer().getAddress();
        }

        HelloApplication.getInstance().getCart().proceedToCheckout(customer.getCustomerId(), selectedPayment, addressText);

        HelloApplication.getInstance().setCart(customer.updateCart());

        HelloApplication.getInstance().setCustomer(customer);

        // Show a success message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Order placed successfully");
        alert.setContentText("Your order has been placed successfully");
        alert.showAndWait();

        // Send order confirmation email
        Customer customerToSendEmail= HelloApplication.getInstance().getCustomer();
        EmailService.sendOrderConfirmation(customerToSendEmail);

        // Redirect the user to the home page
        try {
            HelloApplication.getInstance().switchScene("customer-homepage.fxml", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void onClickSignOut(ActionEvent event) {
        try {
            HelloApplication.getInstance().switchScene("hello-view.fxml", "Assets/logo.JPG");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickViewProfile(ActionEvent event) {
        try {
            HelloApplication.getInstance().switchScene("view-profile.fxml", "Assets/logo.JPG");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
