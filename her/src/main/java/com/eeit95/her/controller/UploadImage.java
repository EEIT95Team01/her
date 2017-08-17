package com.eeit95.her.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadImage")
@MultipartConfig
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		Part filePart = request.getPart("cover");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		System.out.println(name);
		System.out.println(fileName);
		String path = "D:\\her\\Image\\" + name + fileType;

		InputStream is = filePart.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(is);
		OutputStream os = new FileOutputStream(path);
		BufferedOutputStream bos = new BufferedOutputStream(os);

		int data;
		while ((data = bis.read()) != -1) {
			bos.write(data);
		}
		bos.flush();
		bos.close();
		os.close();
		bis.close();
		is.close();

		request.setAttribute("success", "新增成功");

		request.getRequestDispatcher("test/uploadData.jsp").forward(request, response);

	}

}
