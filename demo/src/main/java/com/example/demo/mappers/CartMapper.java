package com.example.demo.mappers;

import com.example.demo.Inventory.Cart;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartMapper {
    public static Cart map(ResultSet resultSet) throws SQLException {
        Cart cart = new Cart();
        cart.setCartId(resultSet.getInt("cartId"));
        cart.setTotalAmount(resultSet.getInt("totalAmount"));
        return cart;
    }

}
