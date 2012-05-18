package com.jshop.action.templates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;
import com.jshop.action.tools.BaseTools;
import com.jshop.entity.ArticleCategoryT;
import com.jshop.entity.ArticleT;
import com.jshop.entity.BrandT;
import com.jshop.entity.GoodsAttributeT;
import com.jshop.entity.GoodsCategoryT;
import com.jshop.entity.GoodsCommentT;
import com.jshop.entity.GoodsT;
import com.jshop.entity.GoodsTypeBrandT;
import com.jshop.entity.JshopbasicInfoT;
import com.jshop.entity.PageEditareaT;
import com.jshop.entity.SiteNavigationT;
import com.jshop.service.ArticleCategoryTService;
import com.jshop.service.ArticleTService;
import com.jshop.service.BrandTService;
import com.jshop.service.GoodsAttributeTService;
import com.jshop.service.GoodsCategoryTService;
import com.jshop.service.GoodsCommentTService;
import com.jshop.service.GoodsTService;
import com.jshop.service.GoodsTypeBrandTService;
import com.jshop.service.JshopbasicInfoTService;
import com.jshop.service.PageEditareaTService;
import com.jshop.service.SiteNavigationTService;
import com.jshop.service.impl.ArticleCategoryTServiceImpl;
import com.jshop.service.impl.ArticleTServiceImpl;
import com.jshop.service.impl.GoodsCategoryTServiceImpl;
import com.jshop.service.impl.GoodsTServiceImpl;
import com.jshop.service.impl.JshopbasicInfoTServiceImpl;
import com.jshop.service.impl.PageEditareaTServiceImpl;
import com.jshop.service.impl.SiteNavigationTServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.emory.mathcs.backport.java.util.Collections;

/**
 * 数据收集 收集所有模板页面需要的数据
 * 
 * @author cd
 * 
 */

@ParentPackage("json-default")
@Namespace("")
@Controller("dataCollectionTAction")
public class DataCollectionTAction extends ActionSupport {

	private JshopbasicInfoTService jshopbasicInfoTService;
	private SiteNavigationTService siteNavigationTService;
	private PageEditareaTService pageEditareaTService;
	private GoodsCategoryTService goodsCategoryTService;
	private BrandTService brandTService;
	private GoodsTypeBrandTService goodsTypeBrandTService;
	private int gradecount;
	private GoodsTService goodsTService;
	private ArticleTService articleTService;
	private ArticleCategoryTService articleCategoryTService;
	private GoodsAttributeTService goodsAttributeTService;
	private GoodsCommentTService goodsCommentTService;
	private String logmsg;
	@JSON(serialize = false)
	public GoodsCommentTService getGoodsCommentTService() {
		return goodsCommentTService;
	}

	public void setGoodsCommentTService(GoodsCommentTService goodsCommentTService) {
		this.goodsCommentTService = goodsCommentTService;
	}

	@JSON(serialize = false)
	public GoodsAttributeTService getGoodsAttributeTService() {
		return goodsAttributeTService;
	}

	public void setGoodsAttributeTService(GoodsAttributeTService goodsAttributeTService) {
		this.goodsAttributeTService = goodsAttributeTService;
	}

	@JSON(serialize = false)
	public GoodsTypeBrandTService getGoodsTypeBrandTService() {
		return goodsTypeBrandTService;
	}

	public void setGoodsTypeBrandTService(GoodsTypeBrandTService goodsTypeBrandTService) {
		this.goodsTypeBrandTService = goodsTypeBrandTService;
	}

	@JSON(serialize = false)
	public BrandTService getBrandTService() {
		return brandTService;
	}

	public void setBrandTService(BrandTService brandTService) {
		this.brandTService = brandTService;
	}

	@JSON(serialize = false)
	public JshopbasicInfoTService getJshopbasicInfoTService() {
		return jshopbasicInfoTService;
	}

	public void setJshopbasicInfoTService(JshopbasicInfoTService jshopbasicInfoTService) {
		this.jshopbasicInfoTService = jshopbasicInfoTService;
	}

	@JSON(serialize = false)
	public SiteNavigationTService getSiteNavigationTService() {
		return siteNavigationTService;
	}

	public void setSiteNavigationTService(SiteNavigationTService siteNavigationTService) {
		this.siteNavigationTService = siteNavigationTService;
	}

	@JSON(serialize = false)
	public PageEditareaTService getPageEditareaTService() {
		return pageEditareaTService;
	}

	public void setPageEditareaTService(PageEditareaTService pageEditareaTService) {
		this.pageEditareaTService = pageEditareaTService;
	}

	@JSON(serialize = false)
	public GoodsCategoryTService getGoodsCategoryTService() {
		return goodsCategoryTService;
	}

	public void setGoodsCategoryTService(GoodsCategoryTService goodsCategoryTService) {
		this.goodsCategoryTService = goodsCategoryTService;
	}

	@JSON(serialize = false)
	public GoodsTService getGoodsTService() {
		return goodsTService;
	}

	public void setGoodsTService(GoodsTService goodsTService) {
		this.goodsTService = goodsTService;
	}

	@JSON(serialize = false)
	public ArticleTService getArticleTService() {
		return articleTService;
	}

	public void setArticleTService(ArticleTService articleTService) {
		this.articleTService = articleTService;
	}

	@JSON(serialize = false)
	public ArticleCategoryTService getArticleCategoryTService() {
		return articleCategoryTService;
	}

	public void setArticleCategoryTService(ArticleCategoryTService articleCategoryTService) {
		this.articleCategoryTService = articleCategoryTService;
	}

	public int getGradecount() {
		return gradecount;
	}

	public void setGradecount(int gradecount) {
		this.gradecount = gradecount;
	}

	public String getLogmsg() {
		return logmsg;
	}

	public void setLogmsg(String logmsg) {
		this.logmsg = logmsg;
	}

	/**
	 * 获取网站根目录
	 * 
	 * @return
	 */
	public String getBasePath() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getContextPath();
		String basePath = path + "/";
		return basePath;
	}

	/**
	 * 获取session数据
	 * 
	 * @return
	 */
	public Map<String, Object> getSession() {
		return ActionContext.getContext().getSession();
	}

	/**
	 * 获取商城基本信息
	 */
	public JshopbasicInfoT findJshopbasicInfo() {
		try {
			String state = "1";//商城状态标记
			String openstate = "1";//商城开启运作标记
			JshopbasicInfoT bean = this.getJshopbasicInfoTService().findJshopbasicInfoBystateandopstate(state, openstate);
			if (bean != null) {
				return bean;
			}
		} catch (Exception e) {
			this.setLogmsg("<p style='color:red;'>" + e.getMessage() + "</p>");
		}
		this.setLogmsg("<p>商城基础信息获取成功");
		return (JshopbasicInfoT) Collections.emptyList().get(0);

	}

	/**
	 * 获取导航
	 */
	@SuppressWarnings( { "unchecked"})
	public List<SiteNavigationT> findSiteNavigation() {
		try {
			String isVisible = "1";//显示标记
			List<SiteNavigationT> list = this.getSiteNavigationTService().findSiteNavigationByisVisible(isVisible);
			if (!list.isEmpty()) {
				return list;
			}
		} catch (Exception e) {
			this.setLogmsg("<p style='color:red;'>" + e.getMessage() + "</p>");
		}
		this.setLogmsg("<p>获取导航数据成功</p>");
		return Collections.emptyList();

	}

	/**
	 * 获取自定义区域
	 * 
	 * @return
	 */
	@SuppressWarnings( { "unchecked", "unchecked" })
	public Map<String, Object> findEditarea(String sign, String state, Map<String, Object> map) {
		try{
			List<PageEditareaT> list = this.getPageEditareaTService().findPageEditareaTBySign(sign, state, BaseTools.adminCreateId());
			if (!list.isEmpty()) {
				for (Iterator it = list.iterator(); it.hasNext();) {
					PageEditareaT pea = (PageEditareaT) it.next();
					if (pea.getEditflag() == 1) {
						map.put("p1", pea);
					}
					if (pea.getEditflag() == 2) {
						map.put("p2", pea);
					}
					if (pea.getEditflag() == 3) {
						map.put("p3", pea);
					}
					if (pea.getEditflag() == 4) {
						map.put("p4", pea);
					}
					if (pea.getEditflag() == 5) {
						map.put("p5", pea);
					}
					if (pea.getEditflag() == 6) {
						map.put("p6", pea);
					}
					if (pea.getEditflag() == 7) {
						map.put("p7", pea);
					}
					if (pea.getEditflag() == 8) {
						map.put("p8", pea);
					}
					if (pea.getEditflag() == 9) {
						map.put("p9", pea);
					}
					if (pea.getEditflag() == 10) {
						map.put("p10", pea);
					}
					if (pea.getEditflag() == 11) {
						map.put("p11", pea);
					}
					if (pea.getEditflag() == 12) {
						map.put("p12", pea);
					}
					if (pea.getEditflag() == 13) {
						map.put("p13", pea);
					}
				}
				return map;
			}
		
		}catch(Exception e){
			this.setLogmsg("<p style='color:red;'>"+e.getMessage()+"</p>");
		}
		this.setLogmsg("<p>获取首页自定义区域数据成功</p>");
		return Collections.emptyMap();
	}

	/**
	 * 读取左侧主导航(商品分类)
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsCategoryT> findGoodsCategoryT() {
		try {
			String state = "1";//标示激活的商品分类
			List<GoodsCategoryT> list = this.getGoodsCategoryTService().findAllGoodsCategoryT(state);
			if (!list.isEmpty()) {
				for (Iterator it = list.iterator(); it.hasNext();) {
					GoodsCategoryT gt = (GoodsCategoryT) it.next();
					if (gt.getGrade().equals("0")) {
						gradecount++;
					}
				}
				return list;
			}
		} catch (Exception e) {
			this.setLogmsg("<p style='color:red;'>" + e.getMessage() + "</p>");
		} 
		this.setLogmsg("<p>商品分类导航数据获取成功</p>");
		return Collections.emptyList();

	}

	/**
	 * 统计顶级分类个数
	 * 
	 * @return
	 */
	public int getGoodsCategoryTreeFirstCount() {
		return this.getGradecount();
	}

	/**
	 * 根据状态获取商品分类,用于生成静态分页商品列表
	 * 
	 * @return
	 */
	public List<GoodsCategoryT> findAllGoodsCategoryTByState() {
		String state = "1";//启用的商品状态
		List<GoodsCategoryT> list = this.getGoodsCategoryTService().findAllGoodsCategoryT(state);
		if (!list.isEmpty()) {
			return list;
		} 
		return Collections.emptyList();
		
	}
	
	/**
	 * 获取二级商品分类
	 * @param parentId
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "unchecked" })
	public List<GoodsCategoryT>findSecondGoodsCategoryT(String parentId){
		String state="1";
		List<GoodsCategoryT>list=this.getGoodsCategoryTService().findGoodscategoryByparentId(state, parentId);
		if(!list.isEmpty()){
			return list;
		}
		return Collections.emptyList();
	}
	

	/**
	 * 查询所有上架商品数据
	 * 
	 * @return
	 */
	public List<GoodsT> findAllGoodsT() {
		String salestate = "1";//标示上架
		List<GoodsT> list = this.getGoodsTService().finaAllGoodsT(salestate);
		if (!list.isEmpty()) {
			return list;
		}
		return Collections.emptyList();
		
	}
	
	
	

	/**
	 * 获取所有文章数据
	 * 
	 * @return
	 */
	public List<ArticleT> findAllArticleT() {
		String status = "1";//标示显示
		List<ArticleT> list = this.getArticleTService().findAllArticleT(status);
		if (!list.isEmpty()) {
			return list;
		} else {
			return Collections.emptyList();
		}
	}

	/**
	 * 获取页脚文章一级分类
	 */
	public List<ArticleCategoryT> findFooterCateogyrT() {
		try{
			String grade = "0";//标示文章是顶级分类
			String status = "1";//标示显示
			List<ArticleCategoryT> list = this.getArticleCategoryTService().findArticleCategoryByGrade(grade, status);
			if (!list.isEmpty()) {
				return list;
			}
			
		}catch(Exception e){
			this.setLogmsg("<p style='color:red;'>"+e.getMessage()+"</p>");
		}
		this.setLogmsg("<p>商城页脚分类数据获取成功</p>");
		return Collections.emptyList();
		
	}

	/**
	 * 获取页脚文章一级分类下得文章
	 */
	@SuppressWarnings( { "unused", "unchecked" })
	public List<ArticleT> findFooterArticle() {
		try{
			String status = "1";//显示的文章
			List<ArticleT> list = this.getArticleTService().findAllArticleT(status);
			if (!list.isEmpty()) {
				List<ArticleT> list1 = new ArrayList<ArticleT>();
				for (Iterator it = list.iterator(); it.hasNext();) {
					ArticleT at = (ArticleT) it.next();
					if (at.getPosition() != null && at.getPosition().equals("1")) {
						list1.add(at);
					}
				}
				return list1;
			}
			
		}catch(Exception e){
			this.setLogmsg("<p style='color:red;'>"+e.getMessage()+"</p>");
		}
		this.setLogmsg("<p>获取商城页脚文章成功</p>");
		return Collections.emptyList();
		
	}
	
	/**
	 * 获取所有的商品品牌数据
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<BrandT>findAllBrandt(){
		try{
			List<BrandT>list=this.getBrandTService().findAllBrandt();
			if(!list.isEmpty()){
				return list;
			}
		}catch(Exception e){
			this.setLogmsg("<p style='color:red;'>"+e.getMessage()+"</p>");
		}
		this.setLogmsg("<p>获取商品品牌信息成功</p>");
		return Collections.emptyList();
	}
	
	
	
	
	
	/**
	 * 
	 * @param goodsTypeId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsTypeBrandT>findGoodsTypeBrandBygoodsType(String goodsTypeId){
		try{
			List<GoodsTypeBrandT>list=this.getGoodsTypeBrandTService().findBrandBygoodsTypeId(goodsTypeId);
			if(!list.isEmpty()){
				return list;
			}
		}catch(Exception e){
			this.setLogmsg("<p style='color:red;'>"+e.getMessage()+"</p>");
		}
		this.setLogmsg("<p>获取商品类型品牌列表成功</p>");
		return Collections.emptyList();
	}
	
	
	/**
	 * 根据商品类型来获取对应的属性列表
	 * @param goodsTypeId
	 * @return
	 */
	public List<GoodsAttributeT>findGoodsAttributeTBygoodsTypeId(String goodsTypeId){
		try{
			List<GoodsAttributeT>list=this.getGoodsAttributeTService().findGoodsAttributeTBygoodsTypeId(goodsTypeId);
			if(!list.isEmpty()){
				return list;
			}
		}catch(Exception e){
			this.setLogmsg("<p style='color:red;'>"+e.getMessage()+"</p>");
		}
		this.setLogmsg("<p>获取商品类型属性列表成功</p>");
		return Collections.emptyList();
	}


	/**
	 * 根据商品id获取商品评论
	 * @return
	 */
	public List<GoodsCommentT> findGoodsCommentBygoodsid(GoodsT gt){
		List<GoodsCommentT>list=this.getGoodsCommentTService().findGoodsCommentByGoodsid(gt.getGoodsid(), 1, 10);
		return list;
	}
	
	
	
}
