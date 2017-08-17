package com.eeit95.her.model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardSelectBean;
import com.eeit95.her.model.dao.card.CardDAOhibernate;
import com.eeit95.her.model.dao.tag.TagDAOhibernate;
import com.eeit95.her.model.misc.SpringJavaConfiguration;
import com.eeit95.her.model.tag.TagBean;
import com.eeit95.her.model.tag.TagDAOInterface;
import com.eeit95.her.model.tag.TagSelectBean;
@Service
public class AdminTagService {
	@Autowired
	private TagDAOInterface tag;

	/* 在 controller 做好資料的檢查，確保傳入的參數無誤 */

	// insert 後，回傳新增成功包含 id 的 tagBean
	public boolean insert(TagBean tagBean) {
		boolean tagbean = tag.insert(tagBean);
		return tagbean;
	}

	// update 後，回傳修改成功的 tagBean
	public boolean update(TagBean tagBean) {
		boolean update = tag.update(tagBean);
		return update;
	}

	// delete 後，回傳是否刪除成功的 boolean
	public boolean delete(TagBean tagBean) {
		boolean delete = tag.delete(tagBean.getId());
		return delete;
	}

	// select
	// selectALl
	public List<TagBean> select(TagSelectBean tagSelectBean) {
		List<TagBean> result = null;
		if (tagSelectBean.getId() != 0&& tagSelectBean.getId() !=0 ) {
			result = tag.selectFM(tagSelectBean);
		} else {
			result = tag.selectFM(tagSelectBean);

		}

		return result;
	}
//
//	public static void main(String[] args) {
//
//		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//		//
//		TagDAOhibernate cdj = (TagDAOhibernate) context.getBean("tagDAOhibernate");
//		TagBean bean = new TagBean();
//		List<TagBean> list = null;
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
//			list = cdj.select(bean);
//			
//			// bean = cdj.selectById("c01706010001");
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} catch (RuntimeException ex) {
//			sessionFactory.getCurrentSession().getTransaction().rollback();
//		}
//		for (TagBean o : list) {
//			System.out.println(o.getId());
//		}
//	}

}
