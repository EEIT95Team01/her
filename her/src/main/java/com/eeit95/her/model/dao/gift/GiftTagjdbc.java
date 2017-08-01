package com.eeit95.her.model.dao.gift;

import java.sql.SQLException;
import java.util.List;

import com.eeit95.her.model.gift.GiftTagBean;
import com.eeit95.her.model.gift.GiftTagDAO;

public class GiftTagjdbc {

	public static void main(String[] args) {
		GiftTagDAO dao = new GiftTagDAO();
		try {
			dao.getConnection();
			
//			// insert
//			GiftTagBean gtBean1 = new GiftTagBean();
//			gtBean1.setGiftId("G20170728007");
//			gtBean1.setTagId(77);;
//			int count1 = dao.insert(gtBean1);
//			System.out.println("insert " + count1 + " rows");
//			System.out.println("---------------------------------");
			
//			// update (giftId跟tagId是複合式主鍵)
//			GiftTagBean gtBean2 = new GiftTagBean();
//			gtBean2.setGiftId("G20170728007");
//			gtBean2.setTagId(88);;
//			int count2 = dao.update(gtBean2);
//			System.out.println("update " + count2 + " rows");
//			System.out.println("---------------------------------");
			
//			// find by PrimaryKey
			GiftTagBean gtBean3 = dao.findByPrimaryKey("G20170727001",11); 
			System.out.println("giftId = " + gtBean3.getGiftId());
			System.out.println("tagId = " + gtBean3.getTagId());
			System.out.println("---------------------------------");

//			// get all 
			List<GiftTagBean> gtBeans = dao.getAll();
			for (GiftTagBean gtBean : gtBeans){
				System.out.print(gtBean.getGiftId() + ",");
				System.out.print(gtBean.getTagId() + "\n");
			}
			System.out.println("---------------------------------");
			
//			// delete
//			int count3 = dao.delete("G20170728007",88); //輸入複合式主鍵的兩個值。
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