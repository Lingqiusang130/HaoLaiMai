/**
 * 
 */
package edu.fjnu.haolaimai.service.impl;

import java.util.List;

import edu.fjnu.haolaimai.dao.GoodDao;
import edu.fjnu.haolaimai.dao.impl.GoodDaoImpl;
import edu.fjnu.haolaimai.domain.Good;
import edu.fjnu.haolaimai.exception.ApplicationException;
import edu.fjnu.haolaimai.service.GoodQueryHelper;
import edu.fjnu.haolaimai.service.GoodService;

/**
 * @author lingqiusang
 *
 */
public class GoodServiceImpl implements GoodService{
	private GoodDao goodDao = new GoodDaoImpl();

	@Override
	public void addGood(Good good) {
		// TODO Auto-generated method stub
		try{
			goodDao.addGood(good);
		}catch(ApplicationException e){
			throw new ApplicationException("操作出错！");
		}
	}

	@Override
	public List<Good> loadGood() {
		List<Good> goodList = null;
		goodList = goodDao.loadGood();
		return goodList;
	}

	@Override
	public byte[] getGoodPic(int goodId) {
		byte[] goodPid = goodDao.getGoodPic(goodId);
		return goodPid;
	}

	@Override
	public List<Good> loadTermGood(GoodQueryHelper helper) {
		List<Good> goodList = null;
		goodList = goodDao.loadTermGood(helper);
		return goodList;
	}

	@Override
	public void removeGood(int goodId) {
		// TODO Auto-generated method stub
		goodDao.removeGood(goodId);
	}
}
