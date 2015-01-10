/**
 * 
 */
package edu.fjnu.haolaimai.domain;

import java.util.List;

/**
 * 订单
 * 
 * @author lingqiusang
 *
 */
public class Order {
	/** 订单号*/
	private int orderId;
	/** 订单时间*/
	private String orderIime;
	/** 订单总价*/
	private double orderTotal;
	/** 订单状态 :1未付款, 2已付款但未发货, 3已发货未确认收货, 4确认收货了交易成功, 5已取消(只有未付款才能取消) */
	private int orderStatus;
	/** 收货地址*/
	private String address;
	/** 订单归属*/
	private User onwer;
	/** 订单条目*/
	private List<OrderItem> orderItemList;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderIime() {
		return orderIime;
	}
	public void setOrderIime(String orderIime) {
		this.orderIime = orderIime;
	}
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User getOnwer() {
		return onwer;
	}
	public void setOnwer(User onwer) {
		this.onwer = onwer;
	}
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
}
