/**
 * 
 */
package edu.fjnu.haolaimai.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.fjnu.haolaimai.dao.AdminDao;
import edu.fjnu.haolaimai.domain.Admin;
import edu.fjnu.haolaimai.exception.DataAccessException;
import edu.fjnu.haolaimai.utils.DBUtils;
/**
 * @author lingqiusang
 *
 */
public class AdminDaoImpl implements AdminDao {
	private static final String GET_ADMIN_BY_NAME = "select * from t_admin where admin_name=?";
	private static final String UPDATE_ADMINPWD = "update t_admin set admin_pwd=? where admin_id=?";
	
	@Override
	public Admin getAdminByName(String adminName) {
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		Admin admin=null;
		
		try {
			
		  pstmt=conn.prepareStatement(GET_ADMIN_BY_NAME);
		  pstmt.setString(1, adminName);
		  rset=pstmt.executeQuery();
		  
		  if(rset.next()){
			 admin=new Admin();
			 admin.setAdmindId(rset.getInt("admin_id"));
			 admin.setAdminName(rset.getString("admin_name"));
			 admin.setAdminPwd(rset.getString("admin_pwd"));
			 admin.setAdminGrade(rset.getInt("admin_grade"));
			 admin.setAdminNickName(rset.getString("admin_nickname"));
		  }
		  else
			 throw new DataAccessException("用户名为"+adminName+"的用户不存在，请检查!");
		  
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("用户名为"+adminName+"的用户信息获取失败!");
		} finally{
		   DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}		
		return admin;
	}

	@Override
	public void updateAdminPwd(int adminId, String adminPwd) {
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		try {
			
		  pstmt=conn.prepareStatement(UPDATE_ADMINPWD);
		  pstmt.setString(1, adminPwd);
		  pstmt.setInt(2, adminId);
		  pstmt.executeUpdate();
		  
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}			
	}

}
