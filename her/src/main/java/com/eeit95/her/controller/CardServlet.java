package com.eeit95.her.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eeit95.her.model.card.cardBean;
import com.eeit95.her.model.dao.card.CardDAOJdbc;



@SuppressWarnings("serial")
@WebServlet("/model/CardServlet.controller")
public class CardServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String prodaction = request.getParameter("prodaction");
		switch(prodaction) {
		case "Select":
			CardDAOJdbc cardDAO = new CardDAOJdbc();
			List<cardBean> beans = cardDAO.select();
			request.setAttribute("beans", beans);
			for(cardBean bean : beans){
				System.out.println(bean);
			}
			break;
		}
		//測試修改
		//接收資料
//		
//		String cardNo = request.getParameter("cardNo");
//		String cardName = request.getParameter("cardName");
//		String temp3 = request.getParameter("cardPrice");
//		String temp4 = request.getParameter("cardCost");
//		String temp5= request.getParameter("cardGrossProfit");
//		String cardManufactory = request.getParameter("cardManufactory");
//		String temp6 = request.getParameter("cardMaxWordCount");
//		String temp7 = request.getParameter("cardImage");
//		String temp8 = request.getParameter("cardStock");
//		String temp9 = request.getParameter("cardViewCount");
//		String temp10 = request.getParameter("cardSalesCount");
//		String temp11 = request.getParameter("cardStatus");
//		String prodaction = request.getParameter("prodaction");
//		
////轉換資料
//		Map<String, String> errors = new HashMap<String, String>();
//		request.setAttribute("errors", errors);
//		int cardId=0;
//		if(temp3!=null || temp3.length()!=0){
//			try{
//				cardId = Integer.parseInt(temp3);
//			}catch(NumberFormatException e){
//				e.printStackTrace();
//				errors.put("cardPrice", "cardPrice必須為正數");
//			}
//		}
//		
		
//		String temp1 = request.getParameter("cardId");int cardId;
//		int cardNo;
//		String cardName;
//		int cardPrice;
//		Double cardCost;
//		Double cardGrossProfit;
//		String cardManufactory;
//		int cardMaxWordCount;
//		Blob cardImage;
//		short cardStock;
//		int cardViewCount;
//		int cardSalesCount;
//		Boolean cardStatus;
//		String temp2 = request.getParameter("cardNo");
//		String cardName = request.getParameter("cardName");
//		String temp3 = request.getParameter("cardPrice");
//		String temp4 = request.getParameter("cardCost");
//		String temp5= request.getParameter("cardGrossProfit");
//		String cardManufactory = request.getParameter("cardManufactory");
//		String temp6 = request.getParameter("cardMaxWordCount");
//		String temp7 = request.getParameter("cardImage");
//		String temp8 = request.getParameter("cardStock");
//		String temp9 = request.getParameter("cardViewCount");
//		String temp10 = request.getParameter("cardSalesCount");
//		String temp11 = request.getParameter("cardStatus");
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
