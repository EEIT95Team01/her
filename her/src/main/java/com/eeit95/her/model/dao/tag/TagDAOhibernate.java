package com.eeit95.her.model.tag.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.tag.TagBean;

import hibernate.util.HibernateUtil;


public class TagDAOhibernate implements TagDAOinterface {

	
	private static final String selectAll = "from TagBean";
	private static final String Delete = "delete from TagBean where id = ?";

	public static void main(String[] args) {
		TagDAOhibernate tdj = new TagDAOhibernate();
		System.out.println("SELECT 一筆資料 & PRINT");
		TagBean bean= tdj.selectById(1);
		System.out.println(bean);
		
		System.out.println("===================================================");
		// INSERT 一筆資料 & PRINT
		bean.setId(0);
		bean =tdj.insert(bean);
		System.out.println("INSERT 一筆資料 & PRINT");
		System.out.println(bean.getId());
//		
		System.out.println("===================================================");
//		
		// UPDATE 一筆資料 & PRINT
		bean.setId(13);
		bean.setName("史奴比");
		tdj.update(bean);
		System.out.println("UPDATE 一筆資料 & PRINT");
		System.out.println(bean.getId()+","+bean.getName()+bean.getDiscount());
		
		
//		System.out.println("===================================================");
//		
//		// DELETE 一筆資料 & PRINT
//		System.out.println("DELETE 一筆資料 & PRINT");
//		System.out.println(tdj.delete(7));
		System.out.println(tdj.delete(11));
		System.out.println(tdj.delete(12));
		
		System.out.println("===================================================");
//		
		// SELECT 所有資料 & PRINT
		List<TagBean> result=tdj.selectAll();
		System.out.println("SELECT 所有資料 & PRINT");
		for(TagBean bean1:result) {
			System.out.println(bean1.getId()+"\t"+bean1.getName()+"\t"+bean1.getDiscount());
		}
		
		
		
	}
	@Override
	public TagBean selectById(int id) {
		TagBean tagBean = null;
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			tagBean = (TagBean) session.get(TagBean.class,id);
			session.getTransaction().commit();
		}catch(RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return tagBean;
	}

	@Override
	public TagBean insert(TagBean bean) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(bean);
			session.getTransaction().commit();
			if(bean!=null) {
			return bean;
			}
		}catch(RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return null;
	}

	@Override
	public TagBean update(TagBean bean) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(bean);
			session.getTransaction().commit();
			if(bean!=null) {
			return bean;
			}
		}catch(RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		TagBean tagBean= null;
		try {
			tagBean = (TagBean) session.get(TagBean.class,id);
			if(tagBean!=null) {
				Query query=session.createQuery(Delete);
				query.setParameter(0, id);
				System.out.println("刪除筆數 :"+query.executeUpdate());
				session.getTransaction().commit();
				return true;
			}
		}catch(RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
		return false;
	}

	@Override
	public List<TagBean> selectAll() {
		List<TagBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query= session.createQuery(selectAll);
			list = query.list();
			session.getTransaction().commit();
		}catch(RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
		return list;

	}

	

}
