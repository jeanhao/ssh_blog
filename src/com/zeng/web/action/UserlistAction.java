package com.zeng.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.utils.Page;
import com.zeng.entity.User_info;
import com.zeng.manager.UserManager;

@SuppressWarnings("serial")
public class UserlistAction extends ActionSupport {

	@Autowired
	private UserManager userManager;
	// �����û���Ϣ��ʾÿҳ�û���
	private final int pageSize = 5;
	private List<User_info> user;
	private int pageNow = 1; // ��ʼ��Ϊ1,Ĭ�ϴӵ�һҳ��ʼ��ʾ
	private int sortInverse = 1;
	private String orderType = "id";
	private Page page;

	// ��ҳ��ѯչʾ�û���Ϣ
	// @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_BOSS')")
	public String userlist() throws Exception {
		user = userManager.listByPage(pageNow, this.pageSize, orderType,
				sortInverse);
		page = new Page(pageNow, this.pageSize,
				userManager.getAllcount("user"));
		if (page.getPageNow() > page.getTotalPage()) {
			page.setPageNow(page.getTotalPage());
		}
		return "userlist";
	}

	public List<User_info> getUser() {
		return user;
	}

	public void setUser(List<User_info> user_info) {
		this.user = user_info;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getSortInverse() {
		return sortInverse;
	}

	public void setSortInverse(int sortInverse) {
		this.sortInverse = sortInverse;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
