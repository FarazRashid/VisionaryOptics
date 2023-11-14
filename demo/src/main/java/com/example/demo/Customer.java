
package com.example.demo;
import java.util.List;

public class Customer extends User {

	/**
	 * 
	 */
	public Cart cart;
	/**
	 * 
	 */
	public List<Feedback> feedback;
	/**
	 * 
	 */
	public Appointment appointment;
	/**
	 * 
	 */
	private Integer customerId;
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
	public List<Feedback> getFeedback() {
	 	 return feedback; 
	}
	/**
	 * Setter of feedback
	 */
	public void setFeedback(List<Feedback> feedback) { 
		 this.feedback = feedback; 
	}
	/**
	 * Getter of appointment
	 */
	public Appointment getAppointment() {
	 	 return appointment; 
	}
	/**
	 * Setter of appointment
	 */
	public void setAppointment(Appointment appointment) { 
		 this.appointment = appointment; 
	}
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
	public void initiateFeedback() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @return 
	 */
	public EJavaObject registerCustomer() {
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

}