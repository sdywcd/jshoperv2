package com.jshop.dao;

import java.util.List;

import com.jshop.entity.GlobalParamM;

public interface GlobalParamMDao {
	/**
	 * 更新全局变量
	 * @param key
	 * @param value
	 * @return
	 */
	public abstract int updateGolbalParamByKey(GlobalParamM gm);
	
	/**
	 * 根据key获取全局值
	 * @param key
	 * @return
	 */
	public abstract GlobalParamM findValueByKey(String key);
	/**
	 * 获取所有全局变量
	 * @return
	 */
	public abstract List<GlobalParamM>findAllGlobalParam();
	
}
