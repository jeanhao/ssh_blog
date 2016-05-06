package com.zeng.entity;

public class User_role {
	private Integer id;
	private String role;
	private Integer userid;
	private User_info user_info;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * @return the user_info
	 */
	public User_info getUser_info() {
		return user_info;
	}
	/**
	 * @param user_info the user_info to set
	 */
	public void setUser_info(User_info user_info) {
		this.user_info = user_info;
	}

}
