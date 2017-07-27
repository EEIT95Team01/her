package com.eeit95.her.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eeit95.her.model.dao.font.FontDAOjdbc;
import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.img.dao.ImageBlob;

/**
 * Servlet implementation class ShowPictureServlet
 */
@WebServlet("/ShowPictureServlet/*")
public class ShowPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// String[] pics = {"autumn_fs.jpg" , "fs.jpg", "m001.jpg"};
		// int num = (int)(Math.random() * pics.length) + 0;
		// // deployDir: 本應用系統在伺服器內的部署資料夾
		// String deployDir = getServletContext().getRealPath("/");
		// // imageDir : 存放圖片檔的資料夾，它位於部署資料夾之下的images資料夾
		// String imageDir = deployDir + "\\images\\" ;
		// InputStream is = new FileInputStream(imageDir + pics[num]);
		String ID = (String) request.getPathInfo().substring(1);
		System.out.println(ID);
		try {
			
			FontDAOjdbc dao = new FontDAOjdbc();
			FontBean bean = dao.findByPrimaryKey(ID);
			response.setContentType("image/jpeg");
			OutputStream os = response.getOutputStream();
			Blob b = bean.getCover();
			byte[] data = b.getBytes(1, (int) b.length());
			os.write(data, 0, (int) b.length());
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
