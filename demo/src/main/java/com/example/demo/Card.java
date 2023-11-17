// Card.java
package com.example.demo;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Card extends StackPane {
    public Card(String title) {
        Rectangle cardBackground = new Rectangle(200, 150);
        cardBackground.setFill(Color.WHITE);
        cardBackground.setStroke(Color.BLACK);

        Label titleLabel = new Label(title);

        getChildren().addAll(cardBackground, titleLabel);
    }
}
