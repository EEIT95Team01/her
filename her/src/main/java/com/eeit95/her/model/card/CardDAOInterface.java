package com.eeit95.her.model.card;

import java.sql.Blob;
import java.util.List;

import com.eeit95.her.model.font.FontBean;

public interface CardDAOInterface {
	public String getNewId();
	public CardBean selectById(String id);
	public CardBean insert(CardBean bean);
	public CardBean update(CardBean bean);
	public boolean delete(String id);
	public List <CardBean> selectAll();
	public List <CardBean> selectTopN(int topN,String column,String ascOrDesc);
	public List <CardBean> selectWithBetween(String type,double lo,double hi,String ascOrdesc);
	public List <CardBean> selectWithBetween(String column, int low, int high, String ascOrDesc);
	public List <CardBean> selectAllFC(String name,int loWordCount,int hiWordCount,double loPrice ,double hiPrice,String ascOrDesc,String column);
	public List <CardBean> selectAllFM(CardSelectBean cardSelectBean);
	public List<CardBean> selectAllOrderBySales();
    public List<CardBean> selectAllOrderByPrice(String ascOrDesc);
    public List<CardBean> selectAllStatus(boolean tOrF);
}
