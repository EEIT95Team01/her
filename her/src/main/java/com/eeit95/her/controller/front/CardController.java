package com.eeit95.her.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.service.CardService;
import com.eeit95.her.model.service.FontService;

@Controller
@RequestMapping("/Card.controller")
public class CardController{

	
	@Autowired
	private CardService cardService;
	
//	@RequestMapping(method={RequestMethod.GET})
//	public String method( Model model,
//			@RequestParam(name="orderSelect") String option) {
//	
//		List<CardBean> beans = cardService.selectOrderBy(option);
//		model.addAttribute("CardBeans", beans);
//		model.addAttribute("orderSelect", option);
//		return "cards_select";
//	}

}
