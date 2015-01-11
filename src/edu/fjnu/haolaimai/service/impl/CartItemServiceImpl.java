/**
 * 
 */
package edu.fjnu.haolaimai.service.impl;

import edu.fjnu.haolaimai.dao.CartItemDao;
import edu.fjnu.haolaimai.dao.impl.CartItemDaoImpl;
import edu.fjnu.haolaimai.service.CartItemService;

/**
 * @author lingqiusang
 *
 */
public class CartItemServiceImpl implements CartItemService{
	private CartItemDao cartItemDao = new CartItemDaoImpl();
}
