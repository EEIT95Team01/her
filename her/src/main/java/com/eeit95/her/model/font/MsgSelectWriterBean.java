package com.eeit95.her.model.font;

import java.util.List;

public class MsgSelectWriterBean {

	private String message;
	private String success;
	private List<WriterBean> data;
	
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
	public List<WriterBean> getData() {
		return data;
	}
	public void setData(List<WriterBean> data) {
		this.data = data;
	}
	
}
