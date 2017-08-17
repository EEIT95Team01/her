package com.eeit95.her.model.advertisement;

import java.util.List;

public class MsgSelectAdvertisementBean {
	private String message;
	private String success;
	private List<AdvertisementBean> data;
	
	
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
	public List<AdvertisementBean> getData() {
		return data;
	}
	public void setData(List<AdvertisementBean> data) {
		this.data = data;
	}
	
	
	
}
