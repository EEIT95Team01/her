package com.eeit95.her.model.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eeit95.her.model.category.CategoryMainBean;
import com.eeit95.her.model.category.CategoryMainDAOInterface;


@Service
public class CategoryMainService {

	@Autowired
	private CategoryMainDAOInterface categoryMainDAOInterface;
	
	
	public CategoryMainBean insert(CategoryMainBean bean) {
		return categoryMainDAOInterface.insert(bean);
	}
	
	public CategoryMainBean update(CategoryMainBean bean) {
		return categoryMainDAOInterface.update(bean);
	}
	
	public boolean delete(int id) {
		return categoryMainDAOInterface.delete(id);
	}
	
	public CategoryMainBean selectById(int id) {
		return categoryMainDAOInterface.selectById(id);
	}
	
	public List<CategoryMainBean> selectAll(){
		return categoryMainDAOInterface.selectAll();
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
		//● 新增-1 (0808-SpringService測試OK)(不需要cascade="save-update" 或 cascade="all"的設定)(這是經常要用到的一般新增)
//		CategoryMainBean bean = new CategoryMainBean(); // CategoryMain的POJO
//		bean.setName("運動用品0808");
//		try {
//			dao.insert(bean);
//			System.out.println("新增成功");
//		} catch (Exception e) {
//			System.out.println("新增失敗");
//		}
		
		//● 修改-2 (0808-SpringService測試OK)(不需設定cascade="save-update" 或 cascade="all")(這是經常要用到的一般修改)
//		CategoryMainBean bean = new CategoryMainBean(); // CategoryMain的POJO
//		bean.setId(5); // 【如果id不存在則會修改失敗】
//		bean.setName("五金用具0808");
//		try {
//			dao.update(bean);
//			System.out.println("修改成功");
//		} catch (Exception e) {
//			System.out.println("修改失敗，請檢查Id是否正確(有無存在於資料庫)");
//		}	

		//●刪除-3 (0808-SpringService測試OK) //輸入id
//			if(dao.delete(6) == true){
//				System.out.println("刪除成功");
//			}else {
//				System.out.println("刪除失敗，請檢查Id是否正確(有無存在於資料庫)");
//			}

//		● 查詢-4 selectById(0808-SpringService測試OK)
//		CategoryMainBean cmbean = dao.selectById(2);
//		System.out.println("Id: " + cmbean.getId() + " ");
//		System.out.println("Name: " + cmbean.getName() + " ");
//		System.out.println("----以下為分類商品別----");
//		for(CategoryBean cbean :cmbean.getCategorys()) { //可供查詢join Category表格的資料
//			System.out.println("CategoryId: " + cbean.getId() + " ");
//			System.out.println("CategoryName: " + cbean.getSubName() + " ");
//			System.out.println("-----------------");
//		}
//	

		//● 查詢-selectAll(0808-SpringService測試OK)
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

//	}
}