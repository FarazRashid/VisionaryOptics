
package com.example.demo;
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
	 * @param object
	 * @return
	 */
	public Boolean update(Customer object, List<String> columnsToBeUpdated) {
		if (columnsToBeUpdated.isEmpty()) {
			return false;
		}

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
						preparedStatement.setString(parameterIndex++, object.getName());
						break;
					case "password":
						preparedStatement.setString(parameterIndex++, object.getPassword());
						break;
					case "address":
						preparedStatement.setString(parameterIndex++, object.getAddress());
						break;
					case "phonenumber":
						preparedStatement.setString(parameterIndex++, object.getPhoneNumber());
						break;
					case "email":
						preparedStatement.setString(parameterIndex++, object.getEmail());
						break;
					default:
						return false;
				}
			}

			preparedStatement.setInt(parameterIndex, object.getCustomerId());

			int affectedRows = preparedStatement.executeUpdate();

			return affectedRows > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param email
	 * @return
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
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * @param email
	 * @param accountPassword
	 * @return
	 */
	public boolean validateLogin(String email, String accountPassword) {
		String query = "SELECT * FROM customer WHERE email=? AND password=?";
		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, accountPassword);

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
	 * @param customer
	 * @return
	 */
	public Boolean delete(Customer customer) {
		String query = "DELETE FROM customer WHERE CustomerId=?";
		// TODO Auto-generated method
		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			// DELETE FROM customers WHERE customerId=?
			preparedStatement.setInt(1, customer.getCustomerId());

			int affectedRows = preparedStatement.executeUpdate();

			return affectedRows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param customer
	 * @return
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
			e.printStackTrace();
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
			e.printStackTrace();
			return Collections.emptyList();
		}
	}


	public Cart getCart(Customer customer) {
		String query = "SELECT c.cartId, c.totalAmount, cp.quantity, p.* FROM cart c "
				+ "JOIN customercart cc ON c.cartId = cc.cartId "
				+ "JOIN cartproduct cp ON c.cartId = cp.cartId "
				+ "JOIN products p ON cp.productId = p.productId "
				+ "WHERE cc.customerId = ?";

		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setInt(1, customer.getCustomerId());

			ResultSet resultSet = preparedStatement.executeQuery();

			Cart cart = null;

			while (resultSet.next()) {
				if (cart == null) {
					cart = CartMapper.map(resultSet);
					cart.setProducts(new ArrayList<>());
				}

				Products product = ProductMapper.map(resultSet);
				product.setQuantity(resultSet.getInt("quantity")); // Set quantity from cartproduct table
				cart.getProducts().add(product);
			}

			return cart;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}



	public boolean insertCartItem(int cartId, int productId, int cartQuantity) {
		// TODO: Implement the logic to insert a product into the CartProduct table

		// Check if there is enough quantity in the Products table
		String checkQuantityQuery = "SELECT quantity FROM products WHERE productId=?";
		String updateQuantityQuery = "UPDATE products SET quantity=? WHERE productId=?";
		String insertCartItemQuery = "INSERT INTO cartproduct (cartId, productId, quantity) VALUES (?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement checkQuantityStatement = connection.prepareStatement(checkQuantityQuery);
			 PreparedStatement updateQuantityStatement = connection.prepareStatement(updateQuantityQuery);
			 PreparedStatement insertCartItemStatement = connection.prepareStatement(insertCartItemQuery)) {

			// Check quantity in the Products table
			checkQuantityStatement.setInt(1, productId);
			ResultSet quantityResult = checkQuantityStatement.executeQuery();

			if (quantityResult.next()) {
				int currentQuantity = quantityResult.getInt("quantity");

				if (currentQuantity >= cartQuantity && currentQuantity > 0) {
					// There is enough quantity, proceed with the insertion

					// Update quantity in the Products table
					updateQuantityStatement.setInt(1, currentQuantity - cartQuantity);
					updateQuantityStatement.setInt(2, productId);
					updateQuantityStatement.executeUpdate();

					// Insert into CartProduct table
					insertCartItemStatement.setInt(1, cartId);
					insertCartItemStatement.setInt(2, productId);
					insertCartItemStatement.setInt(3, cartQuantity);
					insertCartItemStatement.executeUpdate();

					return true; // Success
				} else {
					// Not enough quantity in the Products table or cartQuantity exceeds available quantity
					return false;
				}
			} else {
				// Product not found in the Products table
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean incrementCartItemQuantity(int cartId, int productId, int incrementQuantity) {
		// TODO: Implement the logic to increment the quantity of a product in the CartProduct table

		// Check if there is enough quantity in the Products table
		String checkQuantityQuery = "SELECT quantity FROM products WHERE productId=?";
		String updateQuantityQuery = "UPDATE products SET quantity=? WHERE productId=?";
		String updateCartItemQuantityQuery = "UPDATE cartproduct SET quantity = quantity + ? WHERE cartId=? AND productId=?";

		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement checkQuantityStatement = connection.prepareStatement(checkQuantityQuery);
			 PreparedStatement updateQuantityStatement = connection.prepareStatement(updateQuantityQuery);
			 PreparedStatement updateCartItemQuantityStatement = connection.prepareStatement(updateCartItemQuantityQuery)) {

			// Check quantity in the Products table
			checkQuantityStatement.setInt(1, productId);
			ResultSet quantityResult = checkQuantityStatement.executeQuery();

			if (quantityResult.next()) {
				int currentQuantity = quantityResult.getInt("quantity");

				if (currentQuantity >= incrementQuantity && currentQuantity > 0) {
					// There is enough quantity, proceed with the increment

					// Update quantity in the Products table
					updateQuantityStatement.setInt(1, currentQuantity - incrementQuantity);
					updateQuantityStatement.setInt(2, productId);
					updateQuantityStatement.executeUpdate();

					// Increment quantity in the CartProduct table
					updateCartItemQuantityStatement.setInt(1, incrementQuantity);
					updateCartItemQuantityStatement.setInt(2, cartId);
					updateCartItemQuantityStatement.setInt(3, productId);
					updateCartItemQuantityStatement.executeUpdate();

					return true; // Success
				} else {
					// Not enough quantity in the Products table or incrementQuantity exceeds available quantity
					return false;
				}
			} else {
				// Product not found in the Products table
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCartItem(int cartId, int productId, int cartQuantity) {
		// TODO: Implement logic to delete a product from the CartProduct table

		String updateQuantityQuery = "UPDATE products SET quantity = quantity + ? WHERE productId=?";
		String deleteCartItemQuery = "DELETE FROM cartproduct WHERE cartId=? AND productId=?";

		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement updateQuantityStatement = connection.prepareStatement(updateQuantityQuery);
			 PreparedStatement deleteCartItemStatement = connection.prepareStatement(deleteCartItemQuery)) {

			// Add the quantity back to the Products table
			updateQuantityStatement.setInt(1, cartQuantity);
			updateQuantityStatement.setInt(2, productId);
			updateQuantityStatement.executeUpdate();

			// Delete the product from the CartProduct table
			deleteCartItemStatement.setInt(1, cartId);
			deleteCartItemStatement.setInt(2, productId);
			deleteCartItemStatement.executeUpdate();

			return true; // Success

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deductCartItemQuantity(int cartId, int productId, int cartQuantity) {
		// TODO: Implement logic to deduct the quantity of a product in the CartProduct table

		String updateQuantityQuery = "UPDATE products SET quantity = quantity + ? WHERE productId=?";
		String updateCartItemQuantityQuery = "UPDATE cartproduct SET quantity = quantity - ? WHERE cartId=? AND productId=?";

		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
			 PreparedStatement updateQuantityStatement = connection.prepareStatement(updateQuantityQuery);
			 PreparedStatement updateCartItemQuantityStatement = connection.prepareStatement(updateCartItemQuantityQuery)) {

			// Deduct the quantity from the CartProduct table
			updateCartItemQuantityStatement.setInt(1, cartQuantity);
			updateCartItemQuantityStatement.setInt(2, cartId);
			updateCartItemQuantityStatement.setInt(3, productId);
			updateCartItemQuantityStatement.executeUpdate();

			// Add the quantity back to the Products table
			updateQuantityStatement.setInt(1, cartQuantity);
			updateQuantityStatement.setInt(2, productId);
			updateQuantityStatement.executeUpdate();

			return true; // Success

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


}