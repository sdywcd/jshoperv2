package com.jshop.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.GlobalParam;
import com.jshop.entity.GlobalParamM;
import com.jshop.service.GlobalParamService;
import com.jshop.service.impl.GlobalParamServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")

@Controller("jshopbasicSafeSetTAction")
public class JshopbasicSafeSetTAction extends ActionSupport {
	private GlobalParamService globalParamService;
	private String isusercanregister;
	private String isautolockaccount;
	private String maxloginnum;
	private String unlocktime;
	private boolean slogin;
	private boolean sucflag;
	private String usession;
	
	@JSON(serialize = false)
	public GlobalParamService getGlobalParamService() {
		return globalParamService;
	}

	public void setGlobalParamService(GlobalParamService globalParamService) {
		this.globalParamService = globalParamService;
	}

	public String getIsusercanregister() {
		return isusercanregister;
	}

	public void setIsusercanregister(String isusercanregister) {
		this.isusercanregister = isusercanregister;
	}

	public String getIsautolockaccount() {
		return isautolockaccount;
	}

	public void setIsautolockaccount(String isautolockaccount) {
		this.isautolockaccount = isautolockaccount;
	}

	public String getMaxloginnum() {
		return maxloginnum;
	}

	public void setMaxloginnum(String maxloginnum) {
		this.maxloginnum = maxloginnum;
	}

	public String getUnlocktime() {
		return unlocktime;
	}

	public void setUnlocktime(String unlocktime) {
		this.unlocktime = unlocktime;
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

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}



	/**
	 * 更新安全设定
	 * 
	 * @return
	 */
	@Action(value = "UpdatesafeSet", results = { 
			@Result(name = "success", type="redirect",location = "/jshop/admin/setting/jshopbasicsafeset.jsp?session=${usession}"),
			@Result(name = "input", type="redirect",location = "/jshop/admin/setting/jshopbasicsafeset.jsp?session=${usession}")
	})
	public String UpdatesafeSet() {
			GlobalParamM gm = new GlobalParamM();
			gm.setGkey(GlobalParam.ISUSERCANREGISTER);
			gm.setGvalue(this.getIsusercanregister().trim());
			@SuppressWarnings("unused")
			int i = this.getGlobalParamService().updateGolbalParamByKey(gm);
			if (this.getIsautolockaccount().equals("1")) {
				gm.setGkey(GlobalParam.ISAUTOLOCKACCOUNT);
				gm.setGvalue(this.getIsautolockaccount());
				@SuppressWarnings("unused")
				int k = this.getGlobalParamService().updateGolbalParamByKey(gm);
				gm.setGkey(GlobalParam.MAXLOGINNUM);
				gm.setGvalue(this.getMaxloginnum().trim());
				@SuppressWarnings("unused")
				int j = this.getGlobalParamService().updateGolbalParamByKey(gm);
				gm.setGkey(GlobalParam.UNLOCKTIME);
				gm.setGvalue(this.getUnlocktime().trim());
				@SuppressWarnings("unused")
				int l = this.getGlobalParamService().updateGolbalParamByKey(gm);
			} else {
				gm.setGkey(GlobalParam.ISAUTOLOCKACCOUNT);
				gm.setGvalue(this.getIsautolockaccount());
				@SuppressWarnings("unused")
				int m = this.getGlobalParamService().updateGolbalParamByKey(gm);
				return SUCCESS;
			}
			return SUCCESS;
	}

	/**
	 * 获取所有安全设定值
	 * 
	 * @return
	 */
	@Action(value="findsafeSet",results={
			@Result(name="json",type="json")
	})
	public String findsafeSet() {
			GlobalParamM gm = new GlobalParamM();
			gm = this.getGlobalParamService().findValueByKey(GlobalParam.ISUSERCANREGISTER);
			this.setIsusercanregister(gm.getGvalue());
			gm = this.getGlobalParamService().findValueByKey(GlobalParam.ISAUTOLOCKACCOUNT);
			this.setIsautolockaccount(gm.getGvalue());
			if (gm.getGvalue().equals("1")) {
				gm = this.getGlobalParamService().findValueByKey(GlobalParam.MAXLOGINNUM);
				this.setMaxloginnum(gm.getGvalue());
				gm = this.getGlobalParamService().findValueByKey(GlobalParam.UNLOCKTIME);
				this.setUnlocktime(gm.getGvalue());
			} else {
				this.setSucflag(true);
				return "json";
			}
			this.setSucflag(true);
			return "json";
	}
}
