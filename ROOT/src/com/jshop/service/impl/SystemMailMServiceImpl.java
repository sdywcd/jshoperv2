package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.SystemMailMDao;
import com.jshop.dao.impl.SystemMailMDaoImpl;
import com.jshop.entity.SystemMailM;
import com.jshop.service.SystemMailMService;
@Service("systemMailMService")
@Scope("prototype")
public class SystemMailMServiceImpl implements SystemMailMService {
	private SystemMailMDao systemMailMDao;
	

	public SystemMailMDao getSystemMailMDao() {
		return systemMailMDao;
	}

	public void setSystemMailMDao(SystemMailMDao systemMailMDao) {
		this.systemMailMDao = systemMailMDao;
	}

	public int addSystemMail(SystemMailM sm) {
		return this.getSystemMailMDao().addSystemMail(sm);
	}

	public int updateSystemMail(SystemMailM sm) {
		return this.getSystemMailMDao().updateSystemMail(sm);
	}

	public List<SystemMailM> findAllSystemMail(String taobaouserid) {
		return this.getSystemMailMDao().findAllSystemMail(taobaouserid);
	}

	public SystemMailM findSysmailBysmailid(String smialid) {

		return this.getSystemMailMDao().findSysmailBysmailid(smialid);
	}
}
