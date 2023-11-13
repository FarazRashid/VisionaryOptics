

import java.util.List;

public class System {

	/**
	 * 
	 */
	public List<User> user;
	/**
	 * 
	 */
	public List<Reports> reports;
	/**
	 * 
	 */
	public DbHandler dbhandler;
	/**
	 * 
	 */
	public EmailSystem emailsystem;
	/**
	 * 
	 */
	public Inventory inventory;
	/**
	 * Getter of user
	 */
	public List<User> getUser() {
	 	 return user; 
	}
	/**
	 * Setter of user
	 */
	public void setUser(List<User> user) { 
		 this.user = user; 
	}
	/**
	 * Getter of reports
	 */
	public List<Reports> getReports() {
	 	 return reports; 
	}
	/**
	 * Setter of reports
	 */
	public void setReports(List<Reports> reports) { 
		 this.reports = reports; 
	}
	/**
	 * Getter of dbhandler
	 */
	public DbHandler getDbhandler() {
	 	 return dbhandler; 
	}
	/**
	 * Setter of dbhandler
	 */
	public void setDbhandler(DbHandler dbhandler) { 
		 this.dbhandler = dbhandler; 
	}
	/**
	 * Getter of emailsystem
	 */
	public EmailSystem getEmailsystem() {
	 	 return emailsystem; 
	}
	/**
	 * Setter of emailsystem
	 */
	public void setEmailsystem(EmailSystem emailsystem) { 
		 this.emailsystem = emailsystem; 
	}
	/**
	 * Getter of inventory
	 */
	public Inventory getInventory() {
	 	 return inventory; 
	}
	/**
	 * Setter of inventory
	 */
	public void setInventory(Inventory inventory) { 
		 this.inventory = inventory; 
	}
	/**
	 * 
	 */
	public void manageListingInterface() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @return 
	 */
	public EEList displayProductCategories() { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @return 
	 */
	public EEList displayProducts() { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 */
	public void displayRegistrationForm() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param destination 
	 */
	public void redirectUser(String destination) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void bookAppointmentInterface() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void viewReportsInterface() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @return 
	 */
	public EJavaObject sendOrderConfirmation() { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 */
	public void displayFedbackForm() { 
		// TODO Auto-generated method
	 } 

}