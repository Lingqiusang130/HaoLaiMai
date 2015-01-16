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
import edu.fjnu.haolaimai.service.CategoryQueryHelper;
import edu.fjnu.haolaimai.service.CategoryService;
import edu.fjnu.haolaimai.service.GoodQueryHelper;
import edu.fjnu.haolaimai.service.impl.CategoryServiceImpl;
import edu.fjnu.haolaimai.utils.Page;

public class CategoryServlet extends BaseServlet {
	private CategoryService categoryService = new CategoryServiceImpl();
	
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
		
		//获取所有商品类别
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> parents = categoryService.getAllParentCategory();
		request.setAttribute("parents", parents);
		
		return "f:/jsps/admin/categorys/list_categorys.jsp";
	}
}
