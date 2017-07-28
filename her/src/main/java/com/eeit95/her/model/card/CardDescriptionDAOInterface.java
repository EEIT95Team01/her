package com.eeit95.her.model.card;

import java.util.List;

public interface CardDescriptionDAOInterface {
	public abstract List <CardDescriptionBean> selectById(String cardId);
	public abstract CardDescriptionBean insert(CardDescriptionBean bean);
	public abstract CardDescriptionBean update(CardDescriptionBean bean);
	public abstract boolean delete(String id,short order);

}
