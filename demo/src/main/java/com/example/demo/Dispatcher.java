
package com.example.demo;
import java.util.List;

public class Dispatcher {

	/**
	 * 
	 */
	public List<Order> order;
	/**
	 * 
	 */
	private Integer dispatcherID;
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
	 * Getter of dispatcherID
	 */
	public Integer getDispatcherID() {
	 	 return dispatcherID; 
	}
	/**
	 * Setter of dispatcherID
	 */
	public void setDispatcherID(Integer dispatcherID) { 
		 this.dispatcherID = dispatcherID; 
	}
	/**
	 * 
	 * @param orderNumber 
	 * @return 
	 */
	public String requestOrderStatus(Integer orderNumber) { 
		// TODO Auto-generated method
		return null;
	 } 

}