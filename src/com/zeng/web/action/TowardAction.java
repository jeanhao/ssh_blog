package com.zeng.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class TowardAction  extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String main(){
		return "main";
	}
	
	public String chat(){
		return "chat";
	}
	public String contact(){
		return "contact";
	}
}
