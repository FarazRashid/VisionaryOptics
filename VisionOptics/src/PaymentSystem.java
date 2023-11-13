

import java.util.List;

public class PaymentSystem {

	/**
	 * 
	 */
	private Integer paymentId;
	/**
	 * 
	 */
	private Integer totalAmount;
	/**
	 * 
	 */
	public List<Order> order;
	/**
	 * Getter of paymentId
	 */
	public Integer getPaymentId() {
	 	 return paymentId; 
	}
	/**
	 * Setter of paymentId
	 */
	public void setPaymentId(Integer paymentId) { 
		 this.paymentId = paymentId; 
	}
	/**
	 * Getter of totalAmount
	 */
	public Integer getTotalAmount() {
	 	 return totalAmount; 
	}
	/**
	 * Setter of totalAmount
	 */
	public void setTotalAmount(Integer totalAmount) { 
		 this.totalAmount = totalAmount; 
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
	public Boolean processPayment(Integer totalCost) { 
		// TODO Auto-generated method
		return null;
	 } 

}