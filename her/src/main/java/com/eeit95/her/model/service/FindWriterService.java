package com.eeit95.her.model.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.eeit95.her.model.dao.font.FontDAOHibernate;
import com.eeit95.her.model.dao.font.WriterDAOHibernate;
import com.eeit95.her.model.font.FontDAOInterface;
import com.eeit95.her.model.font.WriterBean;
import com.eeit95.her.model.font.WriterDAOInterface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Service
public class FindWriterService {

//	ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
//	SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	@Autowired
	WriterDAOInterface writerDAO;
//	= (WriterDAOHibernate) context.getBean("writerDAOHibernate");
	
	public List<WriterBean> selectAll(){
		
		List<WriterBean> result = writerDAO.selectAll();
		return result;
		
	}
	
	
	
	public static void main(String[] args) {
		

	}

}
