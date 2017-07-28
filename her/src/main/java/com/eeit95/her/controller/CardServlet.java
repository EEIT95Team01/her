package com.eeit95.her.controller;

import java.io.IOException;
import java.sql.Blob;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eeit95.her.model.img.dao.ImageBlob;



@SuppressWarnings("serial")
@WebServlet("/model/CardServlet.controller")
public class CardServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
//		String prodaction = request.getParameter("prodaction");
//		switch(prodaction) {
//		case "Select":
//			CardDAOjdbc cardDAO = new CardDAOjdbc();
//			List<CardBean> beans = cardDAO.selectAll();

//			request.setAttribute("beans", beans);
//			for(CardBean bean : beans){
//				System.out.println(bean);
//			}
//			break;
//		}
		//測試修改
		//接收資料

		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String temp1 = request.getParameter("price");
		String temp2 = request.getParameter("cover");
		String temp3 = request.getParameter("viewCount");
		String temp4 = request.getParameter("salesCount");
		String temp5 = request.getParameter("status");
		String manufacturer = request.getParameter("manufacturer");
		String temp6 = request.getParameter("cost");
		String temp7= request.getParameter("gpratio");
		String temp8 = request.getParameter("stock");
		String temp9 = request.getParameter("maxWordCount");
		String prodaction = request.getParameter("prodaction");
		
//轉換資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
		Long price=null;
		if(temp1!=null || temp1.length()!=0){
			try{
				price = Long.parseLong(temp1);
				if(price < 0 ) {
					errors.put("price", "price必須為正整數");
				}	
			}catch(NumberFormatException e){
				e.printStackTrace();
				errors.put("price", "price必須為正整數");
			}
		}

		Blob cover= null;
		if(temp2!=null || temp2.length()!=0){
			cover=ImageBlob.imgIn(temp2);
		}
		
		int viewCount=0;
		if(temp3!=null || temp3.length()!=0){
			
			
		}
		
		
//		int salesCount;
//		Boolean	status;
//		String manufacturer;
//		Long cost;
//		Long gpratio;
//		short stock;
//		short maxWordCount;
//		String temp4 = request.getParameter("salesCount");
//		String temp5 = request.getParameter("status");
//		String manufacturer = request.getParameter("manufacturer");
//		String temp6 = request.getParameter("cost");
//		String temp7= request.getParameter("gpratio");
//		String temp8 = request.getParameter("stock");
//		String temp9 = request.getParameter("maxWordCount");
//		String prodaction = request.getParameter("prodaction");
		//驗證資料
		//呼叫Model
		//根據Model執行結果，呼叫View
		request.getRequestDispatcher("/display.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
