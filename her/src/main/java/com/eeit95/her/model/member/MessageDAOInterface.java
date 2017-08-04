package com.eeit95.her.model.member;

import java.util.List;

public interface MessageDAOInterface {
	  public void insert(MessageBean messageBean);
      public void update(MessageBean messageBean);
      public void delete(Integer id);
      public MessageBean findByPrimaryKey(Integer id);
      public List<MessageBean> getAll();
}
