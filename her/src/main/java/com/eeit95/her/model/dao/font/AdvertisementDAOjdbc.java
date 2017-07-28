package com.eeit95.her.model.dao.font;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eeit95.her.model.font.AdvertisementBean;
import com.eeit95.her.model.font.AdvertisementDAOInterface;
import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.img.dao.ImageToBytes;

public class AdvertisementDAOjdbc implements AdvertisementDAOInterface {

	String url = "jdbc:sqlserver://localhost:1433;databaseName=her";
	String username = "sa";
	String password = "sa123456";
	private static final String INSERT = "insert into advertisement ( name, image, beginDate, endDate)"
			+ "values ( ?, ?, ?, ?)";
	private static final String UPDATE = "update advertisement set name=?,"
			+ "image=?,beginDate=?,endDate=? where id = ?";
	private static final String DELETE = "delete from advertisement where id = ?";
	private static final String SELECT = "select * from advertisement where id = ?";
	private static final String SELECT_DATE = "select * from advertisement where GETDATE() BETWEEN [beginDate] AND [endDate] ";
	private static final String SELECT_ALL = "select * from advertisement";

	@Override
	public void insert(AdvertisementBean advertisementBean) {
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement stmt = conn.prepareStatement(INSERT)) {

			if (advertisementBean != null) {
				stmt.setString(1, advertisementBean.getName());
				stmt.setBytes(2, advertisementBean.getImage());
				stmt.setDate(3, advertisementBean.getBeginDate());
				stmt.setDate(4, advertisementBean.getEndDate());

				int n = stmt.executeUpdate();
				System.out.println(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(AdvertisementBean advertisementBean) {
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement stmt = conn.prepareStatement(UPDATE)) {

			if (advertisementBean != null) {
				stmt.setString(1, advertisementBean.getName());
				stmt.setBytes(2, advertisementBean.getImage());
				stmt.setDate(3, advertisementBean.getBeginDate());
				stmt.setDate(4, advertisementBean.getEndDate());
				stmt.setInt(5, advertisementBean.getId());
				int n = stmt.executeUpdate();
				System.out.println(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		try (Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement stmt = conn.prepareStatement(DELETE)) {

			stmt.setInt(1, id);
			int n = stmt.executeUpdate();
			System.out.println(n);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public AdvertisementBean selectById(int id) {
		AdvertisementBean Abean = null;
		ResultSet rs = null;
		try( Connection conn = DriverManager.getConnection(url, username, password); 
				PreparedStatement stmt = conn.prepareStatement(SELECT))  {
			
				stmt.setInt(1, id);
				rs = stmt.executeQuery();
				
				if(rs.next()){
					Abean = new AdvertisementBean();
					Abean.setId(rs.getInt("id"));
					Abean.setName(rs.getString("name"));
					Abean.setImage(rs.getBytes("image"));
					Abean.setBeginDate(rs.getDate("beginDate"));
					Abean.setEndDate(rs.getDate("endDate"));
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return Abean;
	}

	@Override
	public List<AdvertisementBean> selectByDate() {
		List<AdvertisementBean> list = null;
		ResultSet rs = null;
		try( Connection conn = DriverManager.getConnection(url, username, password);
			 PreparedStatement pstmt = conn.prepareStatement(SELECT_DATE))  {
			rs = pstmt.executeQuery();
			
			list = new ArrayList<AdvertisementBean>();
			while(rs.next()) {
				AdvertisementBean Abean = new AdvertisementBean();
				Abean.setId(rs.getInt("id"));
				Abean.setName(rs.getString("name"));
				Abean.setImage(rs.getBytes("image"));
				Abean.setBeginDate(rs.getDate("beginDate"));
				Abean.setEndDate(rs.getDate("endDate"));
				list.add(Abean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<AdvertisementBean> selectAll() {
		List<AdvertisementBean> list = null;
		ResultSet rs = null;
		try( Connection conn = DriverManager.getConnection(url, username, password);
			 PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL))  {
			rs = pstmt.executeQuery();
			
			list = new ArrayList<AdvertisementBean>();
			while(rs.next()) {
				AdvertisementBean Abean = new AdvertisementBean();
				Abean.setId(rs.getInt("id"));
				Abean.setName(rs.getString("name"));
				Abean.setImage(rs.getBytes("image"));
				Abean.setBeginDate(rs.getDate("beginDate"));
				Abean.setEndDate(rs.getDate("endDate"));
				list.add(Abean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {

		AdvertisementDAOjdbc dao = new AdvertisementDAOjdbc();

		AdvertisementBean advertisementBean = new AdvertisementBean();
		//advertisementBean.setId(123);
		advertisementBean.setName("AAAA");
		advertisementBean.setImage(ImageToBytes.imgIn("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg"));
		advertisementBean.setBeginDate(new Date(2015-06-23));
		advertisementBean.setEndDate(new Date(2015-12-23));
		dao.insert(advertisementBean);
//		dao.delete(2);
		List<AdvertisementBean> test = null;
		test = dao.selectAll();
		for(AdvertisementBean bean : test) {
			System.out.print(bean.getId()+",\t");
			System.out.print(bean.getName()+",\t");
			System.out.print(bean.getImage()+",\t");
			System.out.print(bean.getBeginDate()+",\t");
			System.out.print(bean.getEndDate()+",\n");
			
		}
	}

}
