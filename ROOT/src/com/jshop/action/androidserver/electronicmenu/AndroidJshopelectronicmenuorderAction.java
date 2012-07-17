package com.jshop.action.androidserver.electronicmenu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.tools.Arith;
import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.Serial;
import com.jshop.action.tools.Validate;
import com.jshop.entity.ElectronicMenuCartT;
import com.jshop.entity.ElectronicMenuOrderT;
import com.jshop.service.ElectronicMenuCartTService;
import com.jshop.service.ElectronicMenuOrderTService;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
@Controller("androidJshopelectronicmenuorderAction")
public class AndroidJshopelectronicmenuorderAction  extends ActionSupport implements
ServletRequestAware, ServletResponseAware {
	private ElectronicMenuOrderTService electronicMenuOrderTService;
	private ElectronicMenuCartTService electronicMenuCartTService;
	private Serial serial;
	private String electronicMenuOrderid;
	private String tableNumber;
	private String tablestate;
	private String paymentid;
	private String paymentname;
	private Double total;//会员总价
	private Double totalweight;
	private Double freight;
	private Double totalpoints;
	private String elecartgoodsname;
	private String elecartgoodsid;
	private String elecartid;
	private int elecartneedquantity;
	private ElectronicMenuOrderT eleorder;
	private HttpServletRequest request;
    private HttpServletResponse response;
    private String responsejsonstr;
   
    @JSON(serialize = false)
    public ElectronicMenuCartTService getElectronicMenuCartTService() {
		return electronicMenuCartTService;
	}

	public void setElectronicMenuCartTService(
			ElectronicMenuCartTService electronicMenuCartTService) {
		this.electronicMenuCartTService = electronicMenuCartTService;
	}

	@JSON(serialize = false)
	public ElectronicMenuOrderTService getElectronicMenuOrderTService() {
		return electronicMenuOrderTService;
	}

	public void setElectronicMenuOrderTService(
			ElectronicMenuOrderTService electronicMenuOrderTService) {
		this.electronicMenuOrderTService = electronicMenuOrderTService;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getResponsejsonstr() {
		return responsejsonstr;
	}

	public void setResponsejsonstr(String responsejsonstr) {
		this.responsejsonstr = responsejsonstr;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response=arg0;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request=arg0;
		
	}

	public String getElectronicMenuOrderid() {
		return electronicMenuOrderid;
	}

	public void setElectronicMenuOrderid(String electronicMenuOrderid) {
		this.electronicMenuOrderid = electronicMenuOrderid;
	}



	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public String getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}

	public String getTablestate() {
		return tablestate;
	}

	public void setTablestate(String tablestate) {
		this.tablestate = tablestate;
	}

	public ElectronicMenuOrderT getEleorder() {
		return eleorder;
	}

	public void setEleorder(ElectronicMenuOrderT eleorder) {
		this.eleorder = eleorder;
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

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public Double getTotalpoints() {
		return totalpoints;
	}

	public void setTotalpoints(Double totalpoints) {
		this.totalpoints = totalpoints;
	}

	public String getElecartgoodsname() {
		return elecartgoodsname;
	}

	public void setElecartgoodsname(String elecartgoodsname) {
		this.elecartgoodsname = elecartgoodsname;
	}

	public String getElecartgoodsid() {
		return elecartgoodsid;
	}

	public void setElecartgoodsid(String elecartgoodsid) {
		this.elecartgoodsid = elecartgoodsid;
	}

	public int getElecartneedquantity() {
		return elecartneedquantity;
	}

	public void setElecartneedquantity(int elecartneedquantity) {
		this.elecartneedquantity = elecartneedquantity;
	}

	public String getElecartid() {
		return elecartid;
	}

	public void setElecartid(String elecartid) {
		this.elecartid = elecartid;
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

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	
	/**
	 * 根据电子菜单订单号获取订单详细
	 * @throws IOException 
	 */
	@Action(value="findElectronicMenuOrderTByelectronicMenuOrderidForAndroid")
	public void findElectronicMenuOrderTByelectronicMenuOrderidForAndroid() throws IOException{
		if(Validate.StrNotNull(this.getElectronicMenuOrderid())){
			String emorderid=this.getElectronicMenuOrderid().trim();
			ElectronicMenuOrderT emo=new ElectronicMenuOrderT();
			emo=this.getElectronicMenuOrderTService().findElectronicMenuOrderTByelectronicMenuOrderid(emorderid);
			if(emo!=null){
				StringBuilder json=new StringBuilder();
				json.append("[{");
				json.append("\"electronicMenuOrderid\":\"").append(emo.getElectronicMenuOrderid()).append("\",");
				json.append("\"userid\":\"").append(emo.getUserid()).append("\",");
				json.append("\"username\":\"").append(emo.getUsername()).append("\",");
				json.append("\"paymentid\":\"").append(emo.getPaymentid()).append("\",");
				json.append("\"paymentname\":\"").append(emo.getPaymentname()).append("\",");
				json.append("\"delivermode\":\"").append(emo.getDelivermode()).append("\",");
				json.append("\"deliverynumber\":\"").append(emo.getDeliverynumber()).append("\",");
				json.append("\"electronicorderstate\":\"").append(emo.getElectronicorderstate()).append("\",");
				json.append("\"logisticsid\":\"").append(emo.getLogisticsid()).append("\",");
				json.append("\"freight\":\"").append(emo.getFreight()).append("\",");
				json.append("\"amount\":\"").append(emo.getAmount()).append("\",");
				json.append("\"points\":\"").append(emo.getPoints()).append("\",");
				json.append("\"purchasetime\":\"").append(emo.getPurchasetime()).append("\",");
				json.append("\"deliverytime\":\"").append(emo.getDeliverytime()).append("\",");
				json.append("\"invoice\":\"").append(emo.getInvoice()).append("\",");
				json.append("\"shippingaddressid\":\"").append(emo.getShippingaddressid()).append("\",");
				json.append("\"customernotes\":\"").append(emo.getCustomernotes()).append("\",");
				json.append("\"logisticswebaddress\":\"").append(emo.getLogisticswebaddress()).append("\",");
				json.append("\"paytime\":\"").append(emo.getPaytime()).append("\",");
				json.append("\"orderTag\":\"").append(emo.getOrderTag()).append("\",");
				json.append("\"toBuyer\":\"").append(emo.getToBuyer()).append("\",");
				json.append("\"shouldpay\":\"").append(emo.getShouldpay()).append("\",");
				json.append("\"usepoints\":\"").append(emo.getUsepoints()).append("\",");
				json.append("\"vouchersid\":\"").append(emo.getVouchersid()).append("\",");
				json.append("\"goodid\":\"").append(emo.getGoodid()).append("\",");
				json.append("\"goodsname\":\"").append(emo.getGoodsname()).append("\",");
				json.append("\"needquantity\":\"").append(emo.getNeedquantity()).append("\",");
				json.append("\"paystate\":\"").append(emo.getPaystate()).append("\",");
				json.append("\"shippingstate\":\"").append(emo.getShippingstate()).append("\",");
				json.append("\"deliveraddressid\":\"").append(emo.getDeliveraddressid()).append("\",");
				json.append("\"shippingusername\":\"").append(emo.getShippingusername()).append("\",");
				json.append("\"createtime\":\"").append(emo.getCreatetime()).append("\",");
				json.append("\"hasprintexpress\":\"").append(emo.getHasprintexpress()).append("\",");
				json.append("\"hasprintinvoice\":\"").append(emo.getHasprintinvoice()).append("\",");
				json.append("\"hasprintfpinvoice\":\"").append(emo.getHasprintfpinvoice()).append("\",");
				json.append("\"expressnumber\":\"").append(emo.getExpressnumber()).append("\",");
				json.append("\"tradeNo\":\"").append(emo.getTradeNo()).append("\",");
				json.append("\"tableNumber\":\"").append(emo.getTableNumber()).append("\",");
				json.append("\"roomName\":\"").append(emo.getRoomName()).append("\",");
				json.append("\"tablestate\":\"").append(emo.getTablestate()).append("\"");
				json.append("}]");
				this.setResponsejsonstr(json.toString());
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				PrintWriter out=response.getWriter();
				out.write(this.getResponsejsonstr());
				out.flush();
				out.close();
			}
		}
	}
	/**
	 * 处理电子餐车的价格和积分数据给订单
	 * @param list
	 */
	private void getElectronicMenuCartT(List<ElectronicMenuCartT>list){
		this.setTotal(0.0);
		this.setTotalweight(0.0);
		this.setTotalpoints(0.0);
		this.setElecartgoodsname("");
		this.setElecartgoodsid("");
		this.setElecartneedquantity(0);
		for(Iterator it=list.iterator();it.hasNext();){
			ElectronicMenuCartT emt=(ElectronicMenuCartT)it.next();
			total=Arith.add(total, Arith.mul(emt.getMemberprice(), Double.parseDouble(String.valueOf(emt.getNeedquantity()))));
			totalweight=Arith.add(totalweight, Arith.mul(Double.parseDouble(emt.getWeight()), Double.parseDouble(String.valueOf(emt.getNeedquantity()))));
			totalpoints=Arith.add(totalpoints, Arith.mul(emt.getPoints(), Double.parseDouble(String.valueOf(emt.getNeedquantity()))));
			elecartgoodsname+=emt.getGoodsname();
			elecartgoodsid+=emt.getGoodsid()+",";
			elecartneedquantity+=emt.getNeedquantity();
			elecartid=emt.getElectronicMenuCartid();
		}
	}
	
	/**
	 * 加入电子菜单订单
	 * @throws IOException 
	 */
	@Action(value="addElectronicMenuOrderTForAndorid")
	public void addElectronicMenuOrderTForAndorid() throws IOException{
		if(Validate.StrNotNull(this.getTableNumber())&&Validate.StrNotNull(this.getTablestate())){	
			
			//1，生成订单号
			String electronicMenuOrderid=this.getSerial().Serialid(Serial.ELECTRONICMENUORDER);
			//2，收集需要结算的电子餐车
		    String tablestate=this.getTablestate().trim();
		    String tableNumber=this.getTableNumber().trim();
		    String sucflag = null;
		    //3，检查电子订单中是否已经有相应的桌号对应的订单,如果有则进行菜单的重新计算，如果没有则新增电子订单
		    List<ElectronicMenuOrderT>oldeleorder=this.getElectronicMenuOrderTService().findAllElectronicMenuOrderTBytableNumberandstate(tableNumber, tablestate, "0");
		    if(!oldeleorder.isEmpty()){
		    	//向订单新增菜品
		    	List<ElectronicMenuCartT>list=this.getElectronicMenuCartTService().findAllElectronicMenuCartTBytableNumber(tableNumber, tablestate);
				if(!list.isEmpty()){
					getElectronicMenuCartT(list);
					eleorder=new ElectronicMenuOrderT();
					eleorder.setElectronicMenuOrderid(oldeleorder.get(0).getElectronicMenuOrderid());
					eleorder.setUserid("0");//无会员
					eleorder.setUsername("0");
					if(Validate.StrNotNull(this.getPaymentid())&&Validate.StrNotNull(this.getPaymentname())){
						eleorder.setPaymentid(this.getPaymentid().trim());
						eleorder.setPaymentname(this.getPaymentname().trim());
					}else{
						eleorder.setPaymentid("0");//无在线支付
						eleorder.setPaymentname("0");
					}
					eleorder.setDelivermode("0");//无外送
					eleorder.setDeliverynumber("0");
					eleorder.setElectronicorderstate("0");//待确认
					eleorder.setLogisticsid("0");
					eleorder.setFreight(0.0);//无运费
					eleorder.setAmount(this.getTotal());
					eleorder.setPoints(this.getTotalpoints());
					eleorder.setPurchasetime(BaseTools.systemtime());
					eleorder.setDeliverytime(null);
					eleorder.setInvoice("0");//不开发票
					eleorder.setShippingaddressid("0");//无发货地址
					eleorder.setCustomernotes("");//无客户留言
					eleorder.setLogisticswebaddress("");//无物流商地址
					eleorder.setPaytime(null);
					eleorder.setOrderTag("1");//店内订单
					eleorder.setToBuyer(null);//给客户留言
					eleorder.setShouldpay(Arith.add(this.getTotal(),0.0));//无运费下的需支付
					eleorder.setUsepoints(0.0);//用户没有使用积分
					eleorder.setVouchersid(null);//无优惠券
					eleorder.setGoodid(this.getElecartgoodsid());
					eleorder.setGoodsname(this.getElecartgoodsname());
					eleorder.setNeedquantity(this.getElecartneedquantity());
					eleorder.setPaystate("0");//未付款
					eleorder.setShippingstate("0");//配货中，可以是配菜中
					eleorder.setDeliveraddressid("0");//没有收获地址
					eleorder.setShippingusername("");
					eleorder.setCreatetime(BaseTools.systemtime());
					eleorder.setHasprintexpress("0");//未打印快递单
					eleorder.setHasprintinvoice("0");//未打印发货单
					eleorder.setHasprintfpinvoice("0");//未开具发票
					eleorder.setExpressnumber("0");//无快递单号
					eleorder.setTradeNo("0");//无支付宝交易号
					eleorder.setTableNumber(tableNumber);
					eleorder.setRoomName("");
					eleorder.setTablestate(tablestate);
					this.getElectronicMenuOrderTService().updateElectronicMenuOrderT(eleorder);
					sucflag=eleorder.getElectronicMenuOrderid();
					response.setContentType("text/html");
					response.setCharacterEncoding("utf-8");
					PrintWriter out=response.getWriter();
					out.write(sucflag);
					out.flush();
					out.close();
					
				}
		    }else{
		    	//新增订单
		    	//这里需要检查electroorderstate=9的情况（餐桌是否使用）
		    	 List<ElectronicMenuCartT>list=this.getElectronicMenuCartTService().findAllElectronicMenuCartTBytableNumber(tableNumber, tablestate);
					if(!list.isEmpty()){
						getElectronicMenuCartT(list);
						eleorder=new ElectronicMenuOrderT();
						eleorder.setElectronicMenuOrderid(electronicMenuOrderid);
						eleorder.setUserid("0");//无会员
						eleorder.setUsername("0");
						eleorder.setPaymentid("0");//无在线支付
						eleorder.setPaymentname("0");
						eleorder.setDelivermode("0");//无外送
						eleorder.setDeliverynumber("0");
						eleorder.setElectronicorderstate("0");//待确认
						eleorder.setLogisticsid("0");
						eleorder.setFreight(0.0);//无运费
						eleorder.setAmount(this.getTotal());
						eleorder.setPoints(this.getTotalpoints());
						eleorder.setPurchasetime(BaseTools.systemtime());
						eleorder.setDeliverytime(null);
						eleorder.setInvoice("0");//不开发票
						eleorder.setShippingaddressid("0");//无发货地址
						eleorder.setCustomernotes("");//无客户留言
						eleorder.setLogisticswebaddress("");//无物流商地址
						eleorder.setPaytime(null);
						eleorder.setOrderTag("1");//店内订单
						eleorder.setToBuyer(null);//给客户留言
						eleorder.setShouldpay(Arith.add(this.getTotal(),0.0));//无运费下的需支付
						eleorder.setUsepoints(0.0);//用户没有使用积分
						eleorder.setVouchersid(null);//无优惠券
						eleorder.setGoodid(this.getElecartgoodsid());
						eleorder.setGoodsname(this.getElecartgoodsname());
						eleorder.setNeedquantity(this.getElecartneedquantity());
						eleorder.setPaystate("0");//未付款
						eleorder.setShippingstate("0");//配货中，可以是配菜中
						eleorder.setDeliveraddressid("0");//没有收获地址
						eleorder.setShippingusername("");
						eleorder.setCreatetime(BaseTools.systemtime());
						eleorder.setHasprintexpress("0");//未打印快递单
						eleorder.setHasprintinvoice("0");//未打印发货单
						eleorder.setHasprintfpinvoice("0");//未开具发票
						eleorder.setExpressnumber("0");//无快递单号
						eleorder.setTradeNo("0");//无支付宝交易号
						eleorder.setTableNumber(tableNumber);
						eleorder.setRoomName("");
						eleorder.setTablestate(tablestate);
						if(this.getElectronicMenuOrderTService().addElectronicMenuOrderT(eleorder)>0){
							sucflag=eleorder.getElectronicMenuOrderid();//这里返回订单号
						}else{
							sucflag="failed";
						}
						response.setContentType("text/html");
						response.setCharacterEncoding("utf-8");
						PrintWriter out=response.getWriter();
						out.write(sucflag);
						out.flush();
						out.close();
						
					}
		    }
		    
		}
	}
	
	
	
	
	
	
}
