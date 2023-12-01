package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

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

    Order order;

    @FXML
    void trackOrder(ActionEvent event) {
        try {
            HelloApplication.getInstance().setOrder(order);
            HelloApplication.getInstance().switchScene("track-order.fxml","Assets/logo.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void viewOrder(ActionEvent event) throws IOException {

        HelloApplication.getInstance().setOrder(order);
        HelloApplication.getInstance().switchScene("order-product-page.fxml","");

    }

    public void initData(Order order) {

        this.order=order;
        DbHandler dbHandler= new DbHandler();
        Cart cart=  dbHandler.getCart(order.getCartId());
        cart.recalculateTotal();
        orderId.setText(order.getOrderId().toString());
        orderStatus.setText(order.getOrderStatus());
        orderPaymentType.setText(order.getPaymentType());
        orderPrice.setText(String.valueOf(cart.getTotalAmount()));
        orderDate.setText(order.getOrderDate().toString());
        dispatcher.setText(order.getDispatcherName());

    }

}
