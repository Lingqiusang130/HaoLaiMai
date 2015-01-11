/**
 * 
 */
package edu.fjnu.haolaimai.service.impl;

import edu.fjnu.haolaimai.dao.CategoryDao;
import edu.fjnu.haolaimai.dao.impl.CategoryDaoImpl;
import edu.fjnu.haolaimai.service.CategoryService;

/**
 * @author lingqiusang
 *
 */
public class CategoryServiceImpl implements CategoryService{
	private CategoryDao categoryDao = new CategoryDaoImpl();
}
