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

import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.Validate;
import com.jshop.entity.ElectronicMenuCartT;
import com.jshop.service.ElectronicMenuCartTService;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.utility.StringUtil;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
@Controller("androidJshopelectronicmenucartAction")
public class AndroidJshopelectronicmenucartAction  extends ActionSupport implements
ServletRequestAware, ServletResponseAware{
	
	private ElectronicMenuCartTService electronicMenuCartTService;
	private String tableNumber;
	private String tablestate;
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

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	
	/**
	 * 根据餐桌号
	 * @throws IOException 
	 */
	@Action(value="findAllElectronicMenuCartTBytableNumber")
	public void findAllElectronicMenuCartTBytableNumber() throws IOException{
		if(Validate.StrNotNull(this.getTableNumber())&&Validate.StrNotNull(this.getTablestate())){
			String tableNumber=this.getTableNumber().trim();
			String tablestate=this.getTablestate().trim();
			List<ElectronicMenuCartT>list=this.getElectronicMenuCartTService().findAllElectronicMenuCartTBytableNumber(tableNumber, tablestate);
			if(!list.isEmpty()){
				String temp=null;
				String []temparray=null;
				StringBuilder json=new StringBuilder();
				for(Iterator it=list.iterator();it.hasNext();){
					ElectronicMenuCartT emt=(ElectronicMenuCartT)it.next();
					temparray=StringUtil.split(emt.getPicture(), ',');
					temp=temparray[0];
					emt.setPicture(temp);
					json.append("{");
					json.append("\"id\":\"").append(emt.getId()).append("\",");
					json.append("\"electronicMenuOrderid\":\"").append(emt.getElectronicMenuOrderid()).append("\",");
					json.append("\"goodsid\":\"").append(emt.getGoodsid()).append("\",");
					json.append("\"goodsname\":\"").append(emt.getGoodsname()).append("\",");
					json.append("\"userid\":\"").append(emt.getUserid()).append("\",");
					json.append("\"username\":\"").append(emt.getUsername()).append("\",");
					json.append("\"needquantity\":\"").append(emt.getNeedquantity()).append("\",");
					json.append("\"price\":\"").append(emt.getPrice()).append("\",");
					json.append("\"memberprice\":\"").append(emt.getMemberprice()).append("\",");
					json.append("\"changeprice\":\"").append(emt.getChangeprice()).append("\",");
					json.append("\"points\":\"").append(emt.getPoints()).append("\",");
					json.append("\"subtotal\":\"").append(emt.getSubtotal()).append("\",");
					json.append("\"addtime\":\"").append(BaseTools.formateDbDate(emt.getAddtime())).append("\",");
					json.append("\"quantity\":\"").append(emt.getQuantity()).append("\",");
					json.append("\"picture\":\"").append(emt.getPicture()).append("\",");
					json.append("\"usersetnum\":\"").append(emt.getUsersetnum()).append("\",");
					json.append("\"weight\":\"").append(emt.getWeight()).append("\",");
					json.append("\"state\":\"").append(emt.getState()).append("\",");
					json.append("\"deliveryprice\":\"").append(emt.getDeliveryprice()).append("\",");
					json.append("\"taste\":\"").append(emt.getTaste()).append("\",");
					json.append("\"ispackaway\":\"").append(emt.getIspackaway()).append("\",");
					json.append("\"lunchbox\":\"").append(emt.getLunchbox()).append("\",");
					json.append("\"cookingstate\":\"").append(emt.getCookingstate()).append("\",");
					json.append("\"tableNumber\":\"").append(emt.getTableNumber()).append("\",");
					json.append("\"roomName\":\"").append(emt.getRoomName()).append("\",");
					json.append("\"tablestate\":\"").append(emt.getTablestate()).append("\",");
					json.append("\"electronicMenuCartid\":\"").append(emt.getElectronicMenuCartid()).append("\"");
					json.append("}").append("--");
					json.deleteCharAt(json.length()-1);
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
	
	
	
	
	
	
	
	
	
	

}
