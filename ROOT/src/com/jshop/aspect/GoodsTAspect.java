package com.jshop.aspect;

import java.io.IOException;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import com.jshop.action.GoodsTNAction;
import com.jshop.entity.GoodsSpecificationsRelationshipT;


@Aspect
public class GoodsTAspect {
	private String typeid;
	private String goodsid;

	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	//||execution(String com.jshop.action.GoodsTNAction.updateSpecificationGoods())")
	@After("execution(String com.jshop.action.GoodsTNAction.addGoods())")
	public void afteraddSpecificationGoods(JoinPoint joinPoint) throws IOException{
		GoodsTNAction gtn=(GoodsTNAction) joinPoint.getThis();
		if (gtn.getIsSpecificationsOpen().equals("1")) {
			if(gtn.getSpecificationId()!=null ){
				if("1".equals(gtn.getIsSpecificationsOpen())){
					GoodsSpecificationsRelationshipT gsrt = new GoodsSpecificationsRelationshipT();
					gsrt.setSpecidicationsId(gtn.getSpecificationId());
					gsrt.setGoodsSetId(gtn.getBean().getGoodsid());
					gtn.getGoodsSpecificationsRelationshipTService().addGoodsAssociatedProductById(gsrt);
				}
			}
		}
	}
	@After("execution(String com.jshop.action.GoodsTNAction.updateGoods())")
	public void afterupdateSpecificationGoods(JoinPoint joinPoint) throws IOException{
		GoodsTNAction gtn=(GoodsTNAction) joinPoint.getThis();
		//当修改商品规格时关闭规格操作将删除该商品的规格值
		if("0".equals(gtn.getSpecificationId())){
			List<GoodsSpecificationsRelationshipT> list = gtn.getGoodsSpecificationsRelationshipTService().checkSpecificationRelationshipBygoodssetid(gtn.getBean().getGoodsid());
			if(list.size()>0){
				gtn.getGoodsSpecificationsRelationshipTService().delGoodsAssociatedProductById(gtn.getBean().getGoodsid());			
			}			
		}if("1".equals(gtn.getSpecificationId())){
			GoodsSpecificationsRelationshipT gsrt = new GoodsSpecificationsRelationshipT();
			gsrt.setSpecidicationsId(gtn.getSpecificationId());
			gsrt.setGoodsSetId(gtn.getBean().getGoodsid());
			gtn.getGoodsSpecificationsRelationshipTService().updateGoodsAssociatedProductById(gsrt);
			
		}
	}
    

}
