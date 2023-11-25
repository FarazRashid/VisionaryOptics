package com.example.demo;

import java.sql.ResultSet;

public class OrderMapper {

    public static Order map(ResultSet rs) {
        try {
            Order order = new Order();
            order.setOrderId(rs.getInt("orderId"));
            order.setOrderDate(rs.getDate("datePurchased"));
            order.setPaymentType(rs.getString("paymentType"));
            order.setOrderStatus(rs.getString("orderStatus"));
            order.setCartId(rs.getInt("cartId"));
            order.setTotalAmount(rs.getInt("totalAmount"));
            order.setDispatcherName(rs.getString("dispatcherName"));
            return order;
        } catch (Exception e) {
            return null;
        }
    }
}
