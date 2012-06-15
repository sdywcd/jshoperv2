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
	@After("execution(String com.jshop.action.GoodsTNAction.addGoods())")
	public void afteraddSpecificationGoods(JoinPoint joinPoint) throws IOException{
		GoodsTNAction gtn=(GoodsTNAction) joinPoint.getThis();
		if (gtn.getIsSpecificationsOpen().equals("1")) {
			if(gtn.getSpecificationsId()!=null ){
				GoodsSpecificationsRelationshipT gsrt = new GoodsSpecificationsRelationshipT();
				gsrt.setSpecidicationsId(gtn.getSpecificationsId());
				gsrt.setGoodsSetId(gtn.getBean().getGoodsid());
				gtn.getGoodsSpecificationsRelationshipTService().addGoodsAssociatedProductById(gsrt);
			}
		}
	}
	@After("execution(String com.jshop.action.GoodsTNAction.updateGoods())")
	public void afterupdateSpecificationGoods(JoinPoint joinPoint) throws IOException{
		GoodsTNAction gtn=(GoodsTNAction) joinPoint.getThis();
		//当修改商品规格时关闭规格操作将删除该商品的规格值
		if("2".equals(gtn.getIsSpecificationsOpen())||"0".equals(gtn.getIsSpecificationsOpen())){
			List<GoodsSpecificationsRelationshipT> list = gtn.getGoodsSpecificationsRelationshipTService().checkSpecificationRelationshipBygoodssetid(gtn.getBean().getGoodsid());
			if(!list.isEmpty()){
				gtn.getGoodsSpecificationsRelationshipTService().delGoodsAssociatedProductById(gtn.getBean().getGoodsid());			
			}			
		}
		if("1".equals(gtn.getIsSpecificationsOpen())&&gtn.getSpecificationsId() != null){
			List<GoodsSpecificationsRelationshipT> list = gtn.getGoodsSpecificationsRelationshipTService().checkSpecificationRelationshipBygoodssetid(gtn.getBean().getGoodsid());
			if(list.isEmpty()){
				GoodsSpecificationsRelationshipT gsrt = new GoodsSpecificationsRelationshipT();
				gsrt.setSpecidicationsId(gtn.getSpecificationsId());
				gsrt.setGoodsSetId(gtn.getBean().getGoodsid());
				gtn.getGoodsSpecificationsRelationshipTService().addGoodsAssociatedProductById(gsrt);			
			}else{	
				GoodsSpecificationsRelationshipT gsrt = new GoodsSpecificationsRelationshipT();
				gsrt.setSpecidicationsId(gtn.getSpecificationsId());
				gsrt.setGoodsSetId(gtn.getBean().getGoodsid());
				gtn.getGoodsSpecificationsRelationshipTService().updateGoodsAssociatedProductById(gsrt);
			}
		}
	}
    

}
