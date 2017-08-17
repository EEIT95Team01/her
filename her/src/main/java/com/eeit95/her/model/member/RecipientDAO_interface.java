package com.eeit95.her.model.member;

import java.util.List;


public interface RecipientDAO_interface {
	  public RecipientBean insert(RecipientBean recipientBean);
      public RecipientBean update(RecipientBean recipientBean);
      public boolean delete(RecipientBean recipientBean);
      public boolean deleteByMemberId(String memberId);
      public RecipientBean findByPrimaryKey(String recipientId);
      public List<RecipientBean> findByMemberId(String id);
      public String getNewId();
}
