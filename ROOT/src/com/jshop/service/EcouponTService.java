package com.jshop.service;

import java.util.List;

import com.jshop.entity.EcouponT;

public interface EcouponTService {
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

}
