package com.jshop.action.interceptor;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.jshop.dao.impl.GoodsAttributeTDaoImpl;
import com.jshop.entity.GoodsTypeTN;
import com.jshop.service.GoodsAttributeTService;
import com.jshop.service.GoodsTService;
import com.jshop.service.GoodsTypeBrandTService;
import com.jshop.service.impl.GoodsAttributeTServiceImpl;
import com.jshop.service.impl.GoodsTServiceImpl;
import com.jshop.service.impl.GoodsTypeBrandTServiceImpl;
/**
 * 对商品模块中需要做验证后才能执行的方法做统一的拦截器处理
 * @author cd
 *
 */
@ParentPackage("jshop")

@Controller("goodsmoduleInterecptor")
public class GoodsmoduleInterecptor {
	private GoodsTypeBrandTService goodsTypeBrandTService;
	private GoodsAttributeTService goodsAttributeTService;
	private GoodsTService goodsTService;
	public GoodsTypeBrandTService getGoodsTypeBrandTService() {
		return goodsTypeBrandTService;
	}
	public void setGoodsTypeBrandTService(GoodsTypeBrandTService goodsTypeBrandTService) {
		this.goodsTypeBrandTService = goodsTypeBrandTService;
	}
	public GoodsAttributeTService getGoodsAttributeTService() {
		return goodsAttributeTService;
	}
	public void setGoodsAttributeTService(GoodsAttributeTService goodsAttributeTService) {
		this.goodsAttributeTService = goodsAttributeTService;
	}
	public GoodsTService getGoodsTService() {
		return goodsTService;
	}
	public void setGoodsTService(GoodsTService goodsTService) {
		this.goodsTService = goodsTService;
	}
	/**
	 * 更新商品品牌类型中的商品类型，当商品类型被修改以后
	 * @param gtn
	 * @return
	 */
	public void updateGoodsTypeBrandTname(String name,String goodsTypeId){
		this.getGoodsTypeBrandTService().updateGoodsTypeBrandTname(name, goodsTypeId);
		
	}
	/**
	 * 更新商品属性中的商品类型
	 * @param goodsTypeName
	 * @param goodsTypeId
	 */
	public void updateGoodsAttributeTgoodsTypeName(String goodsTypeName,String goodsTypeId){
		this.getGoodsAttributeTService().updateGoodsAttributeTgoodsTypeName(goodsTypeName, goodsTypeId);
	}
	/**
	 * 更新商品表中的商品类型
	 * @param goodsTypeName
	 * @param goodsTypeId
	 */
	public void updateGoodsTypeNameBygoodsTypeId(String goodsTypeName,String goodsTypeId){
		this.getGoodsTService().updateGoodsTypeNameBygoodsTypeId(goodsTypeName, goodsTypeId);
	}
	/**
	 * 根据传入的参数更新商品表中的商品分类
	 * @param nlsid
	 * @param nlsname
	 * @param grade
	 */
	public void updateGoodsCategoryBynlsid(String nlsid,String nlsname){
		String queryString="update GoodsT as gt set gt.nname='"+nlsname+"' where gt.navid='"+nlsid+"' or gt.ltypeid='"+nlsid+"' or gt.stypeid='"+nlsid+"' ";
		this.getGoodsTService().updateGoodsCategoryBynlsid(queryString);
	}
	/**
	 * 当商品分类被删除时更新对应的所有商品到下架状态
	 */
	public void updateGoodsSaleState(String goodsTypeId){
		String salestate="0";
		this.getGoodsTService().updateGoodsSaleState(goodsTypeId, salestate);
	}
	
	/**
	 * 收集生成商品分类静态页需要的数据集合
	 */
	
	
	
	
	
	
	
	
	
	
}
