package com.eeit95.her.model.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eeit95.her.model.member.RecipientBean;
import com.eeit95.her.model.member.RecipientDAO_interface;

@Service
public class RecipientService {
	@Autowired
	private RecipientDAO_interface RDAOI;

	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public RecipientBean findByRecipientId(String recipientId){
		return RDAOI.findByPrimaryKey(recipientId);
	}

	public List<RecipientBean> findByMemberId(String memberId) {
		return RDAOI.findByMemberId(memberId);
	}
	
	public RecipientBean insert(RecipientBean rb){
		rb.setId(RDAOI.getNewId());
		return RDAOI.insert(rb);
	}
	
	public RecipientBean update(RecipientBean rb){
		return RDAOI.update(rb);
	}
	
	public boolean delete(RecipientBean rb){
		return RDAOI.delete(rb);
	}

}
