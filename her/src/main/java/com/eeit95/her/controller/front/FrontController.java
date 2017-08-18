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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardDescriptionBean;
import com.eeit95.her.model.card.CardIUBean;
import com.eeit95.her.model.card.CardSelectAllBean;
import com.eeit95.her.model.card.CardSelectBean;
import com.eeit95.her.model.card.MsgBean;
import com.eeit95.her.model.card.MsgSelectCardBean;
import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.font.FontIUBean;
import com.eeit95.her.model.font.MsgSelectFontBean;
import com.eeit95.her.model.font.PriceRangeFontBean;
import com.eeit95.her.model.gift.GiftBean;
import com.eeit95.her.model.gift.GiftSelectAllBean;
import com.eeit95.her.model.gift.GiftSelectBean;
import com.eeit95.her.model.gift.MsgSelectGiftBean;
import com.eeit95.her.model.misc.PrimitiveNumberEditor;
import com.eeit95.her.model.service.AdminService;
import com.eeit95.her.model.service.CardService;
import com.eeit95.her.model.service.FontService;
import com.eeit95.her.model.service.FrontTopService;

@Controller
@RequestMapping("/front")
public class FrontController {
	@Autowired
	private CardService cardService;
	@Autowired
	private AdminService AS;
	@Autowired
	private FrontTopService FTS;
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@InitBinder
	public void initializePropertyEditor(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		webDataBinder.registerCustomEditor(double.class, new PrimitiveNumberEditor(Double.class, true));
		webDataBinder.registerCustomEditor(int.class, new PrimitiveNumberEditor(Integer.class, true));
	}
//CARD
	@RequestMapping(value = "/card", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody MsgSelectCardBean cardselect(CardSelectBean cardSelectBean) {
		System.out.println("cardSelectBean~~~ =" + cardSelectBean.toString());
		MsgSelectCardBean msg = new MsgSelectCardBean();
		CardBean cardBean = null;
		msg.setMessage("Success");
		msg.setSuccess("true");
		List<Map<String, Object>> datals = null;
		if ("T3".equalsIgnoreCase(cardSelectBean.getId()) || "T2".equalsIgnoreCase(cardSelectBean.getId())) {
			if ("T3".equalsIgnoreCase(cardSelectBean.getId())) {
				datals = jdbcTemplate.queryForList("select top 3 * from card order by id desc");
			}
			if ("T2".equalsIgnoreCase(cardSelectBean.getId())) {
				datals = jdbcTemplate.queryForList("select top 2 * from card order by viewCount desc");
			}
			List<CardBean> cblist = new ArrayList<CardBean>();
			CardSelectAllBean csAb = new CardSelectAllBean();
			for (Map<String, Object> bean : datals) {
				cardBean = new CardBean();
				System.out.println("ID = " + bean.get("id") + " cover = " + bean.get("cover"));
				System.out.println("name = " + bean.get("name") + " price = " + bean.get("price"));
				cardBean.setId((String) bean.get("id"));
				cardBean.setCover((String) bean.get("cover"));
				cardBean.setName((String) bean.get("name"));
				cardBean.setPrice(((BigDecimal) bean.get("price")).doubleValue());
				cblist.add(cardBean);
			}
			csAb.setCard(cblist);
			msg.setData(csAb);
		} else {
			msg.setData(AS.selectCard(cardSelectBean));
		}

		System.out.println("setData~~~ =" + msg.toString());
		return msg;
	}
	//------------------------------------------------------------------------------------------------------//
	// font
	@RequestMapping(value = "/font", method = RequestMethod.GET, produces = "application/json") //
	public @ResponseBody MsgSelectFontBean select(PriceRangeFontBean priceRangeBean) {
		MsgSelectFontBean msfb = new MsgSelectFontBean();
		FontIUBean fontIUBean = new FontIUBean();
		List<Map<String, Object>> datals = null;
		List<FontBean> fontResults = null;
		System.out.println(priceRangeBean);
		System.out.println("id: " + priceRangeBean.getId());
		if (priceRangeBean.getId().length() != 0) {
			if("T1".equalsIgnoreCase(priceRangeBean.getId())||"T2".equalsIgnoreCase(priceRangeBean.getId())) {
				if ("T1".equalsIgnoreCase(priceRangeBean.getId())) {
					datals = jdbcTemplate.queryForList("select top 1 * from font order by viewCount desc");
				}
				if ("T2".equalsIgnoreCase(priceRangeBean.getId())) {
					datals = jdbcTemplate.queryForList("select top 2 * from font order by id desc");
				}
				List<FontBean> cblist = new ArrayList<FontBean>();
				FontIUBean csAb = new FontIUBean();
				FontBean fontBean =null;
				for (Map<String, Object> bean : datals) {
					fontBean = new FontBean();
					System.out.println("ID = " + bean.get("id") + " cover = " + bean.get("cover"));
					System.out.println("name = " + bean.get("name") + " price = " + bean.get("price"));
					fontBean.setId((String) bean.get("id"));
					fontBean.setCover((String) bean.get("cover"));
					fontBean.setName((String) bean.get("name"));
					fontBean.setPrice(((BigDecimal) bean.get("price")).doubleValue());
					cblist.add(fontBean);
				}
				csAb.setFont(cblist);
				msfb.setData(csAb);
			}else {
			fontResults = AS.select(priceRangeBean);
			if (!fontResults.isEmpty()) {
				// FontBean fontResult = fontResults.get(0);
				fontIUBean.setFont(fontResults);
				fontIUBean.setTagIds(AS.selectTagById(priceRangeBean));
				fontIUBean.setDescriptions(AS.selectDescById(priceRangeBean));
				msfb.setMessage("select by id");
				msfb.setSuccess("true");
				msfb.setData(fontIUBean);
			} else {
				System.out.println("fontResults is empty!!!");
				msfb.setMessage("fontResults is empty!!!");
				msfb.setSuccess("true");
				msfb.setData(fontIUBean);
			}
			}
		} else {
			fontResults = AS.select(priceRangeBean);
			if (!fontResults.isEmpty()) {
				fontIUBean.setFont(fontResults);
				msfb.setMessage("select by condition!!!");
				msfb.setSuccess("true");
				msfb.setData(fontIUBean);
			} else {
				System.out.println("fontResults is empty!!!");
				msfb.setMessage("fontResults is empty!!!");
				msfb.setSuccess("true");
				msfb.setData(fontIUBean);
			}
		}
		
		return msfb;
	}
	//------------------------------------------------------------------------------------------------------//
	//gift
	@RequestMapping(value = "/gift", method = RequestMethod.GET , produces = "application/json")
	public @ResponseBody MsgSelectGiftBean giftselect(GiftSelectBean giftSelectBean) {
		System.out.println("giftSelectBean = " + giftSelectBean.toString());
		MsgSelectGiftBean msg = new MsgSelectGiftBean();
		msg.setMessage("success");
		msg.setSuccess("true");
		List<Map<String, Object>> datals = null;
		if ("T5".equalsIgnoreCase(giftSelectBean.getId()) || "T4".equalsIgnoreCase(giftSelectBean.getId())) {
			if ("T5".equalsIgnoreCase(giftSelectBean.getId())) {
				datals = jdbcTemplate.queryForList("select top 5 * from gift order by id desc");
			}
			if ("T4".equalsIgnoreCase(giftSelectBean.getId())) {
				datals = jdbcTemplate.queryForList("select top 4 * from gift order by viewCount desc");
			}
			List<GiftBean> cblist = new ArrayList<GiftBean>();
			GiftSelectAllBean csAb = new GiftSelectAllBean();
			GiftBean giftBean = null;
			for (Map<String, Object> bean : datals) {
				giftBean = new GiftBean();
				System.out.println("ID = " + bean.get("id") + " cover = " + bean.get("cover"));
				System.out.println("name = " + bean.get("name") + " price = " + bean.get("price"));
				giftBean.setId((String) bean.get("id"));
				giftBean.setCover((String) bean.get("cover"));
				giftBean.setName((String) bean.get("name"));
				giftBean.setPrice(((BigDecimal) bean.get("price")).doubleValue());
				cblist.add(giftBean);
			}
			csAb.setGift(cblist);
			msg.setData(csAb);
		} else {
		msg.setData(AS.selectGift(giftSelectBean));
		}
		System.out.println("setData = " + AS.selectGift(giftSelectBean).toString());
		System.out.println("setData = " + msg.toString());
		return msg;
	}
	//----------------------------------------------------------------------------------------------//
	//viewcount+1
	@RequestMapping(value = "/card", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public @ResponseBody MsgBean cardupdate(@RequestBody CardIUBean cardIUBean) {
		System.out.println("111111111111:" + cardIUBean.toString());
		MsgBean msg = new MsgBean();
		List<CardDescriptionBean> result1 = cardIUBean.getDescriptions();
		// 驗證資料
		if (cardIUBean.getCard().getId() == null || cardIUBean.getCard().getId().length() == 0) {
			System.out.println("222222222222");
			msg.setMessage("error");
			msg.setSuccess("false");
			System.out.println("333333333333");
			return msg;
			
		}
		for (CardDescriptionBean bean : result1) {
			if (bean.getCardId() == null ) {
				System.out.println("bean.getCardId() == null");
				msg.setMessage("error");
				msg.setSuccess("false");
				return msg;
			}else if(bean.getCardId().length() == 0) {
				System.out.println("bean.getCardId().length() == 0");
				msg.setMessage("error");
				msg.setSuccess("false");
				return msg;
			}
		}
		boolean result = AS.update(cardIUBean);
		// 判斷回傳值是否正確
		if (result) {
			System.out.println("boolean result = true");
			msg.setMessage("Success");
			msg.setSuccess("true");
		} else {
			System.out.println("boolean result = false");
			msg.setMessage("error");
			msg.setSuccess("false");
		}
		return msg;
	}
	
}
