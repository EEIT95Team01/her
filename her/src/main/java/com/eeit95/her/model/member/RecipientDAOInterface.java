package com.eeit95.her.model.member;

import java.util.List;

public interface RecipientDAOInterface {
	  public void insert(RecipientBean recipientBean);
      public void update(RecipientBean recipientBean);
      public void delete(String id);
      public RecipientBean findByPrimaryKey(String id);
      public List<RecipientBean> getAll();
}
