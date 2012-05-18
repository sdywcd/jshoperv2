package com.jshop.action;

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
import com.jshop.entity.LogisticsbusinessareaT;
import com.jshop.service.LogisticsbusinessareaTService;
import com.jshop.service.impl.LogisticsbusinessareaTServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("jshop")
@Controller("logisticsbusinessareaTAction")
public class LogisticsbusinessareaTAction extends ActionSupport {
	private LogisticsbusinessareaTService logisticsbusinessareaTService;
	@Resource(name = "serial")
	private Serial serial;
	private String logbusareaid;
	private String logisticsid;
	private String logisticsname;
	private String areaname;
	private String costway;
	private String normalcost;
	private String overcost;
	private String freecount;
	private String sendarea;
	private String state;
	private String overvalue;
	private String needcostmin;
	private String needcostmax;
	private LogisticsbusinessareaT beanlist = new LogisticsbusinessareaT();
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean slogin;
	private String usession;

	@JSON(serialize = false)
	public LogisticsbusinessareaTService getLogisticsbusinessareaTService() {
		return logisticsbusinessareaTService;
	}

	public void setLogisticsbusinessareaTService(LogisticsbusinessareaTService logisticsbusinessareaTService) {
		this.logisticsbusinessareaTService = logisticsbusinessareaTService;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public String getLogbusareaid() {
		return logbusareaid;
	}

	public void setLogbusareaid(String logbusareaid) {
		this.logbusareaid = logbusareaid;
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

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getCostway() {
		return costway;
	}

	public void setCostway(String costway) {
		this.costway = costway;
	}

	public String getNormalcost() {
		return normalcost;
	}

	public void setNormalcost(String normalcost) {
		this.normalcost = normalcost;
	}

	public String getSendarea() {
		return sendarea;
	}

	public void setSendarea(String sendarea) {
		this.sendarea = sendarea;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public LogisticsbusinessareaT getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(LogisticsbusinessareaT beanlist) {
		this.beanlist = beanlist;
	}

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

	public String getOvercost() {
		return overcost;
	}

	public void setOvercost(String overcost) {
		this.overcost = overcost;
	}

	public String getFreecount() {
		return freecount;
	}

	public void setFreecount(String freecount) {
		this.freecount = freecount;
	}

	public String getOvervalue() {
		return overvalue;
	}

	public void setOvervalue(String overvalue) {
		this.overvalue = overvalue;
	}

	public String getNeedcostmin() {
		return needcostmin;
	}

	public void setNeedcostmin(String needcostmin) {
		this.needcostmin = needcostmin;
	}

	public String getNeedcostmax() {
		return needcostmax;
	}

	public void setNeedcostmax(String needcostmax) {
		this.needcostmax = needcostmax;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
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
	 *增加物流商区域价格
	 * 
	 * @return
	 */
	@Action(value = "addLogisticsbusinessarea", results = { @Result(name = "success", type = "redirect", location = "/jshop/admin/setting/logisticsareamanagement.jsp?session=${usession}"), @Result(name = "input", type = "redirect", location = "/jshop/admin/setting/logisticsareamanagement.jsp?session=${usession}") })
	public String addLogisticsbusinessarea() {

		LogisticsbusinessareaT lba = new LogisticsbusinessareaT();
		lba.setLogbusareaid(this.getSerial().Serialid(Serial.LOGISTICSBUSINESSAREA));
		lba.setLogisticsid(this.getLogisticsid().trim());
		//lba.setLogisticsname(this.getLogisticsname().trim());
		lba.setAreaname(this.getAreaname().trim());
		lba.setCostway(this.getCostway().trim());
		lba.setNeedcostmin(Double.parseDouble(this.getNeedcostmin()));
		lba.setNeedcostmax(Double.parseDouble(this.getNeedcostmax()));
		lba.setNormalcost(Double.parseDouble(this.getNormalcost()));
		lba.setOvervalue(Double.parseDouble(this.getOvervalue()));
		lba.setOvercost(Double.parseDouble(this.getOvercost()));
		//lba.setFreecount(Double.parseDouble(this.getFreecount()));
		lba.setSendarea(this.getSendarea().trim());
		lba.setState("1");
		if (this.getLogisticsbusinessareaTService().addLogisticsbusinessarea(lba) > 0) {
			return SUCCESS;
		}
		return INPUT;

	}

	/**
	 * 查询所有物流商区域价格
	 * 
	 * @return
	 */
	@Action(value = "findAllLogisticsbusinessareaT", results = { @Result(name = "json", type = "json") })
	public String findAllLogisticsbusinessareaT() {
		int currentPage = page;
		int lineSize = rp;
		List<LogisticsbusinessareaT> list = this.getLogisticsbusinessareaTService().findAllLogisticsbusinessareaT(currentPage, lineSize);
		if (list != null) {
			total = this.getLogisticsbusinessareaTService().countfindAllLogisticsbusinessareaT();
			rows.clear();
			for (Iterator it = list.iterator(); it.hasNext();) {
				LogisticsbusinessareaT lba = (LogisticsbusinessareaT) it.next();
				if (lba.getAreaname().equals("1")) {
					lba.setAreaname("全国");
				} else {
					lba.setAreaname("国际");
				}
				if (lba.getCostway().equals("1")) {
					lba.setCostway("重量模式");
				} else {
					lba.setCostway("件数计算");
				}
				if (lba.getState().equals("1")) {
					lba.setState("启用");
				} else {
					lba.setState("禁止");
				}
				Map cellMap = new HashMap();
				cellMap.put("id", lba.getLogbusareaid());
				cellMap.put("cell", new Object[] { lba.getAreaname(), lba.getCostway(), lba.getNeedcostmin(), lba.getNeedcostmax(), lba.getNormalcost(), lba.getOvervalue(), lba.getOvercost(), lba.getSendarea(), lba.getState() });
				rows.add(cellMap);
			}
			return "json";
		}
		this.setTotal(0);
		rows.clear();
		return "json";
	}

	/**
	 * 更新物流商区域价格
	 * 
	 * @return
	 */
	@Action(value = "UpdateLogisticsbusinessarea", results = { @Result(name = "json", type = "json") })
	public String UpdateLogisticsbusinessarea() {

		LogisticsbusinessareaT lba = new LogisticsbusinessareaT();
		lba.setLogbusareaid(this.getLogbusareaid().trim());
		lba.setLogisticsid(this.getLogisticsid().trim());
		lba.setLogisticsname(this.getLogisticsname().trim());
		lba.setAreaname(this.getAreaname().trim());
		lba.setCostway(this.getCostway().trim());
		lba.setNormalcost(Double.parseDouble(this.getNormalcost()));
		lba.setOvervalue(Double.parseDouble(this.getOvervalue()));
		lba.setOvercost(Double.parseDouble(this.getOvercost()));
		lba.setFreecount(Double.parseDouble(this.getFreecount()));
		lba.setSendarea(this.getSendarea().trim());
		lba.setState("1");
		this.getLogisticsbusinessareaTService().updateLogisticsbusinessarea(lba);
		return "json";

	}

	/**
	 *根据id获取物流商区域价格
	 * 
	 * @return
	 */
	@Action(value = "findLogisticsbusinessareaTById", results = { @Result(name = "json", type = "json") })
	public String findLogisticsbusinessareaTById() {
		if (Validate.StrNotNull(this.getLogbusareaid())) {
			beanlist = this.getLogisticsbusinessareaTService().findLogisticsbusinessareaTById(this.getLogbusareaid().trim());
			if (beanlist != null) {
				return "json";
			}
		}
		return "json";
	}

	/**
	 * 删除物流商区域价格
	 * 
	 * @return
	 */
	@Action(value = "DelLogisticsbusinessarea", results = { @Result(name = "json", type = "json") })
	public String DelLogisticsbusinessarea() {
		if (Validate.StrNotNull(this.getLogbusareaid())) {
			String[] strs = this.getLogbusareaid().trim().split(",");
			if (this.getLogisticsbusinessareaTService().delLogisticsbusinessarea(strs) > 0) {
				return "json";
			}
			return "json";
		}
		return "json";
	}

	/**
	 * 禁止和开启物流商区域价格
	 * 
	 * @return
	 */
	@Action(value = "UpdateLogisticsbusinessareaBystate", results = { @Result(name = "json", type = "json") })
	public String UpdateLogisticsbusinessareaBystate() {
		if (Validate.StrNotNull(this.getLogbusareaid()) && Validate.StrNotNull(this.getState())) {
			String[] array = this.getLogbusareaid().trim().split(",");
			this.getLogisticsbusinessareaTService().updateLogisticsbusinessareaBystate(array, this.getState().trim());
			return "json";
		}
		return "json";
	}
}
