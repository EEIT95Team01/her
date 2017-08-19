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
import com.eeit95.her.model.gift.GiftBean;
import com.eeit95.her.model.gift.GiftSBean;
import com.eeit95.her.model.gift.GiftSelectAllBean;
import com.eeit95.her.model.gift.MsgSelectGiftBean;
import com.eeit95.her.model.misc.PrimitiveNumberEditor;
import com.eeit95.her.model.service.CardService;
import com.eeit95.her.model.service.FontService;
import com.eeit95.her.model.service.GiftService;

@Controller
@RequestMapping("/user")
public class GiftController {

	@Autowired
	private GiftService giftService;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@InitBinder
	public void initializePropertyEditor(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		webDataBinder.registerCustomEditor(double.class, new PrimitiveNumberEditor(Double.class, true));
		webDataBinder.registerCustomEditor(int.class, new PrimitiveNumberEditor(Integer.class, true));
	}
	
	
	
	@RequestMapping(value = "/gift", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody MsgSelectGiftBean select(GiftSBean giftSBean) {
		MsgSelectGiftBean msg = new MsgSelectGiftBean();
		System.out.println("GiftSBean = "+giftSBean.toString());
		String giftId = giftSBean.getId();
		String giftnName = giftSBean.getName();
		String option = giftSBean.getOption();
		int tagId = giftSBean.getTagId();
		StringBuffer sqlText = new StringBuffer();
		sqlText.append("select g.id, g.name, g.price, g.cover from gift as g");
		if (giftId == null) {
			if (tagId != 0) {
				sqlText.append(" join gift_tag t on g.id  = t.giftId where t.tagId = " + tagId);
				if (giftnName!=null) {
					sqlText.append(" and");
				}
			}
//			}else {
//				sqlText.append(" where");
//			}
			
			if (giftnName!=null) {
				if(tagId == 0) {
					sqlText.append(" where");
				}
				sqlText.append(" g.name like '%" + giftnName + "%'");
			}
			if(option!=null) {
			switch (option) {
			case "ID_ASC":
				sqlText.append(" order by g.id");
				break;
			case "SALES_DESC":
				sqlText.append(" order by g.salesCount");
				break;
			case "PRICE_ASC":
				sqlText.append(" order by g.price");
				break;
			case "PRICE_DESC":
				sqlText.append(" order by g.price desc");
				break;
			default:
				sqlText.append(" order by g.id");
				break;
			}}else {
				sqlText.append(" order by g.id");
			}
		} else {
			sqlText.append(" where g.id = '" + giftId+"'");
		}
		System.out.println("sqlText = "+sqlText.toString());
		GiftSelectAllBean gIUBean = new GiftSelectAllBean();
		List<GiftBean> giftBeans = new ArrayList<GiftBean>();
		List<Map<String, Object>> results = jdbcTemplate.queryForList(sqlText.toString());
		if (!results.isEmpty()) {
			for (Map<String, Object> result : results) {
				GiftBean giftBean = new GiftBean();
				giftBean.setId((String) result.get("id"));
				giftBean.setCover((String) result.get("cover"));
				giftBean.setName((String) result.get("name"));
				giftBean.setPrice(((BigDecimal) result.get("price")).doubleValue());
				giftBeans.add(giftBean);
			}

			if (giftId == null) {
				gIUBean.setGift(giftBeans);
			} else {
				gIUBean.setGift(giftBeans);
				gIUBean.setTagIds(giftService.selectTagById(giftSBean));
				gIUBean.setDescriptions(giftService.selectDescById(giftSBean));
			}
			msg.setMessage("success");
			msg.setSuccess("true");
			msg.setData(gIUBean);
		}else {
			msg.setMessage("fail");
			msg.setSuccess("false");
			msg.setData(gIUBean);
		}

		// if("T3".equalsIgnoreCase(cardSelectBean.getId())||"T2".equalsIgnoreCase(cardSelectBean.getId()))
		// {
		// List<Map<String,Object>> datals = jdbcTemplate.queryForList("select top 3 *
		// from card order by id desc");
		// List<CardBean> cblist = new ArrayList<CardBean>();
		// CardSelectAllBean csAb = new CardSelectAllBean();
		// for(Map<String,Object> bean:datals) {
		// cardBean = new CardBean();
		// System.out.println("ID = "+bean.get("id")+" cover = "+bean.get("cover"));
		// System.out.println("name = "+bean.get("name")+" price = "+bean.get("price"));
		// cardBean.setId((String) bean.get("id"));
		// cardBean.setCover((String) bean.get("cover"));
		// cardBean.setName( (String) bean.get("name"));
		// cardBean.setPrice(((BigDecimal) bean.get("price")).doubleValue());
		// cblist.add(cardBean);
		// }
		// csAb.setCard(cblist);
		// msg.setData(csAb);

		return msg;
	}

//	@RequestMapping(method = { RequestMethod.GET })
//	public String method(Model model, @RequestParam(name = "orderSelect") String option) {
//
//		List<FontBean> beans = fontService.selectOrderBy(option);
//		model.addAttribute("fontBeans", beans);
//		model.addAttribute("orderSelect", option);
//		return "fonts.select";
//	}

}
