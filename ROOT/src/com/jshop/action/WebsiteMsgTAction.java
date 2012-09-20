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
import org.springframework.stereotype.Controller;

import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.Serial;
import com.jshop.action.tools.Validate;
import com.jshop.entity.MsgtextT;
import com.jshop.entity.WebsiteMsgT;
import com.jshop.service.MsgtextTService;
import com.jshop.service.WebsiteMsgTService;
import com.opensymphony.xwork2.ActionContext;
@ParentPackage("jshop")
@Controller("websiteMsgTAction")
public class WebsiteMsgTAction {
	private WebsiteMsgTService websiteMsgTService;
	private MsgtextTService msgtextTService;
	private Serial serial;
	private String msgid;
	private String msgtousername;
	private String msgfromuserid;
	private String msgfromusrname;
	private String msgtextid;
	private String state;
	private String title;
	private Date createtime;
	private String msgstate;
	private String text;
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private String adminid ="";
	private String adminname = "";
	
	@JSON(serialize=false)
	public WebsiteMsgTService getWebsiteMsgTService() {
		return websiteMsgTService;
	}
	@JSON(serialize=false)
	public MsgtextTService getMsgtextTService() {
		return msgtextTService;
	}
	
	public void setMsgtextTService(MsgtextTService msgtextTService) {
		this.msgtextTService = msgtextTService;
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
	@JSON(serialize=false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * 
	 * @return
	 */
	public String findAllWebsiteMsg(){
		
		return "json";
	}
	
	/**
	 * 查询所有关于发件人是我的信息
	 * @return
	 */
	@Action(value="findAllWebsiteByMine",results={@Result(name="json",type="json")})
	public String findAllWebsiteByMine(){
		int currentPage=page;
		int lineSize=rp;
		rows.clear();
		
		total= this.getWebsiteMsgTService().countfindAllWebsiteMsgByFromUserid(adminid);
		List<WebsiteMsgT> weblist=this.getWebsiteMsgTService().findAllWebsiteMsgByFromUserid(currentPage, lineSize, adminid);
		for(Iterator it=weblist.iterator();it.hasNext(); ){
			WebsiteMsgT web=(WebsiteMsgT) it.next();
			Map<String, Object> map=new HashMap<String,Object>();
			map.put("id", web.getMsgid());
			map.put("cell",new Object[]{
					web.getTitle(),
					web.getMsgtousername(),
					web.getMsgtextid(),
					web.getState(),
					web.getMsgstate(),
					web.getCreatetime()
			} );
			rows.add(map);			
		}
		return "json";
	}
	/**
	 * 根据id 批量删除站内信
	 * @return
	 */
	@Action(value="delWebsiteMsg",results={@Result(name="json",type="json")})
	public String delWebsiteMsg(){
		if(Validate.StrNotNull(this.getMsgid())){
			String[]s=this.getMsgid().trim().split(",");
			this.getWebsiteMsgTService().delWebsiteMsgT(s);
			return "json";
		}
		return "json";
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
	/**
	 *增加站内信
	 * @return
	 */
	@Action(value="addWebsiteMsg",results={@Result(name="json",type="json")})
	public String addWebsiteMsg(){
		WebsiteMsgT web = new WebsiteMsgT();
		MsgtextT msg = new MsgtextT();
		web.setCreatetime(BaseTools.systemtime());
		web.setMsgfromuserid(adminid);
		web.setMsgfromusrname(adminname);
		web.setMsgid(this.getSerial().Serialid(Serial.WEBSITEMSG));
		web.setMsgstate(this.getMsgstate());
		web.setMsgtextid(this.getMsgtextid());
		web.setMsgtousername(this.getMsgtousername());
		web.setState("0");
		web.setTitle(this.getTitle());
		msg.setMsgtextid(this.getMsgtextid());
		msg.setSendtime(BaseTools.systemtime());
		msg.setText(this.getText());
		this.getMsgtextTService().addMsgtext(msg);
		this.getWebsiteMsgTService().addWebsiteMsgT(web);
		return "json";
	}

	
}
