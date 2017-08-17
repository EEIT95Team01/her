package com.eeit95.her.model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.eeit95.her.model.dao.font.FontDAOHibernate;
import com.eeit95.her.model.dao.tag.TagDAOhibernate;
import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.font.FontDAOInterface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Service
public class FontService {

//	ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
//	SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	@Autowired
	private FontDAOInterface fontDAO;
	
	public FontService() {
		
	}
	
//	public FontService(FontDAOInterface fontDAO) {
//		this.fontDAO=fontDAO;
//	}
	
//	= new FontDAOHibernate();
//	= (FontDAOHibernate) context.getBean("fontDAOHibernate");

//	 @Autowired
//	 private FontDAOInterface fontDAO ;

	public List<FontBean> selectOrderBy(String option) {

//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
			List<FontBean> result = null;
			switch (option) {
			case "ID_ASC":
				result = fontDAO.selectAllStatus(true);
				break;
			case "SALES_DESC":
				result = fontDAO.selectAllOrderBySales();
				break;
			case "PRICE_ASC":
				result = fontDAO.selectAllOrderByPrice("asc");
				break;
			case "PRICE_DESC":
				result = fontDAO.selectAllOrderByPrice("desc");
				break;
			}

//			sessionFactory.getCurrentSession().getTransaction().commit();
			return result;
//		} catch (RuntimeException ex) {
//			sessionFactory.getCurrentSession().getTransaction().rollback();
//			throw ex;
//		}
	}

	public static void main(String[] args) {
//		FontService test = new FontService();
//		// FontBean bean = new FontBean();
//
//		// List<FontBean> list = dao.selectWithBetween("viewCount", 10,1000);
//		// List<FontBean> list = dao.selectTopN(2, "price" , "desc");
//		List<FontBean> list = test.selectOrderBy("PRICE_DESC");
//		for (FontBean bean : list) {
//			System.out.print(bean.getId() + ",");
//			System.out.print(bean.getName() + ",");
//			System.out.print(bean.getPrice() + ",");
//			System.out.print(bean.getCover() + ",");
//			System.out.print(bean.getViewCount() + ",");
//			System.out.print(bean.getSalesCount() + ",");
//			System.out.print(bean.getStatus() + ",");
//			System.out.print(bean.getWriterBean().getId() + ",");
//			System.out.print(bean.getWriterBean().getName() + ",");
//			System.out.print(bean.getWriterBean().getCover() + ",");
//			System.out.print(bean.getWriterBean().getDescription());
//			System.out.println();
//		}

	}
}
