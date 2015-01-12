/**
 * 
 */
package edu.fjnu.haolaimai.service.impl;

import edu.fjnu.haolaimai.dao.GoodDao;
import edu.fjnu.haolaimai.dao.impl.GoodDaoImpl;
import edu.fjnu.haolaimai.domain.Good;
import edu.fjnu.haolaimai.exception.ApplicationException;
import edu.fjnu.haolaimai.service.GoodService;

/**
 * @author lingqiusang
 *
 */
public class GoodServiceImpl implements GoodService{
	private GoodDao goodDao = new GoodDaoImpl();

	@Override
	public void add(Good good) {
		// TODO Auto-generated method stub
		try{
			goodDao.addGood(good);
		}catch(ApplicationException e){
			throw new ApplicationException("操作出错！");
		}
	}
}
