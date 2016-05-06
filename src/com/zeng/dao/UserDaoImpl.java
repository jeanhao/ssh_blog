package com.zeng.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zeng.entity.Log_info;
import com.zeng.entity.User_info;
import com.zeng.entity.User_role;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	// 通过用户名查找用户
	@SuppressWarnings("unchecked")
	@Override
	public User_info getUserByUserName(String userName) {
		String hql = "from User_info u where u.userName=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		List<User_info> u = query.list();
		if (u.size() > 0) {
			return u.get(0);
		} else
			return null;
	}

	// 获得所有用户数量
	@Override
	public int getAllcount(String type) {
		String hql = null;
		if (type.equals("user")) {
			hql = "select count(*) from User_info";

		} else if (type.equals("log")) {
			hql = "select count(*) from Log_info";
		}
		Long count = (Long) sessionFactory.getCurrentSession().createQuery(hql)
				.uniqueResult();
		if (count > 0) {
			return count.intValue();
		} else {
			return 0;
		}
	}

	// 分页加载日志列表
	@Override
	public List<Log_info> log_listByPage(int pageNow, int pageSize,
			String orderType, int sortInverse) {
		// 这种占位符方式不知道为什么不行
		// String hql = "from User_info order by ? ASC ";
		String hql = "";
		if (orderType.equals("id")) {
			if (sortInverse % 2 == 1) {
				hql = "from Log_info order by id ASC ";
			} else {
				hql = "from Log_info order by id DESC ";
			}
		} else if (orderType.equals("userName")) {
			if (sortInverse % 2 == 1) {
				hql = "from Log_info order by userName ASC ";
			} else {
				hql = "from Log_info order by userName DESC ";
			}
		} else if (orderType.equals("operDesc")) {
			if (sortInverse % 2 == 1) {
				hql = "from Log_info order by operDesc ASC ";
			} else {
				hql = "from Log_info order by operDesc DESC ";
			}
		} else if (orderType.equals("operStatus")) {
			if (sortInverse % 2 == 1) {
				hql = "from Log_info u order by operStatus ASC ";
			} else {
				hql = "from Log_info order by operStatus DESC ";
			}
		} else if (orderType.equals("operPara")) {
			if (sortInverse % 2 == 1) {
				hql = "from Log_info order by operPara ASC ";
			} else {
				hql = "from Log_info order by operPara DESC ";
			}
		} else if (orderType.equals("operTime")) {
			if (sortInverse % 2 == 1) {
				hql = "from Log_info order by operTime ASC ";
			} else {
				hql = "from Log_info order by operTime DESC ";
			}
		} else if (orderType.equals("operaIP")) {
			if (sortInverse % 2 == 1) {
				hql = "from Log_info order by operaIP ASC ";
			} else {
				hql = "from Log_info order by operaIP DESC ";
			}
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		// query.setString(0, orderType);
		query.setFirstResult((pageNow - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	// 分页加载用户列表
	@Override
	public List<User_info> listByPage(int pageNow, int pageSize,
			String orderType, int sortInverse) {
		// 这种占位符方式不知道为什么不行
		// String hql = "from User_info order by ? ASC ";
		String hql = "";
		if (orderType.equals("id")) {
			if (sortInverse % 2 == 1) {
				hql = "from User_info order by id ASC ";
			} else {
				hql = "from User_info order by id DESC ";
			}
		} else if (orderType.equals("name")) {
			if (sortInverse % 2 == 1) {
				hql = "from User_info order by name ASC ";
			} else {
				hql = "from User_info order by name DESC ";
			}
		} else if (orderType.equals("userName")) {
			if (sortInverse % 2 == 1) {
				hql = "from User_info order by userName ASC ";
			} else {
				hql = "from User_info order by userName DESC ";
			}
		} else if (orderType.equals("password")) {
			if (sortInverse % 2 == 1) {
				hql = "from User_info u order by password ASC ";
			} else {
				hql = "from User_info order by password DESC ";
			}
		} else if (orderType.equals("gender")) {
			if (sortInverse % 2 == 1) {
				hql = "from User_info order by gender ASC ";
			} else {
				hql = "from User_info order by gender DESC ";
			}
		} else if (orderType.equals("email")) {
			if (sortInverse % 2 == 1) {
				hql = "from User_info order by email ASC ";
			} else {
				hql = "from User_info order by email DESC ";
			}
		} else if (orderType.equals("question")) {
			if (sortInverse % 2 == 1) {
				hql = "from User_info order by question ASC ";
			} else {
				hql = "from User_info order by question DESC ";
			}
		} else if (orderType.equals("answer")) {
			if (sortInverse % 2 == 1) {
				hql = "from User_info order by answer ASC ";
			} else {
				hql = "from User_info order by answer DESC ";
			}
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		// query.setString(0, orderType);
		query.setFirstResult((pageNow - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	// 通过id查找用户
	@Override
	public User_info getUser_info(String id) {

		String hql = "from User_info u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		User_info user_info = (User_info) query.uniqueResult();
		return user_info;
	}

	// 添加用户个人信息
	@Override
	public void addUser_info(User_info user_info) {
		sessionFactory.getCurrentSession().save(user_info);
	}

	// 添加用户权限信息
	@Override
	public void addUser_role(User_role user_role) {
		sessionFactory.getCurrentSession().save(user_role);
	}

	// 添加日志信息
	@Override
	public void addLog_info(Log_info log_info) {
		sessionFactory.getCurrentSession().save(log_info);
	}

	// 删除用户
	@Override
	public void delUser_info(String id) {
		String hql = "delete from User_role u where u.userid = ?";
		sessionFactory.getCurrentSession().createQuery(hql).setString(0, id)
				.executeUpdate();
		hql = "delete from User_info u where u.id = ?";
		sessionFactory.getCurrentSession().createQuery(hql).setString(0, id)
				.executeUpdate();

	}

	// 修改用户
	@Override
	public boolean updateUser_info(User_info user) {

		String hql = "update User_info u set u.userName = ? , u.password = ?, u.name = ?, u.email = ?, u.gender = ?, u.question = ?, u.answer = ? where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getUserName());
		query.setString(1, user.getPassword());
		query.setString(2, user.getName());
		query.setString(3, user.getEmail());
		query.setString(4, user.getGender());
		query.setString(5, user.getQuestion());
		query.setString(6, user.getAnswer());
		query.setInteger(7, user.getId());
		return (query.executeUpdate() > 0);
	}

	@Override
	// 高级检索
	public List<User_info> advancedSearch(int pageNow, int pageSize,
			User_info user) {
		String hql = " from User_info u where u.name like ? AND u.userName like ? AND u.gender like ? AND u.email like ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, "%" + user.getName() + "%");
		query.setString(1, "%" + user.getUserName() + "%");
		query.setString(2, "%" + user.getGender() + "%");
		query.setString(3, "%" + user.getEmail() + "%");
		query.setFirstResult((pageNow - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<User_info> list = query.list();
		return list;
	}

	// 按姓名模糊查找
	@Override
	public List<User_info> findUserByVagueInformation(int pageNow,
			int pageSize, Object value, String informationType) {
		String hql = "";
		if (informationType.equals("name")) {
			hql = " from User_info where name like ? ";
		} else if (informationType.equals("userName")) {
			hql = "from User_info where userName like ? ";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, "%" + value + "%");
		query.setFirstResult((pageNow - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	// 按姓名精确查找
	@Override
	public User_info findUserByAccurateInformation(String value,
			String informationType) {
		String hql = "";
		if (informationType.equals("name")) {
			hql = " from User_info where name = ?";
		} else if (informationType.equals("userName")) {
			hql = " from User_info where userName = ?";
		} else if (informationType.equals("gender")) {
			hql = " from User_info where gender = ? ";
		} else if (informationType.equals("id")) {
			hql = " from User_info where id = ?";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, value);
		List<User_info> u = query.list();
		if (u.size() > 0) {
			return u.get(0);
		} else
			return null;
	}

}
