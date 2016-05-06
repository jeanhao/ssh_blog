package com.zeng.entity;

import java.util.Set;

public class User_info {

	private Integer id;
	private String answer;
	private String email;
	private String gender;
	private String name;
	private String password;
	private String question;
	private String userName;
	//对角色
	private Set<User_role> user_role;
	//对文章
	private Set<Article> article;
	//对评论
	private Set<Critique>critiques;
	public Set<Critique> getCritiques() {
		return critiques;
	}

	public void setCritiques(Set<Critique> critiques) {
		this.critiques = critiques;
	}

	public Set<Article> getArticle() {
		return article;
	}

	public void setArticle(Set<Article> article) {
		this.article = article;
	}

	public User_info() {
	}

	public User_info(String name, String password, String userName) {
		this.name = name;
		this.password = password;
		this.userName = userName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the user_role
	 */
	public Set<User_role> getUser_role() {
		return user_role;
	}

	/**
	 * @param user_role the user_role to set
	 */
	public void setUser_role(Set<User_role> user_role) {
		this.user_role = user_role;
	}

}