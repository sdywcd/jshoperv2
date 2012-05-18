package com.jshop.action.androidserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.Validate;
import com.jshop.entity.GoodsT;
import com.jshop.service.GoodsTService;
import com.jshop.service.impl.GoodsTServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("jshop")

@Controller("androidGoodsTAction")
public class AndroidGoodsTAction extends ActionSupport implements
ServletRequestAware, ServletResponseAware {
	private GoodsTService goodsTService;
	private HttpServletRequest request;
    private HttpServletResponse response;
	private List<GoodsT>beanlist=new ArrayList<GoodsT>();
	private String creatorid;
	private String goodsid;
	private int rp;
	private int page=1;
	private int total=0;
	private String jsonstr;
    private boolean sucflag;
    @JSON(serialize = false)
	public GoodsTService getGoodsTService() {
		return goodsTService;
	}
	public void setGoodsTService(GoodsTService goodsTService) {
		this.goodsTService = goodsTService;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	
	
	
	
	public List<GoodsT> getBeanlist() {
		return beanlist;
	}
	public void setBeanlist(List<GoodsT> beanlist) {
		this.beanlist = beanlist;
	}
	public String getCreatorid() {
		return creatorid;
	}
	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}
	public int getRp() {
		return rp;
	}
	public void setRp(int rp) {
		this.rp = rp;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getJsonstr() {
		return jsonstr;
	}
	public void setJsonstr(String jsonstr) {
		this.jsonstr = jsonstr;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages(); 
	
	}
	
	/**
	 * 查询商品给手机客户端
	 * @throws IOException 
	 */
	@Action(value="findAllGoodsByismobileplatformgoodsforAndroid")
	public void findAllGoodsByismobileplatformgoodsforAndroid() throws IOException{
		if(Validate.StrNotNull(BaseTools.adminCreateId())){
			int currentPage=page;
			int lineSize=12;
			beanlist=this.getGoodsTService().findAllGoodsByismobileplatformgoods(currentPage, lineSize, BaseTools.adminCreateId());
			if(beanlist!=null){
				String url="http://192.168.1.105/Uploads/";
				String temp=null;
				String []temparray=null;
				StringBuilder json=new StringBuilder();
				for(Iterator it=beanlist.iterator();it.hasNext();){
					GoodsT gt=(GoodsT)it.next();
					temparray=gt.getPictureurl().split(",");
					temp=temparray[0];
					gt.setPictureurl(url+temp);
					json.append("{");
					json.append("\"goodsid\":\"").append(gt.getGoodsid()).append("\",");
					json.append("\"pictureurl\":\"").append(gt.getPictureurl()).append("\",");
					json.append("\"goodsname\":\"").append(gt.getGoodsname()).append("\",");
					json.append("\"memberprice\":\"").append(gt.getMemberprice()).append("\"");
					json.append("}").append("-");
				}
				json.deleteCharAt(json.length()-1);
				this.setJsonstr(json.toString());
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				PrintWriter out=response.getWriter();
				out.write(this.getJsonstr());
				out.flush();
				out.close();
			}
			
		}
		
	}
	
	
	/**
	 * 根据商品id查询商品详细给手机客户端
	 * @throws IOException 
	 */
	@Action(value="findGoodsByGoodsidforAndroid")
	public void findGoodsByGoodsidforAndroid() throws IOException{
		if(Validate.StrNotNull(this.getGoodsid())){
			GoodsT gt=new GoodsT();
			gt=this.getGoodsTService().findGoodsById(this.getGoodsid());
			if(gt!=null){
				String url="http://192.168.1.105/Uploads/";
				String temp=null;
				String []temparray=null;
				temparray=gt.getPictureurl().split(",");
				temp=temparray[0];
				gt.setPictureurl(url+temp);
				StringBuilder json=new StringBuilder();
				json.append("{");
				json.append("\"goodsname\":\"").append(gt.getGoodsname()).append("\",");
				json.append("\"brandname\":\"").append(gt.getBrandname()).append("\",");
				json.append("\"nname\":\"").append(gt.getNname()).append("\",");
				json.append("\"lname\":\"").append(gt.getLname()).append("\",");
				json.append("\"sname\":\"").append(gt.getSname()).append("\",");
				json.append("\"fname\":\"").append(gt.getFname()).append("\",");
				json.append("\"price\":\"").append(gt.getPrice()).append("\",");
				json.append("\"memberprice\":\"").append(gt.getMemberprice()).append("\",");
				json.append("\"points\":\"").append(gt.getPoints()).append("\",");
				json.append("\"quantity\":\"").append(gt.getQuantity()).append("\",");
				
				json.append("\"detail\":\"").append(gt.getDetail().replace('"', '\'')).append("\",");
				
				json.append("\"unitname\":\"").append(gt.getUnitname()).append("\",");
				json.append("\"keywordname\":\"").append(gt.getKeywordname()).append("\",");
				json.append("\"weight\":\"").append(gt.getWeight()).append("\",");
				json.append("\"readcount\":\"").append(gt.getReadcount()).append("\",");
				json.append("\"relatedproductid\":\"").append(gt.getRelatedproductid()).append("\",");
				json.append("\"recommended\":\"").append(gt.getRecommended()).append("\",");
				json.append("\"hotsale\":\"").append(gt.getHotsale()).append("\",");
				json.append("\"bargainprice\":\"").append(gt.getBargainprice()).append("\",");
				json.append("\"replycount\":\"").append(gt.getReplycount()).append("\",");
				json.append("\"saleprice\":\"").append(gt.getSaleprice()).append("\",");
				json.append("\"isNew\":\"").append(gt.getIsNew()).append("\",");
				json.append("\"productSn\":\"").append(gt.getProductSn()).append("\",");
				json.append("\"goodsTypeName\":\"").append(gt.getGoodsTypeName()).append("\",");
				json.append("\"usersetnum\":\"").append(gt.getUsersetnum()).append("\",");
				json.append("\"star\":\"").append(gt.getStar()).append("\",");
				json.append("\"staruser\":\"").append(gt.getStaruser()).append("\",");
				json.append("\"totalcomment\":\"").append(gt.getTotalcomment()).append("\",");
				json.append("\"goodsid\":\"").append(gt.getGoodsid()).append("\",");
				json.append("\"pictureurl\":\"").append(gt.getPictureurl()).append("\"");
				json.append("}");
				//json.deleteCharAt(json.length());
				this.setJsonstr(json.toString());
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				PrintWriter out=response.getWriter();
				out.write(this.getJsonstr());
				out.flush();
				out.close();
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
