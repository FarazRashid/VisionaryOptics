

public class Feedback {

	/**
	 * 
	 */
	public Customer customer;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private Integer feedbackId;
	/**
	 * 
	 */
	private Integer rating;
	/**
	 * Getter of customer
	 */
	public Customer getCustomer() {
	 	 return customer; 
	}
	/**
	 * Setter of customer
	 */
	public void setCustomer(Customer customer) { 
		 this.customer = customer; 
	}
	/**
	 * Getter of description
	 */
	public String getDescription() {
	 	 return description; 
	}
	/**
	 * Setter of description
	 */
	public void setDescription(String description) { 
		 this.description = description; 
	}
	/**
	 * Getter of feedbackId
	 */
	public Integer getFeedbackId() {
	 	 return feedbackId; 
	}
	/**
	 * Setter of feedbackId
	 */
	public void setFeedbackId(Integer feedbackId) { 
		 this.feedbackId = feedbackId; 
	}
	/**
	 * Getter of rating
	 */
	public Integer getRating() {
	 	 return rating; 
	}
	/**
	 * Setter of rating
	 */
	public void setRating(Integer rating) { 
		 this.rating = rating; 
	}
	/**
	 * 
	 * @param poorFeedback 
	 */
	public void notifyCustomerSupport(String poorFeedback) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param query 
	 */
	public void submitQuery(String query) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param feedback 
	 * @return 
	 */
	public Boolean provideFeedback(String feedback) { 
		// TODO Auto-generated method
		return null;
	 } 

}