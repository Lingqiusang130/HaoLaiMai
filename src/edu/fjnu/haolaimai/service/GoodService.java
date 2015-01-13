/**
 * 
 */
package edu.fjnu.haolaimai.service;

import java.util.List;

import edu.fjnu.haolaimai.domain.Good;

/**
 * @author lingqiusang
 *
 */
public interface GoodService {
	/**
	 * 添加商品
	 * @param good
	 */
	public void addGood(Good good);
	/**
	 * 展示商品
	 * @return
	 */
	public List<Good> loadGood();
	/**
	 * 获取商品图片
	 * @param goodId
	 * @return
	 */
	public byte[] getGoodPic(int goodId);	
	/**
	 * 有条件的显示商品
	 * @param helper
	 * @return
	 */
	public List<Good> loadTermGood(GoodQueryHelper helper);
}
