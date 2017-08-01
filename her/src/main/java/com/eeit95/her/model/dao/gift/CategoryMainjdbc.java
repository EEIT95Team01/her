package com.eeit95.her.model.dao.gift;

import java.sql.SQLException;
import java.util.List;

import com.eeit95.her.model.gift.CategoryMainBean;
import com.eeit95.her.model.gift.CategoryMainDAO;
import com.eeit95.her.model.gift.ICategoryMainDAO;

public class CategoryMainjdbc {

	public static void main(String[] args) {
		ICategoryMainDAO dao = new CategoryMainDAO();
		try {
			dao.getConnection();

//			// insert
//			CategoryMainBean cmBean1 = new CategoryMainBean();
//			cmBean1.setName("TEST_CM2");
//			int count1 = dao.insert(cmBean1);
//			System.out.println("insert " + count1 + " rows");
//			System.out.println("---------------------------------");
			
//			// update
//			CategoryMainBean cmBean2 = new CategoryMainBean();
//			cmBean2.setId(5);
//			cmBean2.setName("TEST_CM5");
//			int count2 = dao.update(cmBean2);
//			System.out.println("update " + count2 + " rows");
//			System.out.println("---------------------------------");
			
//			// find by PrimaryKey
			CategoryMainBean cmBean3 = dao.findByPrimaryKey(5);;
			System.out.println("id = " + cmBean3.getId());
			System.out.println("name = " + cmBean3.getName());
			System.out.println("---------------------------------");

//			// get all 
			List<CategoryMainBean> cmBeans = dao.getAll();
			for (CategoryMainBean cmBean : cmBeans){
				System.out.print(cmBean.getId() + ",");
				System.out.print(cmBean.getName() + "\n");
			}
			System.out.println("---------------------------------");
			
//			// delete
//			int count3 = dao.delete(1);
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
