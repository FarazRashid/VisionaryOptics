package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class OrdersPageController {

    @FXML
    private GridPane cartGrid;

    @FXML
    private ScrollPane cartScrollPane;

    @FXML
    private Label customerHomePageUserName;

    @FXML
    private Button goBackHomeButton;

    @FXML
    private Button signOutButton;

    @FXML
    private Button trackOrder;

    @FXML
    private Button viewProfileButton;

    public void onClickGoBackHome(ActionEvent actionEvent) {
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
    void onClickTrackOrder(ActionEvent event) {

    }

    @FXML
    void onClickViewProfile(ActionEvent event) {
        try {
            HelloApplication.getInstance().switchScene("view-profile.fxml", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
