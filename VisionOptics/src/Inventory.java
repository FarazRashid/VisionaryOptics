

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
	private EEList listOfProducts;
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
	public EEList getListOfProducts() {
	 	 return listOfProducts; 
	}
	/**
	 * Setter of listOfProducts
	 */
	public void setListOfProducts(EEList listOfProducts) { 
		 this.listOfProducts = listOfProducts; 
	}
	/**
	 * 
	 * @param selectedItems 
	 * @return 
	 */
	public EJavaObject checkItemAvailability(EJavaObject selectedItems) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param selectedItems 
	 * @return 
	 */
	public Boolean updateStock(EJavaObject selectedItems) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @return 
	 */
	public EEList requestProductCategories() { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param listingInfo 
	 * @param operationType 
	 * @return 
	 */
	public EJavaObject managementOperation(EJavaObject listingInfo, String operationType) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param category 
	 * @return 
	 */
	public EEList requestsProducts(String category) { 
		// TODO Auto-generated method
		return null;
	 } 

}