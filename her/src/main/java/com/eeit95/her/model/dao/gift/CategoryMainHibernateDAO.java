package com.eeit95.her.model.dao.gift;

import org.hibernate.*;
import com.eeit95.her.model.gift.CategoryMainDAOInterface;
import com.eeit95.her.model.gift.GiftBean;
import com.eeit95.her.model.gift.CategoryBean;
import com.eeit95.her.model.gift.CategoryMainBean;
import hibernate.util.HibernateUtil;
import java.util.*;

public class CategoryMainHibernateDAO implements CategoryMainDAOInterface{

	private static final String selectAll = "from CategoryMainBean order by id";
	private static final String delete = "delete from CategoryMainBean where id=?";
	
	
	@Override
	public void insert(CategoryMainBean categoryMainVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(categoryMainVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(CategoryMainBean categoryMainVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(categoryMainVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public boolean delete(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		CategoryMainBean result = null;
		try {
			result = (CategoryMainBean) session.get(CategoryMainBean.class, id);
			if(result != null) {
				Query query = session.createQuery(delete);
				query.setParameter(0, id);
				System.out.println("刪除筆數： " + query.executeUpdate());
				session.getTransaction().commit();
				return true;
			}
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return false;
	}

	@Override
	public CategoryMainBean selectById(Integer id) {
		CategoryMainBean categoryMainVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			categoryMainVO = (CategoryMainBean) session.get(CategoryMainBean.class, id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return categoryMainVO;
	}

	@Override
	public List<CategoryMainBean> selectAll() {
		List<CategoryMainBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(selectAll);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
	public static void main(String[] args) {
		
		CategoryMainHibernateDAO dao = new CategoryMainHibernateDAO();
	
		//● 新增-1 (Git測試OK)(不需要cascade="save-update" 或 cascade="all"的設定)(這是經常要用到的一般新增)
//		CategoryMainBean categoryMainVO = new CategoryMainBean(); // CategoryMain的POJO
//		categoryMainVO.setName("大型家電");
//		dao.insert(categoryMainVO);
		
		//● 修改-2 (Git測試OK)(不需設定cascade="save-update" 或 cascade="all")(這是經常要用到的一般修改)
//		CategoryMainBean categoryMainVO = new CategoryMainBean(); // CategoryMain的POJO
//		categoryMainVO.setId(5); // 【如果id不存在則會修改失敗】
//		categoryMainVO.setName("3C家電");
//		dao.update(categoryMainVO);	

		//●刪除-3 (Git測試OK)
//		dao.delete(6); //輸入id

//		● 查詢-selectById(Git測試OK)
//		CategoryMainBean categoryMainBean = dao.selectById(2);
//		System.out.println("Id: " + categoryMainBean.getId() + " ");
//		System.out.println("Name: " + categoryMainBean.getName() + " ");
//		System.out.println("----以下為分類商品別----");
//		for(CategoryBean bean :categoryMainBean.getCategorys()) { //可供查詢join Category表格的資料
//			System.out.println("CategoryId: " + bean.getId() + " ");
//			System.out.println("CategoryName: " + bean.getSubName() + " ");
//			System.out.println("-----------------");
//		}
	

		//● 查詢-selectAll(Git測試OK)
		List<CategoryMainBean> list = dao.selectAll();
		for (CategoryMainBean cmVO : list) {
		System.out.print(cmVO.getId() + ",");
		System.out.print(cmVO.getName() + ",");
		System.out.println();
		}
	}
}