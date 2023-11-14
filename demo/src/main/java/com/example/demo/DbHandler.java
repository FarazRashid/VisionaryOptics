
package com.example.demo;
public class DbHandler {

	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	private Integer connectionString;
	/**
	 * 
	 */
	private String password;
	/**
	 * Getter of username
	 */
	public String getUsername() {
	 	 return username; 
	}
	/**
	 * Setter of username
	 */
	public void setUsername(String username) { 
		 this.username = username; 
	}
	/**
	 * Getter of connectionString
	 */
	public Integer getConnectionString() {
	 	 return connectionString; 
	}
	/**
	 * Setter of connectionString
	 */
	public void setConnectionString(Integer connectionString) { 
		 this.connectionString = connectionString; 
	}
	/**
	 * Getter of password
	 */
	public String getPassword() {
	 	 return password; 
	}
	/**
	 * Setter of password
	 */
	public void setPassword(String password) { 
		 this.password = password; 
	}
	/**
	 * 
	 * @param query 
	 * @param object 
	 * @return 
	 */
	public String update(String query, Customer object) {
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param object 
	 * @param query 
	 * @return 
	 */
	public String save(Customer object, String query) {
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param query 
	 * @param object 
	 * @return 
	 */
	public String delete(String query, Customer object) {
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param object 
	 * @param query 
	 * @return 
	 */
	public String create(Customer object, String query) {
		// TODO Auto-generated method
		return null;
	 } 

}