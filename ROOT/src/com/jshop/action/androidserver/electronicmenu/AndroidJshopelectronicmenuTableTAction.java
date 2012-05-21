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
import com.jshop.entity.TableT;
import com.jshop.service.TableTService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
@Controller("androidJshopelectronicmenuTableTAction")
public class AndroidJshopelectronicmenuTableTAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private TableTService tableTService;
	private HttpServletRequest request;
    private HttpServletResponse response;
    private int page;
    private TableT bean=new TableT();
    private String responsejsonstr;
    @JSON(serialize = false)
	public TableTService getTableTService() {
		return tableTService;
	}

	public void setTableTService(TableTService tableTService) {
		this.tableTService = tableTService;
	}
	@JSON(serialize = false)
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	@JSON(serialize = false)
	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response=arg0;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request=arg0;	
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public TableT getBean() {
		return bean;
	}

	public void setBean(TableT bean) {
		this.bean = bean;
	}

	

	public String getResponsejsonstr() {
		return responsejsonstr;
	}

	public void setResponsejsonstr(String responsejsonstr) {
		this.responsejsonstr = responsejsonstr;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	/**
	 * 查询餐桌信息反馈给手机端
	 * @throws IOException 
	 */
	@Action(value="findAllTableTforAndroid")
	public void findAllTableTforAndroid() throws IOException{
		int currentPage=page;
		int lineSize=20;
		List<TableT>list=this.getTableTService().findAllTableT(currentPage, lineSize);
		StringBuilder json=new StringBuilder();
		for(Iterator it=list.iterator();it.hasNext();){
			TableT t=(TableT)it.next();
			json.append("{");
			json.append("\"tableid\":\"").append(t.getTableid()).append("\",");
			json.append("\"tableNumber\":\"").append(t.getTableNumber()).append("\",");
			json.append("\"roomName\":\"").append(t.getRoomName()).append("\",");
			json.append("\"androidDevicesCount\":\"").append(t.getAndroidDevicesCount()).append("\",");
			json.append("\"note\":\"").append(t.getNote()).append("\",");
			json.append("\"createtime\":\"").append(BaseTools.formateDbDate(t.getCreatetime())).append("\",");
			json.append("\"nop\":\"").append(t.getNop()).append("\",");
			json.append("\"tablestate\":\"").append(t.getTablestate()).append("\",");
			json.append("\"floor\":\"").append(t.getFloor()).append("\",");
			json.append("\"rnop\":\"").append(t.getRnop()).append("\"");
			json.append("}").append("--");
		}
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
