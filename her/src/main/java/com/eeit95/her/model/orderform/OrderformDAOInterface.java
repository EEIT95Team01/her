package com.eeit95.her.model.orderform;

import java.util.List;

import com.eeit95.her.model.member.MemberBean;

public interface OrderformDAOInterface {
	
	public OrderformBean insert (OrderformBean bean);
	
	public List<OrderformBean> selectByMIdAndStatus(String id, int status);
	
	public List<OrderformBean> select
	(String id, String memberId, int status, String lowDate, String highDate);
	
	public String getNewId();
	
}
