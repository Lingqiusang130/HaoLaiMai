/**
 * 
 */
package edu.fjnu.haolaimai.service;

import edu.fjnu.haolaimai.domain.Admin;

/**
 * @author lingqiusang
 *
 */
public interface AdminService {
	public Admin adminLogin(String adminName,String adminPwd);
}
