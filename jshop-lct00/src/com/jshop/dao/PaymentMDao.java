package com.jshop.dao;

import java.util.List;

import com.jshop.entity.PaymentM;

public interface PaymentMDao {

	/**
	 * 增加支付方式
	 * @param pm
	 * @return
	 */
	public abstract int addPayment(PaymentM pm);

	/**
	 * 开启支付方式使用
	 * @param list
	 * @return
	 */
	public abstract int openPayment(String[]list);

	/**
	 * 更新支付方式信息
	 * @param pm
	 * @return
	 */
	public abstract int updatePayment(PaymentM pm);
	/**
	 * 查询所有支付方式
	 * @param currenPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<PaymentM>findAllPayment(final int currentPage,final int lineSize);
	/**
	 * 统计所有支付方式
	 * @return
	 */
	public abstract int countfindAllPayment();

	/**
	 * 根据id获取支付方式
	 * @param paymentid
	 * @return
	 */
	public abstract PaymentM findPaymentbyId(String paymentid);

	/**
	 * 禁止支付方式
	 * @param list
	 * @return
	 */
	public abstract int closePayment(String []list);
	/**
	 * 获取所有启用的支付方式
	 * @return
	 */
	public abstract List<PaymentM>findAllPaymentWithoutPage();
	
}
