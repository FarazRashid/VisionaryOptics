package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class TrackOrderController {

    @FXML
    private Button signOutButton;

    @FXML
    private Label dispatcherLabel;

    @FXML
    private Button goBackToHomePageButton;

    @FXML
    private ImageView logoImageView;

    @FXML
    private Label orderIdLabel;

    @FXML
    private Label orderStatusLabel;

    @FXML
    private Label registerMessageLabel;

    @FXML
    private Label totalAmountLabel;

    @FXML
    private Button viewOrderDetailButton;

    @FXML
    private Button viewOrdersButton;

    @FXML
    void onClickSwitchToHomePage(ActionEvent event) {
        try {
            HelloApplication.getInstance().switchScene("customer-home-page.fxml", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickSwitchToViewOrders(ActionEvent event) {
        try {
            HelloApplication.getInstance().switchScene("orders-page.fxml", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onClickSwitchToOrderDetails(ActionEvent event) {
        try {
//            HelloApplication.getInstance().setOrder(HelloApplication.getInstance().getOrder());
            HelloApplication.getInstance().switchScene("order-product-page.fxml", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(){
        Order order = HelloApplication.getInstance().getOrder();
        orderIdLabel.setText(order.getOrderId().toString());
        orderStatusLabel.setText(order.getOrderStatus());
        totalAmountLabel.setText((Integer.toString(order.getTotalAmount())));
        dispatcherLabel.setText(order.getDispatcherName());
    }

    @FXML
    void onClickSignOut(ActionEvent event) {
    try {
            HelloApplication.getInstance().switchScene("hello-view.fxml", "Assets/logo.JPG");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
