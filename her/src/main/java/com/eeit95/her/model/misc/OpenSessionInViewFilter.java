package com.eeit95.her.model.misc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

@WebFilter(
		urlPatterns={"/*"}
)
public class OpenSessionInViewFilter implements Filter {
	//控制交易
	private SessionFactory sessionFactory = null;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext application = filterConfig.getServletContext();
		ApplicationContext context = (ApplicationContext)
				application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("into doFilter");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			System.out.println("Hibernate Transaction Begin");
			chain.doFilter(request, response);
			sessionFactory.getCurrentSession().getTransaction().commit();
			System.out.println("Hibernate Transaction commit");
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			System.out.println("Hibernate Transaction rollback");
			e.printStackTrace();
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		
	}
}
