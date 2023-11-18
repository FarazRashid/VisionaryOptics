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
        String initialMessage = "You are now an employee of Visionary Optics and you will respond to the queries of the customers\n" +
                "\n" +
                "\n" +
                "Sure, I'd be happy to assist you. Please provide your order number.\n" +
                "I apologize for the inconvenience. Let me check the status for you.\n" +
                "Yes, you can initiate a return within 30 days of receiving them.\n" +
                "You can track your order using the tracking number in your email.\n" +
                "Model A has a metal frame, while model B has a lightweight plastic frame.\n" +
                "Yes, we provide prescription lenses. Please specify your prescription details.\n" +
                "You can reach us at support@visionaryoptics.com or call +92-VISIONARY-EYES.\n" +
                "Check our website for the latest promotions and discounts.\n" +
                "\n" +
                "Our eyewear is designed for both style and comfort.\n" +
                "We offer a variety of lens coatings for UV protection and anti-glare.\n" +
                "We have a wide range of frame styles to suit different preferences.\n" +
                "Orders typically ship within 1-2 business days after confirmation.\n" +
                "For returns, please ensure the eyewear is in its original condition.\n" +
                "Our customer support is available Monday to Friday, 9 AM - 5 PM (GMT).\n" +
                "Explore our virtual try-on feature to see how frames look on you.\n" +
                "Sign up for our newsletter to receive exclusive offers and updates.\n" +
                "Please provide your feedback on our products and services.\n" +
                "\n" +
                "Custom prescriptions can be added during the online ordering process.\n" +
                "We offer a 1-year warranty on manufacturing defects for our eyewear.\n" +
                "Our packaging is eco-friendly, reflecting our commitment to sustainability.\n" +
                "Lost your tracking number? Check your order confirmation email.\n" +
                "For international orders, shipping times may vary based on location.\n" +
                "Our frames are made from high-quality materials for durability.\n" +
                "Check our FAQs page for answers to common questions.\n" +
                "Follow us on social media for the latest eyewear trends and updates.\n" +
                "Need assistance with a specific issue? Describe it, and we'll help you out.";
        // create a chat room between chatGPT api and user
        String response = chatGPT(initialMessage);
        chatTextArea.appendText("ChatGPT: " + response + "\n");
        // send a message to chatGPT api

        // receive a message from chatGPT api



    }
    @FXML
    void onSendMessage(ActionEvent event) {
        String message = messageTextField.getText();
        chatTextArea.appendText("You: " + message + "\n");
        messageTextField.clear();
        String response = chatGPT(message);
        chatTextArea.appendText("ChatGPT: " + response + "\n");

    }

    public static String chatGPT(String conversation) {
        String url = "https://api.openai.com/v1/chat/completions";
        String apiKey = "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";
        String model = "gpt-3.5-turbo";

        try {
            // Create the HTTP POST request
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", "Bearer " + apiKey);
            con.setRequestProperty("Content-Type", "application/json");

            // Build the request body with conversation
            String body = String.format(
                    "{\"model\": \"%s\", \"messages\": %s, \"temperature\": 0.7}",
                    model, conversation);

            con.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            // Get the response
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Return the extracted contents of the response.
            return response.toString();

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to connect to the server.", e);
            return "Sorry, I'm having trouble connecting to the server.";
        }
    }

    // This method extracts the response expected from chatGPT and returns it.
    public static String extractContentFromResponse(String response) {
        int startMarker = response.indexOf("content")+11; // Marker for where the content starts.
        int endMarker = response.indexOf("\"", startMarker); // Marker for where the content ends.
        return response.substring(startMarker, endMarker); // Returns the substring containing only the response.
    }
}


