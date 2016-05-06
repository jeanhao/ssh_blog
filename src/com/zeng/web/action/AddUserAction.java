package com.zeng.web.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zeng.entity.User_info;
import com.zeng.manager.UserManager;

@SuppressWarnings("serial")
public class AddUserAction extends ActionSupport	 implements ModelDriven<User_info>{
	@Autowired
	UserManager userManager;
	
	private User_info user_info;
	public String addUser() throws Exception {
		userManager.addUser(user_info);
		return "SUCCESS";
	}
	
	
	@Override
	public User_info getModel() {
		user_info = new User_info();
		return user_info;
	}
}
