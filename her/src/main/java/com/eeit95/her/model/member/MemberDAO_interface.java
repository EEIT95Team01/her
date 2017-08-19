package com.eeit95.her.model.member;

import java.util.List;
import java.util.Set;

public interface MemberDAO_interface {
	 //public MemberBean insert(String email,String password);
	 public MemberBean insert(MemberBean memberBean);
	 public MemberBean insert(String id ,String email,String password);
     public MemberBean update(MemberBean MemberBean);
     public boolean delete(String id);
     public MemberBean findByPrimaryKey(String id);
     public String findIdFromEmail(String email);
     public List<MemberBean> getAll();
     public String getNewId();
     public void getMemberPassword(String email);
     public void sendEmail(String memberEmail, String newPassword);
}
