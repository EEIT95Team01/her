package com.eeit95.her.controller.front;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eeit95.her.model.dao.font.WriterDAOHibernate;
import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.font.WriterBean;
import com.eeit95.her.model.service.FindWriterService;
import com.eeit95.her.model.service.ImageService;

@Controller
@RequestMapping("/admin/FindWriter.do")
public class FindWriter extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Autowired
	private FindWriterService FWS;

	@RequestMapping
	public String method(Model model) throws IOException {
	
		List<WriterBean> list = FWS.selectAll();
		model.addAttribute("writers", list);
		return "writers.select";
	}

}
