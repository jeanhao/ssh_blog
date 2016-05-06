package com.zeng.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.utils.Page;
import com.zeng.entity.Log_info;
import com.zeng.manager.UserManager;

@SuppressWarnings("serial")
public class LoglistAction extends ActionSupport {

	@Autowired
	private UserManager userManager;
	// �����û���Ϣ��ʾÿҳ�û���
	private final int pageSize = 5;
	private List<Log_info> log;
	private int pageNow = 1; // ��ʼ��Ϊ1,Ĭ�ϴӵ�һҳ��ʼ��ʾ
	private int sortInverse = 1;
	private String orderType = "id";
	private Page page;

	// ��ҳ��ѯչʾ�û���Ϣ
	// @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_BOSS')")
	public String loglist() throws Exception {
		setLog(userManager.log_listByPage(pageNow, this.pageSize, orderType,
				sortInverse));
		page = new Page(pageNow, this.pageSize,
				userManager.getAllcount("log"));
		if (page.getPageNow() > page.getTotalPage()) {
			page.setPageNow(page.getTotalPage());
		}
		return "loglist";
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

	public List<Log_info> getLog() {
		return log;
	}

	public void setLog(List<Log_info> log) {
		this.log = log;
	}

	/**
	 * @return the page
	 */
	public Page getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(Page page) {
		this.page = page;
	}

}
