/**
 * 
 */
package edu.fjnu.haolaimai.domain;

import java.util.List;

/**
 * 商品类别
 * 
 * @author lingqiusang
 *
 */
public class Category {
	/** 类别号*/
	private int cateId;
	/** 类别名*/
	private String cateName;
	/** 类别下的子类别*/
	private List<Category> children;
	/** 类别的父类别*/
	private Category parent;
	/** 类别描述*/
	private String decription;
	
	public Category(int cateId) {
		super();
		this.cateId = cateId;
	}
	public Category() {
		super();
	}
	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
		this.cateId = cateId;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public List<Category> getChildren() {
		return children;
	}
	public void setChildren(List<Category> children) {
		this.children = children;
	}
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
}
