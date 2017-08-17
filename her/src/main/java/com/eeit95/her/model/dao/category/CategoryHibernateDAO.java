package com.eeit95.her.model.dao.category;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import com.eeit95.her.model.category.CategoryBean;
import com.eeit95.her.model.category.CategoryDAOInterface;
import com.eeit95.her.model.category.CategoryMainBean;
import com.eeit95.her.model.gift.GiftBean;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

import java.util.*;

@Repository
public class CategoryHibernateDAO implements CategoryDAOInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	private static final String delete = "delete from CategoryBean where id=?";
	private static final String selectByMainId = "from CategoryBean where mainId = ? order by id";
	private static final String selectAll = "from CategoryBean order by id";
	
	@Override
	public CategoryBean insert(CategoryBean bean) {
		Session session = this.getSession();
		if(bean != null){
			CategoryBean result = session.get(CategoryBean.class, bean.getId());
			if(result == null){
				session.save(bean);
			}
		}
		return null;
	}

	@Override
	public CategoryBean update(CategoryBean bean) {
		Session session = this.getSession();
		CategoryBean result = session.get(CategoryBean.class, bean.getId());
		if(result != null){
			result.setId(bean.getId());
			result.setMainId(bean.getMainId());
			result.setSubName(bean.getSubName());
		}
		return result;
	}

	@Override
	public boolean delete(int id) {
		Session session = this.getSession();
		CategoryBean bean = (CategoryBean) session.get(CategoryBean.class, id);;
			if(bean != null) {
				session.delete(bean);
				return true;
			}
		return false;
	}

	@Override
	public CategoryBean selectById(int id) {
		return this.getSession().get(CategoryBean.class, id);
	}

	@Override
	public List<CategoryBean> selectByMainId(CategoryMainBean mainId) {
		List<CategoryBean> result = null;
		Session session = this.getSession();
			Query query = session.createQuery(selectByMainId);
			query.setParameter(0, mainId);
			result = query.list();
		return result;
	}
	
	@Override
	public List<CategoryBean> selectAll() {
		List<CategoryBean> result = null;
		Session session = this.getSession();
		Query query = session.createQuery(selectAll);
		result = query.list();
		return result;
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");	
		CategoryHibernateDAO dao =(CategoryHibernateDAO) context.getBean("categoryHibernateDAO");

	try {
		sessionFactory.getCurrentSession().beginTransaction();		
				
		//● 新增-1 (0807-Spring測試OK)(不需要cascade="save-update" 或 cascade="all"的設定)(這是經常要用到的一般新增)
//		CategoryMainBean cmVO = new CategoryMainBean();
//		cmVO.setId(2); //如果輸入的值在category_main表格中尚未建立，就不能新增。
//		CategoryBean categoryVO = new CategoryBean(); // Category的POJO
//		categoryVO.setMainId(cmVO);
//		categoryVO.setSubName("10吋智慧型手機0807"); //名稱好像不能重複，否則會新增失敗。
//		dao.insert(categoryVO);
		
		//● 修改-2 (0807-Spring測試OK)(不需設定cascade="save-update" 或 cascade="all")(這是經常要用到的一般修改)
//		CategoryMainBean cmVO = new CategoryMainBean();
//		cmVO.setId(1); //如果輸入的值在category_main表格中尚未建立，就不能修改。				
//		CategoryBean categoryVO = new CategoryBean(); // Category的POJO
//		categoryVO.setId(7); // 【如果id不存在，則會修改失敗。因為Id是由系統流水號自動建立。】
//		categoryVO.setMainId(cmVO);;
//		categoryVO.setSubName("32吋電漿電視0807");
//		dao.update(categoryVO);	

		//●刪除-3 (0807-Spring測試OK)
//		dao.delete(7); //輸入Category的Id，此數值是由系統流水好自動建立。

		//● 查詢-4 selectById(0807-Spring測試OK)
//		CategoryBean categoryVO = dao.selectById(3);
//		for(GiftBean bean : categoryVO.getGifts()) { //可供查詢join Gift表格的資料
//			System.out.print(categoryVO.getId() + ",");
//			System.out.print(categoryVO.getMainId().getId() + ",");
//			System.out.print(categoryVO.getSubName()  + ",");
//			System.out.print(bean.getName()  + ",");
//			System.out.println(bean.getPrice());
//		}
//		System.out.println("\n-----------------");		

		//● 查詢-5 selectByMainId(0807-Spring測試OK)
//		CategoryMainBean cmVO = new CategoryMainBean();
//		cmVO.setId(1); //如果輸入的值在category_main表格中尚未建立，就無法查詢。
//		List<CategoryBean> list = dao.selectByMainId(cmVO);
//		for (CategoryBean catVO : list) {
//		System.out.print(catVO.getMainId().getId() + ",");
//		System.out.print(catVO.getId() + ",");
//		System.out.print(catVO.getSubName());
//		System.out.println();
//		}
		
		
		//● 查詢-6 selectAll(0807-Spring測試OK)
		List<CategoryBean> list = dao.selectAll();
		for (CategoryBean catVO : list) {
		System.out.print(catVO.getId() + ",");
		System.out.print(catVO.getMainId().getId() + ",");
		System.out.print(catVO.getSubName());
		System.out.println();
		}

		sessionFactory.getCurrentSession().getTransaction().commit();
	} catch (RuntimeException ex) {
		sessionFactory.getCurrentSession().getTransaction().rollback();
		throw ex;
	} finally {
		((ConfigurableApplicationContext) context).close();
	}

}
}