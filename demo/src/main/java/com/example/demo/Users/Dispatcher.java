
package com.example.demo.Users;
import com.example.demo.Inventory.Order;

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

	private String name;

	/**
	 * Getter of order
	 */
	/**
	 * Setter of order
	 */
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

    public String getName() {
		return name;
    }

	public void setName(String name) {
		this.name = name;
	}
}