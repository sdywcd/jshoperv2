package com.jshop.action.front;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.Validate;
import com.jshop.entity.UserT;
import com.jshop.entity.WebsiteMsgT;
import com.jshop.service.WebsiteMsgTService;
import com.opensymphony.xwork2.ActionContext;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
@Controller("websiteMsgAction")
public class WebsiteMsgAction {
	private WebsiteMsgTService websiteMsgTService;
	private String msgid;
	private String msgtousername;
	private String msgfromuserid;
	private String msgfromusrname;
	private String msgtextid;
	private String state;
	private String title;
	private Date createtime;
	private String msgstate;
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	@JSON(serialize=false)
	public WebsiteMsgTService getWebsiteMsgTService() {
		return websiteMsgTService;
	}
	public void setWebsiteMsgTService(WebsiteMsgTService websiteMsgTService) {
		this.websiteMsgTService = websiteMsgTService;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public String getMsgtousername() {
		return msgtousername;
	}
	public void setMsgtousername(String msgtousername) {
		this.msgtousername = msgtousername;
	}
	public String getMsgfromuserid() {
		return msgfromuserid;
	}
	public void setMsgfromuserid(String msgfromuserid) {
		this.msgfromuserid = msgfromuserid;
	}
	public String getMsgfromusrname() {
		return msgfromusrname;
	}
	public void setMsgfromusrname(String msgfromusrname) {
		this.msgfromusrname = msgfromusrname;
	}
	public String getMsgtextid() {
		return msgtextid;
	}
	public void setMsgtextid(String msgtextid) {
		this.msgtextid = msgtextid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getMsgstate() {
		return msgstate;
	}
	public void setMsgstate(String msgstate) {
		this.msgstate = msgstate;
	}
	/**
	 * 查找所有关于收件人是我的信息
	 */
	public void findAllByMyWebsiteMsg(){
		int currentPage=page;
		int lineSize=rp;
		UserT user=(UserT) ActionContext.getContext().getSession().get(BaseTools.USER_SESSION_KEY);
		total=this.getWebsiteMsgTService().countfindAllWebsiteMsgByToUsername(user.getUsername());
		List<WebsiteMsgT> website= this.getWebsiteMsgTService().findAllWebsiteMsgByToUsername(currentPage, lineSize, user.getUsername());
		ActionContext.getContext().put("totalweb", total);
		ActionContext.getContext().put("website", website);
	}
	/**
	 * 更新信息为已读
	 * @return
	 */
	@Action(value="updateStateToOne",results={@Result(name="json",type="json")})
	public String updateStateToOne(){
		if(Validate.StrNotNull(this.getMsgid())){
			String[]s=this.getMsgid().trim().split(",");
			this.getWebsiteMsgTService().updateWebsiteMsgstate(s, "1");
			return "json";
		}
		return "json";
	}
	/**
	 * 更新信息为未读
	 * @return
	 */
	@Action(value="updateStateToZero",results={@Result(name="json",type="json")})
	public String updateStateToZero(){
		if(Validate.StrNotNull(this.getMsgid())){
			String[]s=this.getMsgid().trim().split(",");
			this.getWebsiteMsgTService().updateWebsiteMsgstate(s, "0");
			return "json";
		}
		return "json";
	}
	

}
