package com.eeit95.her.model.member;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER")
public class MemberBean implements java.io.Serializable{
	@Id
	@Column(name = "id")
	private String id;
	private String email;
	private String password;
	private String name;
	private String phone;
	private String city;
	private String district;
	private String addr;
	private java.sql.Date birthday;
	
//	@OneToMany(mappedBy="memberbean")
//	private Set<RecipientBean> rbs = new HashSet<RecipientBean>();

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
	
	public MemberBean(){		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	public java.sql.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "MemberBean [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", phone="
				+ phone + ", city=" + city + ", district=" + district + ", addr=" + addr + ", birthday=" + birthday
				+ "]";
	}
	
	//註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
	//註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【目前deptVO是EmpVO的一個屬性】
	//註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
	//FetchType.EAGER : Defines that data must be eagerly fetched
	//FetchType.LAZY  : Defines that data can be lazily fetched
//	public Set<RecipientBean> getRbs() {
//		return rbs;
//	}
//	public void setRbs(Set<RecipientBean> rbs) {
//		this.rbs = rbs;
//	}



}