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
import com.jshop.entity.PaymentM;
import com.jshop.service.PaymentMService;
import com.jshop.service.impl.PaymentMServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("jshop")
@Controller("paymentMAction")
public class PaymentMAction extends ActionSupport {
	private PaymentMService paymentMService;
	@Resource(name = "serial")
	private Serial serial;

	private String paymentid;
	private String paymentname;
	private String paymentCode;
	private String paymentFree;
	private String paymentInterface;
	private String account;
	private String safecode;
	private String partnerid;
	private String des;
	private String isCod;
	private String isOnline;
	private String state;
	private PaymentM beanlist = new PaymentM();
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean slogin;
	private String usession;

	@JSON(serialize = false)
	public PaymentMService getPaymentMService() {
		return paymentMService;
	}

	public void setPaymentMService(PaymentMService paymentMService) {
		this.paymentMService = paymentMService;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public String getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}

	public String getPaymentname() {
		return paymentname;
	}

	public void setPaymentname(String paymentname) {
		this.paymentname = paymentname;
	}

	public String getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}

	public String getPaymentFree() {
		return paymentFree;
	}

	public void setPaymentFree(String paymentFree) {
		this.paymentFree = paymentFree;
	}

	public String getPaymentInterface() {
		return paymentInterface;
	}

	public void setPaymentInterface(String paymentInterface) {
		this.paymentInterface = paymentInterface;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getSafecode() {
		return safecode;
	}

	public void setSafecode(String safecode) {
		this.safecode = safecode;
	}

	public String getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(String partnerid) {
		this.partnerid = partnerid;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getIsCod() {
		return isCod;
	}

	public void setIsCod(String isCod) {
		this.isCod = isCod;
	}

	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public PaymentM getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(PaymentM beanlist) {
		this.beanlist = beanlist;
	}

	public String getUsession() {
		return usession;
	}

	public void setUsession(String usession) {
		this.usession = usession;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 增加支付方式
	 * 
	 * @return
	 */
	@Action(value = "addPayment", results = { @Result(name = "success", type = "redirect", location = "/jshop/admin/setting/paymentmanagement.jsp?session=${usession}"), @Result(name = "input", type = "redirect", location = "/jshop/admin/setting/paymentmanagement.jsp?session=${usession}") })
	public String addPayment() {

		PaymentM pm = new PaymentM();
		pm.setPaymentid(this.getSerial().Serialid(Serial.PAYMENT));
		pm.setPaymentname(this.getPaymentname().trim());
		pm.setPaymentCode(this.getPaymentCode().trim());
		pm.setPaymentFree("0");
		pm.setPaymentInterface(this.getPaymentInterface());
		pm.setAccount(this.getAccount().trim());
		pm.setSafecode(this.getSafecode().trim());
		pm.setPartnerid(this.getPartnerid().trim());
		pm.setDes(this.getDes().trim());
		pm.setIsCod(this.getIsCod().trim());
		pm.setIsOnline(this.getIsOnline().trim());
		pm.setState(this.getState().trim());
		if (this.getPaymentMService().addPayment(pm) > 0) {
			return SUCCESS;
		}
		return INPUT;

	}

	/**
	 *查询所有支付方式
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Action(value = "findAllPayment", results = { @Result(name = "json", type = "json") })
	public String findAllPayment() {
		int currentPage = page;
		int lineSize = rp;
		List<PaymentM> list = this.getPaymentMService().findAllPayment(currentPage, lineSize);
		if (list != null) {
			total = this.getPaymentMService().countfindAllPayment();
			rows.clear();
			for (Iterator it = list.iterator(); it.hasNext();) {
				PaymentM pm = (PaymentM) it.next();
				if (pm.getPaymentInterface().equals("1")) {
					pm.setPaymentInterface("即时到帐交易接口");
				} else if (pm.getPaymentInterface().equals("2")) {
					pm.setPaymentInterface("担保交易接口");
				} else {
					pm.setPaymentInterface("标准双接口");
				}
				if (pm.getIsCod().equals("1")) {
					pm.setIsCod("支持");
				} else {
					pm.setIsCod("不支持");
				}
				if (pm.getIsOnline().equals("1")) {
					pm.setIsOnline("支持");
				} else {
					pm.setIsOnline("不支持");
				}
				if (pm.getState().equals("1")) {
					pm.setState("开启");
				} else {
					pm.setState("禁止");
				}

				Map cellMap = new HashMap();
				cellMap.put("id", pm.getPaymentid());
				cellMap.put("cell", new Object[] { pm.getPaymentname(), pm.getPaymentCode(), pm.getPaymentFree(), pm.getPaymentInterface(), pm.getDes(), pm.getIsCod(), pm.getIsOnline(), pm.getState() });
				rows.add(cellMap);
			}
			return "json";
		}
		this.setTotal(0);
		rows.clear();
		return "json";
	}

	/**
	 * 开启支付方式
	 * 
	 * @return
	 */
	@Action(value = "OpenPayment", results = { @Result(name = "json", type = "json") })
	public String OpenPayment() {

		if (Validate.StrNotNull(this.getPaymentid())) {
			String[] strs = this.getPaymentid().trim().split(",");
			if (this.getPaymentMService().openPayment(strs) > 0) {
				return "json";
			}
			return "json";
		}
		return "json";

	}

	/**
	 * 禁止支付方式
	 * 
	 * @return
	 */
	@Action(value = "ClosePayment", results = { @Result(name = "json", type = "json") })
	public String ClosePayment() {

		if (Validate.StrNotNull(this.getPaymentid())) {
			String[] strs = this.getPaymentid().trim().split(",");
			if (this.getPaymentMService().closePayment(strs) > 0) {
				return "json";
			}
			return "json";
		}
		return "json";

	}

	/**
	 * 根据支付方式id获取支付方式
	 * 
	 * @return
	 */
	@Action(value = "findPaymentbyId", results = { @Result(name = "json", type = "json") })
	public String findPaymentbyId() {

		if (Validate.StrNotNull(this.getPaymentid())) {
			beanlist = this.getPaymentMService().findPaymentbyId(this.getPaymentid().trim());
			if (beanlist != null) {
				return "json";
			}
		}
		return "json";

	}
}
