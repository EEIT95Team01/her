package com.eeit95.her.model.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.eeit95.her.model.category.CategoryBean;
import com.eeit95.her.model.category.CategoryDAOInterface;
import com.eeit95.her.model.category.CategoryMainBean;
import com.eeit95.her.model.dao.category.CategoryHibernateDAO;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDAOInterface categoryDAOInterface;
	
//	ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
//	SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//	CategoryHibernateDAO dao =(CategoryHibernateDAO) context.getBean("categoryHibernateDAO");

	
	//● 新增-1 insert
	public CategoryBean insert(CategoryBean bean) {
		return categoryDAOInterface.insert(bean);
	}
	
	//● 修改-2 update
	public CategoryBean update(CategoryBean bean) {
		return categoryDAOInterface.update(bean);
	}

	//●刪除-3 delete
	public boolean delete(int id) {
		return categoryDAOInterface.delete(id);
	}
	
	//● 查詢-4 selectById
	public CategoryBean selectById(int id) {
		return categoryDAOInterface.selectById(id);
	}
	
	//● 查詢-5 selectByMainId
	public List<CategoryBean> selectByMainId(CategoryMainBean mainId) {
		return categoryDAOInterface.selectByMainId(mainId);
	}
	
	//● 查詢-6 selectAll
	public List<CategoryBean> selectAll() {
		return categoryDAOInterface.selectAll();
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");	
		CategoryHibernateDAO dao =(CategoryHibernateDAO) context.getBean("categoryHibernateDAO");

	try {
		sessionFactory.getCurrentSession().beginTransaction();		
				
		//● 新增-1 (0808-SpringService測試OK)(不需要cascade="save-update" 或 cascade="all"的設定)(這是經常要用到的一般新增)
//		CategoryMainBean cmVO = new CategoryMainBean();
//		cmVO.setId(2); //如果輸入的值在category_main表格中尚未建立，就不能新增。
//		CategoryBean categoryVO = new CategoryBean(); // Category的POJO
//		categoryVO.setMainId(cmVO);
//		categoryVO.setSubName("10吋智慧型手機0807"); //名稱好像不能重複，否則會新增失敗。
//		dao.insert(categoryVO);
		
		//● 修改-2 (0808-SpringService測試OK)(不需設定cascade="save-update" 或 cascade="all")(這是經常要用到的一般修改)
//		CategoryMainBean cmVO = new CategoryMainBean();
//		cmVO.setId(8); //如果輸入的值在category_main表格中尚未建立，就不能修改。				
//		CategoryBean categoryVO = new CategoryBean(); // Category的POJO
//		categoryVO.setId(7); // 【如果id不存在，則會修改失敗。因為Id是由系統流水號自動建立。】
//		categoryVO.setMainId(cmVO);;
//		categoryVO.setSubName("32吋電漿電視0807");
//		dao.update(categoryVO);	

		//●刪除-3 (0808-SpringService測試OK)
//		dao.delete(8); //輸入Category的Id，此數值是由系統流水好自動建立。

		//● 查詢-4 selectById(0808-SpringService測試OK)
//		CategoryBean categoryVO = dao.selectById(3);
//		for(GiftBean bean : categoryVO.getGifts()) { //可供查詢join Gift表格的資料
//			System.out.print(categoryVO.getId() + ",");
//			System.out.print(categoryVO.getMainId().getId() + ",");
//			System.out.print(categoryVO.getSubName()  + ",");
//			System.out.print(bean.getName()  + ",");
//			System.out.println(bean.getPrice());
//		}
//		System.out.println("\n-----------------");		

		//● 查詢-5 selectByMainId(0808-SpringService測試OK)
		CategoryMainBean cmVO = new CategoryMainBean();
		cmVO.setId(1); //如果輸入的值在category_main表格中尚未建立，就無法查詢。
		List<CategoryBean> list = dao.selectByMainId(cmVO);
		for (CategoryBean catVO : list) {
		System.out.print(catVO.getMainId().getId() + ",");
		System.out.print(catVO.getId() + ",");
		System.out.print(catVO.getSubName());
		System.out.println();
		}
		
		
		//● 查詢-6 selectAll(0808-SpringService測試OK)
//		List<CategoryBean> list = dao.selectAll();
//		for (CategoryBean catVO : list) {
//		System.out.print(catVO.getId() + ",");
//		System.out.print(catVO.getMainId().getId() + ",");
//		System.out.print(catVO.getSubName());
//		System.out.println();
//		}

		sessionFactory.getCurrentSession().getTransaction().commit();
	} catch (RuntimeException ex) {
		sessionFactory.getCurrentSession().getTransaction().rollback();
		throw ex;
	} finally {
		((ConfigurableApplicationContext) context).close();
	}

}
}