package com.eeit95.her.controller.front;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardSBean;
import com.eeit95.her.model.card.CardSelectAllBean;
import com.eeit95.her.model.card.MsgSelectCardBean;
import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.font.FontIUBean;
import com.eeit95.her.model.font.FontSBean;
import com.eeit95.her.model.font.MsgSelectFontBean;
import com.eeit95.her.model.misc.PrimitiveNumberEditor;
import com.eeit95.her.model.service.CardService;
import com.eeit95.her.model.service.FontService;

@Controller
@RequestMapping("/user")
public class CardController {

	@Autowired
	private CardService cardService;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@InitBinder
	public void initializePropertyEditor(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		webDataBinder.registerCustomEditor(double.class, new PrimitiveNumberEditor(Double.class, true));
		webDataBinder.registerCustomEditor(int.class, new PrimitiveNumberEditor(Integer.class, true));
	}
	
	
	
	@RequestMapping(value = "/card", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody MsgSelectCardBean select(CardSBean cardSBean) {
		MsgSelectCardBean msg = new MsgSelectCardBean();
		System.out.println("CardSBean = "+cardSBean.toString());
		String cardId = cardSBean.getId();
		String cardnName = cardSBean.getName();
		String option = cardSBean.getOption();
		int tagId = cardSBean.getTagId();
		StringBuffer sqlText = new StringBuffer();
		sqlText.append("select c.id, c.name, c.price, c.cover from card as c");
		if (cardId == null) {
			if (tagId != 0) {
				sqlText.append(" join card_tag t on c.id  = t.cardId where t.tagId = " + tagId);
				if (cardnName!=null) {
					sqlText.append(" and");
				}
			}
//			}else {
//				sqlText.append(" where");
//			}
			
			if (cardnName!=null) {
				if(tagId == 0) {
					sqlText.append(" where");
				}
				sqlText.append(" c.name like '%" + cardnName + "%'");
			}
			if(option!=null) {
			switch (option) {
			case "ID_ASC":
				sqlText.append(" order by c.id");
				break;
			case "SALES_DESC":
				sqlText.append(" order by c.salesCount desc");
				break;
			case "PRICE_ASC":
				sqlText.append(" order by c.price");
				break;
			case "PRICE_DESC":
				sqlText.append(" order by c.price desc");
				break;
			default:
				sqlText.append(" order by c.id");
				break;
			}}else {
				sqlText.append(" order by c.id");
			}
		} else {
			sqlText.append(" where c.id = '" + cardId+"'");
		}
		System.out.println("sqlText = "+sqlText.toString());
		CardSelectAllBean cIUBean = new CardSelectAllBean();
		List<CardBean> cardBeans = new ArrayList<CardBean>();
		List<Map<String, Object>> results = jdbcTemplate.queryForList(sqlText.toString());
		if (!results.isEmpty()) {
			for (Map<String, Object> result : results) {
				CardBean cardBean = new CardBean();
				cardBean.setId((String) result.get("id"));
				cardBean.setCover((String) result.get("cover"));
				cardBean.setName((String) result.get("name"));
				cardBean.setPrice(((BigDecimal) result.get("price")).doubleValue());
				cardBeans.add(cardBean);
			}

			if (cardId == null) {
				cIUBean.setCard(cardBeans);
			} else {
				cIUBean.setCard(cardBeans);
				cIUBean.setTagIds(cardService.selectTagById(cardSBean));
				cIUBean.setDescriptions(cardService.selectDescById(cardSBean));
			}
			msg.setMessage("success");
			msg.setSuccess("true");
			msg.setData(cIUBean);
		}else {
			msg.setMessage("fail");
			msg.setSuccess("false");
			msg.setData(cIUBean);
		}

	

		return msg;
	}


}
