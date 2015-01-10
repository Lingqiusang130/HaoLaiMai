/**
 * 
 */
package edu.fjnu.haolaimai.domain;

/**
 * 商品
 * 
 * @author lingqiusang
 *
 */
public class Good {
	/** 商品号*/
	private int goodId;
	/** 商品名*/
	private String goodName;
	/** 商品价格*/
	private double goodPrice;
	/** 商品大图*/
	private byte[] goodImage_b;
	/** 商品小图*/
	private byte[] goodImage_s;
	/** 商品类别*/
	private Category category;
	/** 商品描述*/
	private String Description;
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public double getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(double goodPrice) {
		this.goodPrice = goodPrice;
	}
	public byte[] getGoodImage_b() {
		return goodImage_b;
	}
	public void setGoodImage_b(byte[] goodImage_b) {
		this.goodImage_b = goodImage_b;
	}
	public byte[] getGoodImage_s() {
		return goodImage_s;
	}
	public void setGoodImage_s(byte[] goodImage_s) {
		this.goodImage_s = goodImage_s;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
}
