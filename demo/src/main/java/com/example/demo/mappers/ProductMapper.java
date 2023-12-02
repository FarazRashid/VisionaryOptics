package com.example.demo.mappers;


import com.example.demo.Inventory.Products;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper {

    public static Products map(ResultSet resultSet) throws SQLException {
        Products product = new Products();
        product.setType(resultSet.getString("type"));
        product.setDescription(resultSet.getString("description"));
        product.setProductId(resultSet.getInt("productId"));
        product.setPrice(resultSet.getInt("price"));
        product.setCategory(resultSet.getString("category"));
        product.setQuantity(resultSet.getInt("quantity"));
        // Add mapping for other fields as needed
        return product;
    }
}

