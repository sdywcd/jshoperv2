package com.jshop.action.androidserver.electronicmenu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("jshop")
@Controller("tableTAction")
public class TableTAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private HttpServletRequest request;
    private HttpServletResponse response;
    
  
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	

}
