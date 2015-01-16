/**
 * 
 */
package edu.fjnu.haolaimai.service;

import java.util.List;

import edu.fjnu.haolaimai.domain.Good;
import edu.fjnu.haolaimai.utils.Page;

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
	/**
	 * 删除商品
	 * @param goodId
	 */
	public void removeGood(int goodId);
	/**
	 * 按查询条件分页显示商品信息
	 * @param helper
	 * @param page
	 * @return
	 */
	public Page loadPagedGooms(GoodQueryHelper helper, Page page);
}
