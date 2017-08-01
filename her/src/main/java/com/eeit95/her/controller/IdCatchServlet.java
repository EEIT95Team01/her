package com.eeit95.her.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eeit95.her.model.dao.font.FontDAOHibernate;
import com.eeit95.her.model.font.FontBean;

@WebServlet("/IdCatchServlet")
public class IdCatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID = request.getParameter("Id");
		FontDAOHibernate dao = new FontDAOHibernate();
		FontBean fontBean = dao.selectById(ID);
		request.setAttribute("fontBean", fontBean);
		request.getRequestDispatcher("view/showPicture.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
