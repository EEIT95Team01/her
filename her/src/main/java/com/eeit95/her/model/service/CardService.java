package com.eeit95.her.model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eeit95.her.model.card.CardBean;
import com.eeit95.her.model.card.CardDAOInterface;
import com.eeit95.her.model.card.CardDescriptionBean;
import com.eeit95.her.model.card.CardDescriptionDAOInterface;
import com.eeit95.her.model.card.CardSBean;
import com.eeit95.her.model.card.CardSelectBean;
import com.eeit95.her.model.card.CardTagBean;
import com.eeit95.her.model.card.CardTagInterface;
import com.eeit95.her.model.font.FontDescriptionBean;
import com.eeit95.her.model.font.FontDescriptionDAOInterface;
import com.eeit95.her.model.font.FontSBean;
import com.eeit95.her.model.font.FontTagBean;
import com.eeit95.her.model.font.FontTagDAOInterface;
import com.eeit95.her.model.misc.SpringJavaConfiguration;

@Service
public class CardService {
	@Autowired
	private CardDAOInterface cardDAO;
	@Autowired
	private CardTagInterface cardTag;
	@Autowired
	private CardDescriptionDAOInterface cardDesc;

	/* 在  controller 做好資料的檢查，確保傳入的參數無誤 */
	
	// insert 後，回傳新增成功包含 id 的　tagBean
	public CardBean insert(CardBean cardBean) {
		CardBean result=null;
		if(cardBean!=null) {
			result = cardDAO.insert(cardBean);
		}
		return result;
	}
	
	// update 後，回傳修改成功的　tagBean
	public CardBean update(CardBean cardBean) {
		CardBean result=null;
		if(cardBean!=null) {
			result = cardDAO.update(cardBean);
		}
		return result;
	}
	
	// delete 後，回傳是否刪除成功的 boolean
	public boolean delete(CardBean cardBean) {
		boolean result = false;
		if(cardBean!=null) {
			result = cardDAO.delete(cardBean.getId());
		}
		return result;
	}
	
	// selectAll
//	@RequestMapping(method = RequestMethod.GET,produces = {"application/json;charset=utf8"})
//	@ResponseBody
//		public List<CardBean> selectAll(CardBean cardBean) {
//			List<CardBean> result = null;
//			if(cardBean.getId().trim().length()!=0 && cardBean.getId()!=null) {
//				CardBean temp = cardDAO.selectById(cardBean.getId());
//				if(temp!=null) {
//					System.out.println(temp);
//					result = new ArrayList<CardBean>();
//					result.add(temp);
//				}else {
//				result = cardDAO.selectAll();
//				}
//			}else {
//				result = cardDAO.selectAll();
//
//			}
//			
//			return result;
//		}
	
	

	// selectAllFM
	public List<CardBean> selectAllFM(CardSelectBean cardSelectBean) {
		List<CardBean> result = null;
		if(cardSelectBean !=null) {
			result = cardDAO.selectAllFM(cardSelectBean);
		}
		
		return result;
	}
	public List<CardBean> selectOrderBy(String option) {

//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
			List<CardBean> result = null;
			switch (option) {
			case "ID_ASC":
				result = cardDAO.selectAllStatus(true);
				break;
			case "SALES_DESC":
				result = cardDAO.selectAllOrderBySales();
				break;
			case "PRICE_ASC":
				result = cardDAO.selectAllOrderByPrice("asc");
				break;
			case "PRICE_DESC":
				result = cardDAO.selectAllOrderByPrice("desc");
				break;
			}

//			sessionFactory.getCurrentSession().getTransaction().commit();
			return result;
//		} catch (RuntimeException ex) {
//			sessionFactory.getCurrentSession().getTransaction().rollback();
//			throw ex;
//		}
	}
	
	
	public String[] selectTagById(CardSBean cardSBean) {

		List<CardTagBean> cardTagBeans = cardTag.selectBycardId(cardSBean.getId());
		String[] tagArray = new String[cardTagBeans.size()];
		for (CardTagBean bean : cardTagBeans) {
			tagArray[cardTagBeans.indexOf(bean)] = String.valueOf(bean.getTagId());
		}
		return tagArray;
	}
	
	public List<CardDescriptionBean> selectDescById(CardSBean cardSBean) {

		List<CardDescriptionBean> cardDescriptionBeans = cardDesc.selectById(cardSBean.getId());
		return cardDescriptionBeans;
	}
	
	
//	public static void main(String[] args) {
//		//
//				ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
//				SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//		
//				CardService cdj = (CardService) context.getBean("cardService");
//				CardBean bean = null;
//				List<CardBean> list = null;
//				try {
//					sessionFactory.getCurrentSession().beginTransaction();
//					list = cdj.selectAll(bean);
//					
//					sessionFactory.getCurrentSession().getTransaction().commit();
//				} catch (RuntimeException ex) {
//					sessionFactory.getCurrentSession().getTransaction().rollback();
//				}
//		//
////				for (CardBean o : list) {
////					System.out.println(o.getId());
////				}
////				System.out.println("id:" + bean.getId() + "   name:" + bean.getName());
////				bean.setId("c01707280009");
//
////				System.out.println("INSERT 一筆資料 & PRINT");
//		//
////				CardBean bean1 = null;
////				try {
////					sessionFactory.getCurrentSession().beginTransaction();
////					bean1 = cdj.insert(bean);
////					sessionFactory.getCurrentSession().getTransaction().commit();
////					System.out.println("11111");
////				} catch (RuntimeException ex) {
////					sessionFactory.getCurrentSession().getTransaction().rollback();
////				}
////				System.out.println("update");
////				bean.setName("我是測試2~~~~");
////				try {
////					sessionFactory.getCurrentSession().beginTransaction();
////					cdj.update(bean);
////					sessionFactory.getCurrentSession().getTransaction().commit();
////				} catch (RuntimeException ex) {
////					sessionFactory.getCurrentSession().getTransaction().rollback();
////				}
//
//				// System.out.println(bean1);
//				//
//				// CardBean bean2 = null;
//				// try {
//				// sessionFactory.getCurrentSession().beginTransaction();
//				// bean2 = cdj.selectById("c01707280009");
//				// sessionFactory.getCurrentSession().getTransaction();
//				// }catch (RuntimeException ex) {
//				// sessionFactory.getCurrentSession().getTransaction().rollback();
//				// }
//				//
//				//
//				// System.out.println("id:"+bean2.getId()+" name:"+bean2.getName());
//
//				// SELECT 一筆資料 & PRINT
//				// Query query = session.createQuery(selectAll);
//				// List<CardBean> list = query.list();
//				// for(CardBean o :list) {
//				// System.out.println(o.getId());
//				// }
//
//				// System.out.println("==================");
//				// CardBean bean = cdj.selectById("c01706010001");
//
//				// System.out.println("===================================================");
//				//
//				// // INSERT 一筆資料 & PRINT
//				// bean.setId("c01707280005");
//				// bean = cdj.insert(bean);
//				// System.out.println("INSERT 一筆資料 & PRINT");
//				// System.out.println(bean);
//
//				// System.out.println("===================================================");
//				//
//				// // UPDATE 一筆資料 & PRINT
//				// bean.setName("史奴比");
//				// System.out.println("snoopy");
//				// cdj.update(bean);
//				// System.out.println("UPDATE 一筆資料 & PRINT");
//				// System.out.println(bean);
//				//
//				// System.out.println("===================================================");
//
//				 // DELETE 一筆資料 & PRINT
////				 System.out.println("DELETE 一筆資料 & PRINT");
////				 try {
////						sessionFactory.getCurrentSession().beginTransaction();
////						cdj.delete("c0170728009");
////						sessionFactory.getCurrentSession().getTransaction().commit();
////					} catch (RuntimeException ex) {
////						sessionFactory.getCurrentSession().getTransaction().rollback();
////					}
////				 cdj.delete("c01707280001");
//				//
//				// System.out.println("===================================================");
//
//				// // SELECT TopN & PRINT
//				// List<CardBean> result = cdj.selectTopN(5, "viewCount", "asc");
//				// System.out.println("SELECT 所有資料 & PRINT");
//				// for (CardBean bean1 : result) {
//				// System.out.println(bean1);
//				// }
//
//				// System.out.println("===================================================");
//				//
//				// // // SELECT 所有資料 & PRINT
//				
////				System.out.println("selectWithBetween");
////				try {
////					sessionFactory.getCurrentSession().beginTransaction();
////					list = cdj.selectWithBetween("price", 45.0, 55.0, "asc");
////					sessionFactory.getCurrentSession().getTransaction().commit();
////				} catch (RuntimeException ex) {
////					sessionFactory.getCurrentSession().getTransaction().rollback();
////				}
////				 
////				 System.out.println("SELECT Between & PRINT");
////				 for (CardBean bean1 : list) {
////				 System.out.println(bean1);
////				  Set<CardDescriptionBean> desc =bean1.getDesc();
////				  for(CardDescriptionBean BEAN2:desc) {
////				  System.out.println(BEAN2.getOrderNo());
////				  }
////				 }
//				// //
//				// // List<CardBean> beans1 = cdj.selectAll();
//				// // System.out.println("SELECT 所有資料 & PRINT");
//				// // for (CardBean bean1 : beans1) {
//				// // System.out.println(bean1);
//				// //// Set<CardDescriptionBean> desc =bean1.getDesc();
//				// //// for(CardDescriptionBean BEAN2:desc) {
//				// //// System.out.println(BEAN2);
//				// //// }
//				// // }
//				//
////				List<CardBean> beansC =null;
////				List<CardBean> beansM =null;
////				CardSelectBean cardSelectBean=new CardSelectBean();
////				cardSelectBean.setHiStock(50);
////				try {
////					sessionFactory.getCurrentSession().beginTransaction();
////					beansC = cdj.selectAllFC(null, 0, 180, 45, 55, "desc", "viewCount");
////					beansM = cdj.selectAllFM(cardSelectBean);
////					sessionFactory.getCurrentSession().getTransaction().commit();
////				} catch (RuntimeException ex) {
////					sessionFactory.getCurrentSession().getTransaction().rollback();
////				}
////				
////				System.out.println("SELECT selectAllFC");
////				System.out.println(beansC.size());
////				for (CardBean bean1 : beansC) {
////					System.out.println(bean1);
////					 Set<CardDescriptionBean> desc =bean1.getDesc();
////					 for(CardDescriptionBean BEAN2:desc) {
////					 System.out.println(BEAN2);
////					 }
////				}
////				
////				System.out.println("SELECT selectAllFM");
////				System.out.println(beansM.size());
////				for (CardBean bean1 : beansM) {
////					System.out.println(bean1);
////					Set<CardDescriptionBean> desc = bean1.getDesc();
////					for (CardDescriptionBean BEAN2 : desc) {
////						System.out.println(BEAN2);
////					}
////				}
//		//
//		}

}
