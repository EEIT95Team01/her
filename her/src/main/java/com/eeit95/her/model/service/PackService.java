package com.eeit95.her.model.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eeit95.her.model.gift.GiftBean;
import com.eeit95.her.model.gift.GiftQuantityBean;
import com.eeit95.her.model.orderform.OrderformBean;
import com.eeit95.her.model.orderform.OrderformDAOInterface;
import com.eeit95.her.model.orderform.OrderformPackBean;
import com.eeit95.her.model.orderform.OrderformPackDAOInterface;
import com.eeit95.her.model.pack.PackBean;
import com.eeit95.her.model.pack.PackDAOInterface;
import com.eeit95.her.model.pack.PackGiftBean;
import com.eeit95.her.model.pack.PackGiftDAOInterface;
import com.eeit95.her.model.pack.PackInsertBean;

@Service
public class PackService {

	@Autowired
	private PackDAOInterface pack;
	@Autowired
	private PackGiftDAOInterface packGift;
	
	 //select(0821)

	 public List<PackBean> selectByMIdnStatusnPId (PackBean bean) {
	   if(bean.getMemberId() != null && bean.getStatus() != 0) {
	    List<PackBean> results = 
	      pack.selectByMIdAndStatus(bean.getMemberId(),bean.getStatus());
	    return results;
	   }
	   return null;
	 }
	 
	//selectByPid(0822)

	 public PackBean selectById (PackBean bean) {
	   if(bean.getId() != null) {
	    PackBean result = 
	      pack.selectById(bean.getId());
	    return result;
	   }
	   return null;
	 }
	 
	 
	//insert(0816)
	public PackBean insert(PackInsertBean pibean) {
		String id = pack.getNewId();
		PackBean bean = new PackBean();
		if(pibean.getCard().getId() != null || pibean.getGiftSum() != 0) {
			if(pibean.getFont().getId() != null && pibean.getCard().getId() == null) {
				System.out.println("他媽的請給我買一張卡片!!");
			}else {
				bean.setId(id);
				bean.setMemberId(pibean.getMemberId());
				bean.setName("包裹"+id.substring(4,8)+id.substring(10));
				bean.setCardId(pibean.getCard().getId());
				bean.setCardPrice(pibean.getCard().getPrice());
				bean.setFontId(pibean.getFont().getId());
				bean.setFontPrice(pibean.getFont().getPrice());
				bean.setGiftSum(pibean.getGiftSum());
				bean.setSum(pibean.getSum());
				bean.setStatus(2);
				PackBean result = pack.insert(bean);
				if(result == null) {
					System.out.println("新增失敗");
				}else {
					for(GiftQuantityBean gqBean : pibean.getGift()) {
						PackGiftBean pgBean = new PackGiftBean();
						pgBean.setPackId(result.getId());
						pgBean.setGiftId(gqBean.getGiftId());
						pgBean.setGiftQuantity(gqBean.getGiftQuantity());
						PackGiftBean result2 = packGift.insert(pgBean);
						if(result2 == null) {
							System.out.println("PackGift fail");
							return null;
						}
					}
				}
				return result;
			}
		}
		return null;
	}
	
	
	//update(0816)
	public PackBean update(PackBean bean) {
		if(bean.getCardId() != null || bean.getGiftSum() != 0) {
			PackBean result = pack.update(bean);
			if(result == null) {
				System.out.println("修改失敗");
			}
			return result;
		}else {
			System.out.println("此包裹沒有任何商品組合，是否刪除？");
			return null;
		}
	}
	
	
	//delete(0816)
	public boolean delete(String id) {
		boolean result = pack.deleteById(id);
		if(result) {
			return true;
		}else {
			return false;	
		}
	}

	/*---------------------------------------------------------------------*/
	//selectPackGift 0823
	public List<PackGiftBean> selectByPackId(PackBean packBean){
		List<PackGiftBean> result = null;
		if(packBean.getId()!=null) {
			result = packGift.selectByPackId(packBean.getId());
		}
		
		
		return result;
	}
	
	
	
/*---------------------------------------------------------------------*/	
	
	@Autowired
	private OrderformDAOInterface order;
	@Autowired
	private OrderformPackDAOInterface orderformPack;
	
	
	
	//orderform
	//insert (0817 - POST TEST-OK)
	public OrderformBean insert(OrderformBean bean) {
		List<PackBean> result1 = pack.selectByMIdAndStatus(bean.getMemberId(), 2);
		if(!result1.isEmpty()) {//判斷pack的會員ID及包裹狀態是在郵寄箱(代號:2)內
			String id = order.getNewId();
			bean.setId(id);
			long date = System.currentTimeMillis();
			java.sql.Timestamp x = new Timestamp(date);
			bean.setDateCreated(x.toString());
			OrderformBean result2 = order.insert(bean);
			if(result2 != null) {
				for(PackBean pBean : result1) {
				OrderformPackBean opBean = new OrderformPackBean();
				opBean.setOrderformId(id);
				opBean.setPackId(pBean.getId());
				opBean.setStatus(1);
				orderformPack.insert(opBean);
				pBean.setStatus(3); //按下寄出包裹後，包裹的狀態即更改為訂單狀態(代號:3)
				}				
				return result2;
			}else {
				System.out.println("寄出包裹新增失敗");
			}
		}else {
			System.out.println("請將包裹放到郵寄箱!");
		}
		return null;
	}
	

	
}