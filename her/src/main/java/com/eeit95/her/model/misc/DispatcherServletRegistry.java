package com.eeit95.her.model.misc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletRegistry extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringMvcJavaConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/member/*","/admin/*","/user/*"};
		//有哪些controller要給DispatcherServlet管
	}

}
