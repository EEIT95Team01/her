package com.eeit95.her.model.member;

import java.util.List;
import java.util.Set;


public interface MemberDAOInterface {
	 public void insert(MemberBean MemberBean);
     public void update(MemberBean MemberBean);
     public void delete(String id);
     public MemberBean findByPrimaryKey(String id);
     public List<MemberBean> getAll();
     public Set<RecipientBean> getRecipientByMember(String id);
     public Set<MessageBean> getMessageByMember(String id);
}
