package com.eeit95.her.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.dao.card.CardDAOjdbc;

@WebServlet("/image/*")
public class ImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		String id = pathInfo.substring(1);
		String type = id.substring(0, 1);
		
		switch(type) {
			case "c":
				CardDAOjdbc cardDAOjdbc = new CardDAOjdbc();
				CardBean cardBean = cardDAOjdbc.select(id);
				response.setContentType("image");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
