
package com.example.demo;

import java.util.Date;

public class Order {

	/**
	 * 
	 */
	public Cart cart;
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
	public Dispatcher dispatcher;

	private Date orderDate;

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
	public Cart getCart() {
	 	 return cart; 
	}
	/**
	 * Setter of cart
	 */
	public void setCart(Cart cart) { 
		 this.cart = cart; 
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
	public Dispatcher getDispatcher() {
	 	 return dispatcher; 
	}
	/**
	 * Setter of dispatcher
	 */
	public void setDispatcher(Dispatcher dispatcher) { 
		 this.dispatcher = dispatcher; 
	}
	/**
	 * 
	 * @param orderStatus 
	 */
	public void displayOrderStatus(String orderStatus) { 
		// TODO Auto-generated method
	 } 

}