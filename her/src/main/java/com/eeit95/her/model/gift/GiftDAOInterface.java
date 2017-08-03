package com.eeit95.her.model.gift;

import java.util.List;

public interface GiftDAOInterface {

	public void insert(GiftBean giftVO);
	public void update(GiftBean giftVO);
	public boolean delete(String id);
	public GiftBean selectById(String id);
	public List<GiftBean> selectAll();
	public List<GiftBean> selectTopN(int n,String column,String ascOrDesc); 
	public  List <GiftBean> selectWithBetween(String column,double lo,double hi, String ascOrDesc);
	public  List <GiftBean> selectWithBetween(String column, int lo, int hi, String ascOrDesc);
}