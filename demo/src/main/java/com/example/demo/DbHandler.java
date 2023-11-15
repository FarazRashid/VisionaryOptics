
package com.example.demo;
import java.sql.*;

public class DbHandler {

	/**
	 * 
	 */
	private String username;
	/**
	 *
	 */
	private String connectionString;
	/**
	 * 
	 */
	private String password;

	/**
	 *
	 */
	public DbHandler() {
		// create connection string for mysql
		connectionString = "jdbc:mysql://localhost:3306/VisionaryOptics";
		username = "root";
		password = "1234";


	}

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
	public String getConnectionString() {
	 	 return connectionString; 
	}
	/**
	 * Setter of connectionString
	 */
	public void setConnectionString(String connectionString) {
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
	 * @param object
	 * @return 
	 */
	public String update(Customer object) {
		String query = "UPDATE customer SET name=?, password=?, address=?, phoneNumber=?, email=? WHERE customerId=?";
		// TODO Auto-generated method
		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			 // UPDATE customers SET name=?, password=?, address=?, phoneNumber=?, email=? WHERE customerId=?
				preparedStatement.setString(1, object.getName());
				preparedStatement.setString(2, object.getPassword());
				preparedStatement.setString(3, object.getAddress());
				preparedStatement.setString(4, object.getPhoneNumber());
				preparedStatement.setString(5, object.getEmail());
				preparedStatement.setInt(6, object.getCustomerId());

				int affectedRows = preparedStatement.executeUpdate();

			return "Update successful. Affected rows: " + affectedRows;
		} catch (SQLException e) {
			e.printStackTrace();
			return "Update failed: " + e.getMessage();
		}
	 }
	/**
	 * 
	 * @param email
	 * @param password
	 * @return 
	 */
	public boolean validateLogin(String email, String password) {
		String query = "SELECT * FROM customer WHERE email=? AND password=?";
		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();

			// The result set is not empty
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
			// Return false in case of any exception
			return false;
		}
	}


	/**
	 * 
	 * @param object
	 * @return 
	 */
	public String delete(Customer object)  {
		String query = "DELETE FROM customer WHERE CustomerId=?";
		// TODO Auto-generated method
		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			// DELETE FROM customers WHERE customerId=?
			preparedStatement.setInt(1, object.getCustomerId());

			int affectedRows = preparedStatement.executeUpdate();

			return "Delete successful. Affected rows: " + affectedRows;
		} catch (SQLException e) {
			e.printStackTrace();
			return "Delete failed: " + e.getMessage();
		}
	 }
	/**
	 * 
	 * @param object 
	 * @return
	 */
	public String create(Customer object) {
		String query = "INSERT INTO customer (name, password, address, phoneNumber, email) VALUES (?, ?, ?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			// INSERT INTO customers (name, password, address, phoneNumber, email) VALUES (?, ?, ?, ?, ?)
			preparedStatement.setString(1, object.getName());
			preparedStatement.setString(2, object.getPassword());
			preparedStatement.setString(3, object.getAddress());
			preparedStatement.setString(4, object.getPhoneNumber());
			preparedStatement.setString(5, object.getEmail());

			int affectedRows = preparedStatement.executeUpdate();

			return "Update successful. Affected rows: " + affectedRows;
		} catch (SQLException e) {
			e.printStackTrace();
			return "Update failed: " + e.getMessage();
		}
	 }

}