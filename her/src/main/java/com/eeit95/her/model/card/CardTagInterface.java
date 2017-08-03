package com.eeit95.her.model.card;

import java.util.List;

import com.eeit95.her.model.tag.TagBean;

public interface CardTagInterface {
	public abstract List<CardTagBean> selectBycardId(String cardId);
	public abstract List<CardTagBean> selectBytagId(int tagId);
	public abstract List<CardTagBean> insert(List<CardTagBean> bean);
	public abstract boolean deleteBycardId(String cardId);
	public abstract boolean deleteBytagId(int tagId);
	public abstract boolean delete(String cardId,int tagId);
	public abstract List <CardTagBean> selectAll();
}
