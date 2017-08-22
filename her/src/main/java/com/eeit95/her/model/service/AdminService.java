package com.eeit95.her.model.service;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.eeit95.her.model.advertisement.AdvertisementBean;
import com.eeit95.her.model.advertisement.AdvertisementDAOInterface;
import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardDAOInterface;
import com.eeit95.her.model.card.CardDescriptionBean;
import com.eeit95.her.model.card.CardDescriptionDAOInterface;
import com.eeit95.her.model.card.CardIUBean;
import com.eeit95.her.model.card.CardSelectAllBean;
import com.eeit95.her.model.card.CardSelectBean;
import com.eeit95.her.model.card.CardTagBean;
import com.eeit95.her.model.card.CardTagInterface;
import com.eeit95.her.model.dao.font.FontDAOHibernate;
import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.font.FontDAOInterface;
import com.eeit95.her.model.font.FontDescriptionBean;
import com.eeit95.her.model.font.FontDescriptionDAOInterface;
import com.eeit95.her.model.font.FontIUBean;
import com.eeit95.her.model.font.FontTagBean;
import com.eeit95.her.model.font.FontTagDAOInterface;
import com.eeit95.her.model.font.PriceRangeFontBean;
import com.eeit95.her.model.font.WriterBean;
import com.eeit95.her.model.font.WriterDAOInterface;
import com.eeit95.her.model.gift.GiftBean;
import com.eeit95.her.model.gift.GiftDAOInterface;
import com.eeit95.her.model.gift.GiftDescriptionBean;
import com.eeit95.her.model.gift.GiftDescriptionDAOInterface;
import com.eeit95.her.model.gift.GiftIUBean;
import com.eeit95.her.model.gift.GiftSelectAllBean;
import com.eeit95.her.model.gift.GiftSelectBean;
import com.eeit95.her.model.gift.GiftTagBean;
import com.eeit95.her.model.gift.GiftTagDAOInterface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;
import com.eeit95.her.model.pack.PackBean;
import com.eeit95.her.model.pack.PackDAOInterface;
import com.eeit95.her.model.pack.PackSelectBean;

@Service
public class AdminService {

	// ApplicationContext context = new
	// AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
	// SessionFactory sessionFactory = (SessionFactory)
	// context.getBean("sessionFactory");

	@Autowired
	private CardDAOInterface card;
	@Autowired
	private CardTagInterface cardTag;
	@Autowired
	private CardDescriptionDAOInterface cardDesc;
	
	@Autowired
	private FontDAOInterface font;
	@Autowired
	private FontTagDAOInterface fontTag;
	@Autowired
	private FontDescriptionDAOInterface fontDesc;
	@Autowired
	private WriterDAOInterface writer;
	@Autowired
	private AdvertisementDAOInterface advertisement;
	
	@Autowired
	private GiftDAOInterface gift;
	@Autowired
	private GiftTagDAOInterface giftTag;
	@Autowired
	private GiftDescriptionDAOInterface giftDesc;
	
	@Autowired
	private PackDAOInterface pack;	
		

/*-----------------------------------------------------------------------------------------------------------------------------------*/
	// Card
	public CardSelectAllBean selectCard(CardSelectBean cardSelectBean) {
		System.out.println("進入Select Service");
		CardSelectAllBean bean = new CardSelectAllBean();
		List<CardBean> list = new ArrayList<CardBean>();
		if(cardSelectBean.getId()!=null&&cardSelectBean.getId().length()!=0) {
			System.out.println("進入Select Service-1");
			list=card.selectAllFM(cardSelectBean);
			System.out.println(list.toString());
			bean.setCard(list);
			if(!list.isEmpty()) {
			System.out.println("進入Select Service-2");
			List<CardTagBean> tagBeans = cardTag.selectBycardId(cardSelectBean.getId());
			 System.out.println("tagBeans.get(0) = "+tagBeans.get(0));
			 String[] tagIds = new String[tagBeans.size()];
			for(CardTagBean bean1:tagBeans ) {
				tagIds[tagBeans.indexOf(bean1)] = bean1.toString();
			}
			bean.setTagIds(tagIds);
			bean.setDescriptions(cardDesc.selectById(cardSelectBean.getId()));
			}
		}else {
			System.out.println("進入SelectAll Service-1");
			bean.setCard(card.selectAllFM(cardSelectBean));
		}
		return bean;
	}

	public boolean insert(CardIUBean cardIUBean) {
		String Id = card.getNewId();
		CardBean result1 = new CardBean();
		CardTagBean result2 = null;
		List<CardDescriptionBean> result3 = new ArrayList<CardDescriptionBean>();
		List<CardTagBean> result4 = new ArrayList<CardTagBean>();
		List<CardDescriptionBean> result5 = null;
		List<CardTagBean> result6 = null;
		List<CardDescriptionBean> result7 = cardIUBean.getDescriptions();
		if (cardIUBean != null) {
			cardIUBean.getCard().setId(Id);
			System.out.println(cardIUBean.getCard().getId());
			result1 = card.insert(cardIUBean.getCard());
			
			for (int i = 0; i < cardIUBean.getTagIds().length; i++) {
				result2 = new CardTagBean();
				result2.setCardId(cardIUBean.getCard().getId());
				result2.setTagId(Integer.parseInt(cardIUBean.getTagIds()[i]));
				System.out.println(result2.getTagId());
				result4.add(result2);
			}
			for (CardDescriptionBean bean : result7) {
				bean.setCardId(Id);
			}
			// System.out.println("55555555555555555555555:");
			result6 = cardTag.insert(result4);
			result5 = cardDesc.insert(cardIUBean.getDescriptions());
			if (result1 != null && result5 != null && result6 != null) {
				return true;
			}
		}
		return false;
	}

	public boolean update(CardIUBean cardIUBean) {
		CardBean result1 = new CardBean();
		CardTagBean result2 = null;
		List<CardDescriptionBean> result3 = new ArrayList<CardDescriptionBean>();
		List<CardTagBean> result4 = new ArrayList<CardTagBean>();
		List<CardDescriptionBean> result5 = null;
		List<CardTagBean> result6 = null;
		if (cardIUBean != null) {
			System.out.println(" ID = " + cardIUBean.getCard().getId());
			String id = cardIUBean.getCard().getId();
			cardIUBean.getCard().setViewCount(card.selectById(id).getViewCount());
			cardIUBean.getCard().setSalesCount(card.selectById(id).getSalesCount());
			if(cardIUBean.getCard().getCover()==null) {
				cardIUBean.getCard().setCover(card.selectById(id).getCover());
			}
			result1 = card.update(cardIUBean.getCard());
			for (int i = 0; i < cardIUBean.getTagIds().length; i++) {
				result2 = new CardTagBean();
				result2.setCardId(cardIUBean.getCard().getId());
				result2.setTagId(Integer.parseInt(cardIUBean.getTagIds()[i]));
				System.out.println(result2.getTagId());
				result4.add(result2);
			}
			// System.out.println("55555555555555555555555:");
			cardTag.deleteBycardId(cardIUBean.getCard().getId());
			result6 = cardTag.insert(result4);
			result5 = cardDesc.insert(cardIUBean.getDescriptions());
			System.out.println(result1);
			System.out.println(result5);
			System.out.println(result6);
			if (result1 != null && result5 != null && result6 != null) {
				return true;
			}
		}
		return false;
	}
	
	//---------------------------------------------------------------------------------------------------------
	// advertisement

		public AdvertisementBean insert(AdvertisementBean advertisementBean) {

			return advertisement.insert(advertisementBean);
		}

		public List<AdvertisementBean> select(AdvertisementBean advertisementBean) {

			return advertisement.select(advertisementBean.getId(), advertisementBean.getName(),
					advertisementBean.getBeginDate(), advertisementBean.getEndDate());

		}

		public AdvertisementBean update(AdvertisementBean advertisementBean) {

			return advertisement.update(advertisementBean);

		}
		// ------------------------------------------------------------------------------
		// Writer
		public WriterBean insert(WriterBean writerBean) {

			return writer.insert(writerBean);
		}

		public List<WriterBean> select(WriterBean writerBean) {

			return writer.selectByIdOrName(writerBean.getId(), writerBean.getName());

		}

		public WriterBean update(WriterBean writerBean) {

			return writer.update(writerBean);

		}
		// -------------------------------------------------------------------------------------
		// Font
		public boolean insert(FontIUBean fontIUBean) {

			FontBean fIResult = null;
			FontDescriptionBean fDResult = null;
			if (fontIUBean != null) {
				String fontId = font.getNewId();
				FontBean bean = fontIUBean.getFont().get(0);
				bean.setId(fontId);
				FontBean fontBean = font.selectById(bean.getId());
				if (fontBean == null) {
					fIResult = font.insert(bean);
					if (fIResult == null) {
						System.out.println("insert " + bean.getId() + " Fail!!!");
						return false;
					}
					FontTagBean fontTagBean = null;
					for (int i = 0; i < fontIUBean.getTagIds().length; i++) {
						fontTagBean = new FontTagBean();
						fontTagBean.setFontId(bean.getId());
						fontTagBean.setTagId(Integer.parseInt(fontIUBean.getTagIds()[i]));
						FontTagBean fTResult = fontTag.insert(fontTagBean);
						if (fTResult == null) {
							System.out.println("insert " + fontIUBean.getTagIds()[i] + " Fail!!!");
							return false;
						}
					}
					FontDescriptionBean fontDescriptionBean = null;
					for (int i = 0; i < fontIUBean.getDescriptions().size(); i++) {
						fontDescriptionBean = fontIUBean.getDescriptions().get(i);
						fontDescriptionBean.setFontId(fontId);
						fDResult = fontDesc.insert(fontDescriptionBean);
						if (fDResult == null) {
							System.out.println("insert " + fontIUBean.getDescriptions().get(i).getFontId() + ", "
									+ fontIUBean.getDescriptions().get(i).getOrderNo() + " Fail!!!");
							return false;
						}
					}
					return true;
				} else {
					System.out.println("already exist " + fontBean.getId() + "!!!");
					return false;
				}

			}
			System.out.println("NO Data!!!");
			return false;
		}

		public List<FontBean> select(PriceRangeFontBean priceRangeBean) {
			List<FontBean> list = null;
			list = font.select(priceRangeBean.getId(), priceRangeBean.getName(), priceRangeBean.getLowPrice(),
					priceRangeBean.getHighPrice(), priceRangeBean.getWriterId(), priceRangeBean.getStatus(), "id", "desc");
			return list;
		}

		public boolean update(FontIUBean fontIUBean) {
			boolean result = false;
			if (fontIUBean != null) {
				FontBean fontBean = fontIUBean.getFont().get(0);
				String id = fontBean.getId();
				fontBean.setViewCount(font.selectById(id).getViewCount());
				fontBean.setSalesCount(font.selectById(id).getSalesCount());
				if(fontBean.getCover()==null) {
					fontBean.setCover(card.selectById(id).getCover());
				}
				FontBean FResult = font.update(fontBean);
				if (FResult != null) {
					List<FontTagBean> fontTagBeans = fontTag.selectByFontId(FResult.getId());
					if (!fontTagBeans.isEmpty()) {
						for (FontTagBean bean : fontTagBeans) {
							boolean dResult = fontTag.delete(bean.getFontId(), bean.getTagId());
							System.out.println(dResult);
							if (!dResult) {
								System.out.println("delete fail");
								return result;
							}
						}
					}

					// System.out.println("---------------");
					// fontTagBeans = fontTag.selectByFontId(FResult.getId());
					// for (FontTagBean bean : fontTagBeans) {
					// System.out.println(bean.getFontId());
					// System.out.println(bean.getTagId());
					// }
					// System.out.println("---------------");

					List<FontTagBean> list = new ArrayList<FontTagBean>();
					for (String s : fontIUBean.getTagIds()) {
						System.out.println("+++=++++++");
						System.out.println(s);
						FontTagBean fontTagBean = new FontTagBean();
						fontTagBean.setFontId(FResult.getId());
						fontTagBean.setTagId(Integer.parseInt(s));
						list.add(fontTagBean);
					}
					boolean bResult = fontTag.insert(list);

					System.out.println(bResult);
					System.out.println("======================");

					boolean DescDeleteResult = fontDesc.delete(FResult.getId());
					if (!DescDeleteResult) {
						System.out.println("desc delete fail!!!");
						return result;
					}
					List<FontDescriptionBean> fontDescriptionBeans = fontIUBean.getDescriptions();
					for (FontDescriptionBean fontDescriptionBean : fontDescriptionBeans) {
						fontDesc.insert(fontDescriptionBean);
					}
					result = true;
				}
			}
			return result;

		}

		public FontBean insert(FontBean fontBean) {

			FontBean result = null;

			result = new FontBean();
			if (fontBean != null) {
				FontBean bean = font.insert(fontBean);
				System.out.println(bean.getName());
				result = font.selectByNAndW(bean);

			}
			return result;
		}

		public FontBean update(FontBean fontBean) {

			FontBean result = null;

			result = new FontBean();
			if (fontBean != null) {
				result = font.update(fontBean);
			}
			return result;
		}

		public boolean delete(FontBean fontBean) {
			boolean result = false;
			String path = font.selectById(fontBean.getId()).getCover();
			File file = new File(path);
			boolean status = font.deleteById(fontBean.getId());
			if (status && file.exists()) {
				file.delete();
				result = true;
			}
			return result;
		}

		public List<FontBean> select(FontBean bean) {
			List<FontBean> result = null;

			if (bean != null && bean.getId() != null) {
				FontBean temp = font.selectById(bean.getId());
				if (temp != null) {
					result = new ArrayList<FontBean>();
					result.add(temp);
				}
			} else {
				result = font.selectAll();
			}
			return result;
		}

		public String[] selectTagById(PriceRangeFontBean priceRangeBean) {

			List<FontTagBean> fontTagBeans = fontTag.selectByFontId(priceRangeBean.getId());
			String[] tagArray = new String[fontTagBeans.size()];
			for (FontTagBean bean : fontTagBeans) {
				tagArray[fontTagBeans.indexOf(bean)] = String.valueOf(bean.getTagId());
			}
			return tagArray;
		}

		public List<FontDescriptionBean> selectDescById(PriceRangeFontBean priceRangeBean) {

			List<FontDescriptionBean> fontDescriptionBeans = fontDesc.selectById(priceRangeBean.getId());
			return fontDescriptionBeans;
		}

		
		/*--------------------------------------------------------------------------------------------------------*/	
		
		//Gift	
			//新增 - insert(0815-test OK)
			public boolean insert(GiftIUBean giftIUBean) {
				
				String id = gift.getNewId();
				if(giftIUBean != null) {
					giftIUBean.getGift().setId(id);
					System.out.println("0=========================0");
					System.out.println("Id: " + giftIUBean.getGift().getId());
					System.out.println("0=========================0");
					
					GiftBean result1 = gift.insert(giftIUBean.getGift());
					System.out.println("1=========================1");
					System.out.println(result1);
					System.out.println("1=========================1");
					
					List<GiftTagBean>  result2 = new ArrayList<GiftTagBean>();
					
					for(int i = 0; i < giftIUBean.getTagIds().length; i++) {
						GiftTagBean result3 = new GiftTagBean();
						result3.setGiftId(giftIUBean.getGift().getId());
						result3.setTagId(Integer.parseInt(giftIUBean.getTagIds()[i]));
						System.out.println("2=========================2");
						System.out.println(result3.getTagId());
						System.out.println("2=========================1");
						
						result2.add(result3);
					}
					System.out.println("3=========================3");
					System.out.println(result2);
					System.out.println("3=========================3");
					
					List<GiftDescriptionBean> result4 = giftIUBean.getDescriptions();
					for(GiftDescriptionBean bean : result4) {
						bean.setGiftId(id);
					}
					System.out.println("4=========================4");
					System.out.println(result4);
					System.out.println("4=========================4");
					
					
					List<GiftTagBean>  result5 =giftTag.insert(result2);
					System.out.println("5=========================5");
					System.out.println(result5);
					System.out.println("5=========================5");
					
					List<GiftDescriptionBean>  result6 =giftDesc.insert(giftIUBean.getDescriptions());
					if(result1 != null && result5 != null && result6 != null ) {
						return true;
					}
				}
				return false ;
			}
			

			//更新 - update(0815-test OK)
			public boolean update(GiftIUBean giftIUBean) {
			
			if (giftIUBean != null) {
				System.out.println(" ID = " + giftIUBean.getGift().getId());
				String id = giftIUBean.getGift().getId();
				giftIUBean.getGift().setViewCount(gift.selectById(id).getViewCount());
				giftIUBean.getGift().setSalesCount(gift.selectById(id).getSalesCount());
				if(giftIUBean.getGift().getCover()==null) {
					giftIUBean.getGift().setCover(gift.selectById(id).getCover());
				}
				GiftBean result1 = gift.update(giftIUBean.getGift());
				
				List<GiftTagBean> result3 = new ArrayList<GiftTagBean>();
				
				for (int i = 0; i < giftIUBean.getTagIds().length; i++) {
					GiftTagBean result2 = new GiftTagBean();
					
					result2.setGiftId(giftIUBean.getGift().getId());
					result2.setTagId(Integer.parseInt(giftIUBean.getTagIds()[i]));
					System.out.println(result2.getTagId());
					result3.add(result2);
				}
				
				giftTag.deleteById(giftIUBean.getGift().getId());
				List<GiftTagBean> result5 = giftTag.insert(result3);
				giftDesc.delete(giftIUBean.getGift().getId());
				List<GiftDescriptionBean> result6 = giftDesc.insert(giftIUBean.getDescriptions());
				System.out.println(result1);
				System.out.println(result6);
				System.out.println(result5);
				if (result1 != null && result5 != null && result6 != null) {
					return true;
				}
			}
			return false;
		}
			
			
//			//複合式查詢 - select(0815-test OK)
			public GiftSelectAllBean selectGift(GiftSelectBean giftSelectBean) {
				
				System.out.println("進入Select Service");
				GiftSelectAllBean bean = new GiftSelectAllBean();
				List<GiftBean> list = new ArrayList<GiftBean>();
				if(giftSelectBean.getId()!=null && giftSelectBean.getId().length() != 0) {
					
					System.out.println("進入Select Service-1");
					list = gift.selectAllFM(giftSelectBean);
					System.out.println(list.toString());
					
					bean.setGift(list);
					if(!list.isEmpty()) {
						
					System.out.println("進入Select Service-2");
					List<GiftTagBean> tagBeans = giftTag.selectById(giftSelectBean.getId());
					System.out.println(tagBeans.get(0));
					 
					String[] tagIds = new String[tagBeans.size()];
					for(GiftTagBean bean1 : tagBeans) {
						tagIds[tagBeans.indexOf(bean1)] = bean1.toString();
					}
					bean.setTagIds(tagIds);
					bean.setDescriptions(giftDesc.selectById(giftSelectBean.getId()));
					}
				}else {
					
					System.out.println("進入SelectAll Service-1");
					bean.setGift(gift.selectAllFM(giftSelectBean));
				}
				return bean;
			}	

			/*--------------------------------------------------------------------------------------------------*/	
			
			
			//Pack	
			//複合式查詢 - select(0815-Test-OK)
			public List<PackBean> selectPack(PackSelectBean packSelectBean) {
				List<PackBean> beans = null;
					beans = pack.selectAllFM(packSelectBean);
					for(PackBean bean : beans) {
						System.out.println(bean.getName());
					}	
				return beans;
			}		
	

}