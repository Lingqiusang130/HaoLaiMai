/**
 * 
 */
package edu.fjnu.haolaimai.dao;

import edu.fjnu.haolaimai.domain.Admin;


/**
 * @author lingqiusang
 *
 */
public interface AdminDao {
	public Admin getAdminByName(String adminName);
	public void updateAdminPwd(int adminId,String adminPwd);
}
