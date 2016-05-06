package com.zeng.web.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zeng.entity.User_info;
import com.zeng.manager.UserManager;

@SuppressWarnings("serial")
public class UpdateUserAction extends ActionSupport implements ModelDriven<User_info>{
	@Autowired
	UserManager userManager;

	private String id;
	private User_info user;
	
	//进入修改用户信息界面
	public String updateUser() throws Exception {
		user = userManager.getUser_info(String.valueOf(user.getId()));
		ActionContext.getContext().getValueStack().push(user);
		return "ToUpdateUser";
	}
	
	public String updateOp() throws Exception {
		if (userManager.updateUser(user)){
			System.out.println("********************"+user.getEmail()+"*****************");
		return "update_succ";
		}else{
			return "update_fail";
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User_info getUser() {
		return user;
	}

	public void setUser(User_info user) {
		this.user = user;
	}

	@Override
	public User_info getModel() {
		user = new User_info();
		return user;
	}
}
