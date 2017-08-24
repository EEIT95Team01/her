package com.eeit95.her.model.orderform;

import java.util.List;

import com.eeit95.her.model.pack.PackGiftBean;

public class MsgOrderformSelectBean {
	private String message;
	private String success;
	private List<OrderformBean> data;
	
	
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
	public List<OrderformBean> getData() {
		return data;
	}
	public void setData(List<OrderformBean> data) {
		this.data = data;
	}
	
	
}
