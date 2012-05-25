package com.jshop.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.tools.Serial;
import com.jshop.action.tools.Validate;
import com.jshop.entity.TableT;
import com.jshop.service.TableTService;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Controller("electableTAction")
public class ElectableTAction extends ActionSupport {
	private TableTService tableTService;
	private Serial serial;
	private String tableid;
	private String tableNumber;
	private String roomName;
	private Integer androidDevicesCount;
	private String note;
	private Date createtime;
	private String creatorid;
	private Integer nop;
	private String tablestate;
	private Integer floor;
	private Integer rnop;
	private String query;
	private String qtype;
	private List rows = new ArrayList();
	private boolean slogin;
	private boolean sucflag;
	private int rp;
	private int page = 1;
	private int total = 0;
	
	
	
	@JSON(serialize = false)
	public TableTService getTableTService() {
		return tableTService;
	}
	public void setTableTService(TableTService tableTService) {
		this.tableTService = tableTService;
	}
	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	public String getTableid() {
		return tableid;
	}
	public void setTableid(String tableid) {
		this.tableid = tableid;
	}
	public String getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Integer getAndroidDevicesCount() {
		return androidDevicesCount;
	}
	public void setAndroidDevicesCount(Integer androidDevicesCount) {
		this.androidDevicesCount = androidDevicesCount;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
	public Integer getNop() {
		return nop;
	}
	public void setNop(Integer nop) {
		this.nop = nop;
	}
	public String getTablestate() {
		return tablestate;
	}
	public void setTablestate(String tablestate) {
		this.tablestate = tablestate;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public Integer getRnop() {
		return rnop;
	}
	public void setRnop(Integer rnop) {
		this.rnop = rnop;
	}
	public boolean isSlogin() {
		return slogin;
	}
	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
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
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}
	/**
	 * 获取所有餐桌
	 */
	public String findAllTableT(){
		if (this.getQtype().equals("sc")){
			this.setTotal(0);
			rows.clear();
			this.findDefaultAllTableT();
		}else{
			if(Validate.StrisNull(this.getQuery())){
				return "json";
			}else{
				return "json";
			}
		}			
		return "json";
	}
	
	public void findDefaultAllTableT(){
		int currentPage = page;
		int lineSize = rp;
		this.setTotal(this.getTableTService().countfindAllTableT());
		List<TableT> list = this.getTableTService().findAllTableT(currentPage, lineSize);
		if(list != null){
			;
		}
	}
	
	public void ProcessTableTList(List<TableT> list){
		rows.clear();
		for (Iterator it = list.iterator(); it.hasNext();){
			TableT tt = (TableT) it.next();
			//if("0".equals(tt.get))
			
		}
	}
}
