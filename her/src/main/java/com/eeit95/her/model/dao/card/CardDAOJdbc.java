package com.eeit95.her.model.dao.card;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.eeit95.her.model.card.cardBean;
import com.eeit95.her.model.card.cardDAOInterface;



public class CardDAOJdbc implements cardDAOInterface {
	private static final String Select_By_ID = "select*from card where id=?";
	private static final String Insert = "insert into card (id,name,price,cover,viewCount,"
			+ "salesCount,status,manufacturer,cost,gpratio,stock,maxWordCount)"+
			"value(?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String Update="update card set name=?,price=?,cover=?,viewCount=?,"
			+ "salesCount,status=?,manufacturer=?,cost=?,gpratio=?,stock=?,maxWordCount=?"
			+ "where id=? ";
	private static final String Select_All="select*from card";
	private static final String Delete = "delete from card where id=?";
	private static DataSource ds; 
	private static Connection conn;
	static{
		
		try {
			Context context = new InitialContext();
			ds= (DataSource)context.lookup("java:comp/env/jdbc/her");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args){
		CardDAOJdbc cdj = new CardDAOJdbc();
		List<cardBean>  beans = cdj.select();
		
		for(cardBean bean: beans){

			System.out.println(bean);
		}
		
		
	}
	
	@Override
	public List <cardBean> select() {
		List<cardBean> result = new ArrayList<cardBean>();
		try	{
		    conn = ds.getConnection();
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			conn = DriverManager.getConnection(URL, userID, password);
			PreparedStatement stmt = conn.prepareStatement(Select_All);
			ResultSet rset = stmt.executeQuery(); 
//			System.out.println("test1");
			//result = new ArrayList<cardBean>();
			while(rset.next()) {
//				System.out.println("while");
				cardBean bean = new cardBean();
				bean.setId(rset.getString("id"));
				bean.setName(rset.getString("name"));
				bean.setPrice( rset.getLong("price"));
				bean.setCover(rset.getBlob("cover"));
				bean.setViewCount(rset.getInt("viewCount"));
				bean.setSalesCount(rset.getInt("salesCount"));
				bean.setStatus(rset.getBoolean("status"));
				bean.setManufacturer(rset.getString("manufacturer"));
				bean.setCost( rset.getLong("cost"));
				bean.setGpratio( rset.getLong("gpratio"));
				bean.setStock(rset.getShort("stock"));
				bean.setMaxWordCount(rset.getShort("maxWordCount"));
				
				
				result.add(bean);
			}
		} catch (SQLException  e) {
			e.printStackTrace();
		} 
		return result;
		
	}

	
	@Override
	public cardBean select(String id) {
		cardBean result = null;
		ResultSet rset = null;
		Connection conn;
		try {
//			conn = DriverManager.getConnection(URL, userID, password);
			
			conn = ds.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(Select_By_ID);
			stmt.setString(1, id);
			rset=stmt.executeQuery();
			while(rset.next()){
				result=new cardBean();
				result.setName(rset.getString("name"));
				result.setPrice( rset.getLong("price"));
				result.setCover(rset.getBlob("cover"));
				result.setViewCount(rset.getInt("viewCount"));
				result.setSalesCount(rset.getInt("salesCount"));
				result.setStatus(rset.getBoolean("status"));
				result.setManufacturer(rset.getString("manufacturer"));
				result.setCost( rset.getLong("cost"));
				result.setGpratio( rset.getLong("gpratio"));
				result.setStock(rset.getShort("stock"));
				result.setMaxWordCount(rset.getShort("maxWordCount"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally{
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}

	@Override
	public cardBean insert(cardBean bean) {
		cardBean result = null;
		try{
//				Connection conn = DriverManager.getConnection(URL, userID, password);
				conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(Insert);
			if(bean!=null) {
				stmt.setString(1, bean.getId());
				stmt.setString(2, bean.getName());
				stmt.setLong(3, bean.getPrice());
				stmt.setBlob(4,bean.getCover());
				stmt.setInt(5,bean.getViewCount());
				stmt.setInt(6,bean.getSalesCount());
				stmt.setBoolean(7, bean.getStatus());
				stmt.setString(8, bean.getManufacturer());
				stmt.setLong(9, bean.getCost());
				stmt.setLong(10, bean.getGpratio());
				stmt.setShort(11, bean.getStock());
				stmt.setShort(12, bean.getMaxWordCount());
				
				int i = stmt.executeUpdate();
				if(i==1) {
					result = bean;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	

	@Override
	public cardBean update(String name,Long price,Blob cover,int viewCount,int salesCount,
			Boolean	status,String manufacturer,Long cost,Long gpratio,short stock,
			short maxWordCount,String id) {
		
		cardBean result = null;
		try {
			conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(Update);
		    stmt.setString(1, name);
		    stmt.setLong(2, price);
		    stmt.setBlob(3, cover);
		    stmt.setInt(4, viewCount);
		    stmt.setInt(5, salesCount);
		    stmt.setBoolean(6, status);
		    stmt.setString(7, manufacturer);
		    stmt.setLong(8, cost);
		    stmt.setLong(9, gpratio);
		    stmt.setShort(10, stock);
		    stmt.setShort(11, maxWordCount);
		    stmt.setString(12, id);
		    
		    int i = stmt.executeUpdate();
			if(i==1) {
				result = this.select(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	
	
	@Override
	public boolean delete(String id) {
		try{
				conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(Delete);			
			stmt.setString(1, id);
			int i = stmt.executeUpdate();
			if(i==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	

}
