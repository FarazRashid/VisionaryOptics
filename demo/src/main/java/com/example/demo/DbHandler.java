
package com.example.demo;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	private static final Logger logger;

    static {
        logger = Logger.getLogger(DbHandler.class.getName());
    }

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
	 * @param customer : The customer to be updated
	 * @return Boolean
	 */
	public Boolean update(Customer customer, List<String> columnsToBeUpdated) {
		if (columnsToBeUpdated.isEmpty()) return false;

		StringBuilder queryBuilder = new StringBuilder("UPDATE customer SET ");
		List<String> setStatements = new ArrayList<>();

		for (String column : columnsToBeUpdated) {
			switch (column.toLowerCase()) {
				case "name":
					setStatements.add("name=?");
					break;
				case "password":
					setStatements.add("password=?");
					break;
				case "address":
					setStatements.add("address=?");
					break;
				case "phonenumber":
					setStatements.add("phoneNumber=?");
					break;
				case "email":
					setStatements.add("email=?");
					break;
				default:
					return false;
			}
		}

		queryBuilder.append(String.join(", ", setStatements));
		queryBuilder.append(" WHERE customerId=?");

		String query = queryBuilder.toString();

		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			int parameterIndex = 1;
			for (String column : columnsToBeUpdated) {
				switch (column.toLowerCase()) {
					case "name":
						preparedStatement.setString(parameterIndex++, customer.getName());
						break;
					case "password":
						preparedStatement.setString(parameterIndex++, customer.getPassword());
						break;
					case "address":
						preparedStatement.setString(parameterIndex++, customer.getAddress());
						break;
					case "phonenumber":
						preparedStatement.setString(parameterIndex++, customer.getPhoneNumber());
						break;
					case "email":
						preparedStatement.setString(parameterIndex++, customer.getEmail());
						break;
					default:
						return false;
				}
			}

			preparedStatement.setInt(parameterIndex, customer.getCustomerId());

			int affectedRows = preparedStatement.executeUpdate();

			return affectedRows > 0;

		} catch (SQLException e) {
			logger.log(Level.SEVERE,"Error while Updating a Customer : ", e);
			return false;
		}
	}

	/**
	 *
	 * @param  email : The email of the user
	 * @return Customer
	 */
	public Customer getCustomer(String email) {
		String query = "SELECT * FROM customer WHERE email=?";

		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, email);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return CustomerMapper.map(resultSet);
			} else {
				return null;
			}

		} catch (SQLException e) {
			logger.log(Level.SEVERE,"Error while Fetching a Customer : ", e);
			return null;
		}

	}

	/**
	 * 
	 * @param email	: The email entered by the user
	 * @param accountPassword : The password entered by the user
	 * @return Boolean
	 */
	public boolean validateLogin(String email, String accountPassword) {
		String query = "SELECT * FROM customer WHERE email=? AND password=?";
		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, accountPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

            /* The result set is not empty */
			return resultSet.next();
		} catch (SQLException e) {
			logger.log(Level.SEVERE,"Error while Validating Login : ", e);
            /* Return false in case of any exception */
			return false;
		}
	}


	/**
	 * 
	 * @param customer : The customer object to be deleted
	 * @return Boolean
	 */
	public Boolean delete(Customer customer)  {
		String query = "DELETE FROM customer WHERE CustomerId=?";
		// TODO Auto-generated method
		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			// DELETE FROM customers WHERE customerId=?
			preparedStatement.setInt(1, customer.getCustomerId());

			int affectedRows = preparedStatement.executeUpdate();

			return affectedRows>0;
		} catch (SQLException e) {
			logger.log(Level.SEVERE,"Error while Deleting a Customer : ", e);
			return false;
		}
	 }
	/**
	 * 
	 * @param customer : The customer object to be created
	 * @return Boolean
	 */
	public Boolean create(Customer customer) {
		String query = "INSERT INTO customer (name, password, address, phoneNumber, email) VALUES (?, ?, ?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			// INSERT INTO customer (name, password, address, phoneNumber, email) VALUES (?, ?, ?, ?, ?)
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getPassword());
			preparedStatement.setString(3, customer.getAddress());
			preparedStatement.setString(4, customer.getPhoneNumber());
			preparedStatement.setString(5, customer.getEmail());

			int affectedRows = preparedStatement.executeUpdate();

			return affectedRows > 0;

		} catch (SQLException e) {
			logger.log(Level.SEVERE,"Error while Inserting a Customer : ", e);
			return false;
		}
	 }

	public List<Products> getAllProducts() {
		String query = "SELECT * FROM products"; // Update the query according to your database schema

		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			ResultSet resultSet = preparedStatement.executeQuery();

			List<Products> productsList = new ArrayList<>();
			while (resultSet.next()) {
				Products product = ProductMapper.map(resultSet);
				productsList.add(product);
			}

			return productsList;

		} catch (SQLException e) {
			logger.log(Level.SEVERE,"Error while Fetching all Products : ", e);
			return Collections.emptyList();
		}
	}


}