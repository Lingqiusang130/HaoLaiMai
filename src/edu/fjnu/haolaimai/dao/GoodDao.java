package edu.fjnu.haolaimai.dao;

import java.util.List;

import edu.fjnu.haolaimai.domain.Good;
import edu.fjnu.haolaimai.service.GoodQueryHelper;
/**
 * 
 * @author lingqiusang
 *
 */
public interface GoodDao {
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
}
