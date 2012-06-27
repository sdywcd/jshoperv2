package com.jshop.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.classic.Validatable;
import org.springframework.stereotype.Controller;

import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.Validate;
import com.jshop.entity.GroupOrderT;
import com.jshop.service.GroupOrderTService;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Controller("goodsGroupTOrderAction")
public class GoodsGroupTOrderAction extends ActionSupport {
	private GroupOrderTService groupOrderTService;
	private String orderid;
	private String userid;
	private String username;
	private String paymentid;
	private String paymentname;
	private String delivermode;
	private String deliverynumber;
	private String orderstate;
	private String logisticsid;
	private double freight;
	private double amount;
	private Double points;
	private Date purchasetime;
	private Date deliverytime;
	private String invoice;
	private String shippingaddressid;
	private String customernotes;
	private String logisticswebaddress;
	private Date paytime;
	private String orderTag;
	private String toBuyer;
	private double shouldpay;
	private double usepoints;
	private String vouchersid;
	private String goodid;
	private String goodsname;
	private Integer needquantity;
	private String paystate;
	private String shippingstate;
	private String deliveraddressid;
	private String shippingusername;
	private Date createtime;
	private String hasprintexpress;
	private String hasprintinvoice;
	private String hasprintfpinvoice;
	private String expressnumber;
	private String tradeNo;
	private List rows= new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String sortname;
	private String sortorder;
	private String qtype;
	
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	@JSON(serialize=false)
	public GroupOrderTService getGroupOrderTService() {
		return groupOrderTService;
	}
	public void setGroupOrderTService(GroupOrderTService groupOrderTService) {
		this.groupOrderTService = groupOrderTService;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}
	public String getPaymentname() {
		return paymentname;
	}
	public void setPaymentname(String paymentname) {
		this.paymentname = paymentname;
	}
	public String getDelivermode() {
		return delivermode;
	}
	public void setDelivermode(String delivermode) {
		this.delivermode = delivermode;
	}
	public String getDeliverynumber() {
		return deliverynumber;
	}
	public void setDeliverynumber(String deliverynumber) {
		this.deliverynumber = deliverynumber;
	}
	public String getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}
	public String getLogisticsid() {
		return logisticsid;
	}
	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}
	public double getFreight() {
		return freight;
	}
	public void setFreight(double freight) {
		this.freight = freight;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Double getPoints() {
		return points;
	}
	public void setPoints(Double points) {
		this.points = points;
	}
	public Date getPurchasetime() {
		return purchasetime;
	}
	public void setPurchasetime(Date purchasetime) {
		this.purchasetime = purchasetime;
	}
	public Date getDeliverytime() {
		return deliverytime;
	}
	public void setDeliverytime(Date deliverytime) {
		this.deliverytime = deliverytime;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getShippingaddressid() {
		return shippingaddressid;
	}
	public void setShippingaddressid(String shippingaddressid) {
		this.shippingaddressid = shippingaddressid;
	}
	public String getCustomernotes() {
		return customernotes;
	}
	public void setCustomernotes(String customernotes) {
		this.customernotes = customernotes;
	}
	public String getLogisticswebaddress() {
		return logisticswebaddress;
	}
	public void setLogisticswebaddress(String logisticswebaddress) {
		this.logisticswebaddress = logisticswebaddress;
	}
	public Date getPaytime() {
		return paytime;
	}
	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}
	public String getOrderTag() {
		return orderTag;
	}
	public void setOrderTag(String orderTag) {
		this.orderTag = orderTag;
	}
	public String getToBuyer() {
		return toBuyer;
	}
	public void setToBuyer(String toBuyer) {
		this.toBuyer = toBuyer;
	}
	public double getShouldpay() {
		return shouldpay;
	}
	public void setShouldpay(double shouldpay) {
		this.shouldpay = shouldpay;
	}
	public double getUsepoints() {
		return usepoints;
	}
	public void setUsepoints(double usepoints) {
		this.usepoints = usepoints;
	}
	public String getVouchersid() {
		return vouchersid;
	}
	public void setVouchersid(String vouchersid) {
		this.vouchersid = vouchersid;
	}
	public String getGoodid() {
		return goodid;
	}
	public void setGoodid(String goodid) {
		this.goodid = goodid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public Integer getNeedquantity() {
		return needquantity;
	}
	public void setNeedquantity(Integer needquantity) {
		this.needquantity = needquantity;
	}
	public String getPaystate() {
		return paystate;
	}
	public void setPaystate(String paystate) {
		this.paystate = paystate;
	}
	public String getShippingstate() {
		return shippingstate;
	}
	public void setShippingstate(String shippingstate) {
		this.shippingstate = shippingstate;
	}
	public String getDeliveraddressid() {
		return deliveraddressid;
	}
	public void setDeliveraddressid(String deliveraddressid) {
		this.deliveraddressid = deliveraddressid;
	}
	public String getShippingusername() {
		return shippingusername;
	}
	public void setShippingusername(String shippingusername) {
		this.shippingusername = shippingusername;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getHasprintexpress() {
		return hasprintexpress;
	}
	public void setHasprintexpress(String hasprintexpress) {
		this.hasprintexpress = hasprintexpress;
	}
	public String getHasprintinvoice() {
		return hasprintinvoice;
	}
	public void setHasprintinvoice(String hasprintinvoice) {
		this.hasprintinvoice = hasprintinvoice;
	}
	public String getHasprintfpinvoice() {
		return hasprintfpinvoice;
	}
	public void setHasprintfpinvoice(String hasprintfpinvoice) {
		this.hasprintfpinvoice = hasprintfpinvoice;
	}
	public String getExpressnumber() {
		return expressnumber;
	}
	public void setExpressnumber(String expressnumber) {
		this.expressnumber = expressnumber;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public int getRp() {
		return rp;
	}
	public void setRp(int rp) {
		this.rp = rp;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getSortname() {
		return sortname;
	}
	public void setSortname(String sortname) {
		this.sortname = sortname;
	}
	public String getSortorder() {
		return sortorder;
	}
	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}
	/**
	 * 迭代显示数据
	 * @param list
	 */
	@SuppressWarnings("unchecked")
	public void processGroupOrder(List<GroupOrderT> list){
		rows.clear();
		for(Iterator it = list.iterator();it.hasNext();){
			GroupOrderT grouporder = (GroupOrderT) it.next();
			Map cellmap=new HashMap();
			cellmap.put("id", grouporder.getOrderid());
			cellmap.put("cell",new Object[]{
					grouporder.getAmount(), grouporder.getNeedquantity(), grouporder.getUsername(), grouporder.getShippingusername(), grouporder.getPaymentname(), grouporder.getDelivermode(), grouporder.getOrderstate(), grouporder.getPaystate(), grouporder.getShippingstate(), BaseTools.formateDbDate(grouporder.getPurchasetime()),  grouporder.getInvoice(), grouporder.getOrderTag() 
			});
			rows.add(cellmap);
			}
	}
	/**]
	 * 查询默认所有的订单
	 */
	public void  finddefaultGroupOrder(){
		int currentPage = page;
		int lineSize= rp;
//		total = this.getGroupOrderTService().countAllGroupOrder();
//		if(Validate.StrNotNull(sortname)&& Validate.StrNotNull(sortorder)){
//			String queryString ="from GroupOrderT order by "+ sortname +" "+ sortorder +"";
//			List<GroupOrderT> order = this.getGroupOrderTService().sortAllGroupOrder(currentPage, lineSize, queryString);
//			if(order!=null){
//				this.processGroupOrder(order);
//			}
//		}
	}
	/**
	 * 查询所有团购订单信息
	 * @return
	 */
	@Action(value="findAllGroupOrder",results={@Result(name="json",type="json")})

	public String  findAllGroupOrder(){
		if ("sc".equals(this.getQtype())) {
			this.setTotal(0);
			rows.clear();
			this.finddefaultGroupOrder();
		}
		return "json";
	}
}
