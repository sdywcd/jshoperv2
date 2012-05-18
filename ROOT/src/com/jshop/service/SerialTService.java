package com.jshop.service;

import com.jshop.dao.impl.SerialTDaoImpl;
import com.jshop.entity.SerialT;

public interface SerialTService {
	
	/**
	 * 保存逻辑id数据
	 * @param transientInstance
	 */
	public abstract void save(SerialT transientInstance);
	/**
	 * 查找新的逻辑id
	 * @param baseid
	 * @return
	 */
	public abstract SerialT findBybaseid(String biz);
	/**
	 * 更新新的逻辑id
	 * @param baseid
	 * @return
	 */
	public abstract int updateBybaseid(SerialT transientInstance);
}
