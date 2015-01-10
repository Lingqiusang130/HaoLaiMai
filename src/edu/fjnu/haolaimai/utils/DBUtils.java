/**
 * 
 */
package edu.fjnu.haolaimai.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author lingqiusang
 *
 */
public class DBUtils {
		
	private static DBUtils me=new DBUtils();
	
	private DBUtils() {}
	
	public static DBUtils getInstance()
	{
		return me;
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public Connection getConn()
	{
		
		Connection conn=null;
		
		try {
			//查看类路径中是否存在这个驱动入口类
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			conn=DriverManager.getConnection("proxool.haolaimai");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return conn;
		
	}
	
	/**
	 * 释放数据库资源
	 * @param conn
	 * @param pstmt
	 * @param rset
	 */
	public void ReleaseRes(Connection conn,PreparedStatement pstmt,ResultSet rset)
	{
		try{
		  if(rset!=null) rset.close();
		  if(pstmt!=null) pstmt.close();
		  if(conn!=null)  conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}


}
