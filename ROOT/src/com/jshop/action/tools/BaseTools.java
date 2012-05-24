package com.jshop.action.tools;


import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;

public class BaseTools {
	/**
	 * 前台用户登录创建的session名称
	 */
	public static final String USER_SESSION_KEY="user";
	/**
	 * 后台用户登录创建的session名称
	 */
	public static final String BACK_USER_SESSION_KEY="admin";
	/**
	 * 后台用户登录创建的session用户名称
	 */
	public static final String BACK_USER_NAME_SESSION_KEY="username";
	/**
	 * 后台用户登录创建的session_key
	 */
	public static final String BACK_SESSION_KEY="sessionKey";

	/**
	 * 默认启用的模板主题标示
	 */
	 
	public static final String DEFAULTTHEMESIGN="theme";
	
	/**
	 * 默认的用户ID，用于在没有登录的情况下生成静态页面，主要是在安装的时候使用
	 */
	public static final String DEFAULTADMINID="20100721001";

	/**
	 * 用户的可操作的方法权限
	 */
	public static final String USERROLEFUNCTION="userrolefunction";
	/**
	 * 所有定义的权限
	 */
	public static final String ALLROLEFUNCTION="allrolefunction";
	
	public static final String KEYFORAUTHORITY="keyforauthority";
	
	/**
	 *设置日期格式
	 * 
	 * @return
	 */
	public static String tagdate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String time = formatter.format(cal.getTime()).toString();
		return time;
	}


	/**
	 * 获取系统时间
	 * 
	 * @return
	 * @throws ParseException 
	 */
	public static Date systemtime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(date);  
		ParsePosition pos = new ParsePosition(0);  
		Date currenttime = formatter.parse(dateString,pos);  
		return currenttime;
	}
	
	/**
	 * 转换数据库日期格式
	 * @param object
	 * @return
	 */
	public static String formateDbDate(Date object){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = formatter.format(object);
		return time;
	}
	
	/**
	 * 获取admin的id做为creatorid
	 * @return
	 */
	public static String adminCreateId(){
		String adminid = (String) ActionContext.getContext().getSession().get(BACK_USER_SESSION_KEY);
		if(!adminid.isEmpty()){
			return adminid;
		}
		return DEFAULTADMINID;
	}

	/**
	 * 获取默认的模板主题
	 * @return
	 */
	public static String getApplicationthemesig(){
		String defaultthemesign=(String)ActionContext.getContext().getApplication().get(DEFAULTTHEMESIGN);
		if(defaultthemesign!=null){
			return defaultthemesign;
		}
		return "default";
	}
}
