/**
 * 
 */
package edu.fjnu.haolaimai.domain;

/**
 * 购物车
 * 
 * @author lingqiusang
 *
 */
public class CartItem {
	/** 购物车号*/
	private int cartItem;
	/** 购物商品数量*/
	private int quantity;
	/** 购物车号*/
	private Good good;
	/** 购物车归属*/
	private User onwer;
	
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCartItem() {
		return cartItem;
	}
	public void setCartItem(int cartItem) {
		this.cartItem = cartItem;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public User getOnwer() {
		return onwer;
	}
	public void setOnwer(User onwer) {
		this.onwer = onwer;
	}

}
