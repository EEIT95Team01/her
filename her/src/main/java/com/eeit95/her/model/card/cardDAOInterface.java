package com.eeit95.her.model.card;

import java.sql.Blob;
import java.util.List;

public interface cardDAOInterface {
	public abstract cardBean select(String id);
	public abstract cardBean insert(cardBean bean);
	public abstract cardBean update(String name,Long price,Blob cover,int viewCount,int salesCount,
	Boolean	status,String manufacturer,Long cost,Long gpratio,short stock,
	short maxWordCount,String id);
	public abstract boolean delete(String id);
	public abstract List <cardBean> select();

}
