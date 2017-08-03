package com.eeit95.her.model.dao.gift;

import org.hibernate.*;
import com.eeit95.her.model.gift.CategoryDAOInterface;
import com.eeit95.her.model.gift.CategoryMainBean;
import com.eeit95.her.model.gift.GiftBean;
import com.eeit95.her.model.gift.CategoryBean;
import hibernate.util.HibernateUtil;
import java.util.*;

public class CategoryHibernateDAO implements CategoryDAOInterface {

	private static final String delete = "delete from CategoryBean where id=?";
	private static final String selectByMainId = "from CategoryBean where mainId = ? order by id";
	private static final String selectAll = "from CategoryBean order by id";
	
	@Override
	public void insert(CategoryBean categoryVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(categoryVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(CategoryBean categoryVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(categoryVO);
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
		CategoryBean result = null;
		try {
			result = (CategoryBean) session.get(CategoryBean.class, id);
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
	public CategoryBean selectById(Integer id) {
		CategoryBean categoryVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			categoryVO = (CategoryBean) session.get(CategoryBean.class, id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return categoryVO;
	}

	@Override
	public List<CategoryBean> selectByMainId(CategoryMainBean mainId) {
		List<CategoryBean> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(selectByMainId);
			query.setParameter(0, mainId);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
	@Override
	public List<CategoryBean> selectAll() {
		List<CategoryBean> list = null;
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
		
		CategoryHibernateDAO dao = new CategoryHibernateDAO();
			
		//● 新增-1 (Git測試OK)(不需要cascade="save-update" 或 cascade="all"的設定)(這是經常要用到的一般新增)
//		CategoryMainBean cmVO = new CategoryMainBean();
//		cmVO.setId(2); //如果輸入的值在category_main表格中尚未建立，就不能新增。
//		CategoryBean categoryVO = new CategoryBean(); // Category的POJO
//		categoryVO.setMainId(cmVO);
//		categoryVO.setSubName("10吋智慧型手機"); //名稱好像不能重複，否則會新增失敗。
//		dao.insert(categoryVO);
		
		//● 修改-2 (Git測試OK)(不需設定cascade="save-update" 或 cascade="all")(這是經常要用到的一般修改)
//		CategoryMainBean cmVO = new CategoryMainBean();
//		cmVO.setId(1); //如果輸入的值在category_main表格中尚未建立，就不能修改。				
//		CategoryBean categoryVO = new CategoryBean(); // Category的POJO
//		categoryVO.setId(9); // 【如果id不存在，則會修改失敗。因為Id是由系統流水號自動建立。】
//		categoryVO.setMainId(cmVO);;
//		categoryVO.setSubName("32吋電漿電視");
//		dao.update(categoryVO);	

		//●刪除-3 (Git測試OK)
//		dao.delete(11); //輸入Category的Id，此數值是由系統流水好自動建立。

		//● 查詢-4 selectById(Git測試OK)
		CategoryBean categoryVO = dao.selectById(3);
		System.out.print(categoryVO.getId() + ",");
		System.out.print(categoryVO.getMainId().getId() + ",");
		System.out.print(categoryVO.getSubName());
		System.out.println("\n-----------------");		

		//● 查詢-5 getAll(Git測試OK)
//		CategoryMainBean cmVO = new CategoryMainBean();
//		cmVO.setId(1); //如果輸入的值在category_main表格中尚未建立，就無法查詢。
//		List<CategoryBean> list = dao.selectByMainId(cmVO);
//		for (CategoryBean catVO : list) {
//		System.out.print(catVO.getMainId().getId() + ",");
//		System.out.print(catVO.getId() + ",");
//		System.out.print(catVO.getSubName());
//		System.out.println();
//		}
		
		
		//● 查詢-6 getAll(Git測試OK)
//		List<CategoryBean> list = dao.selectAll();
//		for (CategoryBean catVO : list) {
//		System.out.print(catVO.getId() + ",");
//		System.out.print(catVO.getMainId().getId() + ",");
//		System.out.print(catVO.getSubName());
//		System.out.println();
//		}

	}
}