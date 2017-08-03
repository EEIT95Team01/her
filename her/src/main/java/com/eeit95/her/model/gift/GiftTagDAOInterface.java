package com.eeit95.her.model.gift;

import java.util.List;

public interface GiftTagDAOInterface {
	
	public void insert(GiftTagBean giftTagVO);
	public List<GiftTagBean> insert(List<GiftTagBean> beans);
	public boolean delete(GiftBean giftId, int tagId);
	public boolean deleteById(GiftBean giftId);
	public boolean deleteByTagId(int tagId);
	public List<GiftTagBean> selectById(GiftBean giftId);
	public List<GiftTagBean> selectByTagId(int tagId);
	public List<GiftTagBean> selectAll();
	
}