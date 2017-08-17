package com.eeit95.her.model.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eeit95.her.model.member.CollectionBean;
import com.eeit95.her.model.member.CollectionDAO_interface;

@Service
public class CollectionService {
	
	@Autowired
	private CollectionDAO_interface CDAOI;

	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public CollectionBean insert(String memberId , String productId){
		return CDAOI.insert(memberId,productId);
	}
	
	public Boolean delete(String memberId , String productId){
		return CDAOI.delete(memberId,productId);
	}
	
	public List<CollectionBean> allCollection(String memberId){
		return CDAOI.allCollection(memberId);
	}
	
	public List<CollectionBean> allCardCollection(String memberId){
		return CDAOI.allCardCollection(memberId);
	}
	
	public List<CollectionBean> allFontCollection(String memberId){
		return CDAOI.allFontCollection(memberId);
	}
	
	public List<CollectionBean> allGiftCollection(String memberId){
		return CDAOI.allGiftCollection(memberId);
	}
}
