/**
 * 
 */
package edu.fjnu.haolaimai.dao;

import java.util.List;

import edu.fjnu.haolaimai.domain.Category;

/**
 * @author lingqiusang
 *
 */
public interface CategoryDao {
	/**
	 * 通过Id查询菜单
	 * @param cateId
	 * @return
	 */
	public Category getCategoryById(int cateId);
	/**
	 * 列出所有菜单
	 * @return
	 */
	public List<Category> loadAllCategory();
	/**
	 * 通过父菜单查询子菜单
	 * @param category
	 * @return
	 */
	public List<Category> findByParent(Category category);
}
