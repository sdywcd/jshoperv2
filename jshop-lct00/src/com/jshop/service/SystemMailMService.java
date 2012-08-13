package com.jshop.service;

import java.util.List;

import com.jshop.entity.SystemMailM;

public interface SystemMailMService {
	/**
	 * 增加系统邮件
	 * @param sm
	 * @return
	 */
	public abstract int addSystemMail(SystemMailM sm);
	
	/**
	 *更新系统邮件
	 * @param sm
	 * @return
	 */
	public abstract int updateSystemMail(SystemMailM sm);
	/**
	 * 查找所有系统邮件
	 * @return
	 */
	public List<SystemMailM> findAllSystemMail(String taobaouserid);
	/**
	 * 根据smailid获取邮箱信息
	 * @param smialid
	 * @return
	 */
	public SystemMailM findSysmailBysmailid(String smialid);
}
