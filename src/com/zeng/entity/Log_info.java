package com.zeng.entity;

public class Log_info {
	private Integer id;
	private String operDesc;
	private String operPara;
	private String operStatus;
	private String operTime;
	private String operaIP;
	private String userName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOperDesc() {
		return operDesc;
	}
	public void setOperDesc(String operDesc) {
		this.operDesc = operDesc;
	}
	public String getOperPara() {
		return operPara;
	}
	public void setOperPara(String operPara) {
		this.operPara = operPara;
	}
	public String getOperStatus() {
		return operStatus;
	}
	public void setOperStatus(String operStatus) {
		this.operStatus = operStatus;
	}
	public String getOperTime() {
		return operTime;
	}
	public void setOperTime(String operTime) {
		this.operTime = operTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the operaIP
	 */
	public String getOperaIP() {
		return operaIP;
	}
	/**
	 * @param operaIP the operaIP to set
	 */
	public void setOperaIP(String operaIP) {
		this.operaIP = operaIP;
	}

}
