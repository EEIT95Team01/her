package com.eeit95.her.model.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.eeit95.her.model.member.AdminUserBean;
import com.eeit95.her.model.member.AdminUserDAO_interface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Service
public class AdminUserService {
	@Autowired
	private AdminUserDAO_interface ADAOI;

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public AdminUserBean login(String username, String password) {
		AdminUserBean ab = ADAOI.findByUsername(username);
		if (ab != null) {
			if (password.trim().equals(ab.getPassword().trim())) {
				System.out.println("登入成功！");
				return ab;
			}
		}
		System.out.println("登入失敗！帳號密碼不符");
		return null;
	}

	public AdminUserBean insert(AdminUserBean ab) {
		
		System.out.println("ADAOI.insert(ab)"+ADAOI.insert(ab));
		return ADAOI.insert(ab);
	}

	public AdminUserBean update(AdminUserBean ab) {
		return ADAOI.update(ab);
	}
	
	public List<AdminUserBean> getAllAdminUser(){
		return ADAOI.getAll();
	}

	// 以下為測試程式===============================================
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");

		AdminUserService ms = (AdminUserService) context.getBean("memberService");
		// 登入
		try {
			sessionFactory.getCurrentSession().beginTransaction();

			ms.login("xxx@abc.com", "xxx");

			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (HibernateException e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}

		// try {
		// sessionFactory.getCurrentSession().beginTransaction();
		//
		// ms.changePassword("xxx@abc.com", "xxx", "ooo");
		//
		// sessionFactory.getCurrentSession().getTransaction().commit();
		// } catch (HibernateException e) {
		// sessionFactory.getCurrentSession().getTransaction().rollback();
		// e.printStackTrace();
		// }

		((ConfigurableApplicationContext) context).close();

	}
}
