package com.eeit95.her.model.pack;

import java.util.List;

public class MsgSelectPackBean  {
	
	private String message;
	private String success;
	private List<PackBean> data;
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
	public List<PackBean> getData() {
		return data;
	}
	public void setData(List<PackBean> data) {
		this.data = data;
	}
	


}