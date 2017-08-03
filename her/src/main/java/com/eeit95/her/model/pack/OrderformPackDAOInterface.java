package com.eeit95.her.model.pack;

import java.util.List;

public interface OrderformPackDAOInterface {
	public OrderformPackBean insert(OrderformPackBean orderformPackBean);
    public OrderformPackBean update(OrderformPackBean orderformPackBean);
    public boolean delete(String orderformId,String packId);
    public List<OrderformPackBean> selectByOrderformId(String orderformId);
    public List<OrderformPackBean> selectByPackId(String packId);
    public List<OrderformPackBean> selectAll();
}
