package com.zeng.aop;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.Spring;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.utils.TcpIP;
import com.zeng.dao.UserDao;
import com.zeng.entity.Log_info;
import com.zeng.entity.User_info;
import com.zeng.manager.UserManager;
import com.zeng.manager.UserManagerImpl;

@Component
@Aspect
public class AopIntercept {

	@Autowired
	private UserManager userManager;

	@SuppressWarnings("unused")
	@Pointcut("execution(* com.zeng.manager.UserManagerImpl.*(..))")
	private void anyMethod() {
	}// 定义一个切入点

	//注册日志记录
//	@After("execution(* com.zeng.manager.UserManagerImpl.addUser(..)) && args(user)")
//	public void add_succ(User_info user) {
//		HttpServletRequest request = ServletActionContext.getRequest();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss ");
//		Calendar ca = Calendar.getInstance();
//		String operDate = df.format(ca.getTime());
//		String ip = TcpIP.getIpAddr(request);
//		Log_info log_info = new Log_info()   ; 
//		log_info.setOperDesc("注册用户");
//		log_info.setOperStatus("注册成功");
//		log_info.setUserName(user.getName());
//		log_info.setOperTime(operDate);
//		log_info.setOperaIP(ip);
//		log_info.setOperPara("用户名:"+user.getUserName());
//		userManager.addLog_info(log_info);
//	}
	//登陆日志记录
//	@After("execution(* com.zeng.web.action.TowardAction.main())")
//	public void Main(){
//		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
//			    .getAuthentication()
//			    .getPrincipal();
//		HttpServletRequest request = ServletActionContext.getRequest();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss ");
//		Calendar ca = Calendar.getInstance();
//		String operDate = df.format(ca.getTime());
//		String ip = TcpIP.getIpAddr(request);
//		Log_info log_info = new Log_info()   ; 
//		log_info.setOperDesc("进入主页");
//		log_info.setOperStatus("进入成功");
//		log_info.setOperTime(operDate);
//		log_info.setOperaIP(ip);
//		log_info.setUserName(userDetails.getUsername());
//		log_info.setOperPara("用户名:"+userDetails.getUsername());
//		userManager.addLog_info(log_info);
//	}
	//进入后台日志记录
	@After("execution(* com.zeng.web.action.UserlistAction.userlist(..))")
	public void tolist(){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		HttpServletRequest request = ServletActionContext.getRequest();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss ");
		Calendar ca = Calendar.getInstance();
		String operDate = df.format(ca.getTime());
		String ip = TcpIP.getIpAddr(request);
		Log_info log_info = new Log_info()   ; 
		log_info.setOperDesc("进入后台管理界面");
		log_info.setOperStatus("进入成功");
		log_info.setUserName(userDetails.getUsername());
		log_info.setOperTime(operDate);
		log_info.setOperaIP(ip);
		log_info.setOperPara("用户名:"+userDetails.getUsername());
		userManager.addLog_info(log_info);
	}
	//进入日志查看界面日志记录
//		@After("execution(* com.zeng.web.UserController.log_info(..))")
		public void tolog_info(){
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
				    .getAuthentication()
				    .getPrincipal();
			HttpServletRequest request = ServletActionContext.getRequest();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss ");
			Calendar ca = Calendar.getInstance();
			String operDate = df.format(ca.getTime());
			String ip = TcpIP.getIpAddr(request);
			Log_info log_info = new Log_info()   ; 
			log_info.setOperDesc("进入日志记录查看界面");
			log_info.setOperStatus("进入成功");
			log_info.setUserName(userDetails.getUsername());
			log_info.setOperTime(operDate);
			log_info.setOperaIP(ip);
			log_info.setOperPara("用户名:"+userDetails.getUsername());
			userManager.addLog_info(log_info);
		}
		//权限不足
	//	@After("execution(* com.zeng.web.UserController.accessDeniedView(..))")
		public void toaccessDeniedView(){
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
				    .getAuthentication()
				    .getPrincipal();
			HttpServletRequest request = ServletActionContext.getRequest();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss ");
			Calendar ca = Calendar.getInstance();
			String operDate = df.format(ca.getTime());
			String ip = TcpIP.getIpAddr(request);
			Log_info log_info = new Log_info()   ; 
			log_info.setOperDesc("权限不足");
			log_info.setOperStatus("操作失败");
			log_info.setUserName(userDetails.getUsername());
			log_info.setOperTime(operDate);
			log_info.setOperaIP(ip);
			log_info.setOperPara("用户名:"+userDetails.getUsername());
			userManager.addLog_info(log_info);
		}
		//删除用户日志记录
//		@After("execution(* com.zeng.web.UserController.delete(..)) && args(id)")
		public void delete( String id ){
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
				    .getAuthentication()
				    .getPrincipal();
			HttpServletRequest request = ServletActionContext.getRequest();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss ");
			Calendar ca = Calendar.getInstance();
			String operDate = df.format(ca.getTime());
			String ip = TcpIP.getIpAddr(request);
			Log_info log_info = new Log_info()   ; 
			log_info.setOperDesc("删除用户");
			log_info.setOperStatus("删除成功");
			log_info.setUserName("操作用户:"+userDetails.getUsername());
			log_info.setOperTime(operDate);
			log_info.setOperaIP(ip);
			log_info.setOperPara("删除ID:"+id);
			userManager.addLog_info(log_info);
		}
		//修改用户日志记录
//		@After("execution(* com.zeng.web.UserController.update(..)) && args(user_info)")
		public void update( User_info user_info ){
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
				    .getAuthentication()
				    .getPrincipal();
			HttpServletRequest request = ServletActionContext.getRequest();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss ");
			Calendar ca = Calendar.getInstance();
			String operDate = df.format(ca.getTime());
			String ip = TcpIP.getIpAddr(request);
			Log_info log_info = new Log_info()   ; 
			log_info.setOperDesc("修改用户信息");
			log_info.setOperStatus("修改成功");
			log_info.setUserName("操作用户:"+userDetails.getUsername());
			log_info.setOperTime(operDate);
			log_info.setOperaIP(ip);
			log_info.setOperPara("修改用户的ID:"+user_info.getId());
			userManager.addLog_info(log_info);
		}
		
}
