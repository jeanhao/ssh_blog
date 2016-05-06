package com.zeng.dao;

import java.util.List;

import com.zeng.entity.Log_info;
import com.zeng.entity.User_info;
import com.zeng.entity.User_role;

public interface UserDao {

	public User_info getUser_info(String id);

	public void addUser_info(User_info user);
	
	public void delUser_info(String  id);
	
	public boolean updateUser_info(User_info user);
	//ͨ���û��������û�
	public User_info getUserByUserName(String userName);
	//��������û���
	public int getAllcount(String type);
	//��ҳ��ʾ
	public List<User_info> listByPage(int pageNow, int pageSize, String orderType,
			int sortInverse);

	User_info findUserByAccurateInformation(String value, String informationType);

	List<User_info> findUserByVagueInformation(int pageNow, int pageSize,
			Object value, String informationType);

	public List<User_info> advancedSearch(int pageNow, int pageSize, User_info user);

	void addUser_role(User_role user_role);


	void addLog_info(Log_info log_info);

	List<Log_info> log_listByPage(int pageNow, int pageSize, String orderType,
			int sortInverse);

}
