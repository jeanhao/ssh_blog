package com.zeng.web.action;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.utils.Page;
import com.zeng.entity.User_info;
import com.zeng.manager.UserManager;

@SuppressWarnings("serial")
public class AdvancedUserSearchAction extends ActionSupport{
	@Autowired
	private UserManager userManager;
	
	// 设置用户信息显示每页用户数
	private final int pageSize = 5;

	private List<User_info> user;
	private int pageNow = 1; // 初始化为1,默认从第一页开始显示
	private Page page;
	private String errorMsg;
	//搜索属性
	private String userName;
	private String  name;
	private String email;
	private String gender;
	
	public String advancedUserSearch( ) throws Exception {
		User_info u_forSear = new User_info();
		u_forSear.setEmail(email);
		u_forSear.setUserName(userName);
		u_forSear.setName(name);
		u_forSear.setGender(gender);
		user = userManager.advancedSearch(pageNow,
				this.pageSize, u_forSear);
		List<User_info> listtemp = userManager.advancedSearch(1, this.pageSize,
				u_forSear);
		if (listtemp == null) {
			page = new Page(pageNow, this.pageSize, 0);
		} else {
			page = new Page(pageNow, this.pageSize, listtemp.size());
		}
		if (page.getPageNow() > page.getTotalPage()) {
			page.setPageNow(page.getTotalPage());
		}
		if (user == null) {
			errorMsg =  "不存在满足条件的用户！";
		}
		return "AdvancedUserSearch";
	}
//	//高级查询
//		@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_BOSS')") 

	public List<User_info> getUser() {
		return user;
	}

	public void setUser(List<User_info> user) {
		this.user = user;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPageSize() {
		return pageSize;
	}

}
