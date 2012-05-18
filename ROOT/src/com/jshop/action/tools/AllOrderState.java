package com.jshop.action.tools;

public class AllOrderState {
//
//	0：未确认 1:已确认
//	2:货到付款  3：待确认收货    
//	4:退货订单    5:关闭    6:用户已确认收货  7：缺货   8：用户删除 9：成功订单（所有订单交易结束）
//ORDERSTATE
	
   
	/**
	 * 订单状态
	 */
	public static final String ORDERSTATE_ZERO="未确认";
	
	public static final String ORDERSTATE_ONE="已确认";

	public static final String ORDERSTATE_TWO="货到付款";
	
	public static final String ORDERSTATE_THREE="待确认收货";
	
	public static final String ORDERSTATE_FOUR="退货";
	
	public static final String ORDERSTATE_FIVE="关闭";
	
	public static final String ORDERSTATE_SIX="用户已收货";
	
	public static final String ORDERSTATE_SEVEN="缺货";
	
	public static final String ORDERSTATE_EIGHT="用户删除";

	public static final String ORDERSTATE_NINE="成功";
	//0：未付款 1：已付款 2：订单关闭
	/**
	 * 支付状态
	 */
	public static final String PAYSTATE_ZERO="未付款";
	
	public static final String PAYSTATE_ONE="已付款";
	
	public static final String PAYSTATE_TWO="订单关闭";
	
	//SHIPPINGSTATE 0：配货中（未发货） 1：已发货 2：订单关闭
	/**
	 * 配送状态
	 */
	public static final String SHIPPINGSTATE_ZERO="配货中(未发货)";
	
	public static final String SHIPPINGSTATE_ONE="已发货";
	
	public static final String SHIPPINGSTATE_TWO="订单关闭";
	
	//配送方式
	public static final String EXPRESS="快递";
	
	public static final String POST="平邮";
	
	public static final String EMS="EMS";
	
	//订单来源
	public static final String ORDERTAG_ONE="普通订单";
	
	public static final String ORDERTAG_TWO="组合商品订单";
	
	//开票
	public static final String INVOICE_ZERO="不开";
	
	public static final String INVOICE_ONE="开";
	
	//订单状态的数字对应
	//
//	0：未确认 1:已确认
//	2:货到付款  3：待确认收货    
//	4:退货订单    5:关闭    6:用户已确认收货  7：缺货   8：用户删除 9：成功订单（所有订单交易结束）
//ORDERSTATE
	public static final String ORDERSTATE_ZERO_NUM="0";
	
	public static final String ORDERSTATE_ONE_NUM="1";
	
	public static final String ORDERSTATE_TWO_NUM="2";
	
	public static final String ORDERSTATE_THREE_NUM="3";
	
	public static final String ORDERSTATE_FOUR_NUM="4";
	
	public static final String ORDERSTATE_FIVE_NUM="5";
	
	public static final String ORDERSTATE_SIX_NUM="6";
	
	public static final String ORDERSTATE_SEVEN_NUM="7";
	
	public static final String ORDERSTATE_EIGHT_NUM="8";

	public static final String ORDERSTATE_NINE_NUM="9";
	
	//0：未付款 1：已付款 2：订单关闭
	/**
	 * 支付状态
	 */
	public static final String PAYSTATE_ZERO_NUM="0";
	
	public static final String PAYSTATE_ONE_NUM="1";
	
	public static final String PAYSTATE_TWO_NUM="2";
	//SHIPPINGSTATE 0：配货中（未发货） 1：已发货 2：订单关闭
	/**
	 * 配送状态
	 */
	public static final String SHIPPINGSTATE_ZERO_NUM="0";
	
	public static final String SHIPPINGSTATE_ONE_NUM="1";
	
	public static final String SHIPPINGSTATE_TWO_NUM="2";
	
	
	
}
