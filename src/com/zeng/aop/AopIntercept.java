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
	}// ����һ�������

	//ע����־��¼
//	@After("execution(* com.zeng.manager.UserManagerImpl.addUser(..)) && args(user)")
//	public void add_succ(User_info user) {
//		HttpServletRequest request = ServletActionContext.getRequest();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss ");
//		Calendar ca = Calendar.getInstance();
//		String operDate = df.format(ca.getTime());
//		String ip = TcpIP.getIpAddr(request);
//		Log_info log_info = new Log_info()   ; 
//		log_info.setOperDesc("ע���û�");
//		log_info.setOperStatus("ע��ɹ�");
//		log_info.setUserName(user.getName());
//		log_info.setOperTime(operDate);
//		log_info.setOperaIP(ip);
//		log_info.setOperPara("�û���:"+user.getUserName());
//		userManager.addLog_info(log_info);
//	}
	//��½��־��¼
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
//		log_info.setOperDesc("������ҳ");
//		log_info.setOperStatus("����ɹ�");
//		log_info.setOperTime(operDate);
//		log_info.setOperaIP(ip);
//		log_info.setUserName(userDetails.getUsername());
//		log_info.setOperPara("�û���:"+userDetails.getUsername());
//		userManager.addLog_info(log_info);
//	}
	//�����̨��־��¼
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
		log_info.setOperDesc("�����̨�������");
		log_info.setOperStatus("����ɹ�");
		log_info.setUserName(userDetails.getUsername());
		log_info.setOperTime(operDate);
		log_info.setOperaIP(ip);
		log_info.setOperPara("�û���:"+userDetails.getUsername());
		userManager.addLog_info(log_info);
	}
	//������־�鿴������־��¼
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
			log_info.setOperDesc("������־��¼�鿴����");
			log_info.setOperStatus("����ɹ�");
			log_info.setUserName(userDetails.getUsername());
			log_info.setOperTime(operDate);
			log_info.setOperaIP(ip);
			log_info.setOperPara("�û���:"+userDetails.getUsername());
			userManager.addLog_info(log_info);
		}
		//Ȩ�޲���
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
			log_info.setOperDesc("Ȩ�޲���");
			log_info.setOperStatus("����ʧ��");
			log_info.setUserName(userDetails.getUsername());
			log_info.setOperTime(operDate);
			log_info.setOperaIP(ip);
			log_info.setOperPara("�û���:"+userDetails.getUsername());
			userManager.addLog_info(log_info);
		}
		//ɾ���û���־��¼
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
			log_info.setOperDesc("ɾ���û�");
			log_info.setOperStatus("ɾ���ɹ�");
			log_info.setUserName("�����û�:"+userDetails.getUsername());
			log_info.setOperTime(operDate);
			log_info.setOperaIP(ip);
			log_info.setOperPara("ɾ��ID:"+id);
			userManager.addLog_info(log_info);
		}
		//�޸��û���־��¼
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
			log_info.setOperDesc("�޸��û���Ϣ");
			log_info.setOperStatus("�޸ĳɹ�");
			log_info.setUserName("�����û�:"+userDetails.getUsername());
			log_info.setOperTime(operDate);
			log_info.setOperaIP(ip);
			log_info.setOperPara("�޸��û���ID:"+user_info.getId());
			userManager.addLog_info(log_info);
		}
		
}
