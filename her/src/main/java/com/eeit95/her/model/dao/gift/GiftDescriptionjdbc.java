package com.eeit95.her.model.dao.gift;

import java.sql.SQLException;
import java.util.List;

import com.eeit95.her.model.gift.GiftDescriptionBean;
import com.eeit95.her.model.gift.GiftDescriptionDAO;
import com.eeit95.her.model.gift.IGiftDescriptionDAO;

public class GiftDescriptionjdbc {

	public static void main(String[] args) {
		IGiftDescriptionDAO dao = new GiftDescriptionDAO();
		try {
			dao.getConnection();
			
//			// insert
//			GiftDescriptionBean gdBean1 = new GiftDescriptionBean();
//			gdBean1.setGiftId("G20170727006");
//			gdBean1.setG_order(6);
//			gdBean1.setText("第6次測試");
//			gdBean1.setImage(null);  //資料庫型態是bit，Java設為byte[]。該給什麼資料新增？
//			int count1 = dao.insert(gdBean1);
//			System.out.println("insert " + count1 + " rows");
//			System.out.println("---------------------------------");
			
//			// update (giftId跟g_order是複合式主鍵)
//			GiftDescriptionBean gdBean2 = new GiftDescriptionBean();
//			gdBean2.setGiftId("G20170727001"); //需要同時符合giftId跟g_order才行。
//			gdBean2.setG_order(0002);  //需要同時符合giftId跟g_order才行。
//			gdBean2.setText("第4次修改");
//			gdBean2.setImage(null);  //資料庫型態是bit，Java設為byte[]。該給什麼資料新增？
//			int count2 = dao.update(gdBean2);
//			System.out.println("update " + count2 + " rows");
//			System.out.println("---------------------------------");
			
//			// find by PrimaryKey
			GiftDescriptionBean gdBean3 = dao.findByPrimaryKey("G20170727006",6); 
			System.out.println("giftId = " + gdBean3.getGiftId());
			System.out.println("g_order = " + gdBean3.getG_order());
			System.out.println("text = " + gdBean3.getText());
			System.out.println("image = " + gdBean3.getImage());
			System.out.println("---------------------------------");

//			// get all 
			List<GiftDescriptionBean> gdBeans = dao.getAll();
			for (GiftDescriptionBean gdBean : gdBeans){
				System.out.print(gdBean.getGiftId() + ",");
				System.out.print(gdBean.getG_order() + ",");
				System.out.print(gdBean.getText() + ",");
				System.out.print(gdBean.getImage() + "\n");
			}
			System.out.println("---------------------------------");
			
//			// delete
//			int count3 = dao.delete("G20170727001",0002); //輸入複合式主鍵的兩個值。
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