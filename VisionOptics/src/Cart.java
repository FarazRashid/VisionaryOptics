

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
	public EJavaObject requestPlaceOrder(EJavaObject selectedItems) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param cart 
	 */
	public void proceedToCheckout(EJavaObject cart) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @return 
	 */
	public EJavaObject displayUpdatedCartContents() { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @return 
	 */
	public EJavaObject requestCartContents() { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param item 
	 * @param quantity 
	 */
	public void updateCartItem(Integer item, Integer quantity) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void recalculcateTotal() { 
		// TODO Auto-generated method
	 } 

}