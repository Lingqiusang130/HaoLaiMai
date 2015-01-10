/**
 * 
 */
package edu.fjnu.haolaimai.domain;

/**
 * 订单条目
 * 
 * @author lingqiusang
 *
 */
public class OrderItem {
	/** 订单条目号*/
	private int OrderItemId;
	/** 商品数量*/
	private int quantity;
	/** 商品小计*/
	private double subtotal;
	/** 商品*/
	private Good good;
	/** 订单*/
	private Order order;
	
	public int getOrderItemId() {
		return OrderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		OrderItemId = orderItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * 商品总价=商品数量*商品价格
	 * @return
	 */
	public double getSubtotal() {	
		subtotal=this.quantity*this.good.getGoodPrice();
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}
