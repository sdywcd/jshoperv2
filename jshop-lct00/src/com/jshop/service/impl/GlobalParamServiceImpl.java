package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.GlobalParamMDao;
import com.jshop.dao.impl.GlobalParamMDaoImpl;
import com.jshop.entity.GlobalParamM;
import com.jshop.service.GlobalParamService;

@Service("globalParamService")
@Scope("prototype")
public class GlobalParamServiceImpl implements GlobalParamService {
	private GlobalParamMDao globalParamMDao;

	
	public GlobalParamMDao getGlobalParamMDao() {
		return globalParamMDao;
	}

	public void setGlobalParamMDao(GlobalParamMDao globalParamMDao) {
		this.globalParamMDao = globalParamMDao;
	}

	public int updateGolbalParamByKey(GlobalParamM gm) {
		return this.getGlobalParamMDao().updateGolbalParamByKey(gm);
	}

	public GlobalParamM findValueByKey(String key) {
		return this.getGlobalParamMDao().findValueByKey(key);
	}

	public List<GlobalParamM> findAllGlobalParam() {
		return this.getGlobalParamMDao().findAllGlobalParam();
	}
}
