package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.logging.Level;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ReceiveCustomerSupportController {

    private static final Logger logger = Logger.getLogger(ReceiveCustomerSupportController.class.getName());


    @FXML
    private Button HomePageButton;

    @FXML
    private TextArea chatTextArea;

    @FXML
    private TextField messageTextField;

    @FXML
    private Button sendButton;

    @FXML
    void OnClickHomePageButton(ActionEvent event) {

            try {
                HelloApplication.getInstance().switchScene("customer-homepage.fxml", "");
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Failed to switch to customer-homepage.", e);
            }

    }

    void initiate(){

    }
    @FXML
    void onSendMessage(ActionEvent event) {

        String message = messageTextField.getText();
        chatTextArea.appendText("You: " + message + "\n");
        messageTextField.clear();
        String response = getResponse(message);
        chatTextArea.appendText("Support: " + response + "\n");

    }

    public static String getResponse(String userQuery) {
        String response;

        String lowerCaseQuery = userQuery.toLowerCase();

        if (lowerCaseQuery.contains("order") && !lowerCaseQuery.contains("track")) {
            response = "Sure, I'd be happy to assist you. Please provide your order number.";
        } else if (lowerCaseQuery.contains("check status")) {
            response = "I apologize for the inconvenience. Let me check the status for you.";
        } else if (lowerCaseQuery.contains("return")) {
            response = "We offer a 1-year warranty on manufacturing defects for our eyewear. If you encounter any issues related to the manufacturing of your glasses within the first year of purchase, please contact us with your order number and a description of the problem. We'll be happy to assist you in resolving the issue or, if necessary, provide a replacement.";
        } else if (lowerCaseQuery.contains("track")) {
            response = "You can track your order using the tracking number in your email.";
        } else if (lowerCaseQuery.contains("frame")) {
            response = "We provide light-weight metal and plastic frames.";
        } else if (lowerCaseQuery.contains("prescription lenses")) {
            response = "Yes, we provide prescription lenses. You can find out more about them at our website!";
        } else if (lowerCaseQuery.contains("contact")) {
            response = "You can reach us at support@visionaryoptics.com or call +92-VISIONARY-EYES.";
        } else if (lowerCaseQuery.contains("promotions") || lowerCaseQuery.contains("discounts")) {
            response = "Check our website for the latest promotions and discounts.";
        } else if (lowerCaseQuery.contains("design")) {
            response = "Our eye-wear is designed for both style and comfort.";
        }
        else if (lowerCaseQuery.contains("hi") || lowerCaseQuery.contains("hello")){
            response = "How may I help you today?";
        }
        else if (lowerCaseQuery.contains("bye")){
            response = "Thank you for contacting Visionary Optics Support. Have a nice day!";
        }
        else {
            response = "I'm sorry, I didn't understand that. Please provide a valid query.";
        }

        return response;
    }




    // This method extracts the response expected from chatGPT and returns it.
    public static String extractContentFromResponse(String response) {
        int startMarker = response.indexOf("content")+11; // Marker for where the content starts.
        int endMarker = response.indexOf("\"", startMarker); // Marker for where the content ends.
        return response.substring(startMarker, endMarker); // Returns the substring containing only the response.
    }
}


