package com.eeit95.her.model.misc;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import com.eeit95.her.model.advertisement.AdvertisementBean;
import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardDescriptionBean;
import com.eeit95.her.model.card.CardTagBean;
import com.eeit95.her.model.category.CategoryBean;
import com.eeit95.her.model.category.CategoryMainBean;
import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.font.FontDescriptionBean;
import com.eeit95.her.model.font.FontTagBean;
import com.eeit95.her.model.font.WriterBean;
import com.eeit95.her.model.gift.GiftBean;
import com.eeit95.her.model.gift.GiftDescriptionBean;
import com.eeit95.her.model.gift.GiftTagBean;
import com.eeit95.her.model.member.AdminUserBean;
import com.eeit95.her.model.member.CollectionBean;
import com.eeit95.her.model.member.MemberBean;
import com.eeit95.her.model.member.RecipientBean;
import com.eeit95.her.model.pack.PackBean;
import com.eeit95.her.model.pack.PackStatusBean;
import com.eeit95.her.model.tag.TagBean;

@Configuration
@ComponentScan( "com.eeit95.her")
public class SpringJavaConfiguration {
	@Bean
	public DataSource dataSource() {
//		DriverManagerDataSource dmds = new DriverManagerDataSource();
//		dmds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		dmds.setUrl("jdbc:sqlserver://localhost:1433;database=her");
//		dmds.setUsername("sa");
//		dmds.setPassword("sa123456");
//		return dmds;
//		
		DataSource dataSource=null;
		try {
			Context tx = new InitialContext();
			dataSource = (DataSource) tx.lookup("java:/comp/env/jdbc/her");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataSource;
	}
	@Bean
	public SessionFactory sessionFactory() {
		System.out.println("sessionFactorysessionFactorysessionFactorysessionFactory");
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
		Properties prop= new Properties();
		prop.put("hibernate.dialect","org.hibernate.dialect.SQLServerDialect");
		prop.put("hibernate.current_session_context_class","thread");
		prop.put("hibernate.show_sql", "true");
		builder.addProperties(prop);
		
		builder.addAnnotatedClasses(CardBean.class,CardDescriptionBean.class,CardTagBean.class,
				TagBean.class,AdvertisementBean.class,FontBean.class,FontDescriptionBean.class,
				FontTagBean.class,WriterBean.class,CardBean.class,CategoryMainBean.class,CategoryBean.class,
				GiftBean.class,GiftDescriptionBean.class,GiftTagBean.class,PackStatusBean.class,MemberBean.class,
				RecipientBean.class,AdminUserBean.class,CollectionBean.class,PackBean.class);
		
		return builder.buildSessionFactory();
		
	}
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		
		return jdbcTemplate;
	}
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
		return namedParameterJdbcTemplate;
	}
	
	
}
