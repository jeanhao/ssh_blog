package com.zeng.web.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.zeng.manager.UserManager;

@SuppressWarnings("serial")
public class DeleteAction extends ActionSupport {
	@Autowired
	private UserManager userManager;
	
	private String id;
	public String deleteUser() throws Exception {
		userManager.delUser(id);
		return "deleteUser";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
