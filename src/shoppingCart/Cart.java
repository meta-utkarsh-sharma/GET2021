package shoppingCart;

import java.util.Map;

public interface Cart {

	/**
	 * @param productId
	 * @param count
	 * @see java.util.List#add(int, java.lang.Object)
	 */
	public abstract void add(Integer productId, int count);

	/**
	 * @param productId
	 * @return
	 * @see java.util.List#contains(java.lang.Object)
	 */
	public abstract boolean contains(Integer productId);

	/**
	 * @param productId
	 */
	public abstract void remove(Integer productId);

	/**
	 * @param productId
	 * @param newCount new count of product to update in cart
	 * @return cartUpdated change in cart
	 */
	public abstract boolean updateQuantity(Integer productId, int newCount);

	/**
	 * This method generates the total bill
	 * of items present in cart.
	 * @return 
	 */
	public abstract Double generateBill();

	/**
	 * @return the cartList
	 */
	public abstract Map<Integer, Integer> getCartItems();

}