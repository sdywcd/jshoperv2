package com.jshop.action.androidserver.electronicmenu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.tools.Validate;
import com.jshop.entity.ElectronicMenuOrderT;
import com.jshop.service.ElectronicMenuCartTService;
import com.jshop.service.ElectronicMenuOrderTService;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Controller("androidJshopelectronicmenuorderAction")
public class AndroidJshopelectronicmenuorderAction  extends ActionSupport implements
ServletRequestAware, ServletResponseAware {
	private ElectronicMenuOrderTService electronicMenuOrderTService;
	private String electronicMenuOrderid;

	private HttpServletRequest request;
    private HttpServletResponse response;
    private String responsejsonstr;
   
    
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
	@Action(value="findElectronicMenuOrderTByelectronicMenuOrderid")
	public void findElectronicMenuOrderTByelectronicMenuOrderid() throws IOException{
		if(Validate.StrNotNull(this.getElectronicMenuOrderid())){
			String emorderid=this.getElectronicMenuOrderid().trim();
			ElectronicMenuOrderT emo=new ElectronicMenuOrderT();
			emo=this.getElectronicMenuOrderTService().findElectronicMenuOrderTByelectronicMenuOrderid(emorderid);
			if(emo!=null){
				StringBuilder json=new StringBuilder();
				json.append("{");
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
				json.append("}");
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
	
	
	
	
	
}
