package com.eeit95.her.model.gift;

import java.util.List;
import com.eeit95.her.model.category.CategoryBean;

public interface GiftDAOInterface {

	public GiftBean insert(GiftBean bean);
	public GiftBean update(GiftBean bean);
	public boolean delete(String id);
	public GiftBean selectById(String id);
	
	//依上架時間/熱銷度/價格查詢(利用order by "欄位名稱" 做排序(asc/desc，預設為升冪))
	public List<GiftBean> selectAll(String column, String ascOrDesc); 
	
	public List<GiftBean> selectTopN(int n,String column,String ascOrDesc);
	public  List <GiftBean> selectWithBetween(String column,double lo,double hi, String ascOrDesc);
	public  List <GiftBean> selectWithBetween(String column, int lo, int hi, String ascOrDesc);

	public List <GiftBean> selectAllFC
	(String name, double loPrice, double hiPrice, int loSaleCount, int hiSaleCount, 
	String manufacturer, CategoryBean categoryId,String ascOrDesc, String column);
	

	public List <GiftBean> selectAllFM(GiftSelectBean giftSelectBean);
	
	public String getNewId();

}