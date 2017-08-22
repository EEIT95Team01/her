package com.eeit95.her.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eeit95.her.model.advertisement.AdvertisementBean;
import com.eeit95.her.model.advertisement.AdvertisementDAOInterface;

@Service
public class FrontService {

	@Autowired
	private AdvertisementDAOInterface advertisement;
	
	 
	public List<AdvertisementBean> select(){
		List<AdvertisementBean> results = new ArrayList<AdvertisementBean>();
		List<AdvertisementBean> beans = advertisement.selectByDate();
		for(AdvertisementBean bean : beans) {
			AdvertisementBean result = new AdvertisementBean();
			result.setImage(bean.getImage());
			results.add(result);
		}
		return results;
	}
	
}
