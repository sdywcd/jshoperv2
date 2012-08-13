package com.jshop.action;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;

import com.jshop.action.templates.CreateHtml;
import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.Serial;
import com.jshop.action.tools.Validate;
import com.jshop.entity.SystemMailM;
import com.jshop.service.SystemMailMService;
import com.jshop.service.UsertService;
import com.jshop.service.impl.SystemMailMServiceImpl;
import com.jshop.service.impl.UsertServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.TemplateException;

@SuppressWarnings("serial")
@ParentPackage("jshop")
@Controller("systemMailMAction")
public class SystemMailMAction extends ActionSupport {
	private UsertService usertService;
	private TaskExecutor taskExecutor;
	private SystemMailMService systemMailMService;
	@Resource(name = "createHtml")
	private CreateHtml createHtml;
	@Resource(name = "serial")
	private Serial serial;

	private String smailid;
	private String sysSendmail;
	private String sysMailSmtp;
	private String sysMailPort;
	private String smtpusername;
	private String smtppwd;
	private String state;
	private String userid;
	private String nick;
	private String detail;
	private SystemMailM bean = new SystemMailM();
	private List rows = new ArrayList();
	private int rp;
	private int page = 1;
	private int total = 0;
	private boolean slogin;
	private boolean hasSystemMail;
	private String createorid;//包括淘宝用户和一般用户
	private String usession;
	private boolean sucflag;

	@JSON(serialize = false)
	public TaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	@JSON(serialize = false)
	public UsertService getUsertService() {
		return usertService;
	}

	public void setUsertService(UsertService usertService) {
		this.usertService = usertService;
	}
	@JSON(serialize = false)
	public SystemMailMService getSystemMailMService() {
		return systemMailMService;
	}

	public void setSystemMailMService(SystemMailMService systemMailMService) {
		this.systemMailMService = systemMailMService;
	}

	@JSON(serialize = false)
	public CreateHtml getCreateHtml() {
		return createHtml;
	}

	public void setCreateHtml(CreateHtml createHtml) {
		this.createHtml = createHtml;
	}

	@JSON(serialize = false)
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}

	public String getSmailid() {
		return smailid;
	}

	public void setSmailid(String smailid) {
		this.smailid = smailid;
	}

	public String getSysSendmail() {
		return sysSendmail;
	}

	public void setSysSendmail(String sysSendmail) {
		this.sysSendmail = sysSendmail;
	}

	public String getSysMailSmtp() {
		return sysMailSmtp;
	}

	public void setSysMailSmtp(String sysMailSmtp) {
		this.sysMailSmtp = sysMailSmtp;
	}

	public String getSysMailPort() {
		return sysMailPort;
	}

	public void setSysMailPort(String sysMailPort) {
		this.sysMailPort = sysMailPort;
	}

	public String getSmtpusername() {
		return smtpusername;
	}

	public void setSmtpusername(String smtpusername) {
		this.smtpusername = smtpusername;
	}

	public String getSmtppwd() {
		return smtppwd;
	}

	public void setSmtppwd(String smtppwd) {
		this.smtppwd = smtppwd;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isSlogin() {
		return slogin;
	}

	public void setSlogin(boolean slogin) {
		this.slogin = slogin;
	}

	public SystemMailM getBean() {
		return bean;
	}

	public void setBean(SystemMailM bean) {
		this.bean = bean;
	}

	public boolean isHasSystemMail() {
		return hasSystemMail;
	}

	public void setHasSystemMail(boolean hasSystemMail) {
		this.hasSystemMail = hasSystemMail;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getCreateorid() {
		return createorid;
	}

	public void setCreateorid(String createorid) {
		this.createorid = createorid;
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

	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 创建淘宝用户在本地的session
	 */
	public void createTaobaosession() {
		ActionContext.getContext().getSession().get("adminid");
		ActionContext.getContext().getSession().get("taobao_user_nick");

	}

	/**
	 * 增加邮件地址
	 * 
	 * @return
	 */

	public String addSystemMail() {
		String taobao_usert_id = (String) ActionContext.getContext().getSession().get("adminid");
		String taobao_nick = (String) ActionContext.getContext().getSession().get("taobao_user_nick");
		if (!this.isHasSystemMail()) {

			SystemMailM sm = new SystemMailM();
			sm.setSmailid(this.getSerial().Serialid(Serial.SYSTEMMAILM));
			sm.setNick(taobao_nick);
			sm.setUserid(taobao_usert_id);
			sm.setSysSendmail(this.getSysSendmail().trim());
			sm.setSysMailSmtp(this.getSysMailSmtp().trim());
			sm.setSysMailPort(this.getSysMailPort().trim());
			sm.setSmtpusername(this.getSmtpusername().trim());
			sm.setSmtppwd(this.getSmtppwd().trim());
			sm.setState("0");
			if (this.getSystemMailMService().addSystemMail(sm) > 0) {
				return SUCCESS;
			} else {
				return INPUT;
			}
		} else {
			UpdateSystemMail();
			return SUCCESS;
		}
	}

	/**
	 * 更新系统邮件地址
	 * 
	 * @return
	 */
	public void UpdateSystemMail() {
		String taobao_usert_id = (String) ActionContext.getContext().getSession().get("adminid");
		SystemMailM sm = new SystemMailM();
		//		sm.setSmailid(this.getSmailid().trim());
		sm.setUserid(taobao_usert_id);
		sm.setSysSendmail(this.getSysSendmail().trim());
		sm.setSysMailSmtp(this.getSysMailSmtp().trim());
		sm.setSysMailPort(this.getSysMailPort().trim());
		sm.setSmtpusername(this.getSmtpusername().trim());
		sm.setSmtppwd(this.getSmtppwd().trim());
		sm.setState("1");
		@SuppressWarnings("unused")
		int i = this.getSystemMailMService().updateSystemMail(sm);

	}

	/**
	 * 查询系统邮件
	 * 
	 * @return
	 */
	@Action(value = "findAllSystemMail", results = { @Result(name = "json", type = "json") })
	public String findAllSystemMail() {
		List<SystemMailM> list = this.getSystemMailMService().findAllSystemMail(this.getCreateorid());
		if (list != null) {
			total = list.size();
			ProcessGoodsList(list);
		}
		return "json";
	}

	/**
	 * 检测系统邮件是否存在
	 */
	@SuppressWarnings("unchecked")
	public void CheckSystemMailList() {
		String taobao_usert_id = (String) ActionContext.getContext().getSession().get("adminid");
		bean = this.getSystemMailMService().findSysmailBysmailid(taobao_usert_id);
		if (bean != null) {
			this.setHasSystemMail(true);
		} else {
			this.setHasSystemMail(false);
		}
	}

	/**
	 * 根据淘宝用户ID 查询邮箱信息 需要修改
	 * 
	 * @return
	 */
	@Action(value = "findSysMailBySysSendMail", results = { @Result(name = "json", type = "json") })
	public String findSysMailBySysSendMail() {

		//bean= this.getSystemmailmserviceimpl().findSysmailBySendmail(this.getUserid().trim());
		bean = this.getSystemMailMService().findSysmailBysmailid(this.getSmailid().trim());
		if (bean != null) {
			return "json";
		}
		return "json";
	}

	/**
	 * 群发活动邮件
	 * 
	 * @return
	 * @throws MessagingException
	 * @throws IOException
	 * @throws TemplateException
	 */
	@Action(value = "sendActivityEmail", results = { @Result(name = "json", type = "json") })
	public String sendActivityEmail() throws MessagingException, IOException, TemplateException {
		String emailcontent = this.getDetail();
		final String[] email = this.getUsertService().findEmailByUser();
		final String htmlText = this.getCreateHtml().buildactivityEmail(emailcontent);
		this.getTaskExecutor().execute(new Runnable() {
			public void run() {
				InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("email.properties");
				Properties p = new Properties();
				try {
					p.load(inputStream);
					inputStream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				p.setProperty("mail.smtp.auth", "true");
				JavaMailSenderImpl sender = new JavaMailSenderImpl();
				sender.setHost("smtp.163.com");
				sender.setPort(25);
				sender.setJavaMailProperties(p);
				sender.setUsername("ttzj5201314@163.com");
				sender.setPassword("20060924");
				MimeMessage msg = sender.createMimeMessage();
				MimeMessageHelper helper = null;
				try {
					helper = new MimeMessageHelper(msg, false, "UTF-8");
				} catch (MessagingException e1) {
					e1.printStackTrace();
				}
				try {

					helper.setTo(email);

					helper.setFrom("ttzj5201314@163.com");
					helper.setSubject("促销");
					helper.setText(htmlText, true);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				sender.send(msg);

			}
		});
		return "json";
	}

	/**
	 * 迭代处理供前台显示
	 * 
	 * @param list
	 */
	@SuppressWarnings("unchecked")
	public void ProcessGoodsList(List<SystemMailM> list) {

		rows.clear();
		for (Iterator it = list.iterator(); it.hasNext();) {
			SystemMailM sm = (SystemMailM) it.next();
			Map cellMap = new HashMap();
			cellMap.put("id", sm.getSmailid());
			cellMap.put("cell", new Object[] { sm.getSysSendmail(), sm.getSysMailSmtp(), sm.getSysMailPort(), sm.getSmtpusername(), sm.getSmtppwd(), sm.getState(), sm.getUserid(), sm.getNick(), });
			rows.add(cellMap);
		}
	}

	/**
	 * 将邮箱设置成系统级别邮箱用来发送邮件激活等系统级动作，并更新email.properties
	 * 
	 * @return
	 */
	@Action(value = "setEmailToSysmail", results = { @Result(name = "json", type = "json") })
	public String setEmailToSysmail() {
		if (Validate.StrNotNull(this.getSmailid())) {
			SystemMailM sm = new SystemMailM();
			sm.setSmailid(this.getSmailid());
			sm = this.getSystemMailMService().findSysmailBysmailid(this.getSmailid());
			updateProperties(sm);
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}

	}

	public void updateProperties(SystemMailM sm) {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("email.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
			URL base = this.getClass().getResource("/");
			String path = base.getFile().substring(0, base.getFile().length() - 8);
			path = path + "classes/" + "email.properties";
			OutputStream fos = new FileOutputStream(path);
			p.setProperty("email.defaultEncoding", "UTF-8");
			p.setProperty("email.host", this.getSysMailSmtp().trim());
			p.setProperty("email.port", this.getSysMailPort().trim());
			p.setProperty("email.username", this.getSysSendmail().trim());
			p.setProperty("email.password", this.getSmtppwd().trim());
			p.setProperty("email.smtpname", this.getSmtpusername().trim());
			p.setProperty("email.timeout", "25000");
			p.setProperty("email.auth", "true");
			p.store(fos, "Update sysmail value");
			fos.close();
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Action(value = "updateEmailProperties", results = { @Result(name = "json", type = "json") })
	public String updateEmailProperties() {
		SystemMailM sm = new SystemMailM();
		updateProperties(sm);
		return "json";

	}
	
	
	/**
	 * 读取email.properties 里面的信息
	 * 
	 * @return
	 */
	@Action(value = "readProperties", results = { 
			@Result(name = "json",type="json")
	})
	public String readProperties() {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("email.properties");
		Properties p = new Properties();
		
		try {
			p.load(inputStream);
			inputStream.close();
			sysSendmail = p.getProperty("email.username");
			sysMailSmtp = p.getProperty("email.host");
			sysMailPort = p.getProperty("email.port");
			smtpusername = p.getProperty("email.smtpname");
			smtppwd = p.getProperty("email.password");
			
			
			return "json";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "json";
		}

	}

}
