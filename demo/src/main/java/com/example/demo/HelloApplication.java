package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class HelloApplication extends Application {

    private static HelloApplication instance;
    private Stage primaryStage;

    public void switchScene(String fxmlFileName, String imageFilePath) throws IOException {
        if (primaryStage == null) {
            throw new IllegalStateException("Primary stage is not initialized.");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFileName));
        Parent root = fxmlLoader.load();

        ImageView imageView = (ImageView) fxmlLoader.getNamespace().get("logoImageView");

        Image image = new Image("file:" + imageFilePath);
        imageView.setImage(image);

        Scene scene = new Scene(root, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void start(Stage primaryStage) throws Exception {
        instance = this;
        this.primaryStage = primaryStage;
        switchScene("register.fxml", "Assets/logo.JPG");  // Load your initial scene
    }

    public static HelloApplication getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        launch();
    }
}
