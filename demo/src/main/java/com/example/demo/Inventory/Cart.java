package com.example.demo.Inventory;

import com.example.demo.Systems.DbHandler;
import com.example.demo.Users.Customer;

import java.util.Iterator;
import java.util.List;

public class Cart {

	/**
	 * 
	 */
	public List<Products> products;
	/**
	 * 
	 */
	private Integer totalAmount;
	/**
	 * 
	 */
	private Integer cartId;
	/**
	 * Getter of products
	 */
	public List<Products> getProducts() {
	 	 return products; 
	}
	/**
	 * Setter of products
	 */
	public void setProducts(List<Products> products) { 
		 this.products = products; 
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
	 * Getter of cartId
	 */
	public Integer getCartId() {
	 	 return cartId; 
	}
	/**
	 * Setter of cartId
	 */
	public void setCartId(Integer cartId) { 
		 this.cartId = cartId; 
	}
	/**
	 * 
	 * @param selectedItems 
	 * @return 
	 */
	public void requestPlaceOrder(Products selectedItems) {


	 }
	/**
	 *
	 */
	public void proceedToCheckout(int customerId, String paymentType, String deliveryAddress) {

		DbHandler dbHandler = new DbHandler();
		dbHandler.placeOrder(this.getCartId(),customerId, paymentType, deliveryAddress);

	 }
	/**
	 * 
	 * @return 
	 */
	public Cart displayUpdatedCartContents() {
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @return 
	 */
	public Cart requestCartContents(Customer customer) {
		DbHandler dbHandler = new DbHandler();
		Cart cart = dbHandler.getCart(customer);
		this.setProducts(cart.getProducts());
		this.setTotalAmount(cart.getTotalAmount());
		this.setCartId(cart.getCartId());
		return this;
	}

	/**
	 * 

	 */
	public void updateCartItem(Products product, String operation, Integer quantity) {
		// TODO: Implement the logic to update the cart item based on the specified operation

		switch (operation.toLowerCase()) {
			case "insert product":
				// TODO: Implement logic to insert the product into the cart
				if (!products.contains(product)) {
					DbHandler dbHandler = new DbHandler();
					dbHandler.insertCartItem(cartId, product.getProductId(), quantity);
					products.add(product);
					recalculateTotal();
				}
				break;
				
			case "increment product quantity":
				// TODO: Implement logic to increment the quantity of the product in the cart
				for (Products existingProduct : products) {
					if (existingProduct.getProductId().equals(product.getProductId())) {
						existingProduct.setQuantity(existingProduct.getQuantity() + quantity);
						DbHandler dbHandler = new DbHandler();
						dbHandler.incrementCartItemQuantity(cartId, product.getProductId(), quantity);
						recalculateTotal();
						return;
					}
				}
				break;

			case "delete product":
				// TODO: Implement logic to delete the product from the cart
				Iterator<Products> iterator = products.iterator();
				while (iterator.hasNext()) {
					Products existingProduct = iterator.next();
					if (existingProduct.getProductId().equals(product.getProductId())) {
						// Remove the product from the cart
						iterator.remove();
						DbHandler dbHandler = new DbHandler();
						dbHandler.deleteCartItem(cartId, product.getProductId(), product.getQuantity());
						recalculateTotal();

						return;
					}
				}
				break;

			case "deduct product quantity":
				// TODO: Implement logic to deduct the quantity of the product in the cart
				Iterator<Products> iterator2 = products.iterator();
				while (iterator2.hasNext()) {
					Products existingProduct = iterator2.next();
					if (existingProduct.getProductId().equals(product.getProductId())) {
						// Deduct the quantity from the cart
						int newQuantity = existingProduct.getQuantity() - quantity;
						if (newQuantity <= 0) {
							// If the new quantity is 0 or less, remove the product completely
							iterator2.remove();
							DbHandler dbHandler = new DbHandler();
							dbHandler.deleteCartItem(cartId, product.getProductId(), product.getQuantity());
						} else {
							existingProduct.setQuantity(newQuantity);
							DbHandler dbHandler = new DbHandler();
							dbHandler.deductCartItemQuantity(cartId, product.getProductId(), quantity);
						}

						// You may also want to adjust the total amount here
						recalculateTotal();

						return; // Exit the method after updating
					}
				}
				break;


			default:
				// Handle unsupported operations or provide an error message
				break;
		}
	}

	/**
	 * 
	 */
	public int recalculateTotal() {

		int total = 0;
		for (Products product : products) {
			total += product.getPrice() * product.getQuantity();
		}

		setTotalAmount(total); // Update the totalAmount in the Cart object
		return total;
	}

}