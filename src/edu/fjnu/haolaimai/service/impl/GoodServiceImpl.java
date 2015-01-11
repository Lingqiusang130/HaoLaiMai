/**
 * 
 */
package edu.fjnu.haolaimai.service.impl;

import edu.fjnu.haolaimai.dao.GoodDao;
import edu.fjnu.haolaimai.dao.impl.GoodDaoImpl;
import edu.fjnu.haolaimai.service.GoodService;

/**
 * @author lingqiusang
 *
 */
public class GoodServiceImpl implements GoodService{
	private GoodDao goodDao = new GoodDaoImpl();
}
