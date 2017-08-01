package com.eeit95.her.model.card;

import java.util.List;

public interface CardDescriptionDAOInterface {
	public abstract List <CardDescriptionBean> selectById(CardBean cardBean);
	public abstract List <CardDescriptionBean> insert(List <CardDescriptionBean> beans);
//	public abstract boolean deleteById(String cardId, int order);
	public abstract boolean deleteBycardId(String cardId);

}
