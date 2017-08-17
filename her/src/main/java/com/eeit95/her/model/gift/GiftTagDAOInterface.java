package com.eeit95.her.model.gift;

import java.util.List;
import com.eeit95.her.model.tag.TagBean;

public interface GiftTagDAOInterface {

	public List<GiftTagBean> insert(List<GiftTagBean> beans);
	public boolean delete(GiftBean giftId, TagBean tagId);
	public boolean deleteById(GiftBean giftId);
	public boolean deleteByTagId(TagBean tagId);
	public List<GiftTagBean> selectById(GiftBean giftId);
	public List<GiftTagBean> selectByTagId(TagBean tagId);
	public List<GiftTagBean> selectAll();
	
}