/**
 * 
 */
package edu.fjnu.haolaimai.service.impl;

import edu.fjnu.haolaimai.dao.UserDao;
import edu.fjnu.haolaimai.dao.impl.UserDaoImpl;
import edu.fjnu.haolaimai.service.UserService;

/**
 * @author lingqiusang
 *
 */
public class UserServiceImpl implements UserService{
	private UserDao uerDao = new UserDaoImpl();
}
