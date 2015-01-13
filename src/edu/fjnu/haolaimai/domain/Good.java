/**
 * 
 */
package edu.fjnu.haolaimai.domain;

import java.util.Arrays;

/**
 * 商品
 * 
 * @author lingqiusang
 * 
 */
public class Good {
	/** 商品号 */
	private int goodId;
	/** 商品名 */
	private String goodName;
	/** 商品价格 */
	private double goodPrice;
	/** 商品图片 */
	private byte[] goodImage;
	/** 商品类别 */
	private Category category;
	/** 商品描述 */
	private String Description;
	/** 库存状态*/
	private int stockStatus;

	public Good() {
		super();
		this.stockStatus = 1;
	}

	public int getGoodId() {
		return goodId;
	}

	public int getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(int stockStatus) {
		this.stockStatus = stockStatus;
	}

	public Category getCategory() {
		return category;
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

	public void setCategory(Category category) {
		this.category = category;
	}

	public byte[] getGoodImage() {
		return goodImage;
	}

	public void setGoodImage(byte[] goodImage) {
		this.goodImage = goodImage;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	@Override
	public String toString() {
		return "Good [goodId=" + goodId + ", goodName=" + goodName
				+ ", goodPrice=" + goodPrice + ", goodImage="
				+ Arrays.toString(goodImage) + ", category=" + category
				+ ", Description=" + Description + ", stockStatus="
				+ stockStatus + "]";
	}

}
