package edu.fjnu.haolaimai.dao;

import java.util.List;

import edu.fjnu.haolaimai.domain.Good;

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
	public List<Good> loadAllGood();
	/**
	 * 获取商品图片
	 * @param goodId
	 * @return
	 */
	public byte[] getGoodPic(int goodId);
}
