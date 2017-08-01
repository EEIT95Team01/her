package com.eeit95.her.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eeit95.her.model.dao.font.FontDAOHibernate;
import com.eeit95.her.model.font.FontBean;


@WebServlet("/ShowPictureServlet/*")
public class ShowPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ID = (String) request.getPathInfo().substring(1);
		System.out.println(ID);
		try {
			
			FontDAOHibernate dao = new FontDAOHibernate();
			FontBean bean = dao.selectById(ID);
			String path = bean.getCover();
			String type = path.substring(path.lastIndexOf("."));
			switch (type) {
			case "png":
				response.setContentType("png");
			case "jpg":
				response.setContentType("image/jpeg");
			case "jpeg":
				response.setContentType("image/jpeg");
			case "gif":
				response.setContentType("image/gif");
			}
			
			InputStream is = new FileInputStream(path);
			BufferedInputStream bis = new BufferedInputStream(is);
			OutputStream os = response.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			int data;
			
			while((data=bis.read())!= -1) {
				bos.write(data);
			}
			bos.close();
			os.close();
			bis.close();
			is.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
