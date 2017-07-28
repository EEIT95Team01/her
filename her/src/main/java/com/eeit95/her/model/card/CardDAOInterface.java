package com.eeit95.her.model.card;

import java.sql.Blob;
import java.util.List;

public interface CardDAOInterface {
	public abstract CardBean selectById(String id);
	public abstract CardBean insert(CardBean bean);
	public abstract CardBean update(String name,Long price,Blob cover,int viewCount,int salesCount,
	Boolean	status,String manufacturer,Long cost,Long gpratio,short stock,
	short maxWordCount,String id);
	public abstract boolean delete(String id);
	public abstract List <CardBean> selectAll();
	public abstract List <CardBean> selectAll(int n,String type);
}
