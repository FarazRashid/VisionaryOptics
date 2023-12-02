module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires java.mail;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.Cards;
    opens com.example.demo.Cards to javafx.fxml;
    exports com.example.demo.mappers;
    opens com.example.demo.mappers to javafx.fxml;
    exports com.example.demo.Controllers;
    opens com.example.demo.Controllers to javafx.fxml;
    exports com.example.demo.Users;
    opens com.example.demo.Users to javafx.fxml;
    exports com.example.demo.Inventory;
    opens com.example.demo.Inventory to javafx.fxml;
    exports com.example.demo.Systems;
    opens com.example.demo.Systems to javafx.fxml;
}