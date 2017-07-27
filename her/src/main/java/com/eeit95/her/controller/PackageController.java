package com.eeit95.her.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eeit95.her.model.dao.pack.PackageDAOjdbc;
import com.eeit95.her.model.pack.PackageBean;

@WebServlet("/member/package")
public class PackageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		int statusM = 1, statusR = 2, statusO = 3;
		
		PackageDAOjdbc packageDAO = new PackageDAOjdbc();
		List<String> packageIdsM = packageDAO.getPackageIds(memberId, statusM);
		List<String> packageIdsR = packageDAO.getPackageIds(memberId, statusR);
		
		List<PackageBean> packageBeansM = new ArrayList<PackageBean>();
		for(String packageIdM : packageIdsM) {
			PackageBean packageBean = packageDAO.selectById(packageIdM);
			packageBeansM.add(packageBean);
		}
		
		List<PackageBean> packageBeansR = new ArrayList<PackageBean>();
		for(String packageIdR : packageIdsR) {
			PackageBean packageBean = packageDAO.selectById(packageIdR);
			packageBeansR.add(packageBean);
		}
		request.setAttribute("mailboxPackages", packageBeansM);
		request.setAttribute("repositoryPackages", packageBeansR);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/package.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
