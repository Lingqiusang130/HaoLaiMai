/**
 * 
 */
package edu.fjnu.haolaimai.dao;

import java.util.List;

import edu.fjnu.haolaimai.domain.Category;
import edu.fjnu.haolaimai.service.CategoryQueryHelper;

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
	/**
	 * 取出在此查询条件下的菜单数量
	 * @param helper
	 * @return
	 */
	public int cntCategorys(CategoryQueryHelper helper);
	/**
	 * 取出在此查询条件下的菜单
	 * @param helper
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Category> loadTermPageCategory(CategoryQueryHelper helper,int begin,int end);
	/**
	 * 只找出父菜单，不包含子菜单
	 * @return
	 */
	public List<Category> getAllParentCategory();
	/**
	 * 添加菜单
	 * @param category
	 */
	public void addCategory(Category category);
	/**
	 * 修改商品类别
	 * @param category
	 */
	public void updateCategory(Category category);
}
