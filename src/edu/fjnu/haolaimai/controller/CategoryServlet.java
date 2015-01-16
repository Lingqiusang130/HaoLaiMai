package edu.fjnu.haolaimai.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import cn.itcast.servlet.BaseServlet;
import edu.fjnu.haolaimai.domain.Admin;
import edu.fjnu.haolaimai.domain.Category;
import edu.fjnu.haolaimai.exception.ApplicationException;
import edu.fjnu.haolaimai.exception.DataAccessException;
import edu.fjnu.haolaimai.service.CategoryQueryHelper;
import edu.fjnu.haolaimai.service.CategoryService;
import edu.fjnu.haolaimai.service.GoodQueryHelper;
import edu.fjnu.haolaimai.service.impl.CategoryServiceImpl;
import edu.fjnu.haolaimai.utils.Page;

public class CategoryServlet extends BaseServlet {
	private CategoryService categoryService = new CategoryServiceImpl();
	/**
	 * 按条件分页显示所有商品种类
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String loadAllCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取组合查询条件
		CategoryQueryHelper helper = new CategoryQueryHelper();
		if(StringUtils.isNotEmpty(request.getParameter("categoryIdB"))){
			int categoryIdB = Integer.parseInt(request.getParameter("categoryIdB"));
			if(categoryIdB!=0){
				helper.setCategoryIdB(categoryIdB);
			}
		}
		if(StringUtils.isNotEmpty(request.getParameter("keyValue"))){
			String keyValue = request.getParameter("keyValue");
			helper.setKeyValue(keyValue);
		}
		Page page=new Page();
		if(StringUtils.isNotEmpty(request.getParameter("pageno")))
			 page.setPageNo(Integer.parseInt(request.getParameter("pageno")));
		
		//获取条件下商品类别
		request.setAttribute("pageCategory", categoryService.loadTermPageCategory(helper, page));
		
		//获取所有商品大类别
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> parents = categoryService.getAllParentCategory();
		request.setAttribute("parents", parents);
		
		return "f:/jsps/admin/categorys/list_categorys.jsp";
	}
	
	/**
	 * 添加商品种类前准备
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String toInputCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取所有商品大类别
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> parents = categoryService.getAllParentCategory();
		request.setAttribute("parents", parents);
		
		return "f:/jsps/admin/categorys/input_category.jsp";
	}
	/**
	 * 添加商品种类
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String addCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category category = new Category();
		category.setCateName(request.getParameter("cateName"));
		category.setParent(new Category(Integer.parseInt(request.getParameter("categoryId"))));
		category.setDecription(request.getParameter("description"));
		try {
			categoryService.addCategory(category);
		} catch (DataAccessException e) {
			request.setAttribute("err", e.getMessage());
			return "f:/jsps/admin/categorys/input_category.jsp";
		}
		
		return "r:/CategoryServlet?method=loadAllCategory";
	}
	/**
	 * 修改商品种类前准备
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String toUpdateCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cateId=Integer.parseInt(request.getParameter("cateId"));
		Category category = categoryService.getCategoryById(cateId);
		request.setAttribute("category", category);
		//获取所有商品大类别
		List<Category> parents = categoryService.getAllParentCategory();
		request.setAttribute("parents", parents);
		return "f:/jsps/admin/categorys/update_category.jsp";
	}
	/**
	 * 修改商品种类
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String updateCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category category = new Category();
		category.setCateId(Integer.parseInt(request.getParameter("cateId")));
		category.setCateName(request.getParameter("cateName"));
		category.setParent(new Category(Integer.parseInt(request.getParameter("categoryId"))));
		category.setDecription(request.getParameter("description"));
		try {
			categoryService.updateCategory(category);
		} catch (DataAccessException e) {
			request.setAttribute("err", e.getMessage());
			return "f:/jsps/admin/categorys/update_category.jsp";
		}
		
		return "r:/CategoryServlet?method=loadAllCategory";
	}
	
	public String deleteCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cateId=Integer.parseInt(request.getParameter("cateId"));
		try{
			categoryService.deleteCategory(cateId);
		}catch(DataAccessException e){
			
		}
		return "r:/CategoryServlet?method=loadAllCategory";
	}
}
