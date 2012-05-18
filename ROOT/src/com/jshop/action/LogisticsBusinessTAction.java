package com.jshop.action;

import java.sql.Date;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.Serial;
import com.jshop.action.tools.Validate;
import com.jshop.entity.LogisticsBusinessT;
import com.jshop.service.LogisticsBusinessTService;
import com.jshop.service.impl.LogisticsBusinessTServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("jshop")
@Controller("logisticsBusinessTAction")
public class LogisticsBusinessTAction extends ActionSupport {
	private LogisticsBusinessTService logisticsBusinessTService;
	private Serial serial;
	private String logisticsid;
	private String logisticsname;
	private String address;
	private String contractor;
	private String telno;
	private String faxno;
	private String email;
	private String receiver;
	private String bankaddress;
	private String bankaccount;
	private Date createtime;
	private String creatorid;
	private String des;
	private String insure;
	private String isCod;
	private String visible;
	private String state;
	private String city;
	private String website;
	private String logisticsjson = null;
	private List<LogisticsBusinessT> logisticsbusiness = new ArrayList<LogisticsBusinessT>();
	private LogisticsBusinessT beanlist = new LogisticsBusinessT();
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean slogin = false;
	private String usession;

	
	@JSON(serialize = false)
	public LogisticsBusinessTService getLogisticsBusinessTService() {
		return logisticsBusinessTService;
	}

	public void setLogisticsBusinessTService(LogisticsBusinessTService logisticsBusinessTService) {
		this.logisticsBusinessTService = logisticsBusinessTService;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public List<LogisticsBusinessT> getLogisticsbusiness() {
		return logisticsbusiness;
	}

	public void setLogisticsbusiness(List<LogisticsBusinessT> logisticsbusiness) {
		this.logisticsbusiness = logisticsbusiness;
	}

	public String getLogisticsid() {
		return logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}

	public String getLogisticsname() {
		return logisticsname;
	}

	public void setLogisticsname(String logisticsname) {
		this.logisticsname = logisticsname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContractor() {
		return contractor;
	}

	public void setContractor(String contractor) {
		this.contractor = contractor;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getFaxno() {
		return faxno;
	}

	public void setFaxno(String faxno) {
		this.faxno = faxno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getBankaddress() {
		return bankaddress;
	}

	public void setBankaddress(String bankaddress) {
		this.bankaddress = bankaddress;
	}

	public String getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getInsure() {
		return insure;
	}

	public void setInsure(String insure) {
		this.insure = insure;
	}

	public String getIsCod() {
		return isCod;
	}

	public void setIsCod(String isCod) {
		this.isCod = isCod;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LogisticsBusinessT getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(LogisticsBusinessT beanlist) {
		this.beanlist = beanlist;
	}

	@JSON(name = "rows")
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public String getLogisticsjson() {
		return logisticsjson;
	}

	public void setLogisticsjson(String logisticsjson) {
		this.logisticsjson = logisticsjson;
	}

	public String getUsession() {
		return usession;
	}

	public void setUsession(String usession) {
		this.usession = usession;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加物流商
	 * 
	 * @return
	 */
	@Action(value = "UpdatesafeSet", results = { @Result(name = "success", type = "redirect", location = "/jshop/admin/setting/logisticsareamanagement.jsp?session=${usession}"), @Result(name = "input", type = "redirect", location = "/jshop/admin/setting/logisticsareamanagement.jsp?session=${usession}"), @Result(name = "error", type = "redirect", location = "/jshop/admin/setting/logisticsareamanagement.jsp?session=${usession}") })
	public String addLogisticsBusiness() {

		if (Validate.StrisNull(this.getLogisticsname())) {
			ActionContext.getContext().put("errormsg", "物流商名称必须填写");
			return ERROR;
		}

		LogisticsBusinessT lb = new LogisticsBusinessT();
		lb.setLogisticsid(this.getSerial().Serialid(Serial.LOGISTICSBUSINESS));
		lb.setLogisticsname(this.getLogisticsname().trim());
		lb.setAddress(this.getAddress());
		lb.setContractor(this.getContractor().trim());
		lb.setTelno(this.getTelno().trim());
		lb.setFaxno(this.getFaxno().trim());
		lb.setEmail(this.getEmail().trim());
		lb.setReceiver(this.getReceiver().trim());
		lb.setBankaddress(this.getBankaddress().trim());
		lb.setBankaccount(this.getBankaccount().trim());
		lb.setCreatetime(BaseTools.systemtime());
		lb.setCreatorid(BaseTools.adminCreateId());
		lb.setDes(this.getDes());
		lb.setInsure(this.getInsure());
		lb.setIsCod(this.getIsCod());
		lb.setVisible(this.getVisible());
		lb.setState(this.getState());
		lb.setCity(this.getCity());
		lb.setWebsite(this.getWebsite());
		if (this.getLogisticsBusinessTService().addLogisticsBusiness(lb) > 0) {
			return SUCCESS;
		}
		return INPUT;

	}

	/**
	 * 查询所有物流商
	 * 
	 * @return
	 */
	@Action(value = "findAllLogisticsBusiness", results = { @Result(name = "json", type = "json") })
	public String findAllLogisticsBusiness() {
		int currentPage = page;
		int lineSize = rp;
		List<LogisticsBusinessT> list = this.getLogisticsBusinessTService().findAllLogisticsBusiness(currentPage, lineSize);
		if (list != null) {
			total = this.getLogisticsBusinessTService().countfindAllLogisticsBusiness();
			rows.clear();
			for (Iterator it = list.iterator(); it.hasNext();) {
				LogisticsBusinessT lb = (LogisticsBusinessT) it.next();
				if (lb.getInsure().equals("1")) {
					lb.setInsure("支持");
				} else {
					lb.setInsure("不支持");
				}
				if (lb.getIsCod().equals("1")) {
					lb.setInsure("支持");
				} else {
					lb.setIsCod("不支持");
				}
				if (lb.getVisible().equals("1")) {
					lb.setVisible("显示");
				} else {
					lb.setVisible("不显示");
				}
				if (lb.getState().equals("1")) {
					lb.setState("前台可用");
				} else if (lb.getState().equals("0")) {
					lb.setState("不可用");
				} else {
					lb.setState("后台可用");
				}

				Map cellMap = new HashMap();
				cellMap.put("id", lb.getLogisticsid());
				cellMap.put("cell", new Object[] { lb.getLogisticsname(), lb.getCity(), lb.getContractor(), lb.getTelno(), lb.getFaxno(), lb.getEmail(), lb.getAddress(), lb.getReceiver(), lb.getBankaccount(), lb.getBankaddress(), lb.getInsure(), lb.getIsCod(), lb.getVisible(), lb.getDes(), lb.getState(), BaseTools.formateDbDate(lb.getCreatetime()), lb.getCreatorid(), lb.getWebsite() });
				rows.add(cellMap);
			}
			return "json";
		}
		this.setTotal(0);
		rows.clear();
		return "json";
	}

	/**
	 * 更新物流商
	 * 
	 * @return
	 */
	@Action(value = "UpdateLogisticsBusiness", results = { @Result(name = "json", type = "json") })
	public String UpdateLogisticsBusiness() {
		LogisticsBusinessT lb = new LogisticsBusinessT();
		lb.setLogisticsid(this.getLogisticsid().trim());
		lb.setLogisticsname(this.getLogisticsname().trim());
		lb.setAddress(this.getAddress());
		lb.setContractor(this.getContractor().trim());
		lb.setTelno(this.getTelno().trim());
		lb.setFaxno(this.getFaxno().trim());
		lb.setEmail(this.getEmail().trim());
		lb.setReceiver(this.getReceiver().trim());
		lb.setBankaddress(this.getBankaddress().trim());
		lb.setBankaccount(this.getBankaccount().trim());
		lb.setCreatetime(BaseTools.systemtime());
		lb.setCreatorid(BaseTools.adminCreateId());
		lb.setDes(this.getDes());
		lb.setInsure(this.getInsure());
		lb.setIsCod(this.getIsCod());
		lb.setVisible(this.getVisible());
		lb.setState(this.getState());
		lb.setCity(this.getCity());
		lb.setWebsite(this.getWebsite());
		this.getLogisticsBusinessTService().updateLogisticsBusiness(lb);
		return "json";
	}

	/**
	 * 根据id获取物流商
	 * 
	 * @return
	 */
	@Action(value = "findLogisticsBusinessById", results = { @Result(name = "json", type = "json") })
	public String findLogisticsBusinessById() {
		if (Validate.StrNotNull(this.getLogisticsid())) {
			beanlist = this.getLogisticsBusinessTService().findLogisticsBusinessById(this.getLogisticsid().trim());
			if (beanlist != null) {
				return "json";
			}
		}
		return "json";
	}

	/**
	 * 删除物流商
	 * 
	 * @return
	 */
	@Action(value = "DelLogisticsBusiness", results = { @Result(name = "json", type = "json") })
	public String DelLogisticsBusiness() {
		if (Validate.StrNotNull(this.getLogisticsid())) {
			String[] strs = this.getLogisticsid().trim().split(",");
			if (this.getLogisticsBusinessTService().delLogisticsBusiness(strs) > 0) {
				return "json";
			}
			return "json";
		}
		return "json";
	}

	/**
	 * 获取物流商json方式
	 * 
	 * @return
	 */
	@Action(value = "findAllLogisticsBusinessTjson", results = { @Result(name = "json", type = "json") })
	public String findAllLogisticsBusinessTjson() {
		this.setLogisticsjson("");
		this.logisticsbusiness = this.getLogisticsBusinessTService().findAllLogisticsBusinessTjson();
		if (this.logisticsbusiness != null) {
			for (Iterator it = this.logisticsbusiness.iterator(); it.hasNext();) {
				LogisticsBusinessT l = (LogisticsBusinessT) it.next();
				this.logisticsjson += "<option value='" + l.getLogisticsid() + "'>" + l.getLogisticsname() + "</option>";
			}
			this.setLogisticsjson(logisticsjson);
			return "json";
		}
		return "json";
	}
}
