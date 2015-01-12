package edu.fjnu.haolaimai.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import edu.fjnu.haolaimai.domain.Admin;
import edu.fjnu.haolaimai.exception.ApplicationException;
import edu.fjnu.haolaimai.service.AdminService;
import edu.fjnu.haolaimai.service.impl.AdminServiceImpl;

public class AdminServlet extends BaseServlet {
	private AdminService adminService = new AdminServiceImpl();
	
	public String updateAdminPwd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,String> errors = new HashMap<String,String>();
		String adminNPwd = request.getParameter("adminNPwd");
		String adminNCPwd = request.getParameter("adminNCPwd");
		Admin admin = (Admin) request.getSession().getAttribute("sessionAdmin");
		if(admin==null){
			return "r:/jsps/admin/login.jsp";
		}
		if(!adminNCPwd.equals(adminNPwd)){
			errors.put("password", "密码不一致");
			return "f:/jsps/admin/update_adminpwd.jsp";
		}
		adminService.updateAdminPwd(admin.getAdmindId(), adminNPwd);
		request.getSession().removeAttribute("sessionAdmin");
		admin.setAdminPwd(adminNPwd);
		request.getSession().setAttribute("sessionAdmin", admin);
		return "f:/jsps/admin/index.jsp";
	}
	/**
	 * 登录
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取表单数据，封装到Admin对象中
		String adminName=request.getParameter("adminName");
		String adminPwd=request.getParameter("adminPwd");
		String verifyCode=request.getParameter("verifyCode");
		Admin formAdmin = new Admin();
		formAdmin.setAdminName(adminName);
		formAdmin.setAdminPwd(adminPwd);
		
		//校验
		Map<String,String> errors = validateLogin(formAdmin,verifyCode,request.getSession());
		if(errors.size() > 0) {
			request.setAttribute("form", formAdmin);
			request.setAttribute("error", errors);
			return "f:/jsps/admin/login.jsp";
		}
		
		//调用adminService#login()方法
		try{
			Admin admin = adminService.adminLogin(adminName.trim(),adminPwd.trim());
			// 保存用户到session
			request.getSession().setAttribute("sessionAdmin", admin);
			// 获取用户名保存到cookie中
			String cookAdminName = admin.getAdminName();
			cookAdminName = URLEncoder.encode(cookAdminName, "utf-8");
			Cookie cookie = new Cookie("cookieAdminName", cookAdminName);
			cookie.setMaxAge(60 * 60 * 24 * 10);//保存10天
			response.addCookie(cookie);
		}catch(ApplicationException e){
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", formAdmin);
			return "f:/jsps/admin/login.jsp";
		}
		return "r:/jsps/admin/index.jsp";//重定向到主页;
	}
	
	/**
	 * ajax验证码是否正确校验
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxValidateVerifyCode(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//获取输入框中的验证码
		String verifyCode = req.getParameter("verifyCode");
		
		//获取图片上真实的校验码
		String vcode = (String) req.getSession().getAttribute("vCode");
		
		//进行忽略大小写比较，得到结果
		boolean b = verifyCode.equalsIgnoreCase(vcode);
		
		//发送给客户端
		resp.getWriter().print(b);
		
		return null;
	}
	
	/**
	 * 校验登录
	 * @param formAdmin 表单Admin
	 * @param verifyCode 表单验证码
	 * @param session session中验证码
	 * @return
	 */
	private Map<String,String> validateLogin(Admin formAdmin,String verifyCode, HttpSession session) {
		Map<String,String> errors = new HashMap<String,String>();

		//校验用户名
		String adminName = formAdmin.getAdminName();
		if(adminName == null || adminName.trim().isEmpty()) {
			errors.put("adminName", "用户名不能为空！");
		} else if(adminName.length() < 3 || adminName.length() > 20) {
			errors.put("adminName", "用户名长度必须在3~20之间！");
		}	
		
		//校验密码
		String adminPwd = formAdmin.getAdminPwd();
		if(adminPwd == null || adminPwd.trim().isEmpty()) {
			errors.put("adminPwd", "密码不能为空！");
		} else if(adminPwd.length() < 3 || adminPwd.length() > 20) {
			errors.put("adminPwd", "密码长度必须在3~20之间！");
		}
		
		//验证码校验
		String vcode = (String) session.getAttribute("vCode");
		if(verifyCode == null || verifyCode.trim().isEmpty()) {
			errors.put("verifyCode", "验证码不能为空！");
		} else if(!verifyCode.equalsIgnoreCase(vcode)) {
			errors.put("verifyCode", "验证码错误！");
		}
		
		return errors;
	}
}
