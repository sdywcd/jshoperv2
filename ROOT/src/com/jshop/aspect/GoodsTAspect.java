package com.jshop.aspect;

import java.io.IOException;

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

}
