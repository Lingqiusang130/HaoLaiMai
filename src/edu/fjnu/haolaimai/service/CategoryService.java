/**
 * 
 */
package edu.fjnu.haolaimai.service;

import java.util.List;

import edu.fjnu.haolaimai.domain.Category;
import edu.fjnu.haolaimai.utils.Page;

/**
 * @author lingqiusang
 *
 */
public interface CategoryService {
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
	/**
	 * 取出在此查询条件下的菜单
	 * @param helper
	 * @param begin
	 * @param end
	 * @return
	 */
	public Page loadTermPageCategory(CategoryQueryHelper helper, Page page);
	/**
	 * 只找出父菜单，不包含子菜单
	 * @return
	 */
	public List<Category> getAllParentCategory();
}
