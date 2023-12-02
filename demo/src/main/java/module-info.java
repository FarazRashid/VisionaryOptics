module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires java.mail;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}