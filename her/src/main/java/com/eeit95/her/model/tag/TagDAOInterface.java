package com.eeit95.her.model.tag;

import java.util.List;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.tag.TagBean;

public interface TagDAOInterface {
	public abstract TagBean selectById(int id);
	public abstract TagBean insert(TagBean bean);
	public abstract TagBean update(TagBean bean);
	public abstract boolean delete(int id);
	public abstract List <TagBean> selectAll();
}
