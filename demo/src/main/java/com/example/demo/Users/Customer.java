
package com.example.demo.Users;
import com.example.demo.Inventory.Cart;
import com.example.demo.Inventory.Order;
import com.example.demo.Systems.DbHandler;

import java.util.List;

public class Customer extends User {

//	public Integer customerId;

	/**
	 * 
	 */
	public Cart cart;
	/**
	 * 
	 */

	/**
	 * 
	 */
	private Integer customerId;
	/**
	 * 
	 */
	private String password;
	/**
	 *
	 */
	public List<Order> order;
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
	 * Getter of feedback
	 */
	/**
	 * Getter of customerId
	 */
	public Integer getCustomerId() {
	 	 return customerId; 
	}
	/**
	 * Setter of customerId
	 */
	public void setCustomerId(Integer customerId) { 
		 this.customerId = customerId; 
	}
	/**
	 * Getter of order
	 */
	public List<Order> getOrder() {
	 	 return order; 
	}
	/**
	 * Setter of order
	 */
	public void setOrder(List<Order> order) { 
		 this.order = order; 
	}
	/**
	 * 
	 */

	public Customer(String name, String password, String email, String phoneNumber, String address, Integer customerId){
		super(name,  password, email, phoneNumber, address);
		this.customerId = customerId;
	}

	public Customer() {
		super();
	}
	public void initiateFeedback() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @return 
	 */
	public Customer registerCustomer() {
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 */
	public void bookAppointment() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void requestQueryStatus() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void manageCart() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void confirmOrder() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param issue 
	 * @param orderNumber 
	 */
	public void contactCustomerSupport(String issue, Integer orderNumber) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param orderNumber 
	 */
	public void initiateOrderTracking(Integer orderNumber) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void recieveCustomerSupport() { 
		// TODO Auto-generated method
	 }

	public Cart updateCart(){

		DbHandler Handler = new DbHandler();

		this.cart=Handler.insertNewCart();

		Handler.updateCustomerCart(this.getCustomerId(),this.cart.getCartId());

		return this.cart;

	}
}