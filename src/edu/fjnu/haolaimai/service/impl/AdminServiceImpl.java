/**
 * 
 */
package edu.fjnu.haolaimai.service.impl;

import edu.fjnu.haolaimai.dao.AdminDao;
import edu.fjnu.haolaimai.dao.impl.AdminDaoImpl;
import edu.fjnu.haolaimai.domain.Admin;
import edu.fjnu.haolaimai.exception.ApplicationException;
import edu.fjnu.haolaimai.service.AdminService;

/**
 * @author lingqiusang
 *
 */
public class AdminServiceImpl implements AdminService{
	private AdminDao adminDao = new AdminDaoImpl();

	@Override
	public Admin adminLogin(String adminName,String adminPwd) {
		Admin admin = adminDao.getAdminByName(adminName);
		
		if(!admin.getAdminPwd().equals(adminPwd.trim()))
			 throw new ApplicationException("密码错误");
		return admin;
	}

	@Override
	public void updateAdminPwd(int adminId, String adminPwd) {
		// TODO Auto-generated method stub
		adminDao.updateAdminPwd(adminId, adminPwd);
	}
}
