package com.jshop.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Action;
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
@Controller("globalParamSetTAction")
public class GlobalParamSetTAction extends ActionSupport {
	private GlobalParamService globalParamService;
	private String issendactivatemail;
	private String stockwarning;
	private String integralconversionratio;
	private String mobilehost;
	private Map<String, Object> map = new HashMap<String, Object>();
	private boolean slogin;
	private boolean sucflag;

	@JSON(serialize = false)
	public GlobalParamService getGlobalParamService() {
		return globalParamService;
	}

	public void setGlobalParamService(GlobalParamService globalParamService) {
		this.globalParamService = globalParamService;
	}

	public String getIssendactivatemail() {
		return issendactivatemail;
	}

	public void setIssendactivatemail(String issendactivatemail) {
		this.issendactivatemail = issendactivatemail;
	}

	public String getStockwarning() {
		return stockwarning;
	}

	public void setStockwarning(String stockwarning) {
		this.stockwarning = stockwarning;
	}

	public String getIntegralconversionratio() {
		return integralconversionratio;
	}

	public void setIntegralconversionratio(String integralconversionratio) {
		this.integralconversionratio = integralconversionratio;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getMobilehost() {
		return mobilehost;
	}

	public void setMobilehost(String mobilehost) {
		this.mobilehost = mobilehost;
	}

	/**
	 * 获取所有全局参数
	 * 
	 * @return
	 */
	@Action(value = "findAllGlobalParam", results = { @Result(name = "json", type = "json") })
	public String findAllGlobalParam() {
		List<GlobalParamM> list = this.getGlobalParamService().findAllGlobalParam();
		if (list != null) {
			for (Iterator it = list.iterator(); it.hasNext();) {
				GlobalParamM gm = (GlobalParamM) it.next();
				if (gm.getGkey().equals(GlobalParam.ISSENDACTIVATEMAIL)) {
					map.put(GlobalParam.ISSENDACTIVATEMAIL, gm.getGvalue());
				}
				if (gm.getGkey().equals(GlobalParam.STOCKWARNING)) {
					map.put(GlobalParam.STOCKWARNING, gm.getGvalue());
				}
				if (gm.getGkey().equals(GlobalParam.INTEGRALCONVERSIONRATIO)) {
					map.put(GlobalParam.INTEGRALCONVERSIONRATIO, gm.getGvalue());
				}
				if(gm.getGkey().equals(GlobalParam.MOBILEHOST)){
					map.put(GlobalParam.MOBILEHOST, gm.getGvalue());
				}
			}
			
		}
		return "json";
	}

	/**
	 * 更新全局参数
	 * 
	 * @return
	 */
	@Action(value = "updateGolbalParamBykey", results = { @Result(name = "json", type = "json")})
	public String updateGolbalParamBykey() {
		GlobalParamM gm = new GlobalParamM();
		gm.setGkey(GlobalParam.ISSENDACTIVATEMAIL);
		gm.setGvalue(this.getIssendactivatemail());
		int i = this.getGlobalParamService().updateGolbalParamByKey(gm);
		gm.setGkey(GlobalParam.STOCKWARNING);
		gm.setGvalue(this.getStockwarning().trim());
		int j = this.getGlobalParamService().updateGolbalParamByKey(gm);
		gm.setGkey(GlobalParam.INTEGRALCONVERSIONRATIO);
		gm.setGvalue(this.getIntegralconversionratio().trim());
		int k = this.getGlobalParamService().updateGolbalParamByKey(gm);
		gm.setGkey(GlobalParam.MOBILEHOST);
		gm.setGvalue(this.getMobilehost().trim());
		this.getGlobalParamService().updateGolbalParamByKey(gm);
		this.setSucflag(true);
		return "json";
	}

}
