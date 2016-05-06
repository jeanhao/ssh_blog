package com.zeng.entity;

public class Critique {
	private Integer id;
	private Integer article_id;
	private Integer observer_id;
	private String criticInfo;
	private String critic_date;
	private Article article;
	private User_info user_info;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public Integer getObserver_id() {
		return observer_id;
	}
	public void setObserver_id(Integer observer_id) {
		this.observer_id = observer_id;
	}

	public String getCritic_date() {
		return critic_date;
	}
	public void setCritic_date(String critic_date) {
		this.critic_date = critic_date;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public User_info getUser_info() {
		return user_info;
	}
	public void setUser_info(User_info user_info) {
		this.user_info = user_info;
	}
	public String getCriticInfo() {
		return criticInfo;
	}
	public void setCriticInfo(String criticInfo) {
		this.criticInfo = criticInfo;
	}

}
