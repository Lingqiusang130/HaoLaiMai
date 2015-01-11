/**
 * 
 */
package edu.fjnu.haolaimai.service.impl;

import edu.fjnu.haolaimai.dao.OrderItemDao;
import edu.fjnu.haolaimai.dao.impl.OrderItemDaoImpl;
import edu.fjnu.haolaimai.service.OrderItemService;

/**
 * @author lingqiusang
 *
 */
public class OrderItemServiceImpl implements OrderItemService{
	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
}
