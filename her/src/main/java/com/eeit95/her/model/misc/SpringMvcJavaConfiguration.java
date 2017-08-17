package com.eeit95.her.model.misc;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.XmlViewResolver;

@Configuration
@ComponentScan(basePackages={"com.eeit95.her.controller"})
@EnableWebMvc
public class SpringMvcJavaConfiguration extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new DemoHandlerInterceptor()).addPathPatterns("/view/*");
	}
	@Autowired
	private ServletContext application;
//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		XmlViewResolver viewResolver = new XmlViewResolver();
//		viewResolver.setLocation(
//				new ServletContextResource(application, "/WEB-INF/views.xml"));//利用views.xml去跳轉網頁
//		registry.viewResolver(viewResolver);
//	}
//	@Bean
//	 public ViewResolver jspViewResolver(){
//	  InternalResourceViewResolver  InternalviewResolver=new InternalResourceViewResolver();
//	      InternalviewResolver.setViewClass(JstlView.class);
//	      InternalviewResolver.setOrder(10);
//	     
//	  return InternalviewResolver;
//	  
//	 }
//	 
	 @Bean
	 public ViewResolver xmlViewResolver(){
		System.out.println("springMVC xmlViewResolver  into~~~~");
	  Resource resource=new ServletContextResource(application, "/WEB-INF/views.xml");
	  XmlViewResolver XMLviewResolver=new XmlViewResolver();
	      XMLviewResolver.setLocation(resource);
	      XMLviewResolver.setOrder(1);
	     
	  return XMLviewResolver;
	  
	 }
	
}
