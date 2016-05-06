package com.zeng.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeng.dao.UserDao;
import com.zeng.entity.Log_info;
import com.zeng.entity.User_info;
import com.zeng.entity.User_role;
//@Service
//@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED,timeout=2)
public class UserManagerImpl implements UserManager {
	
	@Autowired
	private UserDao userDao;


	// 验证登陆
	@Override
	public User_info loginCheck(User_info user) {
		User_info u = userDao.getUserByUserName(user.getUserName());
		if (u != null && u.getPassword().equals(user.getPassword())) {
			return u;
		} else {
			return null;
		}
	}
	// 日志信息分页显示
	@Override
	public List<Log_info> log_listByPage(int pageNow, int pageSize, String orderType,
			int sortInverse) {
		List<Log_info> list = userDao.log_listByPage(pageNow, pageSize, orderType,
				sortInverse);
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
	// 用户分页显示
	@Override
	public List<User_info> listByPage(int pageNow, int pageSize, String orderType,
			int sortInverse) {
		List<User_info> list = userDao.listByPage(pageNow, pageSize, orderType,
				sortInverse);
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
	//根据id查找用户
	@Override
	public User_info getUser_info(String id){
		return userDao.getUser_info(id);
	}

	// 获得所有用户数量
	@Override
	public int getAllcount(String type) {
		return userDao.getAllcount(type);
	}
	//通过用户名查找用户
	@Override
	public User_info getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}
	//添加用户操作日志信息
	public void addLog_info(Log_info log_info){
		userDao.addLog_info(log_info);
	}
	//增加用户
	@Override
	public void addUser(User_info user) {
//		MD5 md5 = new MD5();
//		user.setPassword(md5.getMD5ofStr(user.getPassword()));
		User_role user_role = new User_role();
		//用户权限，账户表关联
		user_role.setRole("ROLE_USER");
		user_role.setUser_info(user);
		
		//用户信息，账户表关联
//		Set<User_role> rolelist = new HashSet<User_role>();
//		rolelist.add(user_role);
//		user.setUser_role(rolelist);
	//	user.getUser_role().add(user_role);
		//System.out.println("****************"+user.getUser_role()l+"******************");
		
		userDao.addUser_info(user);
		userDao.addUser_role(user_role);
	}
	//删除用户
	@Override
	public void delUser(String id) {
		userDao.delUser_info(id);
	}
	//修改用户
	@Override
	public boolean updateUser(User_info user) {
		return userDao.updateUser_info(user);
	}
	//模糊查找
	@Override
	public List<User_info> findUserByVagueInformation(int pageNow, int pageSize, Object value, String informationType) {
		List<User_info> list = userDao.findUserByVagueInformation(pageNow, pageSize, value, informationType);
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
	//精确查找
	@Override
	public User_info findUserByAccurateInformation(String value, String informationType) {
		return userDao.findUserByAccurateInformation(value, informationType);
	}
	//高级查找
	@Override
	public List<User_info> advancedSearch(int pageNow, int pageSize , User_info user) {
		List<User_info> list = userDao.advancedSearch(pageNow, pageSize, user);
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

}
