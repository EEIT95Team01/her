package com.eeit95.her.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eeit95.her.model.dao.font.FontDAOHibernate;
import com.eeit95.her.model.font.FontBean;

@WebServlet("/font")
public class FontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		FontDAOHibernate fontDAO = new FontDAOHibernate();
		List<FontBean> fontBeans = fontDAO.selectAll();
		
		request.setAttribute("fontBeans", fontBeans);
		
		RequestDispatcher rd = request.getRequestDispatcher("/font/fontpage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
