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

import com.eeit95.her.model.member.MemberBean;
import com.eeit95.her.model.member.MemberDAO_interface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Service
public class MemberService {
	@Autowired
	private MemberDAO_interface MDAOI;

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public MemberBean login(String email, String password) {
		String id = MDAOI.findIdFromEmail(email.trim());

		MemberBean mb = MDAOI.findByPrimaryKey(id);
		if (mb != null) {
			if (password != null && password.length() != 0) {
				if (password.equals(mb.getPassword())) {
					System.out.println("登入成功");
					return mb;
				}
			}
		}
		System.out.println("登入失敗！帳號密碼不符");
		return null;
	}

	public boolean changePassword(String email, String oldPassword, String newPassword) {
		MemberBean mb = this.login(email, oldPassword);
		if (mb != null) {
			mb.setPassword(newPassword);
			MDAOI.update(mb);
			System.out.println("更新密碼成功");
			return true;
		}
		System.out.println("更新密碼失敗");
		return false;
	}
	
	public MemberBean insert(String id,String email, String password){
		return MDAOI.insert(id, email, password);
	}
	
	public MemberBean insert(MemberBean memberBean){
		memberBean.setId(MDAOI.getNewId());
		System.out.println("newId = "+MDAOI.getNewId());
		return MDAOI.insert(memberBean);
	}
	
	public MemberBean update(MemberBean bean){
		return MDAOI.update(bean);
	}
	
	public MemberBean findByMemberId(String memberId){
		return MDAOI.findByPrimaryKey(memberId);
	}
	
	public List<MemberBean> getAllMember(){
		return MDAOI.getAll();
	}
	
	public MemberBean findByEmail(String email){
		String id =MDAOI.findIdFromEmail(email.trim());
		return MDAOI.findByPrimaryKey(id);
	}
	

	// 以下為測試程式===============================================
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");

		MemberService ms = (MemberService) context.getBean("memberService");
		// 登入
		 try {
		 sessionFactory.getCurrentSession().beginTransaction();
		
		 ms.login("xxx@abc.com", "xxx");
		
		 sessionFactory.getCurrentSession().getTransaction().commit();
		 } catch (HibernateException e) {
		 sessionFactory.getCurrentSession().getTransaction().rollback();
		 e.printStackTrace();
		 }

//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
//
//			ms.changePassword("xxx@abc.com", "xxx", "ooo");
//
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} catch (HibernateException e) {
//			sessionFactory.getCurrentSession().getTransaction().rollback();
//			e.printStackTrace();
//		}

		((ConfigurableApplicationContext) context).close();

	}
}
