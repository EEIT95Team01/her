package com.eeit95.her.model.gift;



public class MsgSelectGiftBean  {
	
	private String message;
	private String success;
	private GiftSelectAllBean data;
	
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
	public GiftSelectAllBean getData() {
		return data;
	}
	public void setData(GiftSelectAllBean data) {
		this.data = data;
	}

}