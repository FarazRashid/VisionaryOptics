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
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();

        // Get the reference to the ImageView in the FXML file
        ImageView imageView = (ImageView) fxmlLoader.getNamespace().get("logoImageView");

        // Load the image and set it to the ImageView
        Image image = new Image("file:Assets/logo.JPG");
        imageView.setImage(image);

        Scene scene = new Scene(root,1213,899);
        stage.setTitle("Hello Eva PTSD!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
