
package com.example.demo;
public class User {

	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String phoneNumber;
	/**
	 * 
	 */
	private String address;
	/**
	 * Getter of name
	 */
	private String password;
	/**
	 * Getter of name
	 */

	public String getPassword() {
	 	 return password;
	}

	public void setPassword(String password) {
		 this.password = password;
	}

	public String getName() {
	 	 return name; 
	}
	/**
	 * Setter of name
	 */
	public void setName(String name) { 
		 this.name = name; 
	}
	/**
	 * Getter of email
	 */
	public String getEmail() {
	 	 return email; 
	}
	/**
	 * Setter of email
	 */
	public void setEmail(String email) { 
		 this.email = email; 
	}
	/**
	 * Getter of phoneNumber
	 */
	public String getPhoneNumber() {
	 	 return phoneNumber; 
	}
	/**
	 * Setter of phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) { 
		 this.phoneNumber = phoneNumber; 
	}
	/**
	 * Getter of address
	 */
	public String getAddress() {
	 	 return address; 
	}
	/**
	 * Setter of address
	 */
	public void setAddress(String address) { 
		 this.address = address; 
	}
	/**
	 * 
	 * @param newName 
	 * @param personId 
	 * @return 
	 */
	public Boolean editName(String newName, Integer personId) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param personId 
	 * @param newPhoneNumber 
	 * @return 
	 */
	public Boolean editPhoneNumber(Integer personId, String newPhoneNumber) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param personId 
	 * @param newAddress 
	 * @return 
	 */
	public Boolean editAddress(Integer personId, String newAddress) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param personId 
	 * @return 
	 */
	public Customer accessDetails(Integer personId) {
		// TODO Auto-generated method
		return null;
	 }

	 User(String name, String password, String email, String phoneNumber, String address){
		 this.name = name;
		 this.password = password;
		 this.email = email;
		 this.phoneNumber = phoneNumber;
		 this.address = address;
	 }

}