package com.jshop.action.interceptor;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.jshop.action.tools.GlobalParam;
import com.jshop.entity.GlobalParamM;
import com.jshop.service.GlobalParamService;
import com.jshop.service.impl.GlobalParamServiceImpl;
@ParentPackage("jshop")

@Controller("authorityInterceptor")
public class AuthorityInterceptor {
	private GlobalParamService globalParamService;

	public GlobalParamService getGlobalParamService() {
		return globalParamService;
	}

	public void setGlobalParamService(GlobalParamService globalParamService) {
		this.globalParamService = globalParamService;
	}

	/**
	 * 拦截检测是否允许注册
	 * @return
	 */
	public boolean IsusercanregisterIntercept(){
		List<GlobalParamM>list=this.getGlobalParamService().findAllGlobalParam();
		if(list!=null){
			for(Iterator it=list.iterator();it.hasNext();){
				GlobalParamM gm=(GlobalParamM)it.next();
				if(gm.getGkey().equals(GlobalParam.ISUSERCANREGISTER)){
					if(gm.getGvalue().equals("1")){
						return true;
					}else{
						return false;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * 检测是否允许用户注册多个商城
	 * @return
	 */
	public boolean canuserregistermoreshopinfoIntercept(){
		List<GlobalParamM>list=this.getGlobalParamService().findAllGlobalParam();
		if(list!=null){
			for(Iterator it=list.iterator();it.hasNext();){
				GlobalParamM gm=(GlobalParamM)it.next();
				if(gm.getGkey().equals(GlobalParam.CANUSERREGISTERMORESHOPINFO)){
					if(gm.getGvalue().equals("1")){
						return true;
					}else{
						return false;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * 检测是否允许发送激活邮件
	 * @return
	 */
	public boolean issendactivatemail(){
		List<GlobalParamM>list=this.getGlobalParamService().findAllGlobalParam();
		if(list!=null){
			for(Iterator it=list.iterator();it.hasNext();){
				GlobalParamM gm=(GlobalParamM)it.next();
				if(gm.getGkey().equals(GlobalParam.ISSENDACTIVATEMAIL)){
					if(gm.getGvalue().equals("1")){
						return true;
					}else{
						return false;
					}
				}
			}
		}
		return false;
	}
	
}
