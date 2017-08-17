package com.eeit95.her.model.gift;

import java.util.*;

public class MsgSelectGiftBean  {
	
	private String message;
	private String success;
	private List<GiftBean> giftBean;
	private String[] tagIds;
	private List<GiftDescriptionBean> descriptions;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getSuccess() {
		return success;
	}
	
	public void setSuccess(String success) {
		this.success = success;
	}
	
	public List<GiftBean> getGiftBean() {
		return giftBean;
	}
	
	public void setGiftBean(List<GiftBean> giftBean) {
		this.giftBean = giftBean;
	}


}