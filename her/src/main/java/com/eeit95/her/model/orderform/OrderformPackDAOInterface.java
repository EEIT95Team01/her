package com.eeit95.her.model.orderform;

import java.util.List;

public interface OrderformPackDAOInterface {
	
	public OrderformPackBean insert(OrderformPackBean bean);
    public OrderformPackBean update(OrderformPackBean bean);
    public boolean delete(String orderformId,String packId);
    public List<OrderformPackBean> selectByOrderformId(String orderformId);
    public List<OrderformPackBean> selectByPackId(String packId);
    public List<OrderformPackBean> selectAll();
    
}
