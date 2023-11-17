package com.example.demo;


import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper {

    public static Customer map(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setAddress(resultSet.getString("address"));
        customer.setCustomerId(resultSet.getInt("customerId"));
        customer.setEmail(resultSet.getString("email"));
        customer.setName(resultSet.getString("name"));
        customer.setPassword(resultSet.getString("password"));
        customer.setPhoneNumber(resultSet.getString("phoneNumber"));
        return customer;
    }
}

