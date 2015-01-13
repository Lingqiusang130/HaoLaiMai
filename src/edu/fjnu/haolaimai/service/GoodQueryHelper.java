/**
 * 
 */
package edu.fjnu.haolaimai.service;

/**
 * 组合查询
 * @author lingqiusang
 *
 */
public class GoodQueryHelper {
	/** 商品大类*/
	private Integer categoryIdB;
	/** 商品小类*/
	private Integer categoryIdS;
	/** 关键字*/
	private String keyValue;
	public Integer getCategoryIdB() {
		return categoryIdB;
	}
	public void setCategoryIdB(Integer categoryIdB) {
		this.categoryIdB = categoryIdB;
	}
	public Integer getCategoryIdS() {
		return categoryIdS;
	}
	public void setCategoryIdS(Integer categoryIdS) {
		this.categoryIdS = categoryIdS;
	}
	public String getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	
}
