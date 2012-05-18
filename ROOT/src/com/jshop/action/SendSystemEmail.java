package com.jshop.action;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Properties;
import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import com.jshop.action.templates.CreateHtml;
import com.jshop.entity.UserT;
import com.opensymphony.xwork2.ActionSupport;

import com.opensymphony.xwork2.util.ResolverUtil.Test;

import freemarker.template.TemplateException;
@ParentPackage("jshop")

@Controller("sendSystemEmail")
public class SendSystemEmail extends ActionSupport {
	private TaskExecutor taskExecutor;
	@Resource(name="createHtml")
	private CreateHtml createHtml;
	private String username;
	private String sysSendmail;
	private String sysMailSmtp;
	private String sysMailPort;
	private String smtpusername;
	private String smtppwd;
	private boolean flag;
	@JSON(serialize = false)
	public TaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}
	@JSON(serialize = false)
	public CreateHtml getCreateHtml() {
		return createHtml;
	}

	public void setCreateHtml(CreateHtml createHtml) {
		this.createHtml = createHtml;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 获取网站根目录
	 * 
	 * @param map
	 * @throws UnknownHostException
	 */
	public String getBasePath() throws UnknownHostException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getContextPath();
		InetAddress inet = InetAddress.getLocalHost();
		return request.getScheme() + "://" + inet.getHostAddress() + ":" + request.getServerPort() + path + "/";
	}

	/**
	 * 发送激活邮件
	 * 
	 * @param user
	 * @throws MessagingException
	 * @throws IOException
	 * @throws TemplateException
	 */

	public void sendTextMail(final UserT user) throws MessagingException, IOException, TemplateException {
		String emailcontent = "<a href='" + getBasePath() + "html/default/shop/useractivatescallback.html?uid=" + user.getUid() + "'>点击激活</a>";
		final String htmlText = this.getCreateHtml().buildEmail(emailcontent);
		this.getTaskExecutor().execute(new Runnable() {

			public void run() {
				InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("email.properties");
				Properties p = new Properties();
				try {
					p.load(inputStream);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
				JavaMailSender sender = (JavaMailSender) ctx.getBean("javamailsenderimpl");
				MimeMessage msg = sender.createMimeMessage();
				MimeMessageHelper helper = null;
				try {
					helper = new MimeMessageHelper(msg, false, "UTF-8");
				} catch (MessagingException e1) {
					e1.printStackTrace();
				}
				try {
					helper.setTo(user.getEmail());
					helper.setFrom(p.getProperty("email.username"));
					helper.setSubject("ostocy会员激活邮件");
					helper.setText(htmlText, true);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				sender.send(msg);

			}
		});

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
