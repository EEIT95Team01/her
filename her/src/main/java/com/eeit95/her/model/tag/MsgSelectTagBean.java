package com.eeit95.her.model.tag;

import java.util.*;

public class MsgSelectTagBean  {
	
	private String message;
	private String success;
	private List<TagBean> data;
	
	
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
	public List<TagBean> getData() {
		return data;
	}
	public void setData(List<TagBean> data) {
		this.data = data;
	}
	

}