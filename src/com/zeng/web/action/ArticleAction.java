package com.zeng.web.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.utils.Page;
import com.zeng.entity.Article;
import com.zeng.entity.User_info;
import com.zeng.manager.ArticleManager;
import com.zeng.manager.UserManager;

@SuppressWarnings("serial")
public class ArticleAction extends ActionSupport implements ModelDriven<Article> {
	
	@Autowired
	private UserManager usermanager;
	
	@Autowired
	private ArticleManager articleManager;
	
	private Article article;
	//具体博文对象
	private Article art;
	private final int pageSize = 12;
	private List<Article> articles;
	private int pageNow = 1; // 初始化为1,默认从第一页开始显示
	private Page page;
	//显示所有博文
	public String listArticle() throws Exception{
		articles = articleManager.listByPage(pageNow, this.pageSize);
		page = new Page(pageNow, this.pageSize,articleManager.getAllcount("article"));
		if (page.getPageNow() > page.getTotalPage()) {
			page.setPageNow(page.getTotalPage());
		}
		return "listArticle";
	}
	//进入发表博文界面
	public String addArticle(){
		return "addArticle";
	}
	//发表博文提交
	public String add_succArticle() throws Exception{
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		User_info user_info = usermanager.getUserByUserName(userDetails.getUsername());
		article.setUser_info(user_info);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		Calendar ca = Calendar.getInstance();
		String date = df.format(ca.getTime());
		article.setDate(date);
		articleManager.addArticle(article);
		return "add_succArticle";
	}
	
	public String detailArticle () throws Exception{
		art = articleManager.getArticleById(article.getId());
		return "detailArticle";
	}
	
	
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	@Override
	public Article getModel() {
		article = new Article();
		return article;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
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
	public int getPageSize() {
		return pageSize;
	}
	public Article getArt() {
		return art;
	}
	public void setArt(Article art) {
		this.art = art;
	}
}
