package com.example.demo.emailSystem;

import com.example.demo.Inventory.Cart;
import com.example.demo.Users.Customer;
import com.example.demo.Systems.DbHandler;
import com.example.demo.Inventory.Order;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {

    public static void sendOrderConfirmation(Customer customer) {
        // Set your email credentials and properties
        final String username = EmailLoginInfo.getUsername();
        final String password = EmailLoginInfo.getPassword();

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); //TLS
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.host", "smtp.gmail.com");



        // Create a Session object
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);

            // Set the sender and recipient addresses
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(customer.getEmail()));

            // Set the email subject and content
            message.setSubject("Order Confirmation");

            DbHandler dbHandler = new DbHandler();
            Order order = dbHandler.getLatestOrder(customer.getCustomerId());
            String orderDetails = "Order ID: " + order.getOrderId() + "\n" +
                    "Order Date: " + order.getOrderDate() + "\n" +
                    "Payment Type: " + order.getPaymentType() + "\n" +
                    "Order Status: " + order.getOrderStatus() + "\n" +
                    "Total Amount: " + "$"+order.getTotalAmount() + "\n" +
                    "Dispatcher Name: " + order.getDispatcherName() + "\n";

            Cart customerCart = dbHandler.getCart(order.getCartId());

            String itemsOrdered="";
            for (int i = 0; i < customerCart.getProducts().size(); i++) {
                itemsOrdered += "Product :" + customerCart.getProducts().get(i).getDescription() + " x " +customerCart.getProducts().get(i).getQuantity() + " $" +customerCart.getProducts().get(i).getPrice()* customerCart.getProducts().get(i).getQuantity()  +  "\n";
            }
            // Customize the email content with order details
            String emailContent = "Dear " + customer.getName() + " " + ",\n\n" +
                    "Your order has been placed successfully. Here are the order details:\n\n" +
                    orderDetails + "\n\n" +
                    "Your order contains the following items:\n\n" +
                    itemsOrdered +
                    "Thank you for shopping with us.\n\n" +
                    "Regards,\n" +
                    "VisionOptics Team";
            message.setText(emailContent);

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
