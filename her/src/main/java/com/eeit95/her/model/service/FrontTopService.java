package com.eeit95.her.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eeit95.her.model.advertisement.AdvertisementDAOInterface;
import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardDAOInterface;
import com.eeit95.her.model.card.CardDescriptionDAOInterface;
import com.eeit95.her.model.card.CardSelectAllBean;
import com.eeit95.her.model.card.CardSelectBean;
import com.eeit95.her.model.card.CardTagBean;
import com.eeit95.her.model.card.CardTagInterface;
import com.eeit95.her.model.font.FontDAOInterface;
import com.eeit95.her.model.font.FontDescriptionDAOInterface;
import com.eeit95.her.model.font.FontTagDAOInterface;
import com.eeit95.her.model.font.WriterDAOInterface;
import com.eeit95.her.model.gift.GiftDAOInterface;
import com.eeit95.her.model.gift.GiftDescriptionDAOInterface;
import com.eeit95.her.model.gift.GiftTagDAOInterface;

@Service
public class FrontTopService {
	@Autowired
	private CardDAOInterface card;
	@Autowired
	private FontDAOInterface font;
	@Autowired
	private GiftDAOInterface gift;
	
	public CardSelectAllBean selectTopCard(CardSelectBean cardSelectBean) {
		System.out.println("進入Select Service");
		CardSelectAllBean bean = new CardSelectAllBean();
		List<CardBean> list = new ArrayList<CardBean>();
		if("T3".equalsIgnoreCase(cardSelectBean.getId())) {
			System.out.println("進入Select top3 Service-1");
			list=card.selectTop3();
			bean.setCard(list);
		}
		if("T2".equalsIgnoreCase(cardSelectBean.getId())) {
			System.out.println("進入Select top2 Service-1");
			list=card.selectTop2();
			bean.setCard(list);
		}	
		
		return bean;
	}
	
	
	
	
}
