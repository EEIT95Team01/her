package com.eeit95.her.model.member;

import java.util.List;

public interface CollectionDAO_interface {
	public CollectionBean insert(String memberId , String productId);
//	public CollectionBean update(CollectionBean collectionBean);
	public Boolean delete(String memberId , String productId);
	public List<CollectionBean> allCollection(String memberId);
	public List<CollectionBean> allCardCollection(String memberId);
	public List<CollectionBean> allFontCollection(String memberId);
	public List<CollectionBean> allGiftCollection(String memberId);
}
