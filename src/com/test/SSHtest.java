package com.test;


import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.zeng.entity.User_info;

public class SSHtest {
	
	@Test
	public void testssh(){
		JSONObject jo=new JSONObject();
		jo.put("name","nad");
		jo.put("remark", "sadd");
		System.out.println(jo.toString());
/*		ApplicationContext ac = new FileSystemXmlApplicationContext("/src/applicationContext.xml");//ClassPathXmlApplicationContext("spring-applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		User_info user_info = new User_info("zenghao","zenghao","123");
		Transaction tx = session.beginTransaction();
		session.save(user_info);
		tx.commit();*/
	}
}
