package com.zeng.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.opensymphony.xwork2.ActionSupport;
import com.utils.Page;
import com.zeng.entity.User_info;
import com.zeng.manager.UserManager;

public class UserSearchAction extends ActionSupport {
	@Autowired
	private UserManager userManager;
	// �����û���Ϣ��ʾÿҳ�û���
	private final int pageSize = 5;

	private List<User_info> user;
	private User_info u;
	private int pageNow = 1; // ��ʼ��Ϊ1,Ĭ�ϴӵ�һҳ��ʼ��ʾ
	private int sortInverse = 1;
	private String orderType = "id";
	private Page page;
	private String keywords;
	private String informationType;
	private String SearchType;
	private String errorMsg;

	public String userSearch() throws Exception {
		// idֻΪ��ȷ����
		if (informationType.equals("id") || informationType.equals("gender")) {
			u = userManager.findUserByAccurateInformation(keywords,
					informationType);
			if (null == u) {
				errorMsg = "û������û�!";
			}
			return "UserSearchAccurate";
		} else if (SearchType.equals("vague")) {
			user = userManager.findUserByVagueInformation(pageNow,
					this.pageSize, keywords, informationType);
			List<User_info> listtemp = userManager.findUserByVagueInformation(
					1, userManager.getAllcount("user"), keywords,
					informationType);
			if (listtemp == null) {
				page = new Page(pageNow, this.pageSize, 0);
			} else {
				page = new Page(pageNow, this.pageSize, listtemp.size());
			}
			if (page.getPageNow() > page.getTotalPage()) {
				page.setPageNow(page.getTotalPage());
			}
			if (null == user) {
				errorMsg = "�����������������û���";
			}
			return "UserSearchVague";
		} else {
			u = userManager.findUserByAccurateInformation(keywords,
					informationType);
			if (null == u) {
				errorMsg = "û������û���";
			}
			return "UserSearchAccurate";
		}
	}

	// �򵥲�ѯ
	// @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_BOSS')")
	// �û��������Ʒ�ģ���;�ȷ����

	public List<User_info> getUser() {
		return user;
	}

	public void setUser(List<User_info> user) {
		this.user = user;
	}

	public User_info getU() {
		return u;
	}

	public void setU(User_info u) {
		this.u = u;
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

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getInformationType() {
		return informationType;
	}

	public void setInformationType(String informationType) {
		this.informationType = informationType;
	}

	public String getSearchType() {
		return SearchType;
	}

	public void setSearchType(String searchType) {
		SearchType = searchType;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
