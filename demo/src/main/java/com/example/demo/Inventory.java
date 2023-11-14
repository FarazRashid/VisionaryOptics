
package com.example.demo;
import java.util.List;

public class Inventory {

	/**
	 * 
	 */
	private Integer productId;
	/**
	 * 
	 */
	public List<Products> products;
	/**
	 * 
	 */
	private List<Products> listOfProducts;
	/**
	 * Getter of productId
	 */
	public Integer getProductId() {
	 	 return productId; 
	}
	/**
	 * Setter of productId
	 */
	public void setProductId(Integer productId) { 
		 this.productId = productId; 
	}
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
	 * Getter of listOfProducts
	 */
	public List<Products> getListOfProducts() {
	 	 return listOfProducts; 
	}
	/**
	 * Setter of listOfProducts
	 */
	public void setListOfProducts(List<Products> listOfProducts) {
		 this.listOfProducts = listOfProducts; 
	}
	/**
	 * 
	 * @param selectedItems 
	 * @return 
	 */
	public Products checkItemAvailability(Products selectedItems) {
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param selectedItems 
	 * @return 
	 */
	public Boolean updateStock(Products selectedItems) {
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @return 
	 */
	public List<Products> requestProductCategories() {
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param listingInfo 
	 * @param operationType 
	 * @return 
	 */
	public List<Products> managementOperation(List<Products> listingInfo, String operationType) {
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param category 
	 * @return 
	 */
	public List<Products> requestsProducts(String category) {
		// TODO Auto-generated method
		return null;
	 } 

}