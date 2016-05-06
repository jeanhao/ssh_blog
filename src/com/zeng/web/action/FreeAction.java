package com.zeng.web.action;

import com.opensymphony.xwork2.ActionSupport;


public class FreeAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	public String register() throws Exception{
		return "register";
	}

	public String login() throws Exception{
		return "login";
	}
	public String sessionTimeout() throws Exception{
		return "sessionTimeout";
	}
	public String accessDenied() throws Exception{
		return "accessDenied";
	}
	
}
