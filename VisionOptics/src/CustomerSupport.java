

import java.util.List;

private class CustomerSupport extends User {

	/**
	 * 
	 */
	private Integer supportId;
	/**
	 * 
	 */
	public List<Feedback> feedback;
	/**
	 * Getter of supportId
	 */
	public Integer getSupportId() {
	 	 return supportId; 
	}
	/**
	 * Setter of supportId
	 */
	public void setSupportId(Integer supportId) { 
		 this.supportId = supportId; 
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
	 * 
	 * @param issue 
	 * @param orderNumber 
	 */
	public void notifyIssue(String issue, Integer orderNumber) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @return 
	 */
	public EJavaObject getQueryStatus() { 
		// TODO Auto-generated method
		return null;
	 } 

}