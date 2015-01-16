/**
 * 
 */
package edu.fjnu.haolaimai.service.impl;

import java.util.List;

import edu.fjnu.haolaimai.dao.CategoryDao;
import edu.fjnu.haolaimai.dao.impl.CategoryDaoImpl;
import edu.fjnu.haolaimai.domain.Category;
import edu.fjnu.haolaimai.service.CategoryQueryHelper;
import edu.fjnu.haolaimai.service.CategoryService;
import edu.fjnu.haolaimai.utils.Page;

/**
 * @author lingqiusang
 *
 */
public class CategoryServiceImpl implements CategoryService{
	private CategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public Category getCategoryById(int cateId) {
		Category category = categoryDao.getCategoryById(cateId);
		return category;
	}

	@Override
	public List<Category> loadAllCategory() {
		List<Category> parents = categoryDao.loadAllCategory();
		return parents;
	}

	@Override
	public List<Category> findByParent(Category category) {
		List<Category> children = categoryDao.findByParent(category);
		return children;
	}

	@Override
	public Page loadTermPageCategory(CategoryQueryHelper helper,Page page) {
		page.setTotalRecNum(categoryDao.cntCategorys(helper));
		page.setPageContent(categoryDao.loadTermPageCategory(helper, page.getStartIndex(), page.getEndIndex()));		
		return page;
	}

	@Override
	public List<Category> getAllParentCategory() {
		return categoryDao.getAllParentCategory();
	}
}
