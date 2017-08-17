package com.eeit95.her.controller.Admin;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import com.eeit95.her.model.advertisement.AdvertisementBean;
import com.eeit95.her.model.advertisement.MsgSelectAdvertisementBean;
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
import com.eeit95.her.model.font.MsgSelectWriterBean;
import com.eeit95.her.model.font.PriceRangeFontBean;
import com.eeit95.her.model.font.WriterBean;

import com.eeit95.her.model.gift.GiftDescriptionBean;
import com.eeit95.her.model.gift.GiftIUBean;
import com.eeit95.her.model.gift.GiftSelectBean;
import com.eeit95.her.model.gift.MsgSelectGiftBean;
import com.eeit95.her.model.misc.PrimitiveNumberEditor;
import com.eeit95.her.model.pack.MsgSelectPackBean;
import com.eeit95.her.model.pack.PackSelectBean;
import com.eeit95.her.model.service.AdminFontService;
import com.eeit95.her.model.service.AdminService;
import com.eeit95.her.model.service.AdminTagService;
import com.eeit95.her.model.service.CardService;
import com.eeit95.her.model.tag.MsgSelectTagBean;
import com.eeit95.her.model.tag.TagSelectBean;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService AS;

	@InitBinder
	public void initializePropertyEditor(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		webDataBinder.registerCustomEditor(double.class, new PrimitiveNumberEditor(Double.class, true));
		webDataBinder.registerCustomEditor(int.class, new PrimitiveNumberEditor(Integer.class, true));
	}
//------------------------------------------------------------------------------------------------------------------
	// card
	@RequestMapping(value = "/card", method = RequestMethod.GET , produces = "application/json")
	public @ResponseBody MsgSelectCardBean cardselect(CardSelectBean cardSelectBean) {
		System.out.println("cardSelectBean~~~ ="+cardSelectBean.toString());
		MsgSelectCardBean msg = new MsgSelectCardBean();
		msg.setMessage("Success");
		msg.setSuccess("true");
		msg.setData(AS.selectCard(cardSelectBean));
		System.out.println("setData~~~ ="+AS.selectCard(cardSelectBean).toString());
		System.out.println("setData~~~ ="+msg.toString());
		return msg;
	}
//新增
	@RequestMapping(value = "/card", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody MsgBean cardinsert(@RequestBody CardIUBean cardIUBean) {
		System.out.println("111111111111:" + cardIUBean.toString());

		MsgBean msg = new MsgBean();
		List<CardDescriptionBean> result1 = cardIUBean.getDescriptions();
		// 驗證資料
		if (cardIUBean.getCard().getId() != null ) {
			msg.setMessage("error");
			msg.setSuccess("false");
			return msg;
		}
		for (CardDescriptionBean bean : result1) {
			if (bean.getCardId() != null ) {
				msg.setMessage("error");
				msg.setSuccess("false");
				return msg;
			}
		}
		boolean result = AS.insert(cardIUBean);
		// 判斷回傳值是否正確
		if (result) {
			msg.setMessage("Success");
			msg.setSuccess("true");
		} else {
			msg.setMessage("error");
			msg.setSuccess("false");
		}
		return msg;
	}
//卡片更新
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
//-----------------------------------------------------------------------------------------------------
		// advertisement

		@RequestMapping(value = "/ad", method = RequestMethod.POST, consumes = "application/json", produces = "application/json") //
		public @ResponseBody MsgBean insert(@RequestBody AdvertisementBean bean) {
			MsgBean msg = new MsgBean();
			AdvertisementBean result = AS.insert(bean);

			if (result != null) {
				msg.setMessage("success");
				msg.setSuccess("true");
			} else {
				msg.setMessage("fail");
				msg.setSuccess("false");
			}
			return msg;
		}

		@RequestMapping(value = "/ad", method = RequestMethod.GET, produces = "application/json") //
		public @ResponseBody MsgSelectAdvertisementBean select(AdvertisementBean bean) {
			MsgSelectAdvertisementBean msgSelectAdvertisementBean = new MsgSelectAdvertisementBean();
			List<AdvertisementBean> result = AS.select(bean);

			msgSelectAdvertisementBean.setMessage("success");
			msgSelectAdvertisementBean.setSuccess("true");
			msgSelectAdvertisementBean.setData(result);

			return msgSelectAdvertisementBean;
		}

		@RequestMapping(value = "/ad", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json") //
		public @ResponseBody MsgBean update(@RequestBody AdvertisementBean bean) {
			MsgBean msg = new MsgBean();
			AdvertisementBean result = AS.update(bean);

			if (result != null) {
				msg.setMessage("success");
				msg.setSuccess("true");
			} else {
				msg.setMessage("fail");
				msg.setSuccess("false");
			}
			return msg;
		}

		// ---------------------------------------------------------------------------------------

		// Writer

		@RequestMapping(value = "/writer", method = RequestMethod.POST, consumes = "application/json", produces = "application/json") //
		public @ResponseBody MsgBean insert(@RequestBody WriterBean bean) {
			MsgBean msg = new MsgBean();
			WriterBean result = AS.insert(bean);
			if (result != null) {
				msg.setMessage("success");
				msg.setSuccess("true");
			} else {
				msg.setMessage("fail");
				msg.setSuccess("false");
			}

			return msg;
		}

		@RequestMapping(value = "/writer", method = RequestMethod.GET, produces = "application/json") //
		public @ResponseBody MsgSelectWriterBean select(WriterBean bean) {
			MsgSelectWriterBean msgSelectWriterBean = new MsgSelectWriterBean();
			List<WriterBean> result = AS.select(bean);

			msgSelectWriterBean.setMessage("success");
			msgSelectWriterBean.setSuccess("true");
			msgSelectWriterBean.setData(result);

			return msgSelectWriterBean;
		}

		@RequestMapping(value = "/writer", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json") //
		public @ResponseBody MsgBean update(@RequestBody WriterBean bean) {
			MsgBean msg = new MsgBean();
			WriterBean result = AS.update(bean);
			if (result != null) {
				msg.setMessage("success");
				msg.setSuccess("true");
			} else {
				msg.setMessage("fail");
				msg.setSuccess("false");
			}
			return msg;
		}

		// ---------------------------------------------------------------------------------------------------------

		// font

		@RequestMapping(value = "/font", method = RequestMethod.POST, consumes = "application/json", produces = "application/json") //
		public @ResponseBody MsgBean insert(@RequestBody FontIUBean fontIUBean) {

			System.out.println("========================================");

			System.out.println(fontIUBean.toString());
			MsgBean msg = new MsgBean();

			// if (fontIUBean.getFont().get(0).getId().length() == 0) {
			boolean result = AS.insert(fontIUBean);

			if (result) {
				msg.setMessage("success");
				msg.setSuccess("true");
			} else {
				msg.setMessage("fail");
				msg.setSuccess("false");
			}
			// } else {
			// msg.setMessage("fail");
			// msg.setSuccess("false");
			// }
			return msg;

			// WriterBean writerBean = new WriterBean();
			// int id = Integer.parseInt(writerId);
			// writerBean.setId(id);
			// fontBean.setWriterBean(writerBean);
			//
			// FontBean beanWithId = AS.insert(fontBean);
			// System.out.println(beanWithId.getId());
		}

		@RequestMapping(value = "/font", method = RequestMethod.GET, produces = "application/json") //
		public @ResponseBody MsgSelectFontBean select(PriceRangeFontBean priceRangeBean) {
			MsgSelectFontBean msfb = new MsgSelectFontBean();
			FontIUBean fontIUBean = new FontIUBean();
			List<FontBean> fontResults = null;
			System.out.println(priceRangeBean);
			System.out.println("id: " + priceRangeBean.getId());
			if (priceRangeBean.getId().length() != 0) {
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

		@RequestMapping(value = "/font", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json") //
		public @ResponseBody MsgBean update(@RequestBody FontIUBean fontIUBean) {

			MsgBean msg = new MsgBean();
			if (fontIUBean.getFont().get(0).getId().length() != 0) {
				boolean result = AS.update(fontIUBean);
				if (result) {
					msg.setMessage("success");
					msg.setSuccess("true");
				} else {
					msg.setMessage("fail");
					msg.setSuccess("false");
				}
			} else {
				msg.setMessage("fail");
				msg.setSuccess("false");
			}

			return msg;
		}


/*-------------------------------------------------------------------------------*/

	//Gift
	//新增 - insert (POST - 0815 TEST-OK)
	@RequestMapping(value = "/gift", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody MsgBean giftinsert(@RequestBody GiftIUBean giftIUBean) {
		System.out.println("insert測試1:" + giftIUBean.toString());

		MsgBean msg = new MsgBean();
		List<GiftDescriptionBean> result1 = giftIUBean.getDescriptions();
		// 驗證資料
		if (giftIUBean.getGift().getId() != null) {
			msg.setMessage("error");
			msg.setSuccess("false");
			return msg;
		}
		
		for (GiftDescriptionBean bean : result1) {
			if (bean.getGiftId() != null) {
				msg.setMessage("error");
				msg.setSuccess("false");
				return msg;
			}
		}
		boolean result = AS.insert(giftIUBean);
		// 判斷回傳值是否正確
		if (result) {
			msg.setMessage("success");
			msg.setSuccess("true");
		} else {
			msg.setMessage("error");
			msg.setSuccess("false");
		}
		return msg;
	}
	
	
	//修改 - update (PUT - 0815 TEST-OK)
	@RequestMapping(value = "/gift", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public @ResponseBody MsgBean giftupdate(@RequestBody GiftIUBean giftIUBean) {
		System.out.println("update測試1:" + giftIUBean.toString());
		MsgBean msg = new MsgBean();
		List<GiftDescriptionBean> result1 = giftIUBean.getDescriptions();
		
		// 驗證資料
		if (giftIUBean.getGift().getId() == null) {
			System.out.println("update測試2");
			msg.setMessage("error");
			msg.setSuccess("false");
			System.out.println("update測試3");
			return msg;
			
		}
		for (GiftDescriptionBean bean : result1) {
			if (bean.getGiftId() == null ) {
				System.out.println("bean.getGiftId() == null");
				msg.setMessage("error");
				msg.setSuccess("false");
				return msg;
			}else if(bean.getGiftId().length() == 0) {
				System.out.println("bean.getGiftId().length() == 0");
				msg.setMessage("error");
				msg.setSuccess("false");
				return msg;
			}
		}

		boolean result = AS.update(giftIUBean);
		
		// 判斷回傳值是否正確
		if (result) {
			System.out.println("boolean result = true");
			msg.setMessage("success");
			msg.setSuccess("true");
		} else {
			System.out.println("boolean result = false");
			msg.setMessage("error");
			msg.setSuccess("false");
		}
		return msg;
	}
	
	//複合式查詢 - select (GET - 0815 TEST-OK)
		@RequestMapping(value = "/gift", method = RequestMethod.GET , produces = "application/json")
		public @ResponseBody MsgSelectGiftBean giftselect(GiftSelectBean giftSelectBean) {
			System.out.println("giftSelectBean = " + giftSelectBean.toString());
			MsgSelectGiftBean msg = new MsgSelectGiftBean();
			msg.setMessage("success");
			msg.setSuccess("true");
			msg.setData(AS.selectGift(giftSelectBean));
			System.out.println("setData = " + AS.selectGift(giftSelectBean).toString());
			System.out.println("setData = " + msg.toString());
			return msg;
		}
		/*-------------------------------------------------------------------------------*/


		//複合式查詢 - select (GET)
		@RequestMapping(value = "/pack", method = RequestMethod.GET , produces = "application/json")
		public @ResponseBody MsgSelectPackBean packselect(PackSelectBean packSelectBean) {
			System.out.println("packSelectBean = " + packSelectBean.toString());
			MsgSelectPackBean msg = new MsgSelectPackBean();
			msg.setMessage("success");
			msg.setSuccess("true");
			msg.setData(AS.selectPack(packSelectBean));
			System.out.println("setData = " + msg.toString());
			return msg;
		}		
				

}
