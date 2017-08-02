package com.eeit95.her.model.font;

import java.util.List;

public interface FontDAOInterface {
	public FontBean insert(FontBean fontBean);
    public FontBean update(FontBean fontBean);
    public boolean deleteById(String id);
    public FontBean selectById(String id);
    public List<FontBean> selectWithBetween(String column ,double low,double high);
    public List<FontBean> selectWithBetween(String column ,int low,int high);
    public List<FontBean> selectTopN(int topN,String column,String ascOrDesc);
    public List<FontBean> selectAll();
}
