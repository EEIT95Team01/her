package com.eeit95.her.model.gift;

import java.util.List;

public interface GiftDescriptionDAOInterface {
    
	public List<GiftDescriptionBean> insert(List<GiftDescriptionBean> beans);
	public boolean delete(String giftId);
	public List<GiftDescriptionBean> selectById(String giftId);
	public List<GiftDescriptionBean> selectByNo(int orderNo); 
	
}