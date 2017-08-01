package com.eeit95.her.model.dao.gift;

import java.sql.SQLException;
import java.util.List;

import com.eeit95.her.model.gift.CategoryBean;
import com.eeit95.her.model.gift.CategoryDAO;
import com.eeit95.her.model.gift.ICategoryDAO;

public class Categoryjdbc {

	public static void main(String[] args) {
		ICategoryDAO dao = new CategoryDAO();
		try {
			dao.getConnection();
			
//			// insert
//			CategoryBean cBean1 = new CategoryBean();
//			cBean1.setMainId(004);
//			cBean1.setSubName("Category4");
//			int count1 = dao.insert(cBean1);
//			System.out.println("insert " + count1 + " rows");
//			System.out.println("---------------------------------");
			
//			// update
//			CategoryBean cBean2 = new CategoryBean();
//			cBean2.setMainId(004);
//			cBean2.setSubName("Category5");
//			int count2 = dao.update(cBean2);
//			System.out.println("update " + count2 + " rows");
//			System.out.println("---------------------------------");
			
//			// find by PrimaryKey
			CategoryBean cBean3 = dao.findByPrimaryKey(3); //PK是id
			System.out.println("mainId = " + cBean3.getMainId());
			System.out.println("id = " + cBean3.getId());
			System.out.println("subName = " + cBean3.getSubName());
			System.out.println("---------------------------------");

//			// get all 
			List<CategoryBean> cBeans = dao.getAll();
			for (CategoryBean cBean : cBeans){
				System.out.print(cBean.getMainId() + ",");
				System.out.print(cBean.getId() + ",");
				System.out.print(cBean.getSubName() + "\n");
			}
			System.out.println("---------------------------------");
			
//			// delete
//			int count3 = dao.delete(4); //輸入mainID
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