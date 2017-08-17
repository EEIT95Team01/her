package com.eeit95.her.model.member;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN")
public class AdminUserBean implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private Integer authorityId;
	@Override
	public String toString() {
		return "AdminBean [id=" + id + ", username=" + username + ", password=" + password + ", authorityId="
				+ authorityId + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}
	
	
//	//以下為Hibernate測試程式 
//	public static void main(String args[]){
//		
//		try {
//			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//			Session session=HibernateUtil.getSessionFactory().getCurrentSession();
//
////insert
////			MemberBean insert = new MemberBean();
////			insert.setId("M0804");
////			insert.setEmail("xxx@abc.com");
////			insert.setPassword("xxx");
////			insert.setName("xxx");
////			insert.setPhone("123");
////			insert.setCity("xyz");
////			insert.setDistrict("abc");
////			insert.setAddr("ijk");
////			insert.setBirthday(java.sql.Date.valueOf("1999-9-9"));
////			session.save(insert);
//			
////update 
////			MemberBean update = (MemberBean) session.get(MemberBean.class, "M0804");
////			update.setEmail("xxx@abc.com");
////			update.setPassword("xxx");
////			update.setName("ooo");
////			update.setPhone("123");
////			update.setCity("xyz");
////			update.setDistrict("abc");
////			update.setAddr("ijk");
////			update.setBirthday(java.sql.Date.valueOf("1999-9-9"));
////			session.save(update);
//			
//			
//			//delete
////			MemberBean delete = (MemberBean) session.get(MemberBean.class,"M0804");
////			session.delete(delete);
//			
//			//select
//			MemberBean select = (MemberBean) session.get(MemberBean.class,"M0804");
//			System.out.println(select.getId());
//			System.out.println(select.getName());			
//			
//			
//			
//			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		} catch (HibernateException e) {
//			e.printStackTrace();
//		}
//	}

}