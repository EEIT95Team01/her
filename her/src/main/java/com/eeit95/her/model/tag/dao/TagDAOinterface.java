package com.eeit95.her.model.tag.dao;

import java.util.List;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.tag.TagBean;

public interface TagDAOinterface {
	public abstract TagBean selectById(short id);
	public abstract TagBean insert(TagBean bean);
	public abstract TagBean update(TagBean bean);
	public abstract boolean delete(short id);
	public abstract List <TagBean> selectAll();
}
