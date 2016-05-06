package com.zeng.entity;

import java.util.Date;
import java.util.Set;

public class Article {
	private int id;
	private String title;
	private String content;
	private Integer userid;
	private String date;
	private User_info user_info;
	private Set<Critique> Critique;
public Set<Critique> getCritique() {
		return Critique;
	}
	public void setCritique(Set<Critique> critique) {
		Critique = critique;
	}
	//	private int hasread;
//	
//	public int getHasread() {
//		return hasread;
//	}
//	public void setHasread(int hasread) {
//		this.hasread = hasread;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public User_info getUser_info() {
		return user_info;
	}
	public void setUser_info(User_info user_info) {
		this.user_info = user_info;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
}
