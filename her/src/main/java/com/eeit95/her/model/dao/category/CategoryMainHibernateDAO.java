package com.eeit95.her.model.dao.category;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.eeit95.her.model.category.CategoryBean;
import com.eeit95.her.model.category.CategoryMainBean;
import com.eeit95.her.model.category.CategoryMainDAOInterface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;
import java.util.*;

@Repository
public class CategoryMainHibernateDAO implements CategoryMainDAOInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	private static final String selectAll = "from CategoryMainBean order by id";
	private static final String delete = "delete from CategoryMainBean where id=?";
	
	
	@Override
	public CategoryMainBean insert(CategoryMainBean bean) {
		Session session = this.getSession();
		if(bean != null){
			CategoryMainBean result = session.get(CategoryMainBean.class, bean.getId());
			if(result == null){
				session.save(bean);
			}
		}
		return null;
	}

	@Override
	public CategoryMainBean update (CategoryMainBean bean) {
		Session session = this.getSession();
		CategoryMainBean result = session.get(CategoryMainBean.class, bean.getId());
		if(result != null){
			result.setName(bean.getName());
		}
		return result;
	}

	@Override
	public boolean delete(int id) {
		Session session = this.getSession();
		CategoryMainBean result = (CategoryMainBean) session.get(CategoryMainBean.class, id);
			if(result != null) {
				session.delete(result);
				return true;
			}
		return false;
	}

	@Override
	public CategoryMainBean selectById(int id) {
		return this.getSession().get(CategoryMainBean.class,id);
	}

	@Override
	public List<CategoryMainBean> selectAll() {
		List<CategoryMainBean> result = null;
		Session session = this.getSession();
		Query query = session.createQuery(selectAll);
		result = query.list();
		return result;
	}
	
//	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//		CategoryMainHibernateDAO dao = 
//				(CategoryMainHibernateDAO) context.getBean("categoryMainHibernateDAO");
//
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();		
//		
		//● 新增-1 (0807-Spring測試OK)(不需要cascade="save-update" 或 cascade="all"的設定)(這是經常要用到的一般新增)
//		CategoryMainBean bean = new CategoryMainBean(); // CategoryMain的POJO
//		bean.setName("運動用品0805");
//		try {
//			dao.insert(bean);
//			System.out.println("新增成功");
//		} catch (Exception e) {
//			System.out.println("新增失敗");
//		}
		
		//● 修改-2 (0807-Spring測試OK)(不需設定cascade="save-update" 或 cascade="all")(這是經常要用到的一般修改)
//		CategoryMainBean bean = new CategoryMainBean(); // CategoryMain的POJO
//		bean.setId(4); // 【如果id不存在則會修改失敗】
//		bean.setName("五金用具0807");
//		try {
//			dao.update(bean);
//			System.out.println("修改成功");
//		} catch (Exception e) {
//			System.out.println("修改失敗，請檢查Id是否正確(有無存在於資料庫)");
//		}	

		//●刪除-3 (0807-Spring測試OK) //輸入id
//			if(dao.delete(4) == true){
//				System.out.println("刪除成功");
//			}else {
//				System.out.println("刪除失敗，請檢查Id是否正確(有無存在於資料庫)");
//			}

//		● 查詢-4 selectById(0807-Spring測試OK)
//		CategoryMainBean cmbean = dao.selectById(2);
//		System.out.println("Id: " + cmbean.getId() + " ");
//		System.out.println("Name: " + cmbean.getName() + " ");
//		System.out.println("----以下為分類商品別----");
//		for(CategoryBean cbean :cmbean.getCategorys()) { //可供查詢join Category表格的資料
//			System.out.println("CategoryId: " + cbean.getId() + " ");
//			System.out.println("CategoryName: " + cbean.getSubName() + " ");
//			System.out.println("-----------------");
//		}
	

		//● 查詢-selectAll(0807-Spring測試OK)
//		List<CategoryMainBean> beans = dao.selectAll();
//		for (CategoryMainBean bean : beans) {
//		System.out.println();
//		System.out.print(bean.getId() + ",");
//		System.out.println(bean.getName() + ",");
//		System.out.println("-----------------");
//			for(CategoryBean cbean : bean.getCategorys()) { //可供查詢join Category表格的資料
//				System.out.println("CategoryId: " + cbean.getId() + " ");
//				System.out.println("CategoryName: " + cbean.getSubName() + " ");
//			}
//		}
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} catch (RuntimeException ex) {
//			sessionFactory.getCurrentSession().getTransaction().rollback();
//			throw ex;
//		} finally {
//			((ConfigurableApplicationContext) context).close();
//		}
//
//	}
}