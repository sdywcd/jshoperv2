package com.jshop.action.front;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;
import com.jshop.entity.ArticleCategoryT;
import com.jshop.entity.GoodsCategoryT;
import com.jshop.entity.GoodsT;
import com.jshop.entity.JshopbasicInfoT;
import com.jshop.entity.SiteNavigationT;
import com.jshop.service.ArticleCategoryTService;
import com.jshop.service.ArticleTService;
import com.jshop.service.GoodsCategoryTService;
import com.jshop.service.GoodsTService;
import com.jshop.service.JshopbasicInfoTService;
import com.jshop.service.SiteNavigationTService;
import com.jshop.service.impl.ArticleCategoryTServiceImpl;
import com.jshop.service.impl.ArticleTServiceImpl;
import com.jshop.service.impl.GoodsCategoryTServiceImpl;
import com.jshop.service.impl.GoodsTServiceImpl;
import com.jshop.service.impl.JshopbasicInfoTServiceImpl;
import com.jshop.service.impl.SiteNavigationTServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")
@Namespace("")
@InterceptorRefs({  
    @InterceptorRef("defaultStack")  
})
@Controller("goodsCategoryAction")
public class GoodsCategoryAction extends ActionSupport{
	private GoodsTService goodsTService;
	private SiteNavigationTService siteNavigationTService;
	private GoodsCategoryTService goodsCategoryTService;
	private ArticleCategoryTService articleCategoryTService;
	private ArticleTService articleTService;
	private JshopbasicInfoTService jshopbasicInfoTService;
	private Map<String,Object>map=new HashMap<String,Object>();
	private List<GoodsT>goodsList;
	private String navid;
	private String ltypeid;
	private String stypeid;
	private String cp;
    private String ls;
   
    @JSON(serialize = false)
	public GoodsTService getGoodsTService() {
		return goodsTService;
	}
	public void setGoodsTService(GoodsTService goodsTService) {
		this.goodsTService = goodsTService;
	}
	@JSON(serialize = false)
	public SiteNavigationTService getSiteNavigationTService() {
		return siteNavigationTService;
	}
	public void setSiteNavigationTService(SiteNavigationTService siteNavigationTService) {
		this.siteNavigationTService = siteNavigationTService;
	}
	@JSON(serialize = false)
	public GoodsCategoryTService getGoodsCategoryTService() {
		return goodsCategoryTService;
	}
	public void setGoodsCategoryTService(GoodsCategoryTService goodsCategoryTService) {
		this.goodsCategoryTService = goodsCategoryTService;
	}
	@JSON(serialize = false)
	public ArticleCategoryTService getArticleCategoryTService() {
		return articleCategoryTService;
	}
	public void setArticleCategoryTService(ArticleCategoryTService articleCategoryTService) {
		this.articleCategoryTService = articleCategoryTService;
	}
	@JSON(serialize = false)
	public ArticleTService getArticleTService() {
		return articleTService;
	}
	public void setArticleTService(ArticleTService articleTService) {
		this.articleTService = articleTService;
	}
	@JSON(serialize = false)
	public JshopbasicInfoTService getJshopbasicInfoTService() {
		return jshopbasicInfoTService;
	}
	public void setJshopbasicInfoTService(JshopbasicInfoTService jshopbasicInfoTService) {
		this.jshopbasicInfoTService = jshopbasicInfoTService;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public List<GoodsT> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<GoodsT> goodsList) {
		this.goodsList = goodsList;
	}
	public String getNavid() {
		return navid;
	}
	public void setNavid(String navid) {
		this.navid = navid;
	}
	public String getLtypeid() {
		return ltypeid;
	}
	public void setLtypeid(String ltypeid) {
		this.ltypeid = ltypeid;
	}
	public String getStypeid() {
		return stypeid;
	}
	public void setStypeid(String stypeid) {
		this.stypeid = stypeid;
	}

	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	public String getLs() {
		return ls;
	}
	public void setLs(String ls) {
		this.ls = ls;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}

	/**
	 * 收集生成静态页所需数据
	 */
	public void createGoodsCategory(){
		this.findIndexSiteNavigation();
		this.findGoodsCategoryT();
		this.findJshopbasicInfo();
		findFooterCateogyrT();

		
		
	}
	/**
	 * 获取商城基本信息
	 */
	public void findJshopbasicInfo(){
		String state="1";
		String openstate="1";
		JshopbasicInfoT bean=this.getJshopbasicInfoTService().findJshopbasicInfoBystateandopstate(state, openstate);
		if(bean!=null){
			map.put("jshopbasicinfo", bean);
		}
		
	}
	/**
	 * 获取导航
	 */
	public void findIndexSiteNavigation(){
		String isVisible="1";
		List<SiteNavigationT>list=this.getSiteNavigationTService().findSiteNavigationByisVisible(isVisible);
		if(list!=null){
			map.put("siteNavigationList", list);
		}
	}
	/**
	 * 读取左侧主导航
	 * @return
	 */
	public void findGoodsCategoryT(){
		String state="1";
		List<GoodsCategoryT>list=this.getGoodsCategoryTService().findAllGoodsCategoryBycreatorid(state);
		if(list!=null){
			int gradecount=0;
			for(Iterator it=list.iterator();it.hasNext();){
				GoodsCategoryT gt=(GoodsCategoryT)it.next();
				if(gt.getGrade().equals("0")){
					gradecount++;
				}
			}
			map.put("goodsCategoryTree", list);
			map.put("goodsCategoryTreeFirstCount", gradecount);
		}
	}
	/**
	 * 获取页脚分类
	 */
	public void findFooterCateogyrT(){
		String position="1";
		String status="1";
		int lineSize=5;
		List<ArticleCategoryT>list=this.getArticleCategoryTService().findArticleCategoryByposition(lineSize, status, position);
		if(list!=null){
			map.put("footcategory", list);
		}
	}

	/**
	 * 根据属性获取商品列表用于属性搜索
	 * @return
	 */
//	public String findGoodsByAttrs(){
//		
//	}
//	
	
	

}
