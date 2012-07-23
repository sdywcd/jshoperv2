package com.jshop.action.front;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.templates.DataCollectionTAction;
import com.jshop.action.templates.FreeMarkervariable;
import com.jshop.action.tools.Arith;
import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.Serial;
import com.jshop.entity.CartT;
import com.jshop.entity.PaymentM;
import com.jshop.entity.UserT;
import com.jshop.service.CartTService;
import com.jshop.service.OrderTService;
import com.jshop.service.PaymentMService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
@Controller("virtualGoodsOrderAction")
public class VirtualGoodsOrderAction extends ActionSupport {

	private Serial serial;
	private CartTService cartTService;
	private PaymentMService paymentMService;
	private OrderTService orderTService;
	private DataCollectionTAction dataCollectionTAction;
	/**
	 * 虚拟收获地址，邮件和手机号码
	 * 
	 */
	private String userid;
	private String username;
	private String mobile;
	private String email;
	private Date createtime;
	private String state;
	private String issend;
	private String orderid;
	private Double total;//会员总价
	private Double totalweight;
	private String defaultlogisticsid;
	private Double freight;
	private Double vouchercontent = 0.0;
	private Double totalpoints;
	private String usedvoucherid;
	private String cartgoodsname;
	private String cartgoodsid;
	private int cartneedquantity;
	private String cartid;
	private String hidurl;
	@JSON(serialize=false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	@JSON(serialize=false)
	public CartTService getCartTService() {
		return cartTService;
	}
	public void setCartTService(CartTService cartTService) {
		this.cartTService = cartTService;
	}
	@JSON(serialize=false)
	public PaymentMService getPaymentMService() {
		return paymentMService;
	}
	public void setPaymentMService(PaymentMService paymentMService) {
		this.paymentMService = paymentMService;
	}
	@JSON(serialize=false)
	public OrderTService getOrderTService() {
		return orderTService;
	}
	public void setOrderTService(OrderTService orderTService) {
		this.orderTService = orderTService;
	}
	@JSON(serialize=false)
	public DataCollectionTAction getDataCollectionTAction() {
		return dataCollectionTAction;
	}
	public void setDataCollectionTAction(DataCollectionTAction dataCollectionTAction) {
		this.dataCollectionTAction = dataCollectionTAction;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getIssend() {
		return issend;
	}
	public void setIssend(String issend) {
		this.issend = issend;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	
	
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getTotalweight() {
		return totalweight;
	}
	public void setTotalweight(Double totalweight) {
		this.totalweight = totalweight;
	}
	public String getDefaultlogisticsid() {
		return defaultlogisticsid;
	}
	public void setDefaultlogisticsid(String defaultlogisticsid) {
		this.defaultlogisticsid = defaultlogisticsid;
	}
	public Double getFreight() {
		return freight;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}
	public Double getVouchercontent() {
		return vouchercontent;
	}
	public void setVouchercontent(Double vouchercontent) {
		this.vouchercontent = vouchercontent;
	}
	public Double getTotalpoints() {
		return totalpoints;
	}
	public void setTotalpoints(Double totalpoints) {
		this.totalpoints = totalpoints;
	}
	public String getUsedvoucherid() {
		return usedvoucherid;
	}
	public void setUsedvoucherid(String usedvoucherid) {
		this.usedvoucherid = usedvoucherid;
	}
	public String getCartgoodsname() {
		return cartgoodsname;
	}
	public void setCartgoodsname(String cartgoodsname) {
		this.cartgoodsname = cartgoodsname;
	}
	public String getCartgoodsid() {
		return cartgoodsid;
	}
	public void setCartgoodsid(String cartgoodsid) {
		this.cartgoodsid = cartgoodsid;
	}
	public int getCartneedquantity() {
		return cartneedquantity;
	}
	public void setCartneedquantity(int cartneedquantity) {
		this.cartneedquantity = cartneedquantity;
	}
	
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
	}
	public String getHidurl() {
		return hidurl;
	}
	public void setHidurl(String hidurl) {
		this.hidurl = hidurl;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	
	/**
	 * 获取支付方式
	 */
	public List<PaymentM> GetDefaultPayment() {
		List<PaymentM> list = this.getPaymentMService().findAllPaymentWithoutPage();
		return list;
		
	}
	/**
	 * 获取购物车中的商品作为订单商品处理
	 * 
	 * @param user
	 */
	public void GetMyCart(UserT user) {
		List<CartT> list = this.getCartTService().findAllCartByUserId(user.getUserid());
		if (list != null) {
			this.setTotal(0.0);
			this.setTotalweight(0.0);
			this.setTotalpoints(0.0);
			this.setCartgoodsname("");
			this.setCartgoodsid("");
			this.setCartneedquantity(0);
			for (Iterator<CartT> it = list.iterator(); it.hasNext();) {
				CartT ct = (CartT) it.next();
				total = Arith.add(total, Arith.mul(ct.getFavorable(), Double.parseDouble(String.valueOf(ct.getNeedquantity()))));
				totalweight = Arith.add(totalweight, Arith.mul(Double.parseDouble(ct.getWeight()), Double.parseDouble(String.valueOf(ct.getNeedquantity()))));
				totalpoints = Arith.add(totalpoints, Arith.mul(ct.getPoints(), Double.parseDouble(String.valueOf(ct.getNeedquantity()))));
				cartgoodsname += ct.getGoodsname();
				cartgoodsid += ct.getGoodsid() + ",";
				cartneedquantity += ct.getNeedquantity();
				cartid = ct.getCartid();//获取购物车中的cartid表示同一个cartid即在同一个订单中
			}
			ActionContext.getContext().put("cart", list);
			ActionContext.getContext().put("totalprice", total);
			ActionContext.getContext().put("totalpoints", totalpoints);
			ActionContext.getContext().put("cartid", cartid);
			ActionContext.getContext().put("cartgoodsid", cartgoodsid);
			ActionContext.getContext().put("cartgoodsname", cartgoodsname);
			ActionContext.getContext().put("cartneedquantity", cartneedquantity);
		}
	}
	/**
	 * 初始化虚拟商品订单所需信息
	 * 
	 * @return
	 */
	@Action(value = "InitvirtualOrder", results = { 
			@Result(name = "success",type="freemarker",location = "/WEB-INF/theme/default/shop/confirmvirtualorder.ftl"),
			@Result(name = "input",type="redirect",location = "/html/default/shop/user/login.html?redirecturl=${hidurl}")
	})
	public String InitvirtualOrder() {
		UserT user = (UserT) ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
		if (user != null) {
//			//获取用户收获地址
//			GetUserDeliverAddress(user);
			//获取物流商
			//GetDefaultLogistictsBusiness();
			//获取支付方式并注入上下文
			ActionContext.getContext().put("payments", GetDefaultPayment());
			//获取购物车中的商品作为订单商品处理
			GetMyCart(user);
			//计算运费
			//GetLogisticsPrice();
			//获取总金额+运费
			Double totalfreight = this.getTotal();
			ActionContext.getContext().put("totalfreight", totalfreight);
			//路径获取
			ActionContext.getContext().put(FreeMarkervariable.BASEPATH, this.getDataCollectionTAction().getBasePath());
			//获取导航数据
			ActionContext.getContext().put(FreeMarkervariable.SITENAVIGATIONLIST, this.getDataCollectionTAction().findSiteNavigation());
			//获取商城基本数据
			ActionContext.getContext().put(FreeMarkervariable.JSHOPBASICINFO, this.getDataCollectionTAction().findJshopbasicInfo());
			//获取页脚分类数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTCATEGORY, this.getDataCollectionTAction().findFooterCateogyrT());
			//获取页脚文章数据
			ActionContext.getContext().put(FreeMarkervariable.FOOTERATRICLE, this.getDataCollectionTAction().findFooterArticle());
			
			return SUCCESS;
		}
		return INPUT;

	}
	
	
	
	
}
