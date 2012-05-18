package com.jshop.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.taobao.Tblogout;
import com.jshop.action.tools.BaseTools;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")

@Controller("logoutAction")
public class LogoutAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String redirecturl;
	private Tblogout tblogout;

	@JSON(serialize = false)
	public Tblogout getTblogout() {
		return tblogout;
	}

	public void setTblogout(Tblogout tblogout) {
		this.tblogout = tblogout;
	}

	public String getRedirecturl() {
		return redirecturl;
	}

	public void setRedirecturl(String redirecturl) {
		this.redirecturl = redirecturl;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

//	public String logout() throws Exception {
//		HttpSession session = request.getSession(false);
//		if (session != null) {
//			session.removeAttribute(BaseTools.BACK_USER_SESSION_KEY);
//		}
//		Cookie[] cookies = request.getCookies();
//		if (cookies != null) {
//			for (Cookie cookie : cookies) {
//				if (AuthorityLogininterceptor.COOKIE_REMEMBER_KEY.equals(cookie.getName())) {
//					cookie.setValue("");
//					cookie.setMaxAge(0);
//					response.addCookie(cookie);
//					return "login";
//				}
//			}
//		}
//		return "login";
//	}

	/**
	 * 后台登出
	 */
	@Action(value = "adminLogout", results = { 
			@Result(name = "loginout", type="redirect",location = "${redirecturl}")
	})
	public String adminLogout() throws UnsupportedEncodingException {

		String taobao_user_id = (String) ActionContext.getContext().getSession().get("taobao_user_id");
		String adminid = (String) ActionContext.getContext().getSession().get(BaseTools.BACK_USER_SESSION_KEY);
		if (adminid != "" && taobao_user_id == "") {
			this.setRedirecturl(this.getTblogout().getlogoffURL());
		} else {
			this.setRedirecturl("/jshop/admin/jump.jsp");
		}
		ActionContext.getContext().getSession().remove(BaseTools.BACK_USER_SESSION_KEY);
		ActionContext.getContext().getSession().remove("taobao_user_id");
		ActionContext.getContext().getSession().remove("taobao_user_nick");

		return "loginout";

	}
}
