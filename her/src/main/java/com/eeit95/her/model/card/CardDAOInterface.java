package com.eeit95.her.model.card;

import java.sql.Blob;
import java.util.List;

public interface CardDAOInterface {
	public abstract CardBean selectById(String id);
	public abstract CardBean insert(CardBean bean);
	public abstract CardBean update(CardBean bean);
	public abstract boolean delete(String id);
	public abstract List <CardBean> selectAll();
	public abstract List <CardBean> selectAll(int n,String type,String desc);
	public abstract List <CardBean> selectBetween(String type,double lo,double hi);
}
