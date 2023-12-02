package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    private static Customer customer;

    private static Cart cart;

    //applies singleton pattern
    private static HelloApplication instance;
    private Stage primaryStage;

    private static Order selectedOrder;

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        HelloApplication.customer = customer;
    }

    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart cart) {
        HelloApplication.cart = cart;
    }

    public Order getOrder() {
        return selectedOrder;
    }

    public void setOrder(Order order) {
        HelloApplication.selectedOrder = order;
    }

    public void switchScene(String fxmlFileName, String imageFilePath) throws IOException {
        if (primaryStage == null) {
            throw new IllegalStateException("Primary stage is not initialized.");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFileName));
        Parent root = fxmlLoader.load();

        if (!Objects.equals(imageFilePath, ""))
        {
            ImageView imageView = (ImageView) fxmlLoader.getNamespace().get("logoImageView");

            Image image = new Image("file:" + imageFilePath);
            imageView.setImage(image);
        }
        Scene scene = new Scene(root, 1280, 720);
        String cssFileName = fxmlFileName.replace(".fxml", ".css");
        java.lang.System.out.println(cssFileName);

        scene.getStylesheets().add(getClass().getResource("styles/"+cssFileName).toExternalForm());

//        scene.getStylesheets().add(HelloApplication.class.getResource("hello-view.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void start(Stage primaryStage) throws Exception {
        instance = this;
        this.primaryStage = primaryStage;
        switchScene("hello-view.fxml", "Assets/logo.jpg");  // Load your initial scene
    }

    public static HelloApplication getInstance() {
            if (instance == null)
            {
                    instance = new HelloApplication();
            }
        return instance;
    }
    public static void main(String[] args) {
        launch();
    }


}
