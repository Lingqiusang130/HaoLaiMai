package edu.fjnu.haolaimai.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import edu.fjnu.haolaimai.domain.Admin;
import edu.fjnu.haolaimai.domain.Category;
import edu.fjnu.haolaimai.service.CategoryService;
import edu.fjnu.haolaimai.service.impl.CategoryServiceImpl;

public class CategoryServlet extends BaseServlet {
	private CategoryService categoryService = new CategoryServiceImpl();
	
	public String getCategoryById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cateId = Integer.parseInt(request.getParameter("cateId"));
		Category category = categoryService.getCategoryById(cateId);
		request.setAttribute("category", category);
		return null;
	}
}
