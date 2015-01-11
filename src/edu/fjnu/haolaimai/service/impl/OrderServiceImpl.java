/**
 * 
 */
package edu.fjnu.haolaimai.service.impl;

import edu.fjnu.haolaimai.dao.OrderDao;
import edu.fjnu.haolaimai.dao.impl.OrderDaoImpl;
import edu.fjnu.haolaimai.service.OrderService;

/**
 * @author lingqiusang
 *
 */
public class OrderServiceImpl implements OrderService{
	private OrderDao orderDao = new OrderDaoImpl();
}
