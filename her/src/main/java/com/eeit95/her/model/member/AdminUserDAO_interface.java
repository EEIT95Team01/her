package com.eeit95.her.model.member;

import java.util.List;
import java.util.Set;

public interface AdminUserDAO_interface {
	 public AdminUserBean insert(AdminUserBean adminBean);
     public AdminUserBean update(AdminUserBean adminBean);
     public AdminUserBean findByUsername(String username);
     public List<AdminUserBean> findByAuthority(int authority_num);
     public List<AdminUserBean> getAll();
}
