package com.eeit95.her.model.card;

import java.util.List;

public interface CardDescriptionDAOInterface {
	public abstract List <CardDescriptionBean> selectById(String cardId);
	public abstract List <CardDescriptionBean> insert(List <CardDescriptionBean> beans);
	public abstract CardDescriptionBean update(CardDescriptionBean bean);
	public abstract boolean deleteByPrimaryKey(String cardId,short order);

}
