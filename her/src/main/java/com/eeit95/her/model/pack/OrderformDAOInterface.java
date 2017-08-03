package com.eeit95.her.model.pack;

import java.util.List;

public interface OrderformDAOInterface {
	
	public List<OrderformBean> selectByMIdAndStatus(String memberId, int status);
	
	public List<OrderformBean> select(String id, String memberId, String lowDate, String highDate, int paymentMethod, int status);
	
}
