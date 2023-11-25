
package com.example.demo;

import java.util.Date;

public class Order {

	/**
	 * 
	 */
	public int cartId;
	/**
	 * 
	 */
	private Integer orderId;
	/**
	 * 
	 */
	private String orderStatus;
	/**
	 * 
	 */
	public String dispatcherName;

	private Date orderDate;

	private String paymentType;

	private int totalAmount;

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;

	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;

	}


	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setCurrentDate(){
		this.orderDate = new Date();
	}

	/**
	 * Getter of cart
	 */
	public int getCartId() {
	 	 return cartId;
	}
	/**
	 * Setter of cart
	 */
	public void setCartId(int cartId) {
		 this.cartId = cartId;
	}
	/**
	 * Getter of orderId
	 */
	public Integer getOrderId() {
	 	 return orderId; 
	}
	/**
	 * Setter of orderId
	 */
	public void setOrderId(Integer orderId) { 
		 this.orderId = orderId; 
	}
	/**
	 * Getter of orderStatus
	 */
	public String getOrderStatus() {
	 	 return orderStatus; 
	}
	/**
	 * Setter of orderStatus
	 */
	public void setOrderStatus(String orderStatus) { 
		 this.orderStatus = orderStatus; 
	}
	/**
	 * Getter of dispatcher
	 */
	public String getDispatcherName() {
	 	 return dispatcherName;
	}
	/**
	 * Setter of dispatcher
	 */
	public void setDispatcherName(String dispatcherName) {
		 this.dispatcherName = dispatcherName;
	}
	/**
	 * 
	 * @param orderStatus 
	 */
	public void displayOrderStatus(String orderStatus) { 
		// TODO Auto-generated method
	 }


}