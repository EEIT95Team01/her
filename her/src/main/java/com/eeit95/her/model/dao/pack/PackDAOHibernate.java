package com.eeit95.her.model.dao.pack;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.eeit95.her.model.pack.PackBean;
import com.eeit95.her.model.pack.PackDAOInterface;

import hibernate.util.HibernateUtil;

public class PackDAOHibernate implements PackDAOInterface {

	// 待測試 selectByMIdAndStatus() 方法
	
	@Override
	public List<PackBean> selectByMIdAndStatus(String memberId, int status) {
		String SELECT_BY_MID_AND_STATUS_STATEMENT = 
				"from PackBean where memberId = " + memberId + "and status = " + status;
		
		List<PackBean> packList = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_MID_AND_STATUS_STATEMENT);
			
			packList = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return packList;
	}

	@Override
	public PackBean selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PackBean insert(PackBean packagebean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PackBean update(PackBean packageBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
