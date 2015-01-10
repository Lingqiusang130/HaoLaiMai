package edu.fjnu.haolaimai.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.fjnu.haolaimai.domain.Admin;
import edu.fjnu.haolaimai.utils.DBUtils;

public class DBServletTest extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DBServletTest() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String LOAD_ALL_ADMIN="select * from t_admin";
		Connection conn  = DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;//准备参数
		ResultSet rset=null;//结果集
		List<Admin> adminList=null;
		
		try{
			
		  pstmt=conn.prepareStatement(LOAD_ALL_ADMIN);
		  rset=pstmt.executeQuery();
		  
		  adminList=new ArrayList<Admin>();
		  
		  while(rset.next()){
			  
			  Admin admin=new Admin();
			  admin.setAdmindId(rset.getInt("adid"));
			  admin.setAdminName(rset.getString("adname"));
			  admin.setAdminPwd(rset.getString("adpassword"));
			  adminList.add(admin);
		  }
		  for (Admin admin : adminList) {
			System.out.println(admin);
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt,rset);
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
