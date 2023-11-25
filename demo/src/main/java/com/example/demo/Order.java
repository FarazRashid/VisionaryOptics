
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
		// we will set the order status dynamically by checking the date
		// if the order date is less than 1 day then the order status will be "Processing"
		// if the order date is less than 2 days then the order status will be "Shipped"
		// if the order date is less than 3 days then the order status will be "In Transit"
		// if the order date is more than 3 days then the order status will be "Delivered"

		Date currentDate = new Date();
		long diff = currentDate.getTime() - orderDate.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);
		if (diffDays < 1) {
			orderStatus = "Processing";
		} else if (diffDays < 2) {
			orderStatus = "Shipped";
		} else if (diffDays < 4) {
			orderStatus = "In Transit";
		} else if (diffDays > 4){
			orderStatus = "Delivered";
		}

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