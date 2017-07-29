package com.eeit95.her.model.card;

import java.util.List;

import com.eeit95.her.model.tag.TagBean;

public interface CardTagInterface {
	public abstract List<CardTagBean> selectBycardId(String cardId);
	public abstract List<CardTagBean> selectBytagId(short tagId);
	public abstract List<CardTagBean> insert(List<CardTagBean> bean);
	public abstract boolean deleteBycardId(String cardId);
	public abstract boolean deleteBytagId(short tagId);
	public abstract boolean delete(String cardId,short tagId);
	public abstract List <CardTagBean> selectAll();
}
