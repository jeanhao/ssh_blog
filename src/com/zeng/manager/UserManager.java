package com.zeng.manager;

import java.util.List;

import com.zeng.entity.Log_info;
import com.zeng.entity.User_info;

public interface UserManager {
	
	public void addUser(User_info user);
	
	public void delUser(String id);
	
	public boolean updateUser(User_info user);
	//验证登陆
	public User_info loginCheck(User_info user);
	//获得所有用户数量
	public int getAllcount(String type) ;

	public List<User_info> listByPage(int pageNow, int pageSize, String orderType,int sortInverse);

	public User_info getUserByUserName(String userName);

	List<User_info> findUserByVagueInformation(int pageNow, int pageSize,
			Object value, String informationType);

	User_info findUserByAccurateInformation(String value, String informationType);

	List<User_info> advancedSearch(int pageNow, int pageSize, User_info user);

	public void addLog_info(Log_info log_info);

	List<Log_info> log_listByPage(int pageNow, int pageSize, String orderType,
			int sortInverse);

	User_info getUser_info(String id);
}
