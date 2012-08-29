package com.jshop.dao;

import java.util.List;

import com.jshop.entity.EcouponT;

public interface EcouponTDao {
	/**
	 * 添加电子优惠券
	 * @param et
	 * @return
	 */
	public int addEcoupon(EcouponT et);
	/**
	 * 查询所有电子优惠券
	 * @return
	 */
	public List<EcouponT> findAllEcoupon(final int currentPage,final int lineSize);
	
	/**
	 * 统计所有优惠券数量
	 * @return
	 */
	public int countAllEcoupon();
}
