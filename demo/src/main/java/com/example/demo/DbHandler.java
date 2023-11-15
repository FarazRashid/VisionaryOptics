
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
	 * @param query 
	 * @param object 
	 * @return 
	 */
	public String update(String query, Customer object) {
		// TODO Auto-generated method
		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			 // UPDATE customers SET name=?, password=?, address=?, phoneNumber=?, email=? WHERE id=?
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
	 * @param object 
	 * @param query 
	 * @return 
	 */
	public Boolean validateLogin(Customer object, String query) {

		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			// SELECT * FROM customers WHERE email=? AND password=?
			preparedStatement.setString(1, object.getEmail());
			preparedStatement.setString(2, object.getPassword());

			ResultSet resultSet = preparedStatement.executeQuery();

            // The result set is not empty
            return resultSet.next();


        } catch (SQLException e) {
			e.printStackTrace();
		}

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
		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			// DELETE FROM customers WHERE id=?
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
	 * @param query 
	 * @return 
	 */
	public String create(Customer object, String query) {
		// TODO Auto-generated method
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