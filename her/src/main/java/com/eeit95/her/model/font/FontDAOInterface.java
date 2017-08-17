package com.eeit95.her.model.font;

import java.util.List;



public interface FontDAOInterface {
	public String getNewId();
	public FontBean insert(FontBean fontBean);
    public FontBean update(FontBean fontBean);
    public boolean deleteById(String id);
    public FontBean selectById(String id);
    public FontBean selectByNAndW(FontBean fontBean);
    public List<FontBean> selectWithBetween(String column ,double low,double high);
    public List<FontBean> selectWithBetween(String column ,int low,int high);
    public List<FontBean> selectTopN(int topN,String column,String ascOrDesc);
    public List<FontBean> select(String id, String name, double lowPrice, double highPrice, int writerId,
			int status, String column, String ascOrDesc);
    public List<FontBean> selectAllOrderBySales();
    public List<FontBean> selectAllOrderByPrice(String ascOrDesc);
    public List<FontBean> selectAll();
    public List<FontBean> selectAllStatus(boolean tOrF);
}
