package com.zeng.web.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zeng.entity.Critique;
import com.zeng.entity.User_info;
import com.zeng.manager.ArticleManager;
import com.zeng.manager.UserManager;

@SuppressWarnings("serial")
public class CritiqueAction extends ActionSupport implements ModelDriven<Critique>{
	
	@Autowired
	private ArticleManager articleManager;
	@Autowired
	private UserManager userManager;
	
	private String userName;
	private Critique critique;
	private String result;
	//∑¢±Ì∆¿¬€
	public String addCritique() throws Exception{
		System.out.println("\n\n"+userName+critique.getCriticInfo());
		critique.setCriticInfo(java.net.URLDecoder.decode(critique.getCriticInfo(),"utf-8"));
		critique.setArticle(articleManager.getArticleById(critique.getArticle_id()));
		User_info user_info = userManager.getUserByUserName(userName);
		critique.setObserver_id(user_info.getId());
		critique.setUser_info(userManager.getUser_info(String.valueOf(critique.getObserver_id())));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar ca = Calendar.getInstance();
		String date = df.format(ca.getTime());
		critique.setCritic_date(date);
		articleManager.addCritique(critique);
		result = "true";
		return "addCritique";
	}
	@Override
	public Critique getModel() {
		critique = new Critique();
		return critique;
	}
	public Critique getCritique() {
		return critique;
	}
	public void setCritique(Critique critique) {
		this.critique = critique;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	
}
