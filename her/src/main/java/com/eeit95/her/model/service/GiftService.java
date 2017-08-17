package com.eeit95.her.model.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.eeit95.her.model.category.CategoryBean;
import com.eeit95.her.model.dao.gift.GiftHibernateDAO;
import com.eeit95.her.model.gift.GiftBean;
import com.eeit95.her.model.gift.GiftDAOInterface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Service
public class GiftService {

	@Autowired
	private GiftDAOInterface giftDAOInterface;
	
	
	public GiftBean insert(GiftBean bean) {
		return giftDAOInterface.insert(bean);
	}
	
	public GiftBean update(GiftBean bean) {
		return giftDAOInterface.update(bean);
	}
	
	public boolean delete(String id) {
		return giftDAOInterface.delete(id);
	}
	
	public GiftBean selectById(String id) {
		return giftDAOInterface.selectById(id);
	}
	
	//依上架時間/熱銷度/價格查詢(利用order by "欄位名稱" 做排序(asc/desc，預設為升冪))
	public List<GiftBean> selectAll(String column, String ascOrDesc){
		return giftDAOInterface.selectAll(column, ascOrDesc);
	}
	
	public List<GiftBean> selectTopN(int n,String column,String ascOrDesc){
		return giftDAOInterface.selectTopN(n, column, ascOrDesc);
	}
	
	public  List <GiftBean> selectWithBetween(String column,double lo,double hi, String ascOrDesc){
		return giftDAOInterface.selectWithBetween(column, lo, hi, ascOrDesc);
	}
	public  List <GiftBean> selectWithBetween(String column, int lo, int hi, String ascOrDesc){
		return giftDAOInterface.selectWithBetween(column, lo, hi, ascOrDesc);
	}

	public List <GiftBean> selectAllFC
	(String name, double loPrice, double hiPrice, int loSaleCount, int hiSaleCount, 
	String manufacturer, CategoryBean categoryId,String ascOrDesc, String column){
		return giftDAOInterface.selectAllFC
		(name, loPrice, hiPrice, loSaleCount, hiSaleCount, manufacturer, categoryId, ascOrDesc, column);
	}
	
	public List <GiftBean> selectAllFM
	(String id, String name, double loPrice, double hiPrice , int loViewCount, int hiViewCount, 
			int loSaleCount, int hiSaleCount, String manufacturer, double loCost, double hiCost, 
			double loGPratio, double hiGPratio, int loStock, int hiStock, CategoryBean categoryId,
			String ascOrDesc,String column, int status){
		return giftDAOInterface.selectAllFM
		(id, name, loPrice, hiPrice, loViewCount, hiViewCount, loSaleCount, hiSaleCount, manufacturer, 
		loCost, hiCost, loGPratio, hiGPratio, loStock, hiStock, categoryId, ascOrDesc, column, status);
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		GiftHibernateDAO dao = (GiftHibernateDAO) context.getBean("giftHibernateDAO");
		
		try {
			sessionFactory.getCurrentSession().beginTransaction();
		
		//● 新增-1(0808-SpringService測試OK)(不需要cascade="save-update" 或 cascade="all"的設定)(這是經常要用到的一般新增)
//		CategoryBean cBean = new CategoryBean();
//		cBean.setId(6); //必須填入Category已有的Id，否則會新增失敗。
//		GiftBean gBean = new GiftBean(); // Gift的POJO
//		gBean.setId("g01708080001");
//		gBean.setName("IPhone9");
//		gBean.setPrice(1666);
//		gBean.setCover(null);
//		gBean.setViewCount(155);
//		gBean.setSalesCount(1234);
//		gBean.setStatus(true);
//		gBean.setManufacturer("D");
//		gBean.setCost(1333);
//		gBean.setGpratio(1222);
//		gBean.setStock(1111);
//		gBean.setCategoryId(cBean);
//		try {
//			dao.insert(gBean);
//			System.out.println("新增成功");
//		} catch (Exception e1) {
//			System.out.println("新增失敗");
//		}
		
		//● 修改-2(0808-SpringService測試OK)(不需設定cascade="save-update" 或 cascade="all")(這是經常要用到的一般修改)
//		CategoryBean cBean = new CategoryBean();
//		cBean.setId(4);
//		GiftBean gBean = new GiftBean(); // Gift的POJO
//		gBean.setId("g01708080001");//【如果id不存在，則變成update】
//		gBean.setName("ASUS ZenFone10");
//		gBean.setPrice(1110);
//		gBean.setCover(null);
//		gBean.setViewCount(220);
//		gBean.setSalesCount(3330);
//		gBean.setStatus(true);
//		gBean.setManufacturer("D");
//		gBean.setCost(550);
//		gBean.setGpratio(4440);
//		gBean.setStock(660);
//		gBean.setCategoryId(cBean);
//		dao.update(gBean);

		//●刪除-3(0808-SpringService測試OK)//輸入id(String型別)
//		if(dao.delete("g01708080001") == true) {
//			System.out.println("刪除成功");
//		}else{
//			System.out.println("刪除失敗");
//		}; 

		//● 查詢-4 selectById(0808-SpringService測試OK)
//		GiftBean giftBean = dao.selectById("g01706210002"); //輸入id(String型別)
//		System.out.println("\n-----------------");
//		System.out.print(giftBean.getId() + ",");
//		System.out.print(giftBean.getName() + ",");
//		System.out.print(giftBean.getPrice() + ",");
//		System.out.print(giftBean.getCover() + ",");
//		System.out.print(giftBean.getViewCount() + ",");
//		System.out.print(giftBean.getSalesCount() + ",");
//		System.out.print(giftBean.isStatus() + ",");
//		System.out.print(giftBean.getManufacturer() + ",");
//		System.out.print(giftBean.getCost() + ",");
//		System.out.print(giftBean.getGpratio() + ",");
//		System.out.print(giftBean.getStock() + ",");
//		System.out.print(giftBean.getCategoryId().getId() + ",");
//		System.out.println("\n-----------------");

		//● 查詢-5 selectAll(0808-SpringService測試OK)
		//依上架時間/熱銷度/價格查詢(利用order by "欄位名稱" 排序(asc/desc，預設為升冪))
//		String column = "price";
//		String ascOrDesc = null;//未給值預設為null，採升冪排序。
//		List<GiftBean> list = dao.selectAll(column, ascOrDesc);
//		System.out.println("\n-----------------");
//		for (GiftBean gVO : list) {
//		System.out.print(gVO.getId() + ",");
//		System.out.print(gVO.getName() + ",");
//		System.out.print(gVO.getPrice() + ",");
//		System.out.print(gVO.getCover() + ",");
//		System.out.print(gVO.getViewCount() + ",");
//		System.out.print(gVO.getSalesCount() + ",");
//		System.out.print(gVO.isStatus() + ",");
//		System.out.print(gVO.getManufacturer() + ",");
//		System.out.print(gVO.getCost() + ",");
//		System.out.print(gVO.getGpratio() + ",");
//		System.out.print(gVO.getStock() + ",");
//		System.out.print(gVO.getCategoryId().getId() + ",");
//		System.out.println();
//		System.out.println("\n-----------------");
//		}
		
		//● 查詢 -6 selectTopN(測試NG)(spring無法辨別setMaxResults，要改語法)
//		List<GiftBean> list = dao.selectTopN(3, "cost", "asc");
//		System.out.println("\n-----------------");
//		for (GiftBean bean : list) {
//			System.out.print(bean.getId() + ",");
//			System.out.print(bean.getName() + ",");
//			System.out.print(bean.getPrice() + ",");
//			System.out.print(bean.getCover() + ",");
//			System.out.print(bean.getViewCount() + ",");
//			System.out.print(bean.getSalesCount() + ",");
//			System.out.print(bean.isStatus() + ",");
//			System.out.print(bean.getManufacturer() + ",");
//			System.out.print(bean.getCost() + ",");
//			System.out.print(bean.getGpratio() + ",");
//			System.out.print(bean.getStock() + ",");
//			System.out.print(bean.getCategoryId().getId() + ",");
//			System.out.println();
//			System.out.println("\n-----------------");
//			}
		
//		//● 查詢 -7 selectWithBetween(0808-SpringService測試OK)(查詢 int / double 型別的資料)
		//※同一測試程式只要給予符合"column"欄位的數值型別(如整數或小數)，即可正常執行查詢。
//		List<GiftBean> list = dao.selectWithBetween("viewCount",10,50000,"asc");
//		System.out.println("\n-----------------");
//		for (GiftBean gVO : list) {
//			System.out.print(gVO.getId() + ",");
//			System.out.print(gVO.getName() + ",");
//			System.out.print(gVO.getPrice() + ",");
//			System.out.print(gVO.getCover() + ",");
//			System.out.print(gVO.getViewCount() + ",");
//			System.out.print(gVO.getSalesCount() + ",");
//			System.out.print(gVO.isStatus() + ",");
//			System.out.print(gVO.getManufacturer() + ",");
//			System.out.print(gVO.getCost() + ",");
//			System.out.print(gVO.getGpratio() + ",");
//			System.out.print(gVO.getStock() + ",");
//			System.out.print(gVO.getCategoryId().getId() + ",");
//			System.out.println();
//			System.out.println("\n-----------------");
//		}	
		
		//● 查詢 -8 selectAllFC(0807測試NG-只找到空陣列[])
//		CategoryBean cBean = new CategoryBean(); 
//		cBean.setId(2);
//		List <GiftBean> selectAllFC = dao.selectAllFC
//				("日本", 1.0, 10000.0, 1, 100000, null, null, "desc", "price");
//		for (GiftBean gVO : selectAllFC) {
//			System.out.print(gVO.getId() + ",");
//			System.out.print(gVO.getName() + ",");
//			System.out.print(gVO.getPrice() + ",");
//			System.out.print(gVO.getCover() + ",");
//			System.out.print(gVO.getViewCount() + ",");
//			System.out.print(gVO.getSalesCount() + ",");
//			System.out.print(gVO.isStatus() + ",");
//			System.out.print(gVO.getManufacturer() + ",");
//			System.out.print(gVO.getCost() + ",");
//			System.out.print(gVO.getGpratio() + ",");
//			System.out.print(gVO.getStock() + ",");
//			System.out.print(gVO.getCategoryId().getId() + ",");
//			System.out.print(gVO.getCategoryId().getSubName());
//			System.out.println();				
//		}
//		System.out.println(selectAllFC);
			
			
			//● 查詢 -9 selectAllFC(0807測試NG-java.lang.Integer cannot be cast to java.lang.Double)
//		List <GiftBean> selectAllFM = dao.selectAllFM(null, "日本", 1.0, 10000.0, 1, 100000, 1, 100000,
//				null, 1.0, 100000.0, 1.0, 100000.0, 1, 100000, null, null, "id", 1);
//		for (GiftBean gVO : selectAllFM) {
//			System.out.print(gVO.getId() + ",");
//			System.out.print(gVO.getName() + ",");
//			System.out.print(gVO.getPrice() + ",");
//			System.out.print(gVO.getCover() + ",");
//			System.out.print(gVO.getViewCount() + ",");
//			System.out.print(gVO.getSalesCount() + ",");
//			System.out.print(gVO.isStatus() + ",");
//			System.out.print(gVO.getManufacturer() + ",");
//			System.out.print(gVO.getCost() + ",");
//			System.out.print(gVO.getGpratio() + ",");
//			System.out.print(gVO.getStock() + ",");
//			System.out.print(gVO.getCategoryId().getId() + ",");
//			System.out.print(gVO.getCategoryId().getSubName());
//			System.out.println();				
//		}
//		System.out.println(selectAllFM);

		sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException ex) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw ex;
		} finally {
			((ConfigurableApplicationContext) context).close();
		}

	}
}