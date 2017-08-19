package com.eeit95.her.model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardDAOInterface;
import com.eeit95.her.model.card.CardDescriptionBean;
import com.eeit95.her.model.card.CardDescriptionDAOInterface;
import com.eeit95.her.model.card.CardSBean;
import com.eeit95.her.model.card.CardSelectBean;
import com.eeit95.her.model.card.CardTagBean;
import com.eeit95.her.model.card.CardTagInterface;
import com.eeit95.her.model.font.FontDescriptionBean;
import com.eeit95.her.model.font.FontDescriptionDAOInterface;
import com.eeit95.her.model.font.FontSBean;
import com.eeit95.her.model.font.FontTagBean;
import com.eeit95.her.model.font.FontTagDAOInterface;
import com.eeit95.her.model.gift.GiftDAOInterface;
import com.eeit95.her.model.gift.GiftDescriptionBean;
import com.eeit95.her.model.gift.GiftDescriptionDAOInterface;
import com.eeit95.her.model.gift.GiftSBean;
import com.eeit95.her.model.gift.GiftTagBean;
import com.eeit95.her.model.gift.GiftTagDAOInterface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Service
public class GiftService {
	@Autowired
	private GiftDAOInterface giftDAO;
	@Autowired
	private GiftTagDAOInterface giftTag;
	@Autowired
	private GiftDescriptionDAOInterface giftDesc;

	
	
	public String[] selectTagById(GiftSBean giftSBean) {

		List<GiftTagBean> giftTagBeans = giftTag.selectById(giftSBean.getId());
		String[] tagArray = new String[giftTagBeans.size()];
		for (GiftTagBean bean : giftTagBeans) {
			tagArray[giftTagBeans.indexOf(bean)] = String.valueOf(bean.getTagId());
		}
		return tagArray;
	}
	
	public List<GiftDescriptionBean> selectDescById(GiftSBean giftSBean) {

		List<GiftDescriptionBean> giftDescriptionBeans = giftDesc.selectById(giftSBean.getId());
		return giftDescriptionBeans;
	}
	
	

}
