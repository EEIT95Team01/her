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
			
//			OutputStream os = new FileOutputStream("C:\\Users\\Student\\Desktop\\aazzz.jpg");
			
			//byte[] b = bean.getCover();

//			byte[] data = b.getBytes(1, (int) b.length());
			//os.write(b, 0, b.length);
			//os.close();

		
			//os.write(b, 0, (int) b.length);

	
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
