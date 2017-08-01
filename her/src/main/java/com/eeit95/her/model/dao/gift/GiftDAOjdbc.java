package com.eeit95.her.model.dao.gift;

import java.sql.SQLException;
import java.util.List;
import com.eeit95.her.model.gift.GiftBean;
import com.eeit95.her.model.gift.GiftDAO;
import com.eeit95.her.model.gift.IGiftDAO;

public class GiftDAOjdbc {

	public static void main(String[] args) {
		IGiftDAO dao = new GiftDAO();
		try {
			dao.getConnection();
			
//			// insert
//			GiftBean gBean1 = new GiftBean();
//			gBean1.setId("G20170727003"); 
//			gBean1.setName("Gift3");
//			gBean1.setPrice(350);
//			gBean1.setCover(null);  //資料庫型態是bit，Java設為byte[]。該給什麼資料新增？
//			gBean1.setViewCount(0);
//			gBean1.setSalesCount(0);
//			gBean1.setStatus(true);
//			gBean1.setManufacturer("Jelly Huang");
//			gBean1.setCost(50);
//			gBean1.setGpratio(300);
//			gBean1.setStock(33);
//			gBean1.setCategoryId(305);		
//			int count1 = dao.insert(gBean1);
//			System.out.println("insert " + count1 + " rows");
//			System.out.println("---------------------------------");
			
//			// update
//			GiftBean gBean2 = new GiftBean();
//			gBean2.setId("G20170727003");
//			gBean2.setName("Gift4");
//			gBean2.setPrice(450);
//			gBean2.setCover(null);  //資料庫型態是bit，Java設為byte[]。該給什麼資料新增？
//			gBean2.setViewCount(0);
//			gBean2.setSalesCount(0);
//			gBean2.setStatus(true);
//			gBean2.setManufacturer("Carrie Liu");
//			gBean2.setCost(40);
//			gBean2.setGpratio(400);
//			gBean2.setStock(40);
//			gBean2.setCategoryId(405);	
//			int count2 = dao.update(gBean2);
//			System.out.println("update " + count2 + " rows");
//			System.out.println("---------------------------------");
			
//			// find by PrimaryKey
			GiftBean gBean3 = dao.findByPrimaryKey("G20170727003"); //PK是id
			System.out.println("id = " + gBean3.getId());
			System.out.println("name = " + gBean3.getName());
			System.out.println("price = " + gBean3.getPrice());
			System.out.println("cover = " + gBean3.getCover());
			System.out.println("viewCount = " + gBean3.getViewCount());
			System.out.println("salesCount = " + gBean3.getSalesCount());
			System.out.println("status = " + gBean3.isStatus());
			System.out.println("manufacturer = " + gBean3.getManufacturer());
			System.out.println("cost = " + gBean3.getCost());
			System.out.println("gpratio = " + gBean3.getGpratio());
			System.out.println("stock = " + gBean3.getStock());
			System.out.println("categoryId = " + gBean3.getCategoryId());
			System.out.println("---------------------------------");

//			// get all 
			List<GiftBean> gBeans = dao.getAll();
			for (GiftBean gBean : gBeans){
				System.out.print(gBean.getId() + ",");
				System.out.print(gBean.getName() + ",");
				System.out.print(gBean.getPrice() + ",");
				System.out.print(gBean.getCover() + ",");
				System.out.print(gBean.getViewCount() + ",");
				System.out.print(gBean.getSalesCount() + ",");
				System.out.print(gBean.isStatus() + ",");
				System.out.print(gBean.getManufacturer() + ",");
				System.out.print(gBean.getCost() + ",");
				System.out.print(gBean.getGpratio() + ",");
				System.out.print(gBean.getStock() + ",");
				System.out.print(gBean.getCategoryId() + "\n");
			}
			System.out.println("---------------------------------");
			
//			// delete
//			int count3 = dao.delete("G20170727002"); //輸入id
//			System.out.println("delete " + count3 + " rows");	
//			System.out.println("---------------------------------");		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dao.closeConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
}
