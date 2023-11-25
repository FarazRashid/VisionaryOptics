package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CardOrder {

    public Label orderPaymentType;
    @FXML
    private Label dispatcher;

    @FXML
    private Label orderDate;

    @FXML
    private Label orderId;

    @FXML
    private Label orderPrice;

    @FXML
    private Label orderStatus;

    @FXML
    private Button trackOrder;

    @FXML
    private Button viewOrder;

    @FXML
    void trackOrder(ActionEvent event) {

    }

    @FXML
    void viewOrder(ActionEvent event) {

    }

    public void initData(Order order) {

        orderId.setText(order.getOrderId().toString());
        orderStatus.setText(order.getOrderStatus());
        orderPaymentType.setText(order.getPaymentType());
        orderPrice.setText(String.valueOf(order.getTotalAmount()));
        orderDate.setText(order.getOrderDate().toString());
        dispatcher.setText(order.getDispatcherName());

    }

}
