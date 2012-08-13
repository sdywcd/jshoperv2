package com.jshop.dao;

import java.util.List;

import com.jshop.entity.TemplateT;

public interface TemplateTDao {

	/**
	 * 增加模板
	 * @param tt
	 * @return
	 */
	public abstract int addTemplate(TemplateT tt);
	
	/**
	 * 查询所有模板
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<TemplateT>findAllTemplate(final int currentPage,final int lineSize,final String creatorid);
	
	/**
	 * 统计查询所有模板
	 * @return
	 */
	public abstract int countfindAllTemplate(String creatorid);
	/**
	 * 更新模板
	 * @param tt
	 * @return
	 */
	public abstract int updateTemplate(TemplateT tt);
	/**
	 * 根据id查找模板
	 * @param tid
	 * @return
	 */
	public abstract TemplateT findTemplateByTid(String tid);

	/**
	 * 删除模板
	 * @param list
	 * @return
	 */
	public abstract int delTemplate(String []list);
	/**
	 * 获取所有启用的模板数据
	 * @param status
	 * @return
	 */
	public abstract List<TemplateT>findAllTemplateWithNoParam(String creatorid,String status);
	/**
	 * 检测模板文件唯一性
	 * @param creatorid
	 * @param note
	 * @param name
	 * @return
	 */
	public abstract int findTemplateBynameandnote(String creatorid,String note,String name);
	/**
	 * 通过sign检测模板文件唯一性，必须保证sign唯一
	 * @param sign
	 * @return
	 */
	public abstract int checkTemplateBysign(String sign);
	
	/**
	 * 根据name和creatorid获取模板文件
	 * @param creatorid
	 * @param name
	 * @return
	 */
	public abstract TemplateT findTemplateByname(String creatorid,String name);
	/**
	 * 根据模板类型获取模板文件
	 * @param type
	 * @return
	 */
	public abstract TemplateT findTemplateBytype(String type);
	/**
	 * 检测模板主题下是否有模板文件
	 * @param themeid
	 * @return
	 */
	public abstract TemplateT checkTemplatetheme(String themeid);
	/**
	 * 根据模板主题id更新模板文件状态
	 * @param themeid
	 * @param status
	 */
	public abstract int updateTemplatetBystatus(String themeid,String status);
	/**
	 * 根据sign和status获取模板文件
	 * @param sign
	 * @param status
	 * @return
	 */
	public abstract TemplateT findTemplateBysign(String sign,String status);
	
	
}
