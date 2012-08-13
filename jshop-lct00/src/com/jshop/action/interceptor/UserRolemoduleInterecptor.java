package com.jshop.action.interceptor;

import java.util.Iterator;
import java.util.List;



import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.jshop.action.tools.BaseTools;
import com.jshop.entity.FunctionM;
import com.jshop.entity.RoleFunctionM;
import com.jshop.service.FunctionMService;
import com.jshop.service.RoleFunctionMService;
import com.jshop.service.UserRoleMService;
import com.opensymphony.xwork2.ActionContext;
@ParentPackage("jshop")

@Controller("userRolemoduleInterecptor")
public class UserRolemoduleInterecptor {
	private FunctionMService functionMService;
	private UserRoleMService userRoleMService;
	private RoleFunctionMService roleFunctionMService;
	public FunctionMService getFunctionMService() {
		return functionMService;
	}
	public void setFunctionMService(FunctionMService functionMService) {
		this.functionMService = functionMService;
	}
	public UserRoleMService getUserRoleMService() {
		return userRoleMService;
	}
	public void setUserRoleMService(UserRoleMService userRoleMService) {
		this.userRoleMService = userRoleMService;
	}
	
	public RoleFunctionMService getRoleFunctionMService() {
		return roleFunctionMService;
	}
	public void setRoleFunctionMService(RoleFunctionMService roleFunctionMService) {
		this.roleFunctionMService = roleFunctionMService;
	}

	
	
	
	
}
